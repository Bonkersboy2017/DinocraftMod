package com.dinocrew.dinocraft.mixins;

import com.dinocrew.dinocraft.registry.ModBiomes;
import com.mojang.datafixers.util.Pair;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.OverworldBiomeBuilder;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
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

@Mixin(OverworldBiomeBuilder.class)
public class ModBiomeParameters {

    @Shadow
    private void addSurfaceBiome(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> parameters, Climate.Parameter temperature, Climate.Parameter humidity, Climate.Parameter continentalness, Climate.Parameter erosion, Climate.Parameter weirdness, float offset, ResourceKey<Biome> biome) {

    }

    @Shadow
    @Final
    private Climate.Parameter FULL_RANGE;

    @Shadow
    @Final
    private Climate.Parameter mushroomFieldsContinentalness;

    @Shadow
    @Final
    private Climate.Parameter[] temperatures;

    @Shadow
    @Final
    private Climate.Parameter[] humidities;

    @Inject(method = "addOffCoastBiomes", at = @At("HEAD"))
    private void writeOceanBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> parameters, CallbackInfo ci) {
        this.addSurfaceBiome(
                parameters,
                this.temperatures[2],
                this.FULL_RANGE,
                this.mushroomFieldsContinentalness,
                this.FULL_RANGE,
                this.FULL_RANGE,
                0.0F,
                ModBiomes.BREAKTHROUGH
        );

        this.addSurfaceBiome(
                parameters,
                this.temperatures[3],
                this.FULL_RANGE,
                this.mushroomFieldsContinentalness,
                this.FULL_RANGE,
                this.FULL_RANGE,
                0.0F,
                ModBiomes.BREAKTHROUGH
        );

        this.addSurfaceBiome(
                parameters,
                this.temperatures[4],
                this.FULL_RANGE,
                this.mushroomFieldsContinentalness,
                this.FULL_RANGE,
                this.FULL_RANGE,
                0.0F,
                ModBiomes.BREAKTHROUGH
        );
    }

    @Inject(method = "addOffCoastBiomes", at = @At("TAIL"))
    private void writeOceanBiomesTail(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> parameters, CallbackInfo ci) {
        this.addSurfaceBiome(
                parameters,
                this.temperatures[2],
                this.FULL_RANGE,
                this.mushroomFieldsContinentalness,
                this.FULL_RANGE,
                this.FULL_RANGE,
                0.0F,
                ModBiomes.BREAKTHROUGH
        );

        this.addSurfaceBiome(
                parameters,
                this.temperatures[3],
                this.FULL_RANGE,
                this.mushroomFieldsContinentalness,
                this.FULL_RANGE,
                this.FULL_RANGE,
                0.0F,
                ModBiomes.BREAKTHROUGH
        );

        this.addSurfaceBiome(
                parameters,
                this.temperatures[4],
                this.FULL_RANGE,
                this.mushroomFieldsContinentalness,
                this.FULL_RANGE,
                this.FULL_RANGE,
                0.0F,
                ModBiomes.BREAKTHROUGH
        );
    }
}