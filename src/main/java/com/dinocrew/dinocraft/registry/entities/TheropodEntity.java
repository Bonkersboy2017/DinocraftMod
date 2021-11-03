package com.dinocrew.dinocraft.registry.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.AttackGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;

import static net.minecraft.entity.mob.PhantomEntity.field_28641;

public class TheropodEntity extends PathAwareEntity {
    public TheropodEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);

    }
    protected void initGoals() {
        this.goalSelector.add(7, new WanderAroundFarGoal(this, 0.4D));
        this.goalSelector.add(7, new AttackGoal(this));
    }

}
