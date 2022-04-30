package com.dinocrew.dinocraft.armour;

import com.dinocrew.dinocraft.registry.ModItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class BronziumArmourMaterial implements ArmorMaterial {
    private static final int[] BASE_DURABILITY = new int[] {10, 13, 14, 12};
    private static final int[] PROTECTION_AMOUNTS = new int[] {5, 7, 8, 6};


    @Override
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()]*25;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return PROTECTION_AMOUNTS[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return 25;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.BLOCK_METAL_PLACE;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ModItems.ROTTING_CYADS);
    }

    @Override
    public String getName() {
        return "bronzium";
    }

    @Override
    public float getToughness() {
        return 1.5f;
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }



}
