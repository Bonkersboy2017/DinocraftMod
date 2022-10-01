package com.dinocrew.dinocraft.mixins;

import com.dinocrew.dinocraft.registry.RegisterBlocks;
import com.dinocrew.dinocraft.registry.RegisterWorldgen;
import net.minecraft.data.worldgen.SurfaceRuleData;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(SurfaceRuleData.class)
public class VanillaSurfaceRulesInjector {
    @ModifyVariable(method = "overworldLike", at = @At("STORE"), ordinal = 8)
    private static SurfaceRules.RuleSource injected(SurfaceRules.RuleSource originalRules) {
        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(RegisterWorldgen.BREAKTHROUGH),
                        SurfaceRules.ifTrue(
                                SurfaceRules.ON_FLOOR,
                                SurfaceRules.ifTrue(
                                        SurfaceRules.abovePreliminarySurface(),
                                        SurfaceRules.sequence(
                                                SurfaceRules.ifTrue(
                                                        SurfaceRules.waterBlockCheck(0, 0),
                                                        SurfaceRules.state(RegisterBlocks.DRAGONGRASS.defaultBlockState())
                                                ),
                                                SurfaceRules.state(Blocks.DIRT.defaultBlockState())
                                        ))
                        )
                )
                , originalRules);

    }
}
