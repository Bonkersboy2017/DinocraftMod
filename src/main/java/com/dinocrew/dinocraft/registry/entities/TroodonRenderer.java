package com.dinocrew.dinocraft.registry.entities;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.client.DinocraftClient;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class TroodonRenderer extends MobRenderer<Troodon, TroodonModel> {

    public TroodonRenderer(EntityRendererProvider.Context context) {
        super(context, new TroodonModel(context.bakeLayer(DinocraftClient.MODEL_TROODON_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(Troodon entity) {
        return Dinocraft.id("textures/entity/troodon.png");
    }
}