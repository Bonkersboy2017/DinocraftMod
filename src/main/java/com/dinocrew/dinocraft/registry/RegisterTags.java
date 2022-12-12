package com.dinocrew.dinocraft.registry;

import com.dinocrew.dinocraft.Dinocraft;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public final class RegisterTags {

    public static final TagKey<Biome> DINO_SPAWNABLE = bind("dino_spawnable");

    private RegisterTags() {
    }

    private static TagKey<Biome> bind(String path) {
        return TagKey.create(Registries.BIOME, Dinocraft.id(path));
    }
}
