package com.dinocrew.dinocraft.mixin;

import com.dinocrew.dinocraft.registry.RegisterItems;
import com.dinocrew.dinocraft.entity.DinoBoats;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Boat.class)
public class BoatDropsMixin {

    //CREDIT TO nyuppo/fabric-boat-example ON GITHUB

    @Inject(method = "getDropItem", at = @At("HEAD"), cancellable = true)
    public void getDropItem(CallbackInfoReturnable<Item> ci) {
        var boat = Boat.class.cast(this);
        if (boat.getVariant() == DinoBoats.DRAGONWOOD) {
            ci.setReturnValue(RegisterItems.DRAGONWOOD_BOAT);
        }
    }

}
