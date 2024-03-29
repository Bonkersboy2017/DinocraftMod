package com.dinocrew.dinocraft.mixin;

import com.dinocrew.dinocraft.registry.RegisterItems;
import com.dinocrew.dinocraft.entity.DinoBoats;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ChestBoat.class)
public class ChestBoatDropsMixin {

    //CREDIT TO nyuppo/fabric-boat-example ON GITHUB

    @Inject(method = "getDropItem", at = @At("HEAD"), cancellable = true)
    public void getDropItem(CallbackInfoReturnable<Item> ci) {
        var chestBoat = ChestBoat.class.cast(this);
        if (chestBoat.getVariant() == DinoBoats.DRAGONWOOD) {
            ci.setReturnValue(RegisterItems.DRAGONWOOD_CHEST_BOAT);
        }
    }

}
