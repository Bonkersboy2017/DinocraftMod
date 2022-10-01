package com.dinocrew.dinocraft.registry.weapons;

import com.dinocrew.dinocraft.Dinocraft;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Tier;

public class HoeBase extends HoeItem {
    public HoeBase(Tier toolMaterial) {
        super(toolMaterial, 1, -2.2f, new FabricItemSettings().tab(Dinocraft.ITEM_GROUP));
    }
}
