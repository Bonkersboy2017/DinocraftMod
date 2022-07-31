package com.dinocrew.dinocraft.registry;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {

    public static final FoodComponent CYAD_LEAF = (new FoodComponent.Builder()).hunger(7).saturationModifier(1).build();
    public static final FoodComponent CYAD_SEEDS = (new FoodComponent.Builder()).hunger(7).saturationModifier(1).build();
    public static final FoodComponent BERRIES = (new FoodComponent.Builder()).hunger(7).saturationModifier(1).build();
    public static final FoodComponent TROPICAL_BERRIES = (new FoodComponent.Builder()).hunger(7).saturationModifier(1).build();
    public static final FoodComponent ROTTING_CYADS = (new FoodComponent.Builder()).hunger(7).saturationModifier(1).statusEffect(new StatusEffectInstance(StatusEffects.POISON, 600, 0), 0.8F).build();
    public static final FoodComponent INFECTED_BERRIES = (new FoodComponent.Builder()).hunger(7).saturationModifier(1).statusEffect(new StatusEffectInstance(StatusEffects.POISON, 600, 0), 0.8F).build();
    public static final FoodComponent DINO_FLESH = (new FoodComponent.Builder()).hunger(7).saturationModifier(1).build();
}
