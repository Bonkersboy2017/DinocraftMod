package com.dinocrew.dinocraft.armour;

import com.dinocrew.dinocraft.registry.RegisterItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

public class AmberArmorMaterial implements ArmorMaterial {
    private static final int[] BASE_DURABILITY = new int[]{7, 10, 12, 11};
    private static final int[] PROTECTION_AMOUNTS = new int[]{4, 6, 7, 8};


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
        return 15;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.METAL_PLACE;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(RegisterItems.ROTTING_CYADS);
    }

    @Override
    public String getName() {
        return "amber";
    }

    @Override
    public float getToughness() {
        return 1.2f;
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }


}
