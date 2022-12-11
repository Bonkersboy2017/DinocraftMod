package com.dinocrew.dinocraft.registry;

import com.dinocrew.dinocraft.Dinocraft;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Musics;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import org.jetbrains.annotations.NotNull;
import org.quiltmc.qsl.frozenblock.worldgen.surface_rule.api.SurfaceRuleContext;
import org.quiltmc.qsl.frozenblock.worldgen.surface_rule.api.SurfaceRuleEvents;

public final class RegisterWorldgen implements SurfaceRuleEvents.OverworldModifierCallback {

    public static final ResourceKey<Biome> BREAKTHROUGH = registerBiomeKeys("breakthrough");

    private static ResourceKey<Biome> registerBiomeKeys(String name) {
        return ResourceKey.create(Registries.BIOME, Dinocraft.id(name));
    }

    public static void bootstrap(BootstapContext<Biome> context) {
        Dinocraft.logDino("Registering Biomes for", Dinocraft.UNSTABLE_LOGGING);
        register(context, BREAKTHROUGH, RegisterWorldgen.createBreakthrough(context));
    }

    @Override
    public void modifyOverworldRules(SurfaceRuleContext.@NotNull Overworld overworld) {
        overworld.ruleSources().add(0,
                SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(RegisterWorldgen.BREAKTHROUGH),
                        SurfaceRules.ifTrue(
                                SurfaceRules.ON_FLOOR,
                                SurfaceRules.ifTrue(
                                        SurfaceRules.abovePreliminarySurface(),
                                        SurfaceRules.sequence(
                                                SurfaceRules.ifTrue(
                                                        SurfaceRules.waterBlockCheck(0, 0),
                                                        SurfaceRules.state(RegisterBlocks.DRAGONGRASS.defaultBlockState())
                                                ),
                                                SurfaceRules.state(Blocks.DIRT.defaultBlockState())
                                        )
                                )
                        )
                )
        );
    }


    private static Holder<Biome> register(BootstapContext<Biome> context, ResourceKey<Biome> key, Biome biome) {
        return context.register(key, biome);
    }

    public static int getSkyColor(float temperature) {
        float f = temperature / 3.0F;
        f = Mth.clamp(f, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.62222224F - f * 0.05F, 0.5F + f * 0.1F, 1.0F);
    }

    public static Biome createBreakthrough(BootstapContext<Biome> context) {
        final var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        final var configuredCarvers = context.lookup(Registries.CONFIGURED_CARVER);

        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();


        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(RegisterEntities.DEINONYCHUS, 10, 1, 2));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(RegisterEntities.SAUROPOD, 10, 1, 2));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(RegisterEntities.STEGORAPTOR, 10, 1, 2));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(RegisterEntities.THEROPOD, 10, 1, 2));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(RegisterEntities.TROODON, 10, 1, 2));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(RegisterEntities.SCORPIUS, 2, 1, 2));
        spawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(RegisterEntities.TYRANNOSAURUS, 2, 1, 2));

        BiomeGenerationSettings.Builder featureSettings = new BiomeGenerationSettings.Builder(placedFeatures, configuredCarvers);

        featureSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RegisterFeatures.TREES_DRAGONWOOD);
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
                .add(ModificationPhase.ADDITIONS, BiomeSelectors.includeByKey(RegisterWorldgen.BREAKTHROUGH), ctx -> {
                });

        return new Biome.BiomeBuilder()
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
