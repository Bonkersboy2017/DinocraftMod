package com.dinocrew.dinocraft.client;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.registry.ModEntities;
import com.dinocrew.dinocraft.registry.ModBlocks;
import com.dinocrew.dinocraft.registry.entities.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
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

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DRAGONWOOD_LEAVES, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DINOSAUR_TEMPERED_GLASS, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.INCUBATED_DINO_EGG, RenderLayer.getCutout());


    }


}
