package com.dinocrew.dinocraft.entity.ai.behavior;

import com.dinocrew.dinocraft.entity.Tyrannosaurus;
import com.google.common.collect.ImmutableMap;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.behavior.Behavior;
import net.minecraft.world.entity.ai.behavior.BlockPosTracker;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;

import java.util.Map;

public class SetTyrannosaurusLookTarget extends Behavior<Tyrannosaurus> {

    public SetTyrannosaurusLookTarget() {
        super(
                ImmutableMap.of(
                        MemoryModuleType.DISTURBANCE_LOCATION,
                        MemoryStatus.REGISTERED,
                        MemoryModuleType.ROAR_TARGET,
                        MemoryStatus.REGISTERED,
                        MemoryModuleType.ATTACK_TARGET,
                        MemoryStatus.VALUE_ABSENT
                )
        );
    }

    @Override
    protected boolean checkExtraStartConditions(ServerLevel level, Tyrannosaurus tyrannosaurus) {
        return tyrannosaurus.getBrain().hasMemoryValue(MemoryModuleType.DISTURBANCE_LOCATION) || tyrannosaurus.getBrain().hasMemoryValue(MemoryModuleType.ROAR_TARGET);
    }

    @Override
    protected void start(ServerLevel level, Tyrannosaurus tyrannosaurus, long gameTime) {
        BlockPos blockPos = tyrannosaurus.getBrain()
                .getMemory(MemoryModuleType.ROAR_TARGET)
                .map(Entity::blockPosition)
                .or(() -> tyrannosaurus.getBrain().getMemory(MemoryModuleType.DISTURBANCE_LOCATION))
                .get();
        tyrannosaurus.getBrain().setMemory(MemoryModuleType.LOOK_TARGET, new BlockPosTracker(blockPos));
    }
}
