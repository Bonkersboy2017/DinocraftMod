package net.frozenblock.dinocraft.registry;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.registry.RegisterFeatures;
import com.dinocrew.dinocraft.registry.RegisterWorldgen;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.frozenblock.dinocraft.worldgen.features.BreakthoughRock;
import net.frozenblock.dinocraft.worldgen.features.BreakthroughPlants;
import net.frozenblock.dinocraft.worldgen.features.BreakthroughStones;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

public class RegisterConfiguredFeatures {

    public static final BreakthroughStones BT_STONE = new BreakthroughStones(ProbabilityFeatureConfiguration.CODEC);
    public static final BreakthoughRock BT_ROCK = new BreakthoughRock(ProbabilityFeatureConfiguration.CODEC);

    public static final ResourceKey<ConfiguredFeature<?, ?>> BT_STONE_CONFIGURED = RegisterFeatures.createKey("bt_stones");

    public static final ResourceKey<ConfiguredFeature<?, ?>> BT_ROCK_CONFIGURED = RegisterFeatures.createKey("bt_rock");

    public static final ResourceKey<PlacedFeature> BT_STONE_PLACED = RegisterFeatures.createPlacedKey("bt_stones_placed");
    public static final ResourceKey<PlacedFeature> BT_ROCK_PLACED = RegisterFeatures.createPlacedKey("bt_rock_placed");

    public static void init(String modid) {
        Registry.register(BuiltInRegistries.FEATURE, new ResourceLocation(modid, "breakthrough_stone"), BT_STONE);
        Registry.register(BuiltInRegistries.FEATURE, new ResourceLocation(modid, "breakthrough_rock"), BT_ROCK);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(RegisterWorldgen.BREAKTHROUGH),
                GenerationStep.Decoration.TOP_LAYER_MODIFICATION, BT_STONE_PLACED);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(RegisterWorldgen.BREAKTHROUGH),
                GenerationStep.Decoration.TOP_LAYER_MODIFICATION, BT_ROCK_PLACED);

        BreakthroughPlants.registerAll(modid);

    }

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        FeatureUtils.register(context,
                BT_STONE_CONFIGURED,
                BT_STONE,
                new ProbabilityFeatureConfiguration(0.8F)
        );

        FeatureUtils.register(context,
                BT_ROCK_CONFIGURED,
                BT_ROCK,
                new ProbabilityFeatureConfiguration(0.8F)
        );
    }

    public static void bootstrapPlaced(BootstapContext<PlacedFeature> context) {
        final var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        PlacementUtils.register(context,
                BT_STONE_PLACED,
                configuredFeatures.getOrThrow(BT_STONE_CONFIGURED),
                RarityFilter.onAverageOnceEvery(4),
                InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP,
                BiomeFilter.biome()
        );

        PlacementUtils.register(context,
                BT_ROCK_PLACED,
                configuredFeatures.getOrThrow(BT_ROCK_CONFIGURED),
                RarityFilter.onAverageOnceEvery(4),
                InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP,
                BiomeFilter.biome()
        );
    }

    private static ResourceKey<ConfiguredFeature<?, ?>> createKey(String key) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Dinocraft.id(key));
    }

    private static ResourceKey<PlacedFeature> createPlacedKey(String key) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Dinocraft.id(key));
    }
}
