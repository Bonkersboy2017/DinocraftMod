package com.dinocrew.dinocraft.registry.weapons;

import com.dinocrew.dinocraft.Dinocraft;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class SwordBase extends SwordItem {
    public SwordBase(Tier toolMaterial) {
        super(toolMaterial, 4, 3.0f, new FabricItemSettings().tab(Dinocraft.ITEM_GROUP));
    }
}
