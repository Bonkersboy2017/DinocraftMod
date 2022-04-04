package com.dinocrew.dinocraft.recipe;

import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.registry.Registry;

public class ModRecipeSerializer<T extends Recipe<?>> {
    public static final RecipeSerializer<DinoBenchRecipe> DINOBENCH = register("dinobench", new DinoBenchRecipe.Serializer());
    static <S extends RecipeSerializer<T>, T extends Recipe<?>> S register(String id, S serializer) {
        return Registry.register(Registry.RECIPE_SERIALIZER, id, serializer);
    }
}
