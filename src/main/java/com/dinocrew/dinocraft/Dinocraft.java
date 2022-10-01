package com.dinocrew.dinocraft;

import com.dinocrew.dinocraft.mixins.FoliagePlacerTypeInvoker;
import com.dinocrew.dinocraft.mixins.TrunkPlacerTypeInvoker;
import com.dinocrew.dinocraft.recipe.ModRecipeSerializer;
import com.dinocrew.dinocraft.registry.*;
import com.dinocrew.dinocraft.registry.blocks.ModBlockEntityTypes;
import com.dinocrew.dinocraft.registry.enchantments.EnchantmentRegistry;
import com.dinocrew.dinocraft.screen.ModScreenHandlerTypes;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.loader.api.FabricLoader;
import net.frozenblock.Config;
import net.frozenblock.api.minecraft.worldgen.trees.foliageplacers.DragonWoodFoliagePlacer;
import net.frozenblock.api.minecraft.worldgen.trees.trunkplacers.DragonWoodTrunkPlacer;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.minecraft.world.gen.trunk.TrunkPlacerType;
import static net.minecraft.server.command.CommandManager.*;
import java.nio.file.Path;
import java.util.Properties;

public class Dinocraft implements ModInitializer {
    public static final String MOD_ID = "dinocraft";
    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(id("general"), () -> new ItemStack(ModItems.FOSSIL));

    public static Identifier identify(String id) {
        return new Identifier(MOD_ID + ":" + id);
    }

    public static boolean areConfigsInit = false;

    public static boolean hasCloth = FabricLoader.getInstance().isModLoaded("cloth-config");

    public static boolean naturally_generate_mobs;

    public static final Path CONFIG_PATH = FabricLoader.getInstance().getConfigDir().resolve("dinocraft.json");

    public static final TrunkPlacerType<DragonWoodTrunkPlacer> DRAGONWOOD_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("dragonwood_trunk_placer", DragonWoodTrunkPlacer.CODEC);
    public static final FoliagePlacerType<DragonWoodFoliagePlacer> DRAGONWOOD_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("rich_foliage_placer", DragonWoodFoliagePlacer.CODEC);

    @Override
    public void onInitialize() {

        naturally_generate_mobs = Boolean.parseBoolean((String) Config.getFixedConfig("naturally_generate_mobs"));


        net.frozenblock.Main.runner(MOD_ID); // Run FrozenBlock stuff


        ModItems.registerAll();
        ModBlocks.registerAll();
        ModEntities.registerAll();
        EnchantmentRegistry.init();
        ModSpawns.registerAll();
        ModFeatures.registerAll();
        ModBiomes.registerBiomes();
        ModScreenHandlerTypes.initialize();
        ModRecipeSerializer.initialize();
        ModBlockEntityTypes.initialize();
        RegisterSounds.init();
        // RegisterWorldgen.initialize();


    }

    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    }
}






