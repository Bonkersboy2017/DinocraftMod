package com.dinocrew.dinocraft.registry;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.registry.entities.*;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.registry.Registry;

public class ModEntities {
    public static final EntityType<SauropodEntity> SAUROPOD = Registry.register(Registry.ENTITY_TYPE, Dinocraft.id("sauropod"), FabricEntityTypeBuilder.createMob().entityFactory(SauropodEntity::new).spawnGroup(SpawnGroup.CREATURE).defaultAttributes(SauropodEntity::createDinoAttributes).dimensions(EntityDimensions.fixed(2F, 3F)).build());
    public static final EntityType<TheropodEntity> THEROPOD = Registry.register(Registry.ENTITY_TYPE, Dinocraft.id("theropod"), FabricEntityTypeBuilder.createMob().entityFactory(TheropodEntity::new).spawnGroup(SpawnGroup.CREATURE).defaultAttributes(TheropodEntity::createDinoAttributes).dimensions(EntityDimensions.fixed(1.8F, 2.3F)).build());
    public static final EntityType<TroodonEntity> TROODON = Registry.register(Registry.ENTITY_TYPE, Dinocraft.id("troodon"), FabricEntityTypeBuilder.createMob().entityFactory(TroodonEntity::new).spawnGroup(SpawnGroup.CREATURE).defaultAttributes(TroodonEntity::createDinoAttributes).dimensions(EntityDimensions.fixed(1.5F, 2.0F)).build());
    public static final EntityType<MicroraptorEntity> MICRORAPTOR = Registry.register(Registry.ENTITY_TYPE, Dinocraft.id("micoraptor"), FabricEntityTypeBuilder.createMob().entityFactory(MicroraptorEntity::new).spawnGroup(SpawnGroup.CREATURE).defaultAttributes(MicroraptorEntity::createDinoAttributes).dimensions(EntityDimensions.fixed(2.0F, 2.5F)).build());
    public static final EntityType<MosasaurusEntity> MOSASAURUS = Registry.register(Registry.ENTITY_TYPE, Dinocraft.id("mosasaurus"), FabricEntityTypeBuilder.createMob().entityFactory(MosasaurusEntity::new).spawnGroup(SpawnGroup.CREATURE).defaultAttributes(MosasaurusEntity::createMobAttributes).dimensions(EntityDimensions.fixed(4.0F, 2.0F)).build());
    public static final EntityType<StegoraptorEntity> STEGORAPTOR = Registry.register(Registry.ENTITY_TYPE, Dinocraft.id("stegoraptor"), FabricEntityTypeBuilder.createMob().entityFactory(StegoraptorEntity::new).spawnGroup(SpawnGroup.CREATURE).defaultAttributes(StegoraptorEntity::createDinoAttributes).dimensions(EntityDimensions.fixed(1.7F, 2.0F)).build());
    public static final EntityType<ChinleaEntity> CHINLEA = Registry.register(Registry.ENTITY_TYPE, Dinocraft.id("chinlea"), FabricEntityTypeBuilder.createMob().entityFactory(ChinleaEntity::new).spawnGroup(SpawnGroup.CREATURE).defaultAttributes(ChinleaEntity::createMobAttributes).dimensions(EntityDimensions.fixed(0.7F, 0.5F)).build());
    public static final EntityType<DeinonychusEntity> DEINONYCHUS = Registry.register(Registry.ENTITY_TYPE, Dinocraft.id("deinonychus"), FabricEntityTypeBuilder.createMob().entityFactory(DeinonychusEntity::new).spawnGroup(SpawnGroup.CREATURE).defaultAttributes(DeinonychusEntity::createDinoAttributes).dimensions(EntityDimensions.fixed(1.4F, 1.5F)).build());
    public static final EntityType<ProfessorEntity> PROFESSOR = Registry.register(Registry.ENTITY_TYPE, Dinocraft.id("professor"), FabricEntityTypeBuilder.createMob().entityFactory(ProfessorEntity::new).spawnGroup(SpawnGroup.CREATURE).defaultAttributes(ProfessorEntity::createMobAttributes).dimensions(EntityDimensions.fixed(0.6F, 1.8F)).trackedUpdateRate(2).build());
    public static final EntityType<ScorpiusEntity> SCORPIUS = Registry.register(Registry.ENTITY_TYPE, Dinocraft.id("scorpius"), FabricEntityTypeBuilder.createMob().entityFactory(ScorpiusEntity::new).spawnGroup(SpawnGroup.CREATURE).defaultAttributes(ScorpiusEntity::createDinoAttributes).dimensions(EntityDimensions.fixed(2.0F, 2.3F)).build());
    public static final EntityType<TRexEntity> TREX = Registry.register(Registry.ENTITY_TYPE, Dinocraft.id("trex"), FabricEntityTypeBuilder.createMob().entityFactory(TRexEntity::new).spawnGroup(SpawnGroup.CREATURE).defaultAttributes(TRexEntity::createDinoAttributes).dimensions(EntityDimensions.fixed(2.8F, 2.6F)).build());

    public static void registerAll() {
    }
}
