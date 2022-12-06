package com.dinocrew.dinocraft.entity.ai.behavior;

import com.dinocrew.dinocraft.entity.Tyrannosaurus;
import com.dinocrew.dinocraft.entity.ai.TyrannosaurusAi;
import com.dinocrew.dinocraft.registry.RegisterSounds;
import com.google.common.collect.ImmutableMap;
import net.frozenblock.lib.screenshake.api.ScreenShakePackets;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Unit;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.behavior.Behavior;
import net.minecraft.world.entity.ai.behavior.BehaviorUtils;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;

public class TyrannosaurusRoar extends Behavior<Tyrannosaurus> {
    private static final int TICKS_BEFORE_PLAYING_ROAR_SOUND = 25;
    private static final int ROAR_ANGER_INCREASE = 20;

    public TyrannosaurusRoar() {
        super(
                ImmutableMap.of(
                        MemoryModuleType.ROAR_TARGET,
                        MemoryStatus.VALUE_PRESENT,
                        MemoryModuleType.ATTACK_TARGET,
                        MemoryStatus.VALUE_ABSENT,
                        MemoryModuleType.ROAR_SOUND_COOLDOWN,
                        MemoryStatus.REGISTERED,
                        MemoryModuleType.ROAR_SOUND_DELAY,
                        MemoryStatus.REGISTERED
                ),
                TyrannosaurusAi.ROAR_DURATION
        );
    }

    protected void start(ServerLevel serverLevel, Tyrannosaurus dino, long l) {
        Brain<Tyrannosaurus> brain = dino.getBrain();
        brain.setMemoryWithExpiry(MemoryModuleType.ROAR_SOUND_DELAY, Unit.INSTANCE, TICKS_BEFORE_PLAYING_ROAR_SOUND);
        brain.eraseMemory(MemoryModuleType.WALK_TARGET);
        LivingEntity livingEntity = dino.getBrain().getMemory(MemoryModuleType.ROAR_TARGET).get();
        BehaviorUtils.lookAtEntity(dino, livingEntity);
        dino.setPose(Pose.ROARING);
        dino.increaseAngerAt(livingEntity, 20, false);
    }

    protected boolean canStillUse(ServerLevel serverLevel, Tyrannosaurus dino, long gameTime) {
        return true;
    }

    protected void tick(ServerLevel serverLevel, Tyrannosaurus dino, long l) {
        if (!dino.getBrain().hasMemoryValue(MemoryModuleType.ROAR_SOUND_DELAY) && !dino.getBrain().hasMemoryValue(MemoryModuleType.ROAR_SOUND_COOLDOWN)) {
            dino.getBrain().setMemoryWithExpiry(MemoryModuleType.ROAR_SOUND_COOLDOWN, Unit.INSTANCE, TyrannosaurusAi.ROAR_DURATION - TICKS_BEFORE_PLAYING_ROAR_SOUND);
            dino.playSound(RegisterSounds.TYRANNOSAURUS_ROAR, 3.0F, 1.0F);
            ScreenShakePackets.createScreenShakePacket(serverLevel, 0.4F, TyrannosaurusAi.ROAR_DURATION - TICKS_BEFORE_PLAYING_ROAR_SOUND, dino.getX(), dino.getY(), dino.getZ(), 19);
        }
    }

    protected void stop(ServerLevel serverLevel, Tyrannosaurus dino, long l) {
        if (dino.hasPose(Pose.ROARING)) {
            dino.setPose(Pose.STANDING);
        }

        dino.getBrain().getMemory(MemoryModuleType.ROAR_TARGET).ifPresent(dino::setAttackTarget);
        dino.getBrain().eraseMemory(MemoryModuleType.ROAR_TARGET);
    }
}
