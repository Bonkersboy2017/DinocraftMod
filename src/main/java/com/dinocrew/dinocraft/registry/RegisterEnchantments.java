package com.dinocrew.dinocraft.registry;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.enchantment.BraveryEnchantment;
import com.dinocrew.dinocraft.enchantment.DinoEnchantment;
import net.minecraft.core.Registry;
import net.minecraft.world.item.enchantment.Enchantment;

public final class RegisterEnchantments {

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

    private RegisterEnchantments() {
    }

    public static void init() {

    }
}
