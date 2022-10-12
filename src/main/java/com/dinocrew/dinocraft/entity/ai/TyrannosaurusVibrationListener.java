package com.dinocrew.dinocraft.entity.ai;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.VibrationParticleOption;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.util.Mth;
import net.minecraft.world.level.ClipBlockStateContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.PositionSource;
import net.minecraft.world.level.gameevent.vibrations.VibrationListener;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class TyrannosaurusVibrationListener extends VibrationListener {

    public static Codec<TyrannosaurusVibrationListener> tyrannosaurusCodec(VibrationListenerConfig callback) {
        return RecordCodecBuilder.create(
                instance -> instance.group(
                                PositionSource.CODEC.fieldOf("source").forGetter(arg -> arg.listenerSource),
                                ExtraCodecs.NON_NEGATIVE_INT.fieldOf("range").forGetter(arg -> arg.listenerRange),
                                VibrationListener.ReceivingEvent.CODEC.optionalFieldOf("event").forGetter(arg -> Optional.ofNullable(arg.receivingEvent)),
                                Codec.floatRange(0.0F, Float.MAX_VALUE).fieldOf("event_distance").orElse(0.0F).forGetter(arg -> arg.receivingDistance),
                                ExtraCodecs.NON_NEGATIVE_INT.fieldOf("event_delay").orElse(0).forGetter(arg -> arg.travelTimeInTicks)
                        )
                        .apply(
                                instance,
                                (positionSource, integer, optional, float_, integer2) -> new TyrannosaurusVibrationListener(
                                        positionSource, integer, callback, optional.orElse(null), float_, integer2
                                )
                        )
        );
    }

    public TyrannosaurusVibrationListener(PositionSource listenerSource, int listenerRange, VibrationListenerConfig config, @Nullable VibrationListener.ReceivingEvent receivingEvent, float receivingDistance, int travelTimeInTicks) {
        super(listenerSource, listenerRange, config, receivingEvent, receivingDistance, travelTimeInTicks);
    }

    @Override
    public boolean handleGameEvent(ServerLevel level, GameEvent.Message eventMessage) {
        if (this.receivingEvent != null) {
            return false;
        } else {
            GameEvent gameEvent = eventMessage.gameEvent();
            GameEvent.Context context = eventMessage.context();
            if (!this.config.isValidVibration(gameEvent, context)) {
                return false;
            } else {
                Optional<Vec3> optional = this.listenerSource.getPosition(level);
                if (optional.isEmpty()) {
                    return false;
                } else {
                    Vec3 vec3 = eventMessage.source();
                    Vec3 vec32 = optional.get();
                    if (!this.config.shouldListen(level, this, new BlockPos(vec3), gameEvent, context)) {
                        return false;
                    } else if (isOccluded(level, vec3, vec32)) {
                        return false;
                    } else {
                        this.scheduleSignal(level, gameEvent, context, vec3, vec32);
                        return true;
                    }
                }
            }
        }
    }

    private void scheduleSignal(ServerLevel level, GameEvent event, GameEvent.Context context, Vec3 origin, Vec3 destination) {
        this.receivingDistance = (float)origin.distanceTo(destination);
        this.receivingEvent = new VibrationListener.ReceivingEvent(event, this.receivingDistance, origin, context.sourceEntity());
        this.travelTimeInTicks = Mth.floor(this.receivingDistance);
        level.sendParticles(new VibrationParticleOption(this.listenerSource, this.travelTimeInTicks), origin.x, origin.y, origin.z, 1, 0.0, 0.0, 0.0, 0.0);
        this.config.onSignalSchedule();
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
