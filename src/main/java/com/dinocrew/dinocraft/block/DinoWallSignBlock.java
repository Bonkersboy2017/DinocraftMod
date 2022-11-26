package com.dinocrew.dinocraft.block;

import com.dinocrew.dinocraft.Dinocraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.state.properties.WoodType;

public class DinoWallSignBlock extends WallSignBlock {
    public DinoWallSignBlock(Properties settings, WoodType type) {
        super(settings, type);
    }

    @Override
    public final ResourceLocation getLootTable() {
        ResourceLocation correctedLootTableId = new ResourceLocation(Dinocraft.MOD_ID, "blocks/" + this.type().name() + "_sign");
        if (this.drops != correctedLootTableId) {
            this.drops = correctedLootTableId;
        }

        return this.drops;
    }
}