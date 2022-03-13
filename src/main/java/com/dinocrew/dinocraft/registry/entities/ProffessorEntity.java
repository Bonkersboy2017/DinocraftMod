package com.dinocrew.dinocraft.registry.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class ProffessorEntity extends HostileEntity {
    public ProffessorEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    protected void initGoals() {

            this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
            this.goalSelector.add(8, new LookAroundGoal(this));
            this.goalSelector.add(7, new WanderAroundFarGoal(this, 0.4D));
            this.goalSelector.add(7, new AttackGoal(this));
            this.goalSelector.add(2, new ProffessorAttackGoal(this, 1.0D, false));

    }


}






