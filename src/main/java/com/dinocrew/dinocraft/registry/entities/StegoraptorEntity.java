package com.dinocrew.dinocraft.registry.entities;

import com.dinocrew.dinocraft.registry.ModItems;
import com.dinocrew.dinocraft.registry.RegisterSounds;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class StegoraptorEntity extends TameableEntity {
    public StegoraptorEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
    }

    protected void initGoals() {
        this.goalSelector.add(7, new WanderAroundFarGoal(this, 0.7D));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.targetSelector.add(1, new RevengeGoal(this).setGroupRevenge(PlayerEntity.class));
        this.targetSelector.add(5, new ActiveTargetGoal<>(this, PlayerEntity.class, true));

//        this.targetSelector.add(2, new IndoraptorEntity.TargetGoal(this, PlayerEntity.class));

    }

    public static DefaultAttributeContainer.Builder createDinoAttributes() {
        return TameableEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 16.0D).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.30000001192092896D).add(EntityAttributes.GENERIC_ATTACK_DAMAGE);
    }


    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.isItemEqual(ModItems.CYAD_SEEDS.getDefaultStack())) {
            if (!player.getAbilities().creativeMode) {
                itemStack.decrement(1);
            }
            this.setOwner(player);
            this.navigation.stop();
            this.setTarget(null);
            this.setSitting(true);
            this.world.sendEntityStatus(this, (byte) 7);

            return ActionResult.SUCCESS;
        }
        return super.interactMob(player, hand);
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return RegisterSounds.DINO_IDLE;
    }

    @Override
    public SoundCategory getSoundCategory() {
        return SoundCategory.HOSTILE;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return RegisterSounds.DINO_HIT;
    }



}
