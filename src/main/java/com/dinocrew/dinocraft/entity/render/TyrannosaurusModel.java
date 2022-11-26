package com.dinocrew.dinocraft.entity.render;

import com.dinocrew.dinocraft.entity.Tyrannosaurus;
import com.dinocrew.dinocraft.entity.render.animation.TyrannosaurusAnimation;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.frozenblock.api.math.AnimationAPI;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.util.Mth;

// Made with Model Converter by Globox_Z
// Generate all required imports
// Made with Blockbench 4.0.5
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports

public class TyrannosaurusModel extends HierarchicalModel<Tyrannosaurus> implements AnimationAPI {
    private final ModelPart root;
    private final ModelPart right_leg;
    private final ModelPart right_knee;
    private final ModelPart right_thigh;
    private final ModelPart right_foot;
    private final ModelPart left_leg;
    private final ModelPart left_knee;
    private final ModelPart left_thigh;
    private final ModelPart left_foot;
    private final ModelPart body;
    private final ModelPart tail;
    private final ModelPart tail2;
    private final ModelPart tail3;
    private final ModelPart tail4;
    private final ModelPart neck;
    private final ModelPart neck2;
    private final ModelPart neck3;
    private final ModelPart head;
    private final ModelPart jaw;
    private final ModelPart right_arm;
    private final ModelPart left_arm;

    public TyrannosaurusModel(ModelPart root) {
        super(RenderType::entityCutoutNoCull);
        this.root = root;
        this.body = this.root.getChild("body");
        this.right_leg = this.root.getChild("right_leg");
        this.right_knee = this.right_leg.getChild("right_knee");
        this.right_thigh = this.right_knee.getChild("right_thigh");
        this.right_foot = this.right_thigh.getChild("right_foot");
        this.left_leg = this.root.getChild("left_leg");
        this.left_knee = this.left_leg.getChild("left_knee");
        this.left_thigh = this.left_knee.getChild("left_thigh");
        this.left_foot = this.left_thigh.getChild("left_foot");
        this.neck = this.body.getChild("neck");
        this.neck2 = this.neck.getChild("neck2");
        this.left_arm = this.neck2.getChild("left_arm");
        this.right_arm = this.neck2.getChild("right_arm");
        this.neck3 = this.neck2.getChild("neck3");
        this.head = this.neck3.getChild("head");
        this.jaw = this.head.getChild("jaw");
        this.tail = this.body.getChild("tail");
        this.tail2 = this.tail.getChild("tail2");
        this.tail3 = this.tail2.getChild("tail3");
        this.tail4 = this.tail3.getChild("tail4");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition modelData = new MeshDefinition();
        PartDefinition modelPartData = modelData.getRoot();
        PartDefinition modelPartData1 = modelPartData.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 85).addBox(-16.0F, -6.0F, -9.0F, 10.0F, 25.0F, 19.0F), PartPose.offset(0.0F, -6.0F, 8.0F));
        PartDefinition modelPartData2 = modelPartData1.addOrReplaceChild("right_knee", CubeListBuilder.create().texOffs(79, 142).addBox(-15.01F, -3.0F, -3.0F, 9.0F, 16.0F, 9.0F), PartPose.offset(0.0F, 13.0F, 6.0F));
        PartDefinition modelPartData3 = modelPartData2.addOrReplaceChild("right_thigh", CubeListBuilder.create().texOffs(144, 35).addBox(-6.0F, -1.0F, -2.0F, 8.0F, 14.0F, 6.0F), PartPose.offsetAndRotation(-8.0F, 7.0F, 2.0F, -1.3963F, 0F, 0F));
        modelPartData3.addOrReplaceChild("right_foot", CubeListBuilder.create().texOffs(39, 91).addBox(-6.0F, -1.0F, -6.0F, 8.0F, 3.0F, 10.0F, new CubeDeformation(-0.01F)).texOffs(0, 43).addBox(-5.0F, -3.0F, -12.0F, 0.0F, 5.0F, 11.0F).texOffs(0, 38).addBox(-2.0F, -3.0F, -12.0F, 0.0F, 5.0F, 11.0F).texOffs(0, 33).addBox(1.0F, -3.0F, -12.0F, 0.0F, 5.0F, 11.0F), PartPose.offsetAndRotation(0.0F, 14.0F, 0.0F, 0.5672F, 0F, 0F));
        PartDefinition modelPartData4 = modelPartData.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 85).addBox(-16.0F, -6.0F, -9.0F, 10.0F, 25.0F, 19.0F), PartPose.offset(22.0F, -6.0F, 8.0F));
        PartDefinition modelPartData5 = modelPartData4.addOrReplaceChild("left_knee", CubeListBuilder.create().texOffs(79, 142).addBox(-14.986F, -3.0F, -3.0F, 9.0F, 16.0F, 9.0F), PartPose.offset(-1.0F, 13.0F, 6.0F));
        PartDefinition modelPartData6 = modelPartData5.addOrReplaceChild("left_thigh", CubeListBuilder.create().texOffs(144, 35).addBox(-5.0F, -1.0F, -2.0F, 8.0F, 14.0F, 6.0F), PartPose.offsetAndRotation(-9.0F, 7.0F, 2.0F, -1.3963F, 0F, 0F));
        modelPartData6.addOrReplaceChild("left_foot", CubeListBuilder.create().texOffs(39, 91).addBox(-5.0F, -1.0F, -6.0F, 8.0F, 3.0F, 10.0F, new CubeDeformation(-0.01F)).texOffs(0, 33).addBox(-4.0F, -3.0F, -12.0F, 0.0F, 5.0F, 11.0F).texOffs(0, 38).addBox(-1.0F, -3.0F, -12.0F, 0.0F, 5.0F, 11.0F).texOffs(0, 43).addBox(2.0F, -3.0F, -12.0F, 0.0F, 5.0F, 11.0F), PartPose.offsetAndRotation(0.0F, 14.0F, 0.0F, 0.5672F, 0F, 0F));
        PartDefinition modelPartData7 = modelPartData.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-11.0F, -7.0F, -13.0F, 22.0F, 19.0F, 25.0F).texOffs(0, 107).addBox(-4.0F, -16.0F, -10.0F, 0.0F, 9.0F, 22.0F).texOffs(0, 107).addBox(4.0F, -16.0F, -10.0F, 0.0F, 9.0F, 22.0F).texOffs(0, 135).addBox(0.0F, -16.0F, -10.0F, 0.0F, 9.0F, 22.0F), PartPose.offset(0.0F, -8.0F, 8.0F));
        PartDefinition modelPartData8 = modelPartData7.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 44).addBox(-9.0F, -6.0F, -1.0F, 18.0F, 16.0F, 25.0F).texOffs(103, 76).addBox(0.0F, -12.0F, 0.0F, 0.0F, 8.0F, 25.0F), PartPose.offset(0.0F, -1.0F, 13.0F));
        PartDefinition modelPartData9 = modelPartData8.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(106, 115).addBox(-7.0F, -4.0F, -2.0F, 14.0F, 12.0F, 18.0F).texOffs(0, 120).addBox(0.0F, -11.0F, -1.0F, 0.0F, 7.0F, 18.0F), PartPose.offset(0.0F, 0.0F, 26.0F));
        PartDefinition modelPartData10 = modelPartData9.addOrReplaceChild("tail3", CubeListBuilder.create().texOffs(29, 133).addBox(-5.0F, -4.0F, -1.0F, 10.0F, 9.0F, 15.0F).texOffs(122, 13).addBox(0.0F, -11.0F, 0.0F, 0.0F, 7.0F, 15.0F), PartPose.offset(0.0F, 0.0F, 17.0F));
        modelPartData10.addOrReplaceChild("tail4", CubeListBuilder.create().texOffs(69, 0).addBox(-3.0F, -4.0F, -2.0F, 6.0F, 6.0F, 13.0F), PartPose.offset(0.0F, 0.0F, 16.0F));
        PartDefinition modelPartData11 = modelPartData7.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(65, 64).addBox(-8.0F, -7.0F, -13.0F, 16.0F, 16.0F, 21.0F).texOffs(64, 112).addBox(0.0F, -16.0F, -13.0F, 0.0F, 9.0F, 21.0F), PartPose.offset(0.0F, 0.0F, -12.0F));
        PartDefinition modelPartData12 = modelPartData11.addOrReplaceChild("neck2", CubeListBuilder.create().texOffs(72, 22).addBox(-7.0F, -9.0F, -17.0F, 14.0F, 15.0F, 22.0F), PartPose.offsetAndRotation(0.0F, 3.0F, -13.0F, -0.1745F, 0F, 0F));
        PartDefinition modelPartData13 = modelPartData12.addOrReplaceChild("neck3", CubeListBuilder.create().texOffs(122, 0).addBox(-6.0F, -7.0F, -15.0F, 12.0F, 12.0F, 16.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 1.0F, -12.0F, -0.8727F, 0F, 0F));
        PartDefinition modelPartData14 = modelPartData13.addOrReplaceChild("head", CubeListBuilder.create().texOffs(61, 37).addBox(0.0F, -16.0F, -15.0F, 0.0F, 5.0F, 22.0F).texOffs(58, 101).addBox(-6.0F, -12.0F, -15.0F, 12.0F, 11.0F, 21.0F).texOffs(94, 146).addBox(-6.0F, -10.0F, -15.0F, 12.0F, 11.0F, 21.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.0F, 7.0F, -10.0F, 0.829F, 0.0F, 0.0F));
        modelPartData14.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(118, 59).addBox(-5.0F, -1.0F, -18.0F, 10.0F, 4.0F, 19.0F), PartPose.offset(0.0F, 0.0F, 4.0F));
        modelPartData12.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(0, 0).addBox(-13.0F, 0.0F, -3.0F, 6.0F, 16.0F, 6.0F).texOffs(94, 0).addBox(-13.0F, 11.0F, -10.0F, 6.0F, 5.0F, 7.0F), PartPose.offset(1.0F, -3.0F, -9.0F));
        modelPartData12.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(0, 0).addBox(7.0F, 0.0F, -3.0F, 6.0F, 16.0F, 6.0F, true).texOffs(94, 0).addBox(7.0F, 11.0F, -10.0F, 6.0F, 5.0F, 7.0F, true), PartPose.offset(0.0F, -3.0F, -9.0F));
        return LayerDefinition.create(modelData, 256, 256);
    }

    @Override
    public void setupAnim(Tyrannosaurus dino, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.animateHeadLookTarget(netHeadYaw, headPitch);
        this.animateWalk(limbSwing, limbSwingAmount, ageInTicks);
        this.animate(dino.attackAnimationState, TyrannosaurusAnimation.ATTACK, ageInTicks);
        this.animate(dino.roarAnimationState, TyrannosaurusAnimation.ROAR, ageInTicks);
        this.animate(dino.sniffAnimationState, TyrannosaurusAnimation.SNIFF, ageInTicks);
    }

    private void animateHeadLookTarget(float pitch, float yaw) {
        this.head.xRot = yaw * ((float) (Math.PI / 180.0));
        this.head.yRot = pitch * (float) (Math.PI / 180.0);
    }

    private void animateWalk(float limbSwing, float limbSwingAmount, float ageInTicks) {
        float amount = 1F; // change this if legs make too much/too less movement
        float speed = 0.85F; // change this if legs are too slow/fast

        float cosAnim = (Mth.cos(limbSwing * 0.6662F * speed) + 1) * 1.4F * limbSwingAmount;
        float sinAnim = (Mth.sin(limbSwing * 0.6662F * speed) + 1) * 1.4F * limbSwingAmount;

        float trueCosAnim = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        float trueSinAnim = Mth.sin(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

        this.tail.yRot = Mth.cos(ageInTicks / 3) / 5;
        this.tail2.yRot = Mth.sin(ageInTicks / 3) / 5;
        this.tail3.yRot = Mth.cos(ageInTicks / 3) / 5;
        this.tail4.yRot = Mth.sin(ageInTicks / 3) / 5;

        this.neck.xRot = 0.2f + Mth.cos(ageInTicks / 5) / 20;

        float cos0to1 = (cosAnim * amount) / 4;
        float sin0to1 = (sinAnim * amount) / 4;

        this.right_leg.xRot = -(cos0to1 + 0.83f);
        this.right_knee.xRot = sin0to1 + 1.6f;
        this.left_leg.xRot = -(sin0to1 + 0.83f);
        this.left_knee.xRot = cos0to1 + 1.6f;
        this.right_arm.xRot = trueCosAnim;
        this.left_arm.xRot = trueSinAnim;
    }

    @Override
    public ModelPart root() {
        return this.root;
    }
}