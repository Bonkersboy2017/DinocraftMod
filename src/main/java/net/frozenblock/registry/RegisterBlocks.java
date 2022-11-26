package net.frozenblock.registry;

import com.dinocrew.dinocraft.Dinocraft;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.GlowLichenBlock;

public class RegisterBlocks {

    public static final GlowLichenBlock LIVERWORTS = new GlowLichenBlock(FabricBlockSettings.copyOf(Blocks.GLOW_LICHEN));
    public static final BushBlock CYCADOPHYTA = new BushBlock(FabricBlockSettings.copyOf(Blocks.GRASS));

    public static void init(String modid) {
        registerBlock(LIVERWORTS, modid, "liverworts", new FabricItemSettings().tab(Dinocraft.ITEM_GROUP));
        registerBlock(CYCADOPHYTA, modid, "cycadophyta", new FabricItemSettings().tab(Dinocraft.ITEM_GROUP));

        FlammableBlockRegistry.getDefaultInstance().add(LIVERWORTS, 15, 100);
        FlammableBlockRegistry.getDefaultInstance().add(CYCADOPHYTA, 60, 100);
    }

    private static void registerBlock(Block block, String modid, String id, Item.Properties settings) {
        Registry.register(Registry.BLOCK, new ResourceLocation(modid, id), block);
        Registry.register(Registry.ITEM, new ResourceLocation(modid, id), new BlockItem(block, settings));
    }
}
