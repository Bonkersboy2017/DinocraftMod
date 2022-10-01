package com.dinocrew.dinocraft.registry.entities;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.client.DinocraftClient;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@Environment(EnvType.CLIENT)
public class MicroraptorRenderer extends MobRenderer<Microraptor, MicroraptorModel> {

    public MicroraptorRenderer(EntityRendererProvider.Context context) {
        super(context, new MicroraptorModel(context.bakeLayer(DinocraftClient.MODEL_MICRORAPTOR_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(Microraptor entity) {
        return Dinocraft.id("textures/entity/microraptor.png");
    }
}