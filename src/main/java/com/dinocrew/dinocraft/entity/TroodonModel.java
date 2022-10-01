// Made with Model Converter by Globox_Z
// Generate all required imports
// Made with Blockbench 4.0.5
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports
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

public class TroodonModel extends HierarchicalModel<Troodon> {
    private final ModelPart root;
    private final ModelPart body;
    private final ModelPart neck1;
    private final ModelPart neck2;
    private final ModelPart head;
    private final ModelPart nose;
    private final ModelPart nose_r1;
    private final ModelPart jaw;
    private final ModelPart right_arm;
    private final ModelPart right_wrist;
    private final ModelPart left_arm;
    private final ModelPart left_wrist;
    private final ModelPart tail1;
    private final ModelPart tail2;
    private final ModelPart tail3;
    private final ModelPart right_hip;
    private final ModelPart right_leg;
    private final ModelPart right_knee;
    private final ModelPart right_foot;
    private final ModelPart left_hip;
    private final ModelPart left_leg;
    private final ModelPart left_knee;
    private final ModelPart left_foot;

    public TroodonModel(ModelPart root) {
        super(RenderType::entityCutoutNoCull);
        this.root = root;
        this.body = this.root.getChild("body");
        this.tail1 = this.body.getChild("tail1");
        this.tail2 = this.tail1.getChild("tail2");
        this.tail3 = this.tail2.getChild("tail3");
        this.left_arm = this.body.getChild("left_arm");
        this.left_wrist = this.left_arm.getChild("left_wrist");
        this.right_arm = this.body.getChild("right_arm");
        this.right_wrist = this.right_arm.getChild("right_wrist");
        this.neck1 = this.body.getChild("neck1");
        this.neck2 = this.neck1.getChild("neck2");
        this.head = this.neck2.getChild("head");
        this.jaw = this.head.getChild("jaw");
        this.nose = this.head.getChild("nose");
        this.nose_r1 = this.nose.getChild("nose_r1");
        this.right_hip = this.root.getChild("right_hip");
        this.right_leg = this.right_hip.getChild("right_leg");
        this.right_knee = this.right_leg.getChild("right_knee");
        this.right_foot = this.right_knee.getChild("right_foot");
        this.left_hip = this.root.getChild("left_hip");
        this.left_leg = this.left_hip.getChild("left_leg");
        this.left_knee = this.left_leg.getChild("left_knee");
        this.left_foot = this.left_knee.getChild("left_foot");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition modelData = new MeshDefinition();
        PartDefinition modelPartData = modelData.getRoot();
        PartDefinition modelPartData1 = modelPartData.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -6.0F, -9.0F, 12.0F, 12.0F, 18.0F), PartPose.offset(0.0F, 2.0F, 0.0F));
        PartDefinition modelPartData2 = modelPartData1.addOrReplaceChild("neck1", CubeListBuilder.create().texOffs(58, 48).addBox(-4.0F, -4.5F, -8.0F, 8.0F, 9.0F, 8.0F), PartPose.offset(0.0F, -1.5F, -5.0F));
        PartDefinition modelPartData3 = modelPartData2.addOrReplaceChild("neck2", CubeListBuilder.create().texOffs(78, 0).addBox(-3.0F, -3.0F, -7.25F, 6.0F, 6.0F, 8.0F), PartPose.offset(0.0F, 0.0F, -6.25F));
        PartDefinition modelPartData4 = modelPartData3.addOrReplaceChild("head", CubeListBuilder.create().texOffs(24, 34).addBox(-4.5F, -2.0F, -12.0F, 9.0F, 7.0F, 12.0F).texOffs(70, 79).addBox(-3.5F, 0.0F, -20.0F, 7.0F, 3.0F, 8.0F), PartPose.offset(0.0F, -3.0F, -7.25F));
        PartDefinition modelPartData5 = modelPartData4.addOrReplaceChild("nose", CubeListBuilder.create(), PartPose.offset(-0.5F, 0.0F, -20.0F));
        modelPartData5.addOrReplaceChild("nose_r1", CubeListBuilder.create().texOffs(0, 71).addBox(-2.5F, 0.0F, 0.0F, 5.0F, 4.0F, 10.0F), PartPose.offset(0.5F, 0.0F, 0.0F));
        modelPartData4.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(62, 65).addBox(-2.5F, 0.0F, 0.0F, 6.0F, 2.0F, 10.0F), PartPose.offset(-0.5F, 3.0F, -20.0F));
        PartDefinition modelPartData6 = modelPartData1.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -1.0F, -2.5F, 4.0F, 10.0F, 5.0F).texOffs(70, 101).addBox(-1.5F, -1.0F, -2.5F, 0.0F, 13.0F, 14.0F), PartPose.offset(-4.5F, -2.0F, -6.5F));
        modelPartData6.addOrReplaceChild("right_wrist", CubeListBuilder.create().texOffs(26, 84).addBox(-1.5F, -0.75F, -2.0F, 2.0F, 10.0F, 4.0F).texOffs(108, 105).addBox(-0.5F, -3.75F, 2.0F, 0.0F, 13.0F, 10.0F), PartPose.offset(-0.5F, 8.25F, 0.0F));
        PartDefinition modelPartData7 = modelPartData1.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -1.0F, -2.5F, 4.0F, 10.0F, 5.0F, true).texOffs(0, 101).addBox(1.5F, -1.0F, -2.5F, 0.0F, 13.0F, 14.0F, true), PartPose.offset(4.5F, -2.0F, -6.5F));
        modelPartData7.addOrReplaceChild("left_wrist", CubeListBuilder.create().texOffs(28, 105).addBox(0.5F, -3.75F, 2.0F, 0.0F, 13.0F, 10.0F, true).texOffs(26, 84).addBox(-0.5F, -0.75F, -2.0F, 2.0F, 10.0F, 4.0F, true), PartPose.offset(0.5F, 8.25F, 0.0F));
        PartDefinition modelPartData8 = modelPartData1.addOrReplaceChild("tail1", CubeListBuilder.create().texOffs(54, 18).addBox(-4.0F, -3.0F, 0.0F, 8.0F, 8.0F, 12.0F), PartPose.offset(0.0F, -3.0F, 7.0F));
        PartDefinition modelPartData9 = modelPartData8.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(42, 0).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 6.0F, 12.0F), PartPose.offset(0.0F, -2.0F, 12.0F));
        modelPartData9.addOrReplaceChild("tail3", CubeListBuilder.create().texOffs(0, 46).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 3.0F, 16.0F), PartPose.offset(0.0F, 2.0F, 12.0F));
        PartDefinition modelPartData10 = modelPartData.addOrReplaceChild("right_hip", CubeListBuilder.create().texOffs(30, 56).addBox(-3.0F, -3.0F, -5.0F, 6.0F, 12.0F, 10.0F, true), PartPose.offset(-4.5F, 3.5F, 6.5F));
        PartDefinition modelPartData11 = modelPartData10.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(82, 14).addBox(-2.5F, -1.5F, -3.0F, 5.0F, 8.0F, 6.0F, true), PartPose.offset(0.0F, 6.5F, 1.0F));
        PartDefinition modelPartData12 = modelPartData11.addOrReplaceChild("right_knee", CubeListBuilder.create().texOffs(0, 46).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 11.0F, 4.0F, true), PartPose.offset(0.0F, 4.5F, -1.5F));
        modelPartData12.addOrReplaceChild("right_foot", CubeListBuilder.create().texOffs(70, 38).addBox(-3.0F, 0.0F, -6.5F, 6.0F, 2.0F, 8.0F, true), PartPose.offset(0.0F, 9.5F, -0.5F));
        PartDefinition modelPartData13 = modelPartData.addOrReplaceChild("left_hip", CubeListBuilder.create().texOffs(30, 56).addBox(-3.0F, -3.0F, -5.0F, 6.0F, 12.0F, 10.0F), PartPose.offset(4.5F, 3.5F, 6.5F));
        PartDefinition modelPartData14 = modelPartData13.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(82, 14).addBox(-2.5F, -1.5F, -3.0F, 5.0F, 8.0F, 6.0F), PartPose.offset(0.0F, 6.5F, 1.0F));
        PartDefinition modelPartData15 = modelPartData14.addOrReplaceChild("left_knee", CubeListBuilder.create().texOffs(0, 46).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 11.0F, 4.0F), PartPose.offset(0.0F, 4.5F, -1.5F));
        modelPartData15.addOrReplaceChild("left_foot", CubeListBuilder.create().texOffs(70, 38).addBox(-3.0F, 0.0F, -6.5F, 6.0F, 2.0F, 8.0F), PartPose.offset(0.0F, 9.5F, -0.5F));
        return LayerDefinition.create(modelData, 128, 128);

    }

    @Override
    public void setupAnim(Troodon entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.nose.xRot = 0.5236F;
        this.nose_r1.xRot = -0.3491F;
        this.jaw.xRot = 0.1745F;
        this.right_arm.xRot = 0.1745F;
        this.right_arm.zRot = 0.6037F - Mth.cos(ageInTicks / 5) / 10;
        this.right_wrist.xRot = -0.7418F;
        this.left_arm.xRot = 0.1434F;
        this.left_arm.yRot = 0.0998F;
        this.left_arm.zRot = -0.6037F + Mth.cos(ageInTicks / 5) / 10;
        this.left_wrist.xRot = -0.7418F;

        this.tail1.yRot = Mth.cos(ageInTicks / 5) / 10;
        this.tail2.yRot = Mth.sin(ageInTicks / 5) / 10;
        this.tail3.yRot = Mth.cos(ageInTicks / 5) / 10;

        this.right_wrist.zRot = -Mth.sin(ageInTicks / 5) / 10;
        this.left_wrist.zRot = Mth.sin(ageInTicks / 5) / 10;

        float flatAngle = 3 * (limbSwingAmount) + 1;
        this.body.xRot = -0.1745F / flatAngle;
        this.neck1.xRot = -0.5236F / flatAngle;
        this.neck2.xRot = -0.48F / flatAngle;
        this.head.xRot = 1.3963F / flatAngle;
        this.tail1.xRot = 0.1745F / flatAngle;
        this.body.zRot = Mth.cos(limbSwing * 2) * limbSwingAmount / 7;


        this.right_hip.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwingAmount / 3 - 0.3491F;
        this.right_leg.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwingAmount / 3 + 1.2217F;
        this.right_knee.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwingAmount / 3 - 1.3963F;
        this.right_foot.xRot = 0.5236F;
        this.left_hip.xRot = -Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwingAmount / 3 - 0.3491F;
        this.left_leg.xRot = -Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwingAmount / 3 + 1.2217F;
        this.left_knee.xRot = -Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwingAmount / 3 - 1.3963F;
        this.left_foot.xRot = 0.5236F;
    }

    @Override
    public void renderToBuffer(PoseStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {

        body.render(matrixStack, buffer, packedLight, packedOverlay);
        right_hip.render(matrixStack, buffer, packedLight, packedOverlay);
        left_hip.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }
}