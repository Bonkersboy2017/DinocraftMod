package com.dinocrew.dinocraft.registry.entities;

import com.dinocrew.dinocraft.registry.RegisterSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class ProfessorEntity extends Monster {
    public ProfessorEntity(EntityType<? extends Monster> entityType, Level world) {
        super(entityType, world);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.initCustomGoals();
    }

    protected void initCustomGoals() {
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 0.3D));
    }



    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return RegisterSounds.PROFESSOR_IDLE;
    }

    @Override
    public SoundSource getSoundSource() {
        return SoundSource.HOSTILE;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return RegisterSounds.PROFESSOR_HIT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return RegisterSounds.PROFESSOR_DEATH;
    }
}










