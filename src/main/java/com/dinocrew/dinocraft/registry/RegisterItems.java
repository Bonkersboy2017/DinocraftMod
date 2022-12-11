package com.dinocrew.dinocraft.registry;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.armour.AmberArmorMaterial;
import com.dinocrew.dinocraft.armour.BaseArmour;
import com.dinocrew.dinocraft.armour.BronziumArmourMaterial;
import com.dinocrew.dinocraft.armour.SkeletonArmourMaterial;
import com.dinocrew.dinocraft.entity.DinoBoats;
import com.dinocrew.dinocraft.item.weapons.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.frozenblock.lib.item.api.FrozenCreativeTabs;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ItemLike;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class RegisterItems {

    public static final Item ALLOSAURUS_SKULL = new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON));
    public static final Item BARYONYX_SKULL = new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON));
    public static final Item CARNOTAURUS_SKULL = new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON));
    public static final Item DINO_KIDNEY = new Item(new FabricItemSettings());
    public static final Item BERRIES = new Item(new FabricItemSettings().food(RegisterFood.BERRIES));
    public static final Item INFECTED_BERRIES = new Item(new FabricItemSettings().food(RegisterFood.INFECTED_BERRIES));
    public static final Item DINO_SKELETON_JAW = new Item(new FabricItemSettings());
    public static final Item RAW_DINO_FLESH = new Item(new FabricItemSettings());
    public static final Item DINO_FLESH = new Item(new FabricItemSettings().food(RegisterFood.DINO_FLESH));
    public static final Item PILL = new Item(new FabricItemSettings());
    public static final Item FOSSIL = new Item(new FabricItemSettings());
    public static final ArmorMaterial SKELETON_ARMOUR = new SkeletonArmourMaterial();
    public static final ArmorMaterial BRONZIUM_ARMOUR = new BronziumArmourMaterial();
    public static final ArmorMaterial AMBER_ARMOR = new AmberArmorMaterial();
    public static final Item CYAD_SEEDS = new Item(new FabricItemSettings().food(RegisterFood.CYAD_SEEDS));
    public static final Item ROTTING_CYADS = new Item(new FabricItemSettings().food(RegisterFood.ROTTING_CYADS));
    public static final Item CYAD_LEAF = new Item(new FabricItemSettings().food(RegisterFood.CYAD_LEAF));
    public static final Item BRONZIUM_INGOT = new Item(new FabricItemSettings());
    //public static final Item THEM_CHILLI = new Item(new FabricItemSettings().group(Dinocraft.ITEM_GROUP));
    //public static final Item DEMME_BERRIES = new Item(new FabricItemSettings().group(Dinocraft.ITEM_GROUP));
    public static final Item TIME_FLINT = new Item(new FabricItemSettings());
    public static final Item WYVERN_CRYSTAL = new Item(new FabricItemSettings());
    public static final Item SAUROPOD_SPAWN_EGG = new SpawnEggItem(RegisterEntities.SAUROPOD, 25600, 9498256, new FabricItemSettings());
    public static final Item THEROPOD_SPAWN_EGG = new SpawnEggItem(RegisterEntities.THEROPOD, 0xff8c00, 16777215, new FabricItemSettings());
    public static final Item TROODON_SPAWN_EGG = new SpawnEggItem(RegisterEntities.TROODON, 0x5c4033, 16753920, new FabricItemSettings());
    public static final Item MICORAPTOR_SPAWN_EGG = new SpawnEggItem(RegisterEntities.MICRORAPTOR, 16753920, 132957, new FabricItemSettings());
    public static final Item MOSASAURUS_SPAWN_EGG = new SpawnEggItem(RegisterEntities.MOSASAURUS, 11393254, 9498256, new FabricItemSettings());
    public static final Item CHINLEA_SPAWN_EGG = new SpawnEggItem(RegisterEntities.CHINLEA, 144238144, 0xFFFFFF, new FabricItemSettings());
    public static final Item STEGORAPTOR_SPAWN_EGG = new SpawnEggItem(RegisterEntities.STEGORAPTOR, 25600, 139, new FabricItemSettings());
    public static final Item DEINONYCHUS_SPAWN_EGG = new SpawnEggItem(RegisterEntities.DEINONYCHUS, 167475200, 16753920, new FabricItemSettings());
    public static final Item PROFESSOR_SPAWN_EGG = new SpawnEggItem(RegisterEntities.PROFESSOR, 0xFFFFFF, 0x808080, new FabricItemSettings());
    public static final Item SCORPIUS_SPAWN_EGG = new SpawnEggItem(RegisterEntities.SCORPIUS, 0x808080, 0xFFFF00, new FabricItemSettings());
    public static final Item TYRANNOSAURUS_SPAWN_EGG = new SpawnEggItem(RegisterEntities.TYRANNOSAURUS, 0xC8AE7E, 0xD1C0A8, new FabricItemSettings());
    public static final Item DINOSTEEL_INGOT = new Item(new FabricItemSettings());
    public static final Item SHARD_OF_ENLIGHTENMENT = new Item(new FabricItemSettings().rarity(Rarity.EPIC));
    public static final Item TROPICAL_BERRIES = new Item(new FabricItemSettings().food(RegisterFood.TROPICAL_BERRIES));
    public static final Item ENLIGHTENED_CORE = new Item(new FabricItemSettings().rarity(Rarity.EPIC));
    public static final Item ENLIGHTENED_NECKLACE = new Item(new FabricItemSettings().rarity(Rarity.EPIC));
    public static final Item DRAGONWOOD_BOAT = new BoatItem(false, DinoBoats.DRAGONWOOD, new FabricItemSettings().stacksTo(1));
    public static final Item DRAGONWOOD_CHEST_BOAT = new BoatItem(true, DinoBoats.DRAGONWOOD, new FabricItemSettings().stacksTo(1));
    public static final Item DRAGONWOOD_SIGN = new SignItem(new FabricItemSettings().stacksTo(16),
            RegisterBlocks.DRAGONWOOD_SIGN, RegisterBlocks.DRAGONWOOD_WALL_SIGN);
    public static final Item EMPTY_DNA_BOTTLE = new Item(new FabricItemSettings());
    public static final Item DNA_BOTTLE = new Item(new FabricItemSettings());
    public static final Item MYSTERIOUS_DNA_BOTTLE = new Item(new FabricItemSettings());
    public static final Item INFLAMED_DNA_BOTTLE = new Item(new FabricItemSettings());
    public static final Item DINO_FEATHER = new Item(new FabricItemSettings());
    public static final Item AMBER_GEM = new Item(new FabricItemSettings());
    public static final Item DRAGONWOOD_SCRAP = new Item(new FabricItemSettings());
    public static final SwordBase SPEAR = new SwordBase(new ToolMaterialEnlightened());

    private RegisterItems() {
    }


    public static void registerAll() {
        registerItem(ALLOSAURUS_SKULL, "allosaurus_skull");
        registerItem(BARYONYX_SKULL, "baryonyx_skull");
        registerItem(CARNOTAURUS_SKULL, "carnotaurus_skull");
        registerItem(BERRIES, "berries");
        registerItem(INFECTED_BERRIES,"infected_berries");
        registerItem("tropical_berries", TROPICAL_BERRIES);
        registerItem("cyad_seeds", CYAD_SEEDS);
        registerItem("rotting_cyads", ROTTING_CYADS);
        registerItem("cyad_leaf", CYAD_LEAF);
        //registerItem("them_chilli", THEM_CHILLI);
        //registerItem("demme_berries", DEMME_BERRIES);
        registerItem("dino_kidney", DINO_KIDNEY);
        registerItem("dino_skeleton_jaw", DINO_SKELETON_JAW);
        registerItem("raw_dino_flesh", RAW_DINO_FLESH);
        registerItem("dino_flesh", DINO_FLESH);
        registerItem("pill", PILL);
        registerItem("fossil", FOSSIL);
        registerItem("skeleton_pickaxe", new PickaxeBase(new ToolMaterialSkeleton()));
        registerItem("skeleton_axe", new AxeBase(new ToolMaterialSkeleton()));
        registerItem("skeleton_shovel", new ShovelBase(new ToolMaterialSkeleton()));
        registerItem("skeleton_hoe", new HoeBase(new ToolMaterialSkeleton()));
        registerItem("skeleton_sword", new SwordBase(new ToolMaterialSkeleton()));
        registerItem("skeleton_dagger", new DaggerBase(new ToolMaterialSkeleton()));
        registerItem("enlightened_pickaxe", new PickaxeBase(new ToolMaterialEnlightened()));
        registerItem("enlightened_axe", new AxeBase(new ToolMaterialEnlightened()));
        registerItem("enlightened_shovel", new ShovelBase(new ToolMaterialEnlightened()));
        registerItem("enlightened_hoe", new HoeBase(new ToolMaterialEnlightened()));
        registerItem("enlightened_skeletonsword", new SwordBase(new ToolMaterialEnlightened()));
        registerItem("enlightened_skeleton_dagger", new DaggerBase(new ToolMaterialSkeleton()));
        registerItem("skeleton_helmet", new BaseArmour(SKELETON_ARMOUR, EquipmentSlot.HEAD));
        registerItem("skeleton_chestplate", new BaseArmour(SKELETON_ARMOUR, EquipmentSlot.CHEST));
        registerItem("skeleton_leggings", new BaseArmour(SKELETON_ARMOUR, EquipmentSlot.LEGS));
        registerItem("skeleton_boots", new BaseArmour(SKELETON_ARMOUR, EquipmentSlot.FEET));
        registerItem("bronzium_pickaxe", new PickaxeBase(new ToolMaterialBronzium()));
        registerItem("bronzium_axe", new AxeBase(new ToolMaterialBronzium()));
        registerItem("bronzium_shovel", new ShovelBase(new ToolMaterialBronzium()));
        registerItem("bronzium_hoe", new HoeBase(new ToolMaterialBronzium()));
        registerItem("bronzium_sword", new SwordBase(new ToolMaterialBronzium()));
        registerItem("bronzium_helmet", new BaseArmour(BRONZIUM_ARMOUR, EquipmentSlot.HEAD));
        registerItem("bronzium_chestplate", new BaseArmour(BRONZIUM_ARMOUR, EquipmentSlot.CHEST));
        registerItem("bronzium_leggings", new BaseArmour(BRONZIUM_ARMOUR, EquipmentSlot.LEGS));
        registerItem("bronzium_boots", new BaseArmour(BRONZIUM_ARMOUR, EquipmentSlot.FEET));
        registerItem("bronzium_ingot", BRONZIUM_INGOT);
        registerItem("shard_of_enlightenment", SHARD_OF_ENLIGHTENMENT);
        registerItem("wyvern_crystal", WYVERN_CRYSTAL);
        registerItem("sauropod_spawn_egg", SAUROPOD_SPAWN_EGG);
        registerItem("troodon_spawn_egg", TROODON_SPAWN_EGG);
        registerItem("theropod_spawn_egg", THEROPOD_SPAWN_EGG);
        registerItem("micoraptor_spawn_egg", MICORAPTOR_SPAWN_EGG);
        registerItem("mosasaurus_spawn_egg", MOSASAURUS_SPAWN_EGG);
        registerItem("stegoraptor_spawn_egg", STEGORAPTOR_SPAWN_EGG);
        registerItem("chinlea_spawn_egg", CHINLEA_SPAWN_EGG);
        registerItem("deinonychus_spawn_egg", DEINONYCHUS_SPAWN_EGG);
        registerItem("professor_spawn_egg", PROFESSOR_SPAWN_EGG);
        registerItem("scorpius_spawn_egg", SCORPIUS_SPAWN_EGG);
        registerItem("tyrannosaurus_spawn_egg", TYRANNOSAURUS_SPAWN_EGG);
        registerItem("time_flint", TIME_FLINT);
        registerItem("enlightened_core", ENLIGHTENED_CORE);
        registerItem("enlightened_necklace", ENLIGHTENED_NECKLACE);
        registerItem("dragonwood_boat", DRAGONWOOD_BOAT);
        registerItem("dragonwood_chest_boat", DRAGONWOOD_CHEST_BOAT);
        registerItem("dragonwood_sign", DRAGONWOOD_SIGN);
        registerItem("spear", SPEAR);
        registerItem("dragonwood_pickaxe", new PickaxeBase(new ToolMaterialDragonwood()));
        registerItem("dragonwood_axe", new AxeBase(new ToolMaterialDragonwood()));
        registerItem("dragonwood_shovel", new ShovelBase(new ToolMaterialDragonwood()));
        registerItem("dragonwood_hoe", new HoeBase(new ToolMaterialDragonwood()));
        registerItem("dragonwood_sword", new SwordBase(new ToolMaterialDragonwood()));
        registerItem("dragonwood_scrap", DRAGONWOOD_SCRAP);
        registerItem("dinosteel_ingot", DINOSTEEL_INGOT);
        registerItem("empty_dna_bottle", EMPTY_DNA_BOTTLE);
        registerItem("dna_bottle", DNA_BOTTLE);
        registerItem("mysterious_dna_bottle", MYSTERIOUS_DNA_BOTTLE);
        registerItem("inflamed_dna_bottle", INFLAMED_DNA_BOTTLE);
        registerItem("dino_feather", DINO_FEATHER);
        registerItem("amber_gem", AMBER_GEM);
        registerItem("amber_helmet", new BaseArmour(AMBER_ARMOR, EquipmentSlot.HEAD));
        registerItem("amber_chestplate", new BaseArmour(AMBER_ARMOR, EquipmentSlot.CHEST));
        registerItem("amber_leggings", new BaseArmour(AMBER_ARMOR, EquipmentSlot.LEGS));
        registerItem("amber_boots", new BaseArmour(AMBER_ARMOR, EquipmentSlot.FEET));
        registerItem("amber_pickaxe", new PickaxeBase(new ToolMaterialAmber()));
        registerItem("amber_axe", new AxeBase(new ToolMaterialAmber()));
        registerItem("amber_shovel", new ShovelBase(new ToolMaterialAmber()));
        registerItem("amber_hoe", new HoeBase(new ToolMaterialAmber()));
        registerItem("amber_sword", new SwordBase(new ToolMaterialAmber()));
    }

    private static void registerInstrument(Item instrument, String path, TagKey<Instrument> tagKey, CreativeModeTab.TabVisibility tabVisibility, CreativeModeTab... tabs) {
        actualRegister(instrument, path);
        FrozenCreativeTabs.addInstrument(instrument, tagKey, tabVisibility, tabs);
    }

    private static void registerInstrumentBefore(Item comparedItem, Item instrument, String path, TagKey<Instrument> tagKey, CreativeModeTab.TabVisibility tabVisibility, CreativeModeTab... tabs) {
        actualRegister(instrument, path);
        FrozenCreativeTabs.addInstrumentBefore(comparedItem, instrument, tagKey, tabVisibility, tabs);
    }

    private static void registerItem(Item item, String path, CreativeModeTab... tabs) {
        actualRegister(item, path);
        var added = new ArrayList<>(Arrays.stream(tabs).toList());
        added.add(Dinocraft.ITEM_GROUP);
        FrozenCreativeTabs.add(item, added.toArray(new CreativeModeTab[]{}));
    }

    private static void registerItemBefore(ItemLike comparedItem, Item item, String path, CreativeModeTab... tabs) {
        registerItemBefore(comparedItem, item, path, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS, tabs);
    }

    private static void registerItemBefore(ItemLike comparedItem, Item item, String path, CreativeModeTab.TabVisibility tabVisibility, CreativeModeTab... tabs) {
        actualRegister(item, path);
        var added = new ArrayList<>(Arrays.stream(tabs).toList());
        added.add(Dinocraft.ITEM_GROUP);
        FrozenCreativeTabs.addBefore(comparedItem, item, tabVisibility, added.toArray(new CreativeModeTab[]{}));
    }

    private static void registerItemAfter(ItemLike comparedItem, Item item, String path, CreativeModeTab... tabs) {
        registerItemAfter(comparedItem, item, path, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS, tabs);
    }

    private static void registerItemAfter(ItemLike comparedItem, Item item, String path, CreativeModeTab.TabVisibility tabVisibility, CreativeModeTab... tabs) {
        actualRegister(item, path);
        var added = new ArrayList<>(Arrays.stream(tabs).toList());
        added.add(Dinocraft.ITEM_GROUP);
        FrozenCreativeTabs.addAfter(comparedItem, item, tabVisibility, added.toArray(new CreativeModeTab[]{}));
    }

    private static void actualRegister(Item item, String path) {
        var registry = BuiltInRegistries.ITEM;
        var location = Dinocraft.id(path);
        if (registry.getOptional(location).isEmpty()) {
            Registry.register(registry, location, item);
        }
    }

    private static void registerItem(String path, Item item, CreativeModeTab... tabs) {
        registerItem(item, path, tabs);
    }
}










