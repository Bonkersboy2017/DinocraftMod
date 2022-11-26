package com.dinocrew.dinocraft.entity.render;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.DinocraftClient;
import com.dinocrew.dinocraft.entity.Tyrannosaurus;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;


public class TyrannosaurusRenderer extends MobRenderer<Tyrannosaurus, TyrannosaurusModel> {

    public TyrannosaurusRenderer(EntityRendererProvider.Context context) {
        super(context, new TyrannosaurusModel(context.bakeLayer(DinocraftClient.MODEL_TREX_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(Tyrannosaurus entity) {
        return Dinocraft.id("textures/entity/trex.png");
    }
}