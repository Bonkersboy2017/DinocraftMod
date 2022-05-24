package net.frozenblock.api.minecraft.worldgen.features;

import com.dinocrew.dinocraft.registry.ModBiomes;
import com.mojang.serialization.Codec;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.frozenblock.registry.RegisterBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.Heightmap;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

public class BreakthroughPlants {

    public static final FernFeature BT_FERN = new FernFeature(ProbabilityConfig.CODEC);
    public static final LiverWortsFeature BT_LIVERWORTS = new LiverWortsFeature(ProbabilityConfig.CODEC);
    public static final CycadophytaFeature BT_CYCADOPHYTA = new CycadophytaFeature(ProbabilityConfig.CODEC);

    public static final RegistryEntry<ConfiguredFeature<ProbabilityConfig, ?>> BT_FERN_CONFIGURED = ConfiguredFeatures.register("bt_fern", BT_FERN, new ProbabilityConfig(0.1F));
    public static final RegistryEntry<ConfiguredFeature<ProbabilityConfig, ?>> BT_LIVERWORTS_CONFIGURED = ConfiguredFeatures.register("bt_liverworts", BT_LIVERWORTS, new ProbabilityConfig(0.1F));
    public static final RegistryEntry<ConfiguredFeature<ProbabilityConfig, ?>> BT_CYCADOPHYTA_CONFIGURED = ConfiguredFeatures.register("bt_cycadophyta", BT_CYCADOPHYTA, new ProbabilityConfig(0.1F));

    public static final RegistryEntry<PlacedFeature> BT_FERN_PLACED = PlacedFeatures.register("bt_fern_placed", BT_FERN_CONFIGURED, RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
    public static final RegistryEntry<PlacedFeature> BT_LIVERWORTS_PLACED = PlacedFeatures.register("bt_liverworts_placed", BT_LIVERWORTS_CONFIGURED, RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
    public static final RegistryEntry<PlacedFeature> BT_CYCADOPHYTA_PLACED = PlacedFeatures.register("bt_cycadophyta_placed", BT_CYCADOPHYTA_CONFIGURED, RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    public static void registerAll(String modid) {
        Registry.register(Registry.FEATURE, new Identifier(modid, "bt_fern"), BT_FERN);
        Registry.register(Registry.FEATURE, new Identifier(modid, "bt_liverworts"), BT_LIVERWORTS);
        Registry.register(Registry.FEATURE, new Identifier(modid, "bt_cycadophyta"), BT_CYCADOPHYTA);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.BREAKTHHROUGH_KEY),
                GenerationStep.Feature.TOP_LAYER_MODIFICATION, BT_FERN_PLACED.getKey().get());
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.BREAKTHHROUGH_KEY),
                GenerationStep.Feature.TOP_LAYER_MODIFICATION, BT_LIVERWORTS_PLACED.getKey().get());
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.BREAKTHHROUGH_KEY),
                GenerationStep.Feature.TOP_LAYER_MODIFICATION, BT_CYCADOPHYTA_PLACED.getKey().get());
    }

    private static void generate(FeatureContext<ProbabilityConfig> context, BlockState state) {
        StructureWorldAccess world = context.getWorld();
        BlockPos topPos = world.getTopPosition(Heightmap.Type.OCEAN_FLOOR_WG, context.getOrigin());
        assert world.getBlockState(topPos).isAir();
        world.setBlockState(topPos, state, 3);
    }

    private static class FernFeature extends Feature<ProbabilityConfig> {
        public FernFeature(Codec<ProbabilityConfig> configCodec) {
            super(configCodec);
        }
        @Override
        public boolean generate(FeatureContext<ProbabilityConfig> context) {
            BreakthroughPlants.generate(context, Blocks.FERN.getDefaultState());
            return true;
        }
    }
    private static class LiverWortsFeature extends Feature<ProbabilityConfig> {
        public LiverWortsFeature(Codec<ProbabilityConfig> configCodec) {
            super(configCodec);
        }
        @Override
        public boolean generate(FeatureContext<ProbabilityConfig> context) {
            BreakthroughPlants.generate(context, RegisterBlocks.LIVERWORTS.getDefaultState());
            return true;
        }
    }
    private static class CycadophytaFeature extends Feature<ProbabilityConfig> {
        public CycadophytaFeature(Codec<ProbabilityConfig> configCodec) {
            super(configCodec);
        }
        @Override
        public boolean generate(FeatureContext<ProbabilityConfig> context) {
            BreakthroughPlants.generate(context, RegisterBlocks.CYCADOPHYTA.getDefaultState());
            return true;
        }
    }
}
