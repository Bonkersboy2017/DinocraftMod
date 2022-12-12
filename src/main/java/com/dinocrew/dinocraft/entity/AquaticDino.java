package com.dinocrew.dinocraft.entity;

import com.dinocrew.dinocraft.entity.ai.AquaticDinoAi;
import com.dinocrew.dinocraft.registry.RegisterItems;
import com.dinocrew.dinocraft.registry.RegisterSounds;
import com.mojang.serialization.Dynamic;
import net.frozenblock.lib.entity.api.NoFlopAbstractFish;
import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.game.DebugPackets;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
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
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

public class AquaticDino extends NoFlopAbstractFish implements AlternateDino {
    public AquaticDino(EntityType<? extends AquaticDino> entityType, Level level) {
        super(entityType, level);
        this.moveControl = new SmootherSwimmingMoveControl(this, 0.05F, 50.0F, 1F, 0.05F, false);
        this.lookControl = new SmoothSwimmingLookControl(this, 10);
        this.xpReward = 5;
        this.getNavigation().setCanFloat(false);
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
        return BaseDino.createDinoAttributes().add(Attributes.MOVEMENT_SPEED, 3.0).add(Attributes.ATTACK_KNOCKBACK, 1.2);
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
                && !(livingEntity instanceof AquaticDino)
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
    public void customServerAiStep() {
        ServerLevel serverLevel = (ServerLevel) this.level;
        serverLevel.getProfiler().push("aquaticDinoBrain");
        ((Brain<AquaticDino>) this.getBrain()).tick(serverLevel, this);
        this.level.getProfiler().pop();
        super.customServerAiStep();

        AquaticDinoAi.updateActivity(this);
    }

    @Override
    protected Brain<?> makeBrain(Dynamic<?> dynamic) {
        return AquaticDinoAi.makeBrain(this, dynamic);
    }

    @Override
    public Brain<? extends AquaticDino> getBrain() {
        return (Brain<AquaticDino>) super.getBrain();
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

    public void setAttackTarget(LivingEntity target) {
        this.getBrain().setMemory(MemoryModuleType.ATTACK_TARGET, target);
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
        if (itemStack.sameItem(RegisterItems.CYAD_SEEDS.getDefaultInstance())) {
            if (!player.getAbilities().instabuild) {
                itemStack.shrink(1);
            }
            this.navigation.stop();
            this.setTarget(null);
            this.level.broadcastEntityEvent(this, (byte) 7);

            return InteractionResult.SUCCESS;
        }
        return super.mobInteract(player, hand);
    }

    @Override
    protected SoundEvent getFlopSound() {
        return this.getSwimSound();
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return RegisterSounds.DINO_AMBIENT;
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
        return RegisterSounds.DINO_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return RegisterSounds.DINO_DEATH;
    }

    @Override
    public ItemStack getBucketItemStack() {
        return null;
    }

    private static class SmootherSwimmingMoveControl extends MoveControl {
        private final float maxTurnX;
        private final float maxTurnY;
        private final float inWaterSpeedModifier;
        private final float outsideWaterSpeedModifier;
        private final boolean applyGravity;

        public SmootherSwimmingMoveControl(Mob mob, float maxTurnX, float maxTurnY, float inWaterSpeedModifier, float outsideWaterSpeedModifier, boolean applyGravity) {
            super(mob);
            this.maxTurnX = maxTurnX;
            this.maxTurnY = maxTurnY;
            this.inWaterSpeedModifier = inWaterSpeedModifier;
            this.outsideWaterSpeedModifier = outsideWaterSpeedModifier;
            this.applyGravity = applyGravity;
        }

        @Override
        public void tick() {
            if (this.applyGravity && this.mob.isInWater()) {
                this.mob.setDeltaMovement(this.mob.getDeltaMovement().add(0.0, 0.005, 0.0));
            }

            if (this.operation == MoveControl.Operation.MOVE_TO && !this.mob.getNavigation().isDone()) {
                double d = this.wantedX - this.mob.getX();
                double e = this.wantedY - this.mob.getY();
                double f = this.wantedZ - this.mob.getZ();
                double g = d * d + e * e + f * f;
                if (g < 2.5000003E-7F) {
                    this.mob.setZza(0.0F);
                } else {
                    float h = (float)(Mth.atan2(f, d) * 180.0F / (float)Math.PI) - 90.0F;
                    this.mob.setYRot(this.rotlerp(this.mob.getYRot(), h, (float)this.maxTurnY));
                    this.mob.yBodyRot = this.mob.getYRot();
                    this.mob.yHeadRot = this.mob.getYRot();
                    float i = (float)(this.speedModifier * this.mob.getAttributeValue(Attributes.MOVEMENT_SPEED));
                    if (this.mob.isInWater()) {
                        this.mob.setSpeed(i * this.inWaterSpeedModifier);
                        double j = Math.sqrt(d * d + f * f);
                        if (Math.abs(e) > 1.0E-5F || Math.abs(j) > 1.0E-5F) {
                            float k = -((float)(Mth.atan2(e, j) * 180.0F / (float)Math.PI));
                            k = Mth.clamp(Mth.wrapDegrees(k), (float)(-this.maxTurnX), (float)this.maxTurnX);
                            this.mob.setXRot(this.rotlerp(this.mob.getXRot(), k, 5.0F));
                        }

                        float k = Mth.cos(this.mob.getXRot() * (float) (Math.PI / 180.0));
                        float l = Mth.sin(this.mob.getXRot() * (float) (Math.PI / 180.0));
                        this.mob.zza = k * i;
                        this.mob.yya = -l * i;
                    } else {
                        this.mob.setSpeed(i * this.outsideWaterSpeedModifier);
                    }

                }
            } else {
                this.mob.setSpeed(0.0F);
                this.mob.setXxa(0.0F);
                this.mob.setYya(0.0F);
                this.mob.setZza(0.0F);
            }
        }
    }

}
