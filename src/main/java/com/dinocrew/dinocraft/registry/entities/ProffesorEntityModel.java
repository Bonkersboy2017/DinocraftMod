// Made with Model Converter by Globox_Z
// Generate all required imports
// Made with Blockbench 4.0.5
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	package com.dinocrew.dinocraft.registry.entities;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class ProffesorEntityModel extends EntityModel<ProffessorEntity> {
private final ModelPart bone;
	private final ModelPart LeftLeg;
	private final ModelPart LeftLegLayer_r1;
	private final ModelPart LeftLeg_r1;
	private final ModelPart RightLeg;
	private final ModelPart RightLegLayer_r1;
	private final ModelPart RightLeg_r1;
	private final ModelPart LeftArm;
	private final ModelPart LeftArmLayer_r1;
	private final ModelPart LeftArm_r1;
	private final ModelPart RightArm;
	private final ModelPart RightArmLayer_r1;
	private final ModelPart RightArm_r1;
	private final ModelPart Body;
	private final ModelPart BodyLayer_r1;
	private final ModelPart Head;
	private final ModelPart HatLayer_r1;
	private final ModelPart Head_r1;
public ProffesorEntityModel(ModelPart root) {
this.bone = root.getChild("bone");
this.Head = this.bone.getChild("Head");
this.Head_r1 = this.Head.getChild("Head_r1");
this.HatLayer_r1 = this.Head.getChild("HatLayer_r1");
this.Body = this.bone.getChild("Body");
this.BodyLayer_r1 = this.Body.getChild("BodyLayer_r1");
this.RightArm = this.bone.getChild("RightArm");
this.RightArm_r1 = this.RightArm.getChild("RightArm_r1");
this.RightArmLayer_r1 = this.RightArm.getChild("RightArmLayer_r1");
this.LeftArm = this.bone.getChild("LeftArm");
this.LeftArm_r1 = this.LeftArm.getChild("LeftArm_r1");
this.LeftArmLayer_r1 = this.LeftArm.getChild("LeftArmLayer_r1");
this.RightLeg = this.bone.getChild("RightLeg");
this.RightLeg_r1 = this.RightLeg.getChild("RightLeg_r1");
this.RightLegLayer_r1 = this.RightLeg.getChild("RightLegLayer_r1");
this.LeftLeg = this.bone.getChild("LeftLeg");
this.LeftLeg_r1 = this.LeftLeg.getChild("LeftLeg_r1");
this.LeftLegLayer_r1 = this.LeftLeg.getChild("LeftLegLayer_r1");
}
public static TexturedModelData getTexturedModelData() {
ModelData modelData = new ModelData();
ModelPartData modelPartData = modelData.getRoot();
		
		
ModelPartData modelPartData1 = modelPartData.addChild("bone", ModelPartBuilder.create(), ModelTransform.pivot(0.0F,24.0F,0.0F));
ModelPartData modelPartData2 = modelPartData1.addChild("LeftLeg", ModelPartBuilder.create(), ModelTransform.pivot(0.9F,-12.0F,4.0F));
modelPartData2.addChild("LeftLegLayer_r1", ModelPartBuilder.create().uv(0,48).cuboid(-0.1F, -12.0F, 0.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.25F)), ModelTransform.pivot(-1.9F,12.0F,0.0F));
modelPartData2.addChild("LeftLeg_r1", ModelPartBuilder.create().uv(16,48).cuboid(-0.1F, -12.0F, 0.0F, 4.0F, 12.0F, 4.0F), ModelTransform.pivot(-1.9F,12.0F,0.0F));
ModelPartData modelPartData3 = modelPartData1.addChild("RightLeg", ModelPartBuilder.create(), ModelTransform.pivot(-0.9F,-12.0F,-4.0F));
modelPartData3.addChild("RightLegLayer_r1", ModelPartBuilder.create().uv(0,32).cuboid(-3.9F, -12.0F, -4.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.25F)), ModelTransform.pivot(1.9F,12.0F,0.0F));
modelPartData3.addChild("RightLeg_r1", ModelPartBuilder.create().uv(0,16).cuboid(-3.9F, -12.0F, -4.0F, 4.0F, 12.0F, 4.0F), ModelTransform.pivot(1.9F,12.0F,0.0F));
ModelPartData modelPartData4 = modelPartData1.addChild("LeftArm", ModelPartBuilder.create(), ModelTransform.pivot(5.0F,-22.0F,-9.0F));
modelPartData4.addChild("LeftArmLayer_r1", ModelPartBuilder.create().uv(48,48).cuboid(4.0F, -24.0F, -7.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.25F)), ModelTransform.pivot(-5.0F,22.0F,0.0F));
modelPartData4.addChild("LeftArm_r1", ModelPartBuilder.create().uv(32,48).cuboid(4.0F, -24.0F, -7.0F, 4.0F, 12.0F, 4.0F), ModelTransform.pivot(-5.0F,22.0F,0.0F));
ModelPartData modelPartData5 = modelPartData1.addChild("RightArm", ModelPartBuilder.create(), ModelTransform.pivot(-5.0F,-22.0F,8.0F));
modelPartData5.addChild("RightArmLayer_r1", ModelPartBuilder.create().uv(40,32).cuboid(-8.0F, -24.0F, 2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.25F)), ModelTransform.pivot(5.0F,22.0F,0.0F));
modelPartData5.addChild("RightArm_r1", ModelPartBuilder.create().uv(40,16).cuboid(-8.0F, -24.0F, 2.0F, 4.0F, 12.0F, 4.0F), ModelTransform.pivot(5.0F,22.0F,0.0F));
ModelPartData modelPartData6 = modelPartData1.addChild("Body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F,-24.0F,0.0F));
modelPartData6.addChild("BodyLayer_r1", ModelPartBuilder.create().uv(16,32).cuboid(-4.0F, -24.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.25F)).uv(16,16).cuboid(-4.0F, -24.0F, -2.0F, 8.0F, 12.0F, 4.0F), ModelTransform.pivot(0.0F,24.0F,0.0F));
ModelPartData modelPartData7 = modelPartData1.addChild("Head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F,-24.0F,-1.0F));
modelPartData7.addChild("HatLayer_r1", ModelPartBuilder.create().uv(32,0).cuboid(-4.0F, -32.0F, -5.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.5F)), ModelTransform.pivot(0.0F,24.0F,0.0F));
modelPartData7.addChild("Head_r1", ModelPartBuilder.create().uv(0,0).cuboid(-4.0F, -32.0F, -5.0F, 8.0F, 8.0F, 8.0F), ModelTransform.pivot(0.0F,24.0F,0.0F));
return TexturedModelData.of(modelData,64,64);
		
		
		
		
		
}
@Override
public void setAngles(ProffessorEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
this.LeftLeg.pitch = -0.1745F;
this.LeftLeg.roll = -0.0349F;
this.LeftLegLayer_r1.pitch = 2.9687F;
this.LeftLegLayer_r1.yaw = 0.0551F;
this.LeftLegLayer_r1.roll = -3.0804F;
this.LeftLeg_r1.pitch = 2.9687F;
this.LeftLeg_r1.yaw = 0.0551F;
this.LeftLeg_r1.roll = -3.0804F;
this.RightLeg.pitch = 0.192F;
this.RightLeg.roll = 0.0349F;
this.RightLegLayer_r1.pitch = -2.9775F;
this.RightLegLayer_r1.yaw = 0.0561F;
this.RightLegLayer_r1.roll = 3.0813F;
this.RightLeg_r1.pitch = -2.9775F;
this.RightLeg_r1.yaw = 0.0561F;
this.RightLeg_r1.roll = 3.0813F;
this.LeftArm.pitch = 0.2094F;
this.LeftArmLayer_r1.pitch = -2.9407F;
this.LeftArmLayer_r1.yaw = 0.0427F;
this.LeftArmLayer_r1.roll = -3.1325F;
this.LeftArm_r1.pitch = -2.9407F;
this.LeftArm_r1.yaw = 0.0427F;
this.LeftArm_r1.roll = -3.1325F;
this.RightArm.pitch = -0.1745F;
this.RightArmLayer_r1.pitch = 2.9669F;
this.RightArmLayer_r1.yaw = 0.043F;
this.RightArmLayer_r1.roll = 3.134F;
this.RightArm_r1.pitch = 2.9669F;
this.RightArm_r1.yaw = 0.043F;
this.RightArm_r1.roll = 3.134F;
this.BodyLayer_r1.pitch = -3.1416F;
this.BodyLayer_r1.yaw = 0.0436F;
this.BodyLayer_r1.roll = 3.1416F;
this.Head.pitch = 0.0262F;
this.Head.yaw = 0.0873F;
this.HatLayer_r1.pitch = -3.1328F;
this.HatLayer_r1.yaw = 0.0436F;
this.HatLayer_r1.roll = -3.1404F;
this.Head_r1.pitch = -3.1327F;
this.Head_r1.yaw = 0.0872F;
this.Head_r1.roll = -3.1382F;
		//previously the render function, render code was moved to a method below
}
@Override
public void render(MatrixStack matrixStack, VertexConsumer	buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		
		bone.render(matrixStack, buffer, packedLight, packedOverlay);
}
public void setRotationAngle(ModelPart bone, float x, float y, float z) {
		bone.pitch = x;
		bone.yaw = y;
		bone.roll = z;
}



}