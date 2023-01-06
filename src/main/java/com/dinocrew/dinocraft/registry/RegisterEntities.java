package com.dinocrew.dinocraft.registry;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.entity.*;
import com.dinocrew.dinocraft.entity.ai.sensor.AquaticDinoEntitySensor;
import com.dinocrew.dinocraft.entity.ai.sensor.BaseDinoEntitySensor;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.sensing.Sensor;
import net.minecraft.world.entity.ai.sensing.SensorType;
import net.minecraft.world.level.levelgen.Heightmap;

import java.util.function.Supplier;

public final class RegisterEntities {
    public static final EntityType<Sauropod> SAUROPOD = register("sauropod", FabricEntityTypeBuilder.createMob().entityFactory(Sauropod::new).spawnGroup(MobCategory.CREATURE).defaultAttributes(Sauropod::createDinoAttributes).dimensions(EntityDimensions.fixed(2F, 3F)).build());
    public static final EntityType<Theropod> THEROPOD = register("theropod", FabricEntityTypeBuilder.createMob().entityFactory(Theropod::new).spawnGroup(MobCategory.CREATURE).defaultAttributes(Theropod::createDinoAttributes).dimensions(EntityDimensions.fixed(1.8F, 2.3F)).build());
    public static final EntityType<Troodon> TROODON = register("troodon", FabricEntityTypeBuilder.createMob().entityFactory(Troodon::new).spawnGroup(MobCategory.CREATURE).defaultAttributes(Troodon::createDinoAttributes).dimensions(EntityDimensions.fixed(1.5F, 2.0F)).build());
    public static final EntityType<Microraptor> MICRORAPTOR = register("micoraptor", FabricEntityTypeBuilder.createMob().entityFactory(Microraptor::new).spawnGroup(MobCategory.CREATURE).defaultAttributes(Microraptor::createDinoAttributes).dimensions(EntityDimensions.fixed(2.0F, 2.5F)).build());
    public static final EntityType<Mosasaurus> MOSASAURUS = register("mosasaurus", FabricEntityTypeBuilder.createMob().entityFactory(Mosasaurus::new).spawnGroup(MobCategory.CREATURE).defaultAttributes(Mosasaurus::createDinoAttributes).dimensions(EntityDimensions.fixed(4.0F, 2.0F)).build());
    public static final EntityType<Stegoraptor> STEGORAPTOR = register("stegoraptor", FabricEntityTypeBuilder.createMob().entityFactory(Stegoraptor::new).spawnGroup(MobCategory.CREATURE).defaultAttributes(Stegoraptor::createDinoAttributes).dimensions(EntityDimensions.fixed(1.7F, 2.0F)).build());
    public static final EntityType<Chinlea> CHINLEA = register("chinlea", FabricEntityTypeBuilder.createMob().entityFactory(Chinlea::new).spawnGroup(MobCategory.CREATURE).defaultAttributes(Chinlea::createDinoAttributes).dimensions(EntityDimensions.fixed(0.7F, 0.5F)).build());
    public static final EntityType<Deinonychus> DEINONYCHUS = register("deinonychus", FabricEntityTypeBuilder.createMob().entityFactory(Deinonychus::new).spawnGroup(MobCategory.CREATURE).defaultAttributes(Deinonychus::createDinoAttributes).dimensions(EntityDimensions.fixed(1.2F, 1.5F)).build());
    public static final EntityType<Professor> PROFESSOR = register("professor", FabricEntityTypeBuilder.createMob().entityFactory(Professor::new).spawnGroup(MobCategory.CREATURE).defaultAttributes(Professor::createMobAttributes).dimensions(EntityDimensions.fixed(0.6F, 1.8F)).trackedUpdateRate(2).build());
    public static final EntityType<Scorpius> SCORPIUS = register("scorpius", FabricEntityTypeBuilder.createMob().entityFactory(Scorpius::new).spawnGroup(MobCategory.CREATURE).defaultAttributes(Scorpius::createDinoAttributes).dimensions(EntityDimensions.fixed(2.0F, 2.3F)).build());
    public static final EntityType<Tyrannosaurus> TYRANNOSAURUS = register("tyrannosaurus", FabricEntityTypeBuilder.createMob().entityFactory(Tyrannosaurus::new).spawnGroup(MobCategory.CREATURE).defaultAttributes(Tyrannosaurus::createDinoAttributes).dimensions(EntityDimensions.fixed(2.5F, 2.6F)).build());

    public static final SensorType<BaseDinoEntitySensor> BASE_DINO_ENTITY_SENSOR = registerSensor("base_dino_entity_sensor", BaseDinoEntitySensor::new);
    public static final SensorType<AquaticDinoEntitySensor> AQUATIC_DINO_ENTITY_SENSOR = registerSensor("aquatic_dino_entity_sensor", AquaticDinoEntitySensor::new);

    private RegisterEntities() {
    }

    public static void registerAll() {
        Dinocraft.logDino("Registering Entities for", Dinocraft.UNSTABLE_LOGGING);
        SpawnPlacements.register(SAUROPOD, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Sauropod::canSpawn);
        SpawnPlacements.register(THEROPOD, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Theropod::canSpawn);
        SpawnPlacements.register(TROODON, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Troodon::canSpawn);
        SpawnPlacements.register(MICRORAPTOR, SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING, Microraptor::canSpawn);
        SpawnPlacements.register(MOSASAURUS, SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mosasaurus::canSpawn);
        SpawnPlacements.register(STEGORAPTOR, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Stegoraptor::canSpawn);
        SpawnPlacements.register(CHINLEA, SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Chinlea::canSpawn);
        SpawnPlacements.register(DEINONYCHUS, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Deinonychus::canSpawn);
        SpawnPlacements.register(PROFESSOR, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Professor::canSpawn);
        SpawnPlacements.register(SCORPIUS, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Scorpius::canSpawn);
        SpawnPlacements.register(TYRANNOSAURUS, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Tyrannosaurus::canSpawn);
    }

    private static <E extends Entity> EntityType<E> register(String key, EntityType<E> type) {
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, Dinocraft.id(key), type);
    }

    private static <U extends Sensor<?>> SensorType<U> registerSensor(String key, Supplier<U> sensorSupplier) {
        return Registry.register(BuiltInRegistries.SENSOR_TYPE, Dinocraft.id(key), new SensorType<>(sensorSupplier));
    }
}
