// Made with Model Converter by Globox_Z
// Generate all required imports
// Made with Blockbench 3.9.2
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	package com.dinocrew.dinocraft.registry.entities;

import com.dinocrew.dinocraft.registry.entities.SauropodEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class sauropod  extends EntityModel<SauropodEntity> {
private final ModelPart torso;
	private final ModelPart tail;
	private final ModelPart tailparttwo;
	private final ModelPart tailpartthree;
	private final ModelPart neck;
	private final ModelPart necktwo;
	private final ModelPart neckthree;
	private final ModelPart neckfour;
	private final ModelPart frontleftleg;
	private final ModelPart frontleftbedn;
	private final ModelPart frontleftfoog;
	private final ModelPart frontrightleg;
	private final ModelPart frontrightbedn;
	private final ModelPart frontrightfoog;
	private final ModelPart Head;
	private final ModelPart topmouth;
	private final ModelPart bottommouth;
	private final ModelPart backrightleg;
	private final ModelPart backrightlegbend;
	private final ModelPart backrightlegfoot;
	private final ModelPart backleftleg;
	private final ModelPart backleftlegbend;
	private final ModelPart backleftlegfoot;
	public sauropod(ModelPart root){
this.torso = root.getChild("torso");
this.neck = this.torso.getChild("neck");
this.necktwo = this.neck.getChild("necktwo");
this.neckthree = this.necktwo.getChild("neckthree");
this.neckfour = this.neckthree.getChild("neckfour");
this.tail = this.torso.getChild("tail");
this.tailpartthree = this.tail.getChild("tailpartthree");
this.tailparttwo = this.tail.getChild("tailparttwo");
this.frontleftleg = root.getChild("frontleftleg");
this.frontleftbedn = this.frontleftleg.getChild("frontleftbedn");
this.frontleftfoog = this.frontleftbedn.getChild("frontleftfoog");
this.frontrightleg = root.getChild("frontrightleg");
this.frontrightbedn = this.frontrightleg.getChild("frontrightbedn");
this.frontrightfoog = this.frontrightbedn.getChild("frontrightfoog");
this.Head = root.getChild("Head");
this.bottommouth = this.Head.getChild("bottommouth");
this.topmouth = this.Head.getChild("topmouth");
this.backrightleg = root.getChild("backrightleg");
this.backrightlegbend = this.backrightleg.getChild("backrightlegbend");
this.backrightlegfoot = this.backrightlegbend.getChild("backrightlegfoot");
this.backleftleg = root.getChild("backleftleg");
this.backleftlegbend = this.backleftleg.getChild("backleftlegbend");
this.backleftlegfoot = this.backleftlegbend.getChild("backleftlegfoot");
}
public static TexturedModelData getTexturedModelData() {
ModelData modelData = new ModelData();
ModelPartData modelPartData = modelData.getRoot();

ModelPartData modelPartData1 = modelPartData.addChild("torso", ModelPartBuilder.create().uv(0,35).cuboid(-10.0F, -10.0F, 0.0F, 20.0F, 15.0F, 19.0F).uv(0,0).cuboid(-11.0F, -10.0F, -18.0F, 22.0F, 16.0F, 19.0F), ModelTransform.pivot(0.0F,2.0F,0.0F));
ModelPartData modelPartData2 = modelPartData1.addChild("tail", ModelPartBuilder.create().uv(0,69).cuboid(-9.0F, -5.0F, -6.5F, 18.0F, 13.0F, 11.0F), ModelTransform.pivot(0.0F,-3.0F,23.5F));
modelPartData2.addChild("tailparttwo", ModelPartBuilder.create().uv(0,106).cuboid(-7.0F, -6.5F, -6.5F, 14.0F, 10.0F, 12.0F), ModelTransform.pivot(0.0F,1.5F,10.0F));
modelPartData2.addChild("tailpartthree", ModelPartBuilder.create().uv(113,35).cuboid(-5.0F, -7.5F, -6.5F, 10.0F, 8.0F, 12.0F), ModelTransform.pivot(0.0F,-0.5F,21.0F));
ModelPartData modelPartData3 = modelPartData1.addChild("neck", ModelPartBuilder.create().uv(66,66).cuboid(-9.0F, -6.1883F, -9.7615F, 18.0F, 14.0F, 12.0F), ModelTransform.pivot(0.0F,-3.0F,-15.0F));
ModelPartData modelPartData4 = modelPartData3.addChild("necktwo", ModelPartBuilder.create().uv(67,20).cuboid(-7.0F, -3.2149F, -10.8944F, 14.0F, 12.0F, 15.0F), ModelTransform.pivot(0.0F,-2.0F,-7.0F));
ModelPartData modelPartData5 = modelPartData4.addChild("neckthree", ModelPartBuilder.create().uv(42,92).cuboid(-6.0F, -3.5696F, -16.8649F, 12.0F, 10.0F, 16.0F), ModelTransform.pivot(0.0F,2.5F,-7.0F));
modelPartData5.addChild("neckfour", ModelPartBuilder.create().uv(114,55).cuboid(-5.0F, -4.0F, -10.0F, 10.0F, 9.0F, 10.0F), ModelTransform.pivot(0.0F,1.0F,-16.0F));
ModelPartData modelPartData6 = modelPartData.addChild("frontleftleg", ModelPartBuilder.create().uv(110,0).cuboid(-5.0F, -7.0F, -5.0F, 10.0F, 14.0F, 10.0F), ModelTransform.pivot(-12.0F,0.0F,-10.0F));
ModelPartData modelPartData7 = modelPartData6.addChild("frontleftbedn", ModelPartBuilder.create().uv(138,74).cuboid(-4.0F, -3.0F, -6.5F, 8.0F, 17.0F, 8.0F), ModelTransform.pivot(0.0F,7.0F,2.5F));
modelPartData7.addChild("frontleftfoog", ModelPartBuilder.create().uv(63,0).cuboid(-4.5F, -6.5F, -5.5F, 11.0F, 7.0F, 11.0F), ModelTransform.pivot(-0.5F,18.5F,-2.0F));
ModelPartData modelPartData8 = modelPartData.addChild("frontrightleg", ModelPartBuilder.create().uv(110,0).cuboid(-5.0F, -7.0F, -5.0F, 10.0F, 14.0F, 10.0F), ModelTransform.pivot(12.0F,0.0F,-10.0F));
ModelPartData modelPartData9 = modelPartData8.addChild("frontrightbedn", ModelPartBuilder.create().uv(138,74).cuboid(-4.0F, -3.0F, -6.5F, 8.0F, 17.0F, 8.0F), ModelTransform.pivot(0.0F,7.0F,2.5F));
modelPartData9.addChild("frontrightfoog", ModelPartBuilder.create().uv(63,0).cuboid(-6.5F, -6.5F, -5.5F, 11.0F, 7.0F, 11.0F), ModelTransform.pivot(0.5F,18.5F,-2.0F));
ModelPartData modelPartData10 = modelPartData.addChild("Head", ModelPartBuilder.create().uv(98,98).cuboid(-6.0F, -5.0F, -9.0F, 12.0F, 9.0F, 16.0F), ModelTransform.pivot(0.0F,-41.0F,-33.0F));
modelPartData10.addChild("topmouth", ModelPartBuilder.create().uv(0,93).cuboid(-4.0F, -2.5F, -6.5F, 8.0F, 5.0F, 8.0F), ModelTransform.pivot(0.0F,-1.5F,-9.5F));
modelPartData10.addChild("bottommouth", ModelPartBuilder.create().uv(47,69).cuboid(-3.0F, -0.5F, -5.5F, 6.0F, 2.0F, 7.0F), ModelTransform.pivot(0.0F,1.5F,-9.5F));
ModelPartData modelPartData11 = modelPartData.addChild("backrightleg", ModelPartBuilder.create().uv(120,123).cuboid(-5.0F, -5.0F, -4.5F, 10.0F, 10.0F, 9.0F), ModelTransform.pivot(12.0F,1.0F,11.5F));
ModelPartData modelPartData12 = modelPartData11.addChild("backrightlegbend", ModelPartBuilder.create().uv(54,142).cuboid(-2.5F, -4.7412F, -1.6319F, 5.0F, 20.0F, 6.0F), ModelTransform.pivot(1.5F,4.5F,-2.0F));
modelPartData12.addChild("backrightlegfoot", ModelPartBuilder.create().uv(138,99).cuboid(-1.5F, -9.5F, -5.5F, 7.0F, 5.0F, 9.0F), ModelTransform.pivot(-2.0F,24.0F,2.5F));
ModelPartData modelPartData13 = modelPartData.addChild("backleftleg", ModelPartBuilder.create().uv(120,123).cuboid(-5.0F, -5.0F, -4.5F, 10.0F, 10.0F, 9.0F), ModelTransform.pivot(-12.0F,1.0F,11.5F));
ModelPartData modelPartData14 = modelPartData13.addChild("backleftlegbend", ModelPartBuilder.create().uv(54,142).cuboid(-2.5F, -4.7412F, -1.6319F, 5.0F, 20.0F, 6.0F), ModelTransform.pivot(-1.5F,4.5F,-2.0F));
modelPartData14.addChild("backleftlegfoot", ModelPartBuilder.create().uv(138,99).cuboid(-5.5F, -9.5F, -5.5F, 7.0F, 5.0F, 9.0F), ModelTransform.pivot(2.0F,24.0F,2.5F));
return TexturedModelData.of(modelData,256,256);

}


@Override
public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		
		torso.render(matrixStack, buffer, packedLight, packedOverlay);
		frontleftleg.render(matrixStack, buffer, packedLight, packedOverlay);
		frontrightleg.render(matrixStack, buffer, packedLight, packedOverlay);
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
		backrightleg.render(matrixStack, buffer, packedLight, packedOverlay);
		backleftleg.render(matrixStack, buffer, packedLight, packedOverlay);
}
public void setRotationAngle(ModelPart bone, float x, float y, float z) {
		bone.pitch = x;
		bone.yaw = y;
		bone.roll = z;
}

	@Override
	public void setAngles(SauropodEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		setRotationAngle(neck, -0.2618F, 0.0F, 0.0F);
		setRotationAngle(necktwo, -0.6981F, 0.0F, 0.0F);
		setRotationAngle(neckthree, -0.1745F, 0.0F, 0.0F);
		setRotationAngle(neckfour, -0.1745F, 0.0F, 0.0F);
		setRotationAngle(frontleftleg, 0.2618F, 0.0F, 0.0F);
		setRotationAngle(frontleftbedn, -0.4363F, 0.0F, 0.0F);
		setRotationAngle(frontleftfoog, 0.2618F, 0.0F, 0.0F);
		setRotationAngle(frontrightleg, 0.2618F, 0.0F, 0.0F);
		setRotationAngle(frontrightbedn, -0.4363F, 0.0F, 0.0F);
		setRotationAngle(frontrightfoog, 0.2618F, 0.0F, 0.0F);
		setRotationAngle(Head, 0.1745F, 0.0F, 0.0F);
		setRotationAngle(backrightleg, 0.3491F, 0.0F, 0.0F);
		setRotationAngle(backrightlegbend, -0.3491F, 0.0F, 0.0F);
		setRotationAngle(backrightlegfoot, 0.0873F, 0.0F, 0.0F);
		setRotationAngle(backleftleg, 0.3491F, 0.0F, 0.0F);
		setRotationAngle(backleftlegbend, -0.3491F, 0.0F, 0.0F);
		setRotationAngle(backleftlegfoot, 0.0873F, 0.0F, 0.0F);
		setRotationAngle(torso, -0.1745F, 0.0F, 0.0F);
		setRotationAngle(tail, -0.2618F, 0.0F, 0.0F);
		setRotationAngle(tailparttwo, 0.2618F, 0.0F, 0.0F);
		setRotationAngle(tailpartthree, 0.5236F, 0.0F, 0.0F);
		// ANIMATIONS BELOW
		this.frontleftbedn.pitch = MathHelper.cos(limbAngle * 0.6662F) * 1.4F * limbDistance;
		this.frontrightbedn.pitch = MathHelper.cos(limbAngle * 0.6662F + 3.1415927F) * 1.4F * limbDistance;
		this.backleftlegbend.pitch = MathHelper.cos(limbAngle * 0.6662F) * 1.4F * limbDistance;
		this.backrightlegbend.pitch = MathHelper.cos(limbAngle * 0.6662F + 3.1415927F) * 1.4F * limbDistance;
	}}