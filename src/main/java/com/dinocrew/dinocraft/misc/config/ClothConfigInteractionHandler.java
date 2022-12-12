package com.dinocrew.dinocraft.misc.config;

import com.dinocrew.dinocraft.Dinocraft;
import net.frozenblock.lib.FrozenBools;

public final class ClothConfigInteractionHandler {

    public static boolean naturallyGenerateDinos() {
        if (FrozenBools.HAS_CLOTH_CONFIG) {
            return ClothConfigCloserInteractionHandler.naturallyGenerateDinos();
        }
        return true;
    }
}
