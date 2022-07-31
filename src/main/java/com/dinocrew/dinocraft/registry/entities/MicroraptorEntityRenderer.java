package com.dinocrew.dinocraft.registry.entities;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.client.DinocraftClient;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class MicroraptorEntityRenderer extends MobEntityRenderer<MicroraptorEntity, MicroRaptorEntityModel> {

    public MicroraptorEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new MicroRaptorEntityModel(context.getPart(DinocraftClient.MODEL_MICRORAPTOR_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(MicroraptorEntity entity) {
        return Dinocraft.id("textures/entity/microraptor.png");
    }
}