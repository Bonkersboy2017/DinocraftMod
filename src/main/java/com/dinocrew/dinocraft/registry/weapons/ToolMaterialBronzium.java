package com.dinocrew.dinocraft.registry.weapons;

import com.dinocrew.dinocraft.registry.ModItems;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class ToolMaterialBronzium implements Tier {

    @Override
    public int getUses() {
        return 250;
    }

    @Override
    public float getSpeed() {
        return 8.0f;
    }

    @Override
    public float getAttackDamageBonus() {
        return 2.0f;
    }

    @Override
    public int getLevel() {
        return 3;
    }

    @Override
    public int getEnchantmentValue() {
        return 10;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(ModItems.DINO_SKELETON_JAW);
    }
}
