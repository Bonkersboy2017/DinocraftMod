package com.dinocrew.dinocraft.registry;

import com.dinocrew.dinocraft.Dinocraft;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public final class RegisterSounds {

    //ENTITIES
    public static final SoundEvent BIGDINO_HIT = register("bigdino_hit");
    public static final SoundEvent CHINLEA_HIT = register("chinlea_hit");
    public static final SoundEvent CHINLEA_IDLE = register("chinlea_idle");
    public static final SoundEvent DINO_DEATH = register("dino_death");
    public static final SoundEvent DINO_HIT = register("dino_hit");
    public static final SoundEvent DINO_IDLE = register("dino_idle");
    public static final SoundEvent MICRO_HIT = register("micro_hit");
    public static final SoundEvent MICRO_IDLE = register("micro_idle");
    public static final SoundEvent MOSA_HIT = register("mosa_hit");
    public static final SoundEvent MOSA_IDLE = register("mosa_idle");
    public static final SoundEvent PROFESSOR_DEATH = register("professor_death");
    public static final SoundEvent PROFESSOR_HIT = register("professor_hit");
    public static final SoundEvent PROFESSOR_IDLE = register("professor_idle");

    //BIOME

    public static final SoundEvent MUSIC_BREAKTHROUGH = register("music_breakthrough");

    private RegisterSounds() {
    }


    private static SoundEvent register(String path) {
        return Registry.register(Registry.SOUND_EVENT, new ResourceLocation(Dinocraft.MOD_ID, path), new SoundEvent(new ResourceLocation(Dinocraft.MOD_ID, path)));
    }

    public static void init() {
    }
}
