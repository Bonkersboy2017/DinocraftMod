package com.dinocrew.dinocraft.entity.ai;

import com.dinocrew.dinocraft.entity.Tyrannosaurus;
import com.dinocrew.dinocraft.registry.RegisterSounds;
import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;

import java.util.Arrays;

public enum TyrannosaurusAngerLevel {
    CALM(Tyrannosaurus.CALM_ANGER, RegisterSounds.TYRANNOSAURUS_AMBIENT, RegisterSounds.TYRANNOSAURUS_DETECTING),
    AGITATED(Tyrannosaurus.AGITATED_ANGER, RegisterSounds.TYRANNOSAURUS_AGITATED, RegisterSounds.TYRANNOSAURUS_DETECTING_ANGRY),
    ANGRY(Tyrannosaurus.ANGRY_ANGER, RegisterSounds.TYRANNOSAURUS_ANGRY, RegisterSounds.TYRANNOSAURUS_DETECTING_ANGRY);

    private static final TyrannosaurusAngerLevel[] SORTED_LEVELS = Util.make(
            values(), state -> Arrays.sort(state, (state1, state2) -> Integer.compare(state2.minimumAnger, state1.minimumAnger))
    );
    private final int minimumAnger;
    private final SoundEvent ambientSound;
    private final SoundEvent listeningSound;

    TyrannosaurusAngerLevel(int minimumAnger, SoundEvent ambientSound, SoundEvent listeningSound) {
        this.minimumAnger = minimumAnger;
        this.ambientSound = ambientSound;
        this.listeningSound = listeningSound;
    }

    public int getMinimumAnger() {
        return this.minimumAnger;
    }

    public SoundEvent getAmbientSound() {
        return this.ambientSound;
    }

    public SoundEvent getListeningSound() {
        return this.listeningSound;
    }

    public static TyrannosaurusAngerLevel byAnger(int anger) {
        for(TyrannosaurusAngerLevel angerLevel : SORTED_LEVELS) {
            if (anger >= angerLevel.minimumAnger) {
                return angerLevel;
            }
        }

        return CALM;
    }

    public boolean isAngry() {
        return this == ANGRY;
    }
}
