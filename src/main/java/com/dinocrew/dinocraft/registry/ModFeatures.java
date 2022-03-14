package com.dinocrew.dinocraft.registry;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.OreBlock;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.CountPlacementModifier;
import net.minecraft.world.gen.decorator.HeightRangePlacementModifier;
import net.minecraft.world.gen.decorator.SquarePlacementModifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;


public class ModFeatures {
    private static final ConfiguredFeature<?, ?> OVERWORLD_SKELETON_ORE_CONFIGURED_FEATURE = Feature.ORE.configure(new OreFeatureConfig(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.SKELETON_ORE.getDefaultState(), 9));
    public static PlacedFeature OVERWORLD_SKELETON_ORE_PLACED_FEATURE = OVERWORLD_SKELETON_ORE_CONFIGURED_FEATURE.withPlacement(CountPlacementModifier.of(20), SquarePlacementModifier.of(),HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64)));
    private static final ConfiguredFeature<?, ?> OVERWORLD_BRONZIUM_ORE_CONFIGURED_FEATURE = Feature.ORE.configure(new OreFeatureConfig(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.BRONZIUM_ORE.getDefaultState(), 9));
    public static PlacedFeature OVERWORLD_BRONZIUM_ORE_PLACED_FEATURE = OVERWORLD_BRONZIUM_ORE_CONFIGURED_FEATURE.withPlacement(CountPlacementModifier.of(20), SquarePlacementModifier.of(), HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64)));
    private static final ConfiguredFeature<?, ?> OVERWORLD_FOSSILISED_STONE_CONFIGURED_FEATURE = Feature.ORE.configure(new OreFeatureConfig(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.FOSSILIZED_STONE.getDefaultState(), 9));
    public static PlacedFeature OVERWORLD_FOSSILISED_STONE_PLACED_FEATURE = OVERWORLD_FOSSILISED_STONE_CONFIGURED_FEATURE.withPlacement(CountPlacementModifier.of(20), SquarePlacementModifier.of(), HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64)));

    public static void registerAll() {
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("dinocraft", "overworld_skeleton_ore"), OVERWORLD_SKELETON_ORE_PLACED_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("dinocraft", "overworld_skeleton_ore")));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier("dinocraft", "overworld_bronzium_ore"), OVERWORLD_BRONZIUM_ORE_CONFIGURED_FEATURE);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("dinocraft", "overworld_bronzium_ore"), OVERWORLD_BRONZIUM_ORE_PLACED_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("dinocraft", "overworld_bronzium_ore")));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("dinocraft", "overworld_fossilised_stone"), OVERWORLD_FOSSILISED_STONE_PLACED_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("dinocraft", "overworld_fossilised_stone")));
    }
}

