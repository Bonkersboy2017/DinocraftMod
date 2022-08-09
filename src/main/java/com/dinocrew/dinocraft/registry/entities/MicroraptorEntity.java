package com.dinocrew.dinocraft.registry.entities;

import com.dinocrew.dinocraft.registry.RegisterSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.control.BodyControl;
import net.minecraft.entity.ai.control.LookControl;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Heightmap;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import org.jetbrains.annotations.Nullable;

import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;

//THE MICRORAPTOR IS MEANT TO EXTEND FlyingEntity, most of this class is commented out because of a crucial bux that needs fixing.
public class MicroraptorEntity extends FlyingEntity implements Monster {

    public static final int TICKS_PER_FLAP = MathHelper.ceil(24.166098F);
    private Vec3d targetPosition = Vec3d.ZERO;
    private BlockPos circlingCenter = BlockPos.ORIGIN;
    private MicroraptorEntity.MicroraptorMovementType movementType = MicroraptorMovementType.CIRCLE;

    public MicroraptorEntity(EntityType<? extends MicroraptorEntity> entityType, World world) {
        super(entityType, world);
        this.moveControl = new MicroraptorMoveControl(this);
        this.lookControl = new MicroraptorLookControl(this);
    }

    @Override
    public boolean hasWings() {
        return (this.getFlapTickOffset() + this.age) % TICKS_PER_FLAP == 0;
    }

    @Override
    protected BodyControl createBodyControl() {
        return new MicroraptorBodyControl(this);
    }

    protected void initGoals() {
        this.goalSelector.add(1, new MicroraptorEntity.StartAttackGoal());
        this.goalSelector.add(2, new MicroraptorEntity.SwoopMovementGoal());
        this.goalSelector.add(3, new MicroraptorEntity.CircleMovementGoal());
        this.targetSelector.add(1, new MicroraptorEntity.FindTargetGoal());
    }

    public int getFlapTickOffset() {
        return this.getId() * 3;
    }

    public static DefaultAttributeContainer.Builder createDinoAttributes() {
        return FlyingEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 16.0D).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.30000001192092896D).add(EntityAttributes.GENERIC_ATTACK_DAMAGE);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return RegisterSounds.MICRO_IDLE;
    }

    @Override
    public SoundCategory getSoundCategory() {
        return SoundCategory.HOSTILE;
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
        public boolean canStart() {
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
            if (MicroraptorEntity.this.random.nextInt(this.getTickCount(350)) == 0) {
                this.yOffset = -4.0F + MicroraptorEntity.this.random.nextFloat() * 9.0F;
            }

            if (MicroraptorEntity.this.random.nextInt(this.getTickCount(250)) == 0) {
                ++this.radius;
                if (this.radius > 15.0F) {
                    this.radius = 5.0F;
                    this.circlingDirection = -this.circlingDirection;
                }
            }

            if (MicroraptorEntity.this.random.nextInt(this.getTickCount(450)) == 0) {
                this.angle = MicroraptorEntity.this.random.nextFloat() * 2.0F * (float) Math.PI;
                this.adjustDirection();
            }

            if (this.isNearTarget()) {
                this.adjustDirection();
            }

            if (MicroraptorEntity.this.targetPosition.y < MicroraptorEntity.this.getY() && !MicroraptorEntity.this.world.isAir(MicroraptorEntity.this.getBlockPos().down(1))) {
                this.yOffset = Math.max(1.0F, this.yOffset);
                this.adjustDirection();
            }

            if (MicroraptorEntity.this.targetPosition.y > MicroraptorEntity.this.getY() && !MicroraptorEntity.this.world.isAir(MicroraptorEntity.this.getBlockPos().up(1))) {
                this.yOffset = Math.min(-1.0F, this.yOffset);
                this.adjustDirection();
            }

        }

        private void adjustDirection() {
            if (BlockPos.ORIGIN.equals(MicroraptorEntity.this.circlingCenter)) {
                MicroraptorEntity.this.circlingCenter = MicroraptorEntity.this.getBlockPos();
            }

            this.angle += this.circlingDirection * 15.0F * (float) (Math.PI / 180.0);
            MicroraptorEntity.this.targetPosition = Vec3d.of(MicroraptorEntity.this.circlingCenter)
                    .add(this.radius * MathHelper.cos(this.angle), -4.0F + this.yOffset, this.radius * MathHelper.sin(this.angle));
        }
    }

    class FindTargetGoal extends Goal {
        private final TargetPredicate PLAYERS_IN_RANGE_PREDICATE = TargetPredicate.createAttackable().setBaseMaxDistance(64.0);
        private int delay = toGoalTicks(20);

        @Override
        public boolean canStart() {
            if (this.delay > 0) {
                --this.delay;
                return false;
            } else {
                this.delay = toGoalTicks(60);
                List<PlayerEntity> list = MicroraptorEntity.this.world
                        .getPlayers(this.PLAYERS_IN_RANGE_PREDICATE, MicroraptorEntity.this, MicroraptorEntity.this.getBoundingBox().expand(16.0, 64.0, 16.0));
                if (!list.isEmpty()) {
                    list.sort(Comparator.comparing(Entity::getY).reversed());

                    for(PlayerEntity playerEntity : list) {
                        if (MicroraptorEntity.this.isTarget(playerEntity, TargetPredicate.DEFAULT)) {
                            MicroraptorEntity.this.setTarget(playerEntity);
                            return true;
                        }
                    }
                }

                return false;
            }
        }

        @Override
        public boolean shouldContinue() {
            LivingEntity livingEntity = MicroraptorEntity.this.getTarget();
            return livingEntity != null ? MicroraptorEntity.this.isTarget(livingEntity, TargetPredicate.DEFAULT) : false;
        }
    }

    abstract class MovementGoal extends Goal {
        public MovementGoal() {
            this.setControls(EnumSet.of(Goal.Control.MOVE));
        }

        protected boolean isNearTarget() {
            return MicroraptorEntity.this.targetPosition.squaredDistanceTo(MicroraptorEntity.this.getX(), MicroraptorEntity.this.getY(), MicroraptorEntity.this.getZ()) < 4.0;
        }
    }

    class MicroraptorBodyControl extends BodyControl {
        public MicroraptorBodyControl(MobEntity entity) {
            super(entity);
        }

        @Override
        public void tick() {
            MicroraptorEntity.this.headYaw = MicroraptorEntity.this.bodyYaw;
            MicroraptorEntity.this.bodyYaw = MicroraptorEntity.this.getYaw();
        }
    }

    class MicroraptorLookControl extends LookControl {
        public MicroraptorLookControl(MobEntity entity) {
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

        public MicroraptorMoveControl(MobEntity owner) {
            super(owner);
        }

        @Override
        public void tick() {
            if (MicroraptorEntity.this.horizontalCollision) {
                MicroraptorEntity.this.setYaw(MicroraptorEntity.this.getYaw() + 180.0F);
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
                float j = MicroraptorEntity.this.getYaw();
                float k = (float)MathHelper.atan2(f, d);
                float l = MathHelper.wrapDegrees(MicroraptorEntity.this.getYaw() + 90.0F);
                float m = MathHelper.wrapDegrees(k * 180.0F / (float)Math.PI);
                MicroraptorEntity.this.setYaw(MathHelper.stepUnwrappedAngleTowards(l, m, 4.0F) - 90.0F);
                MicroraptorEntity.this.bodyYaw = MicroraptorEntity.this.getYaw();
                if (MathHelper.angleBetween(j, MicroraptorEntity.this.getYaw()) < 3.0F) {
                    this.targetSpeed = MathHelper.stepTowards(this.targetSpeed, 1.8F, 0.005F * (1.8F / this.targetSpeed));
                } else {
                    this.targetSpeed = MathHelper.stepTowards(this.targetSpeed, 0.2F, 0.025F);
                }

                float n = (float)(-(MathHelper.atan2(-e, g) * 180.0F / (float)Math.PI));
                MicroraptorEntity.this.setPitch(n);
                float o = MicroraptorEntity.this.getYaw() + 90.0F;
                double p = (double)(this.targetSpeed * MathHelper.cos(o * (float) (Math.PI / 180.0))) * Math.abs(d / i);
                double q = (double)(this.targetSpeed * MathHelper.sin(o * (float) (Math.PI / 180.0))) * Math.abs(f / i);
                double r = (double)(this.targetSpeed * MathHelper.sin(n * (float) (Math.PI / 180.0))) * Math.abs(e / i);
                Vec3d vec3d = MicroraptorEntity.this.getVelocity();
                MicroraptorEntity.this.setVelocity(vec3d.add(new Vec3d(p, r, q).subtract(vec3d).multiply(0.2)));
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
        public boolean canStart() {
            LivingEntity livingEntity = MicroraptorEntity.this.getTarget();
            return livingEntity != null ? MicroraptorEntity.this.isTarget(livingEntity, TargetPredicate.DEFAULT) : false;
        }

        @Override
        public void start() {
            this.cooldown = this.getTickCount(10);
            MicroraptorEntity.this.movementType = MicroraptorMovementType.CIRCLE;
            this.startSwoop();
        }

        @Override
        public void stop() {
            MicroraptorEntity.this.circlingCenter = MicroraptorEntity.this.world
                    .getTopPosition(Heightmap.Type.MOTION_BLOCKING, MicroraptorEntity.this.circlingCenter)
                    .up(10 + MicroraptorEntity.this.random.nextInt(20));
        }

        @Override
        public void tick() {
            if (MicroraptorEntity.this.movementType == MicroraptorMovementType.CIRCLE) {
                --this.cooldown;
                if (this.cooldown <= 0) {
                    MicroraptorEntity.this.movementType = MicroraptorMovementType.SWOOP;
                    this.startSwoop();
                    this.cooldown = this.getTickCount((8 + MicroraptorEntity.this.random.nextInt(4)) * 20);
                    MicroraptorEntity.this.playSound(SoundEvents.ENTITY_PHANTOM_SWOOP, 10.0F, 0.95F + MicroraptorEntity.this.random.nextFloat() * 0.1F);
                }
            }

        }

        private void startSwoop() {
            MicroraptorEntity.this.circlingCenter = MicroraptorEntity.this.getTarget().getBlockPos().up(20 + MicroraptorEntity.this.random.nextInt(20));
            if (MicroraptorEntity.this.circlingCenter.getY() < MicroraptorEntity.this.world.getSeaLevel()) {
                MicroraptorEntity.this.circlingCenter = new BlockPos(
                        MicroraptorEntity.this.circlingCenter.getX(), MicroraptorEntity.this.world.getSeaLevel() + 1, MicroraptorEntity.this.circlingCenter.getZ()
                );
            }

        }
    }

    class SwoopMovementGoal extends MicroraptorEntity.MovementGoal {
        private static final int CAT_CHECK_INTERVAL = 20;
        private boolean catsNearby;
        private int nextCatCheckAge;

        @Override
        public boolean canStart() {
            return MicroraptorEntity.this.getTarget() != null && MicroraptorEntity.this.movementType == MicroraptorMovementType.SWOOP;
        }

        @Override
        public boolean shouldContinue() {
            LivingEntity livingEntity = MicroraptorEntity.this.getTarget();
            if (livingEntity == null) {
                return false;
            } else if (!livingEntity.isAlive()) {
                return false;
            } else {
                if (livingEntity instanceof PlayerEntity playerEntity && (livingEntity.isSpectator() || playerEntity.isCreative())) {
                    return false;
                }

                if (!this.canStart()) {
                    return false;
                } else {
                    if (MicroraptorEntity.this.age > this.nextCatCheckAge) {
                        this.nextCatCheckAge = MicroraptorEntity.this.age + 20;
                        List<CatEntity> list = MicroraptorEntity.this.world
                                .getEntitiesByClass(CatEntity.class, MicroraptorEntity.this.getBoundingBox().expand(16.0), EntityPredicates.VALID_ENTITY);

                        for(CatEntity catEntity : list) {
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
                MicroraptorEntity.this.targetPosition = new Vec3d(livingEntity.getX(), livingEntity.getBodyY(0.5), livingEntity.getZ());
                if (MicroraptorEntity.this.getBoundingBox().expand(0.2F).intersects(livingEntity.getBoundingBox())) {
                    MicroraptorEntity.this.tryAttack(livingEntity);
                    MicroraptorEntity.this.movementType = MicroraptorMovementType.CIRCLE;
                    if (!MicroraptorEntity.this.isSilent()) {
                        MicroraptorEntity.this.world.syncWorldEvent(WorldEvents.PHANTOM_BITES, MicroraptorEntity.this.getBlockPos(), 0);
                    }
                } else if (MicroraptorEntity.this.horizontalCollision || MicroraptorEntity.this.hurtTime > 0) {
                    MicroraptorEntity.this.movementType = MicroraptorMovementType.CIRCLE;
                }

            }
        }
    }
}

