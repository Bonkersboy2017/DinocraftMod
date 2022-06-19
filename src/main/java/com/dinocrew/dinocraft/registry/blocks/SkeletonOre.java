package com.dinocrew.dinocraft.registry.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

import java.util.Random;

public class SkeletonOre extends Block {

    public SkeletonOre(Settings settings) {
        super(settings);
    }

    protected int getExperienceWhenMined(Random random) {
        return MathHelper.nextInt((net.minecraft.util.math.random.Random) random, 0, 2);
    }

    public void onStacksDropped(BlockState state, ServerWorld world, BlockPos pos, ItemStack stack) {
        super.onStacksDropped(state, world, pos, stack, dropExperience(world, pos, stack, 2));
        if (EnchantmentHelper.getLevel(Enchantments.SILK_TOUCH, stack) == 0) {
        }
    }

    private boolean dropExperience(ServerWorld world, BlockPos pos, ItemStack stack, int i) {
        return dropExperience(world, pos, stack, i);
    }
}

