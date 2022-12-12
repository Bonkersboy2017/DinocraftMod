package com.dinocrew.dinocraft.entity.ai;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.VibrationParticleOption;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.util.Mth;
import net.minecraft.world.level.ClipBlockStateContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.PositionSource;
import net.minecraft.world.level.gameevent.vibrations.VibrationInfo;
import net.minecraft.world.level.gameevent.vibrations.VibrationListener;
import net.minecraft.world.level.gameevent.vibrations.VibrationSelector;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class TyrannosaurusVibrationListener extends VibrationListener {

    public static Codec<TyrannosaurusVibrationListener> tyrannosaurusCodec(VibrationListenerConfig callback) {
        return RecordCodecBuilder.create((instance) ->
            instance.group(PositionSource.CODEC.fieldOf("source").forGetter((arg) ->
                arg.listenerSource
            ), ExtraCodecs.NON_NEGATIVE_INT.fieldOf("range").forGetter((arg) ->
                arg.listenerRange
            ), VibrationInfo.CODEC.optionalFieldOf("event").forGetter((arg) ->
                Optional.ofNullable(arg.currentVibration)
            ), VibrationSelector.CODEC.fieldOf("selector").forGetter((arg) ->
                arg.selectionStrategy
            ), ExtraCodecs.NON_NEGATIVE_INT.fieldOf("event_delay").orElse(0).forGetter((arg) ->
                arg.travelTimeInTicks
            )).apply(instance, (positionSource, integer, optional, vibrationSelector, integer2) ->
                new TyrannosaurusVibrationListener(positionSource, integer, callback, optional.orElse(null), vibrationSelector, integer2)
            )
        );
    }

    private TyrannosaurusVibrationListener(
            PositionSource positionSource,
            int range,
            VibrationListener.VibrationListenerConfig callback,
            @Nullable VibrationInfo vibrationInfo,
            VibrationSelector vibrationSelector,
            int i
    ) {
        super(positionSource, range, callback, vibrationInfo, vibrationSelector, i);
    }

    public TyrannosaurusVibrationListener(PositionSource positionSource, int range, VibrationListenerConfig vibrationListenerConfig) {
        super(positionSource, range, vibrationListenerConfig);
    }

    @Override
    public boolean handleGameEvent(ServerLevel level, GameEvent gameEvent, GameEvent.Context context, Vec3 vec3) {
        if (this.currentVibration != null) {
            return false;
        } else if (!this.config.isValidVibration(gameEvent, context)) {
            return false;
        } else {
            Optional<Vec3> optional = this.listenerSource.getPosition(level);
            if (optional.isEmpty()) {
                return false;
            } else {
                Vec3 vec32 = optional.get();
                if (!this.config.shouldListen(level, this, new BlockPos(vec3), gameEvent, context)) {
                    return false;
                } else if (isOccluded(level, vec3, vec32)) {
                    return false;
                } else {
                    this.scheduleVibration(level, gameEvent, context, vec3, vec32);
                    return true;
                }
            }
        }
    }

    private static boolean isOccluded(Level level, Vec3 from, Vec3 to) {
        Vec3 vec3 = new Vec3((double) Mth.floor(from.x) + 0.5, (double)Mth.floor(from.y) + 0.5, (double)Mth.floor(from.z) + 0.5);
        Vec3 vec32 = new Vec3((double)Mth.floor(to.x) + 0.5, (double)Mth.floor(to.y) + 0.5, (double)Mth.floor(to.z) + 0.5);

        for(Direction direction : Direction.values()) {
            Vec3 vec33 = vec3.relative(direction, 1.0E-5F);
            if (level.isBlockInLine(new ClipBlockStateContext(vec33, vec32, BlockBehaviour.BlockStateBase::canOcclude)).getType() != HitResult.Type.BLOCK) {
                return false;
            }
        }

        return true;
    }
}
