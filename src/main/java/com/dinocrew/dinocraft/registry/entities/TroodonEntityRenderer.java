package com.dinocrew.dinocraft.registry.entities;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.client.DinocraftClient;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class TroodonEntityRenderer extends MobEntityRenderer<TroodonEntity, TroodonEntityModel> {

    public TroodonEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new TroodonEntityModel(context.getPart(DinocraftClient.MODEL_TROODON_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(TroodonEntity entity) {
        return Dinocraft.id("textures/entity/troodon.png");
    }
}