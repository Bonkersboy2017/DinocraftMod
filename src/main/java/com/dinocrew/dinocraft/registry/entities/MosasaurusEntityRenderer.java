package com.dinocrew.dinocraft.registry.entities;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.client.DinocraftClient;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MosasaurusEntityRenderer extends MobRenderer<MosasaurusEntity, MosasaurusEntityModel> {

    public MosasaurusEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new MosasaurusEntityModel(context.bakeLayer(DinocraftClient.MODEL_MOSASAURUS_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTexture(MosasaurusEntity entity) {
        return Dinocraft.id("textures/entity/mosasaurus.png");
    }
}