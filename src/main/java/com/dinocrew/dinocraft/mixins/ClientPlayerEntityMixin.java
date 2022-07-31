package com.dinocrew.dinocraft.mixins;

import com.dinocrew.dinocraft.registry.entities.DragonwoodBoatEntity;
import com.mojang.authlib.GameProfile;
import net.minecraft.client.input.Input;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.network.encryption.PlayerPublicKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public abstract class ClientPlayerEntityMixin extends AbstractClientPlayerEntity {

    @Shadow
    private boolean riding;

    @Shadow
    public Input input;

    public ClientPlayerEntityMixin(ClientWorld world, GameProfile pos, PlayerPublicKey yaw) {
        super(world, pos, yaw);
    }


    @Inject(at = @At("HEAD"), method = "tickRiding")
    public void tickRiding(CallbackInfo ci) {
        this.riding = false;
        if (this.getVehicle() instanceof DragonwoodBoatEntity boatEntity) {
            boatEntity.setInputs(this.input.pressingLeft, this.input.pressingRight, this.input.pressingForward, this.input.pressingBack);
            this.riding |= this.input.pressingLeft || this.input.pressingRight || this.input.pressingForward || this.input.pressingBack;
        }

    }
}
