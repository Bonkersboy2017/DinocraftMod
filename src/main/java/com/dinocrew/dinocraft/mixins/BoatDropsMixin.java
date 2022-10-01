package com.dinocrew.dinocraft.mixins;

import com.dinocrew.dinocraft.registry.ModItems;
import com.dinocrew.dinocraft.registry.entities.DinoBoats;
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
        if (((Boat) (Object) this).getBoatType() == DinoBoats.DRAGONWOOD) {
            ci.setReturnValue(ModItems.DRAGONWOOD_BOAT);
            ci.cancel();
        }
    }

}
