package com.dinocrew.dinocraft.registry;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.registry.blocks.*;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class ModBlocks
{
    public static final AbstractBlock.Settings DRAGONWOOD_SETTINGS = FabricBlockSettings.copyOf ( Blocks.IRON_ORE ).requiresTool ();

    public static final OreBlock SKELETON_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE).strength (12.0f, 26.0f).requiresTool().sounds(BlockSoundGroup.STONE));

    public static final Block DINOBENCH = new Block(FabricBlockSettings.copyOf ( Blocks.IRON_BLOCK ));
    public static final OreBlock BRONZIUM_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE).strength (12.0f, 26.0f).sounds(BlockSoundGroup.STONE));
    public static final Block BRONZIUM_BLOCK = new Block(FabricBlockSettings.copyOf ( Blocks.IRON_ORE ).requiresTool ());
    public static final Block BRONZIUM_BRICKS = new Block(FabricBlockSettings.copyOf ( Blocks.IRON_ORE ).requiresTool ());
    public static final Block DRAGONGRASS = new Block(FabricBlockSettings.copyOf ( Blocks.IRON_ORE ).requiresTool ());
    public static final Block DINOSAUR_TEMPERED_GLASS= new GlassBlock(FabricBlockSettings.copyOf ( Blocks.GLASS ).requiresTool ());
    public static final Block FOSSILIZED_STONE = new Block(FabricBlockSettings.copyOf(Blocks.TUFF).sounds(BlockSoundGroup.DEEPSLATE));
    public static final Block WBC = new Block(FabricBlockSettings.copyOf(Blocks.TUFF).requiresTool());
    public static final Block POLISHED_FS = new Block(FabricBlockSettings.copyOf(Blocks.POLISHED_BASALT).requiresTool());
    public static final Block POLISHED_WBC = new Block(FabricBlockSettings.copyOf(Blocks.POLISHED_BASALT).requiresTool());
    public static final Block FS_BRICKS = new Block(FabricBlockSettings.copyOf(Blocks.POLISHED_BASALT).requiresTool());
    public static final Block WBC_BRICKS = new Block(FabricBlockSettings.copyOf(Blocks.POLISHED_BASALT).requiresTool());
    public static final Block DRAGONWOOD_LOG = new PillarBlock(DRAGONWOOD_SETTINGS);
    public static final Block DRAGONWOOD_PLANKS = new Block(DRAGONWOOD_SETTINGS);
    public static final Block DRAGONWOOD_STAIRS = new CustomStair(Blocks.OAK_STAIRS.getDefaultState(), DRAGONWOOD_SETTINGS);
    public static final Block DRAGONWOOD_DOOR = new CustomDoor(DRAGONWOOD_SETTINGS);
    public static final Block STRIPPED_DRAGONWOOD_LOG = new PillarBlock(DRAGONWOOD_SETTINGS);
    public static final Block STRIPPED_DRAGONWOOD_WOOD = new PillarBlock(DRAGONWOOD_SETTINGS);
    public static final Block DRAGONWOOD_WOOD = new PillarBlock(DRAGONWOOD_SETTINGS);
    public static final Block DRAGONWOOD_FENCE = new FenceBlock(DRAGONWOOD_SETTINGS);
    public static final Block DRAGONWOOD_SLAB = new SlabBlock(DRAGONWOOD_SETTINGS);
    public static final Block DRAGONWOOD_FENCE_GATE = new FenceGateBlock(DRAGONWOOD_SETTINGS);
    public static final Block DRAGONWOOD_PRESSURE_PLATE = new CustomPressurePlate(PressurePlateBlock.ActivationRule.EVERYTHING, DRAGONWOOD_SETTINGS);
    public static final Block DRAGONWOOD_TRAPDOOR = new CustomTrapdoor(DRAGONWOOD_SETTINGS);
    public static final Block DRAGONWOOD_LEAVES = new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).nonOpaque());
    public static final Block DRAGONWOOD_BUTTON = new CustomWoodenButton(DRAGONWOOD_SETTINGS);



    public static void registerAll()
    {
        registerBlock(SKELETON_ORE, Dinocraft.ITEM_GROUP, new Identifier(Dinocraft.MOD_ID, "skeleton_ore"));
        registerBlock(BRONZIUM_ORE, Dinocraft.ITEM_GROUP, new Identifier(Dinocraft.MOD_ID, "bronzium_ore"));
        registerBlock(DINOBENCH, Dinocraft.ITEM_GROUP, new Identifier(Dinocraft.MOD_ID, "dinobench"));
        registerBlock(BRONZIUM_BLOCK, Dinocraft.ITEM_GROUP, new Identifier(Dinocraft.MOD_ID, "bronzium_block"));
        registerBlock(BRONZIUM_BRICKS, Dinocraft.ITEM_GROUP, new Identifier(Dinocraft.MOD_ID, "bronzium_bricks"));
        registerBlock(DRAGONGRASS, Dinocraft.ITEM_GROUP, new Identifier(Dinocraft.MOD_ID, "dragongrass"));
        registerBlock(DINOSAUR_TEMPERED_GLASS, Dinocraft.ITEM_GROUP, new Identifier(Dinocraft.MOD_ID, "dinosaur_tempered_glass"));
        registerBlock(FOSSILIZED_STONE, Dinocraft.ITEM_GROUP, new Identifier(Dinocraft.MOD_ID, "fossilized_stone"));
        registerBlock(WBC, Dinocraft.ITEM_GROUP, new Identifier(Dinocraft.MOD_ID, "wbc"));
        registerBlock(POLISHED_FS, Dinocraft.ITEM_GROUP, new Identifier(Dinocraft.MOD_ID, "polished_fs"));
        registerBlock(POLISHED_WBC, Dinocraft.ITEM_GROUP, new Identifier(Dinocraft.MOD_ID, "polished_wbc"));
        registerBlock(FS_BRICKS, Dinocraft.ITEM_GROUP, new Identifier(Dinocraft.MOD_ID, "fs_bricks"));
        registerBlock(WBC_BRICKS, Dinocraft.ITEM_GROUP, new Identifier(Dinocraft.MOD_ID, "wbc_bricks"));
        registerBlock(DRAGONWOOD_PLANKS, Dinocraft.ITEM_GROUP, new Identifier(Dinocraft.MOD_ID, "dragonwood_planks"));
        registerBlock(DRAGONWOOD_LOG, Dinocraft.ITEM_GROUP, new Identifier(Dinocraft.MOD_ID, "dragonwood_log"));
        registerBlock(STRIPPED_DRAGONWOOD_WOOD, Dinocraft.ITEM_GROUP, new Identifier(Dinocraft.MOD_ID, "stripped_dragonwood_wood"));
        registerBlock(STRIPPED_DRAGONWOOD_LOG, Dinocraft.ITEM_GROUP, new Identifier(Dinocraft.MOD_ID, "stripped_dragonwood_log"));
        registerBlock(DRAGONWOOD_WOOD, Dinocraft.ITEM_GROUP, new Identifier(Dinocraft.MOD_ID, "dragonwood_wood"));
        registerBlock(DRAGONWOOD_LEAVES, Dinocraft.ITEM_GROUP, new Identifier(Dinocraft.MOD_ID, "dragonwood_leaves"));
        registerBlock(DRAGONWOOD_SLAB, Dinocraft.ITEM_GROUP, new Identifier(Dinocraft.MOD_ID, "dragonwood_slab"));
        registerBlock(DRAGONWOOD_FENCE, Dinocraft.ITEM_GROUP, new Identifier(Dinocraft.MOD_ID, "dragonwood_fence"));
        registerBlock(DRAGONWOOD_STAIRS, Dinocraft.ITEM_GROUP, new Identifier(Dinocraft.MOD_ID, "dragonwood_stairs"));
        registerBlock(DRAGONWOOD_BUTTON, Dinocraft.ITEM_GROUP, new Identifier(Dinocraft.MOD_ID, "dragonwood_button"));
        registerBlock(DRAGONWOOD_PRESSURE_PLATE, Dinocraft.ITEM_GROUP, new Identifier(Dinocraft.MOD_ID, "dragonwood_pressure_plate"));
        registerBlock(DRAGONWOOD_DOOR, Dinocraft.ITEM_GROUP, new Identifier(Dinocraft.MOD_ID, "dragonwood_door"));
        registerBlock(DRAGONWOOD_TRAPDOOR, Dinocraft.ITEM_GROUP, new Identifier(Dinocraft.MOD_ID, "dragonwood_trapdoor"));
        registerBlock(DRAGONWOOD_FENCE_GATE, Dinocraft.ITEM_GROUP, new Identifier(Dinocraft.MOD_ID, "dragonwood_fence_gate"));
    }


    private static void registerBlock(Block block, ItemGroup group, Identifier ID) {
        Registry.register(Registry.BLOCK, ID, block);
        Registry.register(Registry.ITEM, ID, new BlockItem(block, new Item.Settings().group(group)));
    }
}
