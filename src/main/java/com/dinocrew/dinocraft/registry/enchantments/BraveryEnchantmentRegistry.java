package com.dinocrew.dinocraft.registry.enchantments;

import com.dinocrew.dinocraft.Dinocraft;
import net.fabricmc.api.ModInitializer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.registry.Registry;

public class BraveryEnchantmentRegistry implements ModInitializer {
    private static final Enchantment BRAVERY = Registry.register(
            Registry.ENCHANTMENT,
            Dinocraft.id("bravery"),
            new BraveryEnchantment()
    );

    @Override
    public void onInitialize() {

    }
}
