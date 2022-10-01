package net.frozenblock.api.minecraft.worldgen.features;

import com.dinocrew.dinocraft.registry.RegisterBlocks;
import com.dinocrew.dinocraft.registry.RegisterWorldgen;
import com.mojang.serialization.Codec;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.MultifaceGrowthConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

public class BreakthroughPlants {

    public static final FernFeature BT_FERN = new FernFeature(ProbabilityFeatureConfiguration.CODEC);
    public static final CycadophytaFeature BT_CYCADOPHYTA = new CycadophytaFeature(ProbabilityFeatureConfiguration.CODEC);
    public static final CycadophytaFeature.EggFeature BT_EGG = new CycadophytaFeature.EggFeature(ProbabilityFeatureConfiguration.CODEC);

    public static final Holder<ConfiguredFeature<ProbabilityFeatureConfiguration, ?>> BT_FERN_CONFIGURED = FeatureUtils.register("bt_fern", BT_FERN, new ProbabilityFeatureConfiguration(0.1F));
    public static final Holder<ConfiguredFeature<MultifaceGrowthConfiguration, ?>> BT_LIVERWORTS_CONFIGURED = FeatureUtils.register(
            "bt_liverworts",
            Feature.MULTIFACE_GROWTH,
            new MultifaceGrowthConfiguration(
                    net.frozenblock.registry.RegisterBlocks.LIVERWORTS,
                    30,
                    true,
                    false,
                    true,
                    0.8F,
                    HolderSet.direct(
                            Block::builtInRegistryHolder,
                            RegisterBlocks.DRAGONGRASS,
                            RegisterBlocks.DRAGONWOOD_LOG,
                            Blocks.DIRT,
                            Blocks.STONE,
                            Blocks.ANDESITE,
                            Blocks.DIORITE,
                            Blocks.GRANITE,
                            Blocks.DRIPSTONE_BLOCK,
                            Blocks.CALCITE,
                            Blocks.TUFF,
                            Blocks.DEEPSLATE
                    )
            )
    );
    public static final Holder<ConfiguredFeature<ProbabilityFeatureConfiguration, ?>> BT_CYCADOPHYTA_CONFIGURED = FeatureUtils.register("bt_cycadophyta", BT_CYCADOPHYTA, new ProbabilityFeatureConfiguration(0.1F));
    public static final Holder<ConfiguredFeature<ProbabilityFeatureConfiguration, ?>> BT_EGG_CONFIGURED = FeatureUtils.register("bt_egg", BT_EGG, new ProbabilityFeatureConfiguration(0.1F));

    public static final Holder<PlacedFeature> BT_FERN_PLACED = PlacementUtils.register("bt_fern_placed", BT_FERN_CONFIGURED, RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    public static final Holder<PlacedFeature> BT_LIVERWORTS_PLACED = PlacementUtils.register("bt_liverworts_placed", BT_LIVERWORTS_CONFIGURED, RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    public static final Holder<PlacedFeature> BT_CYCADOPHYTA_PLACED = PlacementUtils.register("bt_cycadophyta_placed", BT_CYCADOPHYTA_CONFIGURED, RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    public static final Holder<PlacedFeature> BT_EGG_PLACED = PlacementUtils.register("bt_egg_placed", BT_EGG_CONFIGURED, RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());


    public static void registerAll(String modid) {
        Registry.register(Registry.FEATURE, new ResourceLocation(modid, "bt_fern"), BT_FERN);
        Registry.register(Registry.FEATURE, new ResourceLocation(modid, "bt_cycadophyta"), BT_CYCADOPHYTA);
        Registry.register(Registry.FEATURE, new ResourceLocation(modid, "bt_egg"), BT_EGG);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(RegisterWorldgen.BREAKTHROUGH),
                GenerationStep.Decoration.TOP_LAYER_MODIFICATION, BT_FERN_PLACED.unwrapKey().get());
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(RegisterWorldgen.BREAKTHROUGH),
                GenerationStep.Decoration.TOP_LAYER_MODIFICATION, BT_LIVERWORTS_PLACED.unwrapKey().get());
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(RegisterWorldgen.BREAKTHROUGH),
                GenerationStep.Decoration.TOP_LAYER_MODIFICATION, BT_CYCADOPHYTA_PLACED.unwrapKey().get());
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(RegisterWorldgen.BREAKTHROUGH),
                GenerationStep.Decoration.TOP_LAYER_MODIFICATION, BT_EGG_PLACED.unwrapKey().get());
    }

    private static void generate(FeaturePlaceContext<ProbabilityFeatureConfiguration> context, BlockState state) {
        WorldGenLevel world = context.level();
        BlockPos topPos = world.getHeightmapPos(Heightmap.Types.OCEAN_FLOOR_WG, context.origin());
        assert world.getBlockState(topPos).isAir();
        world.setBlock(topPos, state, 3);
    }

    private static class FernFeature extends Feature<ProbabilityFeatureConfiguration> {
        public FernFeature(Codec<ProbabilityFeatureConfiguration> configCodec) {
            super(configCodec);
        }

        @Override
        public boolean place(FeaturePlaceContext<ProbabilityFeatureConfiguration> context) {
            BreakthroughPlants.generate(context, Blocks.FERN.defaultBlockState());
            return true;
        }
    }

    private static class CycadophytaFeature extends Feature<ProbabilityFeatureConfiguration> {
        public CycadophytaFeature(Codec<ProbabilityFeatureConfiguration> configCodec) {
            super(configCodec);
        }


        @Override
        public boolean place(FeaturePlaceContext<ProbabilityFeatureConfiguration> context) {
            BreakthroughPlants.generate(context, net.frozenblock.registry.RegisterBlocks.CYCADOPHYTA.defaultBlockState());
            return true;
        }

        private static class EggFeature extends Feature<ProbabilityFeatureConfiguration> {
            public EggFeature(Codec<ProbabilityFeatureConfiguration> configCodec) {
                super(configCodec);
            }

            @Override
            public boolean place(FeaturePlaceContext<ProbabilityFeatureConfiguration> context) {
                BreakthroughPlants.generate(context, RegisterBlocks.INCUBATED_DINO_EGG.defaultBlockState());
                return true;
            }
        }
    }
}
