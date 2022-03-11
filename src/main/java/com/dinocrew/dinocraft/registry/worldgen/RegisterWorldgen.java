package com.dinocrew.dinocraft.registry.worldgen;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.registry.ModBlocks;
import com.google.common.collect.ImmutableList;
import net.minecraft.block.Blocks;
import net.minecraft.client.color.world.FoliageColors;
import net.minecraft.client.sound.MusicType;
import net.minecraft.sound.BiomeAdditionsSound;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.MusicSound;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
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
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import org.jetbrains.annotations.Nullable;

public class RegisterWorldgen {

    @Nullable
    private static final MusicSound DEFAULT_MUSIC = null;

    public static final RegistryKey<Biome> BREAKTHROUGH = register("breakthrough");


    private static RegistryKey<Biome> register(String name) {
        return RegistryKey.of(Registry.BIOME_KEY, new Identifier(Dinocraft.MOD_ID, name));
    }


    public static Biome createBreakthrough() {
        SpawnSettings.Builder builder = new SpawnSettings.Builder();
        net.minecraft.world.biome.GenerationSettings.Builder builder2 = new net.minecraft.world.biome.GenerationSettings.Builder();
        DefaultBiomeFeatures.addFossils(builder2);
        addBasicFeatures(builder2);
        DefaultBiomeFeatures.addDefaultOres(builder2);
        DefaultBiomeFeatures.addClayDisk(builder2);
        addBreakthroughFeatures(builder2);
        DefaultBiomeFeatures.addDefaultMushrooms(builder2);
        DefaultBiomeFeatures.addSwampVegetation(builder2);
        builder2.feature(GenerationStep.Feature.VEGETAL_DECORATION, OceanPlacedFeatures.SEAGRASS_SWAMP);
        return (
                new net.minecraft.world.biome.Biome.Builder())
                .precipitation(Biome.Precipitation.NONE)
                .category(Biome.Category.SAVANNA)
                .temperature(0.8F).downfall(0.9F)
                .effects((new net.minecraft.world.biome.BiomeEffects.Builder())
                        .waterColor(0x990099)
                        .waterFogColor(0x990099)
                        .fogColor(0x990099)
                        .skyColor(getSkyColor(0.8F))
                        .foliageColor(0x990099)
                        .grassColorModifier(BiomeEffects.GrassColorModifier.SWAMP)
                        .moodSound(BiomeMoodSound.CAVE).build())
                .spawnSettings(builder.build())
                .generationSettings(builder2.build()).build();

    }

    public static void addBreakthroughFeatures(GenerationSettings.Builder builder) {
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.PATCH_WATERLILY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.BROWN_MUSHROOM_SWAMP);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.RED_MUSHROOM_SWAMP);
    }

    private static void addBasicFeatures(net.minecraft.world.biome.GenerationSettings.Builder generationSettings) {
        DefaultBiomeFeatures.addLandCarvers(generationSettings);
        DefaultBiomeFeatures.addAmethystGeodes(generationSettings);
        DefaultBiomeFeatures.addDungeons(generationSettings);
        DefaultBiomeFeatures.addMineables(generationSettings);
        DefaultBiomeFeatures.addSprings(generationSettings);
        DefaultBiomeFeatures.addFrozenTopLayer(generationSettings);
    }

    private static void addBasicFeaturesNoSprings(net.minecraft.world.biome.GenerationSettings.Builder generationSettings) {
        DefaultBiomeFeatures.addLandCarvers(generationSettings);
        DefaultBiomeFeatures.addAmethystGeodes(generationSettings);
        DefaultBiomeFeatures.addDungeons(generationSettings);
        DefaultBiomeFeatures.addMineables(generationSettings);
        DefaultBiomeFeatures.addFrozenTopLayer(generationSettings);
    }

    protected static int getSkyColor(float temperature) {
        float f = temperature / 3.0F;
        f = MathHelper.clamp(f, -1.0F, 1.0F);
        return MathHelper.hsvToRgb(0.62222224F - f * 0.05F, 0.5F + f * 0.1F, 1.0F);
    }

    public static void RegisterWorldgen() {
        BuiltinRegistries.add(BuiltinRegistries.BIOME, BREAKTHROUGH, createBreakthrough());
    }
}
