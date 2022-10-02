package net.frozenblock.registry;

import com.dinocrew.dinocraft.registry.RegisterFeatures;
import com.dinocrew.dinocraft.registry.RegisterWorldgen;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.frozenblock.api.minecraft.worldgen.features.BreakthoughRock;
import net.frozenblock.api.minecraft.worldgen.features.BreakthroughPlants;
import net.frozenblock.api.minecraft.worldgen.features.BreakthroughStones;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
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

    public static final Holder<ConfiguredFeature<ProbabilityFeatureConfiguration, ?>> BT_STONE_CONFIGURED = RegisterFeatures.registerConfigured("bt_stones",
            BT_STONE, new ProbabilityFeatureConfiguration(0.8F));

    public static final Holder<ConfiguredFeature<ProbabilityFeatureConfiguration, ?>> BT_ROCK_CONFIGURED = RegisterFeatures.registerConfigured("bt_rock",
            BT_ROCK, new ProbabilityFeatureConfiguration(0.8F));

    public static final Holder<PlacedFeature> BT_STONE_PLACED = RegisterFeatures.registerPlaced("bt_stones_placed",
            BT_STONE_CONFIGURED, RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    public static final Holder<PlacedFeature> BT_ROCK_PLACED = RegisterFeatures.registerPlaced("bt_rock_placed",
            BT_ROCK_CONFIGURED, RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(),
            PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

    public static void init(String modid) {
        Registry.register(Registry.FEATURE, new ResourceLocation(modid, "breakthrough_stone"), BT_STONE);
        Registry.register(Registry.FEATURE, new ResourceLocation(modid, "breakthrough_rock"), BT_ROCK);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(RegisterWorldgen.BREAKTHROUGH),
                GenerationStep.Decoration.TOP_LAYER_MODIFICATION, BT_STONE_PLACED.unwrapKey().orElseThrow());
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(RegisterWorldgen.BREAKTHROUGH),
                GenerationStep.Decoration.TOP_LAYER_MODIFICATION, BT_ROCK_PLACED.unwrapKey().orElseThrow());

        BreakthroughPlants.registerAll(modid);

    }
}
