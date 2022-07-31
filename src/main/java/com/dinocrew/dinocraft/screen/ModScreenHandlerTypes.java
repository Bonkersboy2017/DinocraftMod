package com.dinocrew.dinocraft.screen;

import com.dinocrew.dinocraft.Dinocraft;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;

public class ModScreenHandlerTypes {
    public static final ScreenHandlerType<DinoBenchScreenHandler> DINO_BENCH_SCREEN_HANDLER_TYPE = register("dinobench", DinoBenchScreenHandler::new);

    public static <T extends ScreenHandler> ScreenHandlerType<T> register(String id, ScreenHandlerRegistry.SimpleClientHandlerFactory<T> prov) {
        return ScreenHandlerRegistry.registerSimple(Dinocraft.id(id), prov);
    }

    public static void initialize() {
    }
}
