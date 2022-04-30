package com.dinocrew.dinocraft.recipe;

import com.google.gson.JsonObject;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.world.World;

public class DinoBenchRecipe implements Recipe<Inventory> {
    private final Ingredient main;
    private final Ingredient modifier;
    private final ItemStack result;
    private final Identifier id;
    public DinoBenchRecipe(Identifier id, Ingredient inputMain, Ingredient inputModifier, ItemStack result) {
        this.id = id;
        this.main = inputMain;
        this.modifier = inputModifier;
        this.result = result;
    }
    public Ingredient getMain(){
        return this.main;
    }
    public Ingredient getModifier(){
        return this.modifier;
    }
//Yes, World parameter is useless. No, Mojang won't elaborate
    @Override
    public boolean matches(Inventory inventory, World world) {
        return this.main.test(inventory.getStack(0)) && this.modifier.test(inventory.getStack(1));
    }

    @Override
    public ItemStack craft(Inventory inventory) {
        ItemStack itemStack = this.result.copy();
        NbtCompound nbtCompound = inventory.getStack(0).getNbt();
        if (nbtCompound != null) {
            itemStack.setNbt(nbtCompound.copy());
        }

        return itemStack;
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getOutput() {return this.result;}

    public boolean testModifier(ItemStack stack) {
        return this.modifier.test(stack);
    }

    @Override
    public Identifier getId() {return this.id;}

    @Override
    public RecipeSerializer<?> getSerializer() {return ModRecipeSerializer.DINOBENCH;}
    public static final RecipeType<DinoBenchRecipe> TYPE = Type.INSTANCE;
    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }
    public static class Serializer implements RecipeSerializer<DinoBenchRecipe> {
        public Serializer() {
        }

        public DinoBenchRecipe read(Identifier identifier, JsonObject jsonObject) {
            Ingredient ingredient = Ingredient.fromJson(JsonHelper.getObject(jsonObject, "main"));
            Ingredient ingredient2 = Ingredient.fromJson(JsonHelper.getObject(jsonObject, "modifier"));
            ItemStack itemStack = ShapedRecipe.outputFromJson(JsonHelper.getObject(jsonObject, "result"));
            return new DinoBenchRecipe(identifier, ingredient, ingredient2, itemStack);
        }

        public DinoBenchRecipe read(Identifier identifier, PacketByteBuf packetByteBuf) {
            Ingredient ingredient = Ingredient.fromPacket(packetByteBuf);
            Ingredient ingredient2 = Ingredient.fromPacket(packetByteBuf);
            ItemStack itemStack = packetByteBuf.readItemStack();
            return new DinoBenchRecipe(identifier, ingredient, ingredient2, itemStack);
        }

        public void write(PacketByteBuf packetByteBuf, DinoBenchRecipe dinobenchRecipe) {
            dinobenchRecipe.main.write(packetByteBuf);
            dinobenchRecipe.modifier.write(packetByteBuf);
            packetByteBuf.writeItemStack(dinobenchRecipe.result);
        }
    }
    public static class Type implements RecipeType<DinoBenchRecipe>{
        private Type(){}
        public static final Type INSTANCE = new Type();
        public static final String ID = "dinobench";
    }
}
