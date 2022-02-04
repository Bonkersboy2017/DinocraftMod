package com.dinocrew.dinocraft.registry.entities;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.client.DinocraftClient;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class ChinleaEntityRenderer extends MobEntityRenderer<ChinleaEntity, ChinleaEntityModel> {

    public ChinleaEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new ChinleaEntityModel(context.getPart(DinocraftClient.MODEL_CHINLEA_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(ChinleaEntity entity) {
        return new Identifier(Dinocraft.MOD_ID, "textures/entity/chinlea.png");
    }
}