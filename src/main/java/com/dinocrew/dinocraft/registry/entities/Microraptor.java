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
import java.util.Objects;

//THE MICRORAPTOR IS MEANT TO EXTEND FlyingEntity, most of this class is commented out because of a crucial bux that needs fixing.
public class Microraptor extends FlyingMob implements Enemy {

    public static final int TICKS_PER_FLAP = Mth.ceil(24.166098F);
    private Vec3 targetPosition = Vec3.ZERO;
    private BlockPos circlingCenter = BlockPos.ZERO;
    private Microraptor.MicroraptorMovementType movementType = MicroraptorMovementType.CIRCLE;

    public Microraptor(EntityType<? extends Microraptor> entityType, Level world) {
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
        this.goalSelector.addGoal(1, new Microraptor.StartAttackGoal(this));
        this.goalSelector.addGoal(2, new Microraptor.SwoopMovementGoal(this));
        this.goalSelector.addGoal(3, new Microraptor.CircleMovementGoal(this));
        this.targetSelector.addGoal(1, new Microraptor.FindTargetGoal(this));
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

    private static class CircleMovementGoal extends Microraptor.MovementGoal {
        private float angle;
        private float radius;
        private float yOffset;
        private float circlingDirection;

        public CircleMovementGoal(Microraptor microraptor) {
            super(microraptor);
        }

        @Override
        public boolean canUse() {
            return this.microraptor.getTarget() == null || this.microraptor.movementType == MicroraptorMovementType.CIRCLE;
        }

        @Override
        public void start() {
            this.radius = 5.0F + this.microraptor.random.nextFloat() * 10.0F;
            this.yOffset = -4.0F + this.microraptor.random.nextFloat() * 9.0F;
            this.circlingDirection = this.microraptor.random.nextBoolean() ? 1.0F : -1.0F;
            this.adjustDirection();
        }

        @Override
        public void tick() {
            if (this.microraptor.random.nextInt(this.adjustedTickDelay(350)) == 0) {
                this.yOffset = -4.0F + this.microraptor.random.nextFloat() * 9.0F;
            }

            if (this.microraptor.random.nextInt(this.adjustedTickDelay(250)) == 0) {
                ++this.radius;
                if (this.radius > 15.0F) {
                    this.radius = 5.0F;
                    this.circlingDirection = -this.circlingDirection;
                }
            }

            if (this.microraptor.random.nextInt(this.adjustedTickDelay(450)) == 0) {
                this.angle = this.microraptor.random.nextFloat() * 2.0F * (float) Math.PI;
                this.adjustDirection();
            }

            if (this.isNearTarget()) {
                this.adjustDirection();
            }

            if (this.microraptor.targetPosition.y < this.microraptor.getY() && !this.microraptor.level.isEmptyBlock(this.microraptor.blockPosition().below(1))) {
                this.yOffset = Math.max(1.0F, this.yOffset);
                this.adjustDirection();
            }

            if (this.microraptor.targetPosition.y > this.microraptor.getY() && !this.microraptor.level.isEmptyBlock(this.microraptor.blockPosition().above(1))) {
                this.yOffset = Math.min(-1.0F, this.yOffset);
                this.adjustDirection();
            }

        }

        private void adjustDirection() {
            if (BlockPos.ZERO.equals(this.microraptor.circlingCenter)) {
                this.microraptor.circlingCenter = this.microraptor.blockPosition();
            }

            this.angle += this.circlingDirection * 15.0F * (float) (Math.PI / 180.0);
            this.microraptor.targetPosition = Vec3.atLowerCornerOf(this.microraptor.circlingCenter)
                    .add(this.radius * Mth.cos(this.angle), -4.0F + this.yOffset, this.radius * Mth.sin(this.angle));
        }
    }

    private static class FindTargetGoal extends Goal {
        private final TargetingConditions PLAYERS_IN_RANGE_PREDICATE = TargetingConditions.forCombat().range(64.0);
        private int delay = reducedTickDelay(20);

        public final Microraptor microraptor;

        public FindTargetGoal(Microraptor microraptor) {
            this.microraptor = microraptor;
        }

        @Override
        public boolean canUse() {
            if (this.delay > 0) {
                --this.delay;
                return false;
            } else {
                this.delay = reducedTickDelay(60);
                List<Player> list = this.microraptor.level
                        .getNearbyPlayers(this.PLAYERS_IN_RANGE_PREDICATE, this.microraptor, this.microraptor.getBoundingBox().inflate(16.0, 64.0, 16.0));
                if (!list.isEmpty()) {
                    list.sort(Comparator.comparing(entity -> ((Entity) entity).getY()).reversed());

                    for(Player playerEntity : list) {
                        if (this.microraptor.canAttack(playerEntity, TargetingConditions.DEFAULT)) {
                            this.microraptor.setTarget(playerEntity);
                            return true;
                        }
                    }
                }

                return false;
            }
        }

        @Override
        public boolean canContinueToUse() {
            LivingEntity livingEntity = this.microraptor.getTarget();
            return livingEntity != null && this.microraptor.canAttack(livingEntity, TargetingConditions.DEFAULT);
        }
    }

    private static abstract class MovementGoal extends Goal {

        public final Microraptor microraptor;

        public MovementGoal(Microraptor microraptor) {
            this.microraptor = microraptor;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        protected boolean isNearTarget() {
            return this.microraptor.targetPosition.distanceToSqr(this.microraptor.getX(), this.microraptor.getY(), this.microraptor.getZ()) < 4.0;
        }
    }

    private static class MicroraptorBodyControl extends BodyRotationControl {

        public final Microraptor microraptor;

        public MicroraptorBodyControl(Microraptor microraptor) {
            super(microraptor);
            this.microraptor = microraptor;
        }

        @Override
        public void clientTick() {
            this.microraptor.yHeadRot = this.microraptor.yBodyRot;
            this.microraptor.yBodyRot = this.microraptor.getYRot();
        }
    }

    private static class MicroraptorLookControl extends LookControl {
        public MicroraptorLookControl(Mob entity) {
            super(entity);
        }

        @Override
        public void tick() {
        }
    }

    private static class MicroraptorMoveControl extends MoveControl {
        /**
         * The movement speed that the microraptor tends towards
         */
        private float targetSpeed = 0.1F;

        public final Microraptor microraptor;

        public MicroraptorMoveControl(Microraptor microraptor) {
            super(microraptor);
            this.microraptor = microraptor;
        }

        @Override
        public void tick() {
            if (this.microraptor.horizontalCollision) {
                this.microraptor.setYRot(this.microraptor.getYRot() + 180.0F);
                this.targetSpeed = 0.1F;
            }

            double x = this.microraptor.targetPosition.x - this.microraptor.getX();
            double y = this.microraptor.targetPosition.y - this.microraptor.getY();
            double z = this.microraptor.targetPosition.z - this.microraptor.getZ();
            double g = Math.sqrt(x * x + z * z);
            if (Math.abs(g) > 1.0E-5F) {
                double h = 1.0 - Math.abs(y * 0.7F) / g;
                x *= h;
                z *= h;
                g = Math.sqrt(x * x + z * z);
                double i = Math.sqrt(x * x + z * z + y * y);
                float j = this.microraptor.getYRot();
                float k = (float)Mth.atan2(z, x);
                float l = Mth.wrapDegrees(this.microraptor.getYRot() + 90.0F);
                float m = Mth.wrapDegrees(k * 180.0F / (float)Math.PI);
                this.microraptor.setYRot(Mth.approachDegrees(l, m, 4.0F) - 90.0F);
                this.microraptor.yBodyRot = this.microraptor.getYRot();
                if (Mth.degreesDifferenceAbs(j, this.microraptor.getYRot()) < 3.0F) {
                    this.targetSpeed = Mth.approach(this.targetSpeed, 1.8F, 0.005F * (1.8F / this.targetSpeed));
                } else {
                    this.targetSpeed = Mth.approach(this.targetSpeed, 0.2F, 0.025F);
                }

                float n = (float)(-(Mth.atan2(-y, g) * 180.0F / (float)Math.PI));
                this.microraptor.setXRot(n);
                float o = this.microraptor.getYRot() + 90.0F;
                double p = (double)(this.targetSpeed * Mth.cos(o * (float) (Math.PI / 180.0))) * Math.abs(x / i);
                double q = (double)(this.targetSpeed * Mth.sin(o * (float) (Math.PI / 180.0))) * Math.abs(z / i);
                double r = (double)(this.targetSpeed * Mth.sin(n * (float) (Math.PI / 180.0))) * Math.abs(y / i);
                Vec3 vec3d = this.microraptor.getDeltaMovement();
                this.microraptor.setDeltaMovement(vec3d.add(new Vec3(p, r, q).subtract(vec3d).scale(0.2)));
            }

        }
    }

    private enum MicroraptorMovementType {
        CIRCLE,
        SWOOP;
    }

    private static class StartAttackGoal extends Goal {
        private int cooldown;

        public final Microraptor microraptor;

        public StartAttackGoal(Microraptor microraptor) {
            this.microraptor = microraptor;
        }

        @Override
        public boolean canUse() {
            LivingEntity livingEntity = this.microraptor.getTarget();
            return livingEntity != null && this.microraptor.canAttack(livingEntity, TargetingConditions.DEFAULT);
        }

        @Override
        public void start() {
            this.cooldown = this.adjustedTickDelay(10);
            this.microraptor.movementType = MicroraptorMovementType.CIRCLE;
            this.startSwoop();
        }

        @Override
        public void stop() {
            this.microraptor.circlingCenter = this.microraptor.level
                    .getHeightmapPos(Heightmap.Types.MOTION_BLOCKING, this.microraptor.circlingCenter)
                    .above(10 + this.microraptor.random.nextInt(20));
        }

        @Override
        public void tick() {
            if (this.microraptor.movementType == MicroraptorMovementType.CIRCLE) {
                --this.cooldown;
                if (this.cooldown <= 0) {
                    this.microraptor.movementType = MicroraptorMovementType.SWOOP;
                    this.startSwoop();
                    this.cooldown = this.adjustedTickDelay((8 + this.microraptor.random.nextInt(4)) * 20);
                    this.microraptor.playSound(SoundEvents.PHANTOM_SWOOP, 10.0F, 0.95F + this.microraptor.random.nextFloat() * 0.1F);
                }
            }

        }

        private void startSwoop() {
            this.microraptor.circlingCenter = Objects.requireNonNull(this.microraptor.getTarget()).blockPosition().above(20 + this.microraptor.random.nextInt(20));
            if (this.microraptor.circlingCenter.getY() < this.microraptor.level.getSeaLevel()) {
                this.microraptor.circlingCenter = new BlockPos(
                        this.microraptor.circlingCenter.getX(), this.microraptor.level.getSeaLevel() + 1, this.microraptor.circlingCenter.getZ()
                );
            }

        }
    }

    private static class SwoopMovementGoal extends Microraptor.MovementGoal {
        private static final int CAT_CHECK_INTERVAL = 20;
        private boolean catsNearby;
        private int nextCatCheckAge;

        public SwoopMovementGoal(Microraptor microraptor) {
            super(microraptor);
        }

        @Override
        public boolean canUse() {
            return this.microraptor.getTarget() != null && this.microraptor.movementType == MicroraptorMovementType.SWOOP;
        }

        @Override
        public boolean canContinueToUse() {
            LivingEntity livingEntity = this.microraptor.getTarget();
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
                    if (this.microraptor.tickCount > this.nextCatCheckAge) {
                        this.nextCatCheckAge = this.microraptor.tickCount + 20;
                        List<Cat> list = this.microraptor.level
                                .getEntitiesOfClass(Cat.class, this.microraptor.getBoundingBox().inflate(16.0), EntitySelector.ENTITY_STILL_ALIVE);

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
            this.microraptor.setTarget(null);
            this.microraptor.movementType = MicroraptorMovementType.CIRCLE;
        }

        @Override
        public void tick() {
            LivingEntity livingEntity = this.microraptor.getTarget();
            if (livingEntity != null) {
                this.microraptor.targetPosition = new Vec3(livingEntity.getX(), livingEntity.getY(0.5), livingEntity.getZ());
                if (this.microraptor.getBoundingBox().inflate(0.2F).intersects(livingEntity.getBoundingBox())) {
                    this.microraptor.doHurtTarget(livingEntity);
                    this.microraptor.movementType = MicroraptorMovementType.CIRCLE;
                    if (!this.microraptor.isSilent()) {
                        this.microraptor.level.levelEvent(LevelEvent.SOUND_PHANTOM_BITE, this.microraptor.blockPosition(), 0);
                    }
                } else if (this.microraptor.horizontalCollision || this.microraptor.hurtTime > 0) {
                    this.microraptor.movementType = MicroraptorMovementType.CIRCLE;
                }

            }
        }
    }
}

