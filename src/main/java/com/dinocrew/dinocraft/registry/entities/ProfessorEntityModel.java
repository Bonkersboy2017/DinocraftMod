// Made with Model Converter by Globox_Z
// Generate all required imports
// Made with Blockbench 4.0.5
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports
package com.dinocrew.dinocraft.registry.entities;

import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.PlayerEntityModel;

public class ProfessorEntityModel extends PlayerEntityModel<ProfessorEntity> {
    public ProfessorEntityModel(ModelPart root) {
        super(root, true);
    }

    public static TexturedModelData getTexturedModelData() {
        return TexturedModelData.of(getTexturedModelData(new Dilation(0), true), 64, 64);
    }
}