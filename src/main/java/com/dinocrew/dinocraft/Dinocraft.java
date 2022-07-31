package com.dinocrew.dinocraft;

import com.dinocrew.dinocraft.mixins.FoliagePlacerTypeInvoker;
import com.dinocrew.dinocraft.mixins.TrunkPlacerTypeInvoker;
import com.dinocrew.dinocraft.recipe.ModRecipeSerializer;
import com.dinocrew.dinocraft.registry.*;
import com.dinocrew.dinocraft.registry.blocks.ModBlockEntityTypes;
import com.dinocrew.dinocraft.screen.ModScreenHandlerTypes;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.frozenblock.api.minecraft.worldgen.trees.foliageplacers.DragonWoodFoliagePlacer;
import net.frozenblock.api.minecraft.worldgen.trees.trunkplacers.DragonWoodTrunkPlacer;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

public class Dinocraft implements ModInitializer {
    public static final String MOD_ID = "dinocraft";
    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(id("general"), () -> new ItemStack(ModItems.FOSSIL));

    public static Identifier identify(String id) {
        return new Identifier(MOD_ID + ":" + id);
    }

    public static final TrunkPlacerType<DragonWoodTrunkPlacer> DRAGONWOOD_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("dragonwood_trunk_placer", DragonWoodTrunkPlacer.CODEC);
    public static final FoliagePlacerType<DragonWoodFoliagePlacer> DRAGONWOOD_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("rich_foliage_placer", DragonWoodFoliagePlacer.CODEC);

    @Override
    public void onInitialize() {

        net.frozenblock.Main.runner(MOD_ID); // Run FrozenBlock stuff


        ModItems.registerAll();
        ModBlocks.registerAll();
        ModEntities.registerAll();
        ModSpawns.registerAll();
        ModFeatures.registerAll();
        ModBiomes.registerBiomes();
        ModScreenHandlerTypes.initialize();
        ModRecipeSerializer.initialize();
        ModBlockEntityTypes.initialize();
        // RegisterWorldgen.initialize();


    }

    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    }
}






