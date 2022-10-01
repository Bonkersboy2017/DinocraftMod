package com.dinocrew.dinocraft.registry;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.enchantment.BraveryEnchantment;
import com.dinocrew.dinocraft.enchantment.DinoEnchantment;
import net.minecraft.core.Registry;
import net.minecraft.world.item.enchantment.Enchantment;

public class RegisterEnchantments {

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
