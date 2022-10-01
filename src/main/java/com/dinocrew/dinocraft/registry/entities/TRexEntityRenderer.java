package com.dinocrew.dinocraft.registry.entities;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.client.DinocraftClient;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;


public class TRexEntityRenderer extends MobRenderer<TRexEntity, TRexEntityModel> {

    public TRexEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new TRexEntityModel(context.bakeLayer(DinocraftClient.MODEL_TREX_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTexture(TRexEntity entity) {
        return Dinocraft.id("textures/entity/trex.png");
    }
}