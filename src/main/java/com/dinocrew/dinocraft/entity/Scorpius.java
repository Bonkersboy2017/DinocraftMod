package com.dinocrew.dinocraft.entity;

import com.dinocrew.dinocraft.registry.RegisterSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import org.jetbrains.annotations.Nullable;

public class Scorpius extends BaseDino {
    public Scorpius(EntityType<? extends Scorpius> entityType, Level world) {
        super(entityType, world);
    }

    public static boolean canSpawn(EntityType<Scorpius> type, LevelAccessor level, MobSpawnType reason, BlockPos pos, RandomSource random) {
        return true;
    }

    public static AttributeSupplier.Builder createDinoAttributes() {
        return TamableAnimal.createMobAttributes().add(Attributes.MAX_HEALTH, 16.0D).add(Attributes.MOVEMENT_SPEED, 0.30000001192092896D).add(Attributes.ATTACK_DAMAGE);
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return RegisterSounds.BIGDINO_HURT;
    }

}

