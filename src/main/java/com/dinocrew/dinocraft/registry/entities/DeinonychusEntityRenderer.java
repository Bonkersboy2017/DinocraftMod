package com.dinocrew.dinocraft.registry.entities;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.client.DinocraftClient;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class DeinonychusEntityRenderer extends MobRenderer<DeinonychusEntity, DeinonychusEntityModel> {

    public DeinonychusEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new DeinonychusEntityModel(context.bakeLayer(DinocraftClient.MODEL_DEINONYCHUS_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(DeinonychusEntity entity) {
        return Dinocraft.id("textures/entity/deinonychus.png");
    }
}
