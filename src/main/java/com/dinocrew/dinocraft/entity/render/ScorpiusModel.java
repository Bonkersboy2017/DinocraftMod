// Made with Model Converter by Globox_Z
// Generate all required imports
// Made with Blockbench 4.2.2
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports
package com.dinocrew.dinocraft.entity.render;

import com.dinocrew.dinocraft.entity.Scorpius;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.frozenblock.api.math.AnimationAPI;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;

public class ScorpiusModel extends HierarchicalModel<Scorpius> implements AnimationAPI {
    private final ModelPart root;
    private final ModelPart bone;
    private final ModelPart right_leg;
    private final ModelPart right_hip;
    private final ModelPart right_knee;
    private final ModelPart right_foot;
    private final ModelPart cube_r1;
    private final ModelPart right_toe;
    private final ModelPart main;
    private final ModelPart tail1;
    private final ModelPart tail2;
    private final ModelPart tail3;
    private final ModelPart tail4;
    private final ModelPart tail5;
    private final ModelPart tail6;
    private final ModelPart neck;
    private final ModelPart head;
    private final ModelPart right_arm;
    private final ModelPart right_elbow;
    private final ModelPart right_hand;
    private final ModelPart left_arm;
    private final ModelPart left_elbow;
    private final ModelPart left_hand;
    private final ModelPart left_leg;
    private final ModelPart left_hip;
    private final ModelPart left_knee;
    private final ModelPart left_foot;
    private final ModelPart cube_r2;
    private final ModelPart left_toe;

