package com.dinocrew.dinocraft.registry;

import com.dinocrew.dinocraft.Dinocraft;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.frozenblock.api.minecraft.worldgen.features.BreakthroughStones;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;

import java.util.Arrays;

public class ModFeatures {
    private static ConfiguredFeature<?, ?> OVERWORLD_SKELETON_ORE_CONFIGURED_FEATURE = new ConfiguredFeature
            (Feature.ORE, new OreFeatureConfig(
                    OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
                    ModBlocks.SKELETON_ORE.getDefaultState(),
                    9)); // vein size

    public static PlacedFeature OVERWORLD_SKELETON_ORE_PLACED_FEATURE = new PlacedFeature(
            RegistryEntry.of(OVERWORLD_SKELETON_ORE_CONFIGURED_FEATURE),
            Arrays.asList(
                    CountPlacementModifier.of(20), // number of veins per chunk
                    SquarePlacementModifier.of(), // spreading horizontally
                    HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64))));

    private static ConfiguredFeature<?, ?> OVERWORLD_BRONZIUM_ORE_CONFIGURED_FEATURE = new ConfiguredFeature
            (Feature.ORE, new OreFeatureConfig(
                    OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
                    ModBlocks.BRONZIUM_ORE.getDefaultState(),
                    9)); // vein size

    public static PlacedFeature OVERWORLD_BRONZIUM_ORE_PLACED_FEATURE = new PlacedFeature(
            RegistryEntry.of(OVERWORLD_BRONZIUM_ORE_CONFIGURED_FEATURE),
            Arrays.asList(
                    CountPlacementModifier.of(20), // number of veins per chunk
                    SquarePlacementModifier.of(), // spreading horizontally
                    HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64))));

    private static ConfiguredFeature<?, ?> OVERWORLD_FOSSILISED_STONE_CONFIGURED_FEATURE = new ConfiguredFeature
            (Feature.ORE, new OreFeatureConfig(
                    OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
                    ModBlocks.FOSSILIZED_STONE.getDefaultState(),
                    9)); // vein size

    public static PlacedFeature OVERWORLD_FOSSILISED_STONE_PLACED_FEATURE = new PlacedFeature(
            RegistryEntry.of(OVERWORLD_FOSSILISED_STONE_CONFIGURED_FEATURE),
            Arrays.asList(
                    CountPlacementModifier.of(20), // number of veins per chunk
                    SquarePlacementModifier.of(), // spreading horizontally
                    HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64))));

    private static ConfiguredFeature<?, ?> OVERWORLD_AMBER_ORE_CONFIGURED_FEATURE = new ConfiguredFeature
            (Feature.ORE, new OreFeatureConfig(
                    OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
                    ModBlocks.AMBER_ORE.getDefaultState(),
                    9)); // vein size

    public static PlacedFeature OVERWORLD_AMBER_ORE_PLACED_FEATURE = new PlacedFeature(
            RegistryEntry.of(OVERWORLD_AMBER_ORE_CONFIGURED_FEATURE),
            Arrays.asList(
                    CountPlacementModifier.of(20), // number of veins per chunk
                    SquarePlacementModifier.of(), // spreading horizontally
                    HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64))));




    public static void registerAll() {
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(Dinocraft.MOD_ID, "overworld_skeleton_ore"), OVERWORLD_SKELETON_ORE_PLACED_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("dinocraft", "overworld_skeleton_ore")));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Dinocraft.MOD_ID, "overworld_bronzium_ore"), OVERWORLD_BRONZIUM_ORE_CONFIGURED_FEATURE);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(Dinocraft.MOD_ID, "overworld_bronzium_ore"), OVERWORLD_BRONZIUM_ORE_PLACED_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("dinocraft", "overworld_bronzium_ore")));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(Dinocraft.MOD_ID, "overworld_fossilised_stone"), OVERWORLD_FOSSILISED_STONE_PLACED_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("dinocraft", "overworld_fossilised_stone")));

        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(Dinocraft.MOD_ID, "overworld_amber_ore"), OVERWORLD_AMBER_ORE_PLACED_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("dinocraft", "overworld_amber_ore")));
    }
}