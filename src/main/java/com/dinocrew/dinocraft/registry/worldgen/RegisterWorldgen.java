package com.dinocrew.dinocraft.registry.worldgen;

import com.dinocrew.dinocraft.Dinocraft;
import net.frozenblock.api.minecraft.worldgen.features.BreakthroughStones;
import net.frozenblock.api.minecraft.worldgen.trees.foliageplacers.DragonWoodFoliagePlacer;
import net.frozenblock.api.minecraft.worldgen.trees.trunkplacers.DragonWoodTrunkPlacer;
import com.dinocrew.dinocraft.registry.ModBiomes;
import com.dinocrew.dinocraft.registry.ModBlocks;
import com.dinocrew.dinocraft.registry.ModEntities;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.minecraft.block.Blocks;
import net.minecraft.client.sound.MusicType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.RandomSpreadFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.awt.*;

public class RegisterWorldgen {

    protected static int getSkyColor(float temperature) {
        float f = temperature / 3.0F;
        f = MathHelper.clamp(f, -1.0F, 1.0F);
        return MathHelper.hsvToRgb(0.62222224F - f * 0.05F, 0.5F + f * 0.1F, 1.0F);
    }

    public static Biome createBreakthrough() {
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


        BiomeModifications.create(Dinocraft.id("breakthrough"))
                .add(ModificationPhase.ADDITIONS, BiomeSelectors.includeByKey(ModBiomes.BREAKTHHROUGH_KEY), ctx -> {
                });

        return (new Biome.Builder())
                .precipitation(Biome.Precipitation.NONE)
                .temperature(0.6F)
                .downfall(0.9F)
                .effects((new BiomeEffects.Builder())
                        .grassColor(Integer.parseInt("a7a543", 16))
                        .foliageColor(Integer.parseInt("63915b", 16))
                        .waterColor(Integer.parseInt("5f9bbf", 16))
                        .waterFogColor(Integer.parseInt("5f9bbf", 16))
                        .fogColor(12638463)
                        .skyColor(getSkyColor(0.8F))
                        .music(MusicType.GAME)
                        .build())
                .spawnSettings(spawnSettings.build())
                .generationSettings(featureSettings.build())
                .build();

    }

    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> DRAGONWOOD = ConfiguredFeatures.register("dragonwood", Feature.TREE, new TreeFeatureConfig.Builder(

            BlockStateProvider.of(ModBlocks.DRAGONWOOD_LOG),
            new DragonWoodTrunkPlacer(3, 3, 0),
            BlockStateProvider.of(ModBlocks.DRAGONWOOD_LEAVES),
            new DragonWoodFoliagePlacer(ConstantIntProvider.create(1), ConstantIntProvider.create(0)),
            new TwoLayersFeatureSize(1, 0, 2)

    ).ignoreVines().build());

    public static final RegistryEntry<PlacedFeature> TREES_DRAGONWOOD = PlacedFeatures.register("trees_dragonwood", RegisterWorldgen.DRAGONWOOD, VegetationPlacedFeatures.modifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 1), Blocks.OAK_SAPLING));
}




