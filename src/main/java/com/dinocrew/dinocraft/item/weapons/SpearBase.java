package com.dinocrew.dinocraft.item.weapons;

import com.dinocrew.dinocraft.Dinocraft;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.frozenblock.lib.item.api.FrozenCreativeTabs;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class SpearBase extends SwordItem {
    public SpearBase(Tier toolMaterial, int attackDamage, float attackSpeed, Properties settings) {
        super(toolMaterial, 6, 3.0f, new FabricItemSettings());
        FrozenCreativeTabs.add(this, Dinocraft.ITEM_GROUP);
    }
}
