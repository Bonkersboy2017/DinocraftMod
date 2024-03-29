package net.frozenblock.dinocraft;

import net.frozenblock.dinocraft.registry.RegisterBlocks;
import net.frozenblock.dinocraft.registry.RegisterConfiguredFeatures;

public class Main {

    /**
     * FROZENBLOCK's INITIALIZER
     * <p>
     * I don't like how Dinocraft is organized, so I made a separated part
     * <p>
     * Only for FrozenBlock Modders, ALL RIGHTS RESERVED
     * <p>
     *
     * @author LiukRast (2021-2022)
     * @since 4.0
     */

    public static void runner(String modid) {
        RegisterConfiguredFeatures.init(modid);
        RegisterBlocks.init(modid);
    }
}
