package com.dinocrew.dinocraft.registry.entities;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.client.DinocraftClient;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class TheropodEntityRenderer extends MobEntityRenderer<TheropodEntity, TheropodEntityModel> {

    public TheropodEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new TheropodEntityModel(context.getPart(DinocraftClient.MODEL_THEROPOD_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(TheropodEntity entity) {
        return Dinocraft.id("textures/entity/theropod.png");
    }
}