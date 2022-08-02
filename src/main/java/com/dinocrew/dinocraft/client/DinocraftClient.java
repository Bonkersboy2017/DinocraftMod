package com.dinocrew.dinocraft.client;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.client.screen.DinoBenchScreen;
import com.dinocrew.dinocraft.registry.ModBlocks;
import com.dinocrew.dinocraft.registry.ModEntities;
import com.dinocrew.dinocraft.registry.entities.*;
import com.dinocrew.dinocraft.screen.ModScreenHandlerTypes;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.frozenblock.registry.RegisterBlocks;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.FoliageColors;
import net.minecraft.client.color.world.GrassColors;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;
import org.quiltmc.qsl.block.extensions.api.client.BlockRenderLayerMap;

@Environment(EnvType.CLIENT)
public class DinocraftClient implements ClientModInitializer {
    public static final EntityModelLayer MODEL_SAUROPOD_LAYER = new EntityModelLayer(Dinocraft.id("sauropod"), "main");
    public static final EntityModelLayer MODEL_THEROPOD_LAYER = new EntityModelLayer(Dinocraft.id("theropod"), "main");
    public static final EntityModelLayer MODEL_TROODON_LAYER = new EntityModelLayer(Dinocraft.id("troodon"), "main");
    public static final EntityModelLayer MODEL_MICRORAPTOR_LAYER = new EntityModelLayer(Dinocraft.id("micorapter"), "main");
    public static final EntityModelLayer MODEL_MOSASAURUS_LAYER = new EntityModelLayer(Dinocraft.id("mosasasaurus"), "main");
    public static final EntityModelLayer MODEL_STEGORAPTOR_LAYER = new EntityModelLayer(Dinocraft.id("stegoraptor"), "main");
    public static final EntityModelLayer MODEL_CHINLEA_LAYER = new EntityModelLayer(Dinocraft.id("chinlea"), "main");
    public static final EntityModelLayer MODEL_DEINONYCHUS_LAYER = new EntityModelLayer(Dinocraft.id("deinonyhchus"), "main");
    public static final EntityModelLayer MODEL_PROFESSOR_LAYER = new EntityModelLayer(Dinocraft.id("professor"), "main");
    public static final EntityModelLayer MODEL_SCORPIUS_LAYER = new EntityModelLayer(Dinocraft.id("scorpius"), "main");
    public static final EntityModelLayer MODEL_TREX_LAYER = new EntityModelLayer(Dinocraft.id("trex"), "main");

    @Override
    public void onInitializeClient(ModContainer modContainer) {

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

        BlockRenderLayerMap.put(RenderLayer.getCutout(), ModBlocks.DRAGONWOOD_LEAVES);

        BlockRenderLayerMap.put(RenderLayer.getCutout(), RegisterBlocks.LIVERWORTS);

        BlockRenderLayerMap.put(RenderLayer.getCutout(), RegisterBlocks.CYCADOPHYTA);

        BlockRenderLayerMap.put(RenderLayer.getCutout(), ModBlocks.DRAGONGRASS);

        BlockRenderLayerMap.put(RenderLayer.getTranslucent(), ModBlocks.DINOSAUR_TEMPERED_GLASS);

        BlockRenderLayerMap.put(RenderLayer.getCutout(), ModBlocks.INCUBATED_DINO_EGG);

        HandledScreens.register(ModScreenHandlerTypes.DINO_BENCH_SCREEN_HANDLER_TYPE, DinoBenchScreen::new);

        ColorProviderRegistry.BLOCK.register(((state, world, pos, tintIndex) -> {
            if (world != null) {
                return BiomeColors.getGrassColor(world, pos);
            } else {
                return GrassColors.getColor(1, 1);
            }
        }), ModBlocks.DRAGONGRASS);

        ColorProviderRegistry.BLOCK.register(((state, world, pos, tintIndex) -> {
            if (world != null) {
                return BiomeColors.getGrassColor(world, pos);
            } else {
                return GrassColors.getColor(1, 1);
            }
        }), RegisterBlocks.CYCADOPHYTA);

        ColorProviderRegistry.BLOCK.register(((state, world, pos, tintIndex) -> {
            if (world != null) {
                return BiomeColors.getFoliageColor(world, pos);
            } else {
                return GrassColors.getColor(1, 1);
            }
        }), ModBlocks.DRAGONWOOD_LEAVES);

        ColorProviderRegistry.ITEM.register(((stack, tintIndex) -> GrassColors.getColor(1, 1)), ModBlocks.DRAGONGRASS);

        ColorProviderRegistry.ITEM.register(((stack, tintIndex) -> FoliageColors.getDefaultColor()), ModBlocks.DRAGONWOOD_LEAVES);

        ColorProviderRegistry.ITEM.register(((stack, tintIndex) -> GrassColors.getColor(1, 1)), RegisterBlocks.CYCADOPHYTA);
    }


}
