package com.dinocrew.dinocraft.registry.weapons;

import com.dinocrew.dinocraft.Dinocraft;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class DaggerBase extends SwordItem {
    public DaggerBase(Tier toolMaterial) {
        super(toolMaterial, 3, 3.5f, new FabricItemSettings().tab(Dinocraft.ITEM_GROUP));
    }
}
