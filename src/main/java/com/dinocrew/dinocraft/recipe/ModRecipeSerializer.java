package com.dinocrew.dinocraft.recipe;

import com.dinocrew.dinocraft.Dinocraft;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class ModRecipeSerializer<T extends Recipe<?>> {
    public static final RecipeSerializer<DinoBenchRecipe> DINOBENCH = register("dinobench", new DinoBenchRecipe.Serializer());

    static <S extends RecipeSerializer<T>, T extends Recipe<?>> S register(String id, S serializer) {
        return Registry.register(Registry.RECIPE_SERIALIZER, Dinocraft.id(id), serializer);
    }

    public static void initialize() {
    }
}
