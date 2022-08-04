package com.dinocrew.dinocraft.registry.entities;

import com.dinocrew.dinocraft.registry.RegisterSounds;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.FlyingEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class MicroraptorEntity extends FlyingEntity {
    public MicroraptorEntity(EntityType<? extends MicroraptorEntity> entityType, World world) {
        super(entityType, world);
        this.moveControl = new MicroraptorEntity.MicroraptorMoveControl(this);
    }

    protected void initGoals() {
        this.goalSelector.add(3, new FlyRandomlyGoal(this));
    }

    public boolean isOnGround() {
        return this.onGround;
    }


    static class MicroraptorMoveControl extends MoveControl {
        private final MicroraptorEntity microraptor;
        private int collisionCheckCooldown;

        public MicroraptorMoveControl(MicroraptorEntity microraptor) {
            super(microraptor);
            this.microraptor = microraptor;
        }

        public void tick() {
            if (this.state == MoveControl.State.MOVE_TO) {
                if (this.collisionCheckCooldown-- <= 0) {
                    this.collisionCheckCooldown += this.microraptor.getRandom().nextInt(5) + 2;
                    Vec3d vec3d = new Vec3d(this.targetX - this.microraptor.getX(), this.targetY - this.microraptor.getY(), this.targetZ - this.microraptor.getZ());
                    double d = vec3d.length();
                    vec3d = vec3d.normalize();
                    if (this.willCollide(vec3d, MathHelper.ceil(d))) {
                        this.microraptor.setVelocity(this.microraptor.getVelocity().add(vec3d.multiply(0.1D)));
                    } else {
                        this.state = MoveControl.State.WAIT;
                    }
                }

            }
        }

        private boolean willCollide(Vec3d direction, int steps) {
            Box box = this.microraptor.getBoundingBox();

            for (int i = 1; i < steps; ++i) {
                box = box.offset(direction);
                if (!this.microraptor.world.isSpaceEmpty(this.microraptor, box)) {
                    return false;
                }
            }

            return true;
        }
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return RegisterSounds.MICRO_IDLE;
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
}

