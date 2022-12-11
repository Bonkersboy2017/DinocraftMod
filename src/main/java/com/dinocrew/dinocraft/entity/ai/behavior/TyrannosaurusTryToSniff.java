package com.dinocrew.dinocraft.entity.ai.behavior;

import com.dinocrew.dinocraft.entity.Tyrannosaurus;
import com.google.common.collect.ImmutableMap;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Unit;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.behavior.Behavior;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;

public class TyrannosaurusTryToSniff extends Behavior<Tyrannosaurus> {
    private static final IntProvider SNIFF_COOLDOWN = UniformInt.of(200, 400);

    public TyrannosaurusTryToSniff() {
        super(
                ImmutableMap.of(
                        MemoryModuleType.SNIFF_COOLDOWN,
                        MemoryStatus.VALUE_ABSENT,
                        MemoryModuleType.NEAREST_ATTACKABLE,
                        MemoryStatus.VALUE_PRESENT,
                        MemoryModuleType.DISTURBANCE_LOCATION,
                        MemoryStatus.VALUE_ABSENT
                )
        );
    }

    protected void start(ServerLevel level, Tyrannosaurus tyrannosaurus, long gameTime) {
        Brain<? extends Tyrannosaurus> brain = tyrannosaurus.getBrain();
        brain.setMemory(MemoryModuleType.IS_SNIFFING, Unit.INSTANCE);
        brain.setMemoryWithExpiry(MemoryModuleType.SNIFF_COOLDOWN, Unit.INSTANCE, SNIFF_COOLDOWN.sample(level.getRandom()));
        brain.eraseMemory(MemoryModuleType.WALK_TARGET);
        tyrannosaurus.setPose(Pose.SNIFFING);
    }
}
