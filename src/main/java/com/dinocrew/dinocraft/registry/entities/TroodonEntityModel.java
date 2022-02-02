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

public class TroodonEntityModel extends EntityModel<TroodonEntity> {
private final ModelPart tail;
	private final ModelPart bone7;
	private final ModelPart bone8;
	private final ModelPart bone9;
	private final ModelPart body;
	private final ModelPart leg1;
	private final ModelPart bone;
	private final ModelPart bone2;
	private final ModelPart bone3;
	private final ModelPart foot1;
	private final ModelPart cube_r1;
	private final ModelPart leg2;
	private final ModelPart bone4;
	private final ModelPart bone5;
	private final ModelPart bone6;
	private final ModelPart foot2;
	private final ModelPart cube_r2;
	private final ModelPart neck;
	private final ModelPart cube_r3;
	private final ModelPart head;
	private final ModelPart top;
	private final ModelPart cube_r4;
	private final ModelPart bottom;
	private final ModelPart arm1;
	private final ModelPart cube_r5;
	private final ModelPart arm2;
	private final ModelPart cube_r6;
public TroodonEntityModel(ModelPart root) {
this.tail = root.getChild("tail");
this.bone9 = this.tail.getChild("bone9");
this.bone8 = this.tail.getChild("bone8");
this.bone7 = this.tail.getChild("bone7");
this.body = root.getChild("body");
this.leg1 = root.getChild("leg1");
this.foot1 = this.leg1.getChild("foot1");
this.cube_r1 = this.foot1.getChild("cube_r1");
this.bone3 = this.leg1.getChild("bone3");
this.bone2 = this.leg1.getChild("bone2");
this.bone = this.leg1.getChild("bone");
this.leg2 = root.getChild("leg2");
this.foot2 = this.leg2.getChild("foot2");
this.cube_r2 = this.foot2.getChild("cube_r2");
this.bone6 = this.leg2.getChild("bone6");
this.bone5 = this.leg2.getChild("bone5");
this.bone4 = this.leg2.getChild("bone4");
this.neck = root.getChild("neck");
this.head = this.neck.getChild("head");
this.bottom = this.head.getChild("bottom");
this.top = this.head.getChild("top");
this.cube_r4 = this.top.getChild("cube_r4");
this.cube_r3 = this.neck.getChild("cube_r3");
this.arm1 = root.getChild("arm1");
this.cube_r5 = this.arm1.getChild("cube_r5");
this.arm2 = root.getChild("arm2");
this.cube_r6 = this.arm2.getChild("cube_r6");
}
public static TexturedModelData getTexturedModelData() {
ModelData modelData = new ModelData();
ModelPartData modelPartData = modelData.getRoot();
		
		
ModelPartData modelPartData1 = modelPartData.addChild("tail", ModelPartBuilder.create(), ModelTransform.pivot(0.0F,24.0F,0.0F));
modelPartData1.addChild("bone7", ModelPartBuilder.create().uv(42,0).cuboid(-2.0F, -19.0F, 8.0F, 4.0F, 4.0F, 7.0F), ModelTransform.pivot(0.0F,0.0F,0.0F));
modelPartData1.addChild("bone8", ModelPartBuilder.create().uv(46,26).cuboid(-1.5F, -18.5F, 15.0F, 3.0F, 3.0F, 6.0F), ModelTransform.pivot(0.0F,0.0F,0.0F));
modelPartData1.addChild("bone9", ModelPartBuilder.create().uv(50,19).cuboid(-1.0F, -18.0F, 21.0F, 2.0F, 2.0F, 5.0F), ModelTransform.pivot(0.0F,0.0F,0.0F));
modelPartData.addChild("body", ModelPartBuilder.create().uv(0,0).cuboid(-5.0F, -20.0F, -8.0F, 10.0F, 8.0F, 16.0F), ModelTransform.pivot(0.0F,24.0F,0.0F));
ModelPartData modelPartData2 = modelPartData.addChild("leg1", ModelPartBuilder.create(), ModelTransform.pivot(0.0F,24.0F,0.0F));
modelPartData2.addChild("bone", ModelPartBuilder.create().uv(0,24).cuboid(-2.0F, -10.3923F, -8.0F, 4.0F, 6.0F, 4.0F), ModelTransform.pivot(4.0F,-2.0F,4.0F));
modelPartData2.addChild("bone2", ModelPartBuilder.create().uv(0,34).cuboid(-1.5F, -10.3154F, 7.0834F, 3.0F, 7.0F, 3.0F), ModelTransform.pivot(4.0F,3.0F,1.0F));
modelPartData2.addChild("bone3", ModelPartBuilder.create().uv(0,9).cuboid(-1.0F, -11.6772F, -3.1753F, 2.0F, 5.0F, 2.0F), ModelTransform.pivot(4.0F,6.0F,5.0F));
ModelPartData modelPartData3 = modelPartData2.addChild("foot1", ModelPartBuilder.create().uv(0,0).cuboid(3.0F, -1.0F, 1.0F, 1.0F, 1.0F, 3.0F).uv(0,5).cuboid(3.0F, -1.0F, 4.0F, 2.0F, 1.0F, 1.0F).uv(0,0).cuboid(4.5F, -1.0F, 1.0F, 1.0F, 1.0F, 3.0F), ModelTransform.pivot(0.0F,0.0F,0.0F));
modelPartData3.addChild("cube_r1", ModelPartBuilder.create().uv(9,0).cuboid(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F), ModelTransform.pivot(3.0F,-1.0F,4.0F));
ModelPartData modelPartData4 = modelPartData.addChild("leg2", ModelPartBuilder.create(), ModelTransform.pivot(-5.0F,30.0F,2.0F));
modelPartData4.addChild("bone4", ModelPartBuilder.create().uv(0,24).cuboid(-2.0F, -10.3923F, -8.0F, 4.0F, 6.0F, 4.0F), ModelTransform.pivot(0.0F,-8.0F,2.0F));
modelPartData4.addChild("bone5", ModelPartBuilder.create().uv(0,34).cuboid(-1.5F, -10.3154F, 7.0834F, 3.0F, 7.0F, 3.0F), ModelTransform.pivot(0.0F,-3.0F,-1.0F));
modelPartData4.addChild("bone6", ModelPartBuilder.create().uv(0,9).cuboid(-1.0F, -11.6772F, -3.1753F, 2.0F, 5.0F, 2.0F), ModelTransform.pivot(0.0F,0.0F,3.0F));
ModelPartData modelPartData5 = modelPartData4.addChild("foot2", ModelPartBuilder.create().uv(0,0).cuboid(0.0F, -7.0F, -1.0F, 1.0F, 1.0F, 3.0F).uv(0,0).cuboid(-1.5F, -7.0F, -1.0F, 1.0F, 1.0F, 3.0F).uv(0,5).cuboid(-1.0F, -7.0F, 2.0F, 2.0F, 1.0F, 1.0F), ModelTransform.pivot(0.0F,0.0F,0.0F));
modelPartData5.addChild("cube_r2", ModelPartBuilder.create().uv(9,0).cuboid(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F), ModelTransform.pivot(1.0F,-7.0F,2.0F));
ModelPartData modelPartData6 = modelPartData.addChild("neck", ModelPartBuilder.create(), ModelTransform.pivot(0.0F,16.0F,-7.0F));
modelPartData6.addChild("cube_r3", ModelPartBuilder.create().uv(12,24).cuboid(-2.0F, 1.0F, -7.0F, 4.0F, 4.0F, 10.0F), ModelTransform.pivot(0.0F,-12.0F,0.0F));
ModelPartData modelPartData7 = modelPartData6.addChild("head", ModelPartBuilder.create().uv(0,53).cuboid(-2.5F, -13.0F, 0.0F, 5.0F, 5.0F, 6.0F), ModelTransform.pivot(0.0F,-4.0F,-12.0F));
ModelPartData modelPartData8 = modelPartData7.addChild("top", ModelPartBuilder.create().uv(16,54).cuboid(-2.0F, -23.5F, -20.8F, 4.0F, 1.0F, 2.0F).uv(17,47).cuboid(-2.0F, -22.5F, -24.0F, 4.0F, 1.0F, 5.0F), ModelTransform.pivot(0.0F,12.0F,19.0F));
modelPartData8.addChild("cube_r4", ModelPartBuilder.create().uv(22,58).cuboid(-2.0F, 0.0F, -5.0F, 4.0F, 1.0F, 5.0F), ModelTransform.pivot(0.0F,-24.0F,-19.0F));
modelPartData7.addChild("bottom", ModelPartBuilder.create().uv(0,47).cuboid(-1.5F, -21.5F, -24.0F, 3.0F, 1.0F, 5.0F), ModelTransform.pivot(0.0F,12.0F,19.0F));
ModelPartData modelPartData9 = modelPartData.addChild("arm1", ModelPartBuilder.create().uv(54,60).cuboid(-3.0F, -13.0F, 0.0F, 3.0F, 2.0F, 2.0F), ModelTransform.pivot(8.0F,19.0F,-6.0F));
modelPartData9.addChild("cube_r5", ModelPartBuilder.create().uv(39,52).cuboid(0.0F, 0.0F, 0.0F, 10.0F, 0.0F, 5.0F).uv(42,58).cuboid(0.0F, -0.5F, -1.0F, 10.0F, 1.0F, 1.0F), ModelTransform.pivot(0.0F,-12.0F,0.0F));
ModelPartData modelPartData10 = modelPartData.addChild("arm2", ModelPartBuilder.create().uv(54,60).cuboid(0.0F, -13.0F, 0.0F, 3.0F, 2.0F, 2.0F), ModelTransform.pivot(-8.0F,19.0F,-6.0F));
modelPartData10.addChild("cube_r6", ModelPartBuilder.create().uv(39,52).cuboid(-10.0F, 0.0F, 0.0F, 10.0F, 0.0F, 5.0F).uv(42,58).cuboid(-10.0F, -0.5F, -1.0F, 10.0F, 1.0F, 1.0F), ModelTransform.pivot(0.0F,-12.0F,0.0F));
return TexturedModelData.of(modelData,64,64);
		
		
}
@Override
public void setAngles(TroodonEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
this.bone.pitch = -0.5236F;
this.bone2.pitch = 0.7854F;
this.bone3.pitch = -0.1309F;
this.cube_r1.pitch = -0.3054F;
this.cube_r1.yaw = 0.2618F;
this.bone4.pitch = -0.5236F;
this.bone5.pitch = 0.7854F;
this.bone6.pitch = -0.1309F;
this.cube_r2.pitch = -0.3054F;
this.cube_r2.yaw = -0.2618F;
this.cube_r3.pitch = -0.6981F;
this.cube_r4.pitch = 0.2618F;
this.cube_r5.yaw = -0.3054F;
this.cube_r6.yaw = 0.3054F;
		//previously the render function, render code was moved to a method below
}
@Override
public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		
		tail.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		leg1.render(matrixStack, buffer, packedLight, packedOverlay);
		leg2.render(matrixStack, buffer, packedLight, packedOverlay);
		neck.render(matrixStack, buffer, packedLight, packedOverlay);
		arm1.render(matrixStack, buffer, packedLight, packedOverlay);
		arm2.render(matrixStack, buffer, packedLight, packedOverlay);
}
public void setRotationAngle(ModelPart bone, float x, float y, float z) {
		bone.pitch = x;
		bone.yaw = y;
		bone.roll = z;
}
	}