package com.dinocrew.dinocraft.registry.blocks;

import com.dinocrew.dinocraft.registry.ModFeatures;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import org.jetbrains.annotations.Nullable;

public class DragonwoodSaplingGenerator extends AbstractTreeGrower {


    public DragonwoodSaplingGenerator(Holder<ConfiguredFeature<TreeConfiguration, ?>> DRAGONWOOD) {
    }

    @Nullable
    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(net.minecraft.util.RandomSource random, boolean bees) {
        return ModFeatures.DRAGONWOOD;
    }
}