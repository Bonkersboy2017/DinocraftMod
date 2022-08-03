package com.dinocrew.dinocraft.registry.blocks;

import com.dinocrew.dinocraft.registry.worldgen.RegisterWorldgen;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import org.jetbrains.annotations.Nullable;

public class DragonwoodSaplingGenerator extends SaplingGenerator {


    public DragonwoodSaplingGenerator(RegistryEntry<ConfiguredFeature<TreeFeatureConfig,?>> DRAGONWOOD) {
    }

    @Nullable
    @Override
    protected RegistryEntry<? extends ConfiguredFeature<?, ?>> getTreeFeature(net.minecraft.util.math.random.Random random, boolean bees) {
        return RegisterWorldgen.DRAGONWOOD;
    }
}