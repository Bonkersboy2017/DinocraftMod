package com.dinocrew.dinocraft.registry.entities;

import com.dinocrew.dinocraft.client.DinocraftClient;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class TheropodEntityRenderer extends MobEntityRenderer<TheropodEntity, theropod> {

    public TheropodEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new theropod(context.getPart(DinocraftClient.MODEL_THEROPOD_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(TheropodEntity entity) {
        return new Identifier("dm", "textures/entity/theropod.png");
    }
}