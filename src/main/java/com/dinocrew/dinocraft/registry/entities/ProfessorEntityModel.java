// Made with Model Converter by Globox_Z
// Generate all required imports
// Made with Blockbench 4.0.5
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports
package com.dinocrew.dinocraft.registry.entities;

import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;

public class ProfessorEntityModel extends PlayerModel<ProfessorEntity> {
    public ProfessorEntityModel(ModelPart root) {
        super(root, true);
    }

    public static LayerDefinition getTexturedModelData() {
        return LayerDefinition.create(createMesh(new CubeDeformation(0), true), 64, 64);
    }
}