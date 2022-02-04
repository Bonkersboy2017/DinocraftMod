package com.dinocrew.dinocraft.registry;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.Biome;

public class ModSpawns {
    public static void registerAll() {
        BiomeModifications.addSpawn(BiomeSelectors.categories(Biome.Category.PLAINS), SpawnGroup.MONSTER, ModEntities.SAUROPOD, 8, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.categories(Biome.Category.PLAINS), SpawnGroup.MONSTER, ModEntities.TROODON, 8, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.categories(Biome.Category.PLAINS), SpawnGroup.MONSTER, ModEntities.THEROPOD, 8, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.categories(Biome.Category.PLAINS), SpawnGroup.MONSTER, ModEntities.STEGORAPTOR, 8, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.categories(Biome.Category.OCEAN), SpawnGroup.MONSTER, ModEntities.MOSASAURUS, 1, 1, 1);
    }
}
