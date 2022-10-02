package com.dinocrew.dinocraft.entity;

import com.dinocrew.dinocraft.entity.ai.BaseDinoAi;
import com.dinocrew.dinocraft.registry.RegisterItems;
import com.dinocrew.dinocraft.registry.RegisterSounds;
import com.mojang.serialization.Dynamic;
import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.game.DebugPackets;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Unit;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.IndirectEntityDamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.behavior.StartAttacking;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

public class BaseDino extends TamableAnimal {
    public BaseDino(EntityType<? extends BaseDino> entityType, Level level) {
        super(entityType, level);
        this.xpReward = 5;
        this.getNavigation().setCanFloat(true);
        this.setPathfindingMalus(BlockPathTypes.UNPASSABLE_RAIL, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.DAMAGE_OTHER, 8.0F);
        this.setPathfindingMalus(BlockPathTypes.POWDER_SNOW, 8.0F);
        this.setPathfindingMalus(BlockPathTypes.LAVA, 8.0F);
    }

    /*@Override
    protected void registerGoals() {
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 0.7D));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers(Player.class));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }*/

    public static AttributeSupplier.Builder createDinoAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 16.0)
                .add(Attributes.MOVEMENT_SPEED, 0.2F)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.7)
                .add(Attributes.ATTACK_KNOCKBACK, 1.5)
                .add(Attributes.ATTACK_DAMAGE, 5.0);
    }

    @Override
    public boolean checkSpawnObstruction(LevelReader level) {
        return super.checkSpawnObstruction(level) && level.noCollision(this, this.getType().getDimensions().makeBoundingBox(this.position()));
    }

    @Override
    public float getWalkTargetValue(BlockPos pos, LevelReader level) {
        return 0.0F;
    }

    @Override
    protected boolean canRide(Entity vehicle) {
        return false;
    }

    @Override
    protected float nextStep() {
        return this.moveDist + 0.55F;
    }

    @Contract("null->false")
    public boolean canTargetEntity(@Nullable Entity entity) {
        return entity instanceof LivingEntity livingEntity
                && this.level == entity.level
                && EntitySelector.NO_CREATIVE_OR_SPECTATOR.test(entity)
                && !this.isAlliedTo(entity)
                && livingEntity.getType() != EntityType.ARMOR_STAND
                && !(livingEntity instanceof BaseDino)
                && !livingEntity.isInvulnerable()
                && !livingEntity.isDeadOrDying()
                && this.level.getWorldBorder().isWithinBounds(livingEntity.getBoundingBox());
    }

    @Nullable
    @Override
    public LivingEntity getTarget() {
        return this.getBrain().getMemory(MemoryModuleType.ATTACK_TARGET).orElse(null);
    }

    @Override
    protected void customServerAiStep() {
        ServerLevel serverLevel = (ServerLevel) this.level;
        serverLevel.getProfiler().push("baseDinoBrain");
        ((Brain<BaseDino>) this.getBrain()).tick(serverLevel, this);
        this.level.getProfiler().pop();
        super.customServerAiStep();

        BaseDinoAi.updateActivity(this);
    }

    @Override
    protected Brain<?> makeBrain(Dynamic<?> dynamic) {
        return BaseDinoAi.makeBrain(this, dynamic);
    }

    @Override
    public Brain<? extends BaseDino> getBrain() {
        return (Brain<BaseDino>) super.getBrain();
    }

    @Override
    protected void sendDebugPackets() {
        super.sendDebugPackets();
        DebugPackets.sendEntityBrain(this);
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        boolean bl = super.hurt(source, amount);
        if (!this.level.isClientSide && !this.isNoAi()) {
            Entity entity = source.getEntity();
            if (this.brain.getMemory(MemoryModuleType.ATTACK_TARGET).isEmpty()
                && entity instanceof LivingEntity livingEntity
                && (!(source instanceof IndirectEntityDamageSource) || this.closerThan(livingEntity, 5.0))) {
                this.setAttackTarget(livingEntity);
            }
        }

        return bl;
    }

    public void setAttackTarget(LivingEntity attackTarget) {
        this.getBrain().eraseMemory(MemoryModuleType.ROAR_TARGET);
        StartAttacking.setAttackTarget(this, attackTarget);
    }

    @Override
    protected void doPush(Entity entity) {
        if (!this.isNoAi() && !this.getBrain().hasMemoryValue(MemoryModuleType.TOUCH_COOLDOWN)) {
            this.getBrain().setMemoryWithExpiry(MemoryModuleType.TOUCH_COOLDOWN, Unit.INSTANCE, 20L);
        }
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        if (itemStack.sameItemStackIgnoreDurability(RegisterItems.CYAD_SEEDS.getDefaultInstance())) {
            if (!player.getAbilities().instabuild) {
                itemStack.shrink(1);
            }
            this.tame(player);
            this.navigation.stop();
            this.setTarget(null);
            this.setOrderedToSit(true);
            this.level.broadcastEntityEvent(this, (byte) 7);

            return InteractionResult.SUCCESS;
        }
        return super.mobInteract(player, hand);
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob otherParent) {
        return null;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return RegisterSounds.DINO_IDLE;
    }

    @Override
    public SoundSource getSoundSource() {
        return SoundSource.HOSTILE;
    }

    @Override
    public float getSoundVolume() {
        return 1.8F;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return RegisterSounds.DINO_HIT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return RegisterSounds.DINO_DEATH;
    }
}
