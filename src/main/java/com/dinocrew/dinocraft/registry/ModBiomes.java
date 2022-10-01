package com.dinocrew.dinocraft.registry;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.registry.worldgen.RegisterWorldgen;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

public class ModBiomes {
    public static final ResourceKey<Biome> BREAKTHROUGH = registerBiomeKeys("breakthrough");

    private static ResourceKey<Biome> registerBiomeKeys(String name) {
        return ResourceKey.create(Registry.BIOME_REGISTRY, Dinocraft.id(name));
    }

    public static void registerBiomes() {
        register(BREAKTHROUGH, RegisterWorldgen.createBreakthrough());
    }


    private static Holder<Biome> register(ResourceKey<Biome> key, Biome biome) {
        return BuiltinRegistries.register(BuiltinRegistries.BIOME, key, biome);
    }
}