package net.frozenblock.registry;

import com.dinocrew.dinocraft.Dinocraft;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.GlowLichenBlock;
import net.minecraft.block.PlantBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class RegisterBlocks {

    public static final GlowLichenBlock LIVERWORTS = new GlowLichenBlock(QuiltBlockSettings.copyOf(Blocks.GLOW_LICHEN));
    public static final PlantBlock CYCADOPHYTA = new PlantBlock(QuiltBlockSettings.copyOf(Blocks.GRASS));

    public static void init(String modid) {
        registerBlock(LIVERWORTS, modid, "liverworts", new QuiltItemSettings().group(Dinocraft.ITEM_GROUP));
        registerBlock(CYCADOPHYTA, modid, "cycadophyta", new QuiltItemSettings().group(Dinocraft.ITEM_GROUP));

        FlammableBlockRegistry.getDefaultInstance().add(LIVERWORTS, 15, 100);
        FlammableBlockRegistry.getDefaultInstance().add(CYCADOPHYTA, 60, 100);
    }

    private static void registerBlock(Block block, String modid, String id, Item.Settings settings) {
        Registry.register(Registry.BLOCK, new Identifier(modid, id), block);
        Registry.register(Registry.ITEM, new Identifier(modid, id), new BlockItem(block, settings));
    }
}
