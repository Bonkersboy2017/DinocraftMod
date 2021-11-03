package com.dinocrew.dinocraft.registry.enchantments;

import com.dinocrew.dinocraft.registry.enchantments.DinoEnchantment;
import net.fabricmc.api.ModInitializer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class LureEnchantmentRegistry implements ModInitializer {
    private static Enchantment LURE = Registry.register(
            Registry.ENCHANTMENT,
            new Identifier("dinocraft", "lure"),
            new DinoEnchantment()
    );
    @Override
    public void onInitialize() {

    }
}
