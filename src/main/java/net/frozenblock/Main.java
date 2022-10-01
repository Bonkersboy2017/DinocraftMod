package net.frozenblock;

import net.frozenblock.registry.RegisterBlocks;
import net.frozenblock.registry.RegisterConfiguredFeatures;

public class Main {

    /**
     * FROZENBLOCK's INITIALIZER
     * <p>
     * I don't like how's dinocraft organized, so I made a separated part
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
