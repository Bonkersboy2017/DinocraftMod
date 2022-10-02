package com.dinocrew.dinocraft.entity;

import com.dinocrew.dinocraft.entity.ai.TyrannosaurusAi;
import com.dinocrew.dinocraft.entity.ai.TyrannosaurusAngerLevel;
import com.dinocrew.dinocraft.entity.ai.TyrannosaurusAngerManagement;
import com.dinocrew.dinocraft.entity.ai.TyrannosaurusVibrationListener;
import com.dinocrew.dinocraft.registry.RegisterSounds;
import com.google.common.annotations.VisibleForTesting;
import com.mojang.logging.LogUtils;
import com.mojang.serialization.Dynamic;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Unit;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.IndirectEntityDamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.DynamicGameEventListener;
import net.minecraft.world.level.gameevent.EntityPositionSource;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.GameEventListener;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

import java.util.Collections;
import java.util.Optional;
import java.util.function.BiConsumer;

public class Tyrannosaurus extends BaseDino implements TyrannosaurusVibrationListener.VibrationListenerConfig {

    private static final Logger LOGGER = LogUtils.getLogger();
    private static final EntityDataAccessor<Integer> CLIENT_ANGER_LEVEL = SynchedEntityData.defineId(Tyrannosaurus.class, EntityDataSerializers.INT);
    public AnimationState roarAnimationState = new AnimationState();
    public AnimationState sniffAnimationState = new AnimationState();
    public AnimationState attackAnimationState = new AnimationState();
    private final DynamicGameEventListener<TyrannosaurusVibrationListener> dynamicGameEventListener;
    private TyrannosaurusAngerManagement angerManagement = new TyrannosaurusAngerManagement(this::canTargetEntity, Collections.emptyList());

    public Tyrannosaurus(EntityType<? extends Tyrannosaurus> entityType, Level world) {
        super(entityType, world);
        this.dynamicGameEventListener = new DynamicGameEventListener<>(
                new TyrannosaurusVibrationListener(new EntityPositionSource(this, this.getEyeHeight()), 16, this, null, 0.0F, 0)
        );
    }

    /*@Override
    protected void registerGoals() {
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 0.7D));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 16.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers(Player.class));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }*/

    public static boolean canSpawn(EntityType<Tyrannosaurus> type, LevelAccessor level, MobSpawnType reason, BlockPos pos, RandomSource random) {
        return true;
    }

    public static AttributeSupplier.Builder createDinoAttributes() {
        return TamableAnimal.createMobAttributes().add(Attributes.MAX_HEALTH, 16.0D).add(Attributes.MOVEMENT_SPEED, 0.30000001192092896D).add(Attributes.ATTACK_DAMAGE);
    }

    @Override
    public boolean doHurtTarget(Entity target) {
        this.level.broadcastEntityEvent(this, (byte) 4);
        this.playSound(SoundEvents.EVOKER_FANGS_ATTACK, 10.0F, this.getVoicePitch());
        return super.doHurtTarget(target);
    }

    @Override
    public boolean dampensVibrations() {
        return true;
    }

    @Override
    public float getSoundVolume() {
        return 3.0F;
    }

    @Nullable
    @Override
    public SoundEvent getAmbientSound() {
        return !this.hasPose(Pose.ROARING) ? this.getAngerLevel().getAmbientSound() : null;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return RegisterSounds.BIGDINO_HIT;
    }

    @Override
    public SoundEvent getDeathSound() {
        return SoundEvents.RAVAGER_DEATH;
    }

