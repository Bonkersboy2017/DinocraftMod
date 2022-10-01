package com.dinocrew.dinocraft;

import com.dinocrew.dinocraft.mixins.FoliagePlacerTypeInvoker;
import com.dinocrew.dinocraft.mixins.TrunkPlacerTypeInvoker;
import com.dinocrew.dinocraft.recipe.ModRecipeSerializer;
import com.dinocrew.dinocraft.registry.*;
import com.dinocrew.dinocraft.registry.blocks.ModBlockEntityTypes;
import com.dinocrew.dinocraft.registry.enchantments.EnchantmentRegistry;
import com.dinocrew.dinocraft.registry.worldgen.RegisterWorldgen;
import com.dinocrew.dinocraft.screen.ModScreenHandlerTypes;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.frozenblock.api.minecraft.worldgen.trees.foliageplacers.DragonWoodFoliagePlacer;
import net.frozenblock.api.minecraft.worldgen.trees.trunkplacers.DragonWoodTrunkPlacer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.nio.file.Path;

public class Dinocraft implements ModInitializer {
    public static final String MOD_ID = "dinocraft";
    public static final CreativeModeTab ITEM_GROUP = FabricItemGroupBuilder.build(id("general"), () -> new ItemStack(ModItems.FOSSIL));

    public static ResourceLocation identify(String id) {
        return new ResourceLocation(MOD_ID + ":" + id);
    }

    public static boolean areConfigsInit = false;

    public static boolean hasCloth = FabricLoader.getInstance().isModLoaded("cloth-config");

    public static final Path CONFIG_PATH = FabricLoader.getInstance().getConfigDir().resolve("dinocraft.json");

    public static final TrunkPlacerType<DragonWoodTrunkPlacer> DRAGONWOOD_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("dragonwood_trunk_placer", DragonWoodTrunkPlacer.CODEC);
    public static final FoliagePlacerType<DragonWoodFoliagePlacer> DRAGONWOOD_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("rich_foliage_placer", DragonWoodFoliagePlacer.CODEC);

    @Override
    public void onInitialize() {
        net.frozenblock.Main.runner(MOD_ID); // Run FrozenBlock stuff


        ModItems.registerAll();
        ModBlocks.registerAll();
        ModEntities.registerAll();
        EnchantmentRegistry.init();
        ModSpawns.registerAll();
        ModFeatures.registerAll();
        ModBiomes.registerBiomes();
        ModScreenHandlerTypes.initialize();
        ModRecipeSerializer.initialize();
        ModBlockEntityTypes.initialize();
        RegisterSounds.init();
        RegisterWorldgen.initialize();


    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}






