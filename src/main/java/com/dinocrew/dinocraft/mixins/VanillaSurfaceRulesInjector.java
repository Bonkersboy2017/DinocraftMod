package com.dinocrew.dinocraft.mixins;

import com.dinocrew.dinocraft.registry.ModBiomes;
import com.dinocrew.dinocraft.registry.ModBlocks;
//import com.dinocrew.dinocraft.registry.worldgen.RegisterWorldgen;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.noise.NoiseParametersKeys;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import net.minecraft.world.gen.surfacebuilder.VanillaSurfaceRules;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(net.minecraft.world.gen.surfacebuilder.VanillaSurfaceRules.class)
public class VanillaSurfaceRulesInjector {
    @ModifyVariable(method = "createDefaultRule", at = @At("STORE"), ordinal = 8)
    private static MaterialRules.MaterialRule injected(MaterialRules.MaterialRule x) {
        return
                MaterialRules.condition(
                        MaterialRules.biome(ModBiomes.BREAKTHHROUGH_KEY),
                        MaterialRules.condition(
                                MaterialRules.STONE_DEPTH_FLOOR,
                                MaterialRules.condition(
                                        MaterialRules.surface(),
                                        MaterialRules.sequence(
                                                MaterialRules.condition(
                                                        MaterialRules.water(0, 0),
                                                        MaterialRules.block(ModBlocks.DRAGONGRASS.getDefaultState())
                                                ),
                                                MaterialRules.block(Blocks.DIRT.getDefaultState())
                                        )
                                )
                        )
                );
    }
}
