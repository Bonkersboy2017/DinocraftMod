package com.dinocrew.dinocraft.item.weapons;

import com.dinocrew.dinocraft.Dinocraft;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.frozenblock.lib.item.api.FrozenCreativeTabs;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Tier;

public class HoeBase extends HoeItem {
    public HoeBase(Tier toolMaterial) {
        super(toolMaterial, -toolMaterial.getLevel(), -3.0F + toolMaterial.getLevel(), new FabricItemSettings().maxCount(1));
    }
}
