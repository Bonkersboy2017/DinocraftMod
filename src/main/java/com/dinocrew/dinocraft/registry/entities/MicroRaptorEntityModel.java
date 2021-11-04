// Made with Model Converter by Globox_Z
// Generate all required imports
// Made with Blockbench 4.0.1
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports

 package com.dinocrew.dinocraft.registry.entities;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.ParrotEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.util.math.MathHelper;
import java.lang.Integer;

import java.util.function.IntToDoubleFunction;

@Environment(EnvType.CLIENT)
public class MicroRaptorEntityModel extends EntityModel<MicroraptorEntity> {
	private final ModelPart body;
		private final ModelPart neck;
		private final ModelPart head;
		private final ModelPart right_leg;
		private final ModelPart right_knee;
		private final ModelPart right_foot;
		private final ModelPart left_leg;
		private final ModelPart left_knee;
		private final ModelPart left_foot;
		private final ModelPart right_wing1;
		private final ModelPart right_wing2;
		private final ModelPart right_wing3;
		private final ModelPart left_wing1;
		private final ModelPart left_wing2;
		private final ModelPart left_wing3;
		private final ModelPart tail1;
		private final ModelPart tail2;
		private final ModelPart tail3;

	public MicroRaptorEntityModel(ModelPart root){
		this.body = root.getChild("body");
		this.tail1 = this.body.getChild("tail1");
		this.tail2 = this.tail1.getChild("tail2");
		this.tail3 = this.tail2.getChild("tail3");
		this.left_wing1 = this.body.getChild("left_wing1");
		this.left_wing2 = this.left_wing1.getChild("left_wing2");
		this.left_wing3 = this.left_wing2.getChild("left_wing3");
		this.right_wing1 = this.body.getChild("right_wing1");
		this.right_wing2 = this.right_wing1.getChild("right_wing2");
		this.right_wing3 = this.right_wing2.getChild("right_wing3");
		this.left_leg = this.body.getChild("left_leg");
		this.left_knee = this.left_leg.getChild("left_knee");
		this.left_foot = this.left_knee.getChild("left_foot");
		this.right_leg = this.body.getChild("right_leg");
		this.right_knee = this.right_leg.getChild("right_knee");
		this.right_foot = this.right_knee.getChild("right_foot");
		this.neck = this.body.getChild("neck");
		this.head = this.neck.getChild("head");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData modelPartData1 = modelPartData.addChild("body", ModelPartBuilder.create().uv(0, 20).cuboid(-6.0F, -6.0F, -8.0F, 12.0F, 12.0F, 16.0F), ModelTransform.pivot(0.0F, 2.0F, 0.0F));
		ModelPartData modelPartData2 = modelPartData1.addChild("neck", ModelPartBuilder.create().uv(52, 0).cuboid(-3.0F, -3.0F, -12.0F, 6.0F, 6.0F, 12.0F), ModelTransform.pivot(0.0F, -2.0F, -6.0F));
		modelPartData2.addChild("head", ModelPartBuilder.create().uv(40, 50).cuboid(-4.0F, -5.0F, -10.0F, 8.0F, 8.0F, 10.0F).uv(62, 72).cuboid(-2.0F, -2.0F, -16.0F, 4.0F, 4.0F, 6.0F), ModelTransform.pivot(0.0F, -1.0F, -10.0F));
		ModelPartData modelPartData3 = modelPartData1.addChild("right_leg", ModelPartBuilder.create().uv(64, 20).cuboid(-3.0F, -3.0F, -5.0F, 6.0F, 12.0F, 10.0F).uv(76, 8).cuboid(-0.25F, -3.0F, 5.0F, 0.0F, 12.0F, 8.0F), ModelTransform.pivot(-4.0F, 3.0F, 5.0F));
		ModelPartData modelPartData4 = modelPartData3.addChild("right_knee", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F).uv(0, 10).cuboid(0.0F, -1.0F, 2.0F, 0.0F, 12.0F, 6.0F), ModelTransform.pivot(0.0F, 8.0F, 2.0F));
		modelPartData4.addChild("right_foot", ModelPartBuilder.create().uv(22, 68).cuboid(-3.0F, 0.0F, -6.0F, 6.0F, 2.0F, 8.0F), ModelTransform.pivot(0.0F, 9.0F, -2.0F));
		ModelPartData modelPartData5 = modelPartData1.addChild("left_leg", ModelPartBuilder.create().uv(64, 20).cuboid(-3.0F, -3.0F, -5.0F, 6.0F, 12.0F, 10.0F, true).uv(76, 8).cuboid(0.25F, -3.0F, 5.0F, 0.0F, 12.0F, 8.0F, true), ModelTransform.pivot(4.0F, 3.0F, 5.0F));
		ModelPartData modelPartData6 = modelPartData5.addChild("left_knee", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F, true).uv(0, 10).cuboid(0.0F, -1.0F, 2.0F, 0.0F, 12.0F, 6.0F, true), ModelTransform.pivot(0.0F, 8.0F, 2.0F));
		modelPartData6.addChild("left_foot", ModelPartBuilder.create().uv(22, 68).cuboid(-3.0F, 0.0F, -6.0F, 6.0F, 2.0F, 8.0F, true), ModelTransform.pivot(0.0F, 9.0F, -2.0F));
		ModelPartData modelPartData7 = modelPartData1.addChild("right_wing1", ModelPartBuilder.create().uv(66, 50).cuboid(-10.0F, -1.0F, -1.5F, 10.0F, 2.0F, 3.0F).uv(42, 72).cuboid(-10.0F, -0.5F, 1.5F, 10.0F, 1.0F, 3.0F).uv(0, 66).cuboid(-10.0F, 0.0F, 4.5F, 10.0F, 0.0F, 10.0F), ModelTransform.pivot(-6.0F, -4.0F, -4.5F));
		ModelPartData modelPartData8 = modelPartData7.addChild("right_wing2", ModelPartBuilder.create().uv(64, 42).cuboid(-16.0F, -0.5F, -1.5F, 16.0F, 1.0F, 3.0F).uv(30, 20).cuboid(-16.0F, 0.0F, 1.5F, 16.0F, 0.0F, 10.0F), ModelTransform.pivot(-10.0F, 0.0F, 0.0F));
		modelPartData8.addChild("right_wing3", ModelPartBuilder.create().uv(18, 50).cuboid(-10.0F, 0.0F, -1.5F, 10.0F, 0.0F, 10.0F), ModelTransform.pivot(-16.0F, 0.0F, 0.0F));
		ModelPartData modelPartData9 = modelPartData1.addChild("left_wing1", ModelPartBuilder.create().uv(66, 50).cuboid(0.0F, -1.0F, -1.5F, 10.0F, 2.0F, 3.0F, true).uv(42, 72).cuboid(0.0F, -0.5F, 1.5F, 10.0F, 1.0F, 3.0F, true).uv(0, 66).cuboid(0.0F, 0.0F, 4.5F, 10.0F, 0.0F, 10.0F, true), ModelTransform.pivot(6.0F, -4.0F, -4.5F));
		ModelPartData modelPartData10 = modelPartData9.addChild("left_wing2", ModelPartBuilder.create().uv(64, 42).cuboid(0.0F, -0.5F, -1.5F, 16.0F, 1.0F, 3.0F, true).uv(30, 20).cuboid(0.0F, 0.0F, 1.5F, 16.0F, 0.0F, 10.0F, true), ModelTransform.pivot(10.0F, 0.0F, 0.0F));
		modelPartData10.addChild("left_wing3", ModelPartBuilder.create().uv(18, 50).cuboid(0.0F, 0.0F, -1.5F, 10.0F, 0.0F, 10.0F, true), ModelTransform.pivot(16.0F, 0.0F, 0.0F));
		ModelPartData modelPartData11 = modelPartData1.addChild("tail1", ModelPartBuilder.create().uv(0, 48).cuboid(-4.0F, -3.0F, 0.0F, 8.0F, 6.0F, 12.0F), ModelTransform.pivot(0.0F, -3.0F, 8.0F));
		ModelPartData modelPartData12 = modelPartData11.addChild("tail2", ModelPartBuilder.create().uv(64, 56).cuboid(-3.0F, -2.0F, 0.0F, 6.0F, 4.0F, 12.0F), ModelTransform.pivot(0.0F, -1.0F, 12.0F));
		modelPartData12.addChild("tail3", ModelPartBuilder.create().uv(40, 32).cuboid(-2.0F, -1.0F, 0.0F, 4.0F, 2.0F, 16.0F).uv(0, 0).cuboid(-8.0F, 0.0F, 14.0F, 16.0F, 0.0F, 20.0F), ModelTransform.pivot(0.0F, -1.0F, 12.0F));
		return TexturedModelData.of(modelData, 128, 128);
	}

	@Override
	public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		body.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelPart bone, float x, float y, float z) {
			bone.pitch = x;
			bone.yaw = y;
			bone.roll = z;
	}

	public void setAngles(MicroraptorEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		float pi = 3.14159265358979323846264338327950288F;
		setRotationAngle(neck, -0.6981F, 0.0F, 0.0F);
		setRotationAngle(head, 0.7854F, 0.0F, 0.0F);
		setRotationAngle(right_foot, -0.3491F, 0.0F, 0.0F);
		setRotationAngle(left_foot, -0.3491F, 0.0F, 0.0F);

		if(!entity.isOnGround()) {
			this.right_wing1.yaw = 0;
			this.left_wing1.yaw = 0;
			this.right_wing1.pitch = 0;
			this.left_wing1.pitch = 0;
			this.right_wing1.roll = MathHelper.cos(animationProgress/5)/3;
			this.left_wing1.roll = -MathHelper.cos(animationProgress/5)/3;

			this.right_wing2.yaw = 0;
			this.left_wing2.yaw = 0;
			this.right_wing2.pitch = 0;
			this.left_wing2.pitch = 0;
			this.right_wing2.roll = MathHelper.cos(animationProgress/5)/3;
			this.left_wing2.roll = -MathHelper.cos(animationProgress/5)/3;

			this.right_wing3.yaw = 0;
			this.left_wing3.yaw = 0;
			this.right_wing3.pitch = 0;
			this.left_wing3.pitch = 0;
			this.right_wing3.roll = MathHelper.cos(animationProgress/5)/3;
			this.left_wing3.roll = -MathHelper.cos(animationProgress/5)/3;

			this.tail1.yaw = 0;
			this.tail2.yaw = 0;
			this.tail3.yaw = 0;

			this.left_leg.pitch = 1;
			this.right_leg.pitch = 1;

			this.left_knee.pitch = 1;
			this.right_knee.pitch = 1;

		} else {
			this.right_wing1.roll = 120 * pi/180;
			this.right_wing1.yaw = 135 * pi/180;
			this.right_wing1.pitch = 10 * pi/180;
			this.left_wing1.roll = -120 * pi/180;
			this.left_wing1.yaw = -135 * pi/180;
			this.left_wing1.pitch = -10 * pi/180;

			this.right_wing2.yaw = 0;
			this.left_wing2.yaw = 0;
			this.right_wing2.roll = 0;
			this.left_wing2.roll = 0;
			this.right_wing2.pitch = 0;
			this.left_wing2.pitch = 0;

			this.right_wing3.yaw = 0;
			this.left_wing3.yaw = 0;
			this.right_wing3.roll = 0;
			this.left_wing3.roll = 0;
			this.right_wing3.pitch = 0;
			this.left_wing3.pitch = 0;

			this.tail1.yaw = -MathHelper.cos(animationProgress/5)/5;
			this.tail2.yaw = -MathHelper.cos(animationProgress/5)/5;
			this.tail3.yaw = -MathHelper.cos(animationProgress/5)/5;

			this.left_leg.pitch = MathHelper.cos(limbAngle * 0.6662F + 3.1415927F) * 1.4F * limbDistance / 2 - 0.3491F;
			this.right_leg.pitch = -MathHelper.cos(limbAngle * 0.6662F + 3.1415927F) * 1.4F * limbDistance / 2 - 0.3491F;

			this.left_knee.pitch = MathHelper.cos(limbAngle * 0.6662F + 3.1415927F) * 1.4F * limbDistance / 2 + 0.6981F;
			this.right_knee.pitch = -MathHelper.cos(limbAngle * 0.6662F + 3.1415927F) * 1.4F * limbDistance / 2 + 0.6981F;
		}
	}

}