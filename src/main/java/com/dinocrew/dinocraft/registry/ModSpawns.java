package com.dinocrew.dinocraft.registry;

//import com.dinocrew.dinocraft.registry.worldgen.RegisterWorldgen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.tag.BiomeTags;

public class ModSpawns {
    public static void registerAll() {
        BiomeModifications.addSpawn(BiomeSelectors.tag(BiomeTags.IS_SAVANNA), SpawnGroup.MONSTER, ModEntities.SAUROPOD, 1, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.tag(BiomeTags.IS_SAVANNA), SpawnGroup.MONSTER, ModEntities.TROODON, 1, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.tag(BiomeTags.IS_SAVANNA), SpawnGroup.MONSTER, ModEntities.THEROPOD, 1, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.tag(BiomeTags.IS_SAVANNA), SpawnGroup.MONSTER, ModEntities.STEGORAPTOR, 1, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.tag(BiomeTags.IS_DEEP_OCEAN), SpawnGroup.MONSTER, ModEntities.MOSASAURUS, 1, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.tag(BiomeTags.IS_SAVANNA), SpawnGroup.MONSTER, ModEntities.DEINONYCHUS, 1, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.tag(BiomeTags.IS_RIVER), SpawnGroup.MONSTER, ModEntities.CHINLEA, 1, 1, 1);
    }
}