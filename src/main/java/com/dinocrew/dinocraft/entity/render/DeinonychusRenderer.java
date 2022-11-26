package com.dinocrew.dinocraft.entity.render;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.DinocraftClient;
import com.dinocrew.dinocraft.entity.Deinonychus;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class DeinonychusRenderer extends MobRenderer<Deinonychus, DeinonychusModel> {

    public DeinonychusRenderer(EntityRendererProvider.Context context) {
        super(context, new DeinonychusModel(context.bakeLayer(DinocraftClient.MODEL_DEINONYCHUS_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(Deinonychus entity) {
        return Dinocraft.id("textures/entity/deinonychus.png");
    }
}
