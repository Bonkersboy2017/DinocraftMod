package com.dinocrew.dinocraft.registry.weapons;

import com.dinocrew.dinocraft.registry.ModItems;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class ToolMaterialAmber implements Tier {

    @Override
    public int getUses() {
        return 100;
    }

    @Override
    public float getSpeed() {
        return 5.0f;
    }

    @Override
    public float getAttackDamageBonus() {
        return 1.0f;
    }

    @Override
    public int getLevel() {
        return 2;
    }

    @Override
    public int getEnchantmentValue() {
        return 5;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(ModItems.DINO_KIDNEY);
    }
}
