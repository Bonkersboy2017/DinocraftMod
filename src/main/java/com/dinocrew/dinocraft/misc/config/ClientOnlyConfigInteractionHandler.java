package com.dinocrew.dinocraft.misc.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import net.minecraft.client.gui.screens.Screen;

public class ClientOnlyConfigInteractionHandler {

    public static ConfigScreenFactory<Screen> buildScreen() {
        return DinocraftConfig::buildScreen;
    }
}
