package com.dinocrew.dinocraft.registry.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.SwimAroundGoal;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;

public class ChinleaEntity extends SchoolingFishEntity {
    public ChinleaEntity(EntityType<? extends SchoolingFishEntity> entityType, World world) {
        super(entityType, world);
    }

    protected void initGoals() {
        this.goalSelector.add(7, new SwimAroundGoal(this, 0.4D, 1));


    }

    @Override
    protected SoundEvent getFlopSound() {
        return getSwimSound();
    }

    @Override
    public ItemStack getBucketItem() {
        return null;
    }
}