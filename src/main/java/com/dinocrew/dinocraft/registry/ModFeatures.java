package com.dinocrew.dinocraft.registry;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.OreBlock;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;

public class ModFeatures
{
    public // Means this method can be seen from anywhere
    static // Means you don't need to create an object of type ModFeatures to use this method
    <T extends OreBlock> /* This is for if you learn more advanced class-creation later,
     * but it allows you to pass objects from custom classes you create
     * yourself, as long as they extend the OreBlock class
     */
    void // Means that calling this method doesn't return a value
    registerOverworldOreUniform ( T ore,
                                  int minYOffset,
                                  int maxYOffset,
                                  int avgOresPerVein,
                                  int avgVeinsPerChunk,
                                  Identifier ID )
    {
        UniformHeightProvider height;
        RangeDecoratorConfig range;
        OreFeatureConfig config;
        ConfiguredFeature<?, ?> feature;
        RegistryKey<ConfiguredFeature<?, ?>> registryKey;

        // Height provider
        height = UniformHeightProvider.create
                (
                        YOffset.aboveBottom ( minYOffset ),
                        YOffset.aboveBottom( maxYOffset )
                );

        // Assign the height provider to the range decorator config
        range = new RangeDecoratorConfig( height );

        // Configure the ore vein configuration
        config = new OreFeatureConfig
                (
                        OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                        ore.getDefaultState(),
                        avgOresPerVein
                );

        // Configure the ore feature
        feature = Feature.ORE.configure ( config )
                .range( range )
                .spreadHorizontally()
                .repeat( avgVeinsPerChunk );

        // Get the registry key for the provided ID
        registryKey = RegistryKey.of ( Registry.CONFIGURED_FEATURE_KEY, ID );

        // Register the feature
        Registry.register
                (
                        BuiltinRegistries.CONFIGURED_FEATURE,
                        registryKey.getValue(),
                        feature
                );

        // Add the feature to all biomes in the overworld
        BiomeModifications.addFeature
                (
                        BiomeSelectors.foundInOverworld (),
                        GenerationStep.Feature.UNDERGROUND_ORES,
                        registryKey
                );
    }
}
