package com.dinocrew.dinocraft.misc.config;

import com.dinocrew.dinocraft.Dinocraft;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screens.Screen;

@Environment(EnvType.CLIENT)
public final class ModMenuIntegration implements ModMenuApi {

    @Override
    public ConfigScreenFactory<Screen> getModConfigScreenFactory() {
        if (Dinocraft.hasCloth) {
            return ClientOnlyConfigInteractionHandler.buildScreen();
        }
        return (screen -> null);
    }
}
