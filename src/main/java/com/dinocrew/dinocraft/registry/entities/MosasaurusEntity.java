package com.dinocrew.dinocraft.registry.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.SwimAroundGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;

public class MosasaurusEntity extends SchoolingFishEntity {
    public MosasaurusEntity(EntityType<? extends SchoolingFishEntity> entityType, World world) {
        super(entityType, world);
    }

    protected void initGoals() {
        this.goalSelector.add(7, new SwimAroundGoal(this, 0.4D, 1));


    }

    @Override
    protected SoundEvent getFlopSound() {
        return null;
    }

    @Override
    public ItemStack getBucketItem() {
        return null;
    }
}