// Made with Model Converter by Globox_Z
// Generate all required imports
// Made with Blockbench 4.0.5
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports
package com.dinocrew.dinocraft.registry.entities;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class ChinleaEntityModel extends EntityModel<ChinleaEntity> {
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

    public ChinleaEntityModel(ModelPart root) {
        this.bone = root.getChild("bone");
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

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();

        ModelPartData modelPartData1 = modelPartData.addChild("bone", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
        ModelPartData modelPartData2 = modelPartData1.addChild("faceside", ModelPartBuilder.create().uv(8, 0).cuboid(0.0F, -1.0F, -1.0F, 7.0F, 3.0F, 1.0F).uv(0, 0).cuboid(7.0F, 0.0F, -1.0F, 2.0F, 1.0F, 1.0F).uv(19, 20).cuboid(0.0F, -1.0F, -2.0F, 1.0F, 3.0F, 1.0F).uv(0, 8).cuboid(0.0F, -1.0F, 0.0F, 1.0F, 3.0F, 1.0F).uv(27, 31).cuboid(7.0F, 0.0F, 0.0F, 2.0F, 1.0F, 0.0F), ModelTransform.pivot(0.0F, -3.0F, 1.0F));
        modelPartData2.addChild("cube_r1", ModelPartBuilder.create().uv(23, 30).cuboid(1.0F, -5.0F, 1.0F, 3.0F, 2.0F, 0.0F), ModelTransform.pivot(0.0F, 3.0F, -1.0F));
        modelPartData2.addChild("cube_r2", ModelPartBuilder.create().uv(0, 30).cuboid(2.0F, -2.0F, -1.0F, 3.0F, 2.0F, 0.0F), ModelTransform.pivot(0.0F, 3.0F, -1.0F));
        modelPartData2.addChild("cube_r3", ModelPartBuilder.create().uv(0, 30).cuboid(2.0F, -2.0F, 2.0F, 3.0F, 2.0F, 0.0F), ModelTransform.pivot(0.0F, 3.0F, -1.0F));
        modelPartData2.addChild("cube_r4", ModelPartBuilder.create().uv(10, 30).cuboid(0.0F, -2.0F, 0.0F, 3.0F, 2.0F, 0.0F), ModelTransform.pivot(0.0F, 3.0F, -1.0F));
        modelPartData2.addChild("cube_r5", ModelPartBuilder.create().uv(10, 30).cuboid(0.0F, -2.0F, 1.0F, 3.0F, 2.0F, 0.0F), ModelTransform.pivot(0.0F, 3.0F, -1.0F));
        modelPartData2.addChild("cube_r6", ModelPartBuilder.create().uv(23, 30).cuboid(1.0F, -5.0F, 0.0F, 3.0F, 2.0F, 0.0F), ModelTransform.pivot(0.0F, 3.0F, -1.0F));
        modelPartData2.addChild("cube_r7", ModelPartBuilder.create().uv(14, 31).cuboid(-9.0F, -3.0F, 0.0F, 2.0F, 1.0F, 0.0F), ModelTransform.pivot(0.0F, 3.0F, -1.0F));
        modelPartData2.addChild("cube_r8", ModelPartBuilder.create().uv(14, 4).cuboid(-1.0F, -5.0F, 0.0F, 6.0F, 2.0F, 1.0F), ModelTransform.pivot(0.0F, 3.0F, -1.0F));
        modelPartData2.addChild("cube_r9", ModelPartBuilder.create().uv(0, 0).cuboid(1.0F, -4.0F, -6.0F, 1.0F, 2.0F, 6.0F), ModelTransform.pivot(0.0F, 3.0F, -1.0F));
        modelPartData2.addChild("cube_r10", ModelPartBuilder.create().uv(0, 8).cuboid(0.0F, -4.0F, 0.0F, 1.0F, 2.0F, 6.0F), ModelTransform.pivot(0.0F, 3.0F, -1.0F));
        modelPartData2.addChild("cube_r11", ModelPartBuilder.create().uv(0, 4).cuboid(4.0F, -7.0F, 0.0F, 2.0F, 1.0F, 1.0F), ModelTransform.pivot(0.0F, 3.0F, -1.0F));
        ModelPartData modelPartData3 = modelPartData2.addChild("jaw", ModelPartBuilder.create().uv(8, 4).cuboid(7.0F, -2.0F, 0.0F, 2.0F, 1.0F, 1.0F).uv(9, 5).cuboid(7.0F, -2.0F, 1.0F, 2.0F, 1.0F, 0.0F), ModelTransform.pivot(0.0F, 3.0F, -1.0F));
        modelPartData3.addChild("cube_r12", ModelPartBuilder.create().uv(9, 5).cuboid(-9.0F, -3.0F, 0.0F, 2.0F, 1.0F, 0.0F), ModelTransform.pivot(0.0F, 1.0F, 0.0F));
        ModelPartData modelPartData4 = modelPartData1.addChild("tailside", ModelPartBuilder.create().uv(0, 2).cuboid(-9.0F, 0.0F, -1.0F, 1.0F, 1.0F, 1.0F).uv(19, 7).cuboid(-8.0F, -1.0F, -1.0F, 3.0F, 3.0F, 1.0F).uv(10, 17).cuboid(-6.0F, 0.0F, -2.0F, 2.0F, 1.0F, 3.0F).uv(11, 13).cuboid(-6.0F, -1.0F, -2.0F, 4.0F, 1.0F, 3.0F).uv(17, 17).cuboid(-4.0F, -2.0F, -1.0F, 4.0F, 1.0F, 1.0F).uv(0, 16).cuboid(-2.0F, -1.0F, -2.0F, 2.0F, 3.0F, 3.0F), ModelTransform.pivot(0.0F, -3.0F, 1.0F));
        modelPartData4.addChild("cube_r13", ModelPartBuilder.create().uv(23, 30).cuboid(-4.0F, -6.0F, 1.0F, 3.0F, 2.0F, 0.0F), ModelTransform.pivot(0.0F, 3.0F, -1.0F));
        modelPartData4.addChild("cube_r14", ModelPartBuilder.create().uv(23, 30).cuboid(-4.0F, -6.0F, 0.0F, 3.0F, 2.0F, 0.0F), ModelTransform.pivot(0.0F, 3.0F, -1.0F));
        modelPartData4.addChild("cube_r15", ModelPartBuilder.create().uv(17, 29).cuboid(-4.0F, -3.0F, 1.0F, 3.0F, 2.0F, 0.0F), ModelTransform.pivot(0.0F, 3.0F, -1.0F));
        modelPartData4.addChild("cube_r16", ModelPartBuilder.create().uv(17, 29).cuboid(-4.0F, -3.0F, 0.0F, 3.0F, 2.0F, 0.0F), ModelTransform.pivot(0.0F, 3.0F, -1.0F));
        modelPartData4.addChild("cube_r17", ModelPartBuilder.create().uv(8, 8).cuboid(-6.0F, -3.0F, -1.0F, 4.0F, 2.0F, 3.0F), ModelTransform.pivot(0.0F, 3.0F, -1.0F));
        return TexturedModelData.of(modelData, 32, 32);
    }

    @Override
    public void setAngles(ChinleaEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.cube_r1.pitch = 0.0469F;
        this.cube_r1.yaw = -0.0386F;
        this.cube_r1.roll = -0.215F;
        this.cube_r2.pitch = 0.0475F;
        this.cube_r2.yaw = -0.1693F;
        this.cube_r2.roll = -0.2212F;
        this.cube_r3.pitch = -0.0475F;
        this.cube_r3.yaw = 0.1693F;
        this.cube_r3.roll = -0.2212F;
        this.cube_r4.pitch = 0.0469F;
        this.cube_r4.yaw = -0.0386F;
        this.cube_r4.roll = -0.215F;
        this.cube_r5.pitch = -0.0469F;
        this.cube_r5.yaw = 0.0386F;
        this.cube_r5.roll = -0.215F;
        this.cube_r6.pitch = -0.0469F;
        this.cube_r6.yaw = 0.0386F;
        this.cube_r6.roll = -0.215F;
        this.cube_r7.pitch = -3.1416F;
        this.cube_r7.roll = 3.1416F;
        this.cube_r8.roll = 0.1745F;
        this.cube_r9.yaw = -1.3963F;
        this.cube_r10.yaw = 1.3963F;
        this.cube_r11.roll = 0.5672F;
        this.cube_r12.pitch = -3.1416F;
        this.cube_r12.roll = 3.1416F;
        this.cube_r13.pitch = 0.047F;
        this.cube_r13.yaw = -0.0822F;
        this.cube_r13.roll = -0.217F;
        this.cube_r14.pitch = -0.047F;
        this.cube_r14.yaw = 0.0822F;
        this.cube_r14.roll = -0.217F;
        this.cube_r15.pitch = -0.0469F;
        this.cube_r15.yaw = 0.0386F;
        this.cube_r15.roll = -0.215F;
        this.cube_r16.pitch = 0.0469F;
        this.cube_r16.yaw = -0.0386F;
        this.cube_r16.roll = -0.215F;
        this.cube_r17.roll = 0.0873F;
        //previously the render function, render code was moved to a method below
    }

    @Override
    public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {

        bone.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelPart bone, float x, float y, float z) {
        bone.pitch = x;
        bone.yaw = y;
        bone.roll = z;
    }
}