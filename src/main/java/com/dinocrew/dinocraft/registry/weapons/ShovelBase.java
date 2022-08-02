package com.dinocrew.dinocraft.registry.weapons;

import com.dinocrew.dinocraft.Dinocraft;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class ShovelBase extends ShovelItem {
    public ShovelBase(ToolMaterial toolMaterial) {
        super(toolMaterial, 1, -2.2f, new QuiltItemSettings().group(Dinocraft.ITEM_GROUP));
    }
}
