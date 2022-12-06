package com.dinocrew.dinocraft.entity.ai;

import com.dinocrew.dinocraft.entity.AquaticDino;
import com.dinocrew.dinocraft.entity.BaseDino;
import com.dinocrew.dinocraft.registry.RegisterEntities;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Dynamic;
import net.frozenblock.lib.entity.api.behavior.BreatheAir;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.behavior.*;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.sensing.Sensor;
import net.minecraft.world.entity.ai.sensing.SensorType;
import net.minecraft.world.entity.schedule.Activity;

import java.util.List;

public class AquaticDinoAi {

    private static final List<SensorType<? extends Sensor<? super AquaticDino>>> SENSOR_TYPES = List.of(SensorType.NEAREST_PLAYERS, RegisterEntities.AQUATIC_DINO_ENTITY_SENSOR);

    private static final List<MemoryModuleType<?>> MEMORY_TYPES = List.of(
            MemoryModuleType.NEAREST_LIVING_ENTITIES,
            MemoryModuleType.NEAREST_VISIBLE_LIVING_ENTITIES,
            MemoryModuleType.NEAREST_VISIBLE_PLAYER,
            MemoryModuleType.NEAREST_VISIBLE_ATTACKABLE_PLAYER,
            MemoryModuleType.NEAREST_VISIBLE_NEMESIS,
            MemoryModuleType.LOOK_TARGET,
            MemoryModuleType.WALK_TARGET,
            MemoryModuleType.CANT_REACH_WALK_TARGET_SINCE,
            MemoryModuleType.PATH,
            MemoryModuleType.ATTACK_TARGET,
            MemoryModuleType.ATTACK_COOLING_DOWN,
            MemoryModuleType.NEAREST_ATTACKABLE,
            MemoryModuleType.TOUCH_COOLDOWN
    );

    private AquaticDinoAi() {
    }

    public static void updateActivity(AquaticDino dino) {
        dino.getBrain().setActiveActivityToFirstValid(ImmutableList.of(Activity.FIGHT, Activity.IDLE));
    }

    public static Brain<AquaticDino> makeBrain(AquaticDino dino, Dynamic<?> dynamic) {
        Brain.Provider<AquaticDino> provider = Brain.provider(MEMORY_TYPES, SENSOR_TYPES);
        Brain<AquaticDino> brain = provider.makeBrain(dynamic);
        initCoreActivity(brain);
        initIdleActivity(brain);
        initFightActivity(dino, brain);
        brain.setCoreActivities(ImmutableSet.of(Activity.CORE));
        brain.setDefaultActivity(Activity.IDLE);
        brain.useDefaultActivity();
        return brain;
    }

    private static void initCoreActivity(Brain<AquaticDino> brain) {
        brain.addActivity(Activity.CORE,
                0,
                ImmutableList.of(
                        new SetEntityLookTarget(8.0F),
                        new LookAtTargetSink(45, 90),
                        new MoveToTargetSink()
                )
        );
    }

    private static void initIdleActivity(Brain<AquaticDino> brain) {
        brain.addActivity(
                Activity.IDLE,
                10,
                ImmutableList.of(
                        new StartAttacking<>(sus -> sus.getBrain().getMemory(MemoryModuleType.NEAREST_VISIBLE_ATTACKABLE_PLAYER)),
                        new TryFindWater(10, 1.0F),
                        new RunOne<>(
                                ImmutableList.of(
                                        Pair.of(new BreatheAir<>(), 3),
                                        Pair.of(new RandomSwim(1.0F), 2),
                                        Pair.of(new DoNothing(30, 60), 1)
                                )
                        )
                )
        );
    }

    private static void initFightActivity(AquaticDino dino, Brain<AquaticDino> brain) {
        brain.addActivityAndRemoveMemoryWhenStopped(
                Activity.FIGHT,
                10,
                ImmutableList.of(
                        new SetEntityLookTarget(mob -> isTarget(dino, mob), (float) dino.getAttributeValue(Attributes.FOLLOW_RANGE)),
                        new SetWalkTargetFromAttackTargetIfTargetOutOfReach(1.2F),
                        new MeleeAttack(18),
                        new StopAttackingIfTargetInvalid<>()
                ),
                MemoryModuleType.ATTACK_TARGET
        );
    }

    private static boolean isTarget(AquaticDino dino, LivingEntity entity) {
        return dino.getBrain().getMemory(MemoryModuleType.ATTACK_TARGET).filter(targetedEntity -> targetedEntity == entity).isPresent();
    }
}
