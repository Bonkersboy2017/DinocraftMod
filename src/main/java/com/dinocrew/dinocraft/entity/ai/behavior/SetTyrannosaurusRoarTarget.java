package com.dinocrew.dinocraft.entity.ai.behavior;

import com.dinocrew.dinocraft.entity.Tyrannosaurus;
import com.google.common.collect.ImmutableMap;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.behavior.Behavior;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;

import java.util.Optional;
import java.util.function.Function;

public class SetTyrannosaurusRoarTarget<E extends Tyrannosaurus> extends Behavior<E> {
    private final Function<E, Optional<? extends LivingEntity>> targetFinderFunction;

    public SetTyrannosaurusRoarTarget(Function<E, Optional<? extends LivingEntity>> targetFinderFunction) {
        super(
                ImmutableMap.of(
                        MemoryModuleType.ROAR_TARGET,
                        MemoryStatus.VALUE_ABSENT,
                        MemoryModuleType.ATTACK_TARGET,
                        MemoryStatus.VALUE_ABSENT,
                        MemoryModuleType.CANT_REACH_WALK_TARGET_SINCE,
                        MemoryStatus.REGISTERED
                )
        );
        this.targetFinderFunction = targetFinderFunction;
    }

    protected boolean checkExtraStartConditions(ServerLevel level, E owner) {
        return this.targetFinderFunction.apply(owner).filter(owner::canTargetEntity).isPresent();
    }

    protected void start(ServerLevel level, E entity, long gameTime) {
        this.targetFinderFunction.apply(entity).ifPresent(entityx -> {
            entity.getBrain().setMemory(MemoryModuleType.ROAR_TARGET, entityx);
            entity.getBrain().eraseMemory(MemoryModuleType.CANT_REACH_WALK_TARGET_SINCE);
        });
    }
}
