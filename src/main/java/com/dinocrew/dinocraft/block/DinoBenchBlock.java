package com.dinocrew.dinocraft.block;

import com.dinocrew.dinocraft.screen.DinoBenchScreenHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CraftingTableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

//basically copypasted Smithing Table

public class DinoBenchBlock extends CraftingTableBlock {
    private static final Component SCREEN_TITLE = Component.translatable("container.dinocraft.dinobench");

    public DinoBenchBlock(Properties settings) {
        super(settings);
    }

    public MenuProvider getMenuProvider(BlockState state, Level world, BlockPos pos) {
        return new SimpleMenuProvider((syncId, inventory, player)
                // Made it pass your new ScreenHandler here tho
                -> new DinoBenchScreenHandler(syncId, inventory, ContainerLevelAccess.create(world, pos)), SCREEN_TITLE);
    }

    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (world.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            player.openMenu(state.getMenuProvider(world, pos));
            // Make your own stat here if it makes you happy
            /*            player.incrementStat(Stats.INTERACT_WITH_SMITHING_TABLE);*/
            return InteractionResult.CONSUME;
        }
    }
}