    @Override
    public void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.RAVAGER_STEP, 5.0F, 1.0F);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(CLIENT_ANGER_LEVEL, 0);
    }

    public int getClientAngerLevel() {
        return this.entityData.get(CLIENT_ANGER_LEVEL);
    }

    private void syncClientAngerLevel() {
        this.entityData.set(CLIENT_ANGER_LEVEL, this.getActiveAnger());
    }

    public TyrannosaurusAngerLevel getAngerLevel() {
        return TyrannosaurusAngerLevel.byAnger(this.getActiveAnger());
    }

    private int getActiveAnger() {
        return this.angerManagement.getActiveAnger(this.getTarget());
    }

    public void clearAnger(Entity entity) {
        this.angerManagement.clearAnger(entity);
    }

    public void increaseAngerAt(@Nullable Entity entity) {
        this.increaseAngerAt(entity, 35, true);
    }

    @VisibleForTesting
    public void increaseAngerAt(@Nullable Entity entity, int offset, boolean playListeningSound) {
        if (!this.isNoAi() && this.canTargetEntity(entity)) {
            boolean bl = !(this.getBrain().getMemory(MemoryModuleType.ATTACK_TARGET).orElse(null) instanceof Player);
            int i = this.angerManagement.increaseAnger(entity, offset);
            if (entity instanceof Player && bl && TyrannosaurusAngerLevel.byAnger(i).isAngry()) {
                this.getBrain().eraseMemory(MemoryModuleType.ATTACK_TARGET);
            }

            if (playListeningSound) {
                this.playListeningSound();
            }
        }

    }

    public Optional<LivingEntity> getEntityAngryAt() {
        return this.getAngerLevel().isAngry() ? this.angerManagement.getActiveEntity() : Optional.empty();
    }

    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        boolean bl = super.hurt(source, amount);
        if (!this.level.isClientSide && !this.isNoAi()) {
            Entity entity = source.getEntity();
            this.increaseAngerAt(entity, TyrannosaurusAngerLevel.ANGRY.getMinimumAnger() + 20, false);
            if (this.brain.getMemory(MemoryModuleType.ATTACK_TARGET).isEmpty()
                    && entity instanceof LivingEntity livingEntity
                    && (!(source instanceof IndirectEntityDamageSource) || this.closerThan(livingEntity, 5.0))) {
                this.setAttackTarget(livingEntity);
            }
        }

        return bl;
    }

    @Override
    public void tick() {
        Level level = this.level;
        if (level instanceof ServerLevel serverLevel) {
            this.dynamicGameEventListener.getListener().tick(serverLevel);
        }

        super.tick();
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        TyrannosaurusAngerManagement.codec(this::canTargetEntity)
                .encodeStart(NbtOps.INSTANCE, this.angerManagement)
                .resultOrPartial(LOGGER::error)
                .ifPresent(tag -> compound.put("anger", tag));
        TyrannosaurusVibrationListener.codec(this)
                .encodeStart(NbtOps.INSTANCE, this.dynamicGameEventListener.getListener())
                .resultOrPartial(LOGGER::error)
                .ifPresent(tag -> compound.put("listener", tag));
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("anger")) {
            TyrannosaurusAngerManagement.codec(this::canTargetEntity)
                    .parse(new Dynamic<>(NbtOps.INSTANCE, compound.get("anger")))
                    .resultOrPartial(LOGGER::error)
                    .ifPresent(angerManagement -> this.angerManagement = angerManagement);
            this.syncClientAngerLevel();
        }

        if (compound.contains("listener", 10)) {
            TyrannosaurusVibrationListener.tyrannosaurusCodec(this)
                    .parse(new Dynamic<>(NbtOps.INSTANCE, compound.getCompound("listener")))
                    .resultOrPartial(LOGGER::error)
                    .ifPresent(vibrationListener -> this.dynamicGameEventListener.updateListener(vibrationListener, this.level));
        }
    }

    private void playListeningSound() {
        if (!this.hasPose(Pose.ROARING)) {
            this.playSound(this.getAngerLevel().getListeningSound(), 5.0F, this.getVoicePitch());
        }
    }

    @Override
    protected void customServerAiStep() {
        ServerLevel serverLevel = (ServerLevel)this.level;
        serverLevel.getProfiler().push("tyrannosaurusBrain");
        this.getBrain().tick(serverLevel, this);
        this.level.getProfiler().pop();
        super.customServerAiStep();

        if (this.tickCount % 20 == 0) {
            this.angerManagement.tick(serverLevel, this::canTargetEntity);
            this.syncClientAngerLevel();
        }

        TyrannosaurusAi.updateActivity(this);
    }

    @Override
    public void handleEntityEvent(byte id) {
        if (id == 4) {
            this.roarAnimationState.stop();
            this.attackAnimationState.start(this.tickCount);
        } else {
            super.handleEntityEvent(id);
        }
    }

    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> key) {
        if (DATA_POSE.equals(key)) {
            switch (this.getPose()) {
                case ROARING -> this.roarAnimationState.start(this.tickCount);
                case SNIFFING -> this.sniffAnimationState.start(this.tickCount);
            }
        }

        super.onSyncedDataUpdated(key);
    }

    @Override
    public boolean canDisableShield() {
        return true;
    }

    @Override
    public Brain<?> makeBrain(Dynamic<?> dynamic) {
        return TyrannosaurusAi.makeBrain(this, dynamic);
    }

    @Override
    public Brain<Tyrannosaurus> getBrain() {
        return (Brain<Tyrannosaurus>) super.getBrain();
    }

    @Override
    public void updateDynamicGameEventListener(BiConsumer<DynamicGameEventListener<?>, ServerLevel> listenerConsumer) {
        Level level = this.level;
        if (level instanceof ServerLevel serverLevel) {
            listenerConsumer.accept(this.dynamicGameEventListener, serverLevel);
        }
    }

    @Override
    public boolean canTriggerAvoidVibration() {
        return true;
    }

    @Override
    protected void doPush(Entity entity) {
        if (!this.isNoAi() && !this.getBrain().hasMemoryValue(MemoryModuleType.TOUCH_COOLDOWN)) {
            this.getBrain().setMemoryWithExpiry(MemoryModuleType.TOUCH_COOLDOWN, Unit.INSTANCE, 20L);
            this.increaseAngerAt(entity);
            TyrannosaurusAi.setDisturbanceLocation(this, entity.blockPosition());
        }

        super.doPush(entity);
    }

    @Override
    public boolean shouldListen(ServerLevel level, GameEventListener listener, BlockPos pos, GameEvent gameEvent, GameEvent.Context context) {
        if (!this.isNoAi()
                && !this.isDeadOrDying()
                && !this.getBrain().hasMemoryValue(MemoryModuleType.VIBRATION_COOLDOWN)
                && level.getWorldBorder().isWithinBounds(pos)
                && !this.isRemoved()
                && this.level == level) {
            Entity sourceEntity = context.sourceEntity();
            return !(sourceEntity instanceof LivingEntity livingEntity) || this.canTargetEntity(livingEntity);
        } else {
            return false;
        }
    }

    @Override
    public void onSignalReceive(ServerLevel level, GameEventListener listener, BlockPos sourcePos, GameEvent gameEvent, @Nullable Entity sourceEntity, @Nullable Entity projectileOwner, float distance) {
        if (!this.isDeadOrDying()) {
            this.brain.setMemoryWithExpiry(MemoryModuleType.VIBRATION_COOLDOWN, Unit.INSTANCE, 40L);
            level.broadcastEntityEvent(this, (byte) 61);
            //this.playSound(RegisterSounds.TYRANNOSAURUS_SOUND_RECEIVE, 3.5F, this.getVoicePitch());
            this.playSound(SoundEvents.WARDEN_TENDRIL_CLICKS, 3.5F, this.getVoicePitch());
            BlockPos blockPos = sourcePos;
            if (projectileOwner != null) {
                if (this.closerThan(projectileOwner, 30.0)) {
                    if (this.getBrain().hasMemoryValue(MemoryModuleType.RECENT_PROJECTILE)) {
                        if (this.canTargetEntity(projectileOwner)) {
                            blockPos = projectileOwner.blockPosition();
                        }

                        this.increaseAngerAt(projectileOwner);
                    } else {
                        this.increaseAngerAt(projectileOwner, 10, true);
                    }
                }

                this.getBrain().setMemoryWithExpiry(MemoryModuleType.RECENT_PROJECTILE, Unit.INSTANCE, 100L);
            } else {
                this.increaseAngerAt(sourceEntity);
            }

            if (!this.getAngerLevel().isAngry()) {
                Optional<LivingEntity> optional = this.angerManagement.getActiveEntity();
                if (projectileOwner != null || optional.isEmpty() || optional.get() == sourceEntity) {
                    TyrannosaurusAi.setDisturbanceLocation(this, blockPos);
                }
            }
        }
    }
}
