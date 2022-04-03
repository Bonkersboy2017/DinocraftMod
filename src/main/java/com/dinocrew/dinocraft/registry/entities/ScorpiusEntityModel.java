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

public class ScorpiusEntityModel extends EntityModel<ScorpiusEntity> {
private final ModelPart body;
	private final ModelPart neck1;
	private final ModelPart neck2;
	private final ModelPart head;
	private final ModelPart jaw;
	private final ModelPart left_head_spine;
	private final ModelPart right_head_spine;
	private final ModelPart right_hip;
	private final ModelPart right_leg;
	private final ModelPart right_knee;
	private final ModelPart right_foot;
	private final ModelPart left_hip;
	private final ModelPart left_leg;
	private final ModelPart left_knee;
	private final ModelPart left_foot;
	private final ModelPart right_arm;
	private final ModelPart right_wrist;
	private final ModelPart right_hand;
	private final ModelPart left_arm;
	private final ModelPart left_wrist;
	private final ModelPart left_hand;
	private final ModelPart tail1;
	private final ModelPart tail2;
	private final ModelPart tail3;
	private final ModelPart left_tail_spine;
	private final ModelPart right_tail_spine;
public ScorpiusEntityModel(ModelPart root) {
this.body = root.getChild("body");
this.tail1 = this.body.getChild("tail1");
this.tail2 = this.tail1.getChild("tail2");
this.tail3 = this.tail2.getChild("tail3");
this.right_tail_spine = this.tail3.getChild("right_tail_spine");
this.left_tail_spine = this.tail3.getChild("left_tail_spine");
this.left_arm = this.body.getChild("left_arm");
this.left_wrist = this.left_arm.getChild("left_wrist");
this.left_hand = this.left_wrist.getChild("left_hand");
this.right_arm = this.body.getChild("right_arm");
this.right_wrist = this.right_arm.getChild("right_wrist");
this.right_hand = this.right_wrist.getChild("right_hand");
this.left_hip = this.body.getChild("left_hip");
this.left_leg = this.left_hip.getChild("left_leg");
this.left_knee = this.left_leg.getChild("left_knee");
this.left_foot = this.left_knee.getChild("left_foot");
this.right_hip = this.body.getChild("right_hip");
this.right_leg = this.right_hip.getChild("right_leg");
this.right_knee = this.right_leg.getChild("right_knee");
this.right_foot = this.right_knee.getChild("right_foot");
this.neck1 = this.body.getChild("neck1");
this.neck2 = this.neck1.getChild("neck2");
this.head = this.neck2.getChild("head");
this.right_head_spine = this.head.getChild("right_head_spine");
this.left_head_spine = this.head.getChild("left_head_spine");
this.jaw = this.head.getChild("jaw");
}
public static TexturedModelData getTexturedModelData() {
ModelData modelData = new ModelData();
ModelPartData modelPartData = modelData.getRoot();
ModelPartData modelPartData1 = modelPartData.addChild("body", ModelPartBuilder.create().uv(0,0).cuboid(-6.0F, -6.0F, -9.0F, 12.0F, 12.0F, 18.0F).uv(0,51).cuboid(0.0F, -12.0F, -7.0F, 0.0F, 6.0F, 14.0F), ModelTransform.pivot(0.0F,0.0F,0.0F));
ModelPartData modelPartData2 = modelPartData1.addChild("neck1", ModelPartBuilder.create().uv(58,48).cuboid(-4.0F, -4.5F, -8.0F, 8.0F, 9.0F, 8.0F), ModelTransform.pivot(0.0F,-1.5F,-5.0F));
ModelPartData modelPartData3 = modelPartData2.addChild("neck2", ModelPartBuilder.create().uv(78,0).cuboid(-3.0F, -3.0F, -7.25F, 6.0F, 6.0F, 8.0F), ModelTransform.pivot(0.0F,0.0F,-6.25F));
ModelPartData modelPartData4 = modelPartData3.addChild("head", ModelPartBuilder.create().uv(24,34).cuboid(-4.5F, -5.0F, -12.0F, 9.0F, 10.0F, 12.0F).uv(70,79).cuboid(-3.5F, -4.0F, -20.0F, 7.0F, 7.0F, 8.0F), ModelTransform.pivot(0.0F,-3.0F,-7.25F));
modelPartData4.addChild("jaw", ModelPartBuilder.create().uv(62,65).cuboid(-2.5F, 0.0F, -11.0F, 6.0F, 4.0F, 10.0F), ModelTransform.pivot(-0.5F,3.0F,-7.0F));
modelPartData4.addChild("left_head_spine", ModelPartBuilder.create().uv(0,12).cuboid(0.0F, -11.0F, -12.0F, 0.0F, 16.0F, 18.0F), ModelTransform.pivot(0.0F,0.0F,0.0F));
modelPartData4.addChild("right_head_spine", ModelPartBuilder.create().uv(0,12).cuboid(0.0F, -11.0F, -12.0F, 0.0F, 16.0F, 18.0F), ModelTransform.pivot(0.0F,0.0F,0.0F));
ModelPartData modelPartData5 = modelPartData1.addChild("right_hip", ModelPartBuilder.create().uv(32,58).cuboid(-3.0F, -3.0F, -5.0F, 6.0F, 12.0F, 8.0F, true), ModelTransform.pivot(-4.5F,1.5F,6.5F));
ModelPartData modelPartData6 = modelPartData5.addChild("right_leg", ModelPartBuilder.create().uv(82,14).cuboid(-2.5F, -1.5F, -3.0F, 5.0F, 8.0F, 6.0F, true), ModelTransform.pivot(0.0F,6.5F,1.0F));
ModelPartData modelPartData7 = modelPartData6.addChild("right_knee", ModelPartBuilder.create().uv(0,85).cuboid(-2.0F, -6.0F, -2.0F, 4.0F, 16.0F, 4.0F, true), ModelTransform.pivot(0.0F,4.5F,-1.5F));
modelPartData7.addChild("right_foot", ModelPartBuilder.create().uv(70,38).cuboid(-3.0F, 0.0F, -6.5F, 6.0F, 2.0F, 8.0F, true), ModelTransform.pivot(0.0F,9.5F,-0.5F));
ModelPartData modelPartData8 = modelPartData1.addChild("left_hip", ModelPartBuilder.create().uv(32,58).cuboid(-3.0F, -3.0F, -5.0F, 6.0F, 12.0F, 8.0F), ModelTransform.pivot(4.5F,1.5F,6.5F));
ModelPartData modelPartData9 = modelPartData8.addChild("left_leg", ModelPartBuilder.create().uv(82,14).cuboid(-2.5F, -1.5F, -3.0F, 5.0F, 8.0F, 6.0F), ModelTransform.pivot(0.0F,6.5F,1.0F));
ModelPartData modelPartData10 = modelPartData9.addChild("left_knee", ModelPartBuilder.create().uv(0,85).cuboid(-2.0F, -6.0F, -2.0F, 4.0F, 16.0F, 4.0F), ModelTransform.pivot(0.0F,4.5F,-1.5F));
modelPartData10.addChild("left_foot", ModelPartBuilder.create().uv(70,38).cuboid(-3.0F, 0.0F, -6.5F, 6.0F, 2.0F, 8.0F), ModelTransform.pivot(0.0F,9.5F,-0.5F));
ModelPartData modelPartData11 = modelPartData1.addChild("right_arm", ModelPartBuilder.create().uv(0,0).cuboid(-2.5F, -1.0F, -2.5F, 4.0F, 13.0F, 5.0F), ModelTransform.pivot(-5.5F,-2.0F,-6.5F));
ModelPartData modelPartData12 = modelPartData11.addChild("right_wrist", ModelPartBuilder.create().uv(26,84).cuboid(-1.5F, -0.75F, -2.0F, 3.0F, 10.0F, 4.0F).uv(40,88).cuboid(-1.0F, -7.0F, -1.0F, 0.0F, 7.0F, 3.0F), ModelTransform.pivot(-0.5F,11.25F,0.0F));
modelPartData12.addChild("right_hand", ModelPartBuilder.create().uv(66,0).cuboid(-2.5F, -0.75F, -1.0F, 5.0F, 6.0F, 2.0F), ModelTransform.pivot(0.0F,8.5F,0.0F));
ModelPartData modelPartData13 = modelPartData1.addChild("left_arm", ModelPartBuilder.create().uv(0,0).cuboid(-1.5F, -1.0F, -2.5F, 4.0F, 13.0F, 5.0F, true), ModelTransform.pivot(5.5F,-2.0F,-6.5F));
ModelPartData modelPartData14 = modelPartData13.addChild("left_wrist", ModelPartBuilder.create().uv(26,84).cuboid(-1.5F, -0.75F, -2.0F, 3.0F, 10.0F, 4.0F, true).uv(40,88).cuboid(1.0F, -7.0F, -1.0F, 0.0F, 7.0F, 3.0F), ModelTransform.pivot(0.5F,11.25F,0.0F));
modelPartData14.addChild("left_hand", ModelPartBuilder.create().uv(66,0).cuboid(-2.5F, -0.75F, -1.0F, 5.0F, 6.0F, 2.0F, true), ModelTransform.pivot(0.0F,8.5F,0.0F));
ModelPartData modelPartData15 = modelPartData1.addChild("tail1", ModelPartBuilder.create().uv(54,18).cuboid(-4.0F, -3.0F, 0.0F, 8.0F, 8.0F, 12.0F).uv(54,67).cuboid(0.0F, -9.0F, 0.0F, 0.0F, 6.0F, 12.0F), ModelTransform.pivot(0.0F,-3.0F,7.0F));
ModelPartData modelPartData16 = modelPartData15.addChild("tail2", ModelPartBuilder.create().uv(42,0).cuboid(-3.0F, -5.0F, 0.0F, 6.0F, 6.0F, 12.0F).uv(30,66).cuboid(0.0F, -11.0F, 0.0F, 0.0F, 6.0F, 12.0F), ModelTransform.pivot(0.0F,3.0F,12.0F));
ModelPartData modelPartData17 = modelPartData16.addChild("tail3", ModelPartBuilder.create().uv(0,46).cuboid(-2.0F, -2.0F, 0.0F, 4.0F, 3.0F, 16.0F), ModelTransform.pivot(0.0F,-1.0F,12.0F));
modelPartData17.addChild("left_tail_spine", ModelPartBuilder.create().uv(84,73).cuboid(0.0F, -10.0F, 0.0F, 0.0F, 10.0F, 22.0F), ModelTransform.pivot(0.0F,-2.0F,0.0F));
modelPartData17.addChild("right_tail_spine", ModelPartBuilder.create().uv(84,73).cuboid(0.0F, -10.0F, 0.0F, 0.0F, 10.0F, 22.0F), ModelTransform.pivot(0.0F,-2.0F,0.0F));
return TexturedModelData.of(modelData,128,128);
}
@Override
public void setAngles(ScorpiusEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
this.body.pitch = -0.48F;
this.neck1.pitch = -0.3491F;
this.neck2.pitch = -0.48F;
this.head.pitch = 1.3963F;
this.left_head_spine.roll = 0.2618F;
this.right_head_spine.roll = -0.2618F;
this.right_hip.pitch = 0.1309F;
this.right_leg.pitch = 1.2217F;
this.right_knee.pitch = -1.3963F;
this.right_foot.pitch = 0.5236F;
this.left_hip.pitch = 0.1309F;
this.left_leg.pitch = 1.2217F;
this.left_knee.pitch = -1.3963F;
this.left_foot.pitch = 0.5236F;
this.right_arm.pitch = 0.48F;
this.right_wrist.pitch = -0.7418F;
this.right_hand.pitch = 0.8727F;
this.left_arm.pitch = 0.48F;
this.left_wrist.pitch = -0.7418F;
this.left_hand.pitch = 0.8727F;
this.tail1.pitch = -0.2618F;
this.tail2.pitch = 0.3054F;
this.tail3.pitch = 0.3491F;
this.left_tail_spine.roll = 0.5672F;
this.right_tail_spine.roll = -0.5672F;
		//previously the render function, render code was moved to a method below
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
	}