package com.dinocrew.dinocraft.registry.entities;

import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.ZombieEntity;

public class TroodonAttackGoal
        extends MeleeAttackGoal {
    private final TroodonEntity troodon;
    private int ticks;

    public TroodonAttackGoal(TroodonEntity troodon, double speed, boolean pauseWhenMobIdle) {
        super(troodon, speed, pauseWhenMobIdle);
        this.troodon = troodon;
    }

    @Override
    public void start() {
        super.start();
        this.ticks = 0;
    }

    @Override
    public void stop() {
        super.stop();
        this.troodon.setAttacking(false);
    }

    @Override
    public void tick() {
        super.tick();
        ++this.ticks;
        if (this.ticks >= 5 && this.getCooldown() < this.getMaxCooldown() / 2) {
            this.troodon.setAttacking(true);
        } else {
            this.troodon.setAttacking(false);
        }
    }
}

