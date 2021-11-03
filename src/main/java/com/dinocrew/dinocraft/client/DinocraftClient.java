package com.dinocrew.dinocraft.client;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.registry.*;
import com.dinocrew.dinocraft.registry.entities.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@Environment(EnvType.CLIENT)
public class DinocraftClient implements ClientModInitializer {
    public static final EntityModelLayer MODEL_SAUROPOD_LAYER = new EntityModelLayer(new Identifier("dinocraft", "sauropod"), "main");
    public static final EntityModelLayer MODEL_THEROPOD_LAYER = new EntityModelLayer(new Identifier("dinocraft", "theropod"), "main");
    public static final EntityModelLayer MODEL_TROODON_LAYER = new EntityModelLayer(new Identifier("dinocraft", "troodon"), "main");
    public static final EntityModelLayer MODEL_MICORAPTOR_LAYER = new EntityModelLayer(new Identifier("dinocraft", "micorapter"), "main");
    public static final EntityModelLayer MODEL_MOSASAURUS_LAYER = new EntityModelLayer(new Identifier("dinocraft", "mosasasaurus"), "main");

    @Override
    public void onInitializeClient() {


        EntityRendererRegistry.INSTANCE.register(Dinocraft.SAUROPOD, (context) -> {
            return new SauropodEntityRenderer(context);
        });
        EntityModelLayerRegistry.registerModelLayer(MODEL_SAUROPOD_LAYER, sauropod::getTexturedModelData);

        EntityRendererRegistry.INSTANCE.register(Dinocraft.THEROPOD, (context) -> {
            return new TheropodEntityRenderer(context);
        });
        EntityModelLayerRegistry.registerModelLayer(MODEL_THEROPOD_LAYER, theropod::getTexturedModelData);


        EntityRendererRegistry.INSTANCE.register(Dinocraft.TROODON, (context) -> {
            return new TroodonEntityRenderer(context);
        });
        EntityModelLayerRegistry.registerModelLayer(MODEL_TROODON_LAYER, troodon::getTexturedModelData);

        EntityRendererRegistry.INSTANCE.register(Dinocraft.MICORAPTOR, (context) -> {
            return new MicoraptorEntityRenderer(context);
        });
        EntityModelLayerRegistry.registerModelLayer(MODEL_MICORAPTOR_LAYER, microraptor::getTexturedModelData);

        EntityRendererRegistry.INSTANCE.register(Dinocraft.MOSASAURUS, (context) -> {
            return new MosasaurusEntityRenderer(context);
        });
        EntityModelLayerRegistry.registerModelLayer(MODEL_MOSASAURUS_LAYER, mosasaurus::getTexturedModelData);


}}
