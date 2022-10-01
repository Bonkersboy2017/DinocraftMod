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

        EntityRendererRegistry.register(ModEntities.SAUROPOD, SauropodRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_SAUROPOD_LAYER, SauropodModel::createBodyLayer);
        EntityRendererRegistry.register(ModEntities.THEROPOD, TheropodRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_THEROPOD_LAYER, TheropodModel::createBodyLayer);
        EntityRendererRegistry.register(ModEntities.TROODON, TroodonRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_TROODON_LAYER, TroodonModel::createBodyLayer);
        EntityRendererRegistry.register(ModEntities.MICRORAPTOR, MicroraptorRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_MICRORAPTOR_LAYER, MicroraptorModel::createBodyLayer);
        EntityRendererRegistry.register(ModEntities.MOSASAURUS, MosasaurusRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_MOSASAURUS_LAYER, MosasaurusModel::createBodyLayer);
        EntityRendererRegistry.register(ModEntities.STEGORAPTOR, StegoraptorRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_STEGORAPTOR_LAYER, StegoraptorModel::createBodyLayer);
        EntityRendererRegistry.register(ModEntities.CHINLEA, ChinleaRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_CHINLEA_LAYER, ChinleaModel::createBodyLayer);
        EntityRendererRegistry.register(ModEntities.DEINONYCHUS, DeinonychusRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_DEINONYCHUS_LAYER, DeinonychusModel::createBodyLayer);
        EntityRendererRegistry.register(ModEntities.PROFESSOR, ProfessorRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_PROFESSOR_LAYER, ProfessorModel::createBodyLayer);
        EntityRendererRegistry.register(ModEntities.SCORPIUS, ScorpiusRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_SCORPIUS_LAYER, ScorpiusModel::createBodyLayer);
        EntityRendererRegistry.register(ModEntities.TYRANNOSAURUS, TyrannosaurusRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_TREX_LAYER, TyrannosaurusModel::createBodyLayer);

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
