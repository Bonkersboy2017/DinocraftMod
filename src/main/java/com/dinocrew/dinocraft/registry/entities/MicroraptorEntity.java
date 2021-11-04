package com.dinocrew.dinocraft.registry.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;

public class MicroraptorEntity extends PathAwareEntity {
    public MicroraptorEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
        //this.moveControl = new FlightMoveControl(this, 10, false);
    }

    protected void initGoals() {
        this.goalSelector.add(5, new FlyRandomlyGoal(this));
    }

    public boolean isOnGround() {
        return this.onGround;
    }
}