package com.dinocrew.dinocraft.item.weapons;

import com.dinocrew.dinocraft.registry.RegisterItems;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class ToolMaterialEnlightened implements Tier {
    @Override
    public int getUses() {
        return 400;
    }

    @Override
    public float getSpeed() {
        return 10.0f;
    }

    @Override
    public float getAttackDamageBonus() {
        return 3.5f;
    }

    @Override
    public int getLevel() {
        return 4;
    }

    @Override
    public int getEnchantmentValue() {
        return 5;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(RegisterItems.WYVERN_CRYSTAL);
    }


}
