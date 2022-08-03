package com.dinocrew.dinocraft.registry.weapons;

import com.dinocrew.dinocraft.Dinocraft;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class DaggerBase extends SwordItem {
    public DaggerBase(ToolMaterial toolMaterial) {
        super(toolMaterial, 3, 3.5f, new FabricItemSettings().group(Dinocraft.ITEM_GROUP));
    }
}
