package com.dinocrew.dinocraft.registry.entities;

import com.dinocrew.dinocraft.client.DinocraftClient;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class MosasaurusEntityRenderer extends MobEntityRenderer<MosasaurusEntity, mosasaurus> {

    public MosasaurusEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new mosasaurus(context.getPart(DinocraftClient.MODEL_MOSASAURUS_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(MosasaurusEntity entity) {
        return new Identifier("dm", "textures/entity/mosasaurus.png");
    }
}