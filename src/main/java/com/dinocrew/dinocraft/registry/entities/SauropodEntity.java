package com.dinocrew.dinocraft.registry.entities;

import com.dinocrew.dinocraft.registry.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.world.World;

import javax.swing.*;

public class SauropodEntity extends PathAwareEntity {
    public SauropodEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }
    protected void initGoals() {
        this.goalSelector.add(7, new WanderAroundFarGoal(this, 0.4D));
        this.goalSelector.add(7, new AttackGoal(this));
        this.goalSelector.add(4, new TemptGoal(this, 0.7D, Ingredient.ofItems(new ItemConvertible[]{ModItems.CYAD_LEAF}), false));


    }

}



