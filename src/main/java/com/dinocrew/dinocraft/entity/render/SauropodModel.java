// Made with Model Converter by Globox_Z
// Generate all required imports
// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports
package com.dinocrew.dinocraft.entity.render;

import com.dinocrew.dinocraft.entity.Sauropod;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.util.Mth;

public class SauropodModel extends HierarchicalModel<Sauropod> {
    private final ModelPart root;
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

    public SauropodModel(ModelPart root) {
        super(RenderType::entityCutoutNoCull);
        this.root = root;
        this.body = this.root.getChild("body");
        this.tail_begin = this.body.getChild("tail_begin");
        this.tail = this.tail_begin.getChild("tail");
        this.tail_end = this.tail.getChild("tail_end");
        this.neck_begin = this.body.getChild("neck_begin");
        this.neck_begin_inside = this.neck_begin.getChild("neck_begin_inside");
        this.neck_end_inside = this.neck_begin_inside.getChild("neck_end_inside");
        this.neck_end = this.neck_end_inside.getChild("neck_end");
        this.head = this.neck_end.getChild("head");
        this.right_front_leg = this.root.getChild("right_front_leg");
        this.right_front_foot = this.right_front_leg.getChild("right_front_foot");
        this.right_back_leg = this.root.getChild("right_back_leg");
        this.right_back_foot = this.right_back_leg.getChild("right_back_foot");
        this.left_front_leg = this.root.getChild("left_front_leg");
        this.left_front_foot = this.left_front_leg.getChild("left_front_foot");
        this.left_back_leg = this.root.getChild("left_back_leg");
        this.left_back_foot = this.left_back_leg.getChild("left_back_foot");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition modelData = new MeshDefinition();
        PartDefinition modelPartData = modelData.getRoot();
        PartDefinition modelPartData1 = modelPartData.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -9.0F, -8.0F, 16.0F, 16.0F, 25.0F), PartPose.offset(0.0F, 6.0F, 0.0F));
        PartDefinition modelPartData2 = modelPartData1.addOrReplaceChild("neck_begin", CubeListBuilder.create().texOffs(71, 30).addBox(-7.0F, -1.0F, -9.0F, 14.0F, 12.0F, 11.0F), PartPose.offset(0.0F, -8.0F, -8.0F));
        PartDefinition modelPartData3 = modelPartData2.addOrReplaceChild("neck_begin_inside", CubeListBuilder.create().texOffs(42, 79).addBox(-6.0F, 0.0F, -7.0F, 12.0F, 10.0F, 9.0F), PartPose.offset(0.0F, -1.0F, -9.0F));
        PartDefinition modelPartData4 = modelPartData3.addOrReplaceChild("neck_end_inside", CubeListBuilder.create().texOffs(0, 73).addBox(-4.0F, 0.0F, -11.0F, 8.0F, 8.0F, 13.0F), PartPose.offset(0.0F, 0.0F, -7.0F));
        PartDefinition modelPartData5 = modelPartData4.addOrReplaceChild("neck_end", CubeListBuilder.create().texOffs(84, 79).addBox(-3.0F, 0.0F, -8.0F, 6.0F, 7.0F, 9.0F), PartPose.offset(0.0F, 0.0F, -11.0F));
        modelPartData5.addOrReplaceChild("head", CubeListBuilder.create().texOffs(80, 53).addBox(-4.0F, -5.0F, -9.0F, 8.0F, 7.0F, 11.0F).texOffs(0, 0).addBox(-3.0F, -5.0F, -14.0F, 6.0F, 6.0F, 5.0F).texOffs(92, 0).addBox(-3.0F, -7.0F, -11.0F, 6.0F, 2.0F, 7.0F), PartPose.offset(0.0F, 4.0F, -8.0F));
        PartDefinition modelPartData6 = modelPartData1.addOrReplaceChild("tail_begin", CubeListBuilder.create().texOffs(0, 41).addBox(-7.0F, -1.0F, -4.0F, 14.0F, 12.0F, 20.0F), PartPose.offset(0.0F, -7.0F, 17.0F));
        PartDefinition modelPartData7 = modelPartData6.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(57, 0).addBox(-5.0F, -3.0F, -1.0F, 10.0F, 9.0F, 15.0F), PartPose.offset(0.0F, 3.0F, 15.0F));
        modelPartData7.addOrReplaceChild("tail_end", CubeListBuilder.create().texOffs(49, 54).addBox(-3.0F, -2.0F, -4.0F, 6.0F, 6.0F, 19.0F), PartPose.offset(0.0F, 0.0F, 14.0F));
        PartDefinition modelPartData8 = modelPartData.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(0, 41).addBox(-10.0F, -2.0F, -2.0F, 4.0F, 8.0F, 5.0F, new CubeDeformation(0.5F)), PartPose.offset(2.0F, 10.0F, -6.0F));
        modelPartData8.addOrReplaceChild("right_front_foot", CubeListBuilder.create().texOffs(0, 11).addBox(-10.0F, -1.0F, -2.0F, 4.0F, 8.0F, 5.0F), PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition modelPartData9 = modelPartData.addOrReplaceChild("right_back_leg", CubeListBuilder.create().texOffs(29, 73).addBox(-10.0F, -1.0F, -2.0F, 4.0F, 8.0F, 5.0F, new CubeDeformation(0.5F)), PartPose.offset(2.0F, 10.0F, 10.0F));
        modelPartData9.addOrReplaceChild("right_back_foot", CubeListBuilder.create().texOffs(48, 41).addBox(-10.0F, -1.0F, -2.0F, 4.0F, 8.0F, 5.0F), PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition modelPartData10 = modelPartData.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(79, 95).addBox(6.0F, -2.0F, -2.0F, 4.0F, 8.0F, 5.0F, new CubeDeformation(0.5F)), PartPose.offset(-2.0F, 10.0F, -6.0F));
        modelPartData10.addOrReplaceChild("left_front_foot", CubeListBuilder.create().texOffs(97, 95).addBox(6.0F, -1.0F, -2.0F, 4.0F, 8.0F, 5.0F), PartPose.offset(0.0F, 7.0F, 0.0F));
        PartDefinition modelPartData11 = modelPartData.addOrReplaceChild("left_back_leg", CubeListBuilder.create().texOffs(18, 94).addBox(6.0F, -1.0F, -2.0F, 4.0F, 8.0F, 5.0F, new CubeDeformation(0.5F)), PartPose.offset(-2.0F, 10.0F, 10.0F));
        modelPartData11.addOrReplaceChild("left_back_foot", CubeListBuilder.create().texOffs(0, 94).addBox(6.0F, -1.0F, -2.0F, 4.0F, 8.0F, 5.0F), PartPose.offset(0.0F, 7.0F, 0.0F));
        return LayerDefinition.create(modelData, 128, 128);
    }

    @Override
    public void setupAnim(Sauropod entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float tailSpeed = 0.2f;
        float swingAmount = 0.05f;

        this.body.xRot = -0.2618F;

        this.tail_begin.xRot = 0.2182F + Mth.cos(ageInTicks * tailSpeed) * swingAmount;
        this.tail.xRot = 0.1309F + Mth.sin(ageInTicks * tailSpeed) * swingAmount;
        this.tail_end.xRot = 0.1745F + Mth.cos(ageInTicks * tailSpeed) * swingAmount;

        this.tail_begin.yRot = Mth.sin(ageInTicks * tailSpeed) * swingAmount;
        this.tail.yRot = Mth.cos(ageInTicks * tailSpeed) * swingAmount;
        this.tail_end.yRot = Mth.sin(ageInTicks * tailSpeed) * swingAmount;

        this.head.xRot = (headPitch * 0.017453292F) / 5 + 1.0472F;
        this.neck_begin.xRot = (headPitch * 0.017453292F) / 5 - 0.1309F;
        this.neck_begin_inside.xRot = (headPitch * 0.017453292F) / 5 - 0.1745F;
        this.neck_end_inside.xRot = (headPitch * 0.017453292F) / 5 - 0.1745F;
        this.neck_end.xRot = (headPitch * 0.017453292F) / 5 - 0.1309F;

        this.head.yRot = (netHeadYaw * 0.017453292F) / 5;
        this.neck_begin.yRot = (netHeadYaw * 0.017453292F) / 5;
        this.neck_begin_inside.yRot = (netHeadYaw * 0.017453292F) / 5;
        this.neck_end_inside.yRot = (netHeadYaw * 0.017453292F) / 5;
        this.neck_end.yRot = (netHeadYaw * 0.017453292F) / 5;

        this.right_back_leg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.left_back_leg.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwingAmount;
        this.right_front_leg.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwingAmount;
        this.left_front_leg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

    }

    @Override
    public void renderToBuffer(PoseStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {


        body.render(matrixStack, buffer, packedLight, packedOverlay);
        right_front_leg.render(matrixStack, buffer, packedLight, packedOverlay);
        right_back_leg.render(matrixStack, buffer, packedLight, packedOverlay);
        left_front_leg.render(matrixStack, buffer, packedLight, packedOverlay);
        left_back_leg.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }
}