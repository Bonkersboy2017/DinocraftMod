package com.dinocrew.dinocraft.registry;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class RegisterFood {

    public static final FoodProperties CYAD_LEAF = (new FoodProperties.Builder()).nutrition(7).saturationMod(1).build();
    public static final FoodProperties CYAD_SEEDS = (new FoodProperties.Builder()).nutrition(7).saturationMod(1).build();
    public static final FoodProperties BERRIES = (new FoodProperties.Builder()).nutrition(7).saturationMod(1).build();
    public static final FoodProperties TROPICAL_BERRIES = (new FoodProperties.Builder()).nutrition(7).saturationMod(1).build();
    public static final FoodProperties ROTTING_CYADS = (new FoodProperties.Builder()).nutrition(7).saturationMod(1).effect(new MobEffectInstance(MobEffects.POISON, 600, 0), 0.8F).build();
    public static final FoodProperties INFECTED_BERRIES = (new FoodProperties.Builder()).nutrition(7).saturationMod(1).effect(new MobEffectInstance(MobEffects.POISON, 600, 0), 0.8F).build();
    public static final FoodProperties DINO_FLESH = (new FoodProperties.Builder()).nutrition(7).saturationMod(1).build();
}
