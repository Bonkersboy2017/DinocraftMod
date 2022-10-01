package com.dinocrew.dinocraft.entity;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.DinocraftClient;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class TheropodRenderer extends MobRenderer<Theropod, TheropodModel> {

    public TheropodRenderer(EntityRendererProvider.Context context) {
        super(context, new TheropodModel(context.bakeLayer(DinocraftClient.MODEL_THEROPOD_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(Theropod entity) {
        return Dinocraft.id("textures/entity/theropod.png");
    }
}