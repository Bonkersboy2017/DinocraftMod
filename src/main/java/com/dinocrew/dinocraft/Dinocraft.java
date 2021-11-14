package com.dinocrew.dinocraft;

import com.dinocrew.dinocraft.registry.*;
import com.dinocrew.dinocraft.registry.entities.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Dinocraft implements ModInitializer {

    public static Identifier getID( String path )
    {
        return new Identifier ( "dm", path ); }



    public static final String MOD_ID = "dm";

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
            new Identifier(MOD_ID, "general"),
            () -> new ItemStack(ModItems.FOSSIL));

    public static final EntityType<SauropodEntity> SAUROPOD = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("dinocraft", "sauropod"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SauropodEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
    );

    public static final EntityType<TheropodEntity> THEROPOD = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("dinocraft", "theropod"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, TheropodEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
    );

    public static final EntityType<TroodonEntity> TROODON = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("dinocraft", "troodon"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, TroodonEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
    );

    public static final EntityType<MicroraptorEntity> MICORAPTOR = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("dinocraft", "micoraptor"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MicroraptorEntity::new).dimensions(EntityDimensions.fixed(1.5f, 2.5f)).build()
    );

    public static final EntityType<MosasaurusEntity> MOSASAURUS = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("dinocraft", "mosasaurus"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MosasaurusEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
    );
    public static final EntityType<StegoraptorEntity> STEGORAPTOR = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("dinocraft", "stegoraptor"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, StegoraptorEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
    );




    @Override
    public void onInitialize() {
        ModItems.registerItems();
        ModBlocks.registerAll();
        FabricDefaultAttributeRegistry.register(SAUROPOD, SauropodEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(THEROPOD, TheropodEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(TROODON, TroodonEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(MICORAPTOR, MicroraptorEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(MOSASAURUS, MicroraptorEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(STEGORAPTOR, StegoraptorEntity.createMobAttributes());
        

    }

    }

