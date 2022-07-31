package com.dinocrew.dinocraft.registry.entities;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.client.DinocraftClient;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class ProfessorEntityRenderer extends MobEntityRenderer<ProfessorEntity, ProfessorEntityModel> {

    public ProfessorEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new ProfessorEntityModel(context.getPart(DinocraftClient.MODEL_PROFESSOR_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(ProfessorEntity entity) {
        return Dinocraft.id("textures/entity/professor.png");
    }
}