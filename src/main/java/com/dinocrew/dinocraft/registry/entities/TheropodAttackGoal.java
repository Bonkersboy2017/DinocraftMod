package com.dinocrew.dinocraft.registry.entities;

import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.ZombieEntity;

public class TheropodAttackGoal extends MeleeAttackGoal {
    private final TheropodEntity theropod;
    private int ticks;

    public TheropodAttackGoal(TheropodEntity theropod, double speed, boolean pauseWhenMobIdle) {
        super(theropod, speed, pauseWhenMobIdle);
        this.theropod = theropod;
    }

    public void start() {
        super.start();
        this.ticks = 0;
    }

    public void stop() {
        super.stop();
        this.theropod.setAttacking(false);
    }

    public void tick() {
        super.tick();
        ++this.ticks;
        if (this.ticks >= 5 && this.getCooldown() < this.getMaxCooldown() / 2) {
            this.theropod.setAttacking(true);
        } else {
            this.theropod.setAttacking(false);
        }

    }
}
