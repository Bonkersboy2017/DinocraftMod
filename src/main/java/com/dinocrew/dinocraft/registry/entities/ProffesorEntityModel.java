// Made with Model Converter by Globox_Z
// Generate all required imports
// Made with Blockbench 4.0.5
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	package com.dinocrew.dinocraft.registry.entities;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import org.w3c.dom.Text;

public class ProffesorEntityModel extends PlayerEntityModel<ProffessorEntity> {
	public ProffesorEntityModel(ModelPart root) {
		super(root, true);
	}

	public static TexturedModelData getTexturedModelData() {
		return TexturedModelData.of(getTexturedModelData(new Dilation(0), true), 64, 64);
	}
}