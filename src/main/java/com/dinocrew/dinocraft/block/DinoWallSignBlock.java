package com.dinocrew.dinocraft.block;

import com.dinocrew.dinocraft.Dinocraft;
import net.minecraft.block.WallSignBlock;
import net.minecraft.util.Identifier;
import net.minecraft.util.SignType;

public class DinoWallSignBlock extends WallSignBlock {
    public DinoWallSignBlock(Settings settings, SignType type) {
        super(settings, type);
    }

    @Override
    public final Identifier getLootTableId() {
        Identifier correctedLootTableId = new Identifier(Dinocraft.MOD_ID, "blocks/" + this.getSignType().getName() + "_sign");
        if (this.lootTableId != correctedLootTableId) {
            this.lootTableId = correctedLootTableId;
        }

        return this.lootTableId;
    }
}