package com.dinocrew.dinocraft.registry.weapons;

import com.dinocrew.dinocraft.Dinocraft;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class SwordBase extends SwordItem {
    public SwordBase(ToolMaterial toolMaterial) {
        super(toolMaterial, 4, 3.0f, new FabricItemSettings().group(Dinocraft.ITEM_GROUP));
    }
}
