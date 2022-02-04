package com.dinocrew.dinocraft;

import com.dinocrew.dinocraft.registry.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class Dinocraft implements ModInitializer {
    public static final String MOD_ID = "dinocraft";
    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "general"), () -> new ItemStack(ModItems.FOSSIL));


    @Override
    public void onInitialize() {
        ModItems.registerAll();
        ModBlocks.registerAll();
        ModEntities.registerAll();
        ModSpawns.registerAll();
        ModFeatures.registerAll();
    }
}
    

       // RegisterWorldgen.RegisterWorldgen();
//
//        Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, new Identifier("breakthrough", "dinocraft"), BREAKTHROUGH_SURFACE_BUILDER);
//        Registry.register(BuiltinRegistries.BIOME, BREAKTHROUGH_KEY.getValue(), BREAKTHROUGH);
//        OverworldBiomes.addContinentalBiome(BREAKTHROUGH_KEY, OverworldClimate.TEMPERATE, 2D);
//        OverworldBiomes.addContinentalBiome(BREAKTHROUGH_KEY, OverworldClimate.COOL, 2D);
//        RegistryKey<ConfiguredFeature<?, ?>> dragonwoodTree = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("dinocraft", "dragonwood_tree"));
//
//        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, dragonwoodTree.getValue(), DRAGONWOOD_TREE);
//
//        // You should use the VEGETAL_DECORATION generation step for trees
//        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.VEGETAL_DECORATION, dragonwoodTree);
//
//    }
//
//
//    private static final ConfiguredSurfaceBuilder<TernarySurfaceConfig> BREAKTHROUGH_SURFACE_BUILDER = SurfaceBuilder.DEFAULT
//            .withConfig(new TernarySurfaceConfig(
//                    ModBlocks.DRAGONGRASS.getDefaultState(),
//                    Blocks.DIRT.getDefaultState(),
//                    Blocks.STONE.getDefaultState()));
//
//    public static void addBreakthroughFeatures(GenerationSettings.Builder builder) {
//        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, Dinocraft.DRAGONWOOD_TREE);
//    }
//
//    private static final Biome BREAKTHROUGH = createBreakthrough();
//
//    private static Biome createBreakthrough() {
//        // We specify what entities spawn and what features generate in the biome .
//        // Aside from some structures, trees, rocks, plants and
//        // custom entities, these are mostly the same for each biome .
//        // Vanilla configured features for biomes are defined in DefaultBiomeFeatures.
//
//        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
//        DefaultBiomeFeatures.addFarmAnimals(spawnSettings);
//        DefaultBiomeFeatures.addMonsters(spawnSettings, 95, 5, 100);
//        GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();
//        generationSettings.surfaceBuilder(BREAKTHROUGH_SURFACE_BUILDER);
//        DefaultBiomeFeatures.addDefaultUndergroundStructures(generationSettings);
//        DefaultBiomeFeatures.addLandCarvers(generationSettings);
//        DefaultBiomeFeatures.addDefaultLakes(generationSettings);
//        DefaultBiomeFeatures.addDungeons(generationSettings);
//        DefaultBiomeFeatures.addMineables(generationSettings);
//        DefaultBiomeFeatures.addDefaultOres(generationSettings);
//        DefaultBiomeFeatures.addDefaultDisks(generationSettings);
//        DefaultBiomeFeatures.addSprings(generationSettings);
//        DefaultBiomeFeatures.addFrozenTopLayer(generationSettings);
//        Dinocraft.addBreakthroughFeatures(generationSettings);
//
//        return (new Biome.Builder())
//                .precipitation(Biome.Precipitation.RAIN)
//                .category(Biome.Category.NONE)
//                .depth(0.125F)
//                .scale(0.05F)
//                .temperature(0.8F)
//                .downfall(0.4F)
//                .effects((new BiomeEffects.Builder())
//                        .waterColor(0xA62D74)
//                        .waterFogColor(0xA62D74)
//                        .fogColor(0xFBC1E3)
//                        .skyColor(0xFBC1E3)
//                        .build())
//                .spawnSettings(spawnSettings.build())
//                .generationSettings(generationSettings.build())
//                .build();
//    }
//
//    public static final RegistryKey<Biome> BREAKTHROUGH_KEY = RegistryKey.of(Registry.BIOME_KEY, new Identifier("dinocraft", "breakthrough"));

//    public static final ConfiguredFeature<?, ?> DRAGONWOOD_TREE = Feature.TREE
//            // Configure the feature using the builder
//            .configure(new TreeFeatureConfig.Builder(
//                    new SimpleBlockStateProvider(ModBlocks.DRAGONWOOD_LOG.getDefaultState()), // Trunk block provider
//                    new StraightTrunkPlacer(8, 3, 0), // places a straight trunk
//                    new SimpleBlockStateProvider(ModBlocks.DRAGONWOOD_LEAVES.getDefaultState()), // Foliage block provider
//                    new SimpleBlockStateProvider(ModBlocks.DRAGONWOOD_SAPLING.getDefaultState()), // Sapling provider; used to determine what blocks the tree can generate on
//                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3), // places leaves as a blob (radius, offset from trunk, height)
//                    new TwoLayersFeatureSize(1, 0, 1) // The width of the tree at different layers; used to see how tall the tree can be without clipping into blocks
//            ).build())
//            .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.OCEAN_FLOOR)))
//            .decorate(Decorator.ICEBERG.configure(new NopeDecoratorConfig()))
//            .decorate(Decorator.WATER_DEPTH_THRESHOLD.configure(new WaterDepthThresholdDecoratorConfig(5))); // About a 33% chance to generate per chunk (1/x)
//    }






