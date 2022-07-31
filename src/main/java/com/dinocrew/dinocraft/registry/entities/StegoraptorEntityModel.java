// Made with Model Converter by Globox_Z
// Generate all required imports
// Made with Blockbench 4.0.3
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports
package com.dinocrew.dinocraft.registry.entities;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class StegoraptorEntityModel extends EntityModel<StegoraptorEntity> {
    private final ModelPart body;
    private final ModelPart neck1;
    private final ModelPart neck2;
    private final ModelPart head;
    private final ModelPart nose;
    private final ModelPart jaw;
    private final ModelPart right_arm;
    private final ModelPart right_wrist;
    private final ModelPart right_hand;
    private final ModelPart left_arm;
    private final ModelPart left_wrist;
    private final ModelPart left_hand;
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

    public StegoraptorEntityModel(ModelPart root) {
        this.body = root.getChild("body");
        this.tail1 = this.body.getChild("tail1");
        this.tail2 = this.tail1.getChild("tail2");
        this.tail3 = this.tail2.getChild("tail3");
        this.left_arm = this.body.getChild("left_arm");
        this.left_wrist = this.left_arm.getChild("left_wrist");
        this.left_hand = this.left_wrist.getChild("left_hand");
        this.right_arm = this.body.getChild("right_arm");
        this.right_wrist = this.right_arm.getChild("right_wrist");
        this.right_hand = this.right_wrist.getChild("right_hand");
        this.neck1 = this.body.getChild("neck1");
        this.neck2 = this.neck1.getChild("neck2");
        this.head = this.neck2.getChild("head");
        this.jaw = this.head.getChild("jaw");
        this.nose = this.head.getChild("nose");
        this.right_hip = root.getChild("right_hip");
        this.right_leg = this.right_hip.getChild("right_leg");
        this.right_knee = this.right_leg.getChild("right_knee");
        this.right_foot = this.right_knee.getChild("right_foot");
        this.left_hip = root.getChild("left_hip");
        this.left_leg = this.left_hip.getChild("left_leg");
        this.left_knee = this.left_leg.getChild("left_knee");
        this.left_foot = this.left_knee.getChild("left_foot");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData modelPartData1 = modelPartData.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-6.0F, -6.0F, -9.0F, 12.0F, 12.0F, 18.0F).uv(0, 51).cuboid(0.0F, -12.0F, -7.0F, 0.0F, 6.0F, 14.0F), ModelTransform.pivot(0.0F, 2.0F, 0.0F));
        ModelPartData modelPartData2 = modelPartData1.addChild("neck1", ModelPartBuilder.create().uv(58, 48).cuboid(-4.0F, -4.5F, -8.0F, 8.0F, 9.0F, 8.0F), ModelTransform.pivot(0.0F, -1.5F, -5.0F));
        ModelPartData modelPartData3 = modelPartData2.addChild("neck2", ModelPartBuilder.create().uv(78, 0).cuboid(-3.0F, -3.0F, -7.25F, 6.0F, 6.0F, 8.0F), ModelTransform.pivot(0.0F, 0.0F, -6.25F));
        ModelPartData modelPartData4 = modelPartData3.addChild("head", ModelPartBuilder.create().uv(24, 34).cuboid(-4.5F, -5.0F, -12.0F, 9.0F, 10.0F, 12.0F).uv(0, 12).cuboid(0.0F, -11.0F, -12.0F, 0.0F, 16.0F, 18.0F).uv(70, 79).cuboid(-3.5F, 0.0F, -20.0F, 7.0F, 3.0F, 8.0F), ModelTransform.pivot(0.0F, -3.0F, -7.25F));
        modelPartData4.addChild("nose", ModelPartBuilder.create().uv(0, 71).cuboid(-2.0F, 0.0F, 0.0F, 5.0F, 4.0F, 10.0F), ModelTransform.pivot(-0.5F, 0.0F, -20.0F));
        modelPartData4.addChild("jaw", ModelPartBuilder.create().uv(62, 65).cuboid(-2.5F, 0.0F, 0.0F, 6.0F, 4.0F, 10.0F), ModelTransform.pivot(-0.5F, 3.0F, -20.0F));
        ModelPartData modelPartData5 = modelPartData1.addChild("right_arm", ModelPartBuilder.create().uv(0, 0).cuboid(-2.5F, -1.0F, -2.5F, 4.0F, 10.0F, 5.0F), ModelTransform.pivot(-4.5F, -2.0F, -6.5F));
        ModelPartData modelPartData6 = modelPartData5.addChild("right_wrist", ModelPartBuilder.create().uv(26, 84).cuboid(-1.5F, -0.75F, -2.0F, 3.0F, 10.0F, 4.0F), ModelTransform.pivot(-0.5F, 8.25F, 0.0F));
        modelPartData6.addChild("right_hand", ModelPartBuilder.create().uv(66, 0).cuboid(-2.5F, -0.75F, -1.0F, 5.0F, 6.0F, 2.0F), ModelTransform.pivot(0.0F, 8.5F, 0.0F));
        ModelPartData modelPartData7 = modelPartData1.addChild("left_arm", ModelPartBuilder.create().uv(0, 0).cuboid(-1.5F, -1.0F, -2.5F, 4.0F, 10.0F, 5.0F, true), ModelTransform.pivot(4.5F, -2.0F, -6.5F));
        ModelPartData modelPartData8 = modelPartData7.addChild("left_wrist", ModelPartBuilder.create().uv(26, 84).cuboid(-1.5F, -0.75F, -2.0F, 3.0F, 10.0F, 4.0F, true), ModelTransform.pivot(0.5F, 8.25F, 0.0F));
        modelPartData8.addChild("left_hand", ModelPartBuilder.create().uv(66, 0).cuboid(-2.5F, -0.75F, -1.0F, 5.0F, 6.0F, 2.0F, true), ModelTransform.pivot(0.0F, 8.5F, 0.0F));
        ModelPartData modelPartData9 = modelPartData1.addChild("tail1", ModelPartBuilder.create().uv(54, 18).cuboid(-4.0F, -3.0F, 0.0F, 8.0F, 8.0F, 12.0F).uv(54, 67).cuboid(0.0F, -9.0F, 0.0F, 0.0F, 6.0F, 12.0F), ModelTransform.pivot(0.0F, -3.0F, 7.0F));
        ModelPartData modelPartData10 = modelPartData9.addChild("tail2", ModelPartBuilder.create().uv(42, 0).cuboid(-3.0F, 0.0F, 0.0F, 6.0F, 6.0F, 12.0F).uv(30, 66).cuboid(0.0F, -6.0F, 0.0F, 0.0F, 6.0F, 12.0F), ModelTransform.pivot(0.0F, -2.0F, 12.0F));
        modelPartData10.addChild("tail3", ModelPartBuilder.create().uv(0, 46).cuboid(-2.0F, 0.0F, 0.0F, 4.0F, 3.0F, 16.0F).uv(54, 26).cuboid(0.0F, -6.0F, 0.0F, 0.0F, 6.0F, 12.0F), ModelTransform.pivot(0.0F, 2.0F, 12.0F));
        ModelPartData modelPartData11 = modelPartData.addChild("right_hip", ModelPartBuilder.create().uv(30, 56).cuboid(-3.0F, -3.0F, -5.0F, 6.0F, 12.0F, 10.0F, true), ModelTransform.pivot(-4.5F, 3.5F, 6.5F));
        ModelPartData modelPartData12 = modelPartData11.addChild("right_leg", ModelPartBuilder.create().uv(82, 14).cuboid(-2.5F, -1.5F, -3.0F, 5.0F, 8.0F, 6.0F, true), ModelTransform.pivot(0.0F, 6.5F, 1.0F));
        ModelPartData modelPartData13 = modelPartData12.addChild("right_knee", ModelPartBuilder.create().uv(0, 46).cuboid(-2.0F, -1.0F, -2.0F, 4.0F, 11.0F, 4.0F, true), ModelTransform.pivot(0.0F, 4.5F, -1.5F));
        modelPartData13.addChild("right_foot", ModelPartBuilder.create().uv(70, 38).cuboid(-3.0F, 0.0F, -6.5F, 6.0F, 2.0F, 8.0F, true), ModelTransform.pivot(0.0F, 9.5F, -0.5F));
        ModelPartData modelPartData14 = modelPartData.addChild("left_hip", ModelPartBuilder.create().uv(30, 56).cuboid(-3.0F, -3.0F, -5.0F, 6.0F, 12.0F, 10.0F), ModelTransform.pivot(4.5F, 3.5F, 6.5F));
        ModelPartData modelPartData15 = modelPartData14.addChild("left_leg", ModelPartBuilder.create().uv(82, 14).cuboid(-2.5F, -1.5F, -3.0F, 5.0F, 8.0F, 6.0F), ModelTransform.pivot(0.0F, 6.5F, 1.0F));
        ModelPartData modelPartData16 = modelPartData15.addChild("left_knee", ModelPartBuilder.create().uv(0, 46).cuboid(-2.0F, -1.0F, -2.0F, 4.0F, 11.0F, 4.0F), ModelTransform.pivot(0.0F, 4.5F, -1.5F));
        modelPartData16.addChild("left_foot", ModelPartBuilder.create().uv(70, 38).cuboid(-3.0F, 0.0F, -6.5F, 6.0F, 2.0F, 8.0F), ModelTransform.pivot(0.0F, 9.5F, -0.5F));
        return TexturedModelData.of(modelData, 128, 128);
    }

    @Override
    public void setAngles(StegoraptorEntity entity, float limbAngle, float limbDistance, float animationProgress, float netHeadYaw, float headPitch) {
        float flatAngle = 3 * (limbDistance) + 1;
        this.body.pitch = -0.1745F / flatAngle;
        this.neck1.pitch = -0.5236F / flatAngle;
        this.neck2.pitch = -0.48F / flatAngle;
        this.head.pitch = 1.3963F / flatAngle;
        this.nose.pitch = 0.5236F;
        this.jaw.pitch = 0.2618F;
        this.right_arm.pitch = 0.1745F;
        this.right_wrist.pitch = -0.7418F;
        this.right_hand.pitch = 0.8727F;
        this.left_arm.pitch = 0.1745F;
        this.left_wrist.pitch = -0.7418F;
        this.left_hand.pitch = 0.8727F;
        this.tail1.pitch = 0.1745F / flatAngle;
        this.body.roll = MathHelper.cos(limbAngle * 2) * limbDistance / 7;

        this.tail1.yaw = MathHelper.cos(animationProgress / 5) / 10;
        this.tail2.yaw = MathHelper.sin(animationProgress / 5) / 10;
        this.tail3.yaw = MathHelper.cos(animationProgress / 5) / 10;

        this.right_hip.pitch = MathHelper.cos(limbAngle * 0.6662F + 3.1415927F) * 1.4F * limbDistance / 3 - 0.3491F;
        this.right_leg.pitch = MathHelper.cos(limbAngle * 0.6662F + 3.1415927F) * 1.4F * limbDistance / 3 + 1.2217F;
        this.right_knee.pitch = MathHelper.cos(limbAngle * 0.6662F + 3.1415927F) * 1.4F * limbDistance / 3 - 1.3963F;
        this.right_foot.pitch = 0.5236F;
        this.left_hip.pitch = -MathHelper.cos(limbAngle * 0.6662F + 3.1415927F) * 1.4F * limbDistance / 3 - 0.3491F;
        this.left_leg.pitch = -MathHelper.cos(limbAngle * 0.6662F + 3.1415927F) * 1.4F * limbDistance / 3 + 1.2217F;
        this.left_knee.pitch = -MathHelper.cos(limbAngle * 0.6662F + 3.1415927F) * 1.4F * limbDistance / 3 - 1.3963F;
        this.left_foot.pitch = 0.5236F;
    }

    @Override
    public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {

        body.render(matrixStack, buffer, packedLight, packedOverlay);
        right_hip.render(matrixStack, buffer, packedLight, packedOverlay);
        left_hip.render(matrixStack, buffer, packedLight, packedOverlay);
    }

}