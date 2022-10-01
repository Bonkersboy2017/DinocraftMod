package com.dinocrew.dinocraft.registry.enchantments;

import com.dinocrew.dinocraft.Dinocraft;
import net.minecraft.core.Registry;
import net.minecraft.world.item.enchantment.Enchantment;

public class EnchantmentRegistry {

    public static final Enchantment BRAVERY = Registry.register(
            Registry.ENCHANTMENT,
            Dinocraft.id("bravery"),
            new BraveryEnchantment()
    );

    public static final Enchantment LURE = Registry.register(
            Registry.ENCHANTMENT,
            Dinocraft.id("lure"),
            new DinoEnchantment()

    );

    public static void init() {

    }
}
