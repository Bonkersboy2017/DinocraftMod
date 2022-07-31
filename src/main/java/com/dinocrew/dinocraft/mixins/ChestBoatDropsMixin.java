package com.dinocrew.dinocraft.mixins;

import com.dinocrew.dinocraft.registry.ModItems;
import com.dinocrew.dinocraft.registry.entities.DinoBoats;
import net.minecraft.entity.vehicle.ChestBoatEntity;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ChestBoatEntity.class)
public class ChestBoatDropsMixin {

    //CREDIT TO nyuppo/fabric-boat-example ON GITHUB

    @Inject(method = "asItem", at = @At("HEAD"), cancellable = true)
    public void asItem(CallbackInfoReturnable<Item> ci) {
        if (((ChestBoatEntity) (Object) this).getBoatType() == DinoBoats.DRAGONWOOD) {
            ci.setReturnValue(ModItems.DRAGONWOOD_CHEST_BOAT);
            ci.cancel();
        }
    }

}
