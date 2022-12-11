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
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;


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
    public static final Block WBC = new Block(FabricBlockSettings.copyOf(Blocks.TUFF).requiresCorrectToolForDrops());
    public static final Block POLISHED_FS = new Block(FabricBlockSettings.copyOf(Blocks.POLISHED_BASALT).requiresCorrectToolForDrops());
    public static final Block POLISHED_WBC = new Block(FabricBlockSettings.copyOf(Blocks.POLISHED_BASALT).requiresCorrectToolForDrops());
    public static final Block FS_BRICKS = new Block(FabricBlockSettings.copyOf(Blocks.POLISHED_BASALT).requiresCorrectToolForDrops());
    public static final Block WBC_BRICKS = new Block(FabricBlockSettings.copyOf(Blocks.POLISHED_BASALT).requiresCorrectToolForDrops());

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
    public static final DragonwoodSaplingBlock DRAGONWOOD_SAPLING = new DragonwoodSaplingBlock(new DragonwoodSaplingGenerator(RegisterFeatures.DRAGONWOOD), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING));


    public static void registerAll() {
        registerBlock(SKELETON_ORE, Dinocraft.ITEM_GROUP, Dinocraft.id("skeleton_ore"));
        registerBlock(BRONZIUM_ORE, Dinocraft.ITEM_GROUP, Dinocraft.id("bronzium_ore"));
        registerBlock(AMBER_ORE, Dinocraft.ITEM_GROUP, Dinocraft.id("amber_ore"));
        // Using other registerBlock method here
        registerBlock(DINOBENCH, Dinocraft.ITEM_GROUP, Dinocraft.id("dinobench"), new FabricItemSettings().rarity(Rarity.RARE));
        registerBlock(BRONZIUM_BLOCK, Dinocraft.ITEM_GROUP, Dinocraft.id("bronzium_block"));
        registerBlock(BRONZIUM_BRICKS, Dinocraft.ITEM_GROUP, Dinocraft.id("bronzium_bricks"));
        registerBlock(AMBER_BLOCK, Dinocraft.ITEM_GROUP, Dinocraft.id("amber_block"));
        registerBlock(AMBER_BRICKS, Dinocraft.ITEM_GROUP, Dinocraft.id("amber_bricks"));
        registerBlock(DRAGONGRASS, Dinocraft.ITEM_GROUP, Dinocraft.id("dragongrass"));
        registerBlock(DINOSAUR_TEMPERED_GLASS, Dinocraft.ITEM_GROUP, Dinocraft.id("dinosaur_tempered_glass"));
        registerBlock(FOSSILIZED_STONE, Dinocraft.ITEM_GROUP, Dinocraft.id("fossilized_stone"));
        registerBlock(WBC, Dinocraft.ITEM_GROUP, Dinocraft.id("wbc"));
        registerBlock(POLISHED_FS, Dinocraft.ITEM_GROUP, Dinocraft.id("polished_fs"));
        registerBlock(POLISHED_WBC, Dinocraft.ITEM_GROUP, Dinocraft.id("polished_wbc"));
        registerBlock(FS_BRICKS, Dinocraft.ITEM_GROUP, Dinocraft.id("fs_bricks"));
        registerBlock(WBC_BRICKS, Dinocraft.ITEM_GROUP, Dinocraft.id("wbc_bricks"));
        registerBlock(DRAGONWOOD_PLANKS, Dinocraft.ITEM_GROUP, Dinocraft.id("dragonwood_planks"));
        registerBlock(DRAGONWOOD_LOG, Dinocraft.ITEM_GROUP, Dinocraft.id("dragonwood_log"));
        registerBlock(STRIPPED_DRAGONWOOD_WOOD, Dinocraft.ITEM_GROUP, Dinocraft.id("stripped_dragonwood_wood"));
        registerBlock(STRIPPED_DRAGONWOOD_LOG, Dinocraft.ITEM_GROUP, Dinocraft.id("stripped_dragonwood_log"));
        registerBlock(DRAGONWOOD_WOOD, Dinocraft.ITEM_GROUP, Dinocraft.id("dragonwood_wood"));
        registerBlock(DRAGONWOOD_LEAVES, Dinocraft.ITEM_GROUP, Dinocraft.id("dragonwood_leaves"));
        registerBlock(DRAGONWOOD_SLAB, Dinocraft.ITEM_GROUP, Dinocraft.id("dragonwood_slab"));
        registerBlock(DRAGONWOOD_FENCE, Dinocraft.ITEM_GROUP, Dinocraft.id("dragonwood_fence"));
        registerBlock(DRAGONWOOD_STAIRS, Dinocraft.ITEM_GROUP, Dinocraft.id("dragonwood_stairs"));
        registerBlock(DRAGONWOOD_BUTTON, Dinocraft.ITEM_GROUP, Dinocraft.id("dragonwood_button"));
        registerBlock(DRAGONWOOD_PRESSURE_PLATE, Dinocraft.ITEM_GROUP, Dinocraft.id("dragonwood_pressure_plate"));
        registerBlock(DRAGONWOOD_DOOR, Dinocraft.ITEM_GROUP, Dinocraft.id("dragonwood_door"));
        registerBlock(DRAGONWOOD_TRAPDOOR, Dinocraft.ITEM_GROUP, Dinocraft.id("dragonwood_trapdoor"));
        registerBlock(DRAGONWOOD_FENCE_GATE, Dinocraft.ITEM_GROUP, Dinocraft.id("dragonwood_fence_gate"));
        registerBlockWithoutBlockItem(DRAGONWOOD_SIGN, Dinocraft.id("dragonwood_sign"));
        registerBlockWithoutBlockItem(DRAGONWOOD_WALL_SIGN, Dinocraft.id("dragonwood_wall_sign"));
        registerBlock(DRAGONWOOD_SAPLING, Dinocraft.ITEM_GROUP, Dinocraft.id("dragonwood_sapling"));
        registerBlock(DINO_EGG, Dinocraft.ITEM_GROUP, Dinocraft.id("dino_egg"), new FabricItemSettings().rarity(Rarity.EPIC));
        registerBlock(INCUBATED_DINO_EGG, Dinocraft.ITEM_GROUP, Dinocraft.id("incubated_dino_egg"), new FabricItemSettings().rarity(Rarity.EPIC));
        registerBlock(DINOTANER, Dinocraft.ITEM_GROUP, Dinocraft.id("dinotaner"), new FabricItemSettings().rarity(Rarity.RARE));


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

    private static void registerBlock(Block block, CreativeModeTab group, ResourceLocation ID) {
        registerBlock(block, group, ID, new FabricItemSettings());
    }

    private static void registerBlock(Block block, CreativeModeTab group, ResourceLocation ID, Item.Properties settings) {
        Registry.register(BuiltInRegistries.BLOCK, ID, block);
        Registry.register(BuiltInRegistries.ITEM, ID, new BlockItem(block, settings.tab(group)));
    }

    private static void registerBlockWithoutBlockItem(Block block, ResourceLocation ID) {
        Registry.register(BuiltInRegistries.BLOCK, ID, block);
    }
}
