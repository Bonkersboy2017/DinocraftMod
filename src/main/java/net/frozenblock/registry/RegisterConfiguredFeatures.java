package net.frozenblock.registry;

import com.dinocrew.dinocraft.registry.ModBiomes;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.frozenblock.api.minecraft.worldgen.features.BreakthoughRock;
import net.frozenblock.api.minecraft.worldgen.features.BreakthroughPlants;
import net.frozenblock.api.minecraft.worldgen.features.BreakthroughStones;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

public class RegisterConfiguredFeatures {

    public static final BreakthroughStones BT_STONE = new BreakthroughStones(ProbabilityConfig.CODEC);
    public static final BreakthoughRock BT_ROCK = new BreakthoughRock(ProbabilityConfig.CODEC);

    public static final RegistryEntry<ConfiguredFeature<ProbabilityConfig, ?>> BT_STONE_CONFIGURED = ConfiguredFeatures.register("bt_stones",
            BT_STONE, new ProbabilityConfig(0.8F));

    public static final RegistryEntry<ConfiguredFeature<ProbabilityConfig, ?>> BT_ROCK_CONFIGURED = ConfiguredFeatures.register("bt_rock",
            BT_ROCK, new ProbabilityConfig(0.8F));

    public static final RegistryEntry<PlacedFeature> BT_STONE_PLACED = PlacedFeatures.register("bt_stones_placed",
            BT_STONE_CONFIGURED, RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
    public static final RegistryEntry<PlacedFeature> BT_ROCK_PLACED = PlacedFeatures.register("bt_rock_placed",
            BT_ROCK_CONFIGURED, RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    public static void init(String modid) {
        Registry.register(Registry.FEATURE, new Identifier(modid, "breakthrough_stone"), BT_STONE);
        Registry.register(Registry.FEATURE, new Identifier(modid, "breakthrough_rock"), BT_ROCK);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.BREAKTHHROUGH_KEY),
                GenerationStep.Feature.TOP_LAYER_MODIFICATION, BT_STONE_PLACED.getKey().get());
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.BREAKTHHROUGH_KEY),
                GenerationStep.Feature.TOP_LAYER_MODIFICATION, BT_ROCK_PLACED.getKey().get());

        BreakthroughPlants.registerAll(modid);

    }
}
