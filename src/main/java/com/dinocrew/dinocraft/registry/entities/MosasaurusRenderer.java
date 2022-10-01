package com.dinocrew.dinocraft.registry.entities;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.client.DinocraftClient;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MosasaurusRenderer extends MobRenderer<Mosasaurus, MosasaurusModel> {

    public MosasaurusRenderer(EntityRendererProvider.Context context) {
        super(context, new MosasaurusModel(context.bakeLayer(DinocraftClient.MODEL_MOSASAURUS_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(Mosasaurus entity) {
        return Dinocraft.id("textures/entity/mosasaurus.png");
    }
}