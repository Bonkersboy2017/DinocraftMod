// Made with Model Converter by Globox_Z
// Generate all required imports
// Made with Blockbench 4.0.1
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports
package com.dinocrew.dinocraft.registry.entities;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.util.Mth;

public class MosasaurusModel extends HierarchicalModel<Mosasaurus> {
    private final ModelPart root;
    private final ModelPart body;
    private final ModelPart back_body;
    private final ModelPart tail1;
    private final ModelPart tail2;
    private final ModelPart exit1;
    private final ModelPart exit2;
    private final ModelPart left_back_fin;
    private final ModelPart left_back_fin2;
    private final ModelPart head;
    private final ModelPart head2;
    private final ModelPart head4;
    private final ModelPart mouth;
    private final ModelPart mouth2;
    private final ModelPart left_front_fin;
    private final ModelPart right_front_fin;

    public MosasaurusModel(ModelPart root) {
        super(RenderType::entityCutoutNoCull);
        this.root = root;
        this.body = this.root.getChild("body");
        this.right_front_fin = this.body.getChild("right_front_fin");
        this.left_front_fin = this.body.getChild("left_front_fin");
        this.head = this.body.getChild("head");
        this.mouth = this.head.getChild("mouth");
        this.mouth2 = this.mouth.getChild("mouth2");
        this.head2 = this.head.getChild("head2");
        this.head4 = this.head2.getChild("head4");
        this.back_body = this.body.getChild("back_body");
        this.tail1 = this.back_body.getChild("tail1");
        this.left_back_fin2 = this.tail1.getChild("left_back_fin2");
        this.left_back_fin = this.tail1.getChild("left_back_fin");
        this.tail2 = this.tail1.getChild("tail2");
        this.exit2 = this.tail2.getChild("exit2");
        this.exit1 = this.tail2.getChild("exit1");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition modelData = new MeshDefinition();
        PartDefinition modelPartData = modelData.getRoot();
        PartDefinition modelPartData1 = modelPartData.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -15.0F, -15.0F, 12.0F, 12.0F, 24.0F), PartPose.offset(0.0F, 24.0F, 0.0F));
        PartDefinition modelPartData2 = modelPartData1.addOrReplaceChild("back_body", CubeListBuilder.create().texOffs(42, 58).addBox(-5.0F, -6.0F, -1.0F, 10.0F, 10.0F, 10.0F), PartPose.offset(0.0F, -8.0F, 9.0F));
        PartDefinition modelPartData3 = modelPartData2.addOrReplaceChild("tail1", CubeListBuilder.create().texOffs(32, 78).addBox(-4.0F, -5.0F, -4.0F, 8.0F, 8.0F, 8.0F), PartPose.offset(0.0F, 0.0F, 13.0F));
        PartDefinition modelPartData4 = modelPartData3.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(44, 36).addBox(-3.0F, -4.0F, 0.0F, 6.0F, 6.0F, 16.0F), PartPose.offset(0.0F, 0.0F, 4.0F));
        modelPartData4.addOrReplaceChild("exit1", CubeListBuilder.create().texOffs(76, 47).addBox(-1.0F, -5.0F, 0.0F, 2.0F, 6.0F, 12.0F), PartPose.offset(0.0F, 1.0F, 9.0F));
        modelPartData4.addOrReplaceChild("exit2", CubeListBuilder.create().texOffs(0, 50).addBox(-2.0F, -4.0F, -4.0F, 4.0F, 6.0F, 17.0F), PartPose.offset(0.0F, 1.0F, 9.0F));
        modelPartData3.addOrReplaceChild("left_back_fin", CubeListBuilder.create().texOffs(72, 37).addBox(0.0F, -1.0F, -4.0F, 12.0F, 2.0F, 8.0F), PartPose.offset(2.0F, 1.0F, 1.0F));
        modelPartData3.addOrReplaceChild("left_back_fin2", CubeListBuilder.create().texOffs(72, 27).addBox(-12.0F, -1.0F, -4.0F, 12.0F, 2.0F, 8.0F), PartPose.offset(-2.0F, 1.0F, 1.0F));
        PartDefinition modelPartData5 = modelPartData1.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 73).addBox(-5.0F, -7.0F, -9.0F, 10.0F, 11.0F, 6.0F), PartPose.offset(0.0F, -8.0F, -12.0F));
        PartDefinition modelPartData6 = modelPartData5.addOrReplaceChild("head2", CubeListBuilder.create().texOffs(71, 67).addBox(-4.0F, -6.0F, -10.0F, 8.0F, 7.0F, 11.0F), PartPose.offset(0.0F, 0.0F, -9.0F));
        modelPartData6.addOrReplaceChild("head4", CubeListBuilder.create().texOffs(55, 85).addBox(-3.0F, 2.0F, -9.0F, 6.0F, 3.0F, 9.0F).texOffs(48, 14).addBox(-3.0F, 5.0F, -9.0F, 6.0F, 1.0F, 9.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, -4.0F, -10.0F));
        PartDefinition modelPartData7 = modelPartData5.addOrReplaceChild("mouth", CubeListBuilder.create().texOffs(72, 14).addBox(-4.0F, 1.0F, -10.0F, 8.0F, 2.0F, 11.0F), PartPose.offset(0.0F, 0.0F, -9.0F));
        modelPartData7.addOrReplaceChild("mouth2", CubeListBuilder.create().texOffs(85, 85).addBox(-3.0F, -1.0F, -9.0F, 6.0F, 2.0F, 9.0F), PartPose.offset(0.0F, 2.0F, -10.0F));
        modelPartData1.addOrReplaceChild("left_front_fin", CubeListBuilder.create().texOffs(48, 0).addBox(-3.0F, -1.0F, -5.0F, 18.0F, 2.0F, 12.0F).texOffs(48, 0).addBox(-3.0F, -1.0F, -5.0F, 18.0F, 2.0F, 12.0F), PartPose.offset(7.0F, -4.0F, -5.0F));
        modelPartData1.addOrReplaceChild("right_front_fin", CubeListBuilder.create().texOffs(0, 36).addBox(-15.0F, -1.0F, -5.0F, 18.0F, 2.0F, 12.0F), PartPose.offset(-7.0F, -4.0F, -5.0F));
        return LayerDefinition.create(modelData, 128, 128);
    }

    @Override
    public void setupAnim(Mosasaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.left_back_fin.yRot = -0.3927F + Mth.cos(ageInTicks / 5) / 5;
        this.left_back_fin.zRot = 0.4363F;
        this.left_back_fin2.yRot = 0.3927F;
        this.left_back_fin2.zRot = -0.4363F;
        this.exit1.xRot = 0.3491F;
        this.exit2.xRot = -0.3491F;
        this.left_front_fin.yRot = -0.3927F - Mth.cos(ageInTicks / 5) / 5;
        this.left_front_fin.zRot = 0.4363F;
        this.right_front_fin.yRot = 0.3927F + Mth.cos(ageInTicks / 5) / 5;
        this.right_front_fin.zRot = -0.4363F;
        this.body.xRot = Mth.sin(ageInTicks / 5) / 10;
        this.back_body.xRot = Mth.cos(ageInTicks / 8) / 8;
        this.tail1.xRot = Mth.sin(ageInTicks / 8) / 8;
        this.tail2.xRot = -Mth.cos(ageInTicks / 8) / 8;

    }

    @Override
    public void renderToBuffer(PoseStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        matrixStack.scale(2, 2, 2);
        matrixStack.translate(0, -0.5, 0);
        body.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }
}