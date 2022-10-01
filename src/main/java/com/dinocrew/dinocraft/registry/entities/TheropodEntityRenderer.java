package com.dinocrew.dinocraft.registry.entities;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.client.DinocraftClient;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class TheropodEntityRenderer extends MobRenderer<TheropodEntity, TheropodEntityModel> {

    public TheropodEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new TheropodEntityModel(context.bakeLayer(DinocraftClient.MODEL_THEROPOD_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTexture(TheropodEntity entity) {
        return Dinocraft.id("textures/entity/theropod.png");
    }
}