package com.dinocrew.dinocraft.client.screen;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.screen.DinoBenchScreenHandler;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screens.inventory.ItemCombinerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

@Environment(EnvType.CLIENT)
public class DinoBenchScreen extends ItemCombinerScreen<DinoBenchScreenHandler> {
    private static final ResourceLocation TEXTURE = Dinocraft.id("textures/gui/container/dinobench.png");

    public DinoBenchScreen(DinoBenchScreenHandler handler, Inventory playerInventory, Component title) {
        super(handler, playerInventory, title, TEXTURE);
        this.titleLabelX = 60;
        this.titleLabelY = 18;
    }

    protected void renderLabels(PoseStack matrices, int mouseX, int mouseY) {
        RenderSystem.disableBlend();
        super.renderLabels(matrices, mouseX, mouseY);
    }
}