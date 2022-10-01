package com.dinocrew.dinocraft.registry.worldgen;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.registry.ModBiomes;
import com.dinocrew.dinocraft.registry.ModEntities;
import com.dinocrew.dinocraft.registry.ModFeatures;
import com.dinocrew.dinocraft.registry.RegisterSounds;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.sounds.Musics;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;

public class RegisterWorldgen {

    public static void initialize() {

    }

    protected static int getSkyColor(float temperature) {
        float f = temperature / 3.0F;
        f = Mth.clamp(f, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.62222224F - f * 0.05F, 0.5F + f * 0.1F, 1.0F);
    }

    public static Biome createBreakthrough() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();


        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.DEINONYCHUS, 10, 1, 2));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.SAUROPOD, 10, 1, 2));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.STEGORAPTOR, 10, 1, 2));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.THEROPOD, 10, 1, 2));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.TROODON, 10, 1, 2));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.SCORPIUS, 2, 1, 2));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.TYRANNOSAURUS, 2, 1, 2));

        BiomeGenerationSettings.Builder featureSettings = new BiomeGenerationSettings.Builder();

        featureSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModFeatures.TREES_DRAGONWOOD);
        featureSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_GRASS_NORMAL);
//        featureSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.FLOWER_PLAIN);
        featureSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.BROWN_MUSHROOM_SWAMP);
        featureSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.RED_MUSHROOM_SWAMP);
        BiomeDefaultFeatures.addPlainGrass(featureSettings);
        BiomeDefaultFeatures.addDefaultOres(featureSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(featureSettings);
        BiomeDefaultFeatures.addWarmFlowers(featureSettings);
//        DefaultBiomeFeatures.addDefaultGrass(featureSettings);
        BiomeDefaultFeatures.addDefaultCarversAndLakes(featureSettings);
        BiomeDefaultFeatures.addDefaultCrystalFormations(featureSettings);
        BiomeDefaultFeatures.addDefaultMonsterRoom(featureSettings);
//        DefaultBiomeFeatures.addMineables(featureSettings);
        BiomeDefaultFeatures.addSurfaceFreezing(featureSettings);
        BiomeDefaultFeatures.addDefaultSprings(featureSettings);
//


        BiomeModifications.create(Dinocraft.id("breakthrough"))
                .add(ModificationPhase.ADDITIONS, BiomeSelectors.includeByKey(ModBiomes.BREAKTHROUGH), ctx -> {
                });

        return (new Biome.BiomeBuilder())
                .precipitation(Biome.Precipitation.NONE)
                .temperature(0.6F)
                .downfall(0.9F)
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .grassColorOverride(Integer.parseInt("a7a543", 16))
                        .foliageColorOverride(Integer.parseInt("63915b", 16))
                        .waterColor(4159204)
                        .waterFogColor(329011)
                        .fogColor(12638463)
                        .skyColor(getSkyColor(0.8F))
                        .backgroundMusic(Musics.createGameMusic(RegisterSounds.MUSIC_BREAKTHROUGH))
                        .build())
                .mobSpawnSettings(spawnSettings.build())
                .generationSettings(featureSettings.build())
                .build();

    }
}




