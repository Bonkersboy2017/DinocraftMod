package com.dinocrew.dinocraft.registry;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.registry.worldgen.RegisterWorldgen;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;

public class ModBiomes {
    public static final RegistryKey<Biome> BREAKTHHROUGH_KEY = registerBiomeKeys("breakthrough");

    private static RegistryKey<Biome> registerBiomeKeys(String name) {
        return RegistryKey.of(Registry.BIOME_KEY, Dinocraft.id(name));
    }

    public static void registerBiomes() {
        register(BREAKTHHROUGH_KEY, RegisterWorldgen.createBreakthrough());
    }


    private static RegistryEntry<Biome> register(RegistryKey<Biome> key, Biome biome) {
        return BuiltinRegistries.add(BuiltinRegistries.BIOME, key, biome);
    }
}