package com.dinocrew.dinocraft.mixin;

import com.dinocrew.dinocraft.entity.Tyrannosaurus;
import com.dinocrew.dinocraft.registry.RegisterEntities;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.game.DebugPackets;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DebugPackets.class)
public class DebugPacketsMixin {

    @Inject(method = "writeBrain", at = @At(value = "INVOKE", target = "Lnet/minecraft/network/FriendlyByteBuf;writeCollection(Ljava/util/Collection;Lnet/minecraft/network/FriendlyByteBuf$Writer;)V", ordinal = 0, shift = At.Shift.BEFORE))
    private static void writeBrain(LivingEntity livingEntity, FriendlyByteBuf buffer, CallbackInfo ci) {
        if (livingEntity.getType() == RegisterEntities.TYRANNOSAURUS) {
            Tyrannosaurus dino = (Tyrannosaurus) livingEntity;
            buffer.writeInt(dino.getClientAngerLevel());
        }
    }
}
