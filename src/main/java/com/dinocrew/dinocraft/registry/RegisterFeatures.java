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
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.*;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public final class RegisterFeatures {
    private static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_SKELETON_CONFIGURED = registerConfigured("ore_skeleton",
            Feature.ORE, new OreConfiguration(
                    OreFeatures.STONE_ORE_REPLACEABLES,
                    RegisterBlocks.SKELETON_ORE.defaultBlockState(),
                    9) // vein size
    );

    public static Holder<PlacedFeature> ORE_SKELETON_PLACED = registerPlaced("ore_skeleton",
            ORE_SKELETON_CONFIGURED,
            CountPlacement.of(20), // number of veins per chunk
            InSquarePlacement.spread(), // spreading horizontally
            HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(64))
    );

    private static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_BRONZIUM_CONFIGURED = registerConfigured("ore_bronzium",
            Feature.ORE, new OreConfiguration(
                    OreFeatures.STONE_ORE_REPLACEABLES,
                    RegisterBlocks.BRONZIUM_ORE.defaultBlockState(),
                    9) // vein size
    );

    public static Holder<PlacedFeature> ORE_BRONZIUM_PLACED = registerPlaced("ore_bronzium",
            ORE_BRONZIUM_CONFIGURED,
            CountPlacement.of(20), // number of veins per chunk
            InSquarePlacement.spread(), // spreading horizontally
            HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(64))
    );

    private static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_FOSSILIZED_STONE_CONFIGURED = registerConfigured("ore_fossilized_stone",
            Feature.ORE, new OreConfiguration(
                    OreFeatures.STONE_ORE_REPLACEABLES,
                    RegisterBlocks.FOSSILIZED_STONE.defaultBlockState(),
                    9) // vein size
    );

    public static Holder<PlacedFeature> ORE_FOSSILIZED_STONE_PLACED = registerPlaced("ore_fossilized_stone",
            ORE_FOSSILIZED_STONE_CONFIGURED,
            CountPlacement.of(20), // number of veins per chunk
            InSquarePlacement.spread(), // spreading horizontally
            HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(64))
    );

    private static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_AMBER_CONFIGURED = registerConfigured("ore_amber",
            Feature.ORE, new OreConfiguration(
                    OreFeatures.STONE_ORE_REPLACEABLES,
                    RegisterBlocks.AMBER_ORE.defaultBlockState(),
                    9) // vein size
    );

    public static Holder<PlacedFeature> ORE_AMBER_PLACED = registerPlaced("ore_amber",
            ORE_AMBER_CONFIGURED,
            CountPlacement.of(20), // number of veins per chunk
            InSquarePlacement.spread(), // spreading horizontally
            HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(64))
    );

    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> DRAGONWOOD = registerConfigured(
            "dragonwood",
            Feature.TREE,
            new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(RegisterBlocks.DRAGONWOOD_LOG),
                    new DragonWoodTrunkPlacer(3, 3, 0),
                    BlockStateProvider.simple(RegisterBlocks.DRAGONWOOD_LEAVES),
                    new DragonWoodFoliagePlacer(ConstantInt.of(1), ConstantInt.of(0)),
                    new TwoLayersFeatureSize(1, 0, 2)
            ).ignoreVines().build()
    );

    public static final Holder<PlacedFeature> TREES_DRAGONWOOD = registerPlaced(
            "trees_dragonwood",
            DRAGONWOOD,
            VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(1, 0.1f, 1),
                    Blocks.OAK_SAPLING)
    );

    private RegisterFeatures() {
    }


    public static void registerAll() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.UNDERGROUND_ORES, ORE_SKELETON_PLACED.unwrapKey().orElseThrow());
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.UNDERGROUND_ORES, ORE_BRONZIUM_PLACED.unwrapKey().orElseThrow());
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.UNDERGROUND_ORES, ORE_FOSSILIZED_STONE_PLACED.unwrapKey().orElseThrow());
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.UNDERGROUND_ORES, ORE_AMBER_PLACED.unwrapKey().orElseThrow());
    }

    public static Holder<PlacedFeature> registerPlaced(@NotNull String id, Holder<? extends ConfiguredFeature<?, ?>> registryEntry, @NotNull List<PlacementModifier> modifiers) {
        return BuiltinRegistries.register(BuiltinRegistries.PLACED_FEATURE, Dinocraft.id(id), new PlacedFeature(Holder.hackyErase(registryEntry), List.copyOf(modifiers)));
    }

    public static Holder<PlacedFeature> registerPlaced(@NotNull String id, Holder<? extends ConfiguredFeature<?, ?>> registryEntry, @NotNull PlacementModifier... modifiers) {
        return registerPlaced(id, registryEntry, List.of(modifiers));
    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>> Holder<ConfiguredFeature<FC, ?>> registerConfigured(@NotNull String id, F feature, @NotNull FC config) {
        return registerExact(BuiltinRegistries.CONFIGURED_FEATURE, id, new ConfiguredFeature<>(feature, config));
    }

    public static <V extends T, T> Holder<V> registerExact(Registry<T> registry, String id, V value) {
        return (Holder<V>) BuiltinRegistries.register(registry, Dinocraft.id(id), value);
    }
}