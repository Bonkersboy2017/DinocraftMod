package com.dinocrew.dinocraft.registry.entities;

import net.frozenblock.api.mathematics.AnimationAPI;
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
    private final ModelPart head;
    private final ModelPart cube_r1;
    private final ModelPart leftleg;
    private final ModelPart cube_r2;
    private final ModelPart cube_r3;
    private final ModelPart leftleg2;
    private final ModelPart cube_r4;
    private final ModelPart cube_r5;
    private final ModelPart tailprefront;
    private final ModelPart tailfront;
    private final ModelPart tailmiddle;
    private final ModelPart tailend;
    private final ModelPart tailprefrontfrails;
    private final ModelPart tailfrontfrails;
    private final ModelPart tailmiddlefrails;
    private final ModelPart bb_main;
    private final ModelPart cube_r6;
    private final ModelPart cube_r7;
    private final ModelPart cube_r8;
    private final ModelPart cube_r9;
    public TRexEntityModel(ModelPart root) {
        this.head = root.getChild("head");
        this.cube_r1 = this.head.getChild("cube_r1");
        this.leftleg = root.getChild("leftleg");
        this.cube_r3 = this.leftleg.getChild("cube_r3");
        this.cube_r2 = this.leftleg.getChild("cube_r2");
        this.leftleg2 = root.getChild("leftleg2");
        this.cube_r5 = this.leftleg2.getChild("cube_r5");
        this.cube_r4 = this.leftleg2.getChild("cube_r4");
        this.tailprefront = root.getChild("tailprefront");
        this.tailfront = root.getChild("tailfront");
        this.tailmiddle = root.getChild("tailmiddle");
        this.tailend = root.getChild("tailend");
        this.tailprefrontfrails = root.getChild("tailprefrontfrails");
        this.tailfrontfrails = root.getChild("tailfrontfrails");
        this.tailmiddlefrails = root.getChild("tailmiddlefrails");
        this.bb_main = root.getChild("bb_main");
        this.cube_r9 = this.bb_main.getChild("cube_r9");
        this.cube_r8 = this.bb_main.getChild("cube_r8");
        this.cube_r7 = this.bb_main.getChild("cube_r7");
        this.cube_r6 = this.bb_main.getChild("cube_r6");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData modelPartData1 = modelPartData.addChild("head", ModelPartBuilder.create().uv(44,119).cuboid(-6.0F, -12.0F, -15.0F, 0.0F, 11.0F, 22.0F).uv(69,0).cuboid(-6.0F, -12.0F, -15.0F, 12.0F, 1.0F, 22.0F).uv(45,82).cuboid(0.0F, -16.0F, -15.0F, 0.0F, 5.0F, 22.0F).uv(126,4).cuboid(-5.0F, -1.0F, -14.0F, 10.0F, 4.0F, 19.0F).uv(93,165).cuboid(-6.0F, -12.0F, -15.0F, 12.0F, 11.0F, 0.0F).uv(84,60).cuboid(-6.0F, -1.0F, -15.0F, 12.0F, 0.0F, 22.0F), ModelTransform.pivot(0.0F,-7.0F,-40.0F));
        modelPartData1.addChild("cube_r1", ModelPartBuilder.create().uv(0,115).cuboid(-6.0F, -12.0F, -7.0F, 0.0F, 11.0F, 22.0F), ModelTransform.pivot(0.0F,0.0F,0.0F));
        ModelPartData modelPartData2 = modelPartData.addChild("leftleg", ModelPartBuilder.create().uv(165,0).cuboid(6.0F, -3.0F, 5.0F, 8.0F, 3.0F, 10.0F).uv(0,84).cuboid(14.0F, -5.0F, -1.0F, 0.0F, 5.0F, 11.0F).uv(0,79).cuboid(6.0F, -5.0F, -1.0F, 0.0F, 5.0F, 11.0F).uv(0,74).cuboid(10.0F, -5.0F, -1.0F, 0.0F, 5.0F, 11.0F), ModelTransform.pivot(0.0F,24.0F,2.0F));
        modelPartData2.addChild("cube_r2", ModelPartBuilder.create().uv(0,85).cuboid(6.0F, -26.0F, 6.0F, 10.0F, 19.0F, 25.0F), ModelTransform.pivot(0.0F,0.0F,0.0F));
        modelPartData2.addChild("cube_r3", ModelPartBuilder.create().uv(30,152).cuboid(6.0F, 7.0F, 6.0F, 8.0F, 6.0F, 14.0F).uv(159,154).cuboid(6.0F, -3.0F, 11.0F, 9.0F, 16.0F, 9.0F), ModelTransform.pivot(0.0F,0.0F,0.0F));
        ModelPartData modelPartData3 = modelPartData.addChild("leftleg2", ModelPartBuilder.create().uv(162,69).cuboid(-14.0F, -3.0F, 5.0F, 8.0F, 3.0F, 10.0F).uv(69,5).cuboid(-14.0F, -5.0F, -1.0F, 0.0F, 5.0F, 11.0F).uv(69,0).cuboid(-6.0F, -5.0F, -1.0F, 0.0F, 5.0F, 11.0F).uv(61,49).cuboid(-10.0F, -5.0F, -1.0F, 0.0F, 5.0F, 11.0F), ModelTransform.pivot(0.0F,24.0F,2.0F));
        modelPartData3.addChild("cube_r4", ModelPartBuilder.create().uv(61,60).cuboid(-16.0F, -26.0F, 6.0F, 10.0F, 19.0F, 25.0F), ModelTransform.pivot(0.0F,0.0F,0.0F));
        modelPartData3.addChild("cube_r5", ModelPartBuilder.create().uv(147,36).cuboid(-14.0F, 7.0F, 6.0F, 8.0F, 6.0F, 14.0F).uv(123,154).cuboid(-15.0F, -3.0F, 11.0F, 9.0F, 16.0F, 9.0F), ModelTransform.pivot(0.0F,0.0F,0.0F));
        modelPartData.addChild("tailprefront", ModelPartBuilder.create().uv(0,44).cuboid(-9.0F, -37.0F, 21.0F, 18.0F, 16.0F, 25.0F), ModelTransform.pivot(0.0F,24.0F,0.0F));
        modelPartData.addChild("tailfront", ModelPartBuilder.create().uv(120,86).cuboid(-7.0F, -37.0F, 46.0F, 14.0F, 12.0F, 18.0F), ModelTransform.pivot(0.0F,24.0F,0.0F));
        modelPartData.addChild("tailmiddle", ModelPartBuilder.create().uv(73,141).cuboid(-5.0F, -37.0F, 64.0F, 10.0F, 9.0F, 15.0F), ModelTransform.pivot(0.0F,24.0F,0.0F));
        modelPartData.addChild("tailend", ModelPartBuilder.create().uv(0,159).cuboid(-3.0F, -37.0F, 79.0F, 6.0F, 6.0F, 13.0F), ModelTransform.pivot(0.0F,24.0F,0.0F));
        modelPartData.addChild("tailprefrontfrails", ModelPartBuilder.create().uv(0,104).cuboid(0.0F, -45.0F, 21.0F, 0.0F, 8.0F, 25.0F), ModelTransform.pivot(0.0F,24.0F,0.0F));
        modelPartData.addChild("tailfrontfrails", ModelPartBuilder.create().uv(120,98).cuboid(0.0F, -44.0F, 46.0F, 0.0F, 7.0F, 18.0F), ModelTransform.pivot(0.0F,24.0F,0.0F));
        modelPartData.addChild("tailmiddlefrails", ModelPartBuilder.create().uv(115,0).cuboid(0.0F, -44.0F, 64.0F, 0.0F, 7.0F, 15.0F), ModelTransform.pivot(0.0F,24.0F,0.0F));
        ModelPartData modelPartData4 = modelPartData.addChild("bb_main", ModelPartBuilder.create().uv(70,104).cuboid(-7.0F, -37.0F, -32.0F, 14.0F, 15.0F, 22.0F), ModelTransform.pivot(0.0F,24.0F,0.0F));
        modelPartData4.addChild("cube_r6", ModelPartBuilder.create().uv(130,48).cuboid(0.0F, -48.0F, -17.0F, 0.0F, 9.0F, 21.0F).uv(73,23).cuboid(-8.0F, -39.0F, -17.0F, 16.0F, 16.0F, 21.0F), ModelTransform.pivot(0.0F,0.0F,0.0F));
        modelPartData4.addChild("cube_r7", ModelPartBuilder.create().uv(0,126).cuboid(-4.0F, -20.0F, 38.0F, 0.0F, 9.0F, 22.0F).uv(126,5).cuboid(4.0F, -20.0F, 38.0F, 0.0F, 9.0F, 22.0F).uv(130,38).cuboid(0.0F, -20.0F, 38.0F, 0.0F, 9.0F, 22.0F), ModelTransform.pivot(0.0F,-31.0F,-40.0F));
        modelPartData4.addChild("cube_r8", ModelPartBuilder.create().uv(0,0).cuboid(-12.0F, -28.0F, -33.0F, 6.0F, 16.0F, 6.0F).uv(115,0).cuboid(-12.0F, -17.0F, -40.0F, 6.0F, 5.0F, 7.0F).uv(67,165).cuboid(6.0F, -17.0F, -40.0F, 6.0F, 5.0F, 7.0F).uv(0,44).cuboid(6.0F, -28.0F, -33.0F, 6.0F, 16.0F, 6.0F).uv(0,0).cuboid(-11.0F, -39.0F, -5.0F, 22.0F, 19.0F, 25.0F), ModelTransform.pivot(0.0F,0.0F,0.0F));
        modelPartData4.addChild("cube_r9", ModelPartBuilder.create().uv(124,123).cuboid(-6.0F, -8.0F, -4.0F, 12.0F, 13.0F, 18.0F), ModelTransform.pivot(0.0F,-36.0F,-37.0F));
        return TexturedModelData.of(modelData,256,256);
    }
    @Override
    public void setAngles(TRexEntity entity, float limbAngle, float limbDistance, float time, float netHeadYaw, float headPitch){
        this.head.pitch = 0.0436F;
        this.cube_r1.yaw = 3.1416F;
        this.cube_r2.pitch = 0.6109F;
        this.cube_r3.pitch = 1.1781F;
        this.cube_r4.pitch = 0.6109F;
        this.cube_r5.pitch = 1.1781F;
        this.cube_r6.pitch = 0.1309F;
        this.cube_r7.pitch = -0.0873F;
        this.cube_r8.pitch = -0.0873F;
        this.cube_r9.pitch = -0.8727F;

        animate(entity, limbAngle, limbDistance, time, netHeadYaw, headPitch);
        //previously the render function, render code was moved to a method below
    }



        private void animate(TRexEntity entity, float limbAngle, float limbDistance, float time, float netHeadYaw, float headPitch) {
        // animated Angles


         this.tailprefront.yaw = (float)Math.cos((time    )/5)/5;
         this.tailprefrontfrails.yaw = (float)Math.cos((time    )/5)/5;
         this.tailfront.yaw = (float) Math.cos((time + 1) / 5) / 5;
         this.tailfrontfrails.yaw = (float) Math.cos((time + 1) / 5) / 5;
         this.tailmiddle.yaw = (float) Math.cos((time + 2) / 5) / 5;
         this.tailmiddlefrails.yaw = (float) Math.cos((time + 2) / 5) / 5;
         this.tailend.yaw = (float) Math.cos((time + 3) / 5) / 5;
         this.leftleg.pitch = MathHelper.cos(limbAngle * 0.6662F) * 1.4F * limbDistance;
         this.leftleg2.pitch = MathHelper.cos(limbAngle * 0.6662F + 3.1415927F) * 1.4F * limbDistance;




    }
    @Override
    public void render(MatrixStack matrixStack, VertexConsumer	buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){

        head.render(matrixStack, buffer, packedLight, packedOverlay);
        leftleg.render(matrixStack, buffer, packedLight, packedOverlay);
        leftleg2.render(matrixStack, buffer, packedLight, packedOverlay);
        tailprefront.render(matrixStack, buffer, packedLight, packedOverlay);
        tailfront.render(matrixStack, buffer, packedLight, packedOverlay);
        tailmiddle.render(matrixStack, buffer, packedLight, packedOverlay);
        tailend.render(matrixStack, buffer, packedLight, packedOverlay);
        tailprefrontfrails.render(matrixStack, buffer, packedLight, packedOverlay);
        tailfrontfrails.render(matrixStack, buffer, packedLight, packedOverlay);
        tailmiddlefrails.render(matrixStack, buffer, packedLight, packedOverlay);
        bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
    }
    public void setRotationAngle(ModelPart bone, float x, float y, float z) {
        bone.pitch = x;
        bone.yaw = y;
        bone.roll = z;
    }
}
//    @Override
//    public void setAngles(TRexEntity entity, float limbAngle, float limbDistance, float time, float netHeadYaw, float headPitch) {
//        this.head.pitch = 0.0436F;
//        this.cube_r1.yaw = 3.1416F;
//        this.cube_r2.pitch = 0.6109F;
//        this.cube_r3.pitch = 1.1781F;
//        this.cube_r4.pitch = 0.6109F;
//        this.cube_r5.pitch = 1.1781F;
//        this.cube_r6.pitch = 0.1309F;
//        this.cube_r7.pitch = -0.0873F;
//        this.cube_r8.pitch = -0.0873F;
//        this.cube_r9.pitch = -0.8727F;
//
//        animate(entity, limbAngle, limbDistance, time, netHeadYaw, headPitch);
//
//        //previously the render function, render code was moved to a method below
//    }
//


//    private void animate(TRexEntity entity, float limbAngle, float limbDistance, float time, float netHeadYaw, float headPitch) {
//        // animated Angles
//
//        this.tailprefront.yaw = (float) Math.cos((time) / 5) / 5;
//        this.tailfront.yaw = (float) Math.cos((time + 1) / 5) / 5;
//        this.tailmiddle.yaw = (float) Math.cos((time + 2) / 5) / 5;
//        this.tailend.yaw = (float) Math.cos((time + 3) / 5) / 5;
//
//
//    }
