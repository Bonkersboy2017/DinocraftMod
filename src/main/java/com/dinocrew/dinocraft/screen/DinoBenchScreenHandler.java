package com.dinocrew.dinocraft.screen;

import com.dinocrew.dinocraft.recipe.DinoBenchRecipe;
import com.dinocrew.dinocraft.registry.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ForgingScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.slot.Slot;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DinoBenchScreenHandler extends ForgingScreenHandler {
    private final World world;
    @Nullable
    private DinoBenchRecipe currentRecipe;
    private final List<DinoBenchRecipe> recipes;

    public DinoBenchScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, ScreenHandlerContext.EMPTY);
    }

    public DinoBenchScreenHandler(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(ModScreenHandlerTypes.DINO_BENCH_SCREEN_HANDLER_TYPE, syncId, playerInventory, context);
        this.world = playerInventory.player.world;
        this.recipes = this.world.getRecipeManager().listAllOfType(DinoBenchRecipe.TYPE);
    }

    protected boolean canUse(BlockState state) {
        return state.isOf(ModBlocks.DINOBENCH);
    }

    protected boolean canTakeOutput(PlayerEntity player, boolean present) {
        return this.currentRecipe != null && this.currentRecipe.matches(this.input, this.world);
    }

    protected void onTakeOutput(PlayerEntity player, ItemStack stack) {
        stack.onCraft(player.world, player, stack.getCount());
        this.output.unlockLastRecipe(player);
        this.decrementStack(0);
        this.decrementStack(1);
        this.context.run((world, pos) -> world.syncWorldEvent(1044, pos, 0));
    }

    private void decrementStack(int slot) {
        ItemStack itemStack = this.input.getStack(slot);
        itemStack.decrement(1);
        this.input.setStack(slot, itemStack);
    }

    public void updateResult() {
        List<DinoBenchRecipe> list = this.world.getRecipeManager().getAllMatches(DinoBenchRecipe.TYPE, this.input, this.world);
        if (list.isEmpty()) {
            this.output.setStack(0, ItemStack.EMPTY);
        } else {
            this.currentRecipe = list.get(0);
            ItemStack itemStack = this.currentRecipe.craft(this.input);
            this.output.setLastRecipe(this.currentRecipe);
            this.output.setStack(0, itemStack);
        }

    }

    protected boolean isUsableAsAddition(ItemStack stack) {
        return this.recipes.stream().anyMatch((recipe) -> recipe.testModifier(stack));
    }

    public boolean canInsertIntoSlot(ItemStack stack, Slot slot) {
        return slot.inventory != this.output && super.canInsertIntoSlot(stack, slot);
    }
}
