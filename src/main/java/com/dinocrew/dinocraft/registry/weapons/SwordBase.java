package com.dinocrew.dinocraft.registry.weapons;

import com.dinocrew.dinocraft.Dinocraft;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class SwordBase extends SwordItem {
    public SwordBase(ToolMaterial toolMaterial) {
        super(toolMaterial, 4, 3.0f, new QuiltItemSettings().group(Dinocraft.ITEM_GROUP));
    }
}
