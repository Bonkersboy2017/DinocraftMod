package com.dinocrew.dinocraft.registry.entities;

import com.dinocrew.dinocraft.registry.RegisterSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.FlyingMob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LevelEvent;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;

//THE MICRORAPTOR IS MEANT TO EXTEND FlyingEntity, most of this class is commented out because of a crucial bux that needs fixing.
public class MicroraptorEntity extends FlyingMob implements Enemy {

    public static final int TICKS_PER_FLAP = Mth.ceil(24.166098F);
    private Vec3 targetPosition = Vec3.ZERO;
    private BlockPos circlingCenter = BlockPos.ZERO;
    private MicroraptorEntity.MicroraptorMovementType movementType = MicroraptorMovementType.CIRCLE;

    public MicroraptorEntity(EntityType<? extends MicroraptorEntity> entityType, Level world) {
        super(entityType, world);
        this.moveControl = new MicroraptorMoveControl(this);
        this.lookControl = new MicroraptorLookControl(this);
    }

    @Override
    public boolean isFlapping() {
        return (this.getFlapTickOffset() + this.tickCount) % TICKS_PER_FLAP == 0;
    }

    @Override
    protected BodyRotationControl createBodyControl() {
        return new MicroraptorBodyControl(this);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new MicroraptorEntity.StartAttackGoal());
        this.goalSelector.addGoal(2, new MicroraptorEntity.SwoopMovementGoal());
        this.goalSelector.addGoal(3, new MicroraptorEntity.CircleMovementGoal());
        this.targetSelector.addGoal(1, new MicroraptorEntity.FindTargetGoal());
    }

    public int getFlapTickOffset() {
        return this.getId() * 3;
    }

    public static AttributeSupplier.Builder createDinoAttributes() {
        return FlyingMob.createMobAttributes().add(Attributes.MAX_HEALTH, 16.0D).add(Attributes.MOVEMENT_SPEED, 0.30000001192092896D).add(Attributes.ATTACK_DAMAGE);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return RegisterSounds.MICRO_IDLE;
    }

    @Override
    public SoundSource getSoundSource() {
        return SoundSource.HOSTILE;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return RegisterSounds.MICRO_HIT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return RegisterSounds.DINO_DEATH;
    }

    class CircleMovementGoal extends MicroraptorEntity.MovementGoal {
        private float angle;
        private float radius;
        private float yOffset;
        private float circlingDirection;

        @Override
        public boolean canUse() {
            return MicroraptorEntity.this.getTarget() == null || MicroraptorEntity.this.movementType == MicroraptorMovementType.CIRCLE;
        }

        @Override
        public void start() {
            this.radius = 5.0F + MicroraptorEntity.this.random.nextFloat() * 10.0F;
            this.yOffset = -4.0F + MicroraptorEntity.this.random.nextFloat() * 9.0F;
            this.circlingDirection = MicroraptorEntity.this.random.nextBoolean() ? 1.0F : -1.0F;
            this.adjustDirection();
        }

        @Override
        public void tick() {
            if (MicroraptorEntity.this.random.nextInt(this.adjustedTickDelay(350)) == 0) {
                this.yOffset = -4.0F + MicroraptorEntity.this.random.nextFloat() * 9.0F;
            }

            if (MicroraptorEntity.this.random.nextInt(this.adjustedTickDelay(250)) == 0) {
                ++this.radius;
                if (this.radius > 15.0F) {
                    this.radius = 5.0F;
                    this.circlingDirection = -this.circlingDirection;
                }
            }

            if (MicroraptorEntity.this.random.nextInt(this.adjustedTickDelay(450)) == 0) {
                this.angle = MicroraptorEntity.this.random.nextFloat() * 2.0F * (float) Math.PI;
                this.adjustDirection();
            }

            if (this.isNearTarget()) {
                this.adjustDirection();
            }

            if (MicroraptorEntity.this.targetPosition.y < MicroraptorEntity.this.getY() && !MicroraptorEntity.this.level.isEmptyBlock(MicroraptorEntity.this.blockPosition().below(1))) {
                this.yOffset = Math.max(1.0F, this.yOffset);
                this.adjustDirection();
            }

            if (MicroraptorEntity.this.targetPosition.y > MicroraptorEntity.this.getY() && !MicroraptorEntity.this.level.isEmptyBlock(MicroraptorEntity.this.blockPosition().above(1))) {
                this.yOffset = Math.min(-1.0F, this.yOffset);
                this.adjustDirection();
            }

        }

        private void adjustDirection() {
            if (BlockPos.ZERO.equals(MicroraptorEntity.this.circlingCenter)) {
                MicroraptorEntity.this.circlingCenter = MicroraptorEntity.this.blockPosition();
            }

            this.angle += this.circlingDirection * 15.0F * (float) (Math.PI / 180.0);
            MicroraptorEntity.this.targetPosition = Vec3.atLowerCornerOf(MicroraptorEntity.this.circlingCenter)
                    .add(this.radius * Mth.cos(this.angle), -4.0F + this.yOffset, this.radius * Mth.sin(this.angle));
        }
    }

    class FindTargetGoal extends Goal {
        private final TargetingConditions PLAYERS_IN_RANGE_PREDICATE = TargetingConditions.forCombat().range(64.0);
        private int delay = reducedTickDelay(20);

        @Override
        public boolean canUse() {
            if (this.delay > 0) {
                --this.delay;
                return false;
            } else {
                this.delay = reducedTickDelay(60);
                List<Player> list = MicroraptorEntity.this.level
                        .getNearbyPlayers(this.PLAYERS_IN_RANGE_PREDICATE, MicroraptorEntity.this, MicroraptorEntity.this.getBoundingBox().inflate(16.0, 64.0, 16.0));
                if (!list.isEmpty()) {
                    list.sort(Comparator.comparing(Entity::getY).reversed());

                    for(Player playerEntity : list) {
                        if (MicroraptorEntity.this.canAttack(playerEntity, TargetingConditions.DEFAULT)) {
                            MicroraptorEntity.this.setTarget(playerEntity);
                            return true;
                        }
                    }
                }

                return false;
            }
        }

        @Override
        public boolean canContinueToUse() {
            LivingEntity livingEntity = MicroraptorEntity.this.getTarget();
            return livingEntity != null ? MicroraptorEntity.this.canAttack(livingEntity, TargetingConditions.DEFAULT) : false;
        }
    }

    abstract class MovementGoal extends Goal {
        public MovementGoal() {
            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        protected boolean isNearTarget() {
            return MicroraptorEntity.this.targetPosition.distanceToSqr(MicroraptorEntity.this.getX(), MicroraptorEntity.this.getY(), MicroraptorEntity.this.getZ()) < 4.0;
        }
    }

    class MicroraptorBodyControl extends BodyRotationControl {
        public MicroraptorBodyControl(Mob entity) {
            super(entity);
        }

        @Override
        public void clientTick() {
            MicroraptorEntity.this.yHeadRot = MicroraptorEntity.this.yBodyRot;
            MicroraptorEntity.this.yBodyRot = MicroraptorEntity.this.getYRot();
        }
    }

    class MicroraptorLookControl extends LookControl {
        public MicroraptorLookControl(Mob entity) {
            super(entity);
        }

        @Override
        public void tick() {
        }
    }

    class MicroraptorMoveControl extends MoveControl {
        /**
         * The movement speed that the microraptor tends towards
         */
        private float targetSpeed = 0.1F;

        public MicroraptorMoveControl(Mob owner) {
            super(owner);
        }

        @Override
        public void tick() {
            if (MicroraptorEntity.this.horizontalCollision) {
                MicroraptorEntity.this.setYRot(MicroraptorEntity.this.getYRot() + 180.0F);
                this.targetSpeed = 0.1F;
            }

            double d = MicroraptorEntity.this.targetPosition.x - MicroraptorEntity.this.getX();
            double e = MicroraptorEntity.this.targetPosition.y - MicroraptorEntity.this.getY();
            double f = MicroraptorEntity.this.targetPosition.z - MicroraptorEntity.this.getZ();
            double g = Math.sqrt(d * d + f * f);
            if (Math.abs(g) > 1.0E-5F) {
                double h = 1.0 - Math.abs(e * 0.7F) / g;
                d *= h;
                f *= h;
                g = Math.sqrt(d * d + f * f);
                double i = Math.sqrt(d * d + f * f + e * e);
                float j = MicroraptorEntity.this.getYRot();
                float k = (float)Mth.atan2(f, d);
                float l = Mth.wrapDegrees(MicroraptorEntity.this.getYRot() + 90.0F);
                float m = Mth.wrapDegrees(k * 180.0F / (float)Math.PI);
                MicroraptorEntity.this.setYRot(Mth.approachDegrees(l, m, 4.0F) - 90.0F);
                MicroraptorEntity.this.yBodyRot = MicroraptorEntity.this.getYRot();
                if (Mth.degreesDifferenceAbs(j, MicroraptorEntity.this.getYRot()) < 3.0F) {
                    this.targetSpeed = Mth.approach(this.targetSpeed, 1.8F, 0.005F * (1.8F / this.targetSpeed));
                } else {
                    this.targetSpeed = Mth.approach(this.targetSpeed, 0.2F, 0.025F);
                }

                float n = (float)(-(Mth.atan2(-e, g) * 180.0F / (float)Math.PI));
                MicroraptorEntity.this.setXRot(n);
                float o = MicroraptorEntity.this.getYRot() + 90.0F;
                double p = (double)(this.targetSpeed * Mth.cos(o * (float) (Math.PI / 180.0))) * Math.abs(d / i);
                double q = (double)(this.targetSpeed * Mth.sin(o * (float) (Math.PI / 180.0))) * Math.abs(f / i);
                double r = (double)(this.targetSpeed * Mth.sin(n * (float) (Math.PI / 180.0))) * Math.abs(e / i);
                Vec3 vec3d = MicroraptorEntity.this.getDeltaMovement();
                MicroraptorEntity.this.setDeltaMovement(vec3d.add(new Vec3(p, r, q).subtract(vec3d).scale(0.2)));
            }

        }
    }

    static enum MicroraptorMovementType {
        CIRCLE,
        SWOOP;
    }

    class StartAttackGoal extends Goal {
        private int cooldown;

        @Override
        public boolean canUse() {
            LivingEntity livingEntity = MicroraptorEntity.this.getTarget();
            return livingEntity != null ? MicroraptorEntity.this.canAttack(livingEntity, TargetingConditions.DEFAULT) : false;
        }

        @Override
        public void start() {
            this.cooldown = this.adjustedTickDelay(10);
            MicroraptorEntity.this.movementType = MicroraptorMovementType.CIRCLE;
            this.startSwoop();
        }

        @Override
        public void stop() {
            MicroraptorEntity.this.circlingCenter = MicroraptorEntity.this.level
                    .getHeightmapPos(Heightmap.Types.MOTION_BLOCKING, MicroraptorEntity.this.circlingCenter)
                    .above(10 + MicroraptorEntity.this.random.nextInt(20));
        }

        @Override
        public void tick() {
            if (MicroraptorEntity.this.movementType == MicroraptorMovementType.CIRCLE) {
                --this.cooldown;
                if (this.cooldown <= 0) {
                    MicroraptorEntity.this.movementType = MicroraptorMovementType.SWOOP;
                    this.startSwoop();
                    this.cooldown = this.adjustedTickDelay((8 + MicroraptorEntity.this.random.nextInt(4)) * 20);
                    MicroraptorEntity.this.playSound(SoundEvents.PHANTOM_SWOOP, 10.0F, 0.95F + MicroraptorEntity.this.random.nextFloat() * 0.1F);
                }
            }

        }

        private void startSwoop() {
            MicroraptorEntity.this.circlingCenter = MicroraptorEntity.this.getTarget().blockPosition().above(20 + MicroraptorEntity.this.random.nextInt(20));
            if (MicroraptorEntity.this.circlingCenter.getY() < MicroraptorEntity.this.level.getSeaLevel()) {
                MicroraptorEntity.this.circlingCenter = new BlockPos(
                        MicroraptorEntity.this.circlingCenter.getX(), MicroraptorEntity.this.level.getSeaLevel() + 1, MicroraptorEntity.this.circlingCenter.getZ()
                );
            }

        }
    }

    class SwoopMovementGoal extends MicroraptorEntity.MovementGoal {
        private static final int CAT_CHECK_INTERVAL = 20;
        private boolean catsNearby;
        private int nextCatCheckAge;

        @Override
        public boolean canUse() {
            return MicroraptorEntity.this.getTarget() != null && MicroraptorEntity.this.movementType == MicroraptorMovementType.SWOOP;
        }

        @Override
        public boolean canContinueToUse() {
            LivingEntity livingEntity = MicroraptorEntity.this.getTarget();
            if (livingEntity == null) {
                return false;
            } else if (!livingEntity.isAlive()) {
                return false;
            } else {
                if (livingEntity instanceof Player playerEntity && (livingEntity.isSpectator() || playerEntity.isCreative())) {
                    return false;
                }

                if (!this.canUse()) {
                    return false;
                } else {
                    if (MicroraptorEntity.this.tickCount > this.nextCatCheckAge) {
                        this.nextCatCheckAge = MicroraptorEntity.this.tickCount + 20;
                        List<Cat> list = MicroraptorEntity.this.level
                                .getEntitiesOfClass(Cat.class, MicroraptorEntity.this.getBoundingBox().inflate(16.0), EntitySelector.ENTITY_STILL_ALIVE);

                        for(Cat catEntity : list) {
                            catEntity.hiss();
                        }

                        this.catsNearby = !list.isEmpty();
                    }

                    return !this.catsNearby;
                }
            }
        }

        @Override
        public void start() {
        }

        @Override
        public void stop() {
            MicroraptorEntity.this.setTarget(null);
            MicroraptorEntity.this.movementType = MicroraptorMovementType.CIRCLE;
        }

        @Override
        public void tick() {
            LivingEntity livingEntity = MicroraptorEntity.this.getTarget();
            if (livingEntity != null) {
                MicroraptorEntity.this.targetPosition = new Vec3(livingEntity.getX(), livingEntity.getY(0.5), livingEntity.getZ());
                if (MicroraptorEntity.this.getBoundingBox().inflate(0.2F).intersects(livingEntity.getBoundingBox())) {
                    MicroraptorEntity.this.doHurtTarget(livingEntity);
                    MicroraptorEntity.this.movementType = MicroraptorMovementType.CIRCLE;
                    if (!MicroraptorEntity.this.isSilent()) {
                        MicroraptorEntity.this.level.levelEvent(LevelEvent.SOUND_PHANTOM_BITE, MicroraptorEntity.this.blockPosition(), 0);
                    }
                } else if (MicroraptorEntity.this.horizontalCollision || MicroraptorEntity.this.hurtTime > 0) {
                    MicroraptorEntity.this.movementType = MicroraptorMovementType.CIRCLE;
                }

            }
        }
    }
}

