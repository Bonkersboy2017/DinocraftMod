package com.dinocrew.dinocraft.registry.entities;

import com.dinocrew.dinocraft.registry.RegisterSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.animal.AbstractSchoolingFish;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class ChinleaEntity extends AbstractSchoolingFish {
    public ChinleaEntity(EntityType<? extends AbstractSchoolingFish> entityType, Level world) {
        super(entityType, world);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(7, new RandomSwimmingGoal(this, 0.4D, 1));


    }

    @Override
    protected SoundEvent getFlopSound() {
        return getSwimSound();
    }

    @Override
    public ItemStack getBucketItemStack() {
        return null;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return RegisterSounds.CHINLEA_IDLE;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return RegisterSounds.CHINLEA_HIT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return RegisterSounds.DINO_DEATH;
    }

}