package com.dinocrew.dinocraft.client;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.client.screen.DinoBenchScreen;
import com.dinocrew.dinocraft.registry.ModBlocks;
import com.dinocrew.dinocraft.registry.ModEntities;
import com.dinocrew.dinocraft.registry.entities.*;
import com.dinocrew.dinocraft.screen.ModScreenHandlerTypes;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.frozenblock.registry.RegisterBlocks;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.GrassColor;

@Environment(EnvType.CLIENT)
public class DinocraftClient implements ClientModInitializer {
    public static final ModelLayerLocation MODEL_SAUROPOD_LAYER = new ModelLayerLocation(Dinocraft.id("sauropod"), "main");
    public static final ModelLayerLocation MODEL_THEROPOD_LAYER = new ModelLayerLocation(Dinocraft.id("theropod"), "main");
    public static final ModelLayerLocation MODEL_TROODON_LAYER = new ModelLayerLocation(Dinocraft.id("troodon"), "main");
    public static final ModelLayerLocation MODEL_MICRORAPTOR_LAYER = new ModelLayerLocation(Dinocraft.id("micorapter"), "main");
    public static final ModelLayerLocation MODEL_MOSASAURUS_LAYER = new ModelLayerLocation(Dinocraft.id("mosasasaurus"), "main");
    public static final ModelLayerLocation MODEL_STEGORAPTOR_LAYER = new ModelLayerLocation(Dinocraft.id("stegoraptor"), "main");
    public static final ModelLayerLocation MODEL_CHINLEA_LAYER = new ModelLayerLocation(Dinocraft.id("chinlea"), "main");
    public static final ModelLayerLocation MODEL_DRAGONWOOD_BOAT_LAYER = new ModelLayerLocation(Dinocraft.id("mangrove_boat"), "main");
    public static final ModelLayerLocation MODEL_DEINONYCHUS_LAYER = new ModelLayerLocation(Dinocraft.id("deinonyhchus"), "main");
    public static final ModelLayerLocation MODEL_PROFESSOR_LAYER = new ModelLayerLocation(Dinocraft.id("professor"), "main");
    public static final ModelLayerLocation MODEL_SCORPIUS_LAYER = new ModelLayerLocation(Dinocraft.id("scorpius"), "main");
    public static final ModelLayerLocation MODEL_TREX_LAYER = new ModelLayerLocation(Dinocraft.id("trex"), "main");

    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.register(ModEntities.SAUROPOD, SauropodEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_SAUROPOD_LAYER, SauropodEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.THEROPOD, TheropodEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_THEROPOD_LAYER, TheropodEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.TROODON, TroodonEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_TROODON_LAYER, TroodonEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.MICRORAPTOR, MicroraptorEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_MICRORAPTOR_LAYER, MicroRaptorEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.MOSASAURUS, MosasaurusEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_MOSASAURUS_LAYER, MosasaurusEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.STEGORAPTOR, StegoraptorEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_STEGORAPTOR_LAYER, StegoraptorEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.CHINLEA, ChinleaEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_CHINLEA_LAYER, ChinleaEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.DEINONYCHUS, DeinonychusEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_DEINONYCHUS_LAYER, DeinonychusEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.PROFESSOR, ProfessorEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_PROFESSOR_LAYER, ProfessorEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.SCORPIUS, ScorpiusEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_SCORPIUS_LAYER, ScorpiusEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.TREX, TRexEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_TREX_LAYER, TRexEntityModel::getTexturedModelData);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DRAGONWOOD_LEAVES, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.LIVERWORTS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.CYCADOPHYTA, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DRAGONGRASS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DINOSAUR_TEMPERED_GLASS, RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.INCUBATED_DINO_EGG, RenderType.cutout());
        ScreenRegistry.register(ModScreenHandlerTypes.DINO_BENCH_SCREEN_HANDLER_TYPE, DinoBenchScreen::new);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DRAGONWOOD_DOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DRAGONWOOD_SAPLING, RenderType.cutout());

        ColorProviderRegistry.BLOCK.register(((state, world, pos, tintIndex) -> {
            if (world != null) {
                return BiomeColors.getAverageGrassColor(world, pos);
            } else {
                return GrassColor.get(1, 1);
            }
        }), ModBlocks.DRAGONGRASS);

        ColorProviderRegistry.BLOCK.register(((state, world, pos, tintIndex) -> {
            if (world != null) {
                return BiomeColors.getAverageGrassColor(world, pos);
            } else {
                return GrassColor.get(1, 1);
            }
        }), RegisterBlocks.CYCADOPHYTA);

        ColorProviderRegistry.BLOCK.register(((state, world, pos, tintIndex) -> {
            if (world != null) {
                return BiomeColors.getAverageFoliageColor(world, pos);
            } else {
                return GrassColor.get(1, 1);
            }
        }), ModBlocks.DRAGONWOOD_LEAVES);

        ColorProviderRegistry.ITEM.register(((stack, tintIndex) -> GrassColor.get(1, 1)), ModBlocks.DRAGONGRASS);

        ColorProviderRegistry.ITEM.register(((stack, tintIndex) -> FoliageColor.getDefaultColor()), ModBlocks.DRAGONWOOD_LEAVES);

        ColorProviderRegistry.ITEM.register(((stack, tintIndex) -> GrassColor.get(1, 1)), RegisterBlocks.CYCADOPHYTA);
    }


}
