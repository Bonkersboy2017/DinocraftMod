package com.dinocrew.dinocraft;

import com.dinocrew.dinocraft.mixins.FoliagePlacerTypeInvoker;
import com.dinocrew.dinocraft.mixins.TrunkPlacerTypeInvoker;
import com.dinocrew.dinocraft.recipe.ModRecipeSerializer;
import com.dinocrew.dinocraft.registry.*;
import com.dinocrew.dinocraft.registry.blocks.ModBlockEntityTypes;
import com.dinocrew.dinocraft.registry.enchantments.EnchantmentRegistry;
import com.dinocrew.dinocraft.registry.worldgen.RegisterWorldgen;
import com.dinocrew.dinocraft.screen.ModScreenHandlerTypes;
import com.mojang.datafixers.schemas.Schema;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Dynamic;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.frozenblock.api.minecraft.worldgen.trees.foliageplacers.DragonWoodFoliagePlacer;
import net.frozenblock.api.minecraft.worldgen.trees.trunkplacers.DragonWoodTrunkPlacer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.datafix.fixes.SimpleEntityRenameFix;
import net.minecraft.util.datafix.schemas.NamespacedSchema;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import org.quiltmc.qsl.frozenblock.misc.datafixerupper.api.QuiltDataFixerBuilder;
import org.quiltmc.qsl.frozenblock.misc.datafixerupper.api.QuiltDataFixes;
import org.quiltmc.qsl.frozenblock.misc.datafixerupper.api.SimpleFixes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.util.Objects;

public class Dinocraft implements ModInitializer {
    public static final String MOD_ID = "dinocraft";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final CreativeModeTab ITEM_GROUP = FabricItemGroupBuilder.build(id("general"), () -> new ItemStack(ModItems.FOSSIL));

    public static ResourceLocation identify(String id) {
        return new ResourceLocation(MOD_ID + ":" + id);
    }

    public static boolean areConfigsInit = false;

    public static boolean hasCloth = FabricLoader.getInstance().isModLoaded("cloth-config");

    public static final Path CONFIG_PATH = FabricLoader.getInstance().getConfigDir().resolve("dinocraft.json");

    public static final TrunkPlacerType<DragonWoodTrunkPlacer> DRAGONWOOD_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("dragonwood_trunk_placer", DragonWoodTrunkPlacer.CODEC);
    public static final FoliagePlacerType<DragonWoodFoliagePlacer> DRAGONWOOD_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("rich_foliage_placer", DragonWoodFoliagePlacer.CODEC);

    @Override
    public void onInitialize() {
        var dataFixer = applyDataFixes(FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow());
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
        RegisterWorldgen.initialize();


    }

    public static final int DATA_VERSION = 1;

    private static QuiltDataFixerBuilder applyDataFixes(ModContainer mod) {
        log("Applying DataFixes for Dinocraft", true);
        var builder = new QuiltDataFixerBuilder(DATA_VERSION);
        builder.addSchema(0, QuiltDataFixes.BASE_SCHEMA);
        Schema schemaV1 = builder.addSchema(1, NamespacedSchema::new);
        builder.addFixer(new SimpleEntityRenameFix("EntityTyrannosaurusFix", schemaV1, true) {
            @Override
            protected Pair<String, Dynamic<?>> getNewNameAndTag(String name, Dynamic<?> tag) {
                return Pair.of(Objects.equals(name, id("trex").toString()) ? id("tyrannosaurus").toString() : name, tag);
            }
        });

        QuiltDataFixes.buildAndRegisterFixer(mod, builder);
        log("DataFixes for Dinocraft have been applied", true);
        return builder;
    }

    //LOGGING
    public static void log(String string, boolean shouldLog) {
        if (shouldLog) {
            LOGGER.info(string);
        }
    }

    public static void logInsane(String string, boolean shouldLog) {
        if (shouldLog) {
            for (int i = 0; i < Math.random() * 5; i++) {
                LOGGER.warn(string);
                LOGGER.error(string);
                LOGGER.warn(string);
                LOGGER.error(string);
                LOGGER.warn(string);
                LOGGER.error(string);
                LOGGER.warn(string);
                LOGGER.error(string);
            }
        }
    }

    public static void log(Entity entity, String string, boolean shouldLog) {
        if (shouldLog) {
            LOGGER.info(entity.toString() + " : " + string + " : " + entity.position());
        }
    }

    public static void log(Block block, String string, boolean shouldLog) {
        if (shouldLog) {
            LOGGER.info(block.toString() + " : " + string + " : ");
        }
    }

    public static void log(Block block, BlockPos pos, String string, boolean shouldLog) {
        if (shouldLog) {
            LOGGER.info(block.toString() + " : " + string + " : " + pos);
        }
    }

    public static void logDino(String string, boolean shouldLog) {
        if (shouldLog) {
            LOGGER.info(string + " " + MOD_ID);
        }
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}






