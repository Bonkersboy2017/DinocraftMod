package com.dinocrew.dinocraft.item.weapons;

import com.dinocrew.dinocraft.registry.RegisterItems;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class ToolMaterialDragonwood implements Tier {

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
        return 3.5F;
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
        return Ingredient.of(RegisterItems.DINO_SKELETON_JAW);
    }
}

