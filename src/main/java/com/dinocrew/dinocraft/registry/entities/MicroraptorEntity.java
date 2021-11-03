package com.dinocrew.dinocraft.registry.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.control.FlightMoveControl;
import net.minecraft.entity.ai.goal.FlyOntoTreeGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;

public class MicroraptorEntity extends PathAwareEntity {
    public MicroraptorEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
        //this.moveControl = new FlightMoveControl(this, 10, false);
    }
    protected void initGoals() {
        this.goalSelector.add(2, new FlyOntoTreeGoal(this, 1.0D));
    }
    public boolean isInAir() {
        World world = this.getEntityWorld();

        return !this.onGround;
    }
}
