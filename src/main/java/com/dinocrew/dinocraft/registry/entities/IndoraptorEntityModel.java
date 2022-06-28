package com.dinocrew.dinocraft.registry.entities;

import com.dinocrew.dinocraft.Dinocraft;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.GeckoLib;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class IndoraptorEntityModel extends AnimatedGeoModel<IndoraptorEntity>
{

    @Override
    public Identifier getModelResource(IndoraptorEntity object) {
        return new Identifier(Dinocraft.MOD_ID, "geo/indoraptor.geo.json");
    }

    @Override
    public Identifier getTextureResource(IndoraptorEntity object) {
        return new Identifier(Dinocraft.MOD_ID, "textures/entity/indoraptor.png");
    }

    @Override
    public Identifier getAnimationResource(IndoraptorEntity animatable) {
        return new Identifier(Dinocraft.MOD_ID, "animations/indoraptor.animations.json");
    }
}