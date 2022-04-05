package com.dinocrew.dinocraft.client.screen;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.screen.DinoBenchScreenHandler;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.ForgingScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class DinoBenchScreen extends ForgingScreen<DinoBenchScreenHandler> {
    private static final Identifier TEXTURE = new Identifier(Dinocraft.MOD_ID, "textures/gui/container/dinobench.png");

    public DinoBenchScreen(DinoBenchScreenHandler handler, PlayerInventory playerInventory, Text title) {
        super(handler, playerInventory, title, TEXTURE);
        this.titleX = 60;
        this.titleY = 18;
    }

    protected void drawForeground(MatrixStack matrices, int mouseX, int mouseY) {
        RenderSystem.disableBlend();
        super.drawForeground(matrices, mouseX, mouseY);
    }
}