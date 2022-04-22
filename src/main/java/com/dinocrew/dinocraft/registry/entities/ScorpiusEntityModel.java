// Made with Model Converter by Globox_Z
// Generate all required imports
// Made with Blockbench 4.2.2
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	package com.dinocrew.dinocraft.registry.entities;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class ScorpiusEntityModel extends EntityModel<ScorpiusEntity> {
private final ModelPart rightleg;
	private final ModelPart cube_r1;
	private final ModelPart cube_r2;
	private final ModelPart cube_r3;
	private final ModelPart cube_r4;
	private final ModelPart cube_r5;
	private final ModelPart leftleg;
	private final ModelPart cube_r6;
	private final ModelPart cube_r7;
	private final ModelPart cube_r8;
	private final ModelPart cube_r9;
	private final ModelPart cube_r10;
	private final ModelPart bone2;
	private final ModelPart cube_r11;
	private final ModelPart bone3;
	private final ModelPart cube_r12;
	private final ModelPart cube_r13;
	private final ModelPart bone;
	private final ModelPart cube_r14;
	private final ModelPart cube_r15;
	private final ModelPart cube_r16;
	private final ModelPart cube_r17;
	private final ModelPart body;
	private final ModelPart cube_r18;
	private final ModelPart cube_r19;
	private final ModelPart cube_r20;
	private final ModelPart cube_r21;
	private final ModelPart cube_r22;
	private final ModelPart cube_r23;
	private final ModelPart bb_main;
	private final ModelPart cube_r24;
public ScorpiusEntityModel(ModelPart root) {
this.rightleg = root.getChild("rightleg");
this.cube_r5 = this.rightleg.getChild("cube_r5");
this.cube_r4 = this.rightleg.getChild("cube_r4");
this.cube_r3 = this.rightleg.getChild("cube_r3");
this.cube_r2 = this.rightleg.getChild("cube_r2");
this.cube_r1 = this.rightleg.getChild("cube_r1");
this.leftleg = root.getChild("leftleg");
this.cube_r10 = this.leftleg.getChild("cube_r10");
this.cube_r9 = this.leftleg.getChild("cube_r9");
this.cube_r8 = this.leftleg.getChild("cube_r8");
this.cube_r7 = this.leftleg.getChild("cube_r7");
this.cube_r6 = this.leftleg.getChild("cube_r6");
this.bone2 = root.getChild("bone2");
this.cube_r11 = this.bone2.getChild("cube_r11");
this.bone3 = root.getChild("bone3");
this.cube_r13 = this.bone3.getChild("cube_r13");
this.cube_r12 = this.bone3.getChild("cube_r12");
this.bone = root.getChild("bone");
this.cube_r17 = this.bone.getChild("cube_r17");
this.cube_r16 = this.bone.getChild("cube_r16");
this.cube_r15 = this.bone.getChild("cube_r15");
this.cube_r14 = this.bone.getChild("cube_r14");
this.body = root.getChild("body");
this.cube_r23 = this.body.getChild("cube_r23");
this.cube_r22 = this.body.getChild("cube_r22");
this.cube_r21 = this.body.getChild("cube_r21");
this.cube_r20 = this.body.getChild("cube_r20");
this.cube_r19 = this.body.getChild("cube_r19");
this.cube_r18 = this.body.getChild("cube_r18");
this.bb_main = root.getChild("bb_main");
this.cube_r24 = this.bb_main.getChild("cube_r24");
}
public static TexturedModelData getTexturedModelData() {
ModelData modelData = new ModelData();
ModelPartData modelPartData = modelData.getRoot();
		
ModelPartData modelPartData1 = modelPartData.addChild("rightleg", ModelPartBuilder.create(), ModelTransform.pivot(5.0F,24.0F,0.0F));
modelPartData1.addChild("cube_r1", ModelPartBuilder.create().uv(97,0).cuboid(14.0F, -6.0F, -8.0F, 0.0F, 6.0F, 10.0F), ModelTransform.pivot(-10.0F,0.0F,0.0F));
modelPartData1.addChild("cube_r2", ModelPartBuilder.create().uv(129,162).cuboid(9.0F, -4.0F, -8.0F, 8.0F, 4.0F, 13.0F, new Dilation(0.01F)), ModelTransform.pivot(-10.0F,0.0F,0.0F));
modelPartData1.addChild("cube_r3", ModelPartBuilder.create().uv(65,198).cuboid(13.0F, -28.0F, -7.0F, 0.0F, 9.0F, 2.0F).uv(65,198).cuboid(-3.0F, -28.0F, -7.0F, 0.0F, 9.0F, 2.0F).uv(76,62).cuboid(10.0F, -24.0F, -5.0F, 6.0F, 20.0F, 6.0F), ModelTransform.pivot(-10.0F,0.0F,0.0F));
modelPartData1.addChild("cube_r4", ModelPartBuilder.create().uv(104,43).cuboid(10.0F, -30.0F, -11.0F, 6.0F, 10.0F, 19.0F, new Dilation(0.01F)), ModelTransform.pivot(-10.0F,0.0F,0.0F));
modelPartData1.addChild("cube_r5", ModelPartBuilder.create().uv(144,62).cuboid(9.0F, -27.0F, 20.0F, 9.0F, 21.0F, 11.0F), ModelTransform.pivot(-10.0F,0.0F,0.0F));
ModelPartData modelPartData2 = modelPartData.addChild("leftleg", ModelPartBuilder.create(), ModelTransform.pivot(-5.0F,24.0F,0.0F));
modelPartData2.addChild("cube_r6", ModelPartBuilder.create().uv(129,162).cuboid(-17.0F, -4.0F, -8.0F, 8.0F, 4.0F, 13.0F, new Dilation(0.01F)), ModelTransform.pivot(10.0F,0.0F,0.0F));
modelPartData2.addChild("cube_r7", ModelPartBuilder.create().uv(0,0).cuboid(-16.0F, -24.0F, -5.0F, 6.0F, 20.0F, 6.0F), ModelTransform.pivot(10.0F,0.0F,0.0F));
modelPartData2.addChild("cube_r8", ModelPartBuilder.create().uv(0,86).cuboid(-14.0F, -6.0F, -8.0F, 0.0F, 6.0F, 10.0F), ModelTransform.pivot(10.0F,0.0F,0.0F));
modelPartData2.addChild("cube_r9", ModelPartBuilder.create().uv(104,0).cuboid(-16.0F, -30.0F, -11.0F, 6.0F, 10.0F, 19.0F, new Dilation(0.01F)), ModelTransform.pivot(10.0F,0.0F,0.0F));
modelPartData2.addChild("cube_r10", ModelPartBuilder.create().uv(0,142).cuboid(-18.0F, -27.0F, 20.0F, 9.0F, 21.0F, 11.0F), ModelTransform.pivot(10.0F,0.0F,0.0F));
ModelPartData modelPartData3 = modelPartData.addChild("bone2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F,13.0F,-17.0F));
modelPartData3.addChild("cube_r11", ModelPartBuilder.create().uv(156,0).cuboid(3.0F, -41.0F, -7.0F, 7.0F, 7.0F, 14.0F), ModelTransform.pivot(0.0F,0.0F,0.0F));
ModelPartData modelPartData4 = modelPartData.addChild("bone3", ModelPartBuilder.create(), ModelTransform.pivot(0.0F,13.0F,-17.0F));
modelPartData4.addChild("cube_r12", ModelPartBuilder.create().uv(85,0).cuboid(5.0F, -3.0F, 47.0F, 6.0F, 3.0F, 4.0F).uv(0,45).cuboid(10.0F, -2.0F, 56.0F, 0.0F, 3.0F, 4.0F).uv(0,45).cuboid(8.0F, -2.0F, 56.0F, 0.0F, 3.0F, 4.0F).uv(0,45).cuboid(6.0F, -2.0F, 56.0F, 0.0F, 3.0F, 4.0F).uv(111,107).cuboid(-6.0F, -2.0F, 56.0F, 0.0F, 3.0F, 4.0F).uv(111,107).cuboid(-8.0F, -2.0F, 56.0F, 0.0F, 3.0F, 4.0F).uv(111,107).cuboid(-10.0F, -2.0F, 56.0F, 0.0F, 3.0F, 4.0F).uv(95,62).cuboid(9.0F, -2.0F, 54.0F, 2.0F, 2.0F, 2.0F).uv(104,79).cuboid(7.0F, -2.0F, 54.0F, 2.0F, 2.0F, 2.0F).uv(0,119).cuboid(5.0F, -2.0F, 54.0F, 2.0F, 2.0F, 2.0F).uv(9,119).cuboid(-7.0F, -2.0F, 54.0F, 2.0F, 2.0F, 2.0F).uv(35,119).cuboid(-9.0F, -2.0F, 54.0F, 2.0F, 2.0F, 2.0F).uv(44,119).cuboid(-11.0F, -2.0F, 54.0F, 2.0F, 2.0F, 2.0F).uv(104,73).cuboid(5.0F, -2.0F, 51.0F, 2.0F, 2.0F, 3.0F).uv(104,88).cuboid(-7.0F, -2.0F, 51.0F, 2.0F, 2.0F, 3.0F).uv(28,98).cuboid(9.0F, -2.0F, 51.0F, 2.0F, 2.0F, 3.0F).uv(15,103).cuboid(7.0F, -2.0F, 51.0F, 2.0F, 2.0F, 3.0F).uv(111,30).cuboid(-9.0F, -2.0F, 51.0F, 2.0F, 2.0F, 3.0F).uv(115,88).cuboid(-11.0F, -2.0F, 51.0F, 2.0F, 2.0F, 3.0F).uv(47,95).cuboid(-11.0F, -3.0F, 47.0F, 6.0F, 3.0F, 4.0F).uv(77,138).cuboid(6.0F, -4.0F, 37.0F, 4.0F, 4.0F, 10.0F).uv(176,137).cuboid(-10.0F, -4.0F, 37.0F, 4.0F, 4.0F, 10.0F), ModelTransform.pivot(0.0F,0.0F,0.0F));
modelPartData4.addChild("cube_r13", ModelPartBuilder.create().uv(27,161).cuboid(-10.0F, -41.0F, -7.0F, 7.0F, 7.0F, 14.0F), ModelTransform.pivot(0.0F,0.0F,0.0F));
ModelPartData modelPartData5 = modelPartData.addChild("bone", ModelPartBuilder.create().uv(136,37).cuboid(-5.0F, -39.0F, 40.0F, 10.0F, 6.0F, 13.0F, new Dilation(0.01F)).uv(135,107).cuboid(-6.0F, -44.0F, 31.0F, 12.0F, 13.0F, 10.0F).uv(0,119).cuboid(-4.0F, -33.0F, 35.0F, 8.0F, 4.0F, 18.0F, new Dilation(-0.01F)).uv(167,77).cuboid(5.0F, -33.0F, 35.0F, 0.0F, 4.0F, 18.0F).uv(165,39).cuboid(-5.0F, -33.0F, 35.0F, 0.0F, 4.0F, 18.0F).uv(0,62).cuboid(-5.0F, -33.0F, 53.0F, 10.0F, 4.0F, 0.0F), ModelTransform.pivot(0.0F,22.0F,-4.0F));
modelPartData5.addChild("cube_r14", ModelPartBuilder.create().uv(142,144).cuboid(-5.0F, -53.0F, 26.0F, 10.0F, 4.0F, 13.0F), ModelTransform.pivot(0.0F,0.0F,0.0F));
modelPartData5.addChild("cube_r15", ModelPartBuilder.create().uv(70,161).cuboid(0.0F, -44.0F, 25.0F, 0.0F, 5.0F, 18.0F), ModelTransform.pivot(0.0F,0.0F,0.0F));
modelPartData5.addChild("cube_r16", ModelPartBuilder.create().uv(70,161).cuboid(0.0F, -44.0F, 25.0F, 0.0F, 5.0F, 18.0F), ModelTransform.pivot(0.0F,0.0F,0.0F));
modelPartData5.addChild("cube_r17", ModelPartBuilder.create().uv(70,161).cuboid(0.0F, -44.0F, 25.0F, 0.0F, 5.0F, 18.0F), ModelTransform.pivot(0.0F,0.0F,0.0F));
ModelPartData modelPartData6 = modelPartData.addChild("body", ModelPartBuilder.create().uv(63,29).cuboid(-6.0F, -29.0F, -23.0F, 12.0F, 16.0F, 16.0F), ModelTransform.pivot(0.0F,13.0F,-17.0F));
modelPartData6.addChild("cube_r18", ModelPartBuilder.create().uv(96,174).cuboid(-4.0F, -37.0F, -74.0F, 8.0F, 8.0F, 11.0F).uv(54,132).cuboid(0.0F, -43.0F, -60.0F, 0.0F, 6.0F, 22.0F).uv(54,132).cuboid(0.0F, -43.0F, -82.0F, 0.0F, 6.0F, 22.0F).uv(52,0).cuboid(-5.0F, -38.0F, -52.0F, 10.0F, 14.0F, 12.0F).uv(0,175).cuboid(-3.0F, -37.0F, -86.0F, 6.0F, 5.0F, 12.0F).uv(99,144).cuboid(-5.0F, -38.0F, -63.0F, 10.0F, 11.0F, 11.0F), ModelTransform.pivot(0.0F,11.0F,17.0F));
modelPartData6.addChild("cube_r19", ModelPartBuilder.create().uv(55,101).cuboid(-5.0F, -39.0F, 18.0F, 10.0F, 13.0F, 17.0F), ModelTransform.pivot(0.0F,11.0F,17.0F));
modelPartData6.addChild("cube_r20", ModelPartBuilder.create().uv(54,132).cuboid(-1.0F, -43.0F, -94.0F, 0.0F, 6.0F, 22.0F).uv(54,132).cuboid(1.0F, -43.0F, -60.0F, 0.0F, 6.0F, 22.0F).uv(54,132).cuboid(0.0F, -43.0F, -82.0F, 0.0F, 6.0F, 22.0F), ModelTransform.pivot(0.0F,11.0F,17.0F));
modelPartData6.addChild("cube_r21", ModelPartBuilder.create().uv(54,132).cuboid(1.0F, -43.0F, -94.0F, 0.0F, 6.0F, 22.0F).uv(54,132).cuboid(-1.0F, -43.0F, -60.0F, 0.0F, 6.0F, 22.0F).uv(54,132).cuboid(0.0F, -43.0F, -82.0F, 0.0F, 6.0F, 22.0F), ModelTransform.pivot(0.0F,11.0F,17.0F));
modelPartData6.addChild("cube_r22", ModelPartBuilder.create().uv(0,45).cuboid(-7.0F, -44.0F, -22.0F, 14.0F, 17.0F, 23.0F), ModelTransform.pivot(0.0F,11.0F,17.0F));
modelPartData6.addChild("cube_r23", ModelPartBuilder.create().uv(0,0).cuboid(-6.0F, -43.0F, -9.0F, 12.0F, 17.0F, 27.0F), ModelTransform.pivot(0.0F,11.0F,17.0F));
ModelPartData modelPartData7 = modelPartData.addChild("bb_main", ModelPartBuilder.create().uv(0,103).cuboid(-10.0F, -3.0F, 4.0F, 2.0F, 3.0F, 5.0F).uv(0,103).cuboid(-12.0F, -3.0F, 4.0F, 2.0F, 3.0F, 5.0F).uv(52,57).cuboid(8.0F, -3.0F, 4.0F, 2.0F, 3.0F, 5.0F).uv(52,57).cuboid(10.0F, -3.0F, 4.0F, 2.0F, 3.0F, 5.0F).uv(118,32).cuboid(-11.0F, -3.0F, 9.0F, 0.0F, 3.0F, 4.0F).uv(118,32).cuboid(-9.0F, -3.0F, 9.0F, 0.0F, 3.0F, 4.0F).uv(111,115).cuboid(9.0F, -3.0F, 9.0F, 0.0F, 3.0F, 4.0F).uv(111,115).cuboid(11.0F, -3.0F, 9.0F, 0.0F, 3.0F, 4.0F), ModelTransform.pivot(0.0F,24.0F,0.0F));
modelPartData7.addChild("cube_r24", ModelPartBuilder.create().uv(104,30).cuboid(6.0F, -15.0F, 0.0F, 0.0F, 6.0F, 6.0F).uv(28,86).cuboid(4.0F, -10.0F, 0.0F, 4.0F, 7.0F, 4.0F).uv(104,30).cuboid(-6.4191F, -15.0F, 0.0F, 0.0F, 6.0F, 6.0F).uv(28,86).cuboid(-8.4191F, -10.0F, 0.0F, 4.0F, 7.0F, 4.0F), ModelTransform.pivot(0.2095F,1.451F,-0.1822F));
return TexturedModelData.of(modelData,256,256);
		
		
		
}
@Override
public void setAngles(ScorpiusEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
this.cube_r1.pitch = -0.3054F;
this.cube_r1.yaw = 0.0436F;
this.cube_r2.yaw = 0.0436F;
this.cube_r3.pitch = 0.5672F;
this.cube_r4.pitch = 0.3054F;
this.cube_r5.pitch = 1.1781F;
this.cube_r6.yaw = -0.0436F;
this.cube_r7.pitch = 0.5672F;
this.cube_r8.pitch = -0.3054F;
this.cube_r8.yaw = -0.0436F;
this.cube_r9.pitch = 0.3054F;
this.cube_r10.pitch = 1.1781F;
this.bone2.pitch = -0.6545F;
this.cube_r11.pitch = -0.5816F;
this.cube_r11.yaw = 0.2316F;
this.cube_r11.roll = -0.1231F;
this.bone3.pitch = -0.6545F;
this.cube_r12.pitch = 0.9163F;
this.cube_r13.pitch = -0.5816F;
this.cube_r13.yaw = -0.2316F;
this.cube_r13.roll = 0.1231F;
this.bone.pitch = -0.0873F;
this.cube_r14.pitch = -0.3054F;
this.cube_r15.pitch = 0.0873F;
this.cube_r15.yaw = 0.0087F;
this.cube_r15.roll = -0.0873F;
this.cube_r16.pitch = 0.0873F;
this.cube_r16.yaw = -0.0087F;
this.cube_r16.roll = 0.0873F;
this.cube_r17.pitch = 0.0873F;
this.cube_r18.pitch = -0.0436F;
this.cube_r19.pitch = 0.0873F;
this.cube_r20.pitch = -0.0436F;
this.cube_r20.yaw = 0.0035F;
this.cube_r20.roll = 0.0855F;
this.cube_r21.pitch = -0.0436F;
this.cube_r21.yaw = -0.0035F;
this.cube_r21.roll = -0.0873F;
this.cube_r22.pitch = 0.1309F;
this.cube_r23.pitch = -0.0873F;
this.cube_r24.pitch = -0.3491F;
		//previously the render function, render code was moved to a method below
}
@Override
public void render(MatrixStack matrixStack, VertexConsumer	buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		
		rightleg.render(matrixStack, buffer, packedLight, packedOverlay);
		leftleg.render(matrixStack, buffer, packedLight, packedOverlay);
		bone2.render(matrixStack, buffer, packedLight, packedOverlay);
		bone3.render(matrixStack, buffer, packedLight, packedOverlay);
		bone.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
}
public void setRotationAngle(ModelPart bone, float x, float y, float z) {
		bone.pitch = x;
		bone.yaw = y;
		bone.roll = z;
}


}