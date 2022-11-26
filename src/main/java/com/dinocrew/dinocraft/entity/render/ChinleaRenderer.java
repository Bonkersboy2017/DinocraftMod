package com.dinocrew.dinocraft.entity.render;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.DinocraftClient;
import com.dinocrew.dinocraft.entity.Chinlea;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ChinleaRenderer extends MobRenderer<Chinlea, ChinleaModel> {

    public ChinleaRenderer(EntityRendererProvider.Context context) {
        super(context, new ChinleaModel(context.bakeLayer(DinocraftClient.MODEL_CHINLEA_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(Chinlea entity) {
        return Dinocraft.id("textures/entity/chinlea.png");
    }
}