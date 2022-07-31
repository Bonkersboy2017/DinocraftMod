package com.dinocrew.dinocraft.registry.entities;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.client.DinocraftClient;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class ScorpiusEntityRenderer extends MobEntityRenderer<ScorpiusEntity, ScorpiusEntityModel> {

    public ScorpiusEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new ScorpiusEntityModel(context.getPart(DinocraftClient.MODEL_SCORPIUS_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(ScorpiusEntity entity) {
        return Dinocraft.id("textures/entity/scorpius.png");
    }
}