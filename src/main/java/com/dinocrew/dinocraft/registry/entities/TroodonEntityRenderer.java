package com.dinocrew.dinocraft.registry.entities;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.client.DinocraftClient;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class TroodonEntityRenderer extends MobRenderer<TroodonEntity, TroodonEntityModel> {

    public TroodonEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new TroodonEntityModel(context.bakeLayer(DinocraftClient.MODEL_TROODON_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTexture(TroodonEntity entity) {
        return Dinocraft.id("textures/entity/troodon.png");
    }
}