package com.dinocrew.dinocraft.mixins;

import com.dinocrew.dinocraft.registry.ModItems;
import com.dinocrew.dinocraft.registry.entities.DinoBoats;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BoatEntity.class)
public class BoatDropsMixin {

    //CREDIT TO nyuppo/fabric-boat-example ON GITHUB

    @Inject(method = "asItem", at = @At("HEAD"), cancellable = true)
    public void asItem(CallbackInfoReturnable<Item> ci) {
        if (((BoatEntity) (Object) this).getBoatType() == DinoBoats.DRAGONWOOD) {
            ci.setReturnValue(ModItems.DRAGONWOOD_BOAT);
            ci.cancel();
        }
    }

}
