package com.dinocrew.dinocraft;

import com.dinocrew.dinocraft.registry.*;
import com.dinocrew.dinocraft.registry.entities.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.CountPlacementModifier;
import net.minecraft.world.gen.decorator.HeightRangePlacementModifier;
import net.minecraft.world.gen.decorator.SquarePlacementModifier;
import net.minecraft.world.gen.feature.*;

public class Dinocraft implements ModInitializer {

    public static Identifier getID(String path) {
        return new Identifier(MOD_ID, path);
    }


    public static final String MOD_ID = "dm";

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
            new Identifier(MOD_ID, "general"),
            () -> new ItemStack(ModItems.FOSSIL));

    public static final EntityType<SauropodEntity> SAUROPOD = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("dinocraft", "sauropod"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SauropodEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
    );

    public static final EntityType<TheropodEntity> THEROPOD = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("dinocraft", "theropod"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, TheropodEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
    );

    public static final EntityType<TroodonEntity> TROODON = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("dinocraft", "troodon"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, TroodonEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
    );

    public static final EntityType<MicroraptorEntity> MICORAPTOR = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("dinocraft", "micoraptor"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MicroraptorEntity::new).dimensions(EntityDimensions.fixed(1.5f, 2.5f)).build()
    );

    public static final EntityType<MosasaurusEntity> MOSASAURUS = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("dinocraft", "mosasaurus"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MosasaurusEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
    );
    public static final EntityType<StegoraptorEntity> STEGORAPTOR = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("dinocraft", "stegoraptor"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, StegoraptorEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
    );

    public static EntityType<DragonwoodBoatEntity> DRAGONWOOD_BOAT;


    @Override
    public void onInitialize() {
        ModItems.registerItems();
        ModBlocks.registerAll();
        FabricDefaultAttributeRegistry.register(SAUROPOD, SauropodEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(THEROPOD, TheropodEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(TROODON, TroodonEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(MICORAPTOR, MicroraptorEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(MOSASAURUS, MicroraptorEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(STEGORAPTOR, StegoraptorEntity.createMobAttributes());
        BiomeModifications.addSpawn(BiomeSelectors.categories(Biome.Category.PLAINS), SpawnGroup.MONSTER, SAUROPOD, 8, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.categories(Biome.Category.PLAINS), SpawnGroup.MONSTER, TROODON, 8, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.categories(Biome.Category.PLAINS), SpawnGroup.MONSTER, THEROPOD, 8, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.categories(Biome.Category.PLAINS), SpawnGroup.MONSTER, MICORAPTOR, 8, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.categories(Biome.Category.PLAINS), SpawnGroup.MONSTER, STEGORAPTOR, 8, 1, 1);


        DRAGONWOOD_BOAT = Registry.register(Registry.ENTITY_TYPE, new Identifier("dinocraft", "dragonwood_boat"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, DragonwoodBoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build());
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
                new Identifier("tutorial", "overworld_wool_ore"), OVERWORLD_SKELETON_ORE_CONFIGURED_FEATURE);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("dinocraft", "overworld_skeleton_ore"),
                OVERWORLD_SKELETON_ORE_PLACED_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                        new Identifier("dinocraft", "overworld_skeleton_ore")));}

    private static ConfiguredFeature<?, ?> OVERWORLD_SKELETON_ORE_CONFIGURED_FEATURE = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
                    ModBlocks.SKELETON_ORE.getDefaultState(),
                    9)); // vein size

    public static PlacedFeature OVERWORLD_SKELETON_ORE_PLACED_FEATURE = OVERWORLD_SKELETON_ORE_CONFIGURED_FEATURE.withPlacement(
            CountPlacementModifier.of(20), // number of veins per chunk
            SquarePlacementModifier.of(), // spreading horizontally
            HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64))); // height
    
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






