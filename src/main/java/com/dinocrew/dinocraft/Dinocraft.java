package com.dinocrew.dinocraft;

import com.dinocrew.dinocraft.recipe.ModRecipeSerializer;
import com.dinocrew.dinocraft.registry.*;
import com.dinocrew.dinocraft.block.ModBlockEntityTypes;
import com.dinocrew.dinocraft.registry.RegisterEnchantments;
import com.dinocrew.dinocraft.screen.ModScreenHandlerTypes;
import com.mojang.datafixers.schemas.Schema;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.Dynamic;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.frozenblock.dinocraft.Main;
import net.frozenblock.dinocraft.worldgen.trees.foliageplacers.DragonWoodFoliagePlacer;
import net.frozenblock.dinocraft.worldgen.trees.trunkplacers.DragonWoodTrunkPlacer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.datafix.fixes.SimpleEntityRenameFix;
import net.minecraft.util.datafix.schemas.NamespacedSchema;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import org.quiltmc.qsl.frozenblock.misc.datafixerupper.api.QuiltDataFixerBuilder;
import org.quiltmc.qsl.frozenblock.misc.datafixerupper.api.QuiltDataFixes;
import org.quiltmc.qsl.frozenblock.misc.datafixerupper.api.SimpleFixes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.util.Objects;

public final class Dinocraft implements ModInitializer {
    public static final String MOD_ID = "dinocraft";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static boolean DEV_LOGGING = false;
    public static boolean UNSTABLE_LOGGING = FabricLoader.getInstance().isDevelopmentEnvironment(); //Used for features that may be unstable and crash in public builds - it's smart to use this for at least registries.

    public static boolean areConfigsInit = false;

    public static final CreativeModeTab ITEM_GROUP = FabricItemGroup.builder(id("general")).icon(() -> new ItemStack(RegisterItems.FOSSIL)).build();
    public static final Path CONFIG_PATH = FabricLoader.getInstance().getConfigDir().resolve("dinocraft.json");

    public static final TrunkPlacerType<DragonWoodTrunkPlacer> DRAGONWOOD_TRUNK_PLACER = registerTrunk("dragonwood_trunk_placer", DragonWoodTrunkPlacer.CODEC);
    public static final FoliagePlacerType<DragonWoodFoliagePlacer> DRAGONWOOD_FOLIAGE_PLACER = registerFoliage("rich_foliage_placer", DragonWoodFoliagePlacer.CODEC);

    @Override
    public void onInitialize() {
        var dataFixer = applyDataFixes(FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow());
        Main.runner(MOD_ID); // Run FrozenBlock stuff


        RegisterItems.registerAll();
        RegisterBlocks.registerAll();
        RegisterEntities.registerAll();
        RegisterEnchantments.init();
        RegisterSpawns.registerAll();
        RegisterFeatures.registerAll();
        ModScreenHandlerTypes.initialize();
        ModRecipeSerializer.initialize();
        ModBlockEntityTypes.initialize();
        RegisterSounds.init();


    }

    public static final int DATA_VERSION = 3;

    private static QuiltDataFixerBuilder applyDataFixes(ModContainer mod) {
        log("Applying DataFixes for Dinocraft", true);
        var builder = new QuiltDataFixerBuilder(DATA_VERSION);
        builder.addSchema(0, QuiltDataFixes.BASE_SCHEMA);
        Schema schemaV1 = builder.addSchema(1, NamespacedSchema::new);
        builder.addFixer(new SimpleEntityRenameFix("EntityTyrannosaurusFix", schemaV1, true) {
            @Override
            protected Pair<String, Dynamic<?>> getNewNameAndTag(String name, Dynamic<?> tag) {
                return Pair.of(Objects.equals(name, identify("trex")) ? identify("tyrannosaurus") : name, tag);
            }
        });
        Schema schemaV2 = builder.addSchema(2, NamespacedSchema::new);
        SimpleFixes.addItemRenameFix(builder, "Rename trex_spawn_egg to tyrannosaurus_spawn_egg", id("trex_spawn_egg"), id("tyrannosaurus_spawn_egg"), schemaV2);
        Schema schemaV3 = builder.addSchema(3, NamespacedSchema::new);
        SimpleFixes.addItemRenameFix(builder, "Rename enlightened_skeletonsword to enlightened_skeleton_sword", id("enlightened_skeletonsword"), id("enlightened_skeleton_sword"), schemaV3);

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

    public static String identify(String id) {
        return MOD_ID + ":" + id;
    }

    public static <P extends TrunkPlacer> TrunkPlacerType<P> registerTrunk(String path, Codec<P> codec) {
        return Registry.register(BuiltInRegistries.TRUNK_PLACER_TYPE, id(path), new TrunkPlacerType<>(codec));
    }

    public static <P extends FoliagePlacer> FoliagePlacerType<P> registerFoliage(String path, Codec<P> codec) {
        return Registry.register(BuiltInRegistries.FOLIAGE_PLACER_TYPE, id(path), new FoliagePlacerType<>(codec));
    }
}






