package com.dinocrew.dinocraft.registry.entities;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.client.DinocraftClient;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SauropodEntityRenderer extends MobRenderer<SauropodEntity, SauropodEntityModel> {

    public SauropodEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new SauropodEntityModel(context.bakeLayer(DinocraftClient.MODEL_SAUROPOD_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTexture(SauropodEntity entity) {
        return Dinocraft.id("textures/entity/sauropod.png");
    }
}