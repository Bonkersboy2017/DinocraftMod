package com.dinocrew.dinocraft.registry.worldgen;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.registry.ModBiomes;
import com.dinocrew.dinocraft.registry.ModBlocks;
import com.dinocrew.dinocraft.registry.ModEntities;
import com.dinocrew.dinocraft.registry.ModItems;
import com.google.common.collect.ImmutableList;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.minecraft.block.Blocks;
import net.minecraft.client.color.world.FoliageColors;
import net.minecraft.client.sound.MusicType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.sound.BiomeAdditionsSound;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.MusicSound;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.RandomSpreadFoliagePlacer;
import net.minecraft.world.gen.foliage.SpruceFoliagePlacer;
import net.minecraft.world.gen.placementmodifier.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RegisterWorldgen {

    public static Biome createBreakthrpugh() {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        DefaultBiomeFeatures.addBatsAndMonsters(spawnSettings);


        spawnSettings.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(ModEntities.DEINONYCHUS, 10, 1, 1));
        spawnSettings.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(ModEntities.SAUROPOD, 10, 1, 1));
        spawnSettings.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(ModEntities.STEGORAPTOR, 10, 1, 1));
        spawnSettings.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(ModEntities.THEROPOD, 10, 1, 1));
        spawnSettings.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(ModEntities.TROODON, 10, 1, 1));
        GenerationSettings.Builder featureSettings = new GenerationSettings.Builder();

        featureSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, TREES_DRAGONWOOD);
        featureSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.PATCH_GRASS_NORMAL);
//        featureSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.FLOWER_PLAIN);
        featureSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.BROWN_MUSHROOM_SWAMP);
        featureSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.RED_MUSHROOM_SWAMP);
        DefaultBiomeFeatures.addPlainsTallGrass(featureSettings);
        DefaultBiomeFeatures.addDefaultOres(featureSettings);
        DefaultBiomeFeatures.addDefaultDisks(featureSettings);
        DefaultBiomeFeatures.addExtraDefaultFlowers(featureSettings);
//        DefaultBiomeFeatures.addDefaultGrass(featureSettings);
        DefaultBiomeFeatures.addLandCarvers(featureSettings);
        DefaultBiomeFeatures.addAmethystGeodes(featureSettings);
        DefaultBiomeFeatures.addDungeons(featureSettings);
//        DefaultBiomeFeatures.addMineables(featureSettings);
        DefaultBiomeFeatures.addFrozenTopLayer(featureSettings);
        DefaultBiomeFeatures.addSprings(featureSettings);
//


        BiomeModifications.create(new Identifier(Dinocraft.MOD_ID + "breakthrough"))
                .add(ModificationPhase.ADDITIONS, BiomeSelectors.includeByKey(ModBiomes.BREAKTHHROUGH_KEY), ctx -> {
                });

        return (new Biome.Builder())
                .precipitation(Biome.Precipitation.NONE)
                .category(Biome.Category.MUSHROOM)
                .temperature(0.6F)
                .downfall(0.9F)
                .effects((new BiomeEffects.Builder())
                        .grassColor(0x990099)
                        .foliageColor(0x990099)
                        .waterColor(0x990099)
                        .waterFogColor(0x990099)
                        .fogColor(0x990099)
                        .skyColor(0x990099)
                        .music(MusicType.GAME)
                        .build())
                .spawnSettings(spawnSettings.build())
                .generationSettings(featureSettings.build())
                .build();

    }

    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> DRAGONWOOD = ConfiguredFeatures.register("dragonwood", Feature.TREE, new TreeFeatureConfig.Builder(BlockStateProvider.of(ModBlocks.DRAGONWOOD_LOG), new StraightTrunkPlacer(8, 3, 0), BlockStateProvider.of(ModBlocks.DRAGONWOOD_LEAVES), new SpruceFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(3), ConstantIntProvider.create(4)), new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build());

    public static final RegistryEntry<PlacedFeature> TREES_DRAGONWOOD = PlacedFeatures.register("trees_dragonwood", RegisterWorldgen.DRAGONWOOD, VegetationPlacedFeatures.modifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(8, 0.1f, 1), Blocks.OAK_SAPLING));


}




