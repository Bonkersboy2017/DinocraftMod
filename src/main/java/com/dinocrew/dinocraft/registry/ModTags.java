package com.dinocrew.dinocraft.registry;

import com.dinocrew.dinocraft.Dinocraft;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

public class ModTags {

    public static final TagKey<Biome> DINO_SPAWNABLE = of("dino_spawnable");

    private static TagKey<Biome> of(String path) {
        return TagKey.of(Registry.BIOME_KEY, Dinocraft.id(path));
    }
}
