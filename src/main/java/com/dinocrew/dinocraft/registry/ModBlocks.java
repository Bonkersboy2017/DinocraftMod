package com.dinocrew.dinocraft.registry;

import com.dinocrew.dinocraft.Dinocraft;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;   
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class ModBlocks
{
    public static final OreBlock SKELETON_ORE = new OreBlock
            (
                    FabricBlockSettings.copyOf ( Blocks.IRON_ORE )
                            .breakByTool ( FabricToolTags.PICKAXES, 2 )
                            .requiresTool ()
            );
    

    public static final Block DINOBENCH = new Block
            (
                    FabricBlockSettings.copyOf ( Blocks.IRON_BLOCK )
                            .breakByTool ( FabricToolTags.AXES )
            );
    public static final OreBlock BRONZIUM_ORE = new OreBlock
            (
                    FabricBlockSettings.copyOf ( Blocks.IRON_ORE )
                            .breakByTool ( FabricToolTags.PICKAXES, 2 )
                            .requiresTool ()
            );
    public static final Block BRONZIUM_BLOCK = new Block
            (
                    FabricBlockSettings.copyOf ( Blocks.IRON_ORE )
                            .breakByTool ( FabricToolTags.PICKAXES, 2 )
                            .requiresTool ()
            );
    public static final Block BRONZIUM_BRICKS = new Block
            (
                    FabricBlockSettings.copyOf ( Blocks.IRON_ORE )
                            .breakByTool ( FabricToolTags.PICKAXES, 2 )
                            .requiresTool ()
            );
    public static final Block DRAGONWOOD_LOG = new Block
            (
                    FabricBlockSettings.copyOf ( Blocks.IRON_ORE )
                            .breakByTool ( FabricToolTags.PICKAXES, 2 )
                            .requiresTool ()
            );
    public static final Block DRAGONWOOD_PLANKS = new Block
            (
                    FabricBlockSettings.copyOf ( Blocks.IRON_ORE )
                            .breakByTool ( FabricToolTags.PICKAXES, 2 )
                            .requiresTool ()
            );
    public static final Block STRIPPED_DRAGONWOOD_LOG = new Block
            (
                    FabricBlockSettings.copyOf ( Blocks.IRON_ORE )
                            .breakByTool ( FabricToolTags.PICKAXES, 2 )
                            .requiresTool ()
            );
    public static final Block DRAGONWOOD_LEAVES= new Block
            (
                    FabricBlockSettings.copyOf ( Blocks.IRON_ORE )
                            .breakByTool ( FabricToolTags.PICKAXES, 2 )
                            .requiresTool ()
                            .nonOpaque()
            );
    public static final Block DRAGONGRASS = new Block
            (
                    FabricBlockSettings.copyOf ( Blocks.IRON_ORE )
                            .breakByTool ( FabricToolTags.PICKAXES, 2 )
                            .requiresTool ()
            );
    public static final Block DRAGONWOOD_DOOR =  new Block
            (
                    FabricBlockSettings.copyOf ( Blocks.IRON_ORE )
                            .breakByTool ( FabricToolTags.PICKAXES, 2 )
                            .requiresTool ()
            );
//    public static final TrapdoorBlock DRAGONWOOD_TRAPDOOR = (TrapdoorBlock) new Block
//            (
//                    FabricBlockSettings.copyOf ( Blocks.IRON_ORE )
//                            .breakByTool ( FabricToolTags.PICKAXES, 2 )
//                            .requiresTool ()
//            );


    public static void registerAll()
    {
        Identifier skeletonOreID = Dinocraft.getID ( "skeleton_ore" );
        Identifier dinobenchID = Dinocraft.getID ( "dinobench" );
        Identifier bronziumOreID = Dinocraft.getID ( "bronzium_ore" );
        Identifier bronziumBlockID = Dinocraft.getID ( "bronzium_block" );
        Identifier bronziumBricksID = Dinocraft.getID ( "bronzium_bricks" );
        Identifier dragonwoodLogID = Dinocraft.getID ( "dragonwood_log" );
        Identifier dragonwoodPlanksID = Dinocraft.getID ( "dragonwood_planks" );
        Identifier strippedDragonwoodLogID = Dinocraft.getID ( "stripped_dragonwood_log" );
        Identifier dragonwoodLeavesID = Dinocraft.getID ( "dragonwood_leaves" );
        Identifier dragongrassID = Dinocraft.getID ( "dragongrass" );

        Identifier dragonwoodDoorID = Dinocraft.getID ( "dragonwood_door" );
//        Identifier dragonwoodTrapdoorID = Dinocraft.getID ( "dragonwood_trapdoor" );

        // Register the SkeletonOre block
        registerBlock ( SKELETON_ORE,
                Dinocraft.ITEM_GROUP,
                skeletonOreID
        );
        registerBlock ( BRONZIUM_ORE,
                Dinocraft.ITEM_GROUP,
                bronziumOreID
        );

        /* Register the skeleton one to spawn from levels 0-16, in groups of 9,
         * once per chunk
         */
        ModFeatures.registerOverworldOreUniform ( SKELETON_ORE, /* Even though SKELETON_ORE
                 * is private, it can still
                 * be passed to other classes
                 */
                0,
                16,
                9,
                1,
                skeletonOreID
        );
        
        

        // Fences go in the decorations tab
        registerBlock ( DINOBENCH,
                Dinocraft.ITEM_GROUP,
                dinobenchID
        );
        registerBlock ( BRONZIUM_BLOCK,
                Dinocraft.ITEM_GROUP,
                bronziumBlockID
        );
        registerBlock ( BRONZIUM_BRICKS,
                Dinocraft.ITEM_GROUP,
                bronziumBricksID
        );

                registerBlock ( DRAGONWOOD_LOG,
                Dinocraft.ITEM_GROUP,
                dragonwoodLogID
        );

        registerBlock ( DRAGONWOOD_PLANKS,
                Dinocraft.ITEM_GROUP,
                dragonwoodPlanksID
        );

        registerBlock ( STRIPPED_DRAGONWOOD_LOG,
                Dinocraft.ITEM_GROUP,
                strippedDragonwoodLogID
        );

        registerBlock ( DRAGONWOOD_LEAVES,
                Dinocraft.ITEM_GROUP,
                dragonwoodLeavesID);

        registerBlock ( DRAGONGRASS,
                Dinocraft.ITEM_GROUP,
                dragongrassID);

        registerBlock ( DRAGONWOOD_DOOR,
                Dinocraft.ITEM_GROUP,
                dragonwoodDoorID
        );
//        registerBlock ( DRAGONWOOD_TRAPDOOR,
//                Dinocraft.ITEM_GROUP,
//                dragonwoodTrapdoorID
//        );
    }


    private static void registerBlock ( Block block,     // The block being registered
                                        ItemGroup group, // The group in the creative tab
                                        Identifier ID    // The Identifier for the registry
    )
    {
        // Create a BlockItem in the provided ItemGroup
        // This helps determine which creative tab to put the item into
        BlockItem item = new BlockItem
                (
                        block,
                        new Item.Settings().group ( group )
                );

        // Adds the unique ID for the block to appear in the 3D world
        Registry.register ( Registry.BLOCK, ID, block );

        // Adds the unique ID for the block to appear in an inventory
        Registry.register ( Registry.ITEM, ID, item );
    }

    public static void registerBlocks() {
    }
}
