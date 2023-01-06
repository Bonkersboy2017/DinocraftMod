package com.dinocrew.dinocraft.registry;

import com.dinocrew.dinocraft.Dinocraft;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.frozenblock.dinocraft.worldgen.trees.foliageplacers.DragonWoodFoliagePlacer;
import net.frozenblock.dinocraft.worldgen.trees.trunkplacers.DragonWoodTrunkPlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
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
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

public final class RegisterFeatures {

    private static final ResourceKey<ConfiguredFeature<?, ?>> ORE_SKELETON_CONFIGURED = createKey("ore_skeleton");

    public static ResourceKey<PlacedFeature> ORE_SKELETON_PLACED = createPlacedKey("ore_skeleton");

    private static final ResourceKey<ConfiguredFeature<?, ?>> ORE_BRONZIUM_CONFIGURED = createKey("ore_bronzium");

    public static ResourceKey<PlacedFeature> ORE_BRONZIUM_PLACED = createPlacedKey("ore_bronzium");

    private static final ResourceKey<ConfiguredFeature<?, ?>> ORE_FOSSILIZED_STONE_CONFIGURED = createKey("ore_fossilized_stone");

    public static ResourceKey<PlacedFeature> ORE_FOSSILIZED_STONE_PLACED = createPlacedKey("ore_fossilized_stone");

    private static final ResourceKey<ConfiguredFeature<?, ?>> ORE_AMBER_CONFIGURED = createKey("ore_amber");

    public static ResourceKey<PlacedFeature> ORE_AMBER_PLACED = createPlacedKey("ore_amber");

    public static final ResourceKey<ConfiguredFeature<?, ?>> DRAGONWOOD = createKey("dragonwood");

    public static final ResourceKey<PlacedFeature> TREES_DRAGONWOOD = createPlacedKey("trees_dragonwood");

    private RegisterFeatures() {
        throw new UnsupportedOperationException("RegisterFeatures contains only static declarations.");
    }


    public static void registerAll() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.UNDERGROUND_ORES, ORE_SKELETON_PLACED);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.UNDERGROUND_ORES, ORE_BRONZIUM_PLACED);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.UNDERGROUND_ORES, ORE_FOSSILIZED_STONE_PLACED);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.UNDERGROUND_ORES, ORE_AMBER_PLACED);
    }

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        final RuleTest stoneOreReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);

        FeatureUtils.register(context,
                ORE_SKELETON_CONFIGURED,
                Feature.ORE,
                new OreConfiguration(
                        stoneOreReplaceables,
                        RegisterBlocks.SKELETON_ORE.defaultBlockState(),
                        9 // vein size
                )
        );

        FeatureUtils.register(context,
                ORE_BRONZIUM_CONFIGURED,
                Feature.ORE,
                new OreConfiguration(
                        stoneOreReplaceables,
                        RegisterBlocks.BRONZIUM_ORE.defaultBlockState(),
                        9 // vein size
                )
        );

        FeatureUtils.register(context,
                ORE_FOSSILIZED_STONE_CONFIGURED,
                Feature.ORE,
                new OreConfiguration(
                        stoneOreReplaceables,
                        RegisterBlocks.FOSSILIZED_STONE.defaultBlockState(),
                        9) // vein size
        );

        FeatureUtils.register(context,
                ORE_AMBER_CONFIGURED,
                Feature.ORE, new OreConfiguration(
                        stoneOreReplaceables,
                        RegisterBlocks.AMBER_ORE.defaultBlockState(),
                        9 // vein size
                )
        );

        FeatureUtils.register(context,
                DRAGONWOOD,
                Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(RegisterBlocks.DRAGONWOOD_LOG),
                        new DragonWoodTrunkPlacer(3, 3, 0),
                        BlockStateProvider.simple(RegisterBlocks.DRAGONWOOD_LEAVES),
                        new DragonWoodFoliagePlacer(ConstantInt.of(1), ConstantInt.of(0)),
                        new TwoLayersFeatureSize(1, 0, 2)
                ).ignoreVines().build()
        );
    }

    public static void bootstrapPlaced(BootstapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        PlacementUtils.register(context,
                ORE_SKELETON_PLACED,
                configuredFeatures.getOrThrow(ORE_SKELETON_CONFIGURED),
                CountPlacement.of(20), // number of veins per chunk
                InSquarePlacement.spread(), // spreading horizontally
                HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(64))
        );

        PlacementUtils.register(context,
                ORE_BRONZIUM_PLACED,
                configuredFeatures.getOrThrow(ORE_BRONZIUM_CONFIGURED),
                CountPlacement.of(20), // number of veins per chunk
                InSquarePlacement.spread(), // spreading horizontally
                HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(64))
        );

        PlacementUtils.register(context,
                ORE_FOSSILIZED_STONE_PLACED,
                configuredFeatures.getOrThrow(ORE_FOSSILIZED_STONE_CONFIGURED),
                CountPlacement.of(20), // number of veins per chunk
                InSquarePlacement.spread(), // spreading horizontally
                HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(64))
        );

        PlacementUtils.register(context,
                ORE_AMBER_PLACED,
                configuredFeatures.getOrThrow(ORE_AMBER_CONFIGURED),
                CountPlacement.of(20), // number of veins per chunk
                InSquarePlacement.spread(), // spreading horizontally
                HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(64))
        );

        PlacementUtils.register(context,
                TREES_DRAGONWOOD,
                configuredFeatures.getOrThrow(DRAGONWOOD),
                VegetationPlacements.treePlacement(
                        PlacementUtils.countExtra(1, 0.1f, 1),
                        Blocks.OAK_SAPLING
                )
        );
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String key) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Dinocraft.id(key));
    }

    public static ResourceKey<PlacedFeature> createPlacedKey(String key) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Dinocraft.id(key));
    }
}