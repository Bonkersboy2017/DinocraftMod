package com.dinocrew.dinocraft.registry.entities;

import com.dinocrew.dinocraft.client.DinocraftClient;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class DeinonychusEntityRenderer extends MobEntityRenderer<DeinonychusEntity, DeinonychusEntityModel> {

    public DeinonychusEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new DeinonychusEntityModel(context.getPart(DinocraftClient.MODEL_DEINONYCHUS_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(DeinonychusEntity entity) {
        return new Identifier("dinocraft", "textures/entity/deinonychus.png");
    }
}
