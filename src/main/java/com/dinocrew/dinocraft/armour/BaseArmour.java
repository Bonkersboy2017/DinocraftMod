package com.dinocrew.dinocraft.armour;

import com.dinocrew.dinocraft.Dinocraft;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;

public class BaseArmour extends ArmorItem {
    public BaseArmour(ArmorMaterial material, EquipmentSlot slot) {
        super(material, slot, new FabricItemSettings().tab(Dinocraft.ITEM_GROUP));
    }
}
