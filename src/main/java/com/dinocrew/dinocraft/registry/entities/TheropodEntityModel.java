// Made with Model Converter by Globox_Z
// Generate all required imports
// Made with Blockbench 3.9.2
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	package com.dinocrew.dinocraft.registry.entities;

import com.dinocrew.dinocraft.registry.entities.TheropodEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class TheropodEntityModel extends EntityModel<TheropodEntity> {
private final ModelPart torso;
	private final ModelPart tail;
	private final ModelPart tailtwo;
	private final ModelPart tailthree;
	private final ModelPart tailfour;
	private final ModelPart neck;
	private final ModelPart rightarm;
	private final ModelPart rightarmbend;
	private final ModelPart leftfinger;
	private final ModelPart rightfinger;
	private final ModelPart head;
	private final ModelPart jaw;
	private final ModelPart bottomjaw;
	private final ModelPart leftarm;
	private final ModelPart leftarmbend;
	private final ModelPart leftarmfinger;
	private final ModelPart leftarmfingertwo;
	private final ModelPart leftleg;
	private final ModelPart leftlegbend;
	private final ModelPart leftlegfoot;
	private final ModelPart leftoe;
	private final ModelPart rightwo;
	private final ModelPart middletoetwo;
	private final ModelPart toespiketwo;
	private final ModelPart rightleg;
	private final ModelPart rightlegbend;
	private final ModelPart rightlefoot;
	private final ModelPart lefttoerightfoot;
	private final ModelPart rightfootlefttoe;
	private final ModelPart middletoerightfoot;
	private final ModelPart toespike;
	public TheropodEntityModel(ModelPart root){
this.torso = root.getChild("torso");
this.neck = this.torso.getChild("neck");
this.tail = this.torso.getChild("tail");
this.tailtwo = this.tail.getChild("tailtwo");
this.tailthree = this.tailtwo.getChild("tailthree");
this.tailfour = this.tailthree.getChild("tailfour");
this.rightarm = root.getChild("rightarm");
this.rightarmbend = this.rightarm.getChild("rightarmbend");
this.rightfinger = this.rightarmbend.getChild("rightfinger");
this.leftfinger = this.rightarmbend.getChild("leftfinger");
this.head = root.getChild("head");
this.bottomjaw = this.head.getChild("bottomjaw");
this.jaw = this.head.getChild("jaw");
this.leftarm = root.getChild("leftarm");
this.leftarmbend = this.leftarm.getChild("leftarmbend");
this.leftarmfingertwo = this.leftarmbend.getChild("leftarmfingertwo");
this.leftarmfinger = this.leftarmbend.getChild("leftarmfinger");
this.leftleg = root.getChild("leftleg");
this.leftlegfoot = this.leftleg.getChild("leftlegfoot");
this.toespiketwo = this.leftlegfoot.getChild("toespiketwo");
this.middletoetwo = this.leftlegfoot.getChild("middletoetwo");
this.rightwo = this.leftlegfoot.getChild("rightwo");
this.leftoe = this.leftlegfoot.getChild("leftoe");
this.leftlegbend = this.leftleg.getChild("leftlegbend");
this.rightleg = root.getChild("rightleg");
this.rightlefoot = this.rightleg.getChild("rightlefoot");
this.toespike = this.rightlefoot.getChild("toespike");
this.middletoerightfoot = this.rightlefoot.getChild("middletoerightfoot");
this.rightfootlefttoe = this.rightlefoot.getChild("rightfootlefttoe");
this.lefttoerightfoot = this.rightlefoot.getChild("lefttoerightfoot");
this.rightlegbend = this.rightleg.getChild("rightlegbend");
}
public static TexturedModelData getTexturedModelData() {
ModelData modelData = new ModelData();
ModelPartData modelPartData = modelData.getRoot();
ModelPartData modelPartData1 = modelPartData.addChild("torso", ModelPartBuilder.create().uv(0,0).cuboid(-27.3333F, -18.0F, -10.8333F, 25.0F, 15.0F, 21.0F).uv(0,36).cuboid(-2.3333F, -17.0F, -9.8333F, 18.0F, 13.0F, 19.0F), ModelTransform.pivot(-2.6667F,8.0F,0.3333F));
ModelPartData modelPartData2 = modelPartData1.addChild("tail", ModelPartBuilder.create().uv(76,20).cuboid(-1.5F, -6.0F, -8.0F, 8.0F, 11.0F, 16.0F), ModelTransform.pivot(16.1667F,-11.0F,-0.3333F));
ModelPartData modelPartData3 = modelPartData2.addChild("tailtwo", ModelPartBuilder.create().uv(54,87).cuboid(0.0F, -4.5F, -6.0F, 10.0F, 9.0F, 12.0F), ModelTransform.pivot(5.0F,-1.5F,0.0F));
ModelPartData modelPartData4 = modelPartData3.addChild("tailthree", ModelPartBuilder.create().uv(38,108).cuboid(-1.0F, -3.5F, -4.0F, 7.0F, 7.0F, 8.0F), ModelTransform.pivot(10.0F,-1.0F,0.0F));
modelPartData4.addChild("tailfour", ModelPartBuilder.create().uv(0,0).cuboid(6.0F, -3.0F, -2.0F, 6.0F, 4.0F, 4.0F), ModelTransform.pivot(0.0F,0.0F,0.0F));
modelPartData1.addChild("neck", ModelPartBuilder.create().uv(0,72).cuboid(-15.0F, -6.5F, -7.0F, 18.0F, 12.0F, 15.0F), ModelTransform.pivot(-27.3333F,-11.5F,-0.8333F));
ModelPartData modelPartData5 = modelPartData.addChild("rightarm", ModelPartBuilder.create().uv(0,68).cuboid(-1.5F, -1.469F, -0.5984F, 3.0F, 10.0F, 3.0F), ModelTransform.pivot(-21.5F,-7.5F,-10.5F));
ModelPartData modelPartData6 = modelPartData5.addChild("rightarmbend", ModelPartBuilder.create().uv(0,36).cuboid(-3.5F, -0.5F, -1.5F, 3.0F, 11.0F, 3.0F), ModelTransform.pivot(0.0F,10.031F,0.9016F));
modelPartData6.addChild("leftfinger", ModelPartBuilder.create().uv(55,36).cuboid(-1.0F, -1.5F, -1.0F, 2.0F, 3.0F, 2.0F), ModelTransform.pivot(-2.0F,11.5F,1.0F));
modelPartData6.addChild("rightfinger", ModelPartBuilder.create().uv(55,36).cuboid(-1.0F, -1.5F, -1.0F, 2.0F, 3.0F, 2.0F), ModelTransform.pivot(-2.0F,11.5F,-1.0F));
ModelPartData modelPartData7 = modelPartData.addChild("head", ModelPartBuilder.create().uv(57,57).cuboid(-10.6667F, -9.5F, -7.6667F, 16.0F, 13.0F, 17.0F), ModelTransform.pivot(-40.3333F,-13.5F,-0.8333F));
modelPartData7.addChild("jaw", ModelPartBuilder.create().uv(85,95).cuboid(-59.0F, -45.0F, -6.5F, 8.0F, 6.0F, 13.0F).uv(106,47).cuboid(-58.0F, -39.0F, -5.5F, 7.0F, 4.0F, 11.0F), ModelTransform.pivot(40.3333F,37.5F,0.8333F));
modelPartData7.addChild("bottomjaw", ModelPartBuilder.create(), ModelTransform.pivot(40.3333F,37.5F,0.8333F));
ModelPartData modelPartData8 = modelPartData.addChild("leftarm", ModelPartBuilder.create().uv(0,68).cuboid(-1.5F, -1.469F, -2.4016F, 3.0F, 10.0F, 3.0F), ModelTransform.pivot(-21.5F,-7.5F,10.5F));
ModelPartData modelPartData9 = modelPartData8.addChild("leftarmbend", ModelPartBuilder.create().uv(0,36).cuboid(-3.5F, -0.5F, -1.5F, 3.0F, 11.0F, 3.0F), ModelTransform.pivot(0.0F,10.031F,-0.9016F));
modelPartData9.addChild("leftarmfinger", ModelPartBuilder.create().uv(55,36).cuboid(-1.0F, -1.5F, -1.0F, 2.0F, 3.0F, 2.0F), ModelTransform.pivot(-2.0F,11.5F,1.0F));
modelPartData9.addChild("leftarmfingertwo", ModelPartBuilder.create().uv(55,36).cuboid(-1.0F, -1.5F, -1.0F, 2.0F, 3.0F, 2.0F), ModelTransform.pivot(-2.0F,11.5F,-1.0F));
ModelPartData modelPartData10 = modelPartData.addChild("leftleg", ModelPartBuilder.create().uv(0,99).cuboid(-6.0F, -4.0F, -4.5F, 10.0F, 11.0F, 9.0F), ModelTransform.pivot(6.0F,-1.0F,11.5F));
modelPartData10.addChild("leftlegbend", ModelPartBuilder.create().uv(71,0).cuboid(2.9619F, 0.8716F, -3.0F, 18.0F, 5.0F, 8.0F), ModelTransform.pivot(-2.0F,4.0F,3.0F));
ModelPartData modelPartData11 = modelPartData10.addChild("leftlegfoot", ModelPartBuilder.create().uv(68,108).cuboid(-5.2622F, -3.0077F, -3.8F, 4.0F, 11.0F, 8.0F), ModelTransform.pivot(-0.8F,10.9F,-15.2F));
modelPartData11.addChild("leftoe", ModelPartBuilder.create().uv(0,13).cuboid(6.5F, -1.0F, -4.5F, 7.0F, 2.0F, 3.0F, true), ModelTransform.pivot(-4.7622F,6.9923F,4.7F));
modelPartData11.addChild("rightwo", ModelPartBuilder.create().uv(0,13).cuboid(6.5F, -1.0F, 1.5F, 7.0F, 2.0F, 3.0F, true), ModelTransform.pivot(-4.7622F,6.9923F,-4.3F));
modelPartData11.addChild("middletoetwo", ModelPartBuilder.create().uv(55,43).cuboid(3.5F, -1.0F, -2.0F, 7.0F, 2.0F, 4.0F, true), ModelTransform.pivot(-4.7622F,6.9923F,0.2F));
modelPartData11.addChild("toespiketwo", ModelPartBuilder.create().uv(0,50).cuboid(1.5F, -4.0F, -1.0F, 6.0F, 2.0F, 2.0F), ModelTransform.pivot(0.2378F,-1.0077F,0.2F));
ModelPartData modelPartData12 = modelPartData.addChild("rightleg", ModelPartBuilder.create().uv(0,99).cuboid(-6.0F, -4.0F, -4.5F, 10.0F, 11.0F, 9.0F), ModelTransform.pivot(6.0F,-1.0F,-9.5F));
modelPartData12.addChild("rightlegbend", ModelPartBuilder.create().uv(71,0).cuboid(2.9619F, 0.8716F, -3.0F, 18.0F, 5.0F, 8.0F), ModelTransform.pivot(-2.0F,4.0F,3.0F));
ModelPartData modelPartData13 = modelPartData12.addChild("rightlefoot", ModelPartBuilder.create().uv(68,108).cuboid(-5.2622F, -3.0077F, -3.8F, 4.0F, 11.0F, 8.0F), ModelTransform.pivot(-0.8F,10.9F,-15.2F));
modelPartData13.addChild("lefttoerightfoot", ModelPartBuilder.create().uv(0,13).cuboid(6.5F, -1.0F, -4.5F, 7.0F, 2.0F, 3.0F, true), ModelTransform.pivot(-4.7622F,6.9923F,4.7F));
modelPartData13.addChild("rightfootlefttoe", ModelPartBuilder.create().uv(0,13).cuboid(6.5F, -1.0F, 1.5F, 7.0F, 2.0F, 3.0F, true), ModelTransform.pivot(-4.7622F,6.9923F,-4.3F));
modelPartData13.addChild("middletoerightfoot", ModelPartBuilder.create().uv(55,43).cuboid(3.5F, -1.0F, -2.0F, 7.0F, 2.0F, 4.0F, true), ModelTransform.pivot(-4.7622F,6.9923F,0.2F));
modelPartData13.addChild("toespike", ModelPartBuilder.create().uv(0,50).cuboid(1.5F, -4.0F, -1.0F, 6.0F, 2.0F, 2.0F), ModelTransform.pivot(0.2378F,-1.0077F,0.2F));
return TexturedModelData.of(modelData,256,256);

}


@Override
public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		
		torso.render(matrixStack, buffer, packedLight, packedOverlay);
		rightarm.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		leftarm.render(matrixStack, buffer, packedLight, packedOverlay);
		leftleg.render(matrixStack, buffer, packedLight, packedOverlay);
		rightleg.render(matrixStack, buffer, packedLight, packedOverlay);
}
public void setRotationAngle(ModelPart bone, float x, float y, float z) {
		bone.pitch = x;
		bone.yaw = y;
		bone.roll = z;
}

	@Override
	public void setAngles(TheropodEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		setRotationAngle(rightarm, -0.6109F, 0.0F, 0.0F);
		setRotationAngle(rightarmbend, 1.1345F, 0.0F, 1.1345F);
		setRotationAngle(leftfinger, 0.3491F, 0.0F, 0.0F);
		setRotationAngle(rightfinger, -0.3491F, 0.0F, 0.0F);
		setRotationAngle(leftarm, 0.6109F, 0.0F, 0.0F);
		setRotationAngle(leftarmbend, -1.1345F, 0.0F, 1.1345F);
		setRotationAngle(leftarmfinger, 0.3491F, 0.0F, 0.0F);
		setRotationAngle(leftarmfingertwo, -0.3491F, 0.0F, 0.0F);
		setRotationAngle(leftleg, 0.0F, -1.5708F, 0.5236F);
		setRotationAngle(leftlegbend, 0.4363F, 1.5708F, 0.4363F);
		setRotationAngle(leftlegfoot, -1.5708F, -1.0472F, 1.5708F);
		setRotationAngle(leftoe, 0.0F, 0.6981F, 0.0F);
		setRotationAngle(rightwo, 0.0F, -0.6981F, 0.0F);
		setRotationAngle(toespiketwo, 0.0F, -3.0543F, -0.7854F);
		setRotationAngle(rightleg, 0.0F, -1.5708F, 0.5236F);
		setRotationAngle(rightlegbend, 0.4363F, 1.5708F, 0.4363F);
		setRotationAngle(rightlefoot, -1.5708F, -1.0472F, 1.5708F);
		setRotationAngle(lefttoerightfoot, 0.0F, 0.6981F, 0.0F);
		setRotationAngle(rightfootlefttoe, 0.0F, -0.6981F, 0.0F);
		setRotationAngle(toespike, 0.0F, -3.0543F, -0.7854F);
		setRotationAngle(torso, 0.0F, 0.0F, 0.1745F);
		setRotationAngle(tail, 0.0F, 0.0F, -0.0873F);
		setRotationAngle(tailtwo, 0.0F, 0.0F, -0.0873F);
		setRotationAngle(tailthree, 0.0F, 0.0F, -0.0873F);
		setRotationAngle(neck, 0.0F, 0.0F, 0.4363F);

		this.leftleg.pitch = MathHelper.cos(limbAngle * 0.6662F) * 1.4F * limbDistance;
		this.rightleg.pitch = MathHelper.cos(limbAngle * 0.6662F + 3.1415927F) * 1.4F * limbDistance;
	}
}