package com.dinocrew.dinocraft.registry.weapons;

import com.dinocrew.dinocraft.Dinocraft;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class SpearBase extends SwordItem {
    public SpearBase(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, 6, 3.0f, new QuiltItemSettings().group(Dinocraft.ITEM_GROUP));
    }
}
