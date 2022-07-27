package com.dinocrew.dinocraft.registry.entities;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.client.DinocraftClient;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;


public class IndoraptorEntityRenderer extends MobEntityRenderer<IndoraptorEntity, IndoraptorEntityModel> {

    public IndoraptorEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new IndoraptorEntityModel(context.getPart(DinocraftClient.MODEL_INDORAPTOR_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(IndoraptorEntity entity) {
        return new Identifier(Dinocraft.MOD_ID, "textures/entity/indoraptor.png");
    }
}