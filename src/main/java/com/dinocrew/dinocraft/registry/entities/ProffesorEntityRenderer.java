package com.dinocrew.dinocraft.registry.entities;

import com.dinocrew.dinocraft.client.DinocraftClient;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class ProffesorEntityRenderer extends MobEntityRenderer<ProffessorEntity, ProffesorEntityModel> {

    public ProffesorEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new ProffesorEntityModel(context.getPart(DinocraftClient.MODEL_PROFFESOR_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(ProffessorEntity entity) {
        return new Identifier("dinocraft", "textures/entity/proffessor.png");
    }
}