package com.dinocrew.dinocraft.block;

import com.dinocrew.dinocraft.Dinocraft;
import net.fabricmc.fabric.api.container.ContainerProviderRegistry;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.awt.*;

public class DinotanerBlock //extends BlockWithEntity
{
//    public DinotanerBlock(Settings settings) {
//        super(settings);
//    }

//    // A side effect of extending BlockWithEntity is it changes the render type to INVISIBLE, so we have to revert this
//    @Override
//    public BlockRenderType getRenderType(BlockState state) {
//        return BlockRenderType.MODEL;
//    }
//
//    // We will create the BlockEntity later.
//    @Override
//    public BlockEntity createBlockEntity(BlockView view) {
//        return new DinotanerBlockEntity();
//    }
//
//    @Override
//    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
//        if (itemStack.hasCustomName()) {
//            BlockEntity blockEntity = world.getBlockEntity(pos);
//            if (blockEntity instanceof DinotanerBlockEntity) {
//                ((DinotanerBlockEntity)blockEntity).setCustomName(itemStack.getName());
//            }
//        }
//    }
//
//    @Override
//    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
//        if (!world.isClient) {
//            BlockEntity blockEntity = world.getBlockEntity(pos);
//            if (blockEntity instanceof DinotanerBlockEntity) {
//                ContainerProviderRegistry.INSTANCE.openContainer(Dinocraft.DINOTANER, player, buf -> buf.writeBlockPos(pos));
//            }
//        }
//        return ActionResult.SUCCESS;
//    }
//
//    // Scatter the items in the chest when it is removed.
//    @Override
//    public void onBlockRemoved(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
//        if (state.getBlock() != newState.getBlock()) {
//            BlockEntity blockEntity = world.getBlockEntity(pos);
//            if (blockEntity instanceof DinotanerBlockEntity) {
//                ItemScatterer.spawn(world, pos, (DinotanerBlockEntity)blockEntity);
//                // update comparators
//                world.updateHorizontalAdjacent(pos, this);
//            }
//            super.onBlockRemoved(state, world, pos, newState, moved);
//        }
//    }
//
//    @Override
//    public boolean hasComparatorOutput(BlockState state) {
//        return true;
//    }
//
//    @Override
//    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
//        return Container.calculateComparatorOutput(world.getBlockEntity(pos));
//    }
//
//    @Nullable
//    @Override
//    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
//        return null;
    }
