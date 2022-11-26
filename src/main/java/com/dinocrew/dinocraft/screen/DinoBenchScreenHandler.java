package com.dinocrew.dinocraft.screen;

import com.dinocrew.dinocraft.recipe.DinoBenchRecipe;
import com.dinocrew.dinocraft.registry.RegisterBlocks;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.ItemCombinerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DinoBenchScreenHandler extends ItemCombinerMenu {
    private final Level world;
    @Nullable
    private DinoBenchRecipe currentRecipe;
    private final List<DinoBenchRecipe> recipes;

    public DinoBenchScreenHandler(int syncId, Inventory playerInventory) {
        this(syncId, playerInventory, ContainerLevelAccess.NULL);
    }

    public DinoBenchScreenHandler(int syncId, Inventory playerInventory, ContainerLevelAccess context) {
        super(ModScreenHandlerTypes.DINO_BENCH_SCREEN_HANDLER_TYPE, syncId, playerInventory, context);
        this.world = playerInventory.player.level;
        this.recipes = this.world.getRecipeManager().getAllRecipesFor(DinoBenchRecipe.TYPE);
    }

    protected boolean isValidBlock(BlockState state) {
        return state.is(RegisterBlocks.DINOBENCH);
    }

    protected boolean mayPickup(Player player, boolean present) {
        return this.currentRecipe != null && this.currentRecipe.matches(this.inputSlots, this.world);
    }

    protected void onTake(Player player, ItemStack stack) {
        stack.onCraftedBy(player.level, player, stack.getCount());
        this.resultSlots.awardUsedRecipes(player);
        this.decrementStack(0);
        this.decrementStack(1);
        this.access.execute((world, pos) -> world.levelEvent(1044, pos, 0));
    }

    private void decrementStack(int slot) {
        ItemStack itemStack = this.inputSlots.getItem(slot);
        itemStack.shrink(1);
        this.inputSlots.setItem(slot, itemStack);
    }

    public void createResult() {
        List<DinoBenchRecipe> list = this.world.getRecipeManager().getRecipesFor(DinoBenchRecipe.TYPE, this.inputSlots, this.world);
        if (list.isEmpty()) {
            this.resultSlots.setItem(0, ItemStack.EMPTY);
        } else {
            this.currentRecipe = list.get(0);
            ItemStack itemStack = this.currentRecipe.assemble(this.inputSlots);
            this.resultSlots.setRecipeUsed(this.currentRecipe);
            this.resultSlots.setItem(0, itemStack);
        }

    }

    protected boolean shouldQuickMoveToAdditionalSlot(ItemStack stack) {
        return this.recipes.stream().anyMatch((recipe) -> recipe.testModifier(stack));
    }

    public boolean canTakeItemForPickAll(ItemStack stack, Slot slot) {
        return slot.container != this.resultSlots && super.canTakeItemForPickAll(stack, slot);
    }
}
