// Made with Model Converter by Globox_Z
// Generate all required imports
// Made with Blockbench 4.2.2
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports
package com.dinocrew.dinocraft.registry.entities;

import net.frozenblock.api.mathematics.AnimationAPI;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class ScorpiusEntityModel extends EntityModel<ScorpiusEntity> implements AnimationAPI {
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

    public ScorpiusEntityModel(ModelPart root) {
        this.bone = root.getChild("bone");
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

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();

        ModelPartData modelPartData1 = modelPartData.addChild("bone", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
        ModelPartData modelPartData2 = modelPartData1.addChild("right_leg", ModelPartBuilder.create().uv(144, 62).cuboid(-13.0F, -3.7937F, -5.4462F, 9.0F, 21.0F, 11.0F), ModelTransform.pivot(16.0F, -35.0F, -9.0F));
        ModelPartData modelPartData3 = modelPartData2.addChild("right_hip", ModelPartBuilder.create().uv(104, 43).cuboid(-2.0F, -5.2625F, -20.8407F, 6.0F, 10.0F, 19.0F, new Dilation(0.01F)), ModelTransform.pivot(-9.0F, 11.0F, -2.0F));
        ModelPartData modelPartData4 = modelPartData3.addChild("right_knee", ModelPartBuilder.create().uv(76, 62).cuboid(-3.0F, -3.0F, -3.0F, 6.0F, 20.0F, 6.0F).uv(65, 198).cuboid(0.0F, -8.0F, -5.0F, 0.0F, 9.0F, 2.0F), ModelTransform.pivot(1.0F, 4.7375F, -17.8407F));
        ModelPartData modelPartData5 = modelPartData4.addChild("right_foot", ModelPartBuilder.create().uv(129, 162).cuboid(-4.0F, 0.0F, -3.0F, 8.0F, 4.0F, 13.0F, true).uv(63, 85).cuboid(0.0F, 1.0F, 9.0F, 4.0F, 3.0F, 5.0F).uv(111, 115).cuboid(1.0F, 1.0F, 14.0F, 0.0F, 3.0F, 4.0F).uv(111, 115).cuboid(3.0F, 1.0F, 14.0F, 0.0F, 3.0F, 4.0F), ModelTransform.pivot(0.0F, 14.0F, 1.0F));
        modelPartData5.addChild("cube_r1", ModelPartBuilder.create().uv(97, 0).cuboid(-13.0F, -7.0F, -8.0F, 0.0F, 7.0F, 10.0F), ModelTransform.pivot(13.0F, 4.0F, 5.0F));
        modelPartData5.addChild("right_toe", ModelPartBuilder.create().uv(28, 86).cuboid(-0.2095F, -5.549F, -0.1822F, 4.0F, 7.0F, 4.0F).uv(104, 30).cuboid(1.7905F, -10.549F, -0.1822F, 0.0F, 6.0F, 6.0F), ModelTransform.pivot(-4.0F, 0.0F, 8.0F));
        ModelPartData modelPartData6 = modelPartData1.addChild("main", ModelPartBuilder.create().uv(0, 0).cuboid(-6.0F, -8.0F, -9.0F, 12.0F, 17.0F, 27.0F), ModelTransform.pivot(0.0F, -35.0F, 0.0F));
        ModelPartData modelPartData7 = modelPartData6.addChild("tail1", ModelPartBuilder.create().uv(0, 45).cuboid(-7.0F, -10.0F, -23.0F, 14.0F, 17.0F, 23.0F), ModelTransform.pivot(0.0F, 2.0F, -8.0F));
        ModelPartData modelPartData8 = modelPartData7.addChild("tail2", ModelPartBuilder.create().uv(63, 29).cuboid(-7.0F, -10.0F, -16.0F, 12.0F, 16.0F, 16.0F), ModelTransform.pivot(1.0F, 0.0F, -22.0F));
        ModelPartData modelPartData9 = modelPartData8.addChild("tail3", ModelPartBuilder.create().uv(52, 0).cuboid(-5.0F, -4.0F, -12.0F, 10.0F, 14.0F, 12.0F), ModelTransform.pivot(-1.0F, -6.0F, -15.0F));
        ModelPartData modelPartData10 = modelPartData9.addChild("tail4", ModelPartBuilder.create().uv(99, 144).cuboid(-5.0F, -5.0F, -11.0F, 10.0F, 11.0F, 11.0F), ModelTransform.pivot(0.0F, 1.0F, -11.0F));
        ModelPartData modelPartData11 = modelPartData10.addChild("tail5", ModelPartBuilder.create().uv(96, 174).cuboid(-4.0F, -5.0F, -10.0F, 8.0F, 8.0F, 11.0F), ModelTransform.pivot(0.0F, 0.0F, -11.0F));
        modelPartData11.addChild("tail6", ModelPartBuilder.create().uv(0, 175).cuboid(-3.0F, -3.0F, -12.0F, 6.0F, 5.0F, 12.0F), ModelTransform.pivot(0.0F, -2.0F, -9.0F));
        ModelPartData modelPartData12 = modelPartData6.addChild("neck", ModelPartBuilder.create().uv(55, 101).cuboid(-5.0F, -3.7882F, -1.0268F, 10.0F, 13.0F, 17.0F), ModelTransform.pivot(0.0F, -2.0F, 17.0F));
        modelPartData12.addChild("head", ModelPartBuilder.create().uv(136, 37).cuboid(-5.0F, -5.0F, 8.0F, 10.0F, 10.0F, 13.0F, new Dilation(0.01F)).uv(135, 107).cuboid(-6.0F, -6.0F, -2.0F, 12.0F, 13.0F, 10.0F).uv(0, 119).cuboid(-4.0F, 5.0F, 2.0F, 8.0F, 4.0F, 18.0F, new Dilation(-0.01F)), ModelTransform.pivot(0.0F, 1.0F, 14.0F));
        ModelPartData modelPartData13 = modelPartData6.addChild("right_arm", ModelPartBuilder.create().uv(27, 161).cuboid(3.0F, -4.0F, -1.0F, 7.0F, 7.0F, 14.0F), ModelTransform.pivot(0.0F, 1.0F, 11.0F));
        ModelPartData modelPartData14 = modelPartData13.addChild("right_elbow", ModelPartBuilder.create().uv(176, 137).cuboid(-2.0F, -3.0F, 0.0F, 4.0F, 4.0F, 10.0F), ModelTransform.pivot(7.0F, 1.0F, 13.0F));
        modelPartData14.addChild("right_hand", ModelPartBuilder.create().uv(47, 95).cuboid(-3.0F, -2.0F, -1.0F, 6.0F, 3.0F, 4.0F).uv(46, 102).cuboid(-3.0F, -1.0F, 3.0F, 6.0F, 2.0F, 5.0F).uv(111, 107).cuboid(-2.0F, -2.0F, 8.0F, 0.0F, 3.0F, 4.0F).uv(111, 107).cuboid(0.0F, -2.0F, 8.0F, 0.0F, 3.0F, 4.0F).uv(111, 107).cuboid(2.0F, -2.0F, 8.0F, 0.0F, 3.0F, 4.0F), ModelTransform.pivot(0.0F, 0.0F, 10.0F));
        ModelPartData modelPartData15 = modelPartData6.addChild("left_arm", ModelPartBuilder.create().uv(27, 161).cuboid(3.0F, -4.0F, -1.0F, 7.0F, 7.0F, 14.0F), ModelTransform.pivot(-13.0F, 1.0F, 12.0F));
        ModelPartData modelPartData16 = modelPartData15.addChild("left_elbow", ModelPartBuilder.create().uv(176, 137).cuboid(-2.0F, -3.0F, 0.0F, 4.0F, 4.0F, 10.0F), ModelTransform.pivot(7.0F, 1.0F, 13.0F));
        modelPartData16.addChild("left_hand", ModelPartBuilder.create().uv(47, 95).cuboid(-3.0F, -2.0F, -1.0F, 6.0F, 3.0F, 4.0F).uv(46, 102).cuboid(-3.0F, -1.0F, 3.0F, 6.0F, 2.0F, 5.0F).uv(111, 107).cuboid(-2.0F, -2.0F, 8.0F, 0.0F, 3.0F, 4.0F).uv(111, 107).cuboid(0.0F, -2.0F, 8.0F, 0.0F, 3.0F, 4.0F).uv(111, 107).cuboid(2.0F, -2.0F, 8.0F, 0.0F, 3.0F, 4.0F), ModelTransform.pivot(0.0F, 0.0F, 10.0F));
        ModelPartData modelPartData17 = modelPartData1.addChild("left_leg", ModelPartBuilder.create().uv(144, 62).cuboid(-13.0F, -3.7937F, -5.4462F, 9.0F, 21.0F, 11.0F), ModelTransform.pivot(0.0F, -35.0F, -9.0F));
        ModelPartData modelPartData18 = modelPartData17.addChild("left_hip", ModelPartBuilder.create().uv(104, 43).cuboid(-2.0F, -5.2625F, -20.8407F, 6.0F, 10.0F, 19.0F, new Dilation(0.01F)), ModelTransform.pivot(-9.0F, 11.0F, -2.0F));
        ModelPartData modelPartData19 = modelPartData18.addChild("left_knee", ModelPartBuilder.create().uv(76, 62).cuboid(-3.0F, -3.0F, -3.0F, 6.0F, 20.0F, 6.0F).uv(65, 198).cuboid(0.0F, -8.0F, -5.0F, 0.0F, 9.0F, 2.0F), ModelTransform.pivot(1.0F, 4.7375F, -17.8407F));
        ModelPartData modelPartData20 = modelPartData19.addChild("left_foot", ModelPartBuilder.create().uv(129, 162).cuboid(-4.0F, 0.0F, -3.0F, 8.0F, 4.0F, 13.0F, true).uv(63, 85).cuboid(-4.0F, 1.0F, 9.0F, 4.0F, 3.0F, 5.0F).uv(111, 115).cuboid(-3.0F, 1.0F, 14.0F, 0.0F, 3.0F, 4.0F).uv(111, 115).cuboid(-1.0F, 1.0F, 14.0F, 0.0F, 3.0F, 4.0F), ModelTransform.pivot(0.0F, 14.0F, 1.0F));
        modelPartData20.addChild("cube_r2", ModelPartBuilder.create().uv(97, 0).cuboid(-13.0F, -7.0F, -8.0F, 0.0F, 7.0F, 10.0F), ModelTransform.pivot(13.0F, 4.0F, 5.0F));
        modelPartData20.addChild("left_toe", ModelPartBuilder.create().uv(28, 86).cuboid(-0.2095F, -5.549F, -0.1822F, 4.0F, 7.0F, 4.0F).uv(104, 30).cuboid(1.7905F, -10.549F, -0.1822F, 0.0F, 6.0F, 6.0F), ModelTransform.pivot(0.0F, 0.0F, 8.0F));
        return TexturedModelData.of(modelData, 256, 256);
    }

    @Override
    public void setAngles(ScorpiusEntity entity, float limbAngle, float limbDistance, float time, float netHeadYaw, float headPitch) {
        // Base angles
        this.bone.yaw = 3.1416F;
        /* BODY */
        this.main.pitch = 0.3927F;
        this.tail1.pitch = -0.0873F;
        this.tail2.pitch = -0.1309F;
        this.tail3.pitch = -0.1309F;
        this.tail4.pitch = -0.1309F;
        this.tail5.pitch = 0.0436F;
        this.tail6.pitch = 0.0873F;
        /* HEAD */
        this.neck.pitch = 0.3491F;
        this.head.pitch = -0.7418F;

        /* ARMS */
        this.right_arm.pitch = -1.7017F;
        this.right_elbow.pitch = 0.5672F;
        this.right_hand.pitch = -0.5236F;
        this.left_arm.pitch = -1.7017F;
        this.left_elbow.pitch = 0.5672F;
        this.left_hand.pitch = -0.5236F;
        animate(entity, limbAngle, limbDistance, time, netHeadYaw, headPitch);

    }

    private void animate(ScorpiusEntity entity, float limbAngle, float limbDistance, float time, float netHeadYaw, float headPitch) {
        // animated Angles

        this.tail1.yaw = (float) Math.cos((time) / 5) / 5;
        this.tail2.yaw = (float) Math.cos((time + 1) / 5) / 5;
        this.tail3.yaw = (float) Math.cos((time + 2) / 5) / 5;
        this.tail4.yaw = (float) Math.cos((time + 3) / 5) / 5;
        this.tail5.yaw = (float) Math.cos((time + 4) / 5) / 5;
        this.tail6.yaw = (float) Math.cos((time + 5) / 5) / 5;

        this.right_leg.pitch = legAnimation(0.9599F, 0.25f, 1, limbAngle, limbDistance);
        this.right_hip.pitch = legAnimation(-0.48F, 0.25f, 1, limbAngle, limbDistance, true);
        this.right_knee.pitch = legAnimation(0.2182F, 0.25f, 1, limbAngle, limbDistance);
        this.right_foot.pitch = legAnimation(-0.6981F, 0.25f, 1, limbAngle, limbDistance);
        this.right_toe.pitch = -0.829F;
        this.left_leg.pitch = legAnimation(0.9599F, 0.25f, 1, limbAngle, limbDistance, true);
        this.left_hip.pitch = legAnimation(-0.48F, 0.25f, 1, limbAngle, limbDistance);
        this.left_knee.pitch = legAnimation(0.2182F, 0.25f, 1, limbAngle, limbDistance, true);
        this.left_foot.pitch = legAnimation(-0.6981F, 0.25f, 1, limbAngle, limbDistance, true);
        this.left_toe.pitch = -0.829F;
		/*
		this.right_leg.pitch = -(float)Math.cos(time/5);
		this.right_hip.pitch = (float)Math.cos(time/5);
		this.right_knee.pitch = -(float)Math.cos(time/5);
		this.right_foot.pitch = (float)Math.cos(time/5);
		*/

    }

    @Override
    public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {

        bone.render(matrixStack, buffer, packedLight, packedOverlay);
    }
}