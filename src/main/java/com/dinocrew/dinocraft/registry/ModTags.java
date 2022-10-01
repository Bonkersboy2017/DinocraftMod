package com.dinocrew.dinocraft.registry;

import com.dinocrew.dinocraft.Dinocraft;
import net.minecraft.core.Registry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class ModTags {

    public static final TagKey<Biome> DINO_SPAWNABLE = of("dino_spawnable");

    private static TagKey<Biome> of(String path) {
        return TagKey.create(Registry.BIOME_REGISTRY, Dinocraft.id(path));
    }
}
