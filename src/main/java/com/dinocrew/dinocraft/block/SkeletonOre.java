package com.dinocrew.dinocraft.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class SkeletonOre extends Block {

    public SkeletonOre(Properties settings) {
        super(settings);
    }

    protected int getExperienceWhenMined(Random random) {
        return Mth.nextInt((net.minecraft.util.RandomSource) random, 0, 2);
    }

    public void onStacksDropped(BlockState state, ServerLevel world, BlockPos pos, ItemStack stack) {
        super.spawnAfterBreak(state, world, pos, stack, dropExperience(world, pos, stack, 2));
        if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, stack) == 0) {
        }
    }

    private boolean dropExperience(ServerLevel world, BlockPos pos, ItemStack stack, int i) {
        return dropExperience(world, pos, stack, i);
    }
}