    public ScorpiusModel(ModelPart root) {
        super(RenderType::entityCutoutNoCull);
        this.root = root;
        this.bone = this.root.getChild("bone");
        this.left_leg = this.bone.getChild("left_leg");
        this.left_hip = this.left_leg.getChild("left_hip");
        this.left_knee = this.left_hip.getChild("left_knee");
        this.left_foot = this.left_knee.getChild("left_foot");
        this.left_toe = this.left_foot.getChild("left_toe");
        this.cube_r2 = this.left_foot.getChild("cube_r2");
        this.main = this.bone.getChild("main");
        this.left_arm = this.main.getChild("left_arm");
        this.left_elbow = this.left_arm.getChild("left_elbow");
        this.left_hand = this.left_elbow.getChild("left_hand");
        this.right_arm = this.main.getChild("right_arm");
        this.right_elbow = this.right_arm.getChild("right_elbow");
        this.right_hand = this.right_elbow.getChild("right_hand");
        this.neck = this.main.getChild("neck");
        this.head = this.neck.getChild("head");
        this.tail1 = this.main.getChild("tail1");
        this.tail2 = this.tail1.getChild("tail2");
        this.tail3 = this.tail2.getChild("tail3");
        this.tail4 = this.tail3.getChild("tail4");
        this.tail5 = this.tail4.getChild("tail5");
        this.tail6 = this.tail5.getChild("tail6");
        this.right_leg = this.bone.getChild("right_leg");
        this.right_hip = this.right_leg.getChild("right_hip");
        this.right_knee = this.right_hip.getChild("right_knee");
        this.right_foot = this.right_knee.getChild("right_foot");
        this.right_toe = this.right_foot.getChild("right_toe");
        this.cube_r1 = this.right_foot.getChild("cube_r1");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition modelData = new MeshDefinition();
        PartDefinition modelPartData = modelData.getRoot();

        PartDefinition modelPartData1 = modelPartData.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
        PartDefinition modelPartData2 = modelPartData1.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(144, 62).addBox(-13.0F, -3.7937F, -5.4462F, 9.0F, 21.0F, 11.0F), PartPose.offset(16.0F, -35.0F, -9.0F));
        PartDefinition modelPartData3 = modelPartData2.addOrReplaceChild("right_hip", CubeListBuilder.create().texOffs(104, 43).addBox(-2.0F, -5.2625F, -20.8407F, 6.0F, 10.0F, 19.0F, new CubeDeformation(0.01F)), PartPose.offset(-9.0F, 11.0F, -2.0F));
        PartDefinition modelPartData4 = modelPartData3.addOrReplaceChild("right_knee", CubeListBuilder.create().texOffs(76, 62).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 20.0F, 6.0F).texOffs(65, 198).addBox(0.0F, -8.0F, -5.0F, 0.0F, 9.0F, 2.0F), PartPose.offset(1.0F, 4.7375F, -17.8407F));
        PartDefinition modelPartData5 = modelPartData4.addOrReplaceChild("right_foot", CubeListBuilder.create().texOffs(129, 162).addBox(-4.0F, 0.0F, -3.0F, 8.0F, 4.0F, 13.0F, true).texOffs(63, 85).addBox(0.0F, 1.0F, 9.0F, 4.0F, 3.0F, 5.0F).texOffs(111, 115).addBox(1.0F, 1.0F, 14.0F, 0.0F, 3.0F, 4.0F).texOffs(111, 115).addBox(3.0F, 1.0F, 14.0F, 0.0F, 3.0F, 4.0F), PartPose.offset(0.0F, 14.0F, 1.0F));
        modelPartData5.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(97, 0).addBox(-13.0F, -7.0F, -8.0F, 0.0F, 7.0F, 10.0F), PartPose.offset(13.0F, 4.0F, 5.0F));
        modelPartData5.addOrReplaceChild("right_toe", CubeListBuilder.create().texOffs(28, 86).addBox(-0.2095F, -5.549F, -0.1822F, 4.0F, 7.0F, 4.0F).texOffs(104, 30).addBox(1.7905F, -10.549F, -0.1822F, 0.0F, 6.0F, 6.0F), PartPose.offset(-4.0F, 0.0F, 8.0F));
        PartDefinition modelPartData6 = modelPartData1.addOrReplaceChild("main", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -8.0F, -9.0F, 12.0F, 17.0F, 27.0F), PartPose.offset(0.0F, -35.0F, 0.0F));
        PartDefinition modelPartData7 = modelPartData6.addOrReplaceChild("tail1", CubeListBuilder.create().texOffs(0, 45).addBox(-7.0F, -10.0F, -23.0F, 14.0F, 17.0F, 23.0F), PartPose.offset(0.0F, 2.0F, -8.0F));
        PartDefinition modelPartData8 = modelPartData7.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(63, 29).addBox(-7.0F, -10.0F, -16.0F, 12.0F, 16.0F, 16.0F), PartPose.offset(1.0F, 0.0F, -22.0F));
        PartDefinition modelPartData9 = modelPartData8.addOrReplaceChild("tail3", CubeListBuilder.create().texOffs(52, 0).addBox(-5.0F, -4.0F, -12.0F, 10.0F, 14.0F, 12.0F), PartPose.offset(-1.0F, -6.0F, -15.0F));
        PartDefinition modelPartData10 = modelPartData9.addOrReplaceChild("tail4", CubeListBuilder.create().texOffs(99, 144).addBox(-5.0F, -5.0F, -11.0F, 10.0F, 11.0F, 11.0F), PartPose.offset(0.0F, 1.0F, -11.0F));
        PartDefinition modelPartData11 = modelPartData10.addOrReplaceChild("tail5", CubeListBuilder.create().texOffs(96, 174).addBox(-4.0F, -5.0F, -10.0F, 8.0F, 8.0F, 11.0F), PartPose.offset(0.0F, 0.0F, -11.0F));
        modelPartData11.addOrReplaceChild("tail6", CubeListBuilder.create().texOffs(0, 175).addBox(-3.0F, -3.0F, -12.0F, 6.0F, 5.0F, 12.0F), PartPose.offset(0.0F, -2.0F, -9.0F));
        PartDefinition modelPartData12 = modelPartData6.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(55, 101).addBox(-5.0F, -3.7882F, -1.0268F, 10.0F, 13.0F, 17.0F), PartPose.offset(0.0F, -2.0F, 17.0F));
        modelPartData12.addOrReplaceChild("head", CubeListBuilder.create().texOffs(136, 37).addBox(-5.0F, -5.0F, 8.0F, 10.0F, 10.0F, 13.0F, new CubeDeformation(0.01F)).texOffs(135, 107).addBox(-6.0F, -6.0F, -2.0F, 12.0F, 13.0F, 10.0F).texOffs(0, 119).addBox(-4.0F, 5.0F, 2.0F, 8.0F, 4.0F, 18.0F, new CubeDeformation(-0.01F)), PartPose.offset(0.0F, 1.0F, 14.0F));
        PartDefinition modelPartData13 = modelPartData6.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(27, 161).addBox(3.0F, -4.0F, -1.0F, 7.0F, 7.0F, 14.0F), PartPose.offset(0.0F, 1.0F, 11.0F));
        PartDefinition modelPartData14 = modelPartData13.addOrReplaceChild("right_elbow", CubeListBuilder.create().texOffs(176, 137).addBox(-2.0F, -3.0F, 0.0F, 4.0F, 4.0F, 10.0F), PartPose.offset(7.0F, 1.0F, 13.0F));
        modelPartData14.addOrReplaceChild("right_hand", CubeListBuilder.create().texOffs(47, 95).addBox(-3.0F, -2.0F, -1.0F, 6.0F, 3.0F, 4.0F).texOffs(46, 102).addBox(-3.0F, -1.0F, 3.0F, 6.0F, 2.0F, 5.0F).texOffs(111, 107).addBox(-2.0F, -2.0F, 8.0F, 0.0F, 3.0F, 4.0F).texOffs(111, 107).addBox(0.0F, -2.0F, 8.0F, 0.0F, 3.0F, 4.0F).texOffs(111, 107).addBox(2.0F, -2.0F, 8.0F, 0.0F, 3.0F, 4.0F), PartPose.offset(0.0F, 0.0F, 10.0F));
        PartDefinition modelPartData15 = modelPartData6.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(27, 161).addBox(3.0F, -4.0F, -1.0F, 7.0F, 7.0F, 14.0F), PartPose.offset(-13.0F, 1.0F, 12.0F));
        PartDefinition modelPartData16 = modelPartData15.addOrReplaceChild("left_elbow", CubeListBuilder.create().texOffs(176, 137).addBox(-2.0F, -3.0F, 0.0F, 4.0F, 4.0F, 10.0F), PartPose.offset(7.0F, 1.0F, 13.0F));
        modelPartData16.addOrReplaceChild("left_hand", CubeListBuilder.create().texOffs(47, 95).addBox(-3.0F, -2.0F, -1.0F, 6.0F, 3.0F, 4.0F).texOffs(46, 102).addBox(-3.0F, -1.0F, 3.0F, 6.0F, 2.0F, 5.0F).texOffs(111, 107).addBox(-2.0F, -2.0F, 8.0F, 0.0F, 3.0F, 4.0F).texOffs(111, 107).addBox(0.0F, -2.0F, 8.0F, 0.0F, 3.0F, 4.0F).texOffs(111, 107).addBox(2.0F, -2.0F, 8.0F, 0.0F, 3.0F, 4.0F), PartPose.offset(0.0F, 0.0F, 10.0F));
        PartDefinition modelPartData17 = modelPartData1.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(144, 62).addBox(-13.0F, -3.7937F, -5.4462F, 9.0F, 21.0F, 11.0F), PartPose.offset(0.0F, -35.0F, -9.0F));
        PartDefinition modelPartData18 = modelPartData17.addOrReplaceChild("left_hip", CubeListBuilder.create().texOffs(104, 43).addBox(-2.0F, -5.2625F, -20.8407F, 6.0F, 10.0F, 19.0F, new CubeDeformation(0.01F)), PartPose.offset(-9.0F, 11.0F, -2.0F));
        PartDefinition modelPartData19 = modelPartData18.addOrReplaceChild("left_knee", CubeListBuilder.create().texOffs(76, 62).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 20.0F, 6.0F).texOffs(65, 198).addBox(0.0F, -8.0F, -5.0F, 0.0F, 9.0F, 2.0F), PartPose.offset(1.0F, 4.7375F, -17.8407F));
        PartDefinition modelPartData20 = modelPartData19.addOrReplaceChild("left_foot", CubeListBuilder.create().texOffs(129, 162).addBox(-4.0F, 0.0F, -3.0F, 8.0F, 4.0F, 13.0F, true).texOffs(63, 85).addBox(-4.0F, 1.0F, 9.0F, 4.0F, 3.0F, 5.0F).texOffs(111, 115).addBox(-3.0F, 1.0F, 14.0F, 0.0F, 3.0F, 4.0F).texOffs(111, 115).addBox(-1.0F, 1.0F, 14.0F, 0.0F, 3.0F, 4.0F), PartPose.offset(0.0F, 14.0F, 1.0F));
        modelPartData20.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(97, 0).addBox(-13.0F, -7.0F, -8.0F, 0.0F, 7.0F, 10.0F), PartPose.offset(13.0F, 4.0F, 5.0F));
        modelPartData20.addOrReplaceChild("left_toe", CubeListBuilder.create().texOffs(28, 86).addBox(-0.2095F, -5.549F, -0.1822F, 4.0F, 7.0F, 4.0F).texOffs(104, 30).addBox(1.7905F, -10.549F, -0.1822F, 0.0F, 6.0F, 6.0F), PartPose.offset(0.0F, 0.0F, 8.0F));
        return LayerDefinition.create(modelData, 256, 256);
    }

    @Override
    public void setupAnim(Scorpius entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        // Base angles
        this.bone.yRot = 3.1416F;
        /* BODY */
        this.main.xRot = 0.3927F;
        this.tail1.xRot = -0.0873F;
        this.tail2.xRot = -0.1309F;
        this.tail3.xRot = -0.1309F;
        this.tail4.xRot = -0.1309F;
        this.tail5.xRot = 0.0436F;
        this.tail6.xRot = 0.0873F;
        /* HEAD */
        this.neck.xRot = 0.3491F;
        this.head.xRot = -0.7418F;

        /* ARMS */
        this.right_arm.xRot = -1.7017F;
        this.right_elbow.xRot = 0.5672F;
        this.right_hand.xRot = -0.5236F;
        this.left_arm.xRot = -1.7017F;
        this.left_elbow.xRot = 0.5672F;
        this.left_hand.xRot = -0.5236F;

        // animated Angles

        this.tail1.yRot = (float) Math.cos((ageInTicks) / 5) / 5;
        this.tail2.yRot = (float) Math.cos((ageInTicks + 1) / 5) / 5;
        this.tail3.yRot = (float) Math.cos((ageInTicks + 2) / 5) / 5;
        this.tail4.yRot = (float) Math.cos((ageInTicks + 3) / 5) / 5;
        this.tail5.yRot = (float) Math.cos((ageInTicks + 4) / 5) / 5;
        this.tail6.yRot = (float) Math.cos((ageInTicks + 5) / 5) / 5;

        this.right_leg.xRot = legAnimation(0.9599F, 0.25f, 1, limbSwing, limbSwingAmount);
        this.right_hip.xRot = legAnimation(-0.48F, 0.25f, 1, limbSwing, limbSwingAmount, true);
        this.right_knee.xRot = legAnimation(0.2182F, 0.25f, 1, limbSwing, limbSwingAmount);
        this.right_foot.xRot = legAnimation(-0.6981F, 0.25f, 1, limbSwing, limbSwingAmount);
        this.right_toe.xRot = -0.829F;
        this.left_leg.xRot = legAnimation(0.9599F, 0.25f, 1, limbSwing, limbSwingAmount, true);
        this.left_hip.xRot = legAnimation(-0.48F, 0.25f, 1, limbSwing, limbSwingAmount);
        this.left_knee.xRot = legAnimation(0.2182F, 0.25f, 1, limbSwing, limbSwingAmount, true);
        this.left_foot.xRot = legAnimation(-0.6981F, 0.25f, 1, limbSwing, limbSwingAmount, true);
        this.left_toe.xRot = -0.829F;
		/*
		this.right_leg.pitch = -(float)Math.cos(ageInTicks/5);
		this.right_hip.pitch = (float)Math.cos(ageInTicks/5);
		this.right_knee.pitch = -(float)Math.cos(ageInTicks/5);
		this.right_foot.pitch = (float)Math.cos(ageInTicks/5);
		*/

    }


    @Override
    public void renderToBuffer(PoseStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        bone.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }
}