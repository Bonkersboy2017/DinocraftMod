package com.dinocrew.dinocraft.registry;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.registry.entities.*;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.registry.Registry;

public class ModEntities {
    public static final EntityType<SauropodEntity> SAUROPOD = Registry.register(Registry.ENTITY_TYPE, Dinocraft.id("sauropod"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SauropodEntity::new).dimensions(EntityDimensions.fixed(2F, 3F)).build());
    public static final EntityType<TheropodEntity> THEROPOD = Registry.register(Registry.ENTITY_TYPE, Dinocraft.id("theropod"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, TheropodEntity::new).dimensions(EntityDimensions.fixed(4f, 2.5f)).build());
    public static final EntityType<TroodonEntity> TROODON = Registry.register(Registry.ENTITY_TYPE, Dinocraft.id("troodon"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, TroodonEntity::new).dimensions(EntityDimensions.fixed(2f, 1.5f)).build());
    public static final EntityType<MicroraptorEntity> MICRORAPTOR = Registry.register(Registry.ENTITY_TYPE, Dinocraft.id("micoraptor"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MicroraptorEntity::new).dimensions(EntityDimensions.fixed(2f, 2.5f)).build());
    public static final EntityType<MosasaurusEntity> MOSASAURUS = Registry.register(Registry.ENTITY_TYPE, Dinocraft.id("mosasaurus"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MosasaurusEntity::new).dimensions(EntityDimensions.fixed(4f, 2f)).build());
    public static final EntityType<StegoraptorEntity> STEGORAPTOR = Registry.register(Registry.ENTITY_TYPE, Dinocraft.id("stegoraptor"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, StegoraptorEntity::new).dimensions(EntityDimensions.fixed(2f, 2)).build());
    public static final EntityType<ChinleaEntity> CHINLEA = Registry.register(Registry.ENTITY_TYPE, Dinocraft.id("chinlea"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, ChinleaEntity::new).dimensions(EntityDimensions.fixed(2f, 2)).build());
    public static final EntityType<DeinonychusEntity> DEINONYCHUS = Registry.register(Registry.ENTITY_TYPE, Dinocraft.id("deinonychus"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, DeinonychusEntity::new).dimensions(EntityDimensions.fixed(2f, 2)).build());
    public static final EntityType<ProffessorEntity> PROFFESOR = Registry.register(Registry.ENTITY_TYPE, Dinocraft.id("proffesor"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, ProffessorEntity::new).dimensions(EntityDimensions.fixed(1f, 2)).build());
    public static final EntityType<ScorpiusEntity> SCORPIUS = Registry.register(Registry.ENTITY_TYPE, Dinocraft.id("scorpius"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, ScorpiusEntity::new).dimensions(EntityDimensions.fixed(2f, 2)).build());
    public static final EntityType<TRexEntity> TREX = Registry.register(Registry.ENTITY_TYPE, Dinocraft.id("trex"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, TRexEntity::new).dimensions(EntityDimensions.fixed(4.5F, 4)).build());

    public static EntityType<DragonwoodBoatEntity> DRAGONWOOD_BOAT;

    public static void registerAll() {
        FabricDefaultAttributeRegistry.register(SAUROPOD, SauropodEntity.createDinoAttributes());
        FabricDefaultAttributeRegistry.register(THEROPOD, TheropodEntity.createDinoAttributes());
        FabricDefaultAttributeRegistry.register(TROODON, TroodonEntity.createDinoAttributes());
        FabricDefaultAttributeRegistry.register(MICRORAPTOR, MicroraptorEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(MOSASAURUS, MicroraptorEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(STEGORAPTOR, StegoraptorEntity.createDinoAttributes());
        FabricDefaultAttributeRegistry.register(CHINLEA, ChinleaEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DEINONYCHUS, DeinonychusEntity.createDinoAttributes());
        FabricDefaultAttributeRegistry.register(PROFFESOR, ProffessorEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(SCORPIUS, ScorpiusEntity.createDinoAttributes());
        FabricDefaultAttributeRegistry.register(TREX, TRexEntity.createDinoAttributes());

        DRAGONWOOD_BOAT = Registry.register(Registry.ENTITY_TYPE, Dinocraft.id("dragonwood_boat"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, DragonwoodBoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build());
    }
}
