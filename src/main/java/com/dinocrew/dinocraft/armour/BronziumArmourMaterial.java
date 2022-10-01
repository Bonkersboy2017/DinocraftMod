package com.dinocrew.dinocraft.armour;

import com.dinocrew.dinocraft.registry.ModItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

public class BronziumArmourMaterial implements ArmorMaterial {
    private static final int[] BASE_DURABILITY = new int[]{10, 13, 14, 12};
    private static final int[] PROTECTION_AMOUNTS = new int[]{5, 7, 8, 6};


    @Override
    public int getDurabilityForSlot(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getIndex()] * 25;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot slot) {
        return PROTECTION_AMOUNTS[slot.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return 25;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.METAL_PLACE;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(ModItems.ROTTING_CYADS);
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
