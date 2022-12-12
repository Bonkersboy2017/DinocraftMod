package com.dinocrew.dinocraft.registry;

import com.dinocrew.dinocraft.Dinocraft;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;

public final class RegisterSounds {

    //ENTITIES
    public static final SoundEvent BIGDINO_HURT = register("entity.bigdino.hurt");
    public static final SoundEvent CHINLEA_HURT = register("entity.chinlea.hurt");
    public static final SoundEvent CHINLEA_AMBIENT = register("entity.chinlea.ambient");
    public static final SoundEvent DINO_DEATH = register("entity.dino.death");
    public static final SoundEvent DINO_HURT = register("entity.dino.hurt");
    public static final SoundEvent DINO_AMBIENT = register("entity.dino.ambient");
    public static final SoundEvent MICRORAPTOR_HURT = register("entity.microraptor.hurt");
    public static final SoundEvent MICRORAPTOR_AMBIENT = register("entity.microraptor.ambient");
    public static final SoundEvent MOSASAURUS_HURT = register("entity.mosasaurus.hurt");
    public static final SoundEvent MOSASAURUS_AMBIENT = register("entity.mosasaurus.ambient");
    public static final SoundEvent PROFESSOR_DEATH = register("entity.professor.death");
    public static final SoundEvent PROFESSOR_HURT = register("entity.professor.hurt");
    public static final SoundEvent PROFESSOR_AMBIENT = register("entity.professor.ambient");
    public static final SoundEvent TYRANNOSAURUS_AGITATED = register("entity.tyrannosaurus.agitated");
    public static final SoundEvent TYRANNOSAURUS_AMBIENT = register("entity.tyrannosaurus.ambient");
    public static final SoundEvent TYRANNOSAURUS_ANGRY = register("entity.tyrannosaurus.angry");
    public static final SoundEvent TYRANNOSAURUS_ATTACK_IMPACT = register("entity.tyrannosaurus.attack_impact");
    public static final SoundEvent TYRANNOSAURUS_DEATH = register("entity.tyrannosaurus.death");
    public static final SoundEvent TYRANNOSAURUS_DETECTING = register("entity.tyrannosaurus.detecting");
    public static final SoundEvent TYRANNOSAURUS_DETECTING_ANGRY = register("entity.tyrannosaurus.detecting_angry");
    public static final SoundEvent TYRANNOSAURUS_HURT = register("entity.tyrannosaurus.hurt");
    public static final SoundEvent TYRANNOSAURUS_ROAR = register("entity.tyrannosaurus.roar");
    public static final SoundEvent TYRANNOSAURUS_SNIFF = register("entity.tyrannosaurus.sniff");
    public static final SoundEvent TYRANNOSAURUS_STEP = register("entity.tyrannosaurus.step");

    //BIOME

    public static final Holder<SoundEvent> MUSIC_BREAKTHROUGH = registerForHolder("music.breakthrough");

    private RegisterSounds() {
    }


    private static SoundEvent register(String path) {
        return Registry.register(BuiltInRegistries.SOUND_EVENT, Dinocraft.id(path), SoundEvent.createVariableRangeEvent(Dinocraft.id(path)));
    }

    private static Holder<SoundEvent> registerForHolder(String path) {
        return Registry.registerForHolder(BuiltInRegistries.SOUND_EVENT, Dinocraft.id(path), SoundEvent.createVariableRangeEvent(Dinocraft.id(path)));
    }

    public static void init() {
    }
}
