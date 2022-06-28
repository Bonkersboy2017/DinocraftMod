package com.dinocrew.dinocraft.registry.entities;

import com.dinocrew.dinocraft.client.DinocraftClient;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class IndoraptorEntityRenderer extends GeoEntityRenderer<IndoraptorEntity> {

    public IndoraptorEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new IndoraptorEntityModel());
    }

    @Override
    public Identifier getTexture(IndoraptorEntity entity) {
        return new Identifier("dinocraft", "textures/entity/indoraptor.png");
    }
}
