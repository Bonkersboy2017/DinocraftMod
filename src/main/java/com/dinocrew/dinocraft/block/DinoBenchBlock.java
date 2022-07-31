package com.dinocrew.dinocraft.block;

import com.dinocrew.dinocraft.screen.DinoBenchScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.CraftingTableBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

//basically copypasted Smithing Table

public class DinoBenchBlock extends CraftingTableBlock {
    private static final Text SCREEN_TITLE = Text.translatable("container.dinocraft.dinobench");

    public DinoBenchBlock(Settings settings) {
        super(settings);
    }

    public NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
        return new SimpleNamedScreenHandlerFactory((syncId, inventory, player)
                // Made it pass your new ScreenHandler here tho
                -> new DinoBenchScreenHandler(syncId, inventory, ScreenHandlerContext.create(world, pos)), SCREEN_TITLE);
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient) {
            return ActionResult.SUCCESS;
        } else {
            player.openHandledScreen(state.createScreenHandlerFactory(world, pos));
            // Make your own stat here if it makes you happy
            /*            player.incrementStat(Stats.INTERACT_WITH_SMITHING_TABLE);*/
            return ActionResult.CONSUME;
        }
    }
}
