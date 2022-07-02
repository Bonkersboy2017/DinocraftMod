package com.dinocrew.dinocraft.registry;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.registry.entities.*;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;

public class ModEntities {
    public static final EntityType<SauropodEntity> SAUROPOD = Registry.register(Registry.ENTITY_TYPE, new Identifier(Dinocraft.MOD_ID, "sauropod"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SauropodEntity::new).dimensions(EntityDimensions.fixed(2F, 3F)).build());
    public static final EntityType<TheropodEntity> THEROPOD = Registry.register(Registry.ENTITY_TYPE, new Identifier(Dinocraft.MOD_ID, "theropod"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, TheropodEntity::new).dimensions(EntityDimensions.fixed(4f, 2.5f)).build());
    public static final EntityType<TroodonEntity> TROODON = Registry.register(Registry.ENTITY_TYPE, new Identifier(Dinocraft.MOD_ID, "troodon"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, TroodonEntity::new).dimensions(EntityDimensions.fixed(2f, 1.5f)).build());
    public static final EntityType<MicroraptorEntity> MICRORAPTOR = Registry.register(Registry.ENTITY_TYPE, new Identifier(Dinocraft.MOD_ID, "micoraptor"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MicroraptorEntity::new).dimensions(EntityDimensions.fixed(2f, 2.5f)).build());
    public static final EntityType<MosasaurusEntity> MOSASAURUS = Registry.register(Registry.ENTITY_TYPE, new Identifier(Dinocraft.MOD_ID, "mosasaurus"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MosasaurusEntity::new).dimensions(EntityDimensions.fixed(4f, 2f)).build());
    public static final EntityType<StegoraptorEntity> STEGORAPTOR = Registry.register(Registry.ENTITY_TYPE, new Identifier(Dinocraft.MOD_ID, "stegoraptor"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, StegoraptorEntity::new).dimensions(EntityDimensions.fixed(2f, 2)).build());
    public static final EntityType<ChinleaEntity> CHINLEA = Registry.register(Registry.ENTITY_TYPE, new Identifier(Dinocraft.MOD_ID, "chinlea"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, ChinleaEntity::new).dimensions(EntityDimensions.fixed(2f, 2)).build());
    public static final EntityType<DeinonychusEntity> DEINONYCHUS = Registry.register(Registry.ENTITY_TYPE, new Identifier(Dinocraft.MOD_ID, "deinonychus"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, DeinonychusEntity::new).dimensions(EntityDimensions.fixed(2f, 2)).build());
    public static final EntityType<ProffessorEntity> PROFFESOR = Registry.register(Registry.ENTITY_TYPE, new Identifier(Dinocraft.MOD_ID, "proffesor"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, ProffessorEntity::new).dimensions(EntityDimensions.fixed(1f, 2)).build());
    public static final EntityType<ScorpiusEntity> SCORPIUS = Registry.register(Registry.ENTITY_TYPE, new Identifier(Dinocraft.MOD_ID, "scorpius"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, ScorpiusEntity::new).dimensions(EntityDimensions.fixed(2f, 2)).build());
    public static final EntityType<IndoraptorEntity> INDORAPTOR = Registry.register(Registry.ENTITY_TYPE, new Identifier(Dinocraft.MOD_ID, "indoraptor"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, IndoraptorEntity::new).dimensions(EntityDimensions.fixed(4.5F, 4)).build());

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
        FabricDefaultAttributeRegistry.register(INDORAPTOR, IndoraptorEntity.createDinoAttributes());

        DRAGONWOOD_BOAT = Registry.register(Registry.ENTITY_TYPE, new Identifier(Dinocraft.MOD_ID, "dragonwood_boat"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, DragonwoodBoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build());
    }
}
