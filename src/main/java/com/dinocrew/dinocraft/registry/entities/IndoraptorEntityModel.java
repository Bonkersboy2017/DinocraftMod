package com.dinocrew.dinocraft.registry.entities;

import com.dinocrew.dinocraft.registry.ModItems;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class IndoraptorEntityModel extends EntityModel<IndoraptorEntity> {
    private final ModelPart indo;
    private final ModelPart excess_cubes;
    private final ModelPart spine0;
    private final ModelPart chest;
    private final ModelPart shoulder_l;
    private final ModelPart elbow_l;
    private final ModelPart wrist_l;
    private final ModelPart finger0_l;
    private final ModelPart finger1_l;
    private final ModelPart finger2_l;
    private final ModelPart finger3_l;
    private final ModelPart shoulder_r;
    private final ModelPart elbow_r;
    private final ModelPart wrist_r;
    private final ModelPart finger0_r;
    private final ModelPart finger1_r;
    private final ModelPart finger2_r;
    private final ModelPart finger3_r;
    private final ModelPart neck0;
    private final ModelPart neck1;
    private final ModelPart head;
    private final ModelPart jaw;
    private final ModelPart tail0;
    private final ModelPart tail1;
    private final ModelPart tail2;
    private final ModelPart tail3;
    private final ModelPart tail4;
    private final ModelPart rump_r;
    private final ModelPart hip_r;
    private final ModelPart knee_r;
    private final ModelPart ankle_r;
    private final ModelPart toe0_r;
    private final ModelPart toe1_r;
    private final ModelPart toe2_r;
    private final ModelPart rump_l;
    private final ModelPart hip_l;
    private final ModelPart knee_l;
    private final ModelPart ankle_l;
    private final ModelPart toe0_l;
    private final ModelPart toe1_l;
    private final ModelPart toe2_l;
    public IndoraptorEntityModel(ModelPart root) {
        this.indo = root.getChild("indo");
        this.rump_l = this.indo.getChild("rump_l");
        this.hip_l = this.rump_l.getChild("hip_l");
        this.knee_l = this.hip_l.getChild("knee_l");
        this.ankle_l = this.knee_l.getChild("ankle_l");
        this.toe2_l = this.ankle_l.getChild("toe2_l");
        this.toe1_l = this.ankle_l.getChild("toe1_l");
        this.toe0_l = this.ankle_l.getChild("toe0_l");
        this.rump_r = this.indo.getChild("rump_r");
        this.hip_r = this.rump_r.getChild("hip_r");
        this.knee_r = this.hip_r.getChild("knee_r");
        this.ankle_r = this.knee_r.getChild("ankle_r");
        this.toe2_r = this.ankle_r.getChild("toe2_r");
        this.toe1_r = this.ankle_r.getChild("toe1_r");
        this.toe0_r = this.ankle_r.getChild("toe0_r");
        this.tail0 = this.indo.getChild("tail0");
        this.tail1 = this.tail0.getChild("tail1");
        this.tail2 = this.tail1.getChild("tail2");
        this.tail3 = this.tail2.getChild("tail3");
        this.tail4 = this.tail3.getChild("tail4");
        this.spine0 = this.indo.getChild("spine0");
        this.chest = this.spine0.getChild("chest");
        this.neck0 = this.chest.getChild("neck0");
        this.neck1 = this.neck0.getChild("neck1");
        this.head = this.neck1.getChild("head");
        this.jaw = this.head.getChild("jaw");
        this.shoulder_r = this.chest.getChild("shoulder_r");
        this.elbow_r = this.shoulder_r.getChild("elbow_r");
        this.wrist_r = this.elbow_r.getChild("wrist_r");
        this.finger3_r = this.wrist_r.getChild("finger3_r");
        this.finger2_r = this.wrist_r.getChild("finger2_r");
        this.finger1_r = this.wrist_r.getChild("finger1_r");
        this.finger0_r = this.wrist_r.getChild("finger0_r");
        this.shoulder_l = this.chest.getChild("shoulder_l");
        this.elbow_l = this.shoulder_l.getChild("elbow_l");
        this.wrist_l = this.elbow_l.getChild("wrist_l");
        this.finger3_l = this.wrist_l.getChild("finger3_l");
        this.finger2_l = this.wrist_l.getChild("finger2_l");
        this.finger1_l = this.wrist_l.getChild("finger1_l");
        this.finger0_l = this.wrist_l.getChild("finger0_l");
        this.excess_cubes = this.indo.getChild("excess_cubes");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();


        ModelPartData modelPartData1 = modelPartData.addChild("indo", ModelPartBuilder.create(), ModelTransform.pivot(0.0F,-20.0F,21.0F));
        modelPartData1.addChild("excess_cubes", ModelPartBuilder.create().uv(49,22).cuboid(0.0F, -58.0F, 10.0F, 0.0F, 6.0F, 26.0F).uv(0,0).cuboid(-8.0F, -52.0F, 10.0F, 16.0F, 19.0F, 20.0F), ModelTransform.pivot(0.0F,44.0F,-21.0F));
        ModelPartData modelPartData2 = modelPartData1.addChild("spine0", ModelPartBuilder.create().uv(0,39).cuboid(-7.0F, -7.0F, -18.0F, 14.0F, 16.0F, 21.0F, new Dilation(0.01F)), ModelTransform.pivot(0.0F,0.0F,-10.0F));
        ModelPartData modelPartData3 = modelPartData2.addChild("chest", ModelPartBuilder.create().uv(64,86).cuboid(-8.0F, -7.0F, -16.0F, 16.0F, 16.0F, 16.0F), ModelTransform.pivot(0.0F,0.0F,-14.0F));
        ModelPartData modelPartData4 = modelPartData3.addChild("shoulder_l", ModelPartBuilder.create().uv(144,144).cuboid(-3.0F, -2.0F, -4.0F, 6.0F, 15.0F, 8.0F), ModelTransform.pivot(9.0F,3.0F,-8.0F));
        ModelPartData modelPartData5 = modelPartData4.addChild("elbow_l", ModelPartBuilder.create().uv(0,159).cuboid(-2.0F, -2.0F, -4.0F, 4.0F, 21.0F, 6.0F), ModelTransform.pivot(0.0F,12.0F,1.0F));
        ModelPartData modelPartData6 = modelPartData5.addChild("wrist_l", ModelPartBuilder.create(), ModelTransform.pivot(0.0F,17.0F,0.0F));
        modelPartData6.addChild("finger0_l", ModelPartBuilder.create().uv(130,0).cuboid(-1.0F, -1.5F, -7.5F, 2.0F, 3.0F, 9.0F).uv(93,12).cuboid(0.0F, -1.5F, -13.5F, 0.0F, 3.0F, 6.0F), ModelTransform.pivot(-2.0F,0.5F,-0.5F));
        modelPartData6.addChild("finger1_l", ModelPartBuilder.create().uv(159,159).cuboid(-1.0F, -1.5F, -11.5F, 2.0F, 3.0F, 13.0F).uv(64,92).cuboid(0.0F, -1.5F, -17.5F, 0.0F, 3.0F, 6.0F), ModelTransform.pivot(-1.0F,0.5F,-0.5F));
        modelPartData6.addChild("finger2_l", ModelPartBuilder.create().uv(152,63).cuboid(-1.0F, -1.5F, -11.5F, 2.0F, 3.0F, 13.0F).uv(93,9).cuboid(0.0F, -1.5F, -17.5F, 0.0F, 3.0F, 6.0F), ModelTransform.pivot(1.5F,0.5F,-0.5F));
        modelPartData6.addChild("finger3_l", ModelPartBuilder.create().uv(131,131).cuboid(-0.5F, -1.5F, -7.0F, 2.0F, 3.0F, 9.0F).uv(93,27).cuboid(0.5F, -1.5F, -13.0F, 0.0F, 3.0F, 6.0F), ModelTransform.pivot(2.0F,0.5F,-1.0F));
        ModelPartData modelPartData7 = modelPartData3.addChild("shoulder_r", ModelPartBuilder.create().uv(144,101).cuboid(-3.0F, -2.0F, -4.0F, 6.0F, 15.0F, 8.0F), ModelTransform.pivot(-9.0F,3.0F,-8.0F));
        ModelPartData modelPartData8 = modelPartData7.addChild("elbow_r", ModelPartBuilder.create().uv(20,159).cuboid(-2.0F, -2.0F, -4.0F, 4.0F, 21.0F, 6.0F), ModelTransform.pivot(0.0F,12.0F,1.0F));
        ModelPartData modelPartData9 = modelPartData8.addChild("wrist_r", ModelPartBuilder.create(), ModelTransform.pivot(0.0F,17.0F,0.0F));
        modelPartData9.addChild("finger0_r", ModelPartBuilder.create().uv(0,108).cuboid(-1.0F, -1.5F, -7.5F, 2.0F, 3.0F, 9.0F).uv(44,86).cuboid(0.0F, -1.5F, -13.5F, 0.0F, 3.0F, 6.0F), ModelTransform.pivot(2.0F,0.5F,-0.5F));
        modelPartData9.addChild("finger1_r", ModelPartBuilder.create().uv(38,108).cuboid(-1.0F, -1.5F, -11.5F, 2.0F, 3.0F, 13.0F).uv(56,86).cuboid(0.0F, -1.5F, -17.5F, 0.0F, 3.0F, 6.0F), ModelTransform.pivot(1.0F,0.5F,-0.5F));
        modelPartData9.addChild("finger2_r", ModelPartBuilder.create().uv(154,124).cuboid(-1.0F, -1.5F, -11.5F, 2.0F, 3.0F, 13.0F).uv(68,86).cuboid(0.0F, -1.5F, -17.5F, 0.0F, 3.0F, 6.0F), ModelTransform.pivot(-1.5F,0.5F,-0.5F));
        modelPartData9.addChild("finger3_r", ModelPartBuilder.create().uv(117,33).cuboid(-1.5F, -1.5F, -7.0F, 2.0F, 3.0F, 9.0F).uv(64,89).cuboid(-0.5F, -1.5F, -13.0F, 0.0F, 3.0F, 6.0F), ModelTransform.pivot(-2.0F,0.5F,-1.0F));
        ModelPartData modelPartData10 = modelPartData3.addChild("neck0", ModelPartBuilder.create().uv(93,0).cuboid(-4.0F, -6.0F, -20.0F, 8.0F, 12.0F, 21.0F, new Dilation(0.01F)), ModelTransform.pivot(0.0F,0.0F,-13.5F));
        ModelPartData modelPartData11 = modelPartData10.addChild("neck1", ModelPartBuilder.create().uv(133,37).cuboid(-4.0F, -6.5F, -12.5F, 8.0F, 12.0F, 14.0F).uv(89,99).cuboid(0.0F, -12.5F, -18.5F, 0.0F, 6.0F, 19.0F), ModelTransform.pivot(0.0F,0.5F,-19.5F));
        ModelPartData modelPartData12 = modelPartData11.addChild("head", ModelPartBuilder.create().uv(49,15).cuboid(-5.0F, -4.0F, -22.0F, 10.0F, 9.0F, 24.0F, new Dilation(0.01F)).uv(0,108).cuboid(-4.0F, 5.0F, -22.0F, 8.0F, 2.0F, 22.0F), ModelTransform.pivot(0.0F,-3.5F,-12.5F));
        modelPartData12.addChild("jaw", ModelPartBuilder.create().uv(90,48).cuboid(-5.0F, 1.0F, -23.0F, 10.0F, 4.0F, 23.0F).uv(105,105).cuboid(-4.0F, -1.0F, -22.8F, 8.0F, 2.0F, 23.0F, new Dilation(0.1F)).uv(0,67).cuboid(4.5F, -5.5F, -9.5F, 0.0F, 9.0F, 9.0F).uv(0,76).cuboid(-4.5F, -5.5F, -9.5F, 0.0F, 9.0F, 9.0F), ModelTransform.pivot(0.0F,4.0F,2.0F));
        ModelPartData modelPartData13 = modelPartData1.addChild("tail0", ModelPartBuilder.create().uv(112,75).cuboid(-7.0F, -7.0F, -2.0F, 14.0F, 14.0F, 12.0F), ModelTransform.pivot(0.0F,0.0F,7.0F));
        ModelPartData modelPartData14 = modelPartData13.addChild("tail1", ModelPartBuilder.create().uv(0,76).cuboid(-6.0F, -6.0F, -1.0F, 12.0F, 12.0F, 20.0F), ModelTransform.pivot(0.0F,0.0F,9.0F));
        ModelPartData modelPartData15 = modelPartData14.addChild("tail2", ModelPartBuilder.create().uv(48,54).cuboid(-5.0F, -5.0F, -1.0F, 10.0F, 10.0F, 22.0F), ModelTransform.pivot(0.0F,0.0F,18.0F));
        ModelPartData modelPartData16 = modelPartData15.addChild("tail3", ModelPartBuilder.create().uv(0,132).cuboid(-3.0F, -4.0F, -1.0F, 6.0F, 8.0F, 19.0F), ModelTransform.pivot(0.0F,0.0F,20.0F));
        modelPartData16.addChild("tail4", ModelPartBuilder.create().uv(130,12).cuboid(-2.0F, -2.0F, -1.0F, 4.0F, 4.0F, 21.0F), ModelTransform.pivot(0.0F,0.0F,17.0F));
        ModelPartData modelPartData17 = modelPartData1.addChild("rump_r", ModelPartBuilder.create().uv(102,130).cuboid(-4.0F, -5.0F, -6.0F, 8.0F, 23.0F, 13.0F), ModelTransform.pivot(-10.0F,0.0F,-1.0F));
        ModelPartData modelPartData18 = modelPartData17.addChild("hip_r", ModelPartBuilder.create().uv(68,154).cuboid(-3.0F, -0.5F, -3.0F, 6.0F, 19.0F, 6.0F, new Dilation(-0.01F)), ModelTransform.pivot(0.0F,12.0F,-3.0F));
        ModelPartData modelPartData19 = modelPartData18.addChild("knee_r", ModelPartBuilder.create().uv(0,39).cuboid(-2.0F, -1.0F, -2.0F, 4.0F, 16.0F, 4.0F), ModelTransform.pivot(0.0F,17.0F,1.0F));
        ModelPartData modelPartData20 = modelPartData19.addChild("ankle_r", ModelPartBuilder.create(), ModelTransform.pivot(0.0F,13.5F,-1.5F));
        modelPartData20.addChild("toe0_r", ModelPartBuilder.create().uv(90,43).cuboid(-0.5F, -3.5F, -16.0F, 0.0F, 6.0F, 11.0F).uv(80,0).cuboid(-1.5F, -1.5F, -10.0F, 3.0F, 4.0F, 11.0F), ModelTransform.pivot(2.5F,-1.0F,0.5F));
        modelPartData20.addChild("toe1_r", ModelPartBuilder.create().uv(159,0).cuboid(-1.5F, -2.0F, -7.75F, 3.0F, 4.0F, 9.0F).uv(66,80).cuboid(0.0F, -1.5F, -13.75F, 0.0F, 3.0F, 6.0F), ModelTransform.pivot(-0.5F,-0.5F,0.25F));
        modelPartData20.addChild("toe2_r", ModelPartBuilder.create().uv(90,60).cuboid(-1.25F, -2.0F, -6.5F, 3.0F, 4.0F, 7.0F).uv(66,83).cuboid(0.25F, -1.5F, -12.5F, 0.0F, 3.0F, 6.0F), ModelTransform.pivot(-3.5F,-0.5F,1.0F));
        ModelPartData modelPartData21 = modelPartData1.addChild("rump_l", ModelPartBuilder.create().uv(60,118).cuboid(-4.0F, -5.0F, -6.0F, 8.0F, 23.0F, 13.0F), ModelTransform.pivot(10.0F,0.0F,-1.0F));
        ModelPartData modelPartData22 = modelPartData21.addChild("hip_l", ModelPartBuilder.create().uv(44,154).cuboid(-3.0F, -0.5F, -3.0F, 6.0F, 19.0F, 6.0F, new Dilation(-0.01F)), ModelTransform.pivot(0.0F,12.0F,-3.0F));
        ModelPartData modelPartData23 = modelPartData22.addChild("knee_l", ModelPartBuilder.create().uv(0,0).cuboid(-2.0F, -1.0F, -2.0F, 4.0F, 16.0F, 4.0F), ModelTransform.pivot(0.0F,17.0F,1.0F));
        ModelPartData modelPartData24 = modelPartData23.addChild("ankle_l", ModelPartBuilder.create(), ModelTransform.pivot(0.0F,13.5F,-1.5F));
        modelPartData24.addChild("toe0_l", ModelPartBuilder.create().uv(44,75).cuboid(0.5F, -3.5F, -16.0F, 0.0F, 6.0F, 11.0F).uv(52,0).cuboid(-1.5F, -1.5F, -10.0F, 3.0F, 4.0F, 11.0F), ModelTransform.pivot(-2.5F,-1.0F,0.5F));
        modelPartData24.addChild("toe1_l", ModelPartBuilder.create().uv(31,132).cuboid(-1.5F, -2.0F, -7.75F, 3.0F, 4.0F, 9.0F).uv(52,9).cuboid(0.0F, -1.5F, -13.75F, 0.0F, 3.0F, 6.0F), ModelTransform.pivot(0.5F,-0.5F,0.25F));
        modelPartData24.addChild("toe2_l", ModelPartBuilder.create().uv(69,0).cuboid(-1.75F, -2.0F, -6.5F, 3.0F, 4.0F, 7.0F).uv(49,49).cuboid(-0.25F, -1.5F, -12.5F, 0.0F, 3.0F, 6.0F), ModelTransform.pivot(3.5F,-0.5F,1.0F));
        return TexturedModelData.of(modelData,256,256);



    }
    @Override
    public void setAngles(IndoraptorEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        //previously the render function, render code was moved to a method below
    }
    @Override
    public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){

        indo.render(matrixStack, buffer, packedLight, packedOverlay);
    }
    public void setRotationAngle(ModelPart bone, float x, float y, float z) {
        bone.pitch = x;
        bone.yaw = y;
        bone.roll = z;
    }
}