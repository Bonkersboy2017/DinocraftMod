package com.dinocrew.dinocraft.registry;

//import com.dinocrew.dinocraft.registry.worldgen.RegisterWorldgen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.MobCategory;

public class ModSpawns {
    public static void registerAll() {

        BiomeModifications.addSpawn(BiomeSelectors.tag(ModTags.DINO_SPAWNABLE), MobCategory.MONSTER, ModEntities.SAUROPOD, 1, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.tag(ModTags.DINO_SPAWNABLE), MobCategory.MONSTER, ModEntities.TROODON, 1, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.tag(ModTags.DINO_SPAWNABLE), MobCategory.MONSTER, ModEntities.THEROPOD, 1, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.tag(ModTags.DINO_SPAWNABLE), MobCategory.MONSTER, ModEntities.STEGORAPTOR, 1, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.tag(BiomeTags.IS_DEEP_OCEAN), MobCategory.CREATURE, ModEntities.MOSASAURUS, 1, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.tag(ModTags.DINO_SPAWNABLE), MobCategory.MONSTER, ModEntities.DEINONYCHUS, 1, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.tag(BiomeTags.IS_DEEP_OCEAN), MobCategory.CREATURE, ModEntities.CHINLEA, 1, 1, 1);
    }
}