package com.dinocrew.dinocraft.block;

import com.dinocrew.dinocraft.Dinocraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.state.properties.WoodType;

import java.util.Objects;

public class DinoSignBlock extends StandingSignBlock {

    public DinoSignBlock(Properties settings, WoodType type) {
        super(settings, type);
    }

    @Override
    public final ResourceLocation getLootTable() {
        ResourceLocation correctedLootTableId = new ResourceLocation(Dinocraft.MOD_ID, "blocks/" + this.type().name() + "_sign");
        if (!Objects.equals(this.drops, correctedLootTableId)) {
            this.drops = correctedLootTableId;
        }

        return this.drops;
    }
}