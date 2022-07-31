package com.dinocrew.dinocraft.armour;

import com.dinocrew.dinocraft.Dinocraft;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;

public class BaseArmour extends ArmorItem {
    public BaseArmour(ArmorMaterial material, EquipmentSlot slot) {
        super(material, slot, new FabricItemSettings().group(Dinocraft.ITEM_GROUP));
    }
}
