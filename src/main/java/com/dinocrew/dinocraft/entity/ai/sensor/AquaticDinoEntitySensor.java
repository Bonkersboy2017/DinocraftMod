package com.dinocrew.dinocraft.entity.ai.sensor;

import com.dinocrew.dinocraft.entity.AquaticDino;
import com.dinocrew.dinocraft.entity.BaseDino;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.sensing.NearestLivingEntitySensor;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

public class AquaticDinoEntitySensor extends NearestLivingEntitySensor<AquaticDino> {

    @Override
    @NotNull
    public Set<MemoryModuleType<?>> requires() {
        return ImmutableSet.copyOf(Iterables.concat(super.requires(), List.of(MemoryModuleType.NEAREST_ATTACKABLE)));
    }

    protected void doTick(ServerLevel level, AquaticDino dino) {
        super.doTick(level, dino);
        getClosest(dino, livingEntity -> livingEntity.getType() == EntityType.PLAYER)
                .or(() -> getClosest(dino, livingEntity -> livingEntity.getType() != EntityType.PLAYER))
                .ifPresentOrElse(
                        livingEntity -> dino.getBrain().setMemory(MemoryModuleType.NEAREST_ATTACKABLE, livingEntity),
                        () -> dino.getBrain().eraseMemory(MemoryModuleType.NEAREST_ATTACKABLE)
                );
    }

    private static Optional<LivingEntity> getClosest(AquaticDino dino, Predicate<LivingEntity> predicate) {
        return dino.getBrain()
                .getMemory(MemoryModuleType.NEAREST_LIVING_ENTITIES)
                .stream()
                .flatMap(Collection::stream)
                .filter(dino::canTargetEntity)
                .filter(predicate)
                .findFirst();
    }

    @Override
    protected int radiusXZ() {
        return 24;
    }

    @Override
    protected int radiusY() {
        return 24;
    }
}
