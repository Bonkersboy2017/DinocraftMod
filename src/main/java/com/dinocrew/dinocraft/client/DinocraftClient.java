package com.dinocrew.dinocraft.client;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.registry.entities.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class DinocraftClient implements ClientModInitializer {
    public static final EntityModelLayer MODEL_SAUROPOD_LAYER = new EntityModelLayer(new Identifier("dinocraft", "sauropodl"), "main");
    public static final EntityModelLayer MODEL_THEROPOD_LAYER = new EntityModelLayer(new Identifier("dinocraft", "theropod"), "main");
    public static final EntityModelLayer MODEL_TROODON_LAYER = new EntityModelLayer(new Identifier("dinocraft", "troodonl"), "main");
    public static final EntityModelLayer MODEL_MICORAPTOR_LAYER = new EntityModelLayer(new Identifier("dinocraft", "micorapter"), "main");
    public static final EntityModelLayer MODEL_MOSASAURUS_LAYER = new EntityModelLayer(new Identifier("dinocraft", "mosasasaurus"), "main");

    @Override
    public void onInitializeClient() {


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


}}
