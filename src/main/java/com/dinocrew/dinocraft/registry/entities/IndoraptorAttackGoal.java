//package com.dinocrew.dinocraft.registry.entities;
//
//import net.minecraft.entity.LivingEntity;
//import net.minecraft.entity.ai.goal.Goal;
//import net.minecraft.entity.ai.goal.MeleeAttackGoal;
//\
//public class IndoraptorAttackGoal extends Goal {
//    private final IndoraptorEntity indoraptor;
//    public int cooldown;
//
//    public IndoraptorAttackGoal(IndoraptorEntity indoraptor) {
//        this.indoraptor = indoraptor;
//    }
//
//    public boolean canStart() {
//        return this.indoraptor.getTarget() != null;
//    }
//
//    public void start() {
//        super.start();
//        this.indoraptor.setAttacking(true);
//        this.cooldown = 0;
//        this.indoraptor.setAttackingState(0);
//    }
//
//    @Override
//    public void stop() {
//        super.stop();
//        this.indoraptor.setAttacking(false);
//        this.indoraptor.setAttackingState(0);
//    }
//
//    public void tick() {
//        LivingEntity livingEntity = this.indoraptor.getTarget();
//        if (this.indoraptor.canSee(livingEntity) && livingEntity != null) {
//            ++this.cooldown;
//            if (this.cooldown == 14) {
//                if(livingEntity.distanceTo(this.indoraptor) <= 2) {
//                    this.indoraptor.setAttackingState(1);
//                    this.indoraptor.tryAttack(livingEntity);
//                }
//            }
//            if (this.cooldown == 27) {
//                this.indoraptor.setAttackingState(0);
//                this.indoraptor.getNavigation().setSpeed(1.33);
//                this.cooldown = -60;
//            }
//        } else if (this.cooldown > 0) {
//            --this.cooldown;
//        }
//    }
//}