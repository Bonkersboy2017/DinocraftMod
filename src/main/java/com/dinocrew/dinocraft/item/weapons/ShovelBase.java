package com.dinocrew.dinocraft.item.weapons;

import com.dinocrew.dinocraft.Dinocraft;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.frozenblock.lib.item.api.FrozenCreativeTabs;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;

public class ShovelBase extends ShovelItem {
    public ShovelBase(Tier toolMaterial) {
        super(toolMaterial, 1, -2.2f, new FabricItemSettings());
        FrozenCreativeTabs.add(this, Dinocraft.ITEM_GROUP);
    }
}
