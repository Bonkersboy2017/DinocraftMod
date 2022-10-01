package com.dinocrew.dinocraft.registry.entities;

import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.FlyingMob;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.EnumSet;

public class FlyRandomlyGoal extends Goal {
    private final FlyingMob entity;

    public FlyRandomlyGoal(FlyingMob entity) {
        this.entity = entity;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE));
    }

    @Override
    public boolean canUse() {
        double f;
        double e;
        MoveControl moveControl = this.entity.getMoveControl();
        if (!moveControl.hasWanted()) {
            return true;
        }
        double d = moveControl.getWantedX() - this.entity.getX();
        double g = d * d + (e = moveControl.getWantedY() - this.entity.getY()) * e + (f = moveControl.getWantedZ() - this.entity.getZ()) * f;
        return g < 1.0 || g > 3600.0;
    }

    @Override
    public boolean canContinueToUse() {
        return !this.entity.getNavigation().isDone() && !this.entity.isVehicle();
    }

    @Override
    public void start() {
        RandomSource random = this.entity.getRandom();
        double d = this.entity.getX() + (double) ((random.nextFloat() * 2.0f - 1.0f) * 16.0f);
        double e = this.entity.getY() + (double) ((random.nextFloat() * 2.0f - 1.0f) * 16.0f);
        double f = this.entity.getZ() + (double) ((random.nextFloat() * 2.0f - 1.0f) * 16.0f);
        this.entity.getMoveControl().setWantedPosition(d, e, f, 0.4);
    }
}