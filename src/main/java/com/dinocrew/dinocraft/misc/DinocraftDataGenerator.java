package com.dinocrew.dinocraft.misc;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.registry.RegisterFeatures;
import com.dinocrew.dinocraft.registry.RegisterWorldgen;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

import java.util.concurrent.CompletableFuture;

public class DinocraftDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator dataGenerator) {
        final FabricDataGenerator.Pack pack = dataGenerator.createPack();
        pack.addProvider(DinoWorldgenProvider::new);
    }

    @Override
    public void buildRegistry(RegistrySetBuilder registryBuilder) {
        Dinocraft.logDino("Registering worldgen for", Dinocraft.UNSTABLE_LOGGING);

        registryBuilder.add(Registries.CONFIGURED_FEATURE, DinoFeatureBootstrap::bootstrapConfiguredFeatures);
        registryBuilder.add(Registries.PLACED_FEATURE, DinoFeatureBootstrap::bootstrapPlacedFeatures);
        registryBuilder.add(Registries.BIOME, RegisterWorldgen::bootstrap);
    }

    private static class DinoWorldgenProvider extends FabricDynamicRegistryProvider {

        public DinoWorldgenProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
            super(output, registriesFuture);
        }

        @Override
        protected void configure(HolderLookup.Provider registries, Entries entries) {
            final var configuredFeatures = asLookup(entries.getLookup(Registries.CONFIGURED_FEATURE));
            final var placedFeatures = asLookup(entries.placedFeatures());
            final var biomes = asLookup(entries.getLookup(Registries.BIOME));

            entries.addAll(configuredFeatures);
            entries.addAll(placedFeatures);
            entries.addAll(biomes);
        }

        @Override
        public String getName() {
            return "Dinocraft Dynamic Registries";
        }
    }

    private static <T> HolderLookup.RegistryLookup<T> asLookup(HolderGetter<T> getter) {
        return (HolderLookup.RegistryLookup<T>) getter;
    }
}
