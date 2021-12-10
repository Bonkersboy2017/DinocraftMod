package com.dinocrew.dinocraft.registry.worldgen;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.registry.treegen.DragonwoodTree;
import net.fabricmc.fabric.api.biome.v1.OverworldBiomes;
import net.fabricmc.fabric.api.biome.v1.OverworldClimate;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

public abstract class RegisterWorldgen {


    public static final RegistryKey<Biome> BREAKTHROUGH_BIOME_KEY = RegistryKey.of(Registry.BIOME_KEY, new Identifier(Dinocraft.MOD_ID, "breakthrough_biome"));
    private static final Biome BREAKTHROUGH_BIOME = BreakthroughBiome.createBreakthroughBiome();


    public static void RegisterWorldgen() {
        RegistryKey<ConfiguredFeature<?, ?>> dragonwoodTree = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier(Dinocraft.MOD_ID, "dragonwood_tree"));

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, dragonwoodTree.getValue(), DragonwoodTree.DRAGONWOOD_TREE);
        Registry.register(BuiltinRegistries.BIOME, BREAKTHROUGH_BIOME_KEY.getValue(), BREAKTHROUGH_BIOME);
        Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, new Identifier(Dinocraft.MOD_ID, "breakthrough_builder"), BreakthroughBiome.BREAKTHROUGH_BIOME_BUILDER);
        OverworldBiomes.addContinentalBiome(BREAKTHROUGH_BIOME_KEY, OverworldClimate.TEMPERATE, 2D);
    }

}