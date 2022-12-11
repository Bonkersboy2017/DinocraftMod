package com.dinocrew.dinocraft.misc;

import com.dinocrew.dinocraft.registry.RegisterFeatures;
import net.frozenblock.dinocraft.registry.RegisterConfiguredFeatures;
import net.frozenblock.dinocraft.worldgen.features.BreakthroughPlants;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class DinoFeatureBootstrap {

    public static void bootstrapConfiguredFeatures(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RegisterFeatures.bootstrap(context);
        RegisterConfiguredFeatures.bootstrap(context);
        BreakthroughPlants.bootstrap(context);
    }

    public static void bootstrapPlacedFeatures(BootstapContext<PlacedFeature> context) {
        RegisterFeatures.bootstrapPlaced(context);
        RegisterConfiguredFeatures.bootstrapPlaced(context);
        BreakthroughPlants.bootstrapPlaced(context);
    }
}
