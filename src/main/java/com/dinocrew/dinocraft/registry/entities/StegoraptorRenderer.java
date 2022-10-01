package com.dinocrew.dinocraft.registry.entities;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.client.DinocraftClient;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class StegoraptorRenderer extends MobRenderer<Stegoraptor, StegoraptorModel> {

    public StegoraptorRenderer(EntityRendererProvider.Context context) {
        super(context, new StegoraptorModel(context.bakeLayer(DinocraftClient.MODEL_STEGORAPTOR_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(Stegoraptor entity) {
        return Dinocraft.id("textures/entity/stegoraptor.png");
    }
}
