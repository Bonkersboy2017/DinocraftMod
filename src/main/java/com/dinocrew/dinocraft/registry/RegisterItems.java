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

public final class RegisterItems {

    public static final Tier AMBER = new ToolMaterialAmber();
    public static final Tier BRONZIUM = new ToolMaterialBronzium();
    public static final Tier DRAGONWOOD = new ToolMaterialDragonwood();
    public static final Tier ENLIGHTENED = new ToolMaterialEnlightened();
    public static final Tier SKELETON = new ToolMaterialSkeleton();

    public static final ArmorMaterial SKELETON_ARMOUR = new SkeletonArmourMaterial();
    public static final ArmorMaterial BRONZIUM_ARMOUR = new BronziumArmourMaterial();
    public static final ArmorMaterial AMBER_ARMOR = new AmberArmorMaterial();

    public static final Item ALLOSAURUS_SKULL = registerItem(new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON)), "allosaurus_skull", CreativeModeTabs.INGREDIENTS);
    public static final Item BARYONYX_SKULL = registerItem(new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON)), "baryonyx_skull", CreativeModeTabs.INGREDIENTS);
    public static final Item CARNOTAURUS_SKULL = registerItem(new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON)), "carnotaurus_skull", CreativeModeTabs.INGREDIENTS);

    public static final Item BERRIES = registerItem(new Item(new FabricItemSettings().food(RegisterFood.BERRIES)), "berries"); //TODO: Implement berries
    public static final Item INFECTED_BERRIES = registerItem(new Item(new FabricItemSettings().food(RegisterFood.INFECTED_BERRIES)), "infected_berries");
    public static final Item TROPICAL_BERRIES = registerItem(new Item(new FabricItemSettings().food(RegisterFood.TROPICAL_BERRIES)), "tropical_berries");
    public static final Item CYAD_SEEDS = registerItem(new Item(new FabricItemSettings().food(RegisterFood.CYAD_SEEDS)), "cyad_seeds", CreativeModeTabs.FOOD_AND_DRINKS);
    public static final Item ROTTING_CYADS = registerItem(new Item(new FabricItemSettings().food(RegisterFood.ROTTING_CYADS)), "rotting_cyads", CreativeModeTabs.FOOD_AND_DRINKS);
    public static final Item CYAD_LEAF = registerItem(new Item(new FabricItemSettings().food(RegisterFood.CYAD_LEAF)), "cyad_leaf", CreativeModeTabs.FOOD_AND_DRINKS);
    //public static final Item THEM_CHILLI = registerItem(new Item(new FabricItemSettings()), "them_chilli");
    //public static final Item DEMME_BERRIES = registerItem(new Item(new FabricItemSettings()), "demme_berries");

    public static final Item DINO_KIDNEY = registerItem(new Item(new FabricItemSettings()), "dino_kidney", CreativeModeTabs.INGREDIENTS);
    public static final Item DINO_SKELETON_JAW = registerItem(new Item(new FabricItemSettings()), "dino_skeleton_jaw", CreativeModeTabs.INGREDIENTS);
    public static final Item DINO_FLESH = registerItem(new Item(new FabricItemSettings().food(RegisterFood.DINO_FLESH)), "dino_flesh", CreativeModeTabs.FOOD_AND_DRINKS);
    public static final Item RAW_DINO_FLESH = registerItem(new Item(new FabricItemSettings()), "raw_dino_flesh", CreativeModeTabs.FOOD_AND_DRINKS);
    public static final Item PILL = registerItem(new Item(new FabricItemSettings()), "pill"); //TODO: Implement the pill
    public static final Item FOSSIL = registerItem(new Item(new FabricItemSettings()), "fossil", CreativeModeTabs.NATURAL_BLOCKS);

    public static final Item AMBER_SHOVEL = registerItemAfter(Items.IRON_HOE, new ShovelBase(AMBER), "amber_shovel", CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final Item AMBER_PICKAXE = registerItemAfter(AMBER_SHOVEL, new PickaxeBase(AMBER), "amber_pickaxe", CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final Item AMBER_AXE = registerItemAfter(AMBER_PICKAXE, new AxeBase(AMBER), "amber_axe", CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final Item AMBER_HOE = registerItemAfter(AMBER_AXE, new HoeBase(AMBER), "amber_hoe", CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final Item AMBER_SWORD = registerItemAfter(Items.IRON_SWORD, new SwordBase(AMBER), "amber_sword", CreativeModeTabs.COMBAT);

    public static final Item SKELETON_SHOVEL = registerItemAfter(Items.DIAMOND_HOE, new ShovelBase(SKELETON), "skeleton_shovel", CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final Item SKELETON_PICKAXE = registerItemAfter(SKELETON_SHOVEL, new PickaxeBase(SKELETON), "skeleton_pickaxe", CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final Item SKELETON_AXE = registerItemAfter(SKELETON_PICKAXE, new AxeBase(SKELETON), "skeleton_axe", CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final Item SKELETON_HOE = registerItemAfter(SKELETON_AXE, new HoeBase(SKELETON), "skeleton_hoe", CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final Item SKELETON_SWORD = registerItemAfter(Items.DIAMOND_SWORD, new SwordBase(SKELETON), "skeleton_sword", CreativeModeTabs.COMBAT);

    public static final Item BRONZIUM_SHOVEL = registerItemAfter(SKELETON_HOE, new ShovelBase(BRONZIUM), "bronzium_shovel", CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final Item BRONZIUM_PICKAXE = registerItemAfter(BRONZIUM_SHOVEL, new PickaxeBase(BRONZIUM), "bronzium_pickaxe", CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final Item BRONZIUM_AXE = registerItemAfter(BRONZIUM_PICKAXE, new AxeBase(BRONZIUM), "bronzium_axe", CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final Item BRONZIUM_HOE = registerItemAfter(BRONZIUM_AXE, new HoeBase(BRONZIUM), "bronzium_hoe", CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final Item BRONZIUM_SWORD = registerItemAfter(SKELETON_SWORD, new SwordBase(BRONZIUM), "bronzium_sword", CreativeModeTabs.COMBAT);

    public static final Item DRAGONWOOD_SHOVEL = registerItemAfter(BRONZIUM_HOE, new ShovelBase(DRAGONWOOD), "dragonwood_shovel", CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final Item DRAGONWOOD_PICKAXE = registerItemAfter(DRAGONWOOD_SHOVEL, new PickaxeBase(DRAGONWOOD), "dragonwood_pickaxe", CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final Item DRAGONWOOD_AXE = registerItemAfter(DRAGONWOOD_PICKAXE, new AxeBase(DRAGONWOOD), "dragonwood_axe", CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final Item DRAGONWOOD_HOE = registerItemAfter(DRAGONWOOD_AXE, new HoeBase(DRAGONWOOD), "dragonwood_hoe", CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final Item DRAGONWOOD_SWORD = registerItemAfter(DRAGONWOOD_HOE, new SwordBase(DRAGONWOOD), "dragonwood_sword", CreativeModeTabs.COMBAT);

    public static final Item ENLIGHTENED_SHOVEL = registerItemAfter(Items.NETHERITE_HOE, new ShovelBase(ENLIGHTENED), "enlightened_shovel", CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final Item ENLIGHTENED_PICKAXE = registerItemAfter(ENLIGHTENED_SHOVEL, new PickaxeBase(ENLIGHTENED), "enlightened_pickaxe", CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final Item ENLIGHTENED_AXE = registerItemAfter(ENLIGHTENED_PICKAXE, new AxeBase(ENLIGHTENED), "enlightened_axe", CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final Item ENLIGHTENED_HOE = registerItemAfter(ENLIGHTENED_AXE, new HoeBase(ENLIGHTENED), "enlightened_hoe", CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final Item ENLIGHTENED_SKELETONSWORD = registerItemAfter(Items.NETHERITE_SWORD, new SwordBase(ENLIGHTENED), "enlightened_skeleton_sword", CreativeModeTabs.COMBAT);

    public static final Item SKELETON_DAGGER = registerItemAfter(Items.TRIDENT, new DaggerBase(SKELETON), "skeleton_dagger", CreativeModeTabs.COMBAT);
    public static final Item ENLIGHTENED_SKELETON_DAGGER = registerItemAfter(SKELETON_DAGGER, new DaggerBase(ENLIGHTENED), "enlightened_skeleton_dagger", CreativeModeTabs.COMBAT);

    public static final Item SPEAR = registerItemAfter(ENLIGHTENED_SKELETON_DAGGER, new SwordBase(ENLIGHTENED), "spear", CreativeModeTabs.COMBAT);

    public static final Item SKELETON_HELMET = registerItemAfter(Items.DIAMOND_BOOTS, new BaseArmour(SKELETON_ARMOUR, EquipmentSlot.HEAD), "skeleton_helmet", CreativeModeTabs.COMBAT);
    public static final Item SKELETON_CHESTPLATE = registerItemAfter(SKELETON_HELMET, new BaseArmour(SKELETON_ARMOUR, EquipmentSlot.CHEST), "skeleton_chestplate", CreativeModeTabs.COMBAT);
    public static final Item SKELETON_LEGGINGS = registerItemAfter(SKELETON_CHESTPLATE, new BaseArmour(SKELETON_ARMOUR, EquipmentSlot.LEGS), "skeleton_leggings", CreativeModeTabs.COMBAT);
    public static final Item SKELETON_BOOTS = registerItemAfter(SKELETON_LEGGINGS, new BaseArmour(SKELETON_ARMOUR, EquipmentSlot.FEET), "skeleton_boots", CreativeModeTabs.COMBAT);

    public static final Item BRONZIUM_HELMET = registerItemAfter(SKELETON_BOOTS, new BaseArmour(BRONZIUM_ARMOUR, EquipmentSlot.HEAD), "bronzium_helmet", CreativeModeTabs.COMBAT);
    public static final Item BRONZIUM_CHESTPLATE = registerItemAfter(BRONZIUM_HELMET, new BaseArmour(BRONZIUM_ARMOUR, EquipmentSlot.CHEST), "bronzium_chestplate", CreativeModeTabs.COMBAT);
    public static final Item BRONZIUM_LEGGINGS = registerItemAfter(BRONZIUM_CHESTPLATE, new BaseArmour(BRONZIUM_ARMOUR, EquipmentSlot.LEGS), "bronzium_leggings", CreativeModeTabs.COMBAT);
    public static final Item BRONZIUM_BOOTS = registerItemAfter(BRONZIUM_LEGGINGS, new BaseArmour(BRONZIUM_ARMOUR, EquipmentSlot.FEET), "bronzium_boots", CreativeModeTabs.COMBAT);

    public static final Item AMBER_HELMET = registerItemAfter(Items.IRON_BOOTS, new BaseArmour(AMBER_ARMOR, EquipmentSlot.HEAD), "amber_helmet", CreativeModeTabs.COMBAT);
    public static final Item AMBER_CHESTPLATE = registerItemAfter(AMBER_HELMET, new BaseArmour(AMBER_ARMOR, EquipmentSlot.CHEST), "amber_chestplate", CreativeModeTabs.COMBAT);
    public static final Item AMBER_LEGGINGS = registerItemAfter(AMBER_CHESTPLATE, new BaseArmour(AMBER_ARMOR, EquipmentSlot.LEGS), "amber_leggings", CreativeModeTabs.COMBAT);
    public static final Item AMBER_BOOTS = registerItemAfter(AMBER_LEGGINGS, new BaseArmour(AMBER_ARMOR, EquipmentSlot.FEET), "amber_boots", CreativeModeTabs.COMBAT);

    public static final Item BRONZIUM_INGOT = registerItemAfter(Items.IRON_INGOT, new Item(new FabricItemSettings()), "bronzium_ingot", CreativeModeTabs.INGREDIENTS);
    public static final Item DINOSTEEL_INGOT = registerItemAfter(BRONZIUM_INGOT, new Item(new FabricItemSettings()), "dinosteel_ingot", CreativeModeTabs.INGREDIENTS);
    public static final Item TIME_FLINT = registerItemAfter(Items.FLINT, new Item(new FabricItemSettings()), "time_flint", CreativeModeTabs.INGREDIENTS);
    public static final Item WYVERN_CRYSTAL = registerItem(new Item(new FabricItemSettings()), "wyvern_crystal", CreativeModeTabs.INGREDIENTS);
    public static final Item SHARD_OF_ENLIGHTENMENT = registerItem(new Item(new FabricItemSettings().rarity(Rarity.EPIC)), "shard_of_enlightenment");
    public static final Item ENLIGHTENED_CORE = registerItem(new Item(new FabricItemSettings().rarity(Rarity.EPIC)), "enlightened_core");
    public static final Item ENLIGHTENED_NECKLACE = registerItem(new Item(new FabricItemSettings().rarity(Rarity.EPIC)), "enlightened_necklace");
    public static final Item DRAGONWOOD_BOAT = registerItemAfter(Items.MANGROVE_CHEST_BOAT, new BoatItem(false, DinoBoats.DRAGONWOOD, new FabricItemSettings().stacksTo(1)), "dragonwood_boat", CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final Item DRAGONWOOD_CHEST_BOAT = registerItemAfter(DRAGONWOOD_BOAT, new BoatItem(true, DinoBoats.DRAGONWOOD, new FabricItemSettings().stacksTo(1)), "dragonwood_chest_boat", CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final Item DRAGONWOOD_SIGN = registerItemAfter(Items.MANGROVE_SIGN, new SignItem(new FabricItemSettings().stacksTo(16),
            RegisterBlocks.DRAGONWOOD_SIGN, RegisterBlocks.DRAGONWOOD_WALL_SIGN), "dragonwood_sign", CreativeModeTabs.FUNCTIONAL_BLOCKS);

    public static final Item EMPTY_DNA_BOTTLE = registerItem(new Item(new FabricItemSettings()), "empty_dna_bottle");
    public static final Item DNA_BOTTLE = registerItem(new Item(new FabricItemSettings()), "dna_bottle");
    public static final Item MYSTERIOUS_DNA_BOTTLE = registerItem(new Item(new FabricItemSettings()), "mysterious_dna_bottle");
    public static final Item INFLAMED_DNA_BOTTLE = registerItem(new Item(new FabricItemSettings()), "inflamed_dna_bottle");
    public static final Item DINO_FEATHER = registerItem(new Item(new FabricItemSettings()), "dino_feather");
    public static final Item AMBER_GEM = registerItem(new Item(new FabricItemSettings()), "amber_gem");
    public static final Item DRAGONWOOD_SCRAP = registerItem(new Item(new FabricItemSettings()), "dragonwood_scrap", CreativeModeTabs.INGREDIENTS);
    public static final Item DINOBENCH = registerItemAfter(Items.CRAFTING_TABLE, new BlockItem(RegisterBlocks.DINOBENCH, new FabricItemSettings().rarity(Rarity.RARE)), "dinobench", CreativeModeTabs.FUNCTIONAL_BLOCKS);
    public static final Item DINO_EGG = registerItem(new BlockItem(RegisterBlocks.DINO_EGG, new FabricItemSettings().rarity(Rarity.EPIC)), "dino_egg");
    public static final Item INCUBATED_DINO_EGG = registerItem(new BlockItem(RegisterBlocks.INCUBATED_DINO_EGG, new FabricItemSettings().rarity(Rarity.EPIC)), "incubated_dino_egg");
    public static final Item DINOTANER = registerItem(new BlockItem(RegisterBlocks.DINOTANER, new FabricItemSettings().rarity(Rarity.RARE)), "dinotaner", CreativeModeTabs.FUNCTIONAL_BLOCKS);

    public static final Item SAUROPOD_SPAWN_EGG = registerItem(new SpawnEggItem(RegisterEntities.SAUROPOD, 25600, 9498256, new FabricItemSettings()), "sauropod_spawn_egg", CreativeModeTabs.SPAWN_EGGS);
    public static final Item THEROPOD_SPAWN_EGG = registerItem(new SpawnEggItem(RegisterEntities.THEROPOD, 0xff8c00, 16777215, new FabricItemSettings()), "theropod_spawn_egg", CreativeModeTabs.SPAWN_EGGS);
    public static final Item TROODON_SPAWN_EGG = registerItem(new SpawnEggItem(RegisterEntities.TROODON, 0x5c4033, 16753920, new FabricItemSettings()), "troodon_spawn_egg", CreativeModeTabs.SPAWN_EGGS);
    public static final Item MICORAPTOR_SPAWN_EGG = registerItem(new SpawnEggItem(RegisterEntities.MICRORAPTOR, 16753920, 132957, new FabricItemSettings()), "microraptor_spawn_egg", CreativeModeTabs.SPAWN_EGGS);
    public static final Item MOSASAURUS_SPAWN_EGG = registerItem(new SpawnEggItem(RegisterEntities.MOSASAURUS, 11393254, 9498256, new FabricItemSettings()), "mosasaurus_spawn_egg", CreativeModeTabs.SPAWN_EGGS);
    public static final Item CHINLEA_SPAWN_EGG = registerItem(new SpawnEggItem(RegisterEntities.CHINLEA, 144238144, 0xFFFFFF, new FabricItemSettings()), "chinlea_spawn_egg", CreativeModeTabs.SPAWN_EGGS);
    public static final Item STEGORAPTOR_SPAWN_EGG = registerItem(new SpawnEggItem(RegisterEntities.STEGORAPTOR, 25600, 139, new FabricItemSettings()), "stegoraptor_spawn_egg", CreativeModeTabs.SPAWN_EGGS);
    public static final Item DEINONYCHUS_SPAWN_EGG = registerItem(new SpawnEggItem(RegisterEntities.DEINONYCHUS, 167475200, 16753920, new FabricItemSettings()), "deinonychus_spawn_egg", CreativeModeTabs.SPAWN_EGGS);
    public static final Item PROFESSOR_SPAWN_EGG = registerItem(new SpawnEggItem(RegisterEntities.PROFESSOR, 0xFFFFFF, 0x808080, new FabricItemSettings()), "professor_spawn_egg", CreativeModeTabs.SPAWN_EGGS);
    public static final Item SCORPIUS_SPAWN_EGG = registerItem(new SpawnEggItem(RegisterEntities.SCORPIUS, 0x808080, 0xFFFF00, new FabricItemSettings()), "scorpius_spawn_egg", CreativeModeTabs.SPAWN_EGGS);
    public static final Item TYRANNOSAURUS_SPAWN_EGG = registerItem(new SpawnEggItem(RegisterEntities.TYRANNOSAURUS, 0xC8AE7E, 0xD1C0A8, new FabricItemSettings()), "tyrannosaurus_spawn_egg", CreativeModeTabs.SPAWN_EGGS);

    private RegisterItems() {
    }


    public static void registerAll() {
    }

    private static Item registerInstrument(Item instrument, String path, TagKey<Instrument> tagKey, CreativeModeTab.TabVisibility tabVisibility, CreativeModeTab... tabs) {
        var registered = actualRegister(instrument, path);
        var added = new ArrayList<>(Arrays.stream(tabs).toList());
        added.add(Dinocraft.ITEM_GROUP);
        FrozenCreativeTabs.addInstrument(instrument, tagKey, tabVisibility, added.toArray(new CreativeModeTab[]{}));
        return registered;
    }

    private static Item registerInstrumentBefore(Item comparedItem, Item instrument, String path, TagKey<Instrument> tagKey, CreativeModeTab.TabVisibility tabVisibility, CreativeModeTab... tabs) {
        var registered = actualRegister(instrument, path);
        var added = new ArrayList<>(Arrays.stream(tabs).toList());
        added.add(Dinocraft.ITEM_GROUP);
        FrozenCreativeTabs.addInstrumentBefore(comparedItem, instrument, tagKey, tabVisibility, added.toArray(new CreativeModeTab[]{}));
        return registered;
    }

    private static Item registerItem(Item item, String path, CreativeModeTab... tabs) {
        var registered = actualRegister(item, path);
        var added = new ArrayList<>(Arrays.stream(tabs).toList());
        added.add(Dinocraft.ITEM_GROUP);
        FrozenCreativeTabs.add(item, added.toArray(new CreativeModeTab[]{}));
        return registered;
    }

    private static Item registerItemBefore(ItemLike comparedItem, Item item, String path, CreativeModeTab... tabs) {
        return registerItemBefore(comparedItem, item, path, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS, tabs);
    }

    private static Item registerItemBefore(ItemLike comparedItem, Item item, String path, CreativeModeTab.TabVisibility tabVisibility, CreativeModeTab... tabs) {
        var registered = actualRegister(item, path);
        var added = new ArrayList<>(Arrays.stream(tabs).toList());
        added.add(Dinocraft.ITEM_GROUP);
        FrozenCreativeTabs.addBefore(comparedItem, item, tabVisibility, added.toArray(new CreativeModeTab[]{}));
        return registered;
    }

    private static Item registerItemAfter(ItemLike comparedItem, Item item, String path, CreativeModeTab... tabs) {
        return registerItemAfter(comparedItem, item, path, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS, tabs);
    }

    private static Item registerItemAfter(ItemLike comparedItem, Item item, String path, CreativeModeTab.TabVisibility tabVisibility, CreativeModeTab... tabs) {
        var registered = actualRegister(item, path);
        var added = new ArrayList<>(Arrays.stream(tabs).toList());
        added.add(Dinocraft.ITEM_GROUP);
        FrozenCreativeTabs.addAfter(comparedItem, item, tabVisibility, added.toArray(new CreativeModeTab[]{}));
        return registered;
    }

    private static Item actualRegister(Item item, String path) {
        var registry = BuiltInRegistries.ITEM;
        var location = Dinocraft.id(path);
        if (registry.getOptional(location).isEmpty()) {
            return Registry.register(registry, location, item);
        }
        return item;
    }

    private static void registerItem(String path, Item item, CreativeModeTab... tabs) {
        registerItem(item, path, tabs);
    }
}










