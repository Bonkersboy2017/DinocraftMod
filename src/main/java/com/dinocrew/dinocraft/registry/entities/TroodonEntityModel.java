// Made with Model Converter by Globox_Z
// Generate all required imports
// Made with Blockbench 3.9.2
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	package com.dinocrew.dinocraft.registry.entities;

import com.dinocrew.dinocraft.registry.entities.TroodonEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class TroodonEntityModel extends EntityModel<TroodonEntity> {
private final ModelPart torso;
	private final ModelPart neck;
	private final ModelPart tail;
	private final ModelPart tailtwo;
	private final ModelPart tailthree;
	private final ModelPart leftleg;
	private final ModelPart leftlegbend;
	private final ModelPart leftfoot;
	private final ModelPart toe;
	private final ModelPart othertoe;
	private final ModelPart rightleg;
	private final ModelPart rightlegbend;
	private final ModelPart rightfoot;
	private final ModelPart toetwo;
	private final ModelPart toethree;
	private final ModelPart leftarm;
	private final ModelPart leftarmbend;
	private final ModelPart leftfinger;
	private final ModelPart rightfinger;
	private final ModelPart middlefinger;
	private final ModelPart leftarm1;
	private final ModelPart leftarmbend1;
	private final ModelPart leftfingerleft;
	private final ModelPart leftfingerrighjt;
	private final ModelPart middlefingerleft;
	private final ModelPart head;
	private final ModelPart jaw;
	private final ModelPart bottomjaw;
	public TroodonEntityModel(ModelPart root){
this.torso = root.getChild("torso");
this.tail = this.torso.getChild("tail");
this.tailtwo = this.tail.getChild("tailtwo");
this.tailthree = this.tailtwo.getChild("tailthree");
this.neck = this.torso.getChild("neck");
this.leftleg = root.getChild("leftleg");
this.leftlegbend = this.leftleg.getChild("leftlegbend");
this.leftfoot = this.leftlegbend.getChild("leftfoot");
this.othertoe = this.leftfoot.getChild("othertoe");
this.toe = this.leftfoot.getChild("toe");
this.rightleg = root.getChild("rightleg");
this.rightlegbend = this.rightleg.getChild("rightlegbend");
this.rightfoot = this.rightlegbend.getChild("rightfoot");
this.toethree = this.rightfoot.getChild("toethree");
this.toetwo = this.rightfoot.getChild("toetwo");
this.leftarm = root.getChild("leftarm");
this.middlefinger = this.leftarm.getChild("middlefinger");
this.rightfinger = this.leftarm.getChild("rightfinger");
this.leftfinger = this.leftarm.getChild("leftfinger");
this.leftarmbend = this.leftarm.getChild("leftarmbend");
this.leftarm1 = root.getChild("leftarm1");
this.middlefingerleft = this.leftarm1.getChild("middlefingerleft");
this.leftfingerrighjt = this.leftarm1.getChild("leftfingerrighjt");
this.leftfingerleft = this.leftarm1.getChild("leftfingerleft");
this.leftarmbend1 = this.leftarm1.getChild("leftarmbend1");
this.head = root.getChild("head");
this.bottomjaw = this.head.getChild("bottomjaw");
this.jaw = this.head.getChild("jaw");
}
public static TexturedModelData getTexturedModelData() {
ModelData modelData = new ModelData();
ModelPartData modelPartData = modelData.getRoot();
ModelPartData modelPartData1 = modelPartData.addChild("torso", ModelPartBuilder.create().uv(0,0).cuboid(-6.0F, -5.0F, -23.0F, 12.0F, 8.0F, 26.0F), ModelTransform.pivot(0.0F,6.0F,10.0F));
modelPartData1.addChild("neck", ModelPartBuilder.create().uv(0,51).cuboid(-4.0F, -5.0F, -5.5F, 8.0F, 6.0F, 7.0F), ModelTransform.pivot(0.0F,-2.0F,-22.5F));
ModelPartData modelPartData2 = modelPartData1.addChild("tail", ModelPartBuilder.create().uv(40,40).cuboid(-5.0F, -3.0F, -2.5F, 10.0F, 6.0F, 8.0F), ModelTransform.pivot(0.0F,-2.0F,3.5F));
ModelPartData modelPartData3 = modelPartData2.addChild("tailtwo", ModelPartBuilder.create().uv(50,0).cuboid(-3.0F, -3.0F, 0.0359F, 6.0F, 6.0F, 9.0F), ModelTransform.pivot(0.0F,0.0F,4.0F));
modelPartData3.addChild("tailthree", ModelPartBuilder.create().uv(0,0).cuboid(-1.0F, 2.0F, 6.0359F, 3.0F, 4.0F, 9.0F), ModelTransform.pivot(0.0F,0.0F,0.0F));
ModelPartData modelPartData4 = modelPartData.addChild("leftleg", ModelPartBuilder.create().uv(48,54).cuboid(-2.0F, -2.351F, -2.4183F, 4.0F, 10.0F, 5.0F), ModelTransform.pivot(-7.0F,5.0F,8.0F));
ModelPartData modelPartData5 = modelPartData4.addChild("leftlegbend", ModelPartBuilder.create().uv(68,34).cuboid(-2.0F, -4.5F, -2.0F, 4.0F, 10.0F, 3.0F), ModelTransform.pivot(0.0F,7.149F,1.5817F));
ModelPartData modelPartData6 = modelPartData5.addChild("leftfoot", ModelPartBuilder.create().uv(0,72).cuboid(-1.5F, -1.0F, -2.5F, 4.0F, 7.0F, 3.0F).uv(23,51).cuboid(-1.0F, 5.0F, -5.0F, 3.0F, 2.0F, 3.0F), ModelTransform.pivot(-0.5F,5.5F,0.5F));
modelPartData6.addChild("toe", ModelPartBuilder.create().uv(0,34).cuboid(-1.5F, 0.0F, -1.0F, 3.0F, 2.0F, 2.0F).uv(15,4).cuboid(-1.5F, 0.0F, -1.0F, 3.0F, 2.0F, 2.0F), ModelTransform.pivot(3.5F,5.0F,-2.0F));
modelPartData6.addChild("othertoe", ModelPartBuilder.create(), ModelTransform.pivot(-2.5F,5.0F,-2.0F));
ModelPartData modelPartData7 = modelPartData.addChild("rightleg", ModelPartBuilder.create().uv(48,54).cuboid(-2.0F, -2.351F, -2.4183F, 4.0F, 10.0F, 5.0F, true), ModelTransform.pivot(7.0F,5.0F,8.0F));
ModelPartData modelPartData8 = modelPartData7.addChild("rightlegbend", ModelPartBuilder.create().uv(68,33).cuboid(-2.0F, -4.5F, -2.0F, 4.0F, 10.0F, 3.0F), ModelTransform.pivot(0.0F,7.149F,1.5817F));
ModelPartData modelPartData9 = modelPartData8.addChild("rightfoot", ModelPartBuilder.create().uv(0,72).cuboid(-1.5F, -1.0F, -2.5F, 4.0F, 7.0F, 3.0F).uv(23,51).cuboid(-1.0F, 5.0F, -5.0F, 3.0F, 2.0F, 3.0F), ModelTransform.pivot(-0.5F,5.5F,0.5F));
modelPartData9.addChild("toetwo", ModelPartBuilder.create().uv(15,4).cuboid(-1.5F, 0.0F, -1.0F, 3.0F, 2.0F, 2.0F), ModelTransform.pivot(3.5F,5.0F,-2.0F));
modelPartData9.addChild("toethree", ModelPartBuilder.create().uv(15,4).cuboid(-1.5F, 0.0F, -1.0F, 3.0F, 2.0F, 2.0F), ModelTransform.pivot(-2.5F,5.0F,-2.0F));
ModelPartData modelPartData10 = modelPartData.addChild("leftarm", ModelPartBuilder.create().uv(35,69).cuboid(-1.5F, -3.2679F, -2.2321F, 3.0F, 9.0F, 3.0F), ModelTransform.pivot(-5.5F,2.0F,-7.5F));
modelPartData10.addChild("leftarmbend", ModelPartBuilder.create().uv(0,13).cuboid(-1.5F, 3.0F, -6.5F, 3.0F, 3.0F, 8.0F), ModelTransform.pivot(0.0F,2.7321F,-0.7321F));
modelPartData10.addChild("leftfinger", ModelPartBuilder.create().uv(43,54).cuboid(-1.0F, -0.5F, -2.5F, 2.0F, 1.0F, 3.0F), ModelTransform.pivot(0.0F,8.5F,-6.5F));
modelPartData10.addChild("rightfinger", ModelPartBuilder.create().uv(44,34).cuboid(-1.0F, -0.5F, -2.5F, 2.0F, 1.0F, 4.0F), ModelTransform.pivot(0.0F,5.5F,-6.5F));
modelPartData10.addChild("middlefinger", ModelPartBuilder.create().uv(0,0).cuboid(-0.5F, 6.0F, -10.0F, 1.0F, 2.0F, 3.0F), ModelTransform.pivot(0.0F,0.0F,0.0F));
ModelPartData modelPartData11 = modelPartData.addChild("leftarm1", ModelPartBuilder.create().uv(35,69).cuboid(-1.5F, -3.2679F, -2.2321F, 3.0F, 9.0F, 3.0F, true), ModelTransform.pivot(5.5F,2.0F,-7.5F));
modelPartData11.addChild("leftarmbend1", ModelPartBuilder.create().uv(0,13).cuboid(-1.5F, 3.0F, -6.5F, 3.0F, 3.0F, 8.0F, true), ModelTransform.pivot(0.0F,2.7321F,-0.7321F));
modelPartData11.addChild("leftfingerleft", ModelPartBuilder.create().uv(45,35).cuboid(-1.0F, -0.5F, -2.5F, 2.0F, 1.0F, 3.0F), ModelTransform.pivot(0.0F,8.5F,-6.5F));
modelPartData11.addChild("leftfingerrighjt", ModelPartBuilder.create().uv(44,34).cuboid(-1.0F, -0.5F, -2.5F, 2.0F, 1.0F, 4.0F), ModelTransform.pivot(0.0F,5.5F,-6.5F));
modelPartData11.addChild("middlefingerleft", ModelPartBuilder.create().uv(0,0).cuboid(-0.5F, 6.0F, -10.0F, 1.0F, 2.0F, 3.0F, true), ModelTransform.pivot(0.0F,0.0F,0.0F));
ModelPartData modelPartData12 = modelPartData.addChild("head", ModelPartBuilder.create().uv(0,34).cuboid(-5.0F, -3.5F, -7.3333F, 10.0F, 7.0F, 10.0F), ModelTransform.pivot(0.0F,-7.5F,-11.6667F));
modelPartData12.addChild("jaw", ModelPartBuilder.create().uv(50,15).cuboid(-4.0F, -2.0F, -6.0F, 8.0F, 4.0F, 6.0F).uv(0,64).cuboid(-3.0F, 2.0F, -6.0F, 6.0F, 2.0F, 6.0F), ModelTransform.pivot(0.0F,-0.5F,-7.3333F));
modelPartData12.addChild("bottomjaw", ModelPartBuilder.create(), ModelTransform.pivot(0.0F,-0.5F,-7.3333F));
return TexturedModelData.of(modelData,128,128);

}
@Override
public void render(MatrixStack matrixStack, VertexConsumer	buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		
		torso.render(matrixStack, buffer, packedLight, packedOverlay);
		leftleg.render(matrixStack, buffer, packedLight, packedOverlay);
		rightleg.render(matrixStack, buffer, packedLight, packedOverlay);
		leftarm.render(matrixStack, buffer, packedLight, packedOverlay);
		leftarm1.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
}
public void setRotationAngle(ModelPart bone, float x, float y, float z) {
		bone.pitch = x;
		bone.yaw = y;
		bone.roll = z;
}


	@Override
	public void setAngles(TroodonEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		setRotationAngle(leftleg, -0.1745F, 0.0F, 0.0F);
		setRotationAngle(leftlegbend, 0.5236F, 0.0F, 0.0F);
		setRotationAngle(leftfoot, -0.3491F, 0.0F, 0.0F);
		setRotationAngle(toe, 0.0F, 0.5236F, 0.0F);
		setRotationAngle(othertoe, 0.0F, -0.4363F, 0.0F);
		setRotationAngle(rightleg, -0.1745F, 0.0F, 0.0F);
		setRotationAngle(rightlegbend, 0.5236F, 0.0F, 0.0F);
		setRotationAngle(rightfoot, -0.3491F, 0.0F, 0.0F);
		setRotationAngle(toetwo, 0.0F, 0.5236F, 0.0F);
		setRotationAngle(toethree, 0.0F, -0.4363F, 0.0F);
		setRotationAngle(leftarm, 0.2618F, 0.0F, 0.7854F);
		setRotationAngle(leftfinger, 0.1745F, 0.8727F, -1.3963F);
		setRotationAngle(rightfinger, -0.0873F, -0.8727F, -1.3963F);
		setRotationAngle(leftarm1, 0.2618F, 0.0F, -0.7854F);
		setRotationAngle(leftfingerleft, 0.1745F, -0.8727F, 1.3963F);
		setRotationAngle(leftfingerrighjt, -0.0873F, 0.8727F, 1.3963F);
		setRotationAngle(torso, -0.1745F, 0.0F, 0.0F);
		setRotationAngle(neck, -0.8727F, 0.0F, 0.0F);
		setRotationAngle(tail, 0.4363F, 0.0F, 0.0F);
		setRotationAngle(tailtwo, 0.5236F, 0.0F, 0.0F);
		setRotationAngle(tailthree, 0.5236F, 0.0F, 0.0F);

		this.leftlegbend.pitch = MathHelper.cos(limbAngle * 0.6662F) * 1.4F * limbDistance;
		this.rightlegbend.pitch = MathHelper.cos(limbAngle * 0.6662F + 3.1415927F) * 1.4F * limbDistance;
	}
}