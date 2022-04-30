package com.dinocrew.dinocraft.registry.entities;

import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.ZombieEntity;

public class ProffessorAttackGoal extends MeleeAttackGoal {
    private final ProffessorEntity proffessor;
    private int ticks;

    public ProffessorAttackGoal(ProffessorEntity proffessor, double speed, boolean pauseWhenMobIdle) {
        super(proffessor, speed, pauseWhenMobIdle);
        this.proffessor = proffessor;
    }

    public void start() {
        super.start();
        this.ticks = 0;
    }

    public void stop() {
        super.stop();
        this.proffessor.setAttacking(false);
    }

    public void tick() {
        super.tick();
        ++this.ticks;
        if (this.ticks >= 5 && this.getCooldown() < this.getMaxCooldown() / 2) {
            this.proffessor.setAttacking(true);
        } else {
            this.proffessor.setAttacking(false);
        }

    }
}
