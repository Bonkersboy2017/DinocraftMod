package com.dinocrew.dinocraft.entity.render;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.DinocraftClient;
import com.dinocrew.dinocraft.entity.Sauropod;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SauropodRenderer extends MobRenderer<Sauropod, SauropodModel> {

    public SauropodRenderer(EntityRendererProvider.Context context) {
        super(context, new SauropodModel(context.bakeLayer(DinocraftClient.MODEL_SAUROPOD_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(Sauropod entity) {
        return Dinocraft.id("textures/entity/sauropod.png");
    }
}