// Made with Model Converter by Globox_Z
// Generate all required imports
// Made with Blockbench 4.0.1
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

package com.dinocrew.dinocraft.registry.entities;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

@Environment(EnvType.CLIENT)
public class MicroRaptorEntityModel extends EntityModel<MicroraptorEntity> {
    private final ModelPart body;
    private final ModelPart neck;
    private final ModelPart head;
    private final ModelPart right_leg;
    private final ModelPart right_knee;
    private final ModelPart right_foot;
    private final ModelPart left_leg;
    private final ModelPart left_knee;
    private final ModelPart left_foot;
    private final ModelPart right_wing1;
    private final ModelPart right_wing2;
    private final ModelPart right_wing3;
    private final ModelPart left_wing1;
    private final ModelPart left_wing2;
    private final ModelPart left_wing3;
    private final ModelPart tail1;
    private final ModelPart tail2;
    private final ModelPart tail3;

    public MicroRaptorEntityModel(ModelPart root) {
        this.body = root.getChild("body");
        this.tail1 = this.body.getChild("tail1");
        this.tail2 = this.tail1.getChild("tail2");
        this.tail3 = this.tail2.getChild("tail3");
        this.left_wing1 = this.body.getChild("left_wing1");
        this.left_wing2 = this.left_wing1.getChild("left_wing2");
        this.left_wing3 = this.left_wing2.getChild("left_wing3");
        this.right_wing1 = this.body.getChild("right_wing1");
        this.right_wing2 = this.right_wing1.getChild("right_wing2");
        this.right_wing3 = this.right_wing2.getChild("right_wing3");
        this.left_leg = this.body.getChild("left_leg");
        this.left_knee = this.left_leg.getChild("left_knee");
        this.left_foot = this.left_knee.getChild("left_foot");
        this.right_leg = this.body.getChild("right_leg");
        this.right_knee = this.right_leg.getChild("right_knee");
        this.right_foot = this.right_knee.getChild("right_foot");
        this.neck = this.body.getChild("neck");
        this.head = this.neck.getChild("head");
    }

    public static LayerDefinition getTexturedModelData() {
        MeshDefinition modelData = new MeshDefinition();
        PartDefinition modelPartData = modelData.getRoot();
        PartDefinition modelPartData1 = modelPartData.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 20).addBox(-6.0F, -6.0F, -8.0F, 12.0F, 12.0F, 16.0F), PartPose.offset(0.0F, 2.0F, 0.0F));
        PartDefinition modelPartData2 = modelPartData1.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(52, 0).addBox(-3.0F, -3.0F, -12.0F, 6.0F, 6.0F, 12.0F), PartPose.offset(0.0F, -2.0F, -6.0F));
        modelPartData2.addOrReplaceChild("head", CubeListBuilder.create().texOffs(40, 50).addBox(-4.0F, -5.0F, -10.0F, 8.0F, 8.0F, 10.0F).texOffs(62, 72).addBox(-2.0F, -2.0F, -16.0F, 4.0F, 4.0F, 6.0F), PartPose.offset(0.0F, -1.0F, -10.0F));
        PartDefinition modelPartData3 = modelPartData1.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(64, 20).addBox(-3.0F, -3.0F, -5.0F, 6.0F, 12.0F, 10.0F).texOffs(76, 8).addBox(-0.25F, -3.0F, 5.0F, 0.0F, 12.0F, 8.0F), PartPose.offset(-4.0F, 3.0F, 5.0F));
        PartDefinition modelPartData4 = modelPartData3.addOrReplaceChild("right_knee", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F).texOffs(0, 10).addBox(0.0F, -1.0F, 2.0F, 0.0F, 12.0F, 6.0F), PartPose.offset(0.0F, 8.0F, 2.0F));
        modelPartData4.addOrReplaceChild("right_foot", CubeListBuilder.create().texOffs(22, 68).addBox(-3.0F, 0.0F, -6.0F, 6.0F, 2.0F, 8.0F), PartPose.offset(0.0F, 9.0F, -2.0F));
        PartDefinition modelPartData5 = modelPartData1.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(64, 20).addBox(-3.0F, -3.0F, -5.0F, 6.0F, 12.0F, 10.0F, true).texOffs(76, 8).addBox(0.25F, -3.0F, 5.0F, 0.0F, 12.0F, 8.0F, true), PartPose.offset(4.0F, 3.0F, 5.0F));
        PartDefinition modelPartData6 = modelPartData5.addOrReplaceChild("left_knee", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F, true).texOffs(0, 10).addBox(0.0F, -1.0F, 2.0F, 0.0F, 12.0F, 6.0F, true), PartPose.offset(0.0F, 8.0F, 2.0F));
        modelPartData6.addOrReplaceChild("left_foot", CubeListBuilder.create().texOffs(22, 68).addBox(-3.0F, 0.0F, -6.0F, 6.0F, 2.0F, 8.0F, true), PartPose.offset(0.0F, 9.0F, -2.0F));
        PartDefinition modelPartData7 = modelPartData1.addOrReplaceChild("right_wing1", CubeListBuilder.create().texOffs(66, 50).addBox(-10.0F, -1.0F, -1.5F, 10.0F, 2.0F, 3.0F).texOffs(42, 72).addBox(-10.0F, -0.5F, 1.5F, 10.0F, 1.0F, 3.0F).texOffs(0, 66).addBox(-10.0F, 0.0F, 4.5F, 10.0F, 0.0F, 10.0F), PartPose.offset(-6.0F, -4.0F, -4.5F));
        PartDefinition modelPartData8 = modelPartData7.addOrReplaceChild("right_wing2", CubeListBuilder.create().texOffs(64, 42).addBox(-16.0F, -0.5F, -1.5F, 16.0F, 1.0F, 3.0F).texOffs(30, 20).addBox(-16.0F, 0.0F, 1.5F, 16.0F, 0.0F, 10.0F), PartPose.offset(-10.0F, 0.0F, 0.0F));
        modelPartData8.addOrReplaceChild("right_wing3", CubeListBuilder.create().texOffs(18, 50).addBox(-10.0F, 0.0F, -1.5F, 10.0F, 0.0F, 10.0F), PartPose.offset(-16.0F, 0.0F, 0.0F));
        PartDefinition modelPartData9 = modelPartData1.addOrReplaceChild("left_wing1", CubeListBuilder.create().texOffs(66, 50).addBox(0.0F, -1.0F, -1.5F, 10.0F, 2.0F, 3.0F, true).texOffs(42, 72).addBox(0.0F, -0.5F, 1.5F, 10.0F, 1.0F, 3.0F, true).texOffs(0, 66).addBox(0.0F, 0.0F, 4.5F, 10.0F, 0.0F, 10.0F, true), PartPose.offset(6.0F, -4.0F, -4.5F));
        PartDefinition modelPartData10 = modelPartData9.addOrReplaceChild("left_wing2", CubeListBuilder.create().texOffs(64, 42).addBox(0.0F, -0.5F, -1.5F, 16.0F, 1.0F, 3.0F, true).texOffs(30, 20).addBox(0.0F, 0.0F, 1.5F, 16.0F, 0.0F, 10.0F, true), PartPose.offset(10.0F, 0.0F, 0.0F));
        modelPartData10.addOrReplaceChild("left_wing3", CubeListBuilder.create().texOffs(18, 50).addBox(0.0F, 0.0F, -1.5F, 10.0F, 0.0F, 10.0F, true), PartPose.offset(16.0F, 0.0F, 0.0F));
        PartDefinition modelPartData11 = modelPartData1.addOrReplaceChild("tail1", CubeListBuilder.create().texOffs(0, 48).addBox(-4.0F, -3.0F, 0.0F, 8.0F, 6.0F, 12.0F), PartPose.offset(0.0F, -3.0F, 8.0F));
        PartDefinition modelPartData12 = modelPartData11.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(64, 56).addBox(-3.0F, -2.0F, 0.0F, 6.0F, 4.0F, 12.0F), PartPose.offset(0.0F, -1.0F, 12.0F));
        modelPartData12.addOrReplaceChild("tail3", CubeListBuilder.create().texOffs(40, 32).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 2.0F, 16.0F).texOffs(0, 0).addBox(-8.0F, 0.0F, 14.0F, 16.0F, 0.0F, 20.0F), PartPose.offset(0.0F, -1.0F, 12.0F));
        return LayerDefinition.create(modelData, 128, 128);
    }

    @Override
    public void renderToBuffer(PoseStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        body.render(matrixStack, buffer, packedLight, packedOverlay);

    }

    public void setRotationAngle(ModelPart bone, float x, float y, float z) {
        bone.xRot = x;
        bone.yRot = y;
        bone.zRot = z;
    }

    public void setAngles(MicroraptorEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        float pi = 3.14159265358979323846264338327950288F;
        setRotationAngle(neck, -0.6981F, 0.0F, 0.0F);
        setRotationAngle(head, 0.7854F, 0.0F, 0.0F);
        setRotationAngle(right_foot, -0.3491F, 0.0F, 0.0F);
        setRotationAngle(left_foot, -0.3491F, 0.0F, 0.0F);

        if (!entity.isOnGround()) {
            this.right_wing1.yRot = 0;
            this.left_wing1.yRot = 0;
            this.right_wing1.xRot = 0;
            this.left_wing1.xRot = 0;
            this.right_wing1.zRot = Mth.cos(animationProgress / 5) / 3;
            this.left_wing1.zRot = -Mth.cos(animationProgress / 5) / 3;

            this.right_wing2.yRot = 0;
            this.left_wing2.yRot = 0;
            this.right_wing2.xRot = 0;
            this.left_wing2.xRot = 0;
            this.right_wing2.zRot = Mth.cos(animationProgress / 5) / 3;
            this.left_wing2.zRot = -Mth.cos(animationProgress / 5) / 3;

            this.right_wing3.yRot = 0;
            this.left_wing3.yRot = 0;
            this.right_wing3.xRot = 0;
            this.left_wing3.xRot = 0;
            this.right_wing3.zRot = Mth.cos(animationProgress / 5) / 3;
            this.left_wing3.zRot = -Mth.cos(animationProgress / 5) / 3;

            this.tail1.yRot = 0;
            this.tail2.yRot = 0;
            this.tail3.yRot = 0;

            this.tail2.xRot = 0;
            this.tail3.xRot = 0;

            this.tail1.zRot = 0;
            this.tail2.zRot = 0;
            this.tail3.zRot = 0;

            this.tail1.xRot = 0;

            this.left_leg.xRot = 1;
            this.right_leg.xRot = 1;

            this.left_knee.xRot = 1;
            this.right_knee.xRot = 1;

            this.head.xRot = 0;
            this.neck.xRot = 0;
            this.head.yRot = 0;

        } else {
            setRotationAngle(right_wing1, -2.2772F, 1.196F, -0.6124F);
            setRotationAngle(left_wing1, -2.2772F, -1.196F, 0.6124F);

            this.right_wing2.yRot = 0;
            this.left_wing2.yRot = 0;
            this.right_wing2.zRot = 0;
            this.left_wing2.zRot = 0;
            this.right_wing2.xRot = 0;
            this.left_wing2.xRot = 0;

            this.right_wing3.yRot = 0;
            this.left_wing3.yRot = 0;
            this.right_wing3.zRot = 0;
            this.left_wing3.zRot = 0;
            this.right_wing3.xRot = 0;
            this.left_wing3.xRot = 0;

            this.tail1.yRot = -Mth.cos(animationProgress / 5) / 5;
            this.tail2.yRot = -Mth.cos(animationProgress / 5) / 5;
            this.tail3.yRot = -Mth.cos(animationProgress / 5) / 5;

            this.tail1.zRot = Mth.cos(animationProgress / 5) / 5;
            this.tail2.zRot = Mth.cos(animationProgress / 5) / 5;
            this.tail3.zRot = Mth.cos(animationProgress / 5) / 5;

            this.head.xRot = 0.7854F;
            this.neck.xRot = -0.6981F;

            this.tail1.xRot = -Mth.sin(animationProgress / 5) / 20 - 20 * pi / 180;
            this.tail2.xRot = Mth.sin(animationProgress / 5) / 20 + 10 * pi / 180;
            this.tail3.xRot = -Mth.sin(animationProgress / 5) / 20 - 10 * pi / 180;

            this.left_leg.xRot = Mth.cos(limbAngle * 0.6662F + 3.1415927F) * 1.4F * limbDistance / 2 - 0.3491F;
            this.right_leg.xRot = -Mth.cos(limbAngle * 0.6662F + 3.1415927F) * 1.4F * limbDistance / 2 - 0.3491F;

            this.left_knee.xRot = Mth.cos(limbAngle * 0.6662F + 3.1415927F) * 1.4F * limbDistance / 2 + 0.6981F;
            this.right_knee.xRot = -Mth.cos(limbAngle * 0.6662F + 3.1415927F) * 1.4F * limbDistance / 2 + 0.6981F;

        }
    }

}