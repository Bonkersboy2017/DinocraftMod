package com.dinocrew.dinocraft.mixins;

import com.dinocrew.dinocraft.registry.ModBiomes;
import com.mojang.datafixers.util.Pair;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.OverworldBiomeCreator;
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
public abstract class ModBiomeParameters {

    @Shadow protected abstract void writeBiomeParameters(Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> parameters, MultiNoiseUtil.ParameterRange temperature, MultiNoiseUtil.ParameterRange humidity, MultiNoiseUtil.ParameterRange continentalness, MultiNoiseUtil.ParameterRange erosion, MultiNoiseUtil.ParameterRange weirdness, float offset, RegistryKey<Biome> biome);

    @Shadow @Final private MultiNoiseUtil.ParameterRange defaultParameter;

    @Shadow @Final private MultiNoiseUtil.ParameterRange mushroomFieldsContinentalness;

    @Shadow @Final private MultiNoiseUtil.ParameterRange[] temperatureParameters;

    @Inject(method = "writeOceanBiomes", at = @At("HEAD"))
    private void writeOceanBiomes(Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> parameters, CallbackInfo ci) {
        this.writeBiomeParameters(
                parameters,
                this.temperatureParameters[2],
                this.defaultParameter,
                this.mushroomFieldsContinentalness,
                this.defaultParameter,
                this.defaultParameter,
                0.0F,
                ModBiomes.BREAKTHROUGH
        );

        this.writeBiomeParameters(
                parameters,
                this.temperatureParameters[3],
                this.defaultParameter,
                this.mushroomFieldsContinentalness,
                this.defaultParameter,
                this.defaultParameter,
                0.0F,
                ModBiomes.BREAKTHROUGH
        );

        this.writeBiomeParameters(
                parameters,
                this.temperatureParameters[4],
                this.defaultParameter,
                this.mushroomFieldsContinentalness,
                this.defaultParameter,
                this.defaultParameter,
                0.0F,
                ModBiomes.BREAKTHROUGH
        );
    }

    @Inject(method = "writeOceanBiomes", at = @At("TAIL"))
    private void writeOceanBiomesTail(Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> parameters, CallbackInfo ci) {
        this.writeBiomeParameters(
                parameters,
                this.temperatureParameters[2],
                this.defaultParameter,
                this.mushroomFieldsContinentalness,
                this.defaultParameter,
                this.defaultParameter,
                0.0F,
                ModBiomes.BREAKTHROUGH
        );

        this.writeBiomeParameters(
                parameters,
                this.temperatureParameters[3],
                this.defaultParameter,
                this.mushroomFieldsContinentalness,
                this.defaultParameter,
                this.defaultParameter,
                0.0F,
                ModBiomes.BREAKTHROUGH
        );

        this.writeBiomeParameters(
                parameters,
                this.temperatureParameters[4],
                this.defaultParameter,
                this.mushroomFieldsContinentalness,
                this.defaultParameter,
                this.defaultParameter,
                0.0F,
                ModBiomes.BREAKTHROUGH
        );
    }
}