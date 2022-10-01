package com.dinocrew.dinocraft.registry.entities;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.client.DinocraftClient;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ScorpiusRenderer extends MobRenderer<Scorpius, ScorpiusModel> {

    public ScorpiusRenderer(EntityRendererProvider.Context context) {
        super(context, new ScorpiusModel(context.bakeLayer(DinocraftClient.MODEL_SCORPIUS_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(Scorpius entity) {
        return Dinocraft.id("textures/entity/scorpius.png");
    }
}