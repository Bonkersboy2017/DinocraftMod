package com.dinocrew.dinocraft.registry;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.registry.blocks.*;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;   
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class ModBlocks
{
    public static final AbstractBlock.Settings DRAGONWOOD_SETTINGS = FabricBlockSettings.copyOf ( Blocks.IRON_ORE ).requiresTool ();

    public static final OreBlock SKELETON_ORE = new OreBlock(FabricBlockSettings.copyOf ( Blocks.IRON_ORE ).requiresTool());
    public static final Block DINOBENCH = new Block(FabricBlockSettings.copyOf ( Blocks.IRON_BLOCK ));
    public static final OreBlock BRONZIUM_ORE = new OreBlock(FabricBlockSettings.copyOf ( Blocks.IRON_ORE ).requiresTool ());
    public static final Block BRONZIUM_BLOCK = new Block(FabricBlockSettings.copyOf ( Blocks.IRON_ORE ).requiresTool ());
    public static final Block BRONZIUM_BRICKS = new Block(FabricBlockSettings.copyOf ( Blocks.IRON_ORE ).requiresTool ());
    public static final Block DRAGONGRASS = new Block(FabricBlockSettings.copyOf ( Blocks.IRON_ORE ).requiresTool ());
    public static final Block DINOSAUR_TEMPERED_GLASS= new GlassBlock(FabricBlockSettings.copyOf ( Blocks.GLASS ).requiresTool ());
    public static final Block FOSSILIZED_STONE = new Block(FabricBlockSettings.copyOf(Blocks.TUFF).requiresTool());
    public static final Block WBC = new Block(FabricBlockSettings.copyOf(Blocks.TUFF).requiresTool());


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
        Identifier skeletonOreID = Dinocraft.getID ( "skeleton_ore" );
        Identifier dinobenchID = Dinocraft.getID ( "dinobench" );
        Identifier bronziumOreID = Dinocraft.getID ( "bronzium_ore" );
        Identifier bronziumBlockID = Dinocraft.getID ( "bronzium_block" );
        Identifier bronziumBricksID = Dinocraft.getID ( "bronzium_bricks" );
        Identifier dragongrassID = Dinocraft.getID ( "dragongrass" );
        Identifier dinosaaurTemperedGlassID = Dinocraft.getID ( "dinosaur_tempered_glass" );
        Identifier fossilizedStoneID = Dinocraft.getID("fossilized_stone");
        Identifier waxedFossilizedStoneID = Dinocraft.getID("wbc");

        // Register the SkeletonOre block
        registerBlock(SKELETON_ORE, Dinocraft.ITEM_GROUP, skeletonOreID);
        registerBlock(BRONZIUM_ORE, Dinocraft.ITEM_GROUP, bronziumOreID);

        
        

        // Fences go in the decorations tab
        registerBlock (DINOBENCH, Dinocraft.ITEM_GROUP, dinobenchID);
        registerBlock (BRONZIUM_BLOCK, Dinocraft.ITEM_GROUP, bronziumBlockID);
        registerBlock (BRONZIUM_BRICKS, Dinocraft.ITEM_GROUP, bronziumBricksID);
        registerBlock (DRAGONGRASS, Dinocraft.ITEM_GROUP, dragongrassID);
        registerBlock (DINOSAUR_TEMPERED_GLASS, Dinocraft.ITEM_GROUP,dinosaaurTemperedGlassID );
        registerBlock(FOSSILIZED_STONE, Dinocraft.ITEM_GROUP, fossilizedStoneID);
        registerBlock(WBC, Dinocraft.ITEM_GROUP, waxedFossilizedStoneID);

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
        BlockItem item = new BlockItem(block, new Item.Settings().group ( group ));

        Registry.register ( Registry.BLOCK, ID, block );

        Registry.register ( Registry.ITEM, ID, item );
    }
}
