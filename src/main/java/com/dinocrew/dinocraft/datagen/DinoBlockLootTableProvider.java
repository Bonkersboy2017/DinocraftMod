package com.dinocrew.dinocraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.frozenblock.registry.RegisterBlocks;
import net.minecraft.item.Items;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.predicate.item.ItemPredicate;

public class DinoBlockLootTableProvider extends FabricBlockLootTableProvider {

    private static final LootCondition.Builder WITH_SHEARS = MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(Items.SHEARS));

    protected DinoBlockLootTableProvider(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateBlockLootTables() {
        this.addDrop(RegisterBlocks.LIVERWORTS, block -> multifaceGrowthDrops(block, WITH_SHEARS));
    }
}
