package com.dinocrew.dinocraft.registry.entities;

import com.dinocrew.dinocraft.client.DinocraftClient;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class SauropodEntityRenderer extends MobEntityRenderer<SauropodEntity, sauropod> {

    public SauropodEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new sauropod(context.getPart(DinocraftClient.MODEL_SAUROPOD_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(SauropodEntity entity) {
        return new Identifier("dm", "textures/entity/sauropod.png");
    }
}