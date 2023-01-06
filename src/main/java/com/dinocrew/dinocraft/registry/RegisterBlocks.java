package com.dinocrew.dinocraft.registry;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.block.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.frozenblock.lib.block.api.FrozenSignBlock;
import net.frozenblock.lib.block.api.FrozenWallSignBlock;
import net.frozenblock.lib.block.api.FrozenWoodTypes;
import net.frozenblock.lib.item.api.FrozenCreativeTabs;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.BlockFamilies;
import net.minecraft.data.BlockFamily;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.item.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import java.util.ArrayList;
import java.util.Arrays;


public final class RegisterBlocks {

    private RegisterBlocks() {
        throw new UnsupportedOperationException("RegisterBlocks contains only static declarations.");
    }

    public static final DropExperienceBlock SKELETON_ORE = new DropExperienceBlock(FabricBlockSettings.of(Material.STONE).strength(4f, 26.0f).sound(SoundType.STONE));

    public static final WoodType DRAGONWOOD_WOOD_TYPE = FrozenWoodTypes.register(FrozenWoodTypes.newType("dinocraftdragonwood"));

    // Now is a DinoBenchBlock
    public static final Block DINOBENCH = new DinoBenchBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final DropExperienceBlock BRONZIUM_ORE = new DropExperienceBlock(FabricBlockSettings.of(Material.STONE).strength(3f, 26.0f).sound(SoundType.STONE));
    public static final Block BRONZIUM_BLOCK = new Block(FabricBlockSettings.copyOf(Blocks.IRON_ORE).requiresCorrectToolForDrops());
    public static final Block BRONZIUM_BRICKS = new Block(FabricBlockSettings.copyOf(Blocks.BRICKS));
    public static final GrassBlock DRAGONGRASS = new GrassBlock(FabricBlockSettings.copyOf(Blocks.GRASS_BLOCK).requiresCorrectToolForDrops());
    public static final Block DINOSAUR_TEMPERED_GLASS = new GlassBlock(FabricBlockSettings.copyOf(Blocks.GLASS).requiresCorrectToolForDrops());
    public static final Block FOSSILIZED_STONE = new Block(FabricBlockSettings.copyOf(Blocks.TUFF).sound(SoundType.STONE));
    public static final Block WAXED_FOSSILIZED_STONE = new Block(FabricBlockSettings.copyOf(Blocks.TUFF).requiresCorrectToolForDrops());
    public static final Block POLISHED_FOSSILIZED_STONE = new Block(FabricBlockSettings.copyOf(Blocks.POLISHED_BASALT).requiresCorrectToolForDrops());
    public static final Block POLISHED_WAXED_FOSSILIZED_STONE = new Block(FabricBlockSettings.copyOf(Blocks.POLISHED_BASALT).requiresCorrectToolForDrops());
    public static final Block FOSSILIZED_STONE_TILES = new Block(FabricBlockSettings.copyOf(Blocks.POLISHED_BASALT).requiresCorrectToolForDrops());
    public static final Block WAXED_FOSSILIZED_STONE_TILES = new Block(FabricBlockSettings.copyOf(Blocks.POLISHED_BASALT).requiresCorrectToolForDrops());

    // DRAGONWOOD

    public static final Block DRAGONWOOD_LOG = new RotatedPillarBlock(FabricBlockSettings.copyOf(Blocks.DARK_OAK_LOG));
    public static final Block DRAGONWOOD_PLANKS = new Block(FabricBlockSettings.copyOf(Blocks.DARK_OAK_PLANKS));
    public static final Block DRAGONWOOD_STAIRS = new StairBlock(DRAGONWOOD_PLANKS.defaultBlockState(), FabricBlockSettings.copyOf(DRAGONWOOD_PLANKS));
    public static final Block DRAGONWOOD_DOOR = new DoorBlock(FabricBlockSettings.of(Material.WOOD, DRAGONWOOD_PLANKS.defaultMaterialColor()).strength(3.0F).sounds(SoundType.WOOD).noOcclusion(), SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN);
    public static final Block STRIPPED_DRAGONWOOD_LOG = new RotatedPillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_DARK_OAK_LOG));
    public static final Block STRIPPED_DRAGONWOOD_WOOD = new RotatedPillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_DARK_OAK_WOOD));
    public static final Block DRAGONWOOD_WOOD = new RotatedPillarBlock(FabricBlockSettings.copyOf(Blocks.DARK_OAK_WOOD));
    public static final Block DRAGONWOOD_FENCE = new FenceBlock(FabricBlockSettings.copyOf(FabricBlockSettings.of(Material.WOOD, DRAGONWOOD_PLANKS.defaultMaterialColor()).strength(2.0F, 3.0F).sounds(SoundType.WOOD)));
    public static final Block DRAGONWOOD_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.DARK_OAK_SLAB));
    public static final Block DRAGONWOOD_FENCE_GATE = new FenceGateBlock(FabricBlockSettings.of(Material.WOOD, DRAGONWOOD_PLANKS.defaultMaterialColor()).strength(2.0F, 3.0F).sound(SoundType.WOOD), SoundEvents.FENCE_GATE_CLOSE, SoundEvents.FENCE_GATE_OPEN);
    public static final Block DRAGONWOOD_PRESSURE_PLATE = new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, FabricBlockSettings.of(Material.WOOD, DRAGONWOOD_PLANKS.defaultMaterialColor()).noCollission().strength(0.5F).sound(SoundType.WOOD), SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON);
    public static final Block DRAGONWOOD_TRAPDOOR = new TrapDoorBlock(FabricBlockSettings.copyOf(Blocks.DARK_OAK_TRAPDOOR), SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN);
    public static final Block DRAGONWOOD_LEAVES = new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).noOcclusion());
    public static final Block DRAGONWOOD_BUTTON = woodenButton();
    public static final Block DRAGONWOOD_SIGN = new FrozenSignBlock(FabricBlockSettings.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD), DRAGONWOOD_WOOD_TYPE, Dinocraft.id("blocks/dragonwood_sign"));
    public static final Block DRAGONWOOD_WALL_SIGN = new FrozenWallSignBlock(FabricBlockSettings.of(Material.WOOD).noCollission().strength(1.0F).sound(SoundType.WOOD).dropsLike(DRAGONWOOD_SIGN), DRAGONWOOD_WOOD_TYPE, Dinocraft.id("blocks/dragonwood_sign"));
    public static final Block AMBER_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).strength(3f, 26.0f).sound(SoundType.STONE));
    public static final Block AMBER_BRICKS = new Block(FabricBlockSettings.of(Material.STONE).strength(3f, 26.0f).sound(SoundType.STONE));
    public static final Block AMBER_ORE = new DropExperienceBlock(FabricBlockSettings.of(Material.STONE).strength(3f, 26.0f).sound(SoundType.STONE));
    public static final EggBlock DINO_EGG = new EggBlock(FabricBlockSettings.copyOf(Blocks.TURTLE_EGG));
    public static final EggBlock INCUBATED_DINO_EGG = new EggBlock(FabricBlockSettings.copyOf(Blocks.TURTLE_EGG));
    public static final Block DINOTANER = new DinotanerBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
    public static final DragonwoodSaplingBlock DRAGONWOOD_SAPLING = new DragonwoodSaplingBlock(FabricBlockSettings.copyOf(Blocks.OAK_SAPLING));


    public static void registerAll() {
        registerBlock(true, "skeleton_ore", SKELETON_ORE, CreativeModeTabs.NATURAL_BLOCKS);
        registerBlock(true, "bronzium_ore", BRONZIUM_ORE, CreativeModeTabs.NATURAL_BLOCKS);
        registerBlock(true, "amber_ore", AMBER_ORE, CreativeModeTabs.NATURAL_BLOCKS);
        registerBlock(false, "dinobench", DINOBENCH);
        registerBlock(true, "bronzium_block", BRONZIUM_BLOCK, CreativeModeTabs.BUILDING_BLOCKS);
        registerBlock(true, "bronzium_bricks", BRONZIUM_BRICKS, CreativeModeTabs.BUILDING_BLOCKS);
        registerBlock(true, "amber_block", AMBER_BLOCK, CreativeModeTabs.BUILDING_BLOCKS);
        registerBlock(true, "amber_bricks", AMBER_BRICKS, CreativeModeTabs.BUILDING_BLOCKS);
        registerBlock(true, "dragongrass", DRAGONGRASS, CreativeModeTabs.NATURAL_BLOCKS);
        registerBlock(true, "dinosaur_tempered_glass", DINOSAUR_TEMPERED_GLASS, CreativeModeTabs.BUILDING_BLOCKS);
        registerBlock(true, "fossilized_stone", FOSSILIZED_STONE, CreativeModeTabs.BUILDING_BLOCKS, CreativeModeTabs.NATURAL_BLOCKS);
        registerBlock(true, "waxed_fossilized_stone", WAXED_FOSSILIZED_STONE, CreativeModeTabs.BUILDING_BLOCKS);
        registerBlock(true, "polished_fossilized_stone", POLISHED_FOSSILIZED_STONE, CreativeModeTabs.BUILDING_BLOCKS);
        registerBlock(true, "polished_waxed_fossilized_stone", POLISHED_WAXED_FOSSILIZED_STONE, CreativeModeTabs.BUILDING_BLOCKS);
        registerBlock(true, "fossilized_stone_tiles", FOSSILIZED_STONE_TILES, CreativeModeTabs.BUILDING_BLOCKS);
        registerBlock(true, "waxed_fossilized_stone_tiles", WAXED_FOSSILIZED_STONE_TILES, CreativeModeTabs.BUILDING_BLOCKS);
        registerBlock(true, "dragonwood_planks", DRAGONWOOD_PLANKS, CreativeModeTabs.BUILDING_BLOCKS);
        registerBlock(true, "dragonwood_log", DRAGONWOOD_LOG, CreativeModeTabs.BUILDING_BLOCKS, CreativeModeTabs.NATURAL_BLOCKS);
        registerBlock(true, "stripped_dragonwood_log", STRIPPED_DRAGONWOOD_LOG, CreativeModeTabs.BUILDING_BLOCKS);
        registerBlock(true, "dragonwood_wood", DRAGONWOOD_WOOD, CreativeModeTabs.BUILDING_BLOCKS);
        registerBlock(true, "stripped_dragonwood_wood", STRIPPED_DRAGONWOOD_WOOD, CreativeModeTabs.BUILDING_BLOCKS);
        registerBlock(true, "dragonwood_leaves", DRAGONWOOD_LEAVES, CreativeModeTabs.BUILDING_BLOCKS);
        registerBlock(true, "dragonwood_slab", DRAGONWOOD_SLAB, CreativeModeTabs.BUILDING_BLOCKS);
        registerBlock(true, "dragonwood_fence", DRAGONWOOD_FENCE, CreativeModeTabs.BUILDING_BLOCKS);
        registerBlock(true, "dragonwood_stairs", DRAGONWOOD_STAIRS, CreativeModeTabs.BUILDING_BLOCKS);
        registerBlock(true, "dragonwood_button", DRAGONWOOD_BUTTON, CreativeModeTabs.BUILDING_BLOCKS);
        registerBlock(true, "dragonwood_pressure_plate", DRAGONWOOD_PRESSURE_PLATE, CreativeModeTabs.BUILDING_BLOCKS);
        registerBlock(true, "dragonwood_door", DRAGONWOOD_DOOR, CreativeModeTabs.BUILDING_BLOCKS);
        registerBlock(true, "dragonwood_trapdoor", DRAGONWOOD_TRAPDOOR, CreativeModeTabs.BUILDING_BLOCKS);
        registerBlock(true, "dragonwood_fence_gate", DRAGONWOOD_FENCE_GATE, CreativeModeTabs.BUILDING_BLOCKS);
        registerBlock(false, "dragonwood_sign", DRAGONWOOD_SIGN, CreativeModeTabs.FUNCTIONAL_BLOCKS);
        registerBlock(false, "dragonwood_wall_sign", DRAGONWOOD_WALL_SIGN, CreativeModeTabs.FUNCTIONAL_BLOCKS);
        registerBlock(true, "dragonwood_sapling", DRAGONWOOD_SAPLING, CreativeModeTabs.NATURAL_BLOCKS);
        registerBlock(false, "dino_egg",  DINO_EGG);
        registerBlock(false, "incubated_dino_egg",  INCUBATED_DINO_EGG);
        registerBlock(false, "dinotaner", DINOTANER);


        FlammableBlockRegistry.getDefaultInstance().add(DRAGONWOOD_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(DRAGONWOOD_SLAB, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(DRAGONWOOD_FENCE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(DRAGONWOOD_FENCE_GATE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(DRAGONWOOD_STAIRS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(DRAGONWOOD_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(STRIPPED_DRAGONWOOD_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(STRIPPED_DRAGONWOOD_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(DRAGONWOOD_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(DRAGONWOOD_LEAVES, 30, 60);

        StrippableBlockRegistry.register(DRAGONWOOD_LOG, STRIPPED_DRAGONWOOD_LOG);
        StrippableBlockRegistry.register(DRAGONWOOD_WOOD, STRIPPED_DRAGONWOOD_WOOD);
    }

    public static final BlockFamily DRAGONWOOD = BlockFamilies.familyBuilder(DRAGONWOOD_PLANKS)
            .button(DRAGONWOOD_BUTTON)
            .slab(DRAGONWOOD_SLAB)
            .stairs(DRAGONWOOD_STAIRS)
            .fence(DRAGONWOOD_FENCE)
            .fenceGate(DRAGONWOOD_FENCE_GATE)
            .pressurePlate(DRAGONWOOD_PRESSURE_PLATE)
            .sign(DRAGONWOOD_SIGN, DRAGONWOOD_WALL_SIGN)
            .door(DRAGONWOOD_DOOR)
            .trapdoor(DRAGONWOOD_TRAPDOOR)
            .recipeGroupPrefix("wooden")
            .recipeUnlockedBy("has_planks")
            .getFamily();

    private static RotatedPillarBlock log(MaterialColor topColor, MaterialColor barkColor) {
        return new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, (state) -> {
            return state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topColor : barkColor;
        }).strength(2.0F).sound(SoundType.WOOD));
    }

    private static RotatedPillarBlock log(MaterialColor uprightColor, MaterialColor sidewaysColor, SoundType soundGroup, FeatureFlag... flags) {
        return new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, (state) -> {
            return state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? uprightColor : sidewaysColor;
        }).strength(2.0F).sound(soundGroup).requiredFeatures(flags));
    }

    private static ButtonBlock woodenButton() {
        return woodenButton(SoundEvents.WOODEN_BUTTON_CLICK_OFF, SoundEvents.WOODEN_BUTTON_CLICK_ON);
    }

    private static ButtonBlock woodenButton(SoundEvent offSound, SoundEvent onSound) {
        return new ButtonBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(0.5F).sound(SoundType.WOOD), 30, true, offSound, onSound);
    }

    private static Boolean never(BlockState state, BlockGetter blockGetter, BlockPos pos, EntityType<?> entity) {
        return false;
    }

    private static Boolean always(BlockState state, BlockGetter blockGetter, BlockPos pos, EntityType<?> entity) {
        return true;
    }

    private static void registerBlock(boolean registerBlockItem, String path, Block block, CreativeModeTab... tabs) {
        if (registerBlockItem) {
            registerBlockItem(path, block, tabs);
        }
        actualRegisterBlock(path, block);
    }

    private static void registerBlockBefore(boolean registerBlockItem, ItemLike comparedItem, String path, Block block, CreativeModeTab... tabs) {
        if (registerBlockItem) {
            registerBlockItemBefore(comparedItem, path, block, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS, tabs);
        }
        actualRegisterBlock(path, block);
    }

    private static void registerBlockAfter(boolean registerBlockItem, ItemLike comparedItem, String path, Block block, CreativeModeTab... tabs) {
        if (registerBlockItem) {
            registerBlockItemAfter(comparedItem, path, block, tabs);
        }
        actualRegisterBlock(path, block);
    }

    private static void registerBlockItem(String path, Block block, CreativeModeTab... tabs) {
        actualRegisterBlockItem(path, block);
        var added = new ArrayList<>(Arrays.stream(tabs).toList());
        added.add(Dinocraft.ITEM_GROUP);
        FrozenCreativeTabs.add(block, added.toArray(new CreativeModeTab[]{}));
    }

    private static void registerBlockItemBefore(ItemLike comparedItem, String name, Block block, CreativeModeTab... tabs) {
        registerBlockItemBefore(comparedItem, name, block, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS, tabs);
    }

    private static void registerBlockItemBefore(ItemLike comparedItem, String path, Block block, CreativeModeTab.TabVisibility tabVisibility, CreativeModeTab... tabs) {
        actualRegisterBlockItem(path, block);
        var added = new ArrayList<>(Arrays.stream(tabs).toList());
        added.add(Dinocraft.ITEM_GROUP);
        FrozenCreativeTabs.addBefore(comparedItem, block, tabVisibility, added.toArray(new CreativeModeTab[]{}));
    }

    private static void registerBlockItemAfter(ItemLike comparedItem, String name, Block block, CreativeModeTab... tabs) {
        registerBlockItemAfter(comparedItem, name, block, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS, tabs);
    }

    private static void registerBlockItemAfter(ItemLike comparedItem, String path, Block block, CreativeModeTab.TabVisibility visibility, CreativeModeTab... tabs) {
        actualRegisterBlockItem(path, block);
        var added = new ArrayList<>(Arrays.stream(tabs).toList());
        added.add(Dinocraft.ITEM_GROUP);
        FrozenCreativeTabs.addAfter(comparedItem, block, visibility, added.toArray(new CreativeModeTab[]{}));
    }

    private static void actualRegisterBlock(String path, Block block) {
        if (BuiltInRegistries.BLOCK.getOptional(Dinocraft.id(path)).isEmpty()) {
            Registry.register(BuiltInRegistries.BLOCK, Dinocraft.id(path), block);
        }
    }

    private static void actualRegisterBlockItem(String path, Block block) {
        if (BuiltInRegistries.ITEM.getOptional(Dinocraft.id(path)).isEmpty()) {
            Registry.register(BuiltInRegistries.ITEM, Dinocraft.id(path), new BlockItem(block, new FabricItemSettings()));
        }
    }
}
