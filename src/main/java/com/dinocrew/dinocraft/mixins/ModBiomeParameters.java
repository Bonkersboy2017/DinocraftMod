package com.dinocrew.dinocraft.mixins;

import com.dinocrew.dinocraft.registry.worldgen.RegisterWorldgen;
import com.mojang.datafixers.util.Pair;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import net.minecraft.world.biome.source.util.VanillaBiomeParameters;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

import static org.objectweb.asm.Opcodes.GETSTATIC;


@Mixin(VanillaBiomeParameters.class)
public abstract class ModBiomeParameters {


    @Shadow
    @Final
    private RegistryKey<Biome>[][] uncommonBiomes;

        @Redirect(method = "writeOceanBiomes",
                at = @At(value = "FIELD", opcode = Opcodes.GETSTATIC, target = "Lnet/minecraft/world/biome/BiomeKeys;MUSHROOM_FIELDS:Lnet/minecraft/util/registry/RegistryKey;"))

        public RegistryKey<Biome> redirectSomeMethod() {

            return RegisterWorldgen.BREAKTHROUGH;
        }




    @Inject(method = "<init>", at = @At("TAIL"))
    private void injectBiomes(CallbackInfo ci) {
        uncommonBiomes[1][0] = RegisterWorldgen.BREAKTHROUGH;

    }}

