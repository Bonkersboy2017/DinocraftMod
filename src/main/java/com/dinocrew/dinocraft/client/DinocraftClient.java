package com.dinocrew.dinocraft.client;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.registry.ModBlocks;
import com.dinocrew.dinocraft.registry.entities.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.FoliageColors;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class DinocraftClient implements ClientModInitializer {
    public static final EntityModelLayer MODEL_SAUROPOD_LAYER = new EntityModelLayer(new Identifier("dinocraft", "sauropodl"), "main");
    public static final EntityModelLayer MODEL_THEROPOD_LAYER = new EntityModelLayer(new Identifier("dinocraft", "theropod"), "main");
    public static final EntityModelLayer MODEL_TROODON_LAYER = new EntityModelLayer(new Identifier("dinocraft", "troodonl"), "main");
    public static final EntityModelLayer MODEL_MICORAPTOR_LAYER = new EntityModelLayer(new Identifier("dinocraft", "micorapter"), "main");
    public static final EntityModelLayer MODEL_MOSASAURUS_LAYER = new EntityModelLayer(new Identifier("dinocraft", "mosasasaurus"), "main");
    public static final EntityModelLayer MODEL_STEGORAPTOR_LAYER = new EntityModelLayer(new Identifier("dinocraft", "stegoraptor"), "main");
    public static final EntityModelLayer MODEL_DRAGONWOOD_BOAT_LAYER = new EntityModelLayer(new Identifier("dinocraft", "mangrove_boat"), "main");

    @Override
    public void onInitializeClient() {

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DRAGONWOOD_LEAVES, RenderLayer.getCutout());


        EntityRendererRegistry.INSTANCE.register(Dinocraft.SAUROPOD, SauropodEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_SAUROPOD_LAYER, SauropodEntityModel::getTexturedModelData);

        EntityRendererRegistry.INSTANCE.register(Dinocraft.THEROPOD, TheropodEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_THEROPOD_LAYER, TheropodEntityModel::getTexturedModelData);

        EntityRendererRegistry.INSTANCE.register(Dinocraft.TROODON, (context) -> new TroodonEntityRenderer(context));
        EntityModelLayerRegistry.registerModelLayer(MODEL_TROODON_LAYER, TroodonEntityModel::getTexturedModelData);

        EntityRendererRegistry.INSTANCE.register(Dinocraft.MICORAPTOR, MicoraptorEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_MICORAPTOR_LAYER, MicroRaptorEntityModel::getTexturedModelData);

        EntityRendererRegistry.INSTANCE.register(Dinocraft.MOSASAURUS, MosasaurusEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_MOSASAURUS_LAYER, MosasaurusEntityModel::getTexturedModelData);

        EntityRendererRegistry.INSTANCE.register(Dinocraft.STEGORAPTOR, StegoraptorEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_STEGORAPTOR_LAYER, StegoraptorEntityModel::getTexturedModelData);

        EntityRendererRegistry.INSTANCE.register(Dinocraft.DRAGONWOOD_BOAT, DragonwoodBoatEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_DRAGONWOOD_BOAT_LAYER, DragonwoodBoatEntityModel::getTexturedModelData);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DRAGONWOOD_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DINOSAUR_TEMPERED_GLASS, RenderLayer.getCutout());


    }


}
