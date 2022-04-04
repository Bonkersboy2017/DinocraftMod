package com.dinocrew.dinocraft.mixins;

import com.dinocrew.dinocraft.registry.ModBiomes;
import com.dinocrew.dinocraft.registry.ModBlocks;
import com.dinocrew.dinocraft.registry.worldgen.RegisterWorldgen;
import com.mojang.datafixers.util.Pair;
import io.netty.util.internal.SuppressJava6Requirement;
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


//@Mixin(VanillaBiomeParameters.class)
//public abstract class ModBiomeParameters {
//
//    @Shadow protected abstract void writeBiomeParameters(Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> parameters, MultiNoiseUtil.ParameterRange temperature, MultiNoiseUtil.ParameterRange humidity, MultiNoiseUtil.ParameterRange continentalness, MultiNoiseUtil.ParameterRange erosion, MultiNoiseUtil.ParameterRange weirdness, float offset, RegistryKey<Biome> biome);
//    private final MultiNoiseUtil.ParameterRange mushroomFieldsContinentalness = MultiNoiseUtil.ParameterRange.of(-1.2F, -1.05F);
//
//    @Shadow
//    @Final
//    private RegistryKey<Biome>[][] uncommonBiomes;
//
//
//
//    @Inject(method="writeOceanBiomes",at=@At("TAIL"))
//    private void mymodid$myBiomeParameters(Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> parameters, CallbackInfo ci) {
//        writeBiomeParameters(parameters, mushroomFieldsContinentalness, MultiNoiseUtil.ParameterRange.of(-1.2F, -1.05F), MultiNoiseUtil.ParameterRange.of(-2, -2), mushroomFieldsContinentalness, mushroomFieldsContinentalness, 0.0f, ModBiomes.BREAKTHHROUGH_KEY);
//    }
//
//
//
//    @Inject(method = "<init>", at = @At("TAIL"))
//    private void injectBiomes(CallbackInfo ci) {
//        uncommonBiomes[1][0] = ModBiomes.BREAKTHHROUGH_KEY;
//
//    }}

@Mixin(VanillaBiomeParameters.class)
public class ModBiomeParameters {


    @Redirect(method = "writeOceanBiomes",
            at = @At(value = "FIELD", opcode = Opcodes.GETSTATIC, target = "Lnet/minecraft/world/biome/BiomeKeys;MUSHROOM_FIELDS:Lnet/minecraft/util/registry/RegistryKey;"))

    public RegistryKey<Biome> redirectSomeMethod() {

        return ModBiomes.BREAKTHHROUGH_KEY;
    }
}