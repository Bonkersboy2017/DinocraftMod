package com.dinocrew.dinocraft.registry;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.armour.AmberArmorMaterial;
import com.dinocrew.dinocraft.armour.BaseArmour;
import com.dinocrew.dinocraft.armour.BronziumArmourMaterial;
import com.dinocrew.dinocraft.armour.SkeletonArmourMaterial;
import com.dinocrew.dinocraft.entity.DinoBoats;
import com.dinocrew.dinocraft.item.weapons.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;

public final class RegisterItems {

    public static final Item ALLOSAURUS_SKULL = new Item(new FabricItemSettings().tab(Dinocraft.ITEM_GROUP).rarity(Rarity.UNCOMMON));
    public static final Item BARYONYX_SKULL = new Item(new FabricItemSettings().tab(Dinocraft.ITEM_GROUP).rarity(Rarity.UNCOMMON));
    public static final Item CARNOTAURUS_SKULL = new Item(new FabricItemSettings().tab(Dinocraft.ITEM_GROUP).rarity(Rarity.UNCOMMON));
    public static final Item DINO_KIDNEY = new Item(new FabricItemSettings().tab(Dinocraft.ITEM_GROUP));
    public static final Item BERRIES = new Item(new FabricItemSettings().tab(Dinocraft.ITEM_GROUP).food(RegisterFood.BERRIES));
    public static final Item INFECTED_BERRIES = new Item(new FabricItemSettings().tab(Dinocraft.ITEM_GROUP).food(RegisterFood.INFECTED_BERRIES));
    public static final Item DINO_SKELETON_JAW = new Item(new FabricItemSettings().tab(Dinocraft.ITEM_GROUP));
    public static final Item RAW_DINO_FLESH = new Item(new FabricItemSettings().tab(Dinocraft.ITEM_GROUP));
    public static final Item DINO_FLESH = new Item(new FabricItemSettings().tab(Dinocraft.ITEM_GROUP).food(RegisterFood.DINO_FLESH));
    public static final Item PILL = new Item(new FabricItemSettings().tab(Dinocraft.ITEM_GROUP));
    public static final Item FOSSIL = new Item(new FabricItemSettings().tab(Dinocraft.ITEM_GROUP));
    public static final ArmorMaterial SKELETON_ARMOUR = new SkeletonArmourMaterial();
    public static final ArmorMaterial BRONZIUM_ARMOUR = new BronziumArmourMaterial();
    public static final ArmorMaterial AMBER_ARMOR = new AmberArmorMaterial();
    public static final Item CYAD_SEEDS = new Item(new FabricItemSettings().tab(Dinocraft.ITEM_GROUP).food(RegisterFood.CYAD_SEEDS));
    public static final Item ROTTING_CYADS = new Item(new FabricItemSettings().tab(Dinocraft.ITEM_GROUP).food(RegisterFood.ROTTING_CYADS));
    public static final Item CYAD_LEAF = new Item(new FabricItemSettings().tab(Dinocraft.ITEM_GROUP).food(RegisterFood.CYAD_LEAF));
    public static final Item BRONZIUM_INGOT = new Item(new FabricItemSettings().tab(Dinocraft.ITEM_GROUP));
    //public static final Item THEM_CHILLI = new Item(new FabricItemSettings().group(Dinocraft.ITEM_GROUP));
    //public static final Item DEMME_BERRIES = new Item(new FabricItemSettings().group(Dinocraft.ITEM_GROUP));
    public static final Item TIME_FLINT = new Item(new FabricItemSettings().tab(Dinocraft.ITEM_GROUP));
    public static final Item WYVERN_CRYSTAL = new Item(new FabricItemSettings().tab(Dinocraft.ITEM_GROUP));
    public static final Item SAUROPOD_SPAWN_EGG = new SpawnEggItem(RegisterEntities.SAUROPOD, 25600, 9498256, new FabricItemSettings().tab(Dinocraft.ITEM_GROUP));
    public static final Item THEROPOD_SPAWN_EGG = new SpawnEggItem(RegisterEntities.THEROPOD, 0xff8c00, 16777215, new FabricItemSettings().tab(Dinocraft.ITEM_GROUP));
    public static final Item TROODON_SPAWN_EGG = new SpawnEggItem(RegisterEntities.TROODON, 0x5c4033, 16753920, new FabricItemSettings().tab(Dinocraft.ITEM_GROUP));
    public static final Item MICORAPTOR_SPAWN_EGG = new SpawnEggItem(RegisterEntities.MICRORAPTOR, 16753920, 132957, new FabricItemSettings().tab(Dinocraft.ITEM_GROUP));
    public static final Item MOSASAURUS_SPAWN_EGG = new SpawnEggItem(RegisterEntities.MOSASAURUS, 11393254, 9498256, new FabricItemSettings().tab(Dinocraft.ITEM_GROUP));
    public static final Item CHINLEA_SPAWN_EGG = new SpawnEggItem(RegisterEntities.CHINLEA, 144238144, 0xFFFFFF, new FabricItemSettings().tab(Dinocraft.ITEM_GROUP));
    public static final Item STEGORAPTOR_SPAWN_EGG = new SpawnEggItem(RegisterEntities.STEGORAPTOR, 25600, 139, new FabricItemSettings().tab(Dinocraft.ITEM_GROUP));
    public static final Item DEINONYCHUS_SPAWN_EGG = new SpawnEggItem(RegisterEntities.DEINONYCHUS, 167475200, 16753920, new FabricItemSettings().tab(Dinocraft.ITEM_GROUP));
    public static final Item PROFESSOR_SPAWN_EGG = new SpawnEggItem(RegisterEntities.PROFESSOR, 0xFFFFFF, 0x808080, new FabricItemSettings().tab(Dinocraft.ITEM_GROUP));
    public static final Item SCORPIUS_SPAWN_EGG = new SpawnEggItem(RegisterEntities.SCORPIUS, 0x808080, 0xFFFF00, new FabricItemSettings().tab(Dinocraft.ITEM_GROUP));
    public static final Item TYRANNOSAURUS_SPAWN_EGG = new SpawnEggItem(RegisterEntities.TYRANNOSAURUS, 0xC8AE7E, 0xD1C0A8, new FabricItemSettings().tab(Dinocraft.ITEM_GROUP));
    public static final Item DINOSTEEL_INGOT = new Item(new FabricItemSettings().tab(Dinocraft.ITEM_GROUP));
    public static final Item SHARD_OF_ENLIGHTENMENT = new Item(new FabricItemSettings().tab(Dinocraft.ITEM_GROUP).rarity(Rarity.EPIC));
    public static final Item TROPICAL_BERRIES = new Item(new FabricItemSettings().tab(Dinocraft.ITEM_GROUP).food(RegisterFood.TROPICAL_BERRIES));
    public static final Item ENLIGHTENED_CORE = new Item(new FabricItemSettings().tab(Dinocraft.ITEM_GROUP).rarity(Rarity.EPIC));
    public static final Item ENLIGHTENED_NECKLACE = new Item(new FabricItemSettings().tab(Dinocraft.ITEM_GROUP).rarity(Rarity.EPIC));
    public static final Item DRAGONWOOD_BOAT = new BoatItem(false, DinoBoats.DRAGONWOOD, new FabricItemSettings().stacksTo(1).tab(Dinocraft.ITEM_GROUP));
    public static final Item DRAGONWOOD_CHEST_BOAT = new BoatItem(true, DinoBoats.DRAGONWOOD, new FabricItemSettings().stacksTo(1).tab(Dinocraft.ITEM_GROUP));
    public static final Item DRAGONWOOD_SIGN = new SignItem(new FabricItemSettings().tab(Dinocraft.ITEM_GROUP).stacksTo(16),
            RegisterBlocks.DRAGONWOOD_SIGN_BLOCK, RegisterBlocks.DRAGONWOOD_WALL_SIGN_BLOCK);
    public static final Item EMPTY_DNA_BOTTLE = new Item(new FabricItemSettings().tab(Dinocraft.ITEM_GROUP));
    public static final Item DNA_BOTTLE = new Item(new FabricItemSettings().tab(Dinocraft.ITEM_GROUP));
    public static final Item MYSTERIOUS_DNA_BOTTLE = new Item(new FabricItemSettings().tab(Dinocraft.ITEM_GROUP));
    public static final Item INFLAMED_DNA_BOTTLE = new Item(new FabricItemSettings().tab(Dinocraft.ITEM_GROUP));
    public static final Item DINO_FEATHER = new Item(new FabricItemSettings().tab(Dinocraft.ITEM_GROUP));
    public static final Item AMBER_GEM = new Item(new FabricItemSettings().tab(Dinocraft.ITEM_GROUP));
    public static final Item DRAGONWOOD_SCRAP = new Item(new FabricItemSettings().tab(Dinocraft.ITEM_GROUP));
    public static final SwordBase SPEAR = new SwordBase(new ToolMaterialEnlightened());

    private RegisterItems() {
    }


    public static void registerAll() {
        Registry.register(Registry.ITEM, Dinocraft.id("allosaurus_skull"), ALLOSAURUS_SKULL);
        Registry.register(Registry.ITEM, Dinocraft.id("baryonyx_skull"), BARYONYX_SKULL);
        Registry.register(Registry.ITEM, Dinocraft.id("carnotaurus_skull"), CARNOTAURUS_SKULL);
        Registry.register(Registry.ITEM, Dinocraft.id("berries"), BERRIES);
        Registry.register(Registry.ITEM, Dinocraft.id("infected_berries"), INFECTED_BERRIES);
        Registry.register(Registry.ITEM, Dinocraft.id("tropical_berries"), TROPICAL_BERRIES);
        Registry.register(Registry.ITEM, Dinocraft.id("cyad_seeds"), CYAD_SEEDS);
        Registry.register(Registry.ITEM, Dinocraft.id("rotting_cyads"), ROTTING_CYADS);
        Registry.register(Registry.ITEM, Dinocraft.id("cyad_leaf"), CYAD_LEAF);
        //Registry.register(Registry.ITEM, Dinocraft.id("them_chilli"), THEM_CHILLI);
        //Registry.register(Registry.ITEM, Dinocraft.id("demme_berries"), DEMME_BERRIES);
        Registry.register(Registry.ITEM, Dinocraft.id("dino_kidney"), DINO_KIDNEY);
        Registry.register(Registry.ITEM, Dinocraft.id("dino_skeleton_jaw"), DINO_SKELETON_JAW);
        Registry.register(Registry.ITEM, Dinocraft.id("raw_dino_flesh"), RAW_DINO_FLESH);
        Registry.register(Registry.ITEM, Dinocraft.id("dino_flesh"), DINO_FLESH);
        Registry.register(Registry.ITEM, Dinocraft.id("pill"), PILL);
        Registry.register(Registry.ITEM, Dinocraft.id("fossil"), FOSSIL);
        Registry.register(Registry.ITEM, Dinocraft.id("skeleton_pickaxe"), new PickaxeBase(new ToolMaterialSkeleton()));
        Registry.register(Registry.ITEM, Dinocraft.id("skeleton_axe"), new AxeBase(new ToolMaterialSkeleton()));
        Registry.register(Registry.ITEM, Dinocraft.id("skeleton_shovel"), new ShovelBase(new ToolMaterialSkeleton()));
        Registry.register(Registry.ITEM, Dinocraft.id("skeleton_hoe"), new HoeBase(new ToolMaterialSkeleton()));
        Registry.register(Registry.ITEM, Dinocraft.id("skeleton_sword"), new SwordBase(new ToolMaterialSkeleton()));
        Registry.register(Registry.ITEM, Dinocraft.id("skeleton_dagger"), new DaggerBase(new ToolMaterialSkeleton()));
        Registry.register(Registry.ITEM, Dinocraft.id("enlightened_pickaxe"), new PickaxeBase(new ToolMaterialEnlightened()));
        Registry.register(Registry.ITEM, Dinocraft.id("enlightened_axe"), new AxeBase(new ToolMaterialEnlightened()));
        Registry.register(Registry.ITEM, Dinocraft.id("enlightened_shovel"), new ShovelBase(new ToolMaterialEnlightened()));
        Registry.register(Registry.ITEM, Dinocraft.id("enlightened_hoe"), new HoeBase(new ToolMaterialEnlightened()));
        Registry.register(Registry.ITEM, Dinocraft.id("enlightened_skeletonsword"), new SwordBase(new ToolMaterialEnlightened()));
        Registry.register(Registry.ITEM, Dinocraft.id("enlightened_skeleton_dagger"), new DaggerBase(new ToolMaterialSkeleton()));
        Registry.register(Registry.ITEM, Dinocraft.id("skeleton_helmet"), new BaseArmour(SKELETON_ARMOUR, EquipmentSlot.HEAD));
        Registry.register(Registry.ITEM, Dinocraft.id("skeleton_chestplate"), new BaseArmour(SKELETON_ARMOUR, EquipmentSlot.CHEST));
        Registry.register(Registry.ITEM, Dinocraft.id("skeleton_leggings"), new BaseArmour(SKELETON_ARMOUR, EquipmentSlot.LEGS));
        Registry.register(Registry.ITEM, Dinocraft.id("skeleton_boots"), new BaseArmour(SKELETON_ARMOUR, EquipmentSlot.FEET));
        Registry.register(Registry.ITEM, Dinocraft.id("bronzium_pickaxe"), new PickaxeBase(new ToolMaterialBronzium()));
        Registry.register(Registry.ITEM, Dinocraft.id("bronzium_axe"), new AxeBase(new ToolMaterialBronzium()));
        Registry.register(Registry.ITEM, Dinocraft.id("bronzium_shovel"), new ShovelBase(new ToolMaterialBronzium()));
        Registry.register(Registry.ITEM, Dinocraft.id("bronzium_hoe"), new HoeBase(new ToolMaterialBronzium()));
        Registry.register(Registry.ITEM, Dinocraft.id("bronzium_sword"), new SwordBase(new ToolMaterialBronzium()));
        Registry.register(Registry.ITEM, Dinocraft.id("bronzium_helmet"), new BaseArmour(BRONZIUM_ARMOUR, EquipmentSlot.HEAD));
        Registry.register(Registry.ITEM, Dinocraft.id("bronzium_chestplate"), new BaseArmour(BRONZIUM_ARMOUR, EquipmentSlot.CHEST));
        Registry.register(Registry.ITEM, Dinocraft.id("bronzium_leggings"), new BaseArmour(BRONZIUM_ARMOUR, EquipmentSlot.LEGS));
        Registry.register(Registry.ITEM, Dinocraft.id("bronzium_boots"), new BaseArmour(BRONZIUM_ARMOUR, EquipmentSlot.FEET));
        Registry.register(Registry.ITEM, Dinocraft.id("bronzium_ingot"), BRONZIUM_INGOT);
        Registry.register(Registry.ITEM, Dinocraft.id("shard_of_enlightenment"), SHARD_OF_ENLIGHTENMENT);
        Registry.register(Registry.ITEM, Dinocraft.id("wyvern_crystal"), WYVERN_CRYSTAL);
        Registry.register(Registry.ITEM, Dinocraft.id("sauropod_spawn_egg"), SAUROPOD_SPAWN_EGG);
        Registry.register(Registry.ITEM, Dinocraft.id("troodon_spawn_egg"), TROODON_SPAWN_EGG);
        Registry.register(Registry.ITEM, Dinocraft.id("theropod_spawn_egg"), THEROPOD_SPAWN_EGG);
        Registry.register(Registry.ITEM, Dinocraft.id("micoraptor_spawn_egg"), MICORAPTOR_SPAWN_EGG);
        Registry.register(Registry.ITEM, Dinocraft.id("mosasaurus_spawn_egg"), MOSASAURUS_SPAWN_EGG);
        Registry.register(Registry.ITEM, Dinocraft.id("stegoraptor_spawn_egg"), STEGORAPTOR_SPAWN_EGG);
        Registry.register(Registry.ITEM, Dinocraft.id("chinlea_spawn_egg"), CHINLEA_SPAWN_EGG);
        Registry.register(Registry.ITEM, Dinocraft.id("deinonychus_spawn_egg"), DEINONYCHUS_SPAWN_EGG);
        Registry.register(Registry.ITEM, Dinocraft.id("professor_spawn_egg"), PROFESSOR_SPAWN_EGG);
        Registry.register(Registry.ITEM, Dinocraft.id("scorpius_spawn_egg"), SCORPIUS_SPAWN_EGG);
        Registry.register(Registry.ITEM, Dinocraft.id("tyrannosaurus_spawn_egg"), TYRANNOSAURUS_SPAWN_EGG);
        Registry.register(Registry.ITEM, Dinocraft.id("time_flint"), TIME_FLINT);
        Registry.register(Registry.ITEM, Dinocraft.id("enlightened_core"), ENLIGHTENED_CORE);
        Registry.register(Registry.ITEM, Dinocraft.id("enlightened_necklace"), ENLIGHTENED_NECKLACE);
        Registry.register(Registry.ITEM, Dinocraft.id("dragonwood_boat"), DRAGONWOOD_BOAT);
        Registry.register(Registry.ITEM, Dinocraft.id("dragonwood_chest_boat"), DRAGONWOOD_CHEST_BOAT);
        Registry.register(Registry.ITEM, Dinocraft.id("dragonwood_sign"), DRAGONWOOD_SIGN);
        Registry.register(Registry.ITEM, Dinocraft.id("spear"), SPEAR);
        Registry.register(Registry.ITEM, Dinocraft.id("dragonwood_pickaxe"), new PickaxeBase(new ToolMaterialDragonwood()));
        Registry.register(Registry.ITEM, Dinocraft.id("dragonwood_axe"), new AxeBase(new ToolMaterialDragonwood()));
        Registry.register(Registry.ITEM, Dinocraft.id("dragonwood_shovel"), new ShovelBase(new ToolMaterialDragonwood()));
        Registry.register(Registry.ITEM, Dinocraft.id("dragonwood_hoe"), new HoeBase(new ToolMaterialDragonwood()));
        Registry.register(Registry.ITEM, Dinocraft.id("dragonwood_sword"), new SwordBase(new ToolMaterialDragonwood()));
        Registry.register(Registry.ITEM, Dinocraft.id("dragonwood_scrap"), DRAGONWOOD_SCRAP);
        Registry.register(Registry.ITEM, Dinocraft.id("dinosteel_ingot"), DINOSTEEL_INGOT);
        Registry.register(Registry.ITEM, Dinocraft.id("empty_dna_bottle"), EMPTY_DNA_BOTTLE);
        Registry.register(Registry.ITEM, Dinocraft.id("dna_bottle"), DNA_BOTTLE);
        Registry.register(Registry.ITEM, Dinocraft.id("mysterious_dna_bottle"), MYSTERIOUS_DNA_BOTTLE);
        Registry.register(Registry.ITEM, Dinocraft.id("inflamed_dna_bottle"), INFLAMED_DNA_BOTTLE);
        Registry.register(Registry.ITEM, Dinocraft.id("dino_feather"), DINO_FEATHER);
        Registry.register(Registry.ITEM, Dinocraft.id("amber_gem"), AMBER_GEM);
        Registry.register(Registry.ITEM, Dinocraft.id("amber_helmet"), new BaseArmour(AMBER_ARMOR, EquipmentSlot.HEAD));
        Registry.register(Registry.ITEM, Dinocraft.id("amber_chestplate"), new BaseArmour(AMBER_ARMOR, EquipmentSlot.CHEST));
        Registry.register(Registry.ITEM, Dinocraft.id("amber_leggings"), new BaseArmour(AMBER_ARMOR, EquipmentSlot.LEGS));
        Registry.register(Registry.ITEM, Dinocraft.id("amber_boots"), new BaseArmour(AMBER_ARMOR, EquipmentSlot.FEET));
        Registry.register(Registry.ITEM, Dinocraft.id("amber_pickaxe"), new PickaxeBase(new ToolMaterialAmber()));
        Registry.register(Registry.ITEM, Dinocraft.id("amber_axe"), new AxeBase(new ToolMaterialAmber()));
        Registry.register(Registry.ITEM, Dinocraft.id("amber_shovel"), new ShovelBase(new ToolMaterialAmber()));
        Registry.register(Registry.ITEM, Dinocraft.id("amber_hoe"), new HoeBase(new ToolMaterialAmber()));
        Registry.register(Registry.ITEM, Dinocraft.id("amber_sword"), new SwordBase(new ToolMaterialAmber()));
    }
}










