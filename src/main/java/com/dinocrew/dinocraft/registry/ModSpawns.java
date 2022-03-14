package com.dinocrew.dinocraft.registry;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.Biome;

public class ModSpawns {
    public static void registerAll() {
        BiomeModifications.addSpawn(BiomeSelectors.categories(Biome.Category.PLAINS), SpawnGroup.MONSTER, ModEntities.SAUROPOD, 1, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.categories(Biome.Category.PLAINS), SpawnGroup.MONSTER, ModEntities.TROODON, 1, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.categories(Biome.Category.PLAINS), SpawnGroup.MONSTER, ModEntities.THEROPOD, 1, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.categories(Biome.Category.PLAINS), SpawnGroup.MONSTER, ModEntities.STEGORAPTOR, 1, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.categories(Biome.Category.OCEAN), SpawnGroup.MONSTER, ModEntities.MOSASAURUS, 1, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.categories(Biome.Category.PLAINS), SpawnGroup.MONSTER, ModEntities.DEINONYCHUS, 1, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.categories(Biome.Category.RIVER), SpawnGroup.MONSTER, ModEntities.CHINLEA, 1, 1, 1);
    }
}