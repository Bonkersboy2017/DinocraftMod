package com.dinocrew.dinocraft.registry.entities;

import net.frozenblock.api.math.AnimationAPI;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

// Made with Model Converter by Globox_Z
// Generate all required imports
// Made with Blockbench 4.0.5
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports

public class TRexEntityModel extends EntityModel<TRexEntity> implements AnimationAPI {
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
    public TRexEntityModel(ModelPart root) {
        this.right_leg = root.getChild("right_leg");
        this.right_knee = this.right_leg.getChild("right_knee");
        this.right_thigh = this.right_knee.getChild("right_thigh");
        this.right_foot = this.right_thigh.getChild("right_foot");
        this.left_leg = root.getChild("left_leg");
        this.left_knee = this.left_leg.getChild("left_knee");
        this.left_thigh = this.left_knee.getChild("left_thigh");
        this.left_foot = this.left_thigh.getChild("left_foot");
        this.body = root.getChild("body");
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
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData modelPartData1 = modelPartData.addChild("right_leg", ModelPartBuilder.create().uv(0,85).cuboid(-16.0F, -6.0F, -9.0F, 10.0F, 25.0F, 19.0F), ModelTransform.pivot(0.0F,-6.0F,8.0F));
        ModelPartData modelPartData2 = modelPartData1.addChild("right_knee", ModelPartBuilder.create().uv(79,142).cuboid(-15.01F, -3.0F, -3.0F, 9.0F, 16.0F, 9.0F), ModelTransform.pivot(0.0F,13.0F,6.0F));
        ModelPartData modelPartData3 = modelPartData2.addChild("right_thigh", ModelPartBuilder.create().uv(144,35).cuboid(-6.0F, -1.0F, -2.0F, 8.0F, 14.0F, 6.0F), ModelTransform.pivot(-8.0F,7.0F,2.0F));
        modelPartData3.addChild("right_foot", ModelPartBuilder.create().uv(39,91).cuboid(-6.0F, -1.0F, -6.0F, 8.0F, 3.0F, 10.0F, new Dilation(-0.01F)).uv(0,43).cuboid(-5.0F, -3.0F, -12.0F, 0.0F, 5.0F, 11.0F).uv(0,38).cuboid(-2.0F, -3.0F, -12.0F, 0.0F, 5.0F, 11.0F).uv(0,33).cuboid(1.0F, -3.0F, -12.0F, 0.0F, 5.0F, 11.0F), ModelTransform.pivot(0.0F,14.0F,0.0F));
        ModelPartData modelPartData4 = modelPartData.addChild("left_leg", ModelPartBuilder.create().uv(0,85).cuboid(-16.0F, -6.0F, -9.0F, 10.0F, 25.0F, 19.0F), ModelTransform.pivot(22.0F,-6.0F,8.0F));
        ModelPartData modelPartData5 = modelPartData4.addChild("left_knee", ModelPartBuilder.create().uv(79,142).cuboid(-14.986F, -3.0F, -3.0F, 9.0F, 16.0F, 9.0F), ModelTransform.pivot(-1.0F,13.0F,6.0F));
        ModelPartData modelPartData6 = modelPartData5.addChild("left_thigh", ModelPartBuilder.create().uv(144,35).cuboid(-5.0F, -1.0F, -2.0F, 8.0F, 14.0F, 6.0F), ModelTransform.pivot(-9.0F,7.0F,2.0F));
        modelPartData6.addChild("left_foot", ModelPartBuilder.create().uv(39,91).cuboid(-5.0F, -1.0F, -6.0F, 8.0F, 3.0F, 10.0F, new Dilation(-0.01F)).uv(0,33).cuboid(-4.0F, -3.0F, -12.0F, 0.0F, 5.0F, 11.0F).uv(0,38).cuboid(-1.0F, -3.0F, -12.0F, 0.0F, 5.0F, 11.0F).uv(0,43).cuboid(2.0F, -3.0F, -12.0F, 0.0F, 5.0F, 11.0F), ModelTransform.pivot(0.0F,14.0F,0.0F));
        ModelPartData modelPartData7 = modelPartData.addChild("body", ModelPartBuilder.create().uv(0,0).cuboid(-11.0F, -7.0F, -13.0F, 22.0F, 19.0F, 25.0F).uv(0,107).cuboid(-4.0F, -16.0F, -10.0F, 0.0F, 9.0F, 22.0F).uv(0,107).cuboid(4.0F, -16.0F, -10.0F, 0.0F, 9.0F, 22.0F).uv(0,135).cuboid(0.0F, -16.0F, -10.0F, 0.0F, 9.0F, 22.0F), ModelTransform.pivot(0.0F,-8.0F,8.0F));
        ModelPartData modelPartData8 = modelPartData7.addChild("tail", ModelPartBuilder.create().uv(0,44).cuboid(-9.0F, -6.0F, -1.0F, 18.0F, 16.0F, 25.0F).uv(103,76).cuboid(0.0F, -12.0F, 0.0F, 0.0F, 8.0F, 25.0F), ModelTransform.pivot(0.0F,-1.0F,13.0F));
        ModelPartData modelPartData9 = modelPartData8.addChild("tail2", ModelPartBuilder.create().uv(106,115).cuboid(-7.0F, -4.0F, -2.0F, 14.0F, 12.0F, 18.0F).uv(0,120).cuboid(0.0F, -11.0F, -1.0F, 0.0F, 7.0F, 18.0F), ModelTransform.pivot(0.0F,0.0F,26.0F));
        ModelPartData modelPartData10 = modelPartData9.addChild("tail3", ModelPartBuilder.create().uv(29,133).cuboid(-5.0F, -4.0F, -1.0F, 10.0F, 9.0F, 15.0F).uv(122,13).cuboid(0.0F, -11.0F, 0.0F, 0.0F, 7.0F, 15.0F), ModelTransform.pivot(0.0F,0.0F,17.0F));
        modelPartData10.addChild("tail4", ModelPartBuilder.create().uv(69,0).cuboid(-3.0F, -4.0F, -2.0F, 6.0F, 6.0F, 13.0F), ModelTransform.pivot(0.0F,0.0F,16.0F));
        ModelPartData modelPartData11 = modelPartData7.addChild("neck", ModelPartBuilder.create().uv(65,64).cuboid(-8.0F, -7.0F, -13.0F, 16.0F, 16.0F, 21.0F).uv(64,112).cuboid(0.0F, -16.0F, -13.0F, 0.0F, 9.0F, 21.0F), ModelTransform.pivot(0.0F,0.0F,-12.0F));
        ModelPartData modelPartData12 = modelPartData11.addChild("neck2", ModelPartBuilder.create().uv(72,22).cuboid(-7.0F, -9.0F, -17.0F, 14.0F, 15.0F, 22.0F), ModelTransform.pivot(0.0F,3.0F,-13.0F));
        ModelPartData modelPartData13 = modelPartData12.addChild("neck3", ModelPartBuilder.create().uv(122,0).cuboid(-6.0F, -7.0F, -15.0F, 12.0F, 12.0F, 16.0F, new Dilation(-0.1F)), ModelTransform.pivot(0.0F,1.0F,-12.0F));
        ModelPartData modelPartData14 = modelPartData13.addChild("head", ModelPartBuilder.create().uv(61,37).cuboid(0.0F, -16.0F, -15.0F, 0.0F, 5.0F, 22.0F).uv(58,101).cuboid(-6.0F, -12.0F, -15.0F, 12.0F, 11.0F, 21.0F).uv(94,146).cuboid(-6.0F, -10.0F, -15.0F, 12.0F, 11.0F, 21.0F, new Dilation(-0.5F)), ModelTransform.pivot(0.0F,7.0F,-10.0F));
        modelPartData14.addChild("jaw", ModelPartBuilder.create().uv(118,59).cuboid(-5.0F, -1.0F, -18.0F, 10.0F, 4.0F, 19.0F), ModelTransform.pivot(0.0F,0.0F,4.0F));
        modelPartData12.addChild("right_arm", ModelPartBuilder.create().uv(0,0).cuboid(-13.0F, 0.0F, -3.0F, 6.0F, 16.0F, 6.0F).uv(94,0).cuboid(-13.0F, 11.0F, -10.0F, 6.0F, 5.0F, 7.0F), ModelTransform.pivot(1.0F,-3.0F,-9.0F));
        modelPartData12.addChild("left_arm", ModelPartBuilder.create().uv(0,0).cuboid(7.0F, 0.0F, -3.0F, 6.0F, 16.0F, 6.0F, true).uv(94,0).cuboid(7.0F, 11.0F, -10.0F, 6.0F, 5.0F, 7.0F, true), ModelTransform.pivot(0.0F,-3.0F,-9.0F));
        return TexturedModelData.of(modelData,256,256);
    }
    @Override
    public void setAngles(TRexEntity entity, float limbAngle, float limbDistance, float AnimationProgress, float netHeadYaw, float headPitch){
        this.right_leg.pitch = -0.829F;
        this.right_knee.pitch = 1.6581F;
        this.right_thigh.pitch = -1.3963F;
        this.right_foot.pitch = 0.5672F;
        this.left_leg.pitch = -0.829F;
        this.left_knee.pitch = 1.6581F;
        this.left_thigh.pitch = -1.3963F;
        this.left_foot.pitch = 0.5672F;
        this.neck.pitch = 0.2182F;
        this.neck2.pitch = -0.1745F;
        this.neck3.pitch = -0.8727F;
        this.head.pitch = 0.829F;
        this.right_arm.pitch = -0.0873F;
        this.left_arm.pitch = -0.0873F;

        float amount = 1; // change this if legs make too much/too less movement
        float speed = 1; // change this if legs are too slow/fast

        float cosAnim = (MathHelper.cos(limbAngle * 0.6662F * speed) + 1) * 1.4F * limbDistance;
        float sinAnim = (MathHelper.sin(limbAngle * 0.6662F * speed) + 1) * 1.4F * limbDistance;

        float trueCosAnim = MathHelper.cos(limbAngle * 0.6662F) * 1.4F * limbDistance;
        float trueSinAnim = MathHelper.sin(limbAngle * 0.6662F) * 1.4F * limbDistance;

        this.tail.yaw = MathHelper.cos(AnimationProgress/3)/5;
        this.tail2.yaw = MathHelper.sin(AnimationProgress/3)/5;
        this.tail3.yaw = MathHelper.cos(AnimationProgress/3)/5;
        this.tail4.yaw = MathHelper.sin(AnimationProgress/3)/5;

        this.neck.pitch = 0.2f + MathHelper.cos(AnimationProgress/5)/20;

        float cos0to1 = (cosAnim * amount)/4;
        float sin0to1 = (sinAnim * amount)/4;

        this.right_leg.pitch = -(cos0to1 + 0.83f);
        this.right_knee.pitch = sin0to1 + 1.6f;
        this.left_leg.pitch = -(sin0to1 + 0.83f);
        this.left_knee.pitch = cos0to1 + 1.6f;
        this.right_arm.pitch = trueCosAnim;
        this.left_arm.pitch = trueSinAnim;


        //previously the render function, render code was moved to a method below
    }
    @Override
    public void render(MatrixStack matrixStack, VertexConsumer	buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){

        right_leg.render(matrixStack, buffer, packedLight, packedOverlay);
        left_leg.render(matrixStack, buffer, packedLight, packedOverlay);
        body.render(matrixStack, buffer, packedLight, packedOverlay);
    }
    public void setRotationAngle(ModelPart bone, float x, float y, float z) {
        bone.pitch = x;
        bone.yaw = y;
        bone.roll = z;
    }
}