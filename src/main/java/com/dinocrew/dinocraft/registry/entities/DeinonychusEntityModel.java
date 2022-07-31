package com.dinocrew.dinocraft.registry.entities;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class DeinonychusEntityModel extends EntityModel<DeinonychusEntity> {
    private final ModelPart body;
    private final ModelPart left_arm;
    private final ModelPart left_wing;
    private final ModelPart neck;
    private final ModelPart cube_r1;
    private final ModelPart head;
    private final ModelPart top;
    private final ModelPart cube_r2;
    private final ModelPart bottom;
    private final ModelPart right_arm;
    private final ModelPart right_wing;
    private final ModelPart tail;
    private final ModelPart tail2;
    private final ModelPart tail3;
    private final ModelPart left_hip;
    private final ModelPart left_leg;
    private final ModelPart left_knee;
    private final ModelPart left_foot;
    private final ModelPart cube_r3;
    private final ModelPart right_hip;
    private final ModelPart right_leg;
    private final ModelPart right_knee;
    private final ModelPart right_foot;
    private final ModelPart cube_r4;

    public DeinonychusEntityModel(ModelPart root) {
        this.body = root.getChild("body");
        this.tail = this.body.getChild("tail");
        this.tail2 = this.tail.getChild("tail2");
        this.tail3 = this.tail2.getChild("tail3");
        this.right_arm = this.body.getChild("right_arm");
        this.right_wing = this.right_arm.getChild("right_wing");
        this.neck = this.body.getChild("neck");
        this.head = this.neck.getChild("head");
        this.bottom = this.head.getChild("bottom");
        this.top = this.head.getChild("top");
        this.cube_r2 = this.top.getChild("cube_r2");
        this.cube_r1 = this.neck.getChild("cube_r1");
        this.left_arm = this.body.getChild("left_arm");
        this.left_wing = this.left_arm.getChild("left_wing");
        this.left_hip = root.getChild("left_hip");
        this.left_leg = this.left_hip.getChild("left_leg");
        this.left_knee = this.left_leg.getChild("left_knee");
        this.left_foot = this.left_knee.getChild("left_foot");
        this.cube_r3 = this.left_foot.getChild("cube_r3");
        this.right_hip = root.getChild("right_hip");
        this.right_leg = this.right_hip.getChild("right_leg");
        this.right_knee = this.right_leg.getChild("right_knee");
        this.right_foot = this.right_knee.getChild("right_foot");
        this.cube_r4 = this.right_foot.getChild("cube_r4");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();

        ModelPartData modelPartData1 = modelPartData.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-5.0F, -20.0F, -8.0F, 10.0F, 8.0F, 16.0F), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
        ModelPartData modelPartData2 = modelPartData1.addChild("left_arm", ModelPartBuilder.create().uv(54, 60).cuboid(0.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F), ModelTransform.pivot(5.0F, -15.0F, -5.0F));
        modelPartData2.addChild("left_wing", ModelPartBuilder.create().uv(42, 58).cuboid(0.0F, -0.5F, -1.0F, 10.0F, 1.0F, 1.0F).uv(39, 52).cuboid(0.0F, 0.0F, 0.0F, 10.0F, 0.0F, 5.0F), ModelTransform.pivot(3.0F, 0.0F, -1.0F));
        ModelPartData modelPartData3 = modelPartData1.addChild("neck", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -16.0F, -7.0F));
        modelPartData3.addChild("cube_r1", ModelPartBuilder.create().uv(12, 24).cuboid(-2.0F, 1.0F, -7.0F, 4.0F, 4.0F, 10.0F), ModelTransform.pivot(0.0F, -4.0F, 0.0F));
        ModelPartData modelPartData4 = modelPartData3.addChild("head", ModelPartBuilder.create().uv(0, 53).cuboid(-2.5F, -3.0F, -6.0F, 5.0F, 5.0F, 6.0F), ModelTransform.pivot(0.0F, -6.0F, -6.0F));
        ModelPartData modelPartData5 = modelPartData4.addChild("top", ModelPartBuilder.create().uv(16, 54).cuboid(-2.0F, -23.5F, -20.8F, 4.0F, 1.0F, 2.0F).uv(17, 47).cuboid(-2.0F, -22.5F, -24.0F, 4.0F, 1.0F, 5.0F), ModelTransform.pivot(0.0F, 22.0F, 13.0F));
        modelPartData5.addChild("cube_r2", ModelPartBuilder.create().uv(22, 58).cuboid(-2.0F, 0.0F, -5.0F, 4.0F, 1.0F, 5.0F), ModelTransform.pivot(0.0F, -24.0F, -19.0F));
        modelPartData4.addChild("bottom", ModelPartBuilder.create().uv(0, 47).cuboid(-1.5F, -21.5F, -24.0F, 3.0F, 1.0F, 5.0F), ModelTransform.pivot(0.0F, 22.0F, 13.0F));
        ModelPartData modelPartData6 = modelPartData1.addChild("right_arm", ModelPartBuilder.create().uv(54, 60).cuboid(-3.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F), ModelTransform.pivot(-5.0F, -15.0F, -5.0F));
        modelPartData6.addChild("right_wing", ModelPartBuilder.create().uv(39, 52).cuboid(-10.0F, 0.0F, 0.0F, 10.0F, 0.0F, 5.0F).uv(42, 58).cuboid(-10.0F, -0.5F, -1.0F, 10.0F, 1.0F, 1.0F), ModelTransform.pivot(-3.0F, 0.0F, -1.0F));
        ModelPartData modelPartData7 = modelPartData1.addChild("tail", ModelPartBuilder.create().uv(42, 0).cuboid(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 7.0F), ModelTransform.pivot(0.0F, -17.0F, 8.0F));
        ModelPartData modelPartData8 = modelPartData7.addChild("tail2", ModelPartBuilder.create().uv(46, 26).cuboid(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 6.0F), ModelTransform.pivot(0.0F, 0.0F, 7.0F));
        modelPartData8.addChild("tail3", ModelPartBuilder.create().uv(50, 19).cuboid(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 5.0F), ModelTransform.pivot(0.0F, 0.0F, 6.0F));
        ModelPartData modelPartData9 = modelPartData.addChild("left_hip", ModelPartBuilder.create().uv(0, 24).cuboid(-2.0F, -1.3923F, -2.0F, 4.0F, 6.0F, 4.0F), ModelTransform.pivot(4.0F, 11.0F, 4.0F));
        ModelPartData modelPartData10 = modelPartData9.addChild("left_leg", ModelPartBuilder.create().uv(0, 34).cuboid(-1.5F, -1.3154F, -0.9166F, 3.0F, 7.0F, 3.0F), ModelTransform.pivot(0.0F, 5.0F, -1.0F));
        ModelPartData modelPartData11 = modelPartData10.addChild("left_knee", ModelPartBuilder.create().uv(0, 9).cuboid(-1.0F, -0.6772F, -1.1753F, 2.0F, 5.0F, 2.0F), ModelTransform.pivot(0.0F, 6.0F, 1.0F));
        ModelPartData modelPartData12 = modelPartData11.addChild("left_foot", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, 0.0F, -4.0F, 1.0F, 1.0F, 3.0F).uv(0, 5).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 1.0F).uv(0, 0).cuboid(0.5F, 0.0F, -4.0F, 1.0F, 1.0F, 3.0F), ModelTransform.pivot(0.0F, 4.0F, 0.0F));
        modelPartData12.addChild("cube_r3", ModelPartBuilder.create().uv(9, 0).cuboid(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F), ModelTransform.pivot(-1.0F, 0.0F, -1.0F));
        ModelPartData modelPartData13 = modelPartData.addChild("right_hip", ModelPartBuilder.create().uv(0, 24).cuboid(-2.0F, -1.3923F, -2.0F, 4.0F, 6.0F, 4.0F), ModelTransform.pivot(-4.0F, 11.0F, 4.0F));
        ModelPartData modelPartData14 = modelPartData13.addChild("right_leg", ModelPartBuilder.create().uv(0, 34).cuboid(-1.5F, -1.3154F, -0.9166F, 3.0F, 7.0F, 3.0F), ModelTransform.pivot(0.0F, 5.0F, -1.0F));
        ModelPartData modelPartData15 = modelPartData14.addChild("right_knee", ModelPartBuilder.create().uv(0, 9).cuboid(-1.0F, -0.6772F, -1.1753F, 2.0F, 5.0F, 2.0F), ModelTransform.pivot(0.0F, 6.0F, 1.0F));
        ModelPartData modelPartData16 = modelPartData15.addChild("right_foot", ModelPartBuilder.create().uv(0, 0).cuboid(-1.5F, 0.0F, -4.0F, 1.0F, 1.0F, 3.0F).uv(0, 5).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 1.0F).uv(0, 0).cuboid(0.0F, 0.0F, -4.0F, 1.0F, 1.0F, 3.0F), ModelTransform.pivot(0.0F, 4.0F, 0.0F));
        modelPartData16.addChild("cube_r4", ModelPartBuilder.create().uv(9, 0).cuboid(-6.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F), ModelTransform.pivot(7.0F, 0.0F, -1.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void setAngles(DeinonychusEntity entity, float limbAngle, float limbDistance, float animationProgress, float netHeadYaw, float headPitch) {
        this.left_wing.yaw = -0.2618F;
        this.cube_r1.pitch = -0.6981F;
        this.cube_r2.pitch = 0.2618F;
        this.right_wing.yaw = 0.2618F;
        this.cube_r3.pitch = -0.3054F;
        this.cube_r3.yaw = 0.2618F;
        this.cube_r4.pitch = -0.3054F;
        this.cube_r4.yaw = -0.2618F;

        this.right_hip.pitch = MathHelper.cos(limbAngle * 0.6662F + 3.1415927F) * 1.4F * limbDistance / 3 - 0.5672F;
        this.right_leg.pitch = MathHelper.cos(limbAngle * 0.6662F + 3.1415927F) * 1.4F * limbDistance / 3 + 1.1781F;
        this.right_knee.pitch = MathHelper.cos(limbAngle * 0.6662F + 3.1415927F) * 1.4F * limbDistance / 3 - 0.6109F;
        this.left_hip.pitch = -MathHelper.cos(limbAngle * 0.6662F + 3.1415927F) * 1.4F * limbDistance / 3 - 0.5672F;
        this.left_leg.pitch = -MathHelper.cos(limbAngle * 0.6662F + 3.1415927F) * 1.4F * limbDistance / 3 + 1.1781F;
        this.left_knee.pitch = -MathHelper.cos(limbAngle * 0.6662F + 3.1415927F) * 1.4F * limbDistance / 3 - 0.6109F;

        float tailSpeed = 0.2f;
        float swingAmount = 0.05f;

        this.left_arm.roll = MathHelper.cos(animationProgress * tailSpeed) * swingAmount;
        this.right_arm.roll = -MathHelper.cos(animationProgress * tailSpeed) * swingAmount;

        this.left_wing.roll = MathHelper.cos(animationProgress * tailSpeed) * swingAmount;
        this.right_wing.roll = -MathHelper.cos(animationProgress * tailSpeed) * swingAmount;

        this.tail.pitch = MathHelper.cos(animationProgress * tailSpeed) * swingAmount;
        this.tail2.pitch = MathHelper.sin(animationProgress * tailSpeed) * swingAmount;
        this.tail3.pitch = MathHelper.cos(animationProgress * tailSpeed) * swingAmount;

        this.tail.yaw = MathHelper.sin(animationProgress * tailSpeed) * swingAmount;
        this.tail2.yaw = MathHelper.cos(animationProgress * tailSpeed) * swingAmount;
        this.tail3.yaw = MathHelper.sin(animationProgress * tailSpeed) * swingAmount;

    }

    @Override
    public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        left_hip.render(matrixStack, buffer, packedLight, packedOverlay);
        right_hip.render(matrixStack, buffer, packedLight, packedOverlay);
    }
}