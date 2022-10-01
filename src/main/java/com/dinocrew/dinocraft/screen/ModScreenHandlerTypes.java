package com.dinocrew.dinocraft.screen;

import com.dinocrew.dinocraft.Dinocraft;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;

public class ModScreenHandlerTypes {
    public static final MenuType<DinoBenchScreenHandler> DINO_BENCH_SCREEN_HANDLER_TYPE = register("dinobench", DinoBenchScreenHandler::new);

    public static <T extends AbstractContainerMenu> MenuType<T> register(String id, ScreenHandlerRegistry.SimpleClientHandlerFactory<T> prov) {
        return ScreenHandlerRegistry.registerSimple(Dinocraft.id(id), prov);
    }

    public static void initialize() {
    }
}
