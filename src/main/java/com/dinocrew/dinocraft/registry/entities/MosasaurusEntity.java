package com.dinocrew.dinocraft.registry.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.BreatheAirGoal;
import net.minecraft.entity.ai.goal.MoveIntoWaterGoal;
import net.minecraft.entity.ai.goal.SwimAroundGoal;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;

public class MosasaurusEntity extends FishEntity {

    public MosasaurusEntity(EntityType<? extends FishEntity> entityType, World world) {
        super(entityType, world);
    }

    protected void initGoals() {
        this.goalSelector.add(0, new BreatheAirGoal(this));
        this.goalSelector.add(0, new MoveIntoWaterGoal(this));
        this.goalSelector.add(4, new SwimAroundGoal(this, 1.0D, 10));

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