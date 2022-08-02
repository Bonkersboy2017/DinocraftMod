package com.dinocrew.dinocraft.registry.enchantments;

import com.dinocrew.dinocraft.Dinocraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.registry.Registry;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

public class BraveryEnchantmentRegistry implements ModInitializer {
    private static final Enchantment BRAVERY = Registry.register(
            Registry.ENCHANTMENT,
            Dinocraft.id("bravery"),
            new BraveryEnchantment()
    );

    @Override
    public void onInitialize(ModContainer modContainer) {

    }
}
