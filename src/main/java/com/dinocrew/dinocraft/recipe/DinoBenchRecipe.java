package com.dinocrew.dinocraft.recipe;

import com.google.gson.JsonObject;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.Level;

public class DinoBenchRecipe implements Recipe<Container> {
    private final Ingredient main;
    private final Ingredient modifier;
    private final ItemStack result;
    private final ResourceLocation id;

    public DinoBenchRecipe(ResourceLocation id, Ingredient inputMain, Ingredient inputModifier, ItemStack result) {
        this.id = id;
        this.main = inputMain;
        this.modifier = inputModifier;
        this.result = result;
    }

    public Ingredient getMain() {
        return this.main;
    }

    public Ingredient getModifier() {
        return this.modifier;
    }

    //Yes, World parameter is useless. No, Mojang won't elaborate
    @Override
    public boolean matches(Container inventory, Level world) {
        return this.main.test(inventory.getItem(0)) && this.modifier.test(inventory.getItem(1));
    }

    @Override
    public ItemStack assemble(Container inventory) {
        ItemStack itemStack = this.result.copy();
        CompoundTag nbtCompound = inventory.getItem(0).getTag();
        if (nbtCompound != null) {
            itemStack.setTag(nbtCompound.copy());
        }

        return itemStack;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResultItem() {
        return this.result;
    }

    public boolean testModifier(ItemStack stack) {
        return this.modifier.test(stack);
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipeSerializer.DINOBENCH;
    }

    public static final RecipeType<DinoBenchRecipe> TYPE = Type.INSTANCE;

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Serializer implements RecipeSerializer<DinoBenchRecipe> {
        public Serializer() {
        }

        public DinoBenchRecipe fromJson(ResourceLocation identifier, JsonObject jsonObject) {
            Ingredient ingredient = Ingredient.fromJson(GsonHelper.getAsJsonObject(jsonObject, "main"));
            Ingredient ingredient2 = Ingredient.fromJson(GsonHelper.getAsJsonObject(jsonObject, "modifier"));
            ItemStack itemStack = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(jsonObject, "result"));
            return new DinoBenchRecipe(identifier, ingredient, ingredient2, itemStack);
        }

        public DinoBenchRecipe fromNetwork(ResourceLocation identifier, FriendlyByteBuf packetByteBuf) {
            Ingredient ingredient = Ingredient.fromNetwork(packetByteBuf);
            Ingredient ingredient2 = Ingredient.fromNetwork(packetByteBuf);
            ItemStack itemStack = packetByteBuf.readItem();
            return new DinoBenchRecipe(identifier, ingredient, ingredient2, itemStack);
        }

        public void toNetwork(FriendlyByteBuf packetByteBuf, DinoBenchRecipe dinobenchRecipe) {
            dinobenchRecipe.main.toNetwork(packetByteBuf);
            dinobenchRecipe.modifier.toNetwork(packetByteBuf);
            packetByteBuf.writeItem(dinobenchRecipe.result);
        }
    }

    public static class Type implements RecipeType<DinoBenchRecipe> {
        private Type() {
        }

        public static final Type INSTANCE = new Type();
        public static final String ID = "dinobench";
    }
}
