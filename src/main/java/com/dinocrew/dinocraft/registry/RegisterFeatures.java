package com.dinocrew.dinocraft.registry;

import com.dinocrew.dinocraft.Dinocraft;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.frozenblock.api.minecraft.worldgen.trees.foliageplacers.DragonWoodFoliagePlacer;
import net.frozenblock.api.minecraft.worldgen.trees.trunkplacers.DragonWoodTrunkPlacer;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.Arrays;

public final class RegisterFeatures {
    private static final ConfiguredFeature<?, ?> OVERWORLD_SKELETON_ORE_CONFIGURED_FEATURE = new ConfiguredFeature<>
            (Feature.ORE, new OreConfiguration(
                    OreFeatures.STONE_ORE_REPLACEABLES,
                    RegisterBlocks.SKELETON_ORE.defaultBlockState(),
                    9)); // vein size

    public static PlacedFeature OVERWORLD_SKELETON_ORE_PLACED_FEATURE = new PlacedFeature(
            Holder.direct(OVERWORLD_SKELETON_ORE_CONFIGURED_FEATURE),
            Arrays.asList(
                    CountPlacement.of(20), // number of veins per chunk
                    InSquarePlacement.spread(), // spreading horizontally
                    HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(64))));

    private static final ConfiguredFeature<?, ?> OVERWORLD_BRONZIUM_ORE_CONFIGURED_FEATURE = new ConfiguredFeature<>
            (Feature.ORE, new OreConfiguration(
                    OreFeatures.STONE_ORE_REPLACEABLES,
                    RegisterBlocks.BRONZIUM_ORE.defaultBlockState(),
                    9)); // vein size

    public static PlacedFeature OVERWORLD_BRONZIUM_ORE_PLACED_FEATURE = new PlacedFeature(
            Holder.direct(OVERWORLD_BRONZIUM_ORE_CONFIGURED_FEATURE),
            Arrays.asList(
                    CountPlacement.of(20), // number of veins per chunk
                    InSquarePlacement.spread(), // spreading horizontally
                    HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(64))));

    private static final ConfiguredFeature<?, ?> OVERWORLD_FOSSILISED_STONE_CONFIGURED_FEATURE = new ConfiguredFeature<>
            (Feature.ORE, new OreConfiguration(
                    OreFeatures.STONE_ORE_REPLACEABLES,
                    RegisterBlocks.FOSSILIZED_STONE.defaultBlockState(),
                    9)); // vein size

    public static PlacedFeature OVERWORLD_FOSSILISED_STONE_PLACED_FEATURE = new PlacedFeature(
            Holder.direct(OVERWORLD_FOSSILISED_STONE_CONFIGURED_FEATURE),
            Arrays.asList(
                    CountPlacement.of(20), // number of veins per chunk
                    InSquarePlacement.spread(), // spreading horizontally
                    HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(64))));

    private static final ConfiguredFeature<?, ?> OVERWORLD_AMBER_ORE_CONFIGURED_FEATURE = new ConfiguredFeature<>
            (Feature.ORE, new OreConfiguration(
                    OreFeatures.STONE_ORE_REPLACEABLES,
                    RegisterBlocks.AMBER_ORE.defaultBlockState(),
                    9)); // vein size

    public static PlacedFeature OVERWORLD_AMBER_ORE_PLACED_FEATURE = new PlacedFeature(
            Holder.direct(OVERWORLD_AMBER_ORE_CONFIGURED_FEATURE),
            Arrays.asList(
                    CountPlacement.of(20), // number of veins per chunk
                    InSquarePlacement.spread(), // spreading horizontally
                    HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(64))));

    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> DRAGONWOOD = FeatureUtils.register(
            "dragonwood",
            Feature.TREE,
            new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(RegisterBlocks.DRAGONWOOD_LOG),
                    new DragonWoodTrunkPlacer(3, 3, 0),
                    BlockStateProvider.simple(RegisterBlocks.DRAGONWOOD_LEAVES),
                    new DragonWoodFoliagePlacer(ConstantInt.of(1), ConstantInt.of(0)),
                    new TwoLayersFeatureSize(1, 0, 2)
            )
                    .ignoreVines()
                    .build()
    );

    public static final Holder<PlacedFeature> TREES_DRAGONWOOD = PlacementUtils.register(
            "trees_dragonwood",
            DRAGONWOOD,
            VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(1, 0.1f, 1),
                    Blocks.OAK_SAPLING)
    );

    private RegisterFeatures() {
    }


    public static void registerAll() {
        Registry.register(BuiltinRegistries.PLACED_FEATURE, Dinocraft.id("overworld_skeleton_ore"), OVERWORLD_SKELETON_ORE_PLACED_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.UNDERGROUND_ORES, ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY, Dinocraft.id("overworld_skeleton_ore")));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, Dinocraft.id("overworld_bronzium_ore"), OVERWORLD_BRONZIUM_ORE_CONFIGURED_FEATURE);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, Dinocraft.id("overworld_bronzium_ore"), OVERWORLD_BRONZIUM_ORE_PLACED_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.UNDERGROUND_ORES, ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY, Dinocraft.id("overworld_bronzium_ore")));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, Dinocraft.id("overworld_fossilised_stone"), OVERWORLD_FOSSILISED_STONE_PLACED_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.UNDERGROUND_ORES, ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY, Dinocraft.id("overworld_fossilised_stone")));

        Registry.register(BuiltinRegistries.PLACED_FEATURE, Dinocraft.id("overworld_amber_ore"), OVERWORLD_AMBER_ORE_PLACED_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.UNDERGROUND_ORES, ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY, Dinocraft.id("overworld_amber_ore")));
    }
}