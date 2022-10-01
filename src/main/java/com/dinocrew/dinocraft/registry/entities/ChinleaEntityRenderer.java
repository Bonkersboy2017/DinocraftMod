package com.dinocrew.dinocraft.registry.entities;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.client.DinocraftClient;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ChinleaEntityRenderer extends MobRenderer<ChinleaEntity, ChinleaEntityModel> {

    public ChinleaEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new ChinleaEntityModel(context.bakeLayer(DinocraftClient.MODEL_CHINLEA_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(ChinleaEntity entity) {
        return Dinocraft.id("textures/entity/chinlea.png");
    }
}