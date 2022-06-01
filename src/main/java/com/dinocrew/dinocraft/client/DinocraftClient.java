package com.dinocrew.dinocraft.client;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.client.screen.DinoBenchScreen;
import com.dinocrew.dinocraft.registry.ModEntities;
import com.dinocrew.dinocraft.registry.ModBlocks;
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
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.FoliageColors;
import net.minecraft.client.color.world.GrassColors;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class DinocraftClient implements ClientModInitializer {
    public static final EntityModelLayer MODEL_SAUROPOD_LAYER = new EntityModelLayer(new Identifier(Dinocraft.MOD_ID, "sauropod"), "main");
    public static final EntityModelLayer MODEL_THEROPOD_LAYER = new EntityModelLayer(new Identifier(Dinocraft.MOD_ID, "theropod"), "main");
    public static final EntityModelLayer MODEL_TROODON_LAYER = new EntityModelLayer(new Identifier(Dinocraft.MOD_ID, "troodon"), "main");
    public static final EntityModelLayer MODEL_MICRORAPTOR_LAYER = new EntityModelLayer(new Identifier("dinocraft", "micorapter"), "main");
    public static final EntityModelLayer MODEL_MOSASAURUS_LAYER = new EntityModelLayer(new Identifier("dinocraft", "mosasasaurus"), "main");
    public static final EntityModelLayer MODEL_STEGORAPTOR_LAYER = new EntityModelLayer(new Identifier("dinocraft", "stegoraptor"), "main");
    public static final EntityModelLayer MODEL_CHINLEA_LAYER = new EntityModelLayer(new Identifier("dinocraft", "chinlea"), "main");
    public static final EntityModelLayer MODEL_DRAGONWOOD_BOAT_LAYER = new EntityModelLayer(new Identifier("dinocraft", "mangrove_boat"), "main");
    public static final EntityModelLayer MODEL_DEINONYCHUS_LAYER = new EntityModelLayer(new Identifier("dinocraft", "deinonyhchus"), "main");
    public static final EntityModelLayer MODEL_PROFFESOR_LAYER = new EntityModelLayer(new Identifier("dinocraft", "professor"), "main");
    public static final EntityModelLayer MODEL_SCORPIUS_LAYER = new EntityModelLayer(new Identifier("dinocraft", "scorpius"), "main");

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
        EntityRendererRegistry.register(ModEntities.DRAGONWOOD_BOAT, DragonwoodBoatEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_DRAGONWOOD_BOAT_LAYER, DragonwoodBoatEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.DEINONYCHUS, DeinonychusEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_DEINONYCHUS_LAYER, DeinonychusEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.PROFFESOR, ProffesorEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_PROFFESOR_LAYER, ProffesorEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.SCORPIUS, ScorpiusEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_SCORPIUS_LAYER, ScorpiusEntityModel::getTexturedModelData);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DRAGONWOOD_LEAVES, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.LIVERWORTS, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.CYCADOPHYTA, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DRAGONGRASS, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DINOSAUR_TEMPERED_GLASS, RenderLayer.getTranslucent());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.INCUBATED_DINO_EGG, RenderLayer.getCutout());

        ScreenRegistry.register(ModScreenHandlerTypes.DINO_BENCH_SCREEN_HANDLER_TYPE, DinoBenchScreen::new);

        ColorProviderRegistry.BLOCK.register(((state, world, pos, tintIndex) -> {
            if(world != null) {
                return BiomeColors.getGrassColor(world, pos);
            } else {
                return GrassColors.getColor(1,1);
            }
        }), ModBlocks.DRAGONGRASS);

        ColorProviderRegistry.BLOCK.register(((state, world, pos, tintIndex) -> {
            if(world != null) {
                return BiomeColors.getGrassColor(world, pos);
            } else {
                return GrassColors.getColor(1,1);
            }
        }), RegisterBlocks.CYCADOPHYTA);

        ColorProviderRegistry.BLOCK.register(((state, world, pos, tintIndex) -> {
            if(world != null) {
                return BiomeColors.getFoliageColor(world, pos);
            } else {
                return GrassColors.getColor(1,1);
            }
        }), ModBlocks.DRAGONWOOD_LEAVES);

        ColorProviderRegistry.ITEM.register(((stack, tintIndex) -> GrassColors.getColor(1,1)), ModBlocks.DRAGONGRASS);

        ColorProviderRegistry.ITEM.register(((stack, tintIndex) -> FoliageColors.getDefaultColor()), ModBlocks.DRAGONWOOD_LEAVES);

        ColorProviderRegistry.ITEM.register(((stack, tintIndex) -> GrassColors.getColor(1,1)), RegisterBlocks.CYCADOPHYTA);
    }


}
