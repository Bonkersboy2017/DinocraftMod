package net.frozenblock.api.mathematics;

public interface AdvancedMath {
    /**
     * ADVANCED MATH
     * <p>
     * Adds more math operations
     * <p>
     * Only for FrozenBlock Modders, ALL RIGHTS RESERVED
     * <p>
     *
     *
     * @author      LiukRast (2021-2022)
     * @since 4.0
     *
     */
    default float range(float min, float max, float number) {
        return (number * max) + min;
    }
}
