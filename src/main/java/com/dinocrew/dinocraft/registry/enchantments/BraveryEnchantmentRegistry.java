package com.dinocrew.dinocraft.registry.enchantments;

import net.fabricmc.api.ModInitializer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BraveryEnchantmentRegistry implements ModInitializer {
    private static Enchantment BRAVERY = Registry.register(
            Registry.ENCHANTMENT,
            new Identifier("dinocraft", "bravery"),
            new BraveryEnchantment()
    );
    @Override
    public void onInitialize() {

    }
}
