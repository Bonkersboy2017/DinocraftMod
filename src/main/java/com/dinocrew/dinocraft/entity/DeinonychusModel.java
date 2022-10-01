package com.dinocrew.dinocraft.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.util.Mth;

public class DeinonychusModel extends HierarchicalModel<Deinonychus> {
    private final ModelPart root;
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

    public DeinonychusModel(ModelPart root) {
        super(RenderType::entityCutoutNoCull);
        this.root = root;
        this.body = this.root.getChild("body");
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
        this.left_hip = this.root.getChild("left_hip");
        this.left_leg = this.left_hip.getChild("left_leg");
        this.left_knee = this.left_leg.getChild("left_knee");
        this.left_foot = this.left_knee.getChild("left_foot");
        this.cube_r3 = this.left_foot.getChild("cube_r3");
        this.right_hip = this.root.getChild("right_hip");
        this.right_leg = this.right_hip.getChild("right_leg");
        this.right_knee = this.right_leg.getChild("right_knee");
        this.right_foot = this.right_knee.getChild("right_foot");
        this.cube_r4 = this.right_foot.getChild("cube_r4");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition modelData = new MeshDefinition();
        PartDefinition modelPartData = modelData.getRoot();

        PartDefinition modelPartData1 = modelPartData.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -20.0F, -8.0F, 10.0F, 8.0F, 16.0F), PartPose.offset(0.0F, 24.0F, 0.0F));
        PartDefinition modelPartData2 = modelPartData1.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(54, 60).addBox(0.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F), PartPose.offset(5.0F, -15.0F, -5.0F));
        modelPartData2.addOrReplaceChild("left_wing", CubeListBuilder.create().texOffs(42, 58).addBox(0.0F, -0.5F, -1.0F, 10.0F, 1.0F, 1.0F).texOffs(39, 52).addBox(0.0F, 0.0F, 0.0F, 10.0F, 0.0F, 5.0F), PartPose.offset(3.0F, 0.0F, -1.0F));
        PartDefinition modelPartData3 = modelPartData1.addOrReplaceChild("neck", CubeListBuilder.create(), PartPose.offset(0.0F, -16.0F, -7.0F));
        modelPartData3.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(12, 24).addBox(-2.0F, 1.0F, -7.0F, 4.0F, 4.0F, 10.0F), PartPose.offset(0.0F, -4.0F, 0.0F));
        PartDefinition modelPartData4 = modelPartData3.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 53).addBox(-2.5F, -3.0F, -6.0F, 5.0F, 5.0F, 6.0F), PartPose.offset(0.0F, -6.0F, -6.0F));
        PartDefinition modelPartData5 = modelPartData4.addOrReplaceChild("top", CubeListBuilder.create().texOffs(16, 54).addBox(-2.0F, -23.5F, -20.8F, 4.0F, 1.0F, 2.0F).texOffs(17, 47).addBox(-2.0F, -22.5F, -24.0F, 4.0F, 1.0F, 5.0F), PartPose.offset(0.0F, 22.0F, 13.0F));
        modelPartData5.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(22, 58).addBox(-2.0F, 0.0F, -5.0F, 4.0F, 1.0F, 5.0F), PartPose.offset(0.0F, -24.0F, -19.0F));
        modelPartData4.addOrReplaceChild("bottom", CubeListBuilder.create().texOffs(0, 47).addBox(-1.5F, -21.5F, -24.0F, 3.0F, 1.0F, 5.0F), PartPose.offset(0.0F, 22.0F, 13.0F));
        PartDefinition modelPartData6 = modelPartData1.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(54, 60).addBox(-3.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F), PartPose.offset(-5.0F, -15.0F, -5.0F));
        modelPartData6.addOrReplaceChild("right_wing", CubeListBuilder.create().texOffs(39, 52).addBox(-10.0F, 0.0F, 0.0F, 10.0F, 0.0F, 5.0F).texOffs(42, 58).addBox(-10.0F, -0.5F, -1.0F, 10.0F, 1.0F, 1.0F), PartPose.offset(-3.0F, 0.0F, -1.0F));
        PartDefinition modelPartData7 = modelPartData1.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(42, 0).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 7.0F), PartPose.offset(0.0F, -17.0F, 8.0F));
        PartDefinition modelPartData8 = modelPartData7.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(46, 26).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 6.0F), PartPose.offset(0.0F, 0.0F, 7.0F));
        modelPartData8.addOrReplaceChild("tail3", CubeListBuilder.create().texOffs(50, 19).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 5.0F), PartPose.offset(0.0F, 0.0F, 6.0F));
        PartDefinition modelPartData9 = modelPartData.addOrReplaceChild("left_hip", CubeListBuilder.create().texOffs(0, 24).addBox(-2.0F, -1.3923F, -2.0F, 4.0F, 6.0F, 4.0F), PartPose.offset(4.0F, 11.0F, 4.0F));
        PartDefinition modelPartData10 = modelPartData9.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 34).addBox(-1.5F, -1.3154F, -0.9166F, 3.0F, 7.0F, 3.0F), PartPose.offset(0.0F, 5.0F, -1.0F));
        PartDefinition modelPartData11 = modelPartData10.addOrReplaceChild("left_knee", CubeListBuilder.create().texOffs(0, 9).addBox(-1.0F, -0.6772F, -1.1753F, 2.0F, 5.0F, 2.0F), PartPose.offset(0.0F, 6.0F, 1.0F));
        PartDefinition modelPartData12 = modelPartData11.addOrReplaceChild("left_foot", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -4.0F, 1.0F, 1.0F, 3.0F).texOffs(0, 5).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(0.5F, 0.0F, -4.0F, 1.0F, 1.0F, 3.0F), PartPose.offset(0.0F, 4.0F, 0.0F));
        modelPartData12.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(9, 0).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F), PartPose.offset(-1.0F, 0.0F, -1.0F));
        PartDefinition modelPartData13 = modelPartData.addOrReplaceChild("right_hip", CubeListBuilder.create().texOffs(0, 24).addBox(-2.0F, -1.3923F, -2.0F, 4.0F, 6.0F, 4.0F), PartPose.offset(-4.0F, 11.0F, 4.0F));
        PartDefinition modelPartData14 = modelPartData13.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 34).addBox(-1.5F, -1.3154F, -0.9166F, 3.0F, 7.0F, 3.0F), PartPose.offset(0.0F, 5.0F, -1.0F));
        PartDefinition modelPartData15 = modelPartData14.addOrReplaceChild("right_knee", CubeListBuilder.create().texOffs(0, 9).addBox(-1.0F, -0.6772F, -1.1753F, 2.0F, 5.0F, 2.0F), PartPose.offset(0.0F, 6.0F, 1.0F));
        PartDefinition modelPartData16 = modelPartData15.addOrReplaceChild("right_foot", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, 0.0F, -4.0F, 1.0F, 1.0F, 3.0F).texOffs(0, 5).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(0.0F, 0.0F, -4.0F, 1.0F, 1.0F, 3.0F), PartPose.offset(0.0F, 4.0F, 0.0F));
        modelPartData16.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(9, 0).addBox(-6.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F), PartPose.offset(7.0F, 0.0F, -1.0F));
        return LayerDefinition.create(modelData, 64, 64);
    }

    @Override
    public void setupAnim(Deinonychus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.left_wing.yRot = -0.2618F;
        this.cube_r1.xRot = -0.6981F;
        this.cube_r2.xRot = 0.2618F;
        this.right_wing.yRot = 0.2618F;
        this.cube_r3.xRot = -0.3054F;
        this.cube_r3.yRot = 0.2618F;
        this.cube_r4.xRot = -0.3054F;
        this.cube_r4.yRot = -0.2618F;

        this.right_hip.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwingAmount / 3 - 0.5672F;
        this.right_leg.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwingAmount / 3 + 1.1781F;
        this.right_knee.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwingAmount / 3 - 0.6109F;
        this.left_hip.xRot = -Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwingAmount / 3 - 0.5672F;
        this.left_leg.xRot = -Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwingAmount / 3 + 1.1781F;
        this.left_knee.xRot = -Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwingAmount / 3 - 0.6109F;

        float tailSpeed = 0.2f;
        float swingAmount = 0.05f;

        this.left_arm.zRot = Mth.cos(ageInTicks * tailSpeed) * swingAmount;
        this.right_arm.zRot = -Mth.cos(ageInTicks * tailSpeed) * swingAmount;

        this.left_wing.zRot = Mth.cos(ageInTicks * tailSpeed) * swingAmount;
        this.right_wing.zRot = -Mth.cos(ageInTicks * tailSpeed) * swingAmount;

        this.tail.xRot = Mth.cos(ageInTicks * tailSpeed) * swingAmount;
        this.tail2.xRot = Mth.sin(ageInTicks * tailSpeed) * swingAmount;
        this.tail3.xRot = Mth.cos(ageInTicks * tailSpeed) * swingAmount;

        this.tail.yRot = Mth.sin(ageInTicks * tailSpeed) * swingAmount;
        this.tail2.yRot = Mth.cos(ageInTicks * tailSpeed) * swingAmount;
        this.tail3.yRot = Mth.sin(ageInTicks * tailSpeed) * swingAmount;

    }

    @Override
    public void renderToBuffer(PoseStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        left_hip.render(matrixStack, buffer, packedLight, packedOverlay);
        right_hip.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }
}