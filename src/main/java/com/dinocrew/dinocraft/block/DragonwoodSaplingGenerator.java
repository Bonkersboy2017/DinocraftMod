package com.dinocrew.dinocraft.block;

import com.dinocrew.dinocraft.registry.RegisterFeatures;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import org.jetbrains.annotations.Nullable;

public class DragonwoodSaplingGenerator extends AbstractTreeGrower {


    public DragonwoodSaplingGenerator() {
    }

    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(net.minecraft.util.RandomSource random, boolean bees) {
        return RegisterFeatures.DRAGONWOOD;
    }
}