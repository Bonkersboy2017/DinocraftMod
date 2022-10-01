package com.dinocrew.dinocraft.registry;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.registry.entities.*;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class ModEntities {
    public static final EntityType<Sauropod> SAUROPOD = Registry.register(Registry.ENTITY_TYPE, Dinocraft.id("sauropod"), FabricEntityTypeBuilder.createMob().entityFactory(Sauropod::new).spawnGroup(MobCategory.CREATURE).defaultAttributes(Sauropod::createDinoAttributes).dimensions(EntityDimensions.fixed(2F, 3F)).build());
    public static final EntityType<Theropod> THEROPOD = Registry.register(Registry.ENTITY_TYPE, Dinocraft.id("theropod"), FabricEntityTypeBuilder.createMob().entityFactory(Theropod::new).spawnGroup(MobCategory.CREATURE).defaultAttributes(Theropod::createDinoAttributes).dimensions(EntityDimensions.fixed(1.8F, 2.3F)).build());
    public static final EntityType<Troodon> TROODON = Registry.register(Registry.ENTITY_TYPE, Dinocraft.id("troodon"), FabricEntityTypeBuilder.createMob().entityFactory(Troodon::new).spawnGroup(MobCategory.CREATURE).defaultAttributes(Troodon::createDinoAttributes).dimensions(EntityDimensions.fixed(1.5F, 2.0F)).build());
    public static final EntityType<Microraptor> MICRORAPTOR = Registry.register(Registry.ENTITY_TYPE, Dinocraft.id("micoraptor"), FabricEntityTypeBuilder.createMob().entityFactory(Microraptor::new).spawnGroup(MobCategory.CREATURE).defaultAttributes(Microraptor::createDinoAttributes).dimensions(EntityDimensions.fixed(2.0F, 2.5F)).build());
    public static final EntityType<Mosasaurus> MOSASAURUS = Registry.register(Registry.ENTITY_TYPE, Dinocraft.id("mosasaurus"), FabricEntityTypeBuilder.createMob().entityFactory(Mosasaurus::new).spawnGroup(MobCategory.CREATURE).defaultAttributes(Mosasaurus::createMobAttributes).dimensions(EntityDimensions.fixed(4.0F, 2.0F)).build());
    public static final EntityType<Stegoraptor> STEGORAPTOR = Registry.register(Registry.ENTITY_TYPE, Dinocraft.id("stegoraptor"), FabricEntityTypeBuilder.createMob().entityFactory(Stegoraptor::new).spawnGroup(MobCategory.CREATURE).defaultAttributes(Stegoraptor::createDinoAttributes).dimensions(EntityDimensions.fixed(1.7F, 2.0F)).build());
    public static final EntityType<Chinlea> CHINLEA = Registry.register(Registry.ENTITY_TYPE, Dinocraft.id("chinlea"), FabricEntityTypeBuilder.createMob().entityFactory(Chinlea::new).spawnGroup(MobCategory.CREATURE).defaultAttributes(Chinlea::createMobAttributes).dimensions(EntityDimensions.fixed(0.7F, 0.5F)).build());
    public static final EntityType<Deinonychus> DEINONYCHUS = Registry.register(Registry.ENTITY_TYPE, Dinocraft.id("deinonychus"), FabricEntityTypeBuilder.createMob().entityFactory(Deinonychus::new).spawnGroup(MobCategory.CREATURE).defaultAttributes(Deinonychus::createDinoAttributes).dimensions(EntityDimensions.fixed(1.4F, 1.5F)).build());
    public static final EntityType<Professor> PROFESSOR = Registry.register(Registry.ENTITY_TYPE, Dinocraft.id("professor"), FabricEntityTypeBuilder.createMob().entityFactory(Professor::new).spawnGroup(MobCategory.CREATURE).defaultAttributes(Professor::createMobAttributes).dimensions(EntityDimensions.fixed(0.6F, 1.8F)).trackedUpdateRate(2).build());
    public static final EntityType<Scorpius> SCORPIUS = Registry.register(Registry.ENTITY_TYPE, Dinocraft.id("scorpius"), FabricEntityTypeBuilder.createMob().entityFactory(Scorpius::new).spawnGroup(MobCategory.CREATURE).defaultAttributes(Scorpius::createDinoAttributes).dimensions(EntityDimensions.fixed(2.0F, 2.3F)).build());
    public static final EntityType<Tyrannosaurus> TYRANNOSAURUS = Registry.register(Registry.ENTITY_TYPE, Dinocraft.id("tyrannosaurus"), FabricEntityTypeBuilder.createMob().entityFactory(Tyrannosaurus::new).spawnGroup(MobCategory.CREATURE).defaultAttributes(Tyrannosaurus::createDinoAttributes).dimensions(EntityDimensions.fixed(2.8F, 2.6F)).build());

    public static void registerAll() {
    }
}
