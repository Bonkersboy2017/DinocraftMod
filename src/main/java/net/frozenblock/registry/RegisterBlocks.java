package net.frozenblock.registry;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.registry.ModFoodComponents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractLichenBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.PlantBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegisterBlocks {

    public static final AbstractLichenBlock LIVERWORTS = new AbstractLichenBlock(FabricBlockSettings.copyOf(Blocks.GLOW_LICHEN));
    public static final PlantBlock CYCADOPHYTA = new PlantBlock(FabricBlockSettings.copyOf(Blocks.GRASS));

    public static void init(String modid) {
        registerBlock(LIVERWORTS, modid, "liverworts", new Item.Settings().group(Dinocraft.ITEM_GROUP));
        registerBlock(CYCADOPHYTA, modid, "cycadophyta", new Item.Settings().group(Dinocraft.ITEM_GROUP));
    }

    private static void registerBlock(Block block, String modid, String id, Item.Settings settings) {
        Registry.register(Registry.BLOCK, new Identifier(modid, id), block);
        Registry.register(Registry.ITEM, new Identifier(modid, id), new BlockItem(block, settings));
    }
}
