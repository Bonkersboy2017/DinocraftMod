package com.dinocrew.dinocraft.entity.ai;

import com.dinocrew.dinocraft.entity.Tyrannosaurus;
import com.dinocrew.dinocraft.entity.ai.behavior.*;
import com.dinocrew.dinocraft.registry.RegisterEntities;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Dynamic;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.Unit;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.behavior.*;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.entity.ai.sensing.Sensor;
import net.minecraft.world.entity.ai.sensing.SensorType;
import net.minecraft.world.entity.schedule.Activity;

import java.util.List;

public class TyrannosaurusAi {
    public static final float SPEED_MULTIPLIER_WHEN_IDLING = 0.5F;
    public static final float SPEED_MULTIPLIER_WHEN_INVESTIGATING = 0.7F;
    public static final float SPEED_MULTIPLIER_WHEN_FIGHTING = 1.2F;
    public static final int MELEE_ATTACK_COOLDOWN = 40;
    public static final int ROAR_DURATION = Mth.ceil(84.0F);
    public static final int SNIFFING_DURATION = Mth.ceil(83.2F);
    public static final int DISTURBANCE_LOCATION_EXPIRY_TIME = 100;
    private static final List<SensorType<? extends Sensor<? super Tyrannosaurus>>> SENSOR_TYPES = List.of(SensorType.NEAREST_PLAYERS, RegisterEntities.BASE_DINO_ENTITY_SENSOR);

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
            MemoryModuleType.ROAR_TARGET,
            MemoryModuleType.DISTURBANCE_LOCATION,
            MemoryModuleType.RECENT_PROJECTILE,
            MemoryModuleType.IS_SNIFFING,
            MemoryModuleType.ROAR_SOUND_DELAY,
            MemoryModuleType.ROAR_SOUND_COOLDOWN,
            MemoryModuleType.SNIFF_COOLDOWN,
            MemoryModuleType.TOUCH_COOLDOWN,
            MemoryModuleType.VIBRATION_COOLDOWN
    );

    public TyrannosaurusAi() {
    }

    public static void updateActivity(Tyrannosaurus dino) {
        dino.getBrain().setActiveActivityToFirstValid(ImmutableList.of(Activity.ROAR, Activity.FIGHT, Activity.INVESTIGATE, Activity.SNIFF, Activity.IDLE));
    }

    public static Brain<Tyrannosaurus> makeBrain(Tyrannosaurus dino, Dynamic<?> dynamic) {
        Brain.Provider<Tyrannosaurus> provider = Brain.provider(MEMORY_TYPES, SENSOR_TYPES);
        Brain<Tyrannosaurus> brain = provider.makeBrain(dynamic);
        initCoreActivity(brain);
        initIdleActivity(brain);
        initRoarActivity(brain);
        initFightActivity(dino, brain);
        initInvestigateActivity(brain);
        initSniffingActivity(brain);
        brain.setCoreActivities(ImmutableSet.of(Activity.CORE));
        brain.setDefaultActivity(Activity.IDLE);
        brain.useDefaultActivity();
        return brain;
    }

    private static void initCoreActivity(Brain<Tyrannosaurus> brain) {
        brain.addActivity(Activity.CORE,
                0,
                ImmutableList.of(
                        new Swim(0.8F),
                        new SetTyrannosaurusLookTarget(),
                        new LookAtTargetSink(45, 90),
                        new MoveToTargetSink()
                )
        );
    }

    private static void initIdleActivity(Brain<Tyrannosaurus> brain) {
        brain.addActivity(
                Activity.IDLE,
                10,
                ImmutableList.of(
                        new SetTyrannosaurusRoarTarget<>(Tyrannosaurus::getEntityAngryAt),
                        new TyrannosaurusTryToSniff(),
                        new RunOne<>(
                                ImmutableMap.of(MemoryModuleType.IS_SNIFFING, MemoryStatus.VALUE_ABSENT),
                                ImmutableList.of(Pair.of(new RandomStroll(SPEED_MULTIPLIER_WHEN_IDLING), 2), Pair.of(new DoNothing(30, 60), 1))
                        )
                )
        );
    }

    private static void initInvestigateActivity(Brain<Tyrannosaurus> brain) {
        brain.addActivityAndRemoveMemoryWhenStopped(
                Activity.INVESTIGATE,
                5,
                ImmutableList.of(new SetTyrannosaurusRoarTarget<>(Tyrannosaurus::getEntityAngryAt), new GoToTargetLocation<>(MemoryModuleType.DISTURBANCE_LOCATION, 2, SPEED_MULTIPLIER_WHEN_INVESTIGATING)),
                MemoryModuleType.DISTURBANCE_LOCATION
        );
    }

    private static void initSniffingActivity(Brain<Tyrannosaurus> brain) {
        brain.addActivityAndRemoveMemoryWhenStopped(
                Activity.SNIFF,
                5,
                ImmutableList.of(
                        new SetTyrannosaurusRoarTarget<>(Tyrannosaurus::getEntityAngryAt),
                        new TyrannosaurusSniffing<>(SNIFFING_DURATION)
                ),
                MemoryModuleType.IS_SNIFFING
        );
    }

    private static void initRoarActivity(Brain<Tyrannosaurus> brain) {
        brain.addActivityAndRemoveMemoryWhenStopped(
                Activity.ROAR,
                10,
                ImmutableList.of(
                        new TyrannosaurusRoar()
                ),
                MemoryModuleType.ROAR_TARGET
        );
    }

    private static void initFightActivity(Tyrannosaurus dino, Brain<Tyrannosaurus> brain) {
        brain.addActivityAndRemoveMemoryWhenStopped(
                Activity.FIGHT,
                10,
                ImmutableList.of(
                        new StopAttackingIfTargetInvalid<>(entity -> !dino.getAngerLevel().isAngry() || !dino.canTargetEntity(entity), TyrannosaurusAi::onTargetInvalid, false),
                        new SetEntityLookTarget(mob -> isTarget(dino, mob), (float) dino.getAttributeValue(Attributes.FOLLOW_RANGE)),
                        new SetWalkTargetFromAttackTargetIfTargetOutOfReach(SPEED_MULTIPLIER_WHEN_FIGHTING),
                        new MeleeAttack(MELEE_ATTACK_COOLDOWN)
                ),
                MemoryModuleType.ATTACK_TARGET
        );
    }

    private static boolean isTarget(Tyrannosaurus dino, LivingEntity entity) {
        return dino.getBrain().getMemory(MemoryModuleType.ATTACK_TARGET).filter(targetedEntity -> targetedEntity == entity).isPresent();
    }

    private static void onTargetInvalid(Tyrannosaurus dino, LivingEntity target) {
        if (!dino.canTargetEntity(target)) {
            dino.clearAnger(target);
        }
    }

    public static void setDisturbanceLocation(Tyrannosaurus dino, BlockPos disturbanceLocation) {
        if (dino.level.getWorldBorder().isWithinBounds(disturbanceLocation)
                && !dino.getEntityAngryAt().isPresent()
                && !dino.getBrain().getMemory(MemoryModuleType.ATTACK_TARGET).isPresent()) {
            dino.getBrain().setMemoryWithExpiry(MemoryModuleType.SNIFF_COOLDOWN, Unit.INSTANCE, DISTURBANCE_LOCATION_EXPIRY_TIME);
            dino.getBrain().setMemoryWithExpiry(MemoryModuleType.LOOK_TARGET, new BlockPosTracker(disturbanceLocation), DISTURBANCE_LOCATION_EXPIRY_TIME);
            dino.getBrain().setMemoryWithExpiry(MemoryModuleType.DISTURBANCE_LOCATION, disturbanceLocation, DISTURBANCE_LOCATION_EXPIRY_TIME);
            dino.getBrain().eraseMemory(MemoryModuleType.WALK_TARGET);
        }
    }
}
