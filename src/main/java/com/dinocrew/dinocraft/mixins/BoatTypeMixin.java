package com.dinocrew.dinocraft.mixins;

import com.dinocrew.dinocraft.registry.ModBlocks;
import com.dinocrew.dinocraft.registry.entities.DinoBoats;
import net.minecraft.block.Block;
import net.minecraft.entity.vehicle.BoatEntity;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.Arrays;

@Mixin(BoatEntity.Type.class)
public class BoatTypeMixin {

    //CREDIT TO nyuppo/fabric-boat-example ON GITHUB

    @SuppressWarnings("InvokerTarget")
    @Invoker("<init>")
    private static BoatEntity.Type newType(String internalName, int internalId, Block baseBlock, String name) {
        throw new AssertionError();
    }

    @SuppressWarnings("ShadowTarget")
    @Final
    @Shadow
    @Mutable
    private static BoatEntity.Type[] field_7724;

    @Inject(method = "<clinit>", at = @At(value = "FIELD",
            opcode = Opcodes.PUTSTATIC,
            target = "Lnet/minecraft/entity/vehicle/BoatEntity$Type;field_7724:[Lnet/minecraft/entity/vehicle/BoatEntity$Type;",
            shift = At.Shift.AFTER))
    private static void addCustomBoatType(CallbackInfo ci) {
        var types = new ArrayList<>(Arrays.asList(field_7724));
        var last = types.get(types.size() - 1);

        var dragonwood = newType("DRAGONWOOD", last.ordinal() + 1, ModBlocks.DRAGONWOOD_PLANKS, "dragonwood");
        DinoBoats.DRAGONWOOD = dragonwood;
        types.add(dragonwood);
        field_7724 = types.toArray(new BoatEntity.Type[0]);
    }
}