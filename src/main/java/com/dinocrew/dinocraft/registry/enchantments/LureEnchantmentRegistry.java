package com.dinocrew.dinocraft.registry.enchantments;

import com.dinocrew.dinocraft.Dinocraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.registry.Registry;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

public class LureEnchantmentRegistry implements ModInitializer {
    private static final Enchantment LURE = Registry.register(
            Registry.ENCHANTMENT,
            Dinocraft.id("lure"),
            new DinoEnchantment()
    );

    @Override
    public void onInitialize(ModContainer modContainer) {

    }
}
