package com.dinocrew.dinocraft.registry;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.registry.entities.*;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;

public class ModEntities {
    public static final EntityType<SauropodEntity> SAUROPOD = Registry.register(Registry.ENTITY_TYPE, new Identifier(Dinocraft.MOD_ID, "sauropod"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SauropodEntity::new).dimensions(EntityDimensions.fixed(2F, 3F)).build());
    public static final EntityType<TheropodEntity> THEROPOD = Registry.register(Registry.ENTITY_TYPE, new Identifier(Dinocraft.MOD_ID, "theropod"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, TheropodEntity::new).dimensions(EntityDimensions.fixed(4f, 2.5f)).build());
    public static final EntityType<TroodonEntity> TROODON = Registry.register(Registry.ENTITY_TYPE, new Identifier(Dinocraft.MOD_ID, "troodon"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, TroodonEntity::new).dimensions(EntityDimensions.fixed(2f, 1.5f)).build());
    public static final EntityType<MicroraptorEntity> MICRORAPTOR = Registry.register(Registry.ENTITY_TYPE, new Identifier(Dinocraft.MOD_ID, "micoraptor"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MicroraptorEntity::new).dimensions(EntityDimensions.fixed(2f, 2.5f)).build());
    public static final EntityType<MosasaurusEntity> MOSASAURUS = Registry.register(Registry.ENTITY_TYPE, new Identifier(Dinocraft.MOD_ID, "mosasaurus"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MosasaurusEntity::new).dimensions(EntityDimensions.fixed(8f, -5f)).build());
    public static final EntityType<StegoraptorEntity> STEGORAPTOR = Registry.register(Registry.ENTITY_TYPE, new Identifier(Dinocraft.MOD_ID, "stegoraptor"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, StegoraptorEntity::new).dimensions(EntityDimensions.fixed(2f, 2)).build());
    public static final EntityType<ChinleaEntity> CHINLEA = Registry.register(Registry.ENTITY_TYPE, new Identifier(Dinocraft.MOD_ID, "chinlea"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, ChinleaEntity::new).dimensions(EntityDimensions.fixed(2f, 2)).build());

    public static EntityType<DragonwoodBoatEntity> DRAGONWOOD_BOAT;

    public static void registerAll() {
        FabricDefaultAttributeRegistry.register(SAUROPOD, SauropodEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(THEROPOD, TheropodEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(TROODON, TroodonEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(MICRORAPTOR, MicroraptorEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(MOSASAURUS, MicroraptorEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(STEGORAPTOR, StegoraptorEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(CHINLEA, ChinleaEntity.createMobAttributes());

        DRAGONWOOD_BOAT = Registry.register(Registry.ENTITY_TYPE, new Identifier(Dinocraft.MOD_ID, "dragonwood_boat"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, DragonwoodBoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build());
    }
}
