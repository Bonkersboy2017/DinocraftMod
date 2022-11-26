package com.dinocrew.dinocraft;

import com.dinocrew.dinocraft.client.screen.DinoBenchScreen;
import com.dinocrew.dinocraft.entity.render.*;
import com.dinocrew.dinocraft.registry.RegisterBlocks;
import com.dinocrew.dinocraft.registry.RegisterEntities;
import com.dinocrew.dinocraft.screen.ModScreenHandlerTypes;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.GrassColor;

@Environment(EnvType.CLIENT)
public final class DinocraftClient implements ClientModInitializer {
    public static final ModelLayerLocation MODEL_SAUROPOD_LAYER = new ModelLayerLocation(Dinocraft.id("sauropod"), "main");
    public static final ModelLayerLocation MODEL_THEROPOD_LAYER = new ModelLayerLocation(Dinocraft.id("theropod"), "main");
    public static final ModelLayerLocation MODEL_TROODON_LAYER = new ModelLayerLocation(Dinocraft.id("troodon"), "main");
    public static final ModelLayerLocation MODEL_MICRORAPTOR_LAYER = new ModelLayerLocation(Dinocraft.id("micorapter"), "main");
    public static final ModelLayerLocation MODEL_MOSASAURUS_LAYER = new ModelLayerLocation(Dinocraft.id("mosasasaurus"), "main");
    public static final ModelLayerLocation MODEL_STEGORAPTOR_LAYER = new ModelLayerLocation(Dinocraft.id("stegoraptor"), "main");
    public static final ModelLayerLocation MODEL_CHINLEA_LAYER = new ModelLayerLocation(Dinocraft.id("chinlea"), "main");
    public static final ModelLayerLocation MODEL_DEINONYCHUS_LAYER = new ModelLayerLocation(Dinocraft.id("deinonyhchus"), "main");
    public static final ModelLayerLocation MODEL_PROFESSOR_LAYER = new ModelLayerLocation(Dinocraft.id("professor"), "main");
    public static final ModelLayerLocation MODEL_SCORPIUS_LAYER = new ModelLayerLocation(Dinocraft.id("scorpius"), "main");
    public static final ModelLayerLocation MODEL_TREX_LAYER = new ModelLayerLocation(Dinocraft.id("trex"), "main");

    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.register(RegisterEntities.SAUROPOD, SauropodRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_SAUROPOD_LAYER, SauropodModel::createBodyLayer);
        EntityRendererRegistry.register(RegisterEntities.THEROPOD, TheropodRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_THEROPOD_LAYER, TheropodModel::createBodyLayer);
        EntityRendererRegistry.register(RegisterEntities.TROODON, TroodonRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_TROODON_LAYER, TroodonModel::createBodyLayer);
        EntityRendererRegistry.register(RegisterEntities.MICRORAPTOR, MicroraptorRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_MICRORAPTOR_LAYER, MicroraptorModel::createBodyLayer);
        EntityRendererRegistry.register(RegisterEntities.MOSASAURUS, MosasaurusRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_MOSASAURUS_LAYER, MosasaurusModel::createBodyLayer);
        EntityRendererRegistry.register(RegisterEntities.STEGORAPTOR, StegoraptorRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_STEGORAPTOR_LAYER, StegoraptorModel::createBodyLayer);
        EntityRendererRegistry.register(RegisterEntities.CHINLEA, ChinleaRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_CHINLEA_LAYER, ChinleaModel::createBodyLayer);
        EntityRendererRegistry.register(RegisterEntities.DEINONYCHUS, DeinonychusRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_DEINONYCHUS_LAYER, DeinonychusModel::createBodyLayer);
        EntityRendererRegistry.register(RegisterEntities.PROFESSOR, ProfessorRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_PROFESSOR_LAYER, ProfessorModel::createBodyLayer);
        EntityRendererRegistry.register(RegisterEntities.SCORPIUS, ScorpiusRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_SCORPIUS_LAYER, ScorpiusModel::createBodyLayer);
        EntityRendererRegistry.register(RegisterEntities.TYRANNOSAURUS, TyrannosaurusRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_TREX_LAYER, TyrannosaurusModel::createBodyLayer);

        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.DRAGONWOOD_LEAVES, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(net.frozenblock.registry.RegisterBlocks.LIVERWORTS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(net.frozenblock.registry.RegisterBlocks.CYCADOPHYTA, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.DRAGONGRASS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.DINOSAUR_TEMPERED_GLASS, RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.INCUBATED_DINO_EGG, RenderType.cutout());
        ScreenRegistry.register(ModScreenHandlerTypes.DINO_BENCH_SCREEN_HANDLER_TYPE, DinoBenchScreen::new);
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.DRAGONWOOD_DOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.DRAGONWOOD_SAPLING, RenderType.cutout());

        ColorProviderRegistry.BLOCK.register(((state, world, pos, tintIndex) -> {
            if (world != null) {
                return BiomeColors.getAverageGrassColor(world, pos);
            } else {
                return GrassColor.get(1, 1);
            }
        }), RegisterBlocks.DRAGONGRASS);

        ColorProviderRegistry.BLOCK.register(((state, world, pos, tintIndex) -> {
            if (world != null) {
                return BiomeColors.getAverageGrassColor(world, pos);
            } else {
                return GrassColor.get(1, 1);
            }
        }), net.frozenblock.registry.RegisterBlocks.CYCADOPHYTA);

        ColorProviderRegistry.BLOCK.register(((state, world, pos, tintIndex) -> {
            if (world != null) {
                return BiomeColors.getAverageFoliageColor(world, pos);
            } else {
                return GrassColor.get(1, 1);
            }
        }), RegisterBlocks.DRAGONWOOD_LEAVES);

        ColorProviderRegistry.ITEM.register(((stack, tintIndex) -> GrassColor.get(1, 1)), RegisterBlocks.DRAGONGRASS);

        ColorProviderRegistry.ITEM.register(((stack, tintIndex) -> FoliageColor.getDefaultColor()), RegisterBlocks.DRAGONWOOD_LEAVES);

        ColorProviderRegistry.ITEM.register(((stack, tintIndex) -> GrassColor.get(1, 1)), net.frozenblock.registry.RegisterBlocks.CYCADOPHYTA);
    }


}
