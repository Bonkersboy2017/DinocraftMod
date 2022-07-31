package com.dinocrew.dinocraft.registry.entities;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.client.DinocraftClient;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class StegoraptorEntityRenderer extends MobEntityRenderer<StegoraptorEntity, StegoraptorEntityModel> {

    public StegoraptorEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new StegoraptorEntityModel(context.getPart(DinocraftClient.MODEL_STEGORAPTOR_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(StegoraptorEntity entity) {
        return Dinocraft.id("textures/entity/stegoraptor.png");
    }
}
