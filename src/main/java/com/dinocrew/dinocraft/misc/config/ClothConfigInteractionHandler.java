package com.dinocrew.dinocraft.misc.config;

import com.dinocrew.dinocraft.Dinocraft;

public final class ClothConfigInteractionHandler {

    public static boolean naturallyGenerateDinos() {
        if (Dinocraft.hasCloth) {
            return ClothConfigCloserInteractionHandler.naturallyGenerateDinos();
        }
        return true;
    }
}
