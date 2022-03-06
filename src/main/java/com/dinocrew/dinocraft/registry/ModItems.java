package com.dinocrew.dinocraft.registry;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.armour.BaseArmour;
import com.dinocrew.dinocraft.armour.BronziumArmourMaterial;
import com.dinocrew.dinocraft.armour.SkeletonArmourMaterial;
import com.dinocrew.dinocraft.registry.items.DragonwoodBoatItem;
import com.dinocrew.dinocraft.registry.weapons.*;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item ALLOSAURUS_SKULL = new Item(new Item.Settings().group(Dinocraft.ITEM_GROUP));
    public static final Item BARYONYX_SKULL = new Item(new Item.Settings().group(Dinocraft.ITEM_GROUP));
    public static final Item CARNOTAURUS_SKULL = new Item(new Item.Settings().group(Dinocraft.ITEM_GROUP));
    public static final Item DINO_KIDNEY = new Item(new Item.Settings().group(Dinocraft.ITEM_GROUP));
    public static final Item BERRIES = new Item(new Item.Settings().group(Dinocraft.ITEM_GROUP).food(ModFoodComponents.BERRIES));
    public static final Item INFECTED_BERRIES = new Item(new Item.Settings().group(Dinocraft.ITEM_GROUP).food(ModFoodComponents.INFECTED_BERRIES));
    public static final Item DINO_SKELETON_JAW = new Item(new Item.Settings().group(Dinocraft.ITEM_GROUP));
    public static final Item RAW_DINO_FLESH = new Item(new Item.Settings().group(Dinocraft.ITEM_GROUP));
    public static final Item DINO_FLESH = new Item(new Item.Settings().group(Dinocraft.ITEM_GROUP).food(ModFoodComponents.DINO_FLESH));
    public static final Item PILL = new Item(new Item.Settings().group(Dinocraft.ITEM_GROUP));
    public static final Item FOSSIL = new Item(new Item.Settings().group(Dinocraft.ITEM_GROUP));
    public static final ArmorMaterial SKELETON_ARMOUR = new SkeletonArmourMaterial();
    public static final ArmorMaterial BRONZIUM_ARMOUR = new BronziumArmourMaterial();
    public static final Item CYAD_SEEDS = new Item(new Item.Settings().group(Dinocraft.ITEM_GROUP).food(ModFoodComponents.CYAD_SEEDS));
    public static final Item ROTTING_CYADS = new Item(new Item.Settings().group(Dinocraft.ITEM_GROUP).food(ModFoodComponents.ROTTING_CYADS));
    public static final Item CYAD_LEAF = new Item(new Item.Settings().group(Dinocraft.ITEM_GROUP).food(ModFoodComponents.CYAD_LEAF));
    public static final Item BRONZIUM_INGOT = new Item(new Item.Settings().group(Dinocraft.ITEM_GROUP));
    //public static final Item THEM_CHILLI = new Item(new Item.Settings().group(Dinocraft.ITEM_GROUP));
    //public static final Item DEMME_BERRIES = new Item(new Item.Settings().group(Dinocraft.ITEM_GROUP));
    public static final Item TIME_FLINT = new Item(new Item.Settings().group(Dinocraft.ITEM_GROUP));
    public static final Item WYVERN_CRYSTAL = new Item(new Item.Settings().group(Dinocraft.ITEM_GROUP));
    public static final Item SAUROPOD_SPAWN_EGG = new SpawnEggItem(ModEntities.SAUROPOD, 25600, 9498256, new Item.Settings().group(Dinocraft.ITEM_GROUP));
    public static final Item THEROPOD_SPAWN_EGG = new SpawnEggItem(ModEntities.THEROPOD, 167475200, 16777215, new Item.Settings().group(Dinocraft.ITEM_GROUP));
    public static final Item TROODON_SPAWN_EGG = new SpawnEggItem(ModEntities.TROODON, 0x5c4033, 16753920, new Item.Settings().group(Dinocraft.ITEM_GROUP));
    public static final Item MICORAPTOR_SPAWN_EGG = new SpawnEggItem(ModEntities.MICRORAPTOR, 16753920, 132957, new Item.Settings().group(Dinocraft.ITEM_GROUP));
    public static final Item MOSASAURUS_SPAWN_EGG = new SpawnEggItem(ModEntities.MOSASAURUS, 11393254, 9498256, new Item.Settings().group(Dinocraft.ITEM_GROUP));
    public static final Item CHINLEA_SPAWN_EGG = new SpawnEggItem(ModEntities.CHINLEA, 144238144, 0xFFFFFF, new Item.Settings().group(Dinocraft.ITEM_GROUP));
    public static final Item STEGORAPTOR_SPAWN_EGG = new SpawnEggItem(ModEntities.STEGORAPTOR, 25600, 139, new Item.Settings().group(Dinocraft.ITEM_GROUP));
    public static final Item DEINONYCHUS_SPAWN_EGG = new SpawnEggItem(ModEntities.DEINONYCHUS, 167475200, 16753920, new Item.Settings().group(Dinocraft.ITEM_GROUP));
    public static final Item DINOSTEEL_INGOT = new Item(new Item.Settings().group(Dinocraft.ITEM_GROUP));
    public static Item SHARD_OF_ENLIGHTENMENT = new Item(new Item.Settings().group(Dinocraft.ITEM_GROUP));
    public static Item TROPICAL_BERRIES = new Item(new Item.Settings().group(Dinocraft.ITEM_GROUP).food(ModFoodComponents.TROPICAL_BERRIES));
    public static Item ENLIGHTENED_CORE = new Item(new Item.Settings().group(Dinocraft.ITEM_GROUP));
    public static Item ENLIGHTENED_NECKLACE = new Item(new Item.Settings().group(Dinocraft.ITEM_GROUP));
    public static Item DRAGONWOOD_BOAT = new DragonwoodBoatItem(new Item.Settings().group(Dinocraft.ITEM_GROUP));
    public static Item EMPTY_DNA_BOTTLE = new Item(new Item.Settings().group(Dinocraft.ITEM_GROUP));
    public static Item DNA_BOTTLE = new Item(new Item.Settings().group(Dinocraft.ITEM_GROUP));
    public static Item MYSTERIOUS_DNA_BOTTLE = new Item(new Item.Settings().group(Dinocraft.ITEM_GROUP));
    public static Item INFLAMED_DNA_BOTTLE = new Item(new Item.Settings().group(Dinocraft.ITEM_GROUP));
    public static final Item DINO_FEATHER = new Item(new Item.Settings().group(Dinocraft.ITEM_GROUP));










    public static void registerAll() {
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "allosaurus_skull"), ALLOSAURUS_SKULL);
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "baryonyx_skull"), BARYONYX_SKULL);
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "carnotaurus_skull"), CARNOTAURUS_SKULL);
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "berries"), BERRIES);
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "infected_berries"), INFECTED_BERRIES);
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "tropical_berries"),TROPICAL_BERRIES);
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "cyad_seeds"), CYAD_SEEDS);
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "rotting_cyads"), ROTTING_CYADS);
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "cyad_leaf"), CYAD_LEAF);
        //Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "them_chilli"), THEM_CHILLI);
        //Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "demme_berries"), DEMME_BERRIES);
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "dino_kidney"), DINO_KIDNEY);
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "dino_skeleton_jaw"), DINO_SKELETON_JAW);
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "raw_dino_flesh"), RAW_DINO_FLESH);
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "dino_flesh"), DINO_FLESH);
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "pill"), PILL);
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "fossil"), FOSSIL);
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "skeleton_pickaxe"), new PickaxeBase(new ToolMaterialSkeleton()));
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "skeleton_axe"), new AxeBase(new ToolMaterialSkeleton()));
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "skeleton_shovel"), new ShovelBase(new ToolMaterialSkeleton()));
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "skeleton_hoe"), new HoeBase(new ToolMaterialSkeleton()));
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "skeleton_sword"), new SwordBase(new ToolMaterialSkeleton()));
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "skeleton_dagger"), new SwordBase(new ToolMaterialSkeleton()));
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "enlightened_pickaxe"), new PickaxeBase(new ToolMaterialEnlightened()));
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "enlightened_axe"), new AxeBase(new ToolMaterialEnlightened()));
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "enlightened_shovel"), new ShovelBase(new ToolMaterialEnlightened()));
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "enlightened_hoe"), new HoeBase(new ToolMaterialEnlightened()));
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "enlightened_skeletonsword"), new SwordBase(new ToolMaterialEnlightened()));
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "enlightened_skeleton_dagger"), new SwordBase(new ToolMaterialSkeleton()));
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "skeleton_helmet"), new BaseArmour(SKELETON_ARMOUR, EquipmentSlot.HEAD));
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "skeleton_chestplate"), new BaseArmour(SKELETON_ARMOUR, EquipmentSlot.CHEST));
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "skeleton_leggings"), new BaseArmour(SKELETON_ARMOUR, EquipmentSlot.LEGS));
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "skeleton_boots"), new BaseArmour(SKELETON_ARMOUR, EquipmentSlot.FEET));
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "bronzium_pickaxe"), new PickaxeBase(new ToolMaterialBronzium()));
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "bronzium_axe"), new AxeBase(new ToolMaterialBronzium()));
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "bronzium_shovel"), new ShovelBase(new ToolMaterialBronzium()));
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "bronzium_hoe"), new HoeBase(new ToolMaterialBronzium()));
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "bronzium_sword"), new SwordBase(new ToolMaterialBronzium()));
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "bronzium_helmet"), new BaseArmour(BRONZIUM_ARMOUR, EquipmentSlot.HEAD));
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "bronzium_chestplate"), new BaseArmour(BRONZIUM_ARMOUR, EquipmentSlot.CHEST));
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "bronzium_leggings"), new BaseArmour(BRONZIUM_ARMOUR, EquipmentSlot.LEGS));
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "bronzium_boots"), new BaseArmour(BRONZIUM_ARMOUR, EquipmentSlot.FEET));
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "bronzium_ingot"), BRONZIUM_INGOT);
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "shard_of_enlightenment"),SHARD_OF_ENLIGHTENMENT);
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "wyvern_crystal"), WYVERN_CRYSTAL);
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "sauropod_spawn_egg"), SAUROPOD_SPAWN_EGG);
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "troodon_spawn_egg"), TROODON_SPAWN_EGG);
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "theropod_spawn_egg"), THEROPOD_SPAWN_EGG);
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "micoraptor_spawn_egg"), MICORAPTOR_SPAWN_EGG);
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "mosasaurus_spawn_egg"), MOSASAURUS_SPAWN_EGG);
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "stegoraptor_spawn_egg"), STEGORAPTOR_SPAWN_EGG);
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "chinlea_spawn_egg"), CHINLEA_SPAWN_EGG);
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "deinonychus_spawn_egg"), DEINONYCHUS_SPAWN_EGG);
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "time_flint"), TIME_FLINT);
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "enlightened_core"),ENLIGHTENED_CORE);
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "enlightened_necklace"),ENLIGHTENED_NECKLACE);
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "dragonwood_boat"), DRAGONWOOD_BOAT);
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "spear"), new SwordBase(new ToolMaterialEnlightened()));
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "dragonwood_pickaxe"), new PickaxeBase(new ToolMaterialDragonwood()));
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "dragonwood_axe"), new AxeBase(new ToolMaterialDragonwood()));
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "dragonwood_shovel"), new ShovelBase(new ToolMaterialDragonwood()));
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "dragonwood_hoe"), new HoeBase(new ToolMaterialDragonwood()));
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "dragonwood_sword"), new SwordBase(new ToolMaterialDragonwood()));
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "dinosteel_ingot"),DINOSTEEL_INGOT);
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "empty_dna_bottle"),EMPTY_DNA_BOTTLE);
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "dna_bottle"),DNA_BOTTLE);
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "mysterious_dna_bottle"),MYSTERIOUS_DNA_BOTTLE);
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "inflamed_dna_bottle"),INFLAMED_DNA_BOTTLE);
        Registry.register(Registry.ITEM, new Identifier(Dinocraft.MOD_ID, "dino_feather"),DINO_FEATHER);
    }
    }










