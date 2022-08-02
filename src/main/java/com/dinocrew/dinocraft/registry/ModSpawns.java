package com.dinocrew.dinocraft.registry;

//import com.dinocrew.dinocraft.registry.worldgen.RegisterWorldgen;

import net.minecraft.entity.SpawnGroup;
import net.minecraft.tag.BiomeTags;
import org.quiltmc.qsl.worldgen.biome.api.BiomeModifications;
import org.quiltmc.qsl.worldgen.biome.api.BiomeSelectors;

public class ModSpawns {
    public static void registerAll() {
        BiomeModifications.addSpawn(BiomeSelectors.isIn(BiomeTags.IS_SAVANNA), SpawnGroup.MONSTER, ModEntities.SAUROPOD, 1, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.isIn(BiomeTags.IS_SAVANNA), SpawnGroup.MONSTER, ModEntities.TROODON, 1, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.isIn(BiomeTags.IS_SAVANNA), SpawnGroup.MONSTER, ModEntities.THEROPOD, 1, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.isIn(BiomeTags.IS_SAVANNA), SpawnGroup.MONSTER, ModEntities.STEGORAPTOR, 1, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.isIn(BiomeTags.IS_DEEP_OCEAN), SpawnGroup.MONSTER, ModEntities.MOSASAURUS, 1, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.isIn(BiomeTags.IS_SAVANNA), SpawnGroup.MONSTER, ModEntities.DEINONYCHUS, 1, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.isIn(BiomeTags.IS_RIVER), SpawnGroup.MONSTER, ModEntities.CHINLEA, 1, 1, 1);
    }
}