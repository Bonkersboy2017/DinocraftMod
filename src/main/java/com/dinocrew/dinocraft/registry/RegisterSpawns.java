package com.dinocrew.dinocraft.registry;

//import com.dinocrew.dinocraft.registry.RegisterWorldgen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.MobCategory;

public class RegisterSpawns {
    public static void registerAll() {

        BiomeModifications.addSpawn(BiomeSelectors.tag(RegisterTags.DINO_SPAWNABLE), MobCategory.MONSTER, RegisterEntities.SAUROPOD, 1, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.tag(RegisterTags.DINO_SPAWNABLE), MobCategory.MONSTER, RegisterEntities.TROODON, 1, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.tag(RegisterTags.DINO_SPAWNABLE), MobCategory.MONSTER, RegisterEntities.THEROPOD, 1, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.tag(RegisterTags.DINO_SPAWNABLE), MobCategory.MONSTER, RegisterEntities.STEGORAPTOR, 1, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.tag(BiomeTags.IS_DEEP_OCEAN), MobCategory.CREATURE, RegisterEntities.MOSASAURUS, 1, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.tag(RegisterTags.DINO_SPAWNABLE), MobCategory.MONSTER, RegisterEntities.DEINONYCHUS, 1, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.tag(BiomeTags.IS_DEEP_OCEAN), MobCategory.CREATURE, RegisterEntities.CHINLEA, 1, 1, 1);
    }
}