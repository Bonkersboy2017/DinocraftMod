package com.dinocrew.dinocraft.registry.entities;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.client.DinocraftClient;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;


public class TRexEntityRenderer extends MobEntityRenderer<TRexEntity, TRexEntityModel> {

    public TRexEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new TRexEntityModel(context.getPart(DinocraftClient.MODEL_TREX_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(TRexEntity entity) {
        return Dinocraft.id("textures/entity/trex.png");
    }
}