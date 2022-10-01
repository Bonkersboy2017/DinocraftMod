// Made with Model Converter by Globox_Z
// Generate all required imports
// Made with Blockbench 4.0.5
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports
package com.dinocrew.dinocraft.registry.entities;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;

public class ChinleaModel extends HierarchicalModel<Chinlea> {
    private final ModelPart root;
    private final ModelPart bone;
    private final ModelPart faceside;
    private final ModelPart cube_r1;
    private final ModelPart cube_r2;
    private final ModelPart cube_r3;
    private final ModelPart cube_r4;
    private final ModelPart cube_r5;
    private final ModelPart cube_r6;
    private final ModelPart cube_r7;
    private final ModelPart cube_r8;
    private final ModelPart cube_r9;
    private final ModelPart cube_r10;
    private final ModelPart cube_r11;
    private final ModelPart jaw;
    private final ModelPart cube_r12;
    private final ModelPart tailside;
    private final ModelPart cube_r13;
    private final ModelPart cube_r14;
    private final ModelPart cube_r15;
    private final ModelPart cube_r16;
    private final ModelPart cube_r17;

    public ChinleaModel(ModelPart root) {
        super(RenderType::entityCutoutNoCull);
        this.root = root;
        this.bone = this.root.getChild("bone");
        this.tailside = this.bone.getChild("tailside");
        this.cube_r17 = this.tailside.getChild("cube_r17");
        this.cube_r16 = this.tailside.getChild("cube_r16");
        this.cube_r15 = this.tailside.getChild("cube_r15");
        this.cube_r14 = this.tailside.getChild("cube_r14");
        this.cube_r13 = this.tailside.getChild("cube_r13");
        this.faceside = this.bone.getChild("faceside");
        this.jaw = this.faceside.getChild("jaw");
        this.cube_r12 = this.jaw.getChild("cube_r12");
        this.cube_r11 = this.faceside.getChild("cube_r11");
        this.cube_r10 = this.faceside.getChild("cube_r10");
        this.cube_r9 = this.faceside.getChild("cube_r9");
        this.cube_r8 = this.faceside.getChild("cube_r8");
        this.cube_r7 = this.faceside.getChild("cube_r7");
        this.cube_r6 = this.faceside.getChild("cube_r6");
        this.cube_r5 = this.faceside.getChild("cube_r5");
        this.cube_r4 = this.faceside.getChild("cube_r4");
        this.cube_r3 = this.faceside.getChild("cube_r3");
        this.cube_r2 = this.faceside.getChild("cube_r2");
        this.cube_r1 = this.faceside.getChild("cube_r1");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition modelData = new MeshDefinition();
        PartDefinition modelPartData = modelData.getRoot();

        PartDefinition modelPartData1 = modelPartData.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
        PartDefinition modelPartData2 = modelPartData1.addOrReplaceChild("faceside", CubeListBuilder.create().texOffs(8, 0).addBox(0.0F, -1.0F, -1.0F, 7.0F, 3.0F, 1.0F).texOffs(0, 0).addBox(7.0F, 0.0F, -1.0F, 2.0F, 1.0F, 1.0F).texOffs(19, 20).addBox(0.0F, -1.0F, -2.0F, 1.0F, 3.0F, 1.0F).texOffs(0, 8).addBox(0.0F, -1.0F, 0.0F, 1.0F, 3.0F, 1.0F).texOffs(27, 31).addBox(7.0F, 0.0F, 0.0F, 2.0F, 1.0F, 0.0F), PartPose.offset(0.0F, -3.0F, 1.0F));
        modelPartData2.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(23, 30).addBox(1.0F, -5.0F, 1.0F, 3.0F, 2.0F, 0.0F), PartPose.offset(0.0F, 3.0F, -1.0F));
        modelPartData2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 30).addBox(2.0F, -2.0F, -1.0F, 3.0F, 2.0F, 0.0F), PartPose.offset(0.0F, 3.0F, -1.0F));
        modelPartData2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 30).addBox(2.0F, -2.0F, 2.0F, 3.0F, 2.0F, 0.0F), PartPose.offset(0.0F, 3.0F, -1.0F));
        modelPartData2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(10, 30).addBox(0.0F, -2.0F, 0.0F, 3.0F, 2.0F, 0.0F), PartPose.offset(0.0F, 3.0F, -1.0F));
        modelPartData2.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(10, 30).addBox(0.0F, -2.0F, 1.0F, 3.0F, 2.0F, 0.0F), PartPose.offset(0.0F, 3.0F, -1.0F));
        modelPartData2.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(23, 30).addBox(1.0F, -5.0F, 0.0F, 3.0F, 2.0F, 0.0F), PartPose.offset(0.0F, 3.0F, -1.0F));
        modelPartData2.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(14, 31).addBox(-9.0F, -3.0F, 0.0F, 2.0F, 1.0F, 0.0F), PartPose.offset(0.0F, 3.0F, -1.0F));
        modelPartData2.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(14, 4).addBox(-1.0F, -5.0F, 0.0F, 6.0F, 2.0F, 1.0F), PartPose.offset(0.0F, 3.0F, -1.0F));
        modelPartData2.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 0).addBox(1.0F, -4.0F, -6.0F, 1.0F, 2.0F, 6.0F), PartPose.offset(0.0F, 3.0F, -1.0F));
        modelPartData2.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 8).addBox(0.0F, -4.0F, 0.0F, 1.0F, 2.0F, 6.0F), PartPose.offset(0.0F, 3.0F, -1.0F));
        modelPartData2.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 4).addBox(4.0F, -7.0F, 0.0F, 2.0F, 1.0F, 1.0F), PartPose.offset(0.0F, 3.0F, -1.0F));
        PartDefinition modelPartData3 = modelPartData2.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(8, 4).addBox(7.0F, -2.0F, 0.0F, 2.0F, 1.0F, 1.0F).texOffs(9, 5).addBox(7.0F, -2.0F, 1.0F, 2.0F, 1.0F, 0.0F), PartPose.offset(0.0F, 3.0F, -1.0F));
        modelPartData3.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(9, 5).addBox(-9.0F, -3.0F, 0.0F, 2.0F, 1.0F, 0.0F), PartPose.offset(0.0F, 1.0F, 0.0F));
        PartDefinition modelPartData4 = modelPartData1.addOrReplaceChild("tailside", CubeListBuilder.create().texOffs(0, 2).addBox(-9.0F, 0.0F, -1.0F, 1.0F, 1.0F, 1.0F).texOffs(19, 7).addBox(-8.0F, -1.0F, -1.0F, 3.0F, 3.0F, 1.0F).texOffs(10, 17).addBox(-6.0F, 0.0F, -2.0F, 2.0F, 1.0F, 3.0F).texOffs(11, 13).addBox(-6.0F, -1.0F, -2.0F, 4.0F, 1.0F, 3.0F).texOffs(17, 17).addBox(-4.0F, -2.0F, -1.0F, 4.0F, 1.0F, 1.0F).texOffs(0, 16).addBox(-2.0F, -1.0F, -2.0F, 2.0F, 3.0F, 3.0F), PartPose.offset(0.0F, -3.0F, 1.0F));
        modelPartData4.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(23, 30).addBox(-4.0F, -6.0F, 1.0F, 3.0F, 2.0F, 0.0F), PartPose.offset(0.0F, 3.0F, -1.0F));
        modelPartData4.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(23, 30).addBox(-4.0F, -6.0F, 0.0F, 3.0F, 2.0F, 0.0F), PartPose.offset(0.0F, 3.0F, -1.0F));
        modelPartData4.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(17, 29).addBox(-4.0F, -3.0F, 1.0F, 3.0F, 2.0F, 0.0F), PartPose.offset(0.0F, 3.0F, -1.0F));
        modelPartData4.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(17, 29).addBox(-4.0F, -3.0F, 0.0F, 3.0F, 2.0F, 0.0F), PartPose.offset(0.0F, 3.0F, -1.0F));
        modelPartData4.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(8, 8).addBox(-6.0F, -3.0F, -1.0F, 4.0F, 2.0F, 3.0F), PartPose.offset(0.0F, 3.0F, -1.0F));
        return LayerDefinition.create(modelData, 32, 32);
    }

    @Override
    public void setupAnim(Chinlea entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.cube_r1.xRot = 0.0469F;
        this.cube_r1.yRot = -0.0386F;
        this.cube_r1.zRot = -0.215F;
        this.cube_r2.xRot = 0.0475F;
        this.cube_r2.yRot = -0.1693F;
        this.cube_r2.zRot = -0.2212F;
        this.cube_r3.xRot = -0.0475F;
        this.cube_r3.yRot = 0.1693F;
        this.cube_r3.zRot = -0.2212F;
        this.cube_r4.xRot = 0.0469F;
        this.cube_r4.yRot = -0.0386F;
        this.cube_r4.zRot = -0.215F;
        this.cube_r5.xRot = -0.0469F;
        this.cube_r5.yRot = 0.0386F;
        this.cube_r5.zRot = -0.215F;
        this.cube_r6.xRot = -0.0469F;
        this.cube_r6.yRot = 0.0386F;
        this.cube_r6.zRot = -0.215F;
        this.cube_r7.xRot = -3.1416F;
        this.cube_r7.zRot = 3.1416F;
        this.cube_r8.zRot = 0.1745F;
        this.cube_r9.yRot = -1.3963F;
        this.cube_r10.yRot = 1.3963F;
        this.cube_r11.zRot = 0.5672F;
        this.cube_r12.xRot = -3.1416F;
        this.cube_r12.zRot = 3.1416F;
        this.cube_r13.xRot = 0.047F;
        this.cube_r13.yRot = -0.0822F;
        this.cube_r13.zRot = -0.217F;
        this.cube_r14.xRot = -0.047F;
        this.cube_r14.yRot = 0.0822F;
        this.cube_r14.zRot = -0.217F;
        this.cube_r15.xRot = -0.0469F;
        this.cube_r15.yRot = 0.0386F;
        this.cube_r15.zRot = -0.215F;
        this.cube_r16.xRot = 0.0469F;
        this.cube_r16.yRot = -0.0386F;
        this.cube_r16.zRot = -0.215F;
        this.cube_r17.zRot = 0.0873F;
        //previously the render function, render code was moved to a method below
    }

    @Override
    public void renderToBuffer(PoseStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {

        bone.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }

    public void setRotationAngle(ModelPart bone, float x, float y, float z) {
        bone.xRot = x;
        bone.yRot = y;
        bone.zRot = z;
    }
}