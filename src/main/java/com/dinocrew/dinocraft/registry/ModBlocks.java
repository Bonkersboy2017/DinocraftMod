package com.dinocrew.dinocraft.registry;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.block.DinoBenchBlock;
import com.dinocrew.dinocraft.block.DinotanerBlock;
import com.dinocrew.dinocraft.registry.blocks.*;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.client.color.world.GrassColors;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;


public class ModBlocks
{
    public static final AbstractBlock.Settings DRAGONWOOD_SETTINGS = FabricBlockSettings.copyOf ( Blocks.BIRCH_PLANKS );

    public static final OreBlock SKELETON_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE).strength (4f, 26.0f).sounds(BlockSoundGroup.STONE));

    // Now is a DinoBenchBlock
    public static final Block DINOBENCH = new DinoBenchBlock(FabricBlockSettings.copyOf ( Blocks.IRON_BLOCK ));
    public static final OreBlock BRONZIUM_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE).strength (3f, 26.0f).sounds(BlockSoundGroup.STONE));
    public static final Block BRONZIUM_BLOCK = new Block(FabricBlockSettings.copyOf ( Blocks.IRON_ORE ).requiresTool());
    public static final Block BRONZIUM_BRICKS = new Block(FabricBlockSettings.copyOf ( Blocks.BRICKS ));
    public static final GrassBlock DRAGONGRASS = new GrassBlock(FabricBlockSettings.copyOf ( Blocks.GRASS_BLOCK ).requiresTool ());
    public static final Block DINOSAUR_TEMPERED_GLASS= new GlassBlock(FabricBlockSettings.copyOf ( Blocks.GLASS ).requiresTool ());
    public static final Block FOSSILIZED_STONE = new Block(FabricBlockSettings.copyOf(Blocks.TUFF).sounds(BlockSoundGroup.STONE));
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
    public static final Block AMBER_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).strength (3f, 26.0f).sounds(BlockSoundGroup.STONE));
    public static final Block AMBER_BRICKS = new Block(FabricBlockSettings.of(Material.STONE).strength (3f, 26.0f).sounds(BlockSoundGroup.STONE));
    public static final Block AMBER_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE).strength (3f, 26.0f).sounds(BlockSoundGroup.STONE));
    public static final EggBlock DINO_EGG = new EggBlock(FabricBlockSettings.copyOf ( Blocks.TURTLE_EGG ));
    public static final EggBlock INCUBATED_DINO_EGG = new EggBlock(FabricBlockSettings.copyOf ( Blocks.TURTLE_EGG ));
    public static final Block DINOTANER = new DinotanerBlock(FabricBlockSettings.copyOf ( Blocks.IRON_BLOCK ));



    public static void registerAll()
    {
        registerBlock(SKELETON_ORE, Dinocraft.ITEM_GROUP, new Identifier(Dinocraft.MOD_ID, "skeleton_ore"));
        registerBlock(BRONZIUM_ORE, Dinocraft.ITEM_GROUP, new Identifier(Dinocraft.MOD_ID, "bronzium_ore"));
        registerBlock(AMBER_ORE, Dinocraft.ITEM_GROUP, new Identifier(Dinocraft.MOD_ID, "amber_ore"));
        // Using other registerBlock method here
        registerBlock(DINOBENCH, Dinocraft.ITEM_GROUP, new Identifier(Dinocraft.MOD_ID, "dinobench"), new Item.Settings().rarity(Rarity.RARE));
        registerBlock(BRONZIUM_BLOCK, Dinocraft.ITEM_GROUP, new Identifier(Dinocraft.MOD_ID, "bronzium_block"));
        registerBlock(BRONZIUM_BRICKS, Dinocraft.ITEM_GROUP, new Identifier(Dinocraft.MOD_ID, "bronzium_bricks"));
        registerBlock(AMBER_BLOCK, Dinocraft.ITEM_GROUP, new Identifier(Dinocraft.MOD_ID, "amber_block"));
        registerBlock(AMBER_BRICKS, Dinocraft.ITEM_GROUP, new Identifier(Dinocraft.MOD_ID, "amber_bricks"));
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
        registerBlock(DINO_EGG, Dinocraft.ITEM_GROUP, new Identifier(Dinocraft.MOD_ID, "dino_egg"), new Item.Settings().rarity(Rarity.EPIC));
        registerBlock(INCUBATED_DINO_EGG, Dinocraft.ITEM_GROUP, new Identifier(Dinocraft.MOD_ID, "incubated_dino_egg"), new Item.Settings().rarity(Rarity.EPIC));
        registerBlock(DINOTANER, Dinocraft.ITEM_GROUP, new Identifier(Dinocraft.MOD_ID, "dinotaner"), new Item.Settings().rarity(Rarity.RARE));

    }


    private static void registerBlock(Block block, ItemGroup group, Identifier ID) {
        registerBlock(block, group, ID, new Item.Settings());
    }
    private static void registerBlock(Block block, ItemGroup group, Identifier ID, Item.Settings settings) {
        Registry.register(Registry.BLOCK, ID, block);
        Registry.register(Registry.ITEM, ID, new BlockItem(block, settings.group(group)));
    }
}
