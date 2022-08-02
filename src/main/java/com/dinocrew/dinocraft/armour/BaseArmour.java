package com.dinocrew.dinocraft.armour;

import com.dinocrew.dinocraft.Dinocraft;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class BaseArmour extends ArmorItem {
    public BaseArmour(ArmorMaterial material, EquipmentSlot slot) {
        super(material, slot, new QuiltItemSettings().group(Dinocraft.ITEM_GROUP));
    }
}
