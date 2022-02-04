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

public class SauropodEntityModel extends EntityModel<SauropodEntity> {
	private final ModelPart body;
	private final ModelPart neck_begin;
	private final ModelPart neck_begin_inside;
	private final ModelPart neck_end_inside;
	private final ModelPart neck_end;
	private final ModelPart head;
	private final ModelPart tail_begin;
	private final ModelPart tail;
	private final ModelPart tail_end;
	private final ModelPart right_front_leg;
	private final ModelPart right_front_foot;
	private final ModelPart right_back_leg;
	private final ModelPart right_back_foot;
	private final ModelPart left_front_leg;
	private final ModelPart left_front_foot;
	private final ModelPart left_back_leg;
	private final ModelPart left_back_foot;
	public SauropodEntityModel(ModelPart root) {
		this.body = root.getChild("body");
		this.tail_begin = this.body.getChild("tail_begin");
		this.tail = this.tail_begin.getChild("tail");
		this.tail_end = this.tail.getChild("tail_end");
		this.neck_begin = this.body.getChild("neck_begin");
		this.neck_begin_inside = this.neck_begin.getChild("neck_begin_inside");
		this.neck_end_inside = this.neck_begin_inside.getChild("neck_end_inside");
		this.neck_end = this.neck_end_inside.getChild("neck_end");
		this.head = this.neck_end.getChild("head");
		this.right_front_leg = root.getChild("right_front_leg");
		this.right_front_foot = this.right_front_leg.getChild("right_front_foot");
		this.right_back_leg = root.getChild("right_back_leg");
		this.right_back_foot = this.right_back_leg.getChild("right_back_foot");
		this.left_front_leg = root.getChild("left_front_leg");
		this.left_front_foot = this.left_front_leg.getChild("left_front_foot");
		this.left_back_leg = root.getChild("left_back_leg");
		this.left_back_foot = this.left_back_leg.getChild("left_back_foot");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData modelPartData1 = modelPartData.addChild("body", ModelPartBuilder.create().uv(0,0).cuboid(-8.0F, -9.0F, -8.0F, 16.0F, 16.0F, 25.0F), ModelTransform.pivot(0.0F,6.0F,0.0F));
		ModelPartData modelPartData2 = modelPartData1.addChild("neck_begin", ModelPartBuilder.create().uv(71,30).cuboid(-7.0F, -1.0F, -9.0F, 14.0F, 12.0F, 11.0F), ModelTransform.pivot(0.0F,-8.0F,-8.0F));
		ModelPartData modelPartData3 = modelPartData2.addChild("neck_begin_inside", ModelPartBuilder.create().uv(42,79).cuboid(-6.0F, 0.0F, -7.0F, 12.0F, 10.0F, 9.0F), ModelTransform.pivot(0.0F,-1.0F,-9.0F));
		ModelPartData modelPartData4 = modelPartData3.addChild("neck_end_inside", ModelPartBuilder.create().uv(0,73).cuboid(-4.0F, 0.0F, -11.0F, 8.0F, 8.0F, 13.0F), ModelTransform.pivot(0.0F,0.0F,-7.0F));
		ModelPartData modelPartData5 = modelPartData4.addChild("neck_end", ModelPartBuilder.create().uv(84,79).cuboid(-3.0F, 0.0F, -8.0F, 6.0F, 7.0F, 9.0F), ModelTransform.pivot(0.0F,0.0F,-11.0F));
		modelPartData5.addChild("head", ModelPartBuilder.create().uv(80,53).cuboid(-4.0F, -5.0F, -9.0F, 8.0F, 7.0F, 11.0F).uv(0,0).cuboid(-3.0F, -5.0F, -14.0F, 6.0F, 6.0F, 5.0F).uv(92,0).cuboid(-3.0F, -7.0F, -11.0F, 6.0F, 2.0F, 7.0F), ModelTransform.pivot(0.0F,4.0F,-8.0F));
		ModelPartData modelPartData6 = modelPartData1.addChild("tail_begin", ModelPartBuilder.create().uv(0,41).cuboid(-7.0F, -1.0F, -4.0F, 14.0F, 12.0F, 20.0F), ModelTransform.pivot(0.0F,-7.0F,17.0F));
		ModelPartData modelPartData7 = modelPartData6.addChild("tail", ModelPartBuilder.create().uv(57,0).cuboid(-5.0F, -3.0F, -1.0F, 10.0F, 9.0F, 15.0F), ModelTransform.pivot(0.0F,3.0F,15.0F));
		modelPartData7.addChild("tail_end", ModelPartBuilder.create().uv(49,54).cuboid(-3.0F, -2.0F, -4.0F, 6.0F, 6.0F, 19.0F), ModelTransform.pivot(0.0F,0.0F,14.0F));
		ModelPartData modelPartData8 = modelPartData.addChild("right_front_leg", ModelPartBuilder.create().uv(0,41).cuboid(-10.0F, -2.0F, -2.0F, 4.0F, 8.0F, 5.0F, new Dilation(0.5F)), ModelTransform.pivot(2.0F,10.0F,-6.0F));
		modelPartData8.addChild("right_front_foot", ModelPartBuilder.create().uv(0,11).cuboid(-10.0F, -1.0F, -2.0F, 4.0F, 8.0F, 5.0F), ModelTransform.pivot(0.0F,7.0F,0.0F));
		ModelPartData modelPartData9 = modelPartData.addChild("right_back_leg", ModelPartBuilder.create().uv(29,73).cuboid(-10.0F, -1.0F, -2.0F, 4.0F, 8.0F, 5.0F, new Dilation(0.5F)), ModelTransform.pivot(2.0F,10.0F,10.0F));
		modelPartData9.addChild("right_back_foot", ModelPartBuilder.create().uv(48,41).cuboid(-10.0F, -1.0F, -2.0F, 4.0F, 8.0F, 5.0F), ModelTransform.pivot(0.0F,7.0F,0.0F));
		ModelPartData modelPartData10 = modelPartData.addChild("left_front_leg", ModelPartBuilder.create().uv(79,95).cuboid(6.0F, -2.0F, -2.0F, 4.0F, 8.0F, 5.0F, new Dilation(0.5F)), ModelTransform.pivot(-2.0F,10.0F,-6.0F));
		modelPartData10.addChild("left_front_foot", ModelPartBuilder.create().uv(97,95).cuboid(6.0F, -1.0F, -2.0F, 4.0F, 8.0F, 5.0F), ModelTransform.pivot(0.0F,7.0F,0.0F));
		ModelPartData modelPartData11 = modelPartData.addChild("left_back_leg", ModelPartBuilder.create().uv(18,94).cuboid(6.0F, -1.0F, -2.0F, 4.0F, 8.0F, 5.0F, new Dilation(0.5F)), ModelTransform.pivot(-2.0F,10.0F,10.0F));
		modelPartData11.addChild("left_back_foot", ModelPartBuilder.create().uv(0,94).cuboid(6.0F, -1.0F, -2.0F, 4.0F, 8.0F, 5.0F), ModelTransform.pivot(0.0F,7.0F,0.0F));
		return TexturedModelData.of(modelData,128,128);
	}
	@Override
	public void setAngles(SauropodEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		this.body.pitch = -0.2618F;
		this.neck_begin.pitch = -0.1309F;
		this.neck_begin_inside.pitch = -0.1745F;
		this.neck_end_inside.pitch = -0.1745F;
		this.neck_end.pitch = -0.1309F;
		this.head.pitch = 1.0472F;
		this.tail_begin.pitch = 0.2182F;
		this.tail.pitch = 0.1309F;
		this.tail_end.pitch = 0.1745F;
	}
	@Override
	public void render(MatrixStack matrixStack, VertexConsumer	buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){

		body.render(matrixStack, buffer, packedLight, packedOverlay);
		right_front_leg.render(matrixStack, buffer, packedLight, packedOverlay);
		right_back_leg.render(matrixStack, buffer, packedLight, packedOverlay);
		left_front_leg.render(matrixStack, buffer, packedLight, packedOverlay);
		left_back_leg.render(matrixStack, buffer, packedLight, packedOverlay);
	}
}