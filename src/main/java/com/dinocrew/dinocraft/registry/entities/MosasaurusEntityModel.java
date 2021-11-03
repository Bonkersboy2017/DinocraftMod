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
	private final ModelPart torso;
	private final ModelPart tail;
	private final ModelPart tailparttwo;
	private final ModelPart tailpartthree;
	private final ModelPart neck;
	private final ModelPart cube4_r1;
	private final ModelPart necktwo;
	private final ModelPart frontleftleg;
	private final ModelPart cube5_r1;
	private final ModelPart frontleftbedn;
	private final ModelPart frontleftfoog;
	private final ModelPart frontrightleg;
	private final ModelPart cube6_r1;
	private final ModelPart frontrightbedn;
	private final ModelPart frontrightfoog;
	private final ModelPart Head;
	private final ModelPart cube7_r1;
	private final ModelPart topmouth;
	private final ModelPart bottommouth;
	private final ModelPart backrightleg;
	private final ModelPart ten;
	private final ModelPart backrightlegbend;
	private final ModelPart backrightlegfoot;
	private final ModelPart backleftleg;
	private final ModelPart eleven;
	private final ModelPart backleftlegbend;
	private final ModelPart backleftlegfoot;
	private final ModelPart bb_main;
	private final ModelPart thirteen;
	private final ModelPart twelve;

	public MosasaurusEntityModel(ModelPart root) {
		this.torso = root.getChild("torso");
		this.neck = this.torso.getChild("neck");
		this.necktwo = this.neck.getChild("necktwo");
		this.cube4_r1 = this.neck.getChild("cube4_r1");
		this.tail = this.torso.getChild("tail");
		this.tailpartthree = this.tail.getChild("tailpartthree");
		this.tailparttwo = this.tail.getChild("tailparttwo");
		this.frontleftleg = root.getChild("frontleftleg");
		this.frontleftbedn = this.frontleftleg.getChild("frontleftbedn");
		this.frontleftfoog = this.frontleftbedn.getChild("frontleftfoog");
		this.cube5_r1 = this.frontleftleg.getChild("cube5_r1");
		this.frontrightleg = root.getChild("frontrightleg");
		this.frontrightbedn = this.frontrightleg.getChild("frontrightbedn");
		this.frontrightfoog = this.frontrightbedn.getChild("frontrightfoog");
		this.cube6_r1 = this.frontrightleg.getChild("cube6_r1");
		this.Head = root.getChild("Head");
		this.bottommouth = this.Head.getChild("bottommouth");
		this.topmouth = this.Head.getChild("topmouth");
		this.cube7_r1 = this.Head.getChild("cube7_r1");
		this.backrightleg = root.getChild("backrightleg");
		this.backrightlegbend = this.backrightleg.getChild("backrightlegbend");
		this.backrightlegfoot = this.backrightlegbend.getChild("backrightlegfoot");
		this.ten = this.backrightleg.getChild("10_r1");
		this.backleftleg = root.getChild("backleftleg");
		this.backleftlegbend = this.backleftleg.getChild("backleftlegbend");
		this.backleftlegfoot = this.backleftlegbend.getChild("backleftlegfoot");
		this. eleven = this.backleftleg.getChild("11_r1");
		this.bb_main = root.getChild("bb_main");
		this.twelve = this.bb_main.getChild("12_r1");
		this.thirteen= this.bb_main.getChild("13_r1");
	}

	@Override
	public void setAngles(MosasaurusEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		setRotationAngle(torso, -0.1745F, 0.0F, 0.0F);
		setRotationAngle(tail, -0.2618F, 0.0F, 0.0F);
		setRotationAngle(tailparttwo, 0.2618F, 0.0F, 0.0F);
		setRotationAngle(tailpartthree, 0.5236F, 0.0F, 0.0F);
		setRotationAngle(neck, -0.2618F, 0.0F, 0.0F);
		setRotationAngle(cube4_r1, 0.0873F, 0.0F, 0.0F);
		setRotationAngle(necktwo, -0.6981F, 0.0F, 0.0F);

		setRotationAngle(frontleftleg, 0.2618F, 0.0F, 0.0F);

		setRotationAngle(cube5_r1, 0.0F, 0.0F, -0.2618F);
		setRotationAngle(frontleftbedn, -0.4363F, 0.0F, 0.0F);

		setRotationAngle(frontleftfoog, 0.2618F, 0.0F, 0.0F);

		setRotationAngle(frontrightleg, 0.2618F, 0.0F, 0.0F);

		setRotationAngle(cube6_r1, -0.0873F, 0.0873F, 0.2618F);
		setRotationAngle(frontrightbedn, -0.4363F, 0.0F, 0.0F);

		setRotationAngle(frontrightfoog, 0.2618F, 0.0F, 0.0F);

		setRotationAngle(Head, 0.1745F, 0.0F, 0.0F);

		setRotationAngle(cube7_r1, -0.6109F, 0.0F, 0.0F);
		setRotationAngle(backrightleg, 0.3491F, 0.0F, 0.0F);

		setRotationAngle(ten, 0.0F, 0.0F, 0.2618F);
		setRotationAngle(backrightlegbend, -0.3491F, 0.0F, 0.0F);

		setRotationAngle(backrightlegfoot, 0.0873F, 0.0F, 0.0F);

		setRotationAngle(backleftleg, 0.3491F, 0.0F, 0.0F);

		setRotationAngle(eleven, 0.0F, 0.0F, -0.2618F);
		setRotationAngle(backleftlegbend, -0.3491F, 0.0F, 0.0F);

		setRotationAngle(backleftlegfoot, 0.0873F, 0.0F, 0.0F);

		setRotationAngle(thirteen, 0.0F, 0.1309F, 2.9234F);
		setRotationAngle(twelve, 0.0F, -0.1309F, -2.9234F);
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();

		ModelPartData modelPartData1 = modelPartData.addChild("torso", ModelPartBuilder.create().uv(61, 52).cuboid(-10.0F, -10.0F, 0.0F, 20.0F, 15.0F, 19.0F).uv(0, 0).cuboid(-11.0F, -10.0F, -18.0F, 22.0F, 16.0F, 19.0F), ModelTransform.pivot(0.0F, 2.0F, 0.0F));
		ModelPartData modelPartData2 = modelPartData1.addChild("tail", ModelPartBuilder.create().uv(0, 71).cuboid(-9.0F, -5.0F, -6.5F, 18.0F, 13.0F, 11.0F), ModelTransform.pivot(0.0F, -3.0F, 23.5F));
		modelPartData2.addChild("tailparttwo", ModelPartBuilder.create().uv(93, 86).cuboid(-7.0F, -6.5F, -6.5F, 14.0F, 10.0F, 12.0F), ModelTransform.pivot(0.0F, 1.5F, 10.0F));
		modelPartData2.addChild("tailpartthree", ModelPartBuilder.create().uv(108, 0).cuboid(-5.0F, -7.5F, -6.5F, 10.0F, 8.0F, 12.0F), ModelTransform.pivot(0.0F, -0.5F, 21.0F));
		ModelPartData modelPartData3 = modelPartData1.addChild("neck", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -3.0F, -15.0F));
		modelPartData3.addChild("cube4_r1", ModelPartBuilder.create().uv(0, 35).cuboid(-9.0F, -12.0F, -35.0F, 18.0F, 14.0F, 22.0F), ModelTransform.pivot(0.0F, 4.8117F, 15.2385F));
		modelPartData3.addChild("necktwo", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -2.0F, -7.0F));
		ModelPartData modelPartData4 = modelPartData.addChild("frontleftleg", ModelPartBuilder.create(), ModelTransform.pivot(-12.0F, 0.0F, -10.0F));
		modelPartData4.addChild("cube5_r1", ModelPartBuilder.create().uv(83, 108).cuboid(-9.0F, -23.0F, -15.0F, 7.0F, 10.0F, 10.0F), ModelTransform.pivot(12.0F, 24.0F, 10.0F));
		ModelPartData modelPartData5 = modelPartData4.addChild("frontleftbedn", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 7.0F, 2.5F));
		modelPartData5.addChild("frontleftfoog", ModelPartBuilder.create(), ModelTransform.pivot(-0.5F, 18.5F, -2.0F));
		ModelPartData modelPartData6 = modelPartData.addChild("frontrightleg", ModelPartBuilder.create(), ModelTransform.pivot(12.0F, 0.0F, -10.0F));
		modelPartData6.addChild("cube6_r1", ModelPartBuilder.create().uv(36, 110).cuboid(3.0F, -22.0F, -14.0F, 7.0F, 9.0F, 10.0F), ModelTransform.pivot(-12.0F, 24.0F, 10.0F));
		ModelPartData modelPartData7 = modelPartData6.addChild("frontrightbedn", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 7.0F, 2.5F));
		modelPartData7.addChild("frontrightfoog", ModelPartBuilder.create(), ModelTransform.pivot(0.5F, 18.5F, -2.0F));
		ModelPartData modelPartData8 = modelPartData.addChild("Head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -41.0F, -33.0F));
		modelPartData8.addChild("cube7_r1", ModelPartBuilder.create().uv(58, 9).cuboid(-6.0F, -12.0F, -71.0F, 12.0F, 9.0F, 26.0F), ModelTransform.pivot(0.0F, 65.0F, 33.0F));
		modelPartData8.addChild("topmouth", ModelPartBuilder.create().uv(39, 86).cuboid(-4.0F, 33.5F, -17.5F, 8.0F, 5.0F, 19.0F), ModelTransform.pivot(0.0F, -1.5F, -9.5F));
		modelPartData8.addChild("bottommouth", ModelPartBuilder.create().uv(0, 95).cuboid(-3.0F, 29.5F, -15.5F, 6.0F, 2.0F, 17.0F), ModelTransform.pivot(0.0F, 1.5F, -9.5F));
		ModelPartData modelPartData9 = modelPartData.addChild("backrightleg", ModelPartBuilder.create(), ModelTransform.pivot(12.0F, 1.0F, 11.5F));
		modelPartData9.addChild("10_r1", ModelPartBuilder.create().uv(117, 108).cuboid(2.0F, -21.0F, 7.0F, 7.0F, 9.0F, 9.0F), ModelTransform.pivot(-12.0F, 23.0F, -11.5F));
		ModelPartData modelPartData10 = modelPartData9.addChild("backrightlegbend", ModelPartBuilder.create(), ModelTransform.pivot(1.5F, 4.5F, -2.0F));
		modelPartData10.addChild("backrightlegfoot", ModelPartBuilder.create(), ModelTransform.pivot(-2.0F, 24.0F, 2.5F));
		ModelPartData modelPartData11 = modelPartData.addChild("backleftleg", ModelPartBuilder.create(), ModelTransform.pivot(-12.0F, 1.0F, 11.5F));
		modelPartData11.addChild("11_r1", ModelPartBuilder.create().uv(0, 114).cuboid(-9.0F, -23.0F, 7.0F, 7.0F, 10.0F, 9.0F), ModelTransform.pivot(12.0F, 23.0F, -11.5F));
		ModelPartData modelPartData12 = modelPartData11.addChild("backleftlegbend", ModelPartBuilder.create(), ModelTransform.pivot(-1.5F, 4.5F, -2.0F));
		modelPartData12.addChild("backleftlegfoot", ModelPartBuilder.create(), ModelTransform.pivot(2.0F, 24.0F, 2.5F));
		ModelPartData modelPartData13 = modelPartData.addChild("bb_main", ModelPartBuilder.create().uv(0, 0).cuboid(1.0F, -33.0F, -43.0F, 3.0F, 3.0F, 3.0F).uv(0, 0).cuboid(-4.0F, -33.0F, -43.0F, 3.0F, 3.0F, 3.0F).uv(0, 0).cuboid(-4.0F, -33.0F, -43.0F, 3.0F, 3.0F, 3.0F).uv(0, 0).cuboid(1.0F, -32.0F, -48.0F, 3.0F, 3.0F, 3.0F).uv(0, 0).cuboid(-4.0F, -32.0F, -48.0F, 3.0F, 3.0F, 3.0F).uv(0, 0).cuboid(4.0F, -28.0F, 21.0F, 3.0F, 3.0F, 3.0F).uv(0, 0).cuboid(4.0F, -26.0F, 25.0F, 3.0F, 3.0F, 3.0F).uv(0, 0).cuboid(-7.0F, -26.0F, 25.0F, 3.0F, 3.0F, 3.0F).uv(0, 0).cuboid(-7.0F, -31.0F, 16.0F, 3.0F, 3.0F, 3.0F).uv(0, 0).cuboid(-7.0F, -32.0F, 10.0F, 3.0F, 3.0F, 3.0F).uv(0, 0).cuboid(5.0F, -31.0F, 16.0F, 3.0F, 3.0F, 3.0F).uv(0, 0).cuboid(5.0F, -32.0F, 10.0F, 3.0F, 3.0F, 3.0F).uv(0, 0).cuboid(5.0F, -33.0F, 5.0F, 3.0F, 3.0F, 3.0F).uv(0, 0).cuboid(-7.0F, -33.0F, 5.0F, 3.0F, 3.0F, 3.0F).uv(0, 0).cuboid(5.0F, -34.0F, -2.0F, 3.0F, 3.0F, 3.0F).uv(0, 0).cuboid(-7.0F, -34.0F, -2.0F, 3.0F, 3.0F, 3.0F).uv(0, 0).cuboid(-7.0F, -35.0F, -8.0F, 3.0F, 3.0F, 3.0F).uv(0, 0).cuboid(-7.0F, -36.0F, -14.0F, 3.0F, 3.0F, 3.0F).uv(0, 0).cuboid(5.0F, -35.0F, -7.0F, 3.0F, 3.0F, 3.0F).uv(0, 0).cuboid(5.0F, -36.0F, -12.0F, 3.0F, 3.0F, 3.0F).uv(0, 0).cuboid(5.0F, -37.0F, -21.0F, 3.0F, 3.0F, 3.0F).uv(0, 0).cuboid(5.0F, -38.0F, -25.0F, 3.0F, 3.0F, 3.0F).uv(0, 0).cuboid(-7.0F, -38.0F, -25.0F, 3.0F, 3.0F, 3.0F).uv(0, 0).cuboid(-8.0F, -37.0F, -21.0F, 3.0F, 3.0F, 3.0F).uv(0, 0).cuboid(-7.0F, -40.0F, -29.0F, 3.0F, 3.0F, 3.0F).uv(0, 0).cuboid(5.0F, -40.0F, -29.0F, 3.0F, 3.0F, 3.0F).uv(0, 0).cuboid(11.0F, -12.0F, 16.0F, 3.0F, 3.0F, 3.0F).uv(0, 0).cuboid(11.0F, -12.0F, 12.0F, 3.0F, 3.0F, 3.0F).uv(0, 0).cuboid(11.0F, -14.0F, -5.0F, 3.0F, 3.0F, 3.0F).uv(0, 0).cuboid(11.0F, -14.0F, -10.0F, 3.0F, 3.0F, 3.0F).uv(0, 0).cuboid(-14.0F, -13.0F, 16.0F, 3.0F, 3.0F, 3.0F).uv(0, 0).cuboid(-14.0F, -13.0F, 12.0F, 3.0F, 3.0F, 3.0F).uv(0, 0).cuboid(-14.0F, -13.0F, -6.0F, 3.0F, 3.0F, 3.0F).uv(0, 0).cuboid(-14.0F, -13.0F, -11.0F, 3.0F, 3.0F, 3.0F).uv(0, 0).cuboid(4.0F, -23.0F, 31.0F, 3.0F, 3.0F, 3.0F).uv(0, 0).cuboid(4.0F, -23.0F, 35.0F, 3.0F, 3.0F, 3.0F).uv(0, 0).cuboid(-7.0F, -23.0F, 31.0F, 3.0F, 3.0F, 3.0F).uv(0, 0).cuboid(-7.0F, -23.0F, 35.0F, 3.0F, 3.0F, 3.0F).uv(0, 0).cuboid(-5.0F, -22.0F, 40.0F, 3.0F, 3.0F, 3.0F).uv(0, 0).cuboid(2.0F, -22.0F, 41.0F, 3.0F, 3.0F, 3.0F).uv(0, 0).cuboid(-7.0F, -28.0F, 21.0F, 3.0F, 3.0F, 3.0F), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		modelPartData13.addChild("13_r1", ModelPartBuilder.create().uv(108, 20).cuboid(-10.0F, 14.0F, 45.0F, 5.0F, 2.0F, 12.0F), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		modelPartData13.addChild("12_r1", ModelPartBuilder.create().uv(108, 20).cuboid(5.0F, 14.0F, 45.0F, 5.0F, 2.0F, 12.0F), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 256, 256);
	}

	@Override
	public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {

		torso.render(matrixStack, buffer, packedLight, packedOverlay);
		frontleftleg.render(matrixStack, buffer, packedLight, packedOverlay);
		frontrightleg.render(matrixStack, buffer, packedLight, packedOverlay);
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
		backrightleg.render(matrixStack, buffer, packedLight, packedOverlay);
		backleftleg.render(matrixStack, buffer, packedLight, packedOverlay);
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelPart bone, float x, float y, float z) {
		bone.pitch = x;
		bone.yaw = y;
		bone.roll = z;
	}
}
