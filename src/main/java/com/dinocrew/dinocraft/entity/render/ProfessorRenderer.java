package com.dinocrew.dinocraft.entity.render;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.DinocraftClient;
import com.dinocrew.dinocraft.entity.Professor;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ProfessorRenderer extends MobRenderer<Professor, ProfessorModel> {

    public ProfessorRenderer(EntityRendererProvider.Context context) {
        super(context, new ProfessorModel(context.bakeLayer(DinocraftClient.MODEL_PROFESSOR_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(Professor entity) {
        return Dinocraft.id("textures/entity/professor.png");
    }
}