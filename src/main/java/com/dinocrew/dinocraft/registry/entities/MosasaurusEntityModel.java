// Made with Model Converter by Globox_Z
// Generate all required imports
// Made with Blockbench 4.0.1
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	package com.dinocrew.dinocraft.registry.entities;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class MosasaurusEntityModel extends EntityModel<MosasaurusEntity> {
	private final ModelPart body;
	private final ModelPart back_body;
	private final ModelPart left_back_fin;
	private final ModelPart left_back_fin2;
	private final ModelPart tail1;
	private final ModelPart tail2;
	private final ModelPart exit1;
	private final ModelPart exit2;
	private final ModelPart head;
	private final ModelPart head2;
	private final ModelPart head4;
	private final ModelPart mouth;
	private final ModelPart mouth2;
	private final ModelPart left_front_fin;
	private final ModelPart right_front_fin;
	public MosasaurusEntityModel(ModelPart root) {
		this.body = root.getChild("body");
		this.right_front_fin = this.body.getChild("right_front_fin");
		this.left_front_fin = this.body.getChild("left_front_fin");
		this.head = this.body.getChild("head");
		this.mouth = this.head.getChild("mouth");
		this.mouth2 = this.mouth.getChild("mouth2");
		this.head2 = this.head.getChild("head2");
		this.head4 = this.head2.getChild("head4");
		this.back_body = this.body.getChild("back_body");
		this.tail1 = this.back_body.getChild("tail1");
		this.tail2 = this.tail1.getChild("tail2");
		this.exit2 = this.tail2.getChild("exit2");
		this.exit1 = this.tail2.getChild("exit1");
		this.left_back_fin2 = this.back_body.getChild("left_back_fin2");
		this.left_back_fin = this.back_body.getChild("left_back_fin");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData modelPartData1 = modelPartData.addChild("body", ModelPartBuilder.create().uv(0,0).cuboid(-6.0F, -15.0F, -15.0F, 12.0F, 12.0F, 24.0F), ModelTransform.pivot(0.0F,24.0F,0.0F));
		ModelPartData modelPartData2 = modelPartData1.addChild("back_body", ModelPartBuilder.create().uv(42,58).cuboid(-5.0F, -6.0F, -1.0F, 10.0F, 10.0F, 10.0F), ModelTransform.pivot(0.0F,-8.0F,9.0F));
		modelPartData2.addChild("left_back_fin", ModelPartBuilder.create().uv(72,37).cuboid(0.0F, -1.0F, -4.0F, 12.0F, 2.0F, 8.0F), ModelTransform.pivot(2.0F,1.0F,14.0F));
		modelPartData2.addChild("left_back_fin2", ModelPartBuilder.create().uv(72,27).cuboid(-12.0F, -1.0F, -4.0F, 12.0F, 2.0F, 8.0F), ModelTransform.pivot(-2.0F,1.0F,14.0F));
		ModelPartData modelPartData3 = modelPartData2.addChild("tail1", ModelPartBuilder.create().uv(32,78).cuboid(-4.0F, -5.0F, -4.0F, 8.0F, 8.0F, 8.0F), ModelTransform.pivot(0.0F,0.0F,13.0F));
		ModelPartData modelPartData4 = modelPartData3.addChild("tail2", ModelPartBuilder.create().uv(44,36).cuboid(-3.0F, -4.0F, 0.0F, 6.0F, 6.0F, 16.0F), ModelTransform.pivot(0.0F,0.0F,4.0F));
		modelPartData4.addChild("exit1", ModelPartBuilder.create().uv(76,47).cuboid(-1.0F, -5.0F, 0.0F, 2.0F, 6.0F, 12.0F), ModelTransform.pivot(0.0F,1.0F,9.0F));
		modelPartData4.addChild("exit2", ModelPartBuilder.create().uv(0,50).cuboid(-2.0F, -4.0F, -4.0F, 4.0F, 6.0F, 17.0F), ModelTransform.pivot(0.0F,1.0F,9.0F));
		ModelPartData modelPartData5 = modelPartData1.addChild("head", ModelPartBuilder.create().uv(0,73).cuboid(-5.0F, -7.0F, -9.0F, 10.0F, 11.0F, 6.0F), ModelTransform.pivot(0.0F,-8.0F,-12.0F));
		ModelPartData modelPartData6 = modelPartData5.addChild("head2", ModelPartBuilder.create().uv(71,67).cuboid(-4.0F, -6.0F, -10.0F, 8.0F, 7.0F, 11.0F), ModelTransform.pivot(0.0F,0.0F,-9.0F));
		modelPartData6.addChild("head4", ModelPartBuilder.create().uv(55,85).cuboid(-3.0F, 2.0F, -9.0F, 6.0F, 3.0F, 9.0F).uv(48,14).cuboid(-3.0F, 5.0F, -9.0F, 6.0F, 1.0F, 9.0F, new Dilation(0.01F)), ModelTransform.pivot(0.0F,-4.0F,-10.0F));
		ModelPartData modelPartData7 = modelPartData5.addChild("mouth", ModelPartBuilder.create().uv(72,14).cuboid(-4.0F, 1.0F, -10.0F, 8.0F, 2.0F, 11.0F), ModelTransform.pivot(0.0F,0.0F,-9.0F));
		modelPartData7.addChild("mouth2", ModelPartBuilder.create().uv(85,85).cuboid(-3.0F, -1.0F, -9.0F, 6.0F, 2.0F, 9.0F), ModelTransform.pivot(0.0F,2.0F,-10.0F));
		modelPartData1.addChild("left_front_fin", ModelPartBuilder.create().uv(48,0).cuboid(-3.0F, -1.0F, -5.0F, 18.0F, 2.0F, 12.0F).uv(48,0).cuboid(-3.0F, -1.0F, -5.0F, 18.0F, 2.0F, 12.0F), ModelTransform.pivot(7.0F,-4.0F,-5.0F));
		modelPartData1.addChild("right_front_fin", ModelPartBuilder.create().uv(0,36).cuboid(-15.0F, -1.0F, -5.0F, 18.0F, 2.0F, 12.0F), ModelTransform.pivot(-7.0F,-4.0F,-5.0F));
		return TexturedModelData.of(modelData,128,128);
	}
	@Override
	public void setAngles(MosasaurusEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		this.left_back_fin.yaw = -0.3927F;
		this.left_back_fin.roll = 0.4363F;
		this.left_back_fin2.yaw = 0.3927F;
		this.left_back_fin2.roll = -0.4363F;
		this.exit1.pitch = 0.3491F;
		this.exit2.pitch = -0.3491F;
		this.left_front_fin.yaw = -0.3927F;
		this.left_front_fin.roll = 0.4363F;
		this.right_front_fin.yaw = 0.3927F;
		this.right_front_fin.roll = -0.4363F;
		//previously the render function, render code was moved to a method below
	}
	@Override
	public void render(MatrixStack matrixStack, VertexConsumer	buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){

		body.render(matrixStack, buffer, packedLight, packedOverlay);
	}
	public void setRotationAngle(ModelPart bone, float x, float y, float z) {
		bone.pitch = x;
		bone.yaw = y;
		bone.roll = z;
	}
}