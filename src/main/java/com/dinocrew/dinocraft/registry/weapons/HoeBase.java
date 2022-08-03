package com.dinocrew.dinocraft.registry.weapons;

import com.dinocrew.dinocraft.Dinocraft;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;

public class HoeBase extends HoeItem {
    public HoeBase(ToolMaterial toolMaterial) {
        super(toolMaterial, 1, -2.2f, new FabricItemSettings().group(Dinocraft.ITEM_GROUP));
    }
}
