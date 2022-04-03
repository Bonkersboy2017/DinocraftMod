package com.dinocrew.dinocraft.mixins;

import com.dinocrew.dinocraft.registry.ModBlocks;
//import com.dinocrew.dinocraft.registry.worldgen.RegisterWorldgen;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.noise.NoiseParametersKeys;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

//@Mixin(net.minecraft.world.gen.surfacebuilder.VanillaSurfaceRules.class)
//public class VanillaSurfaceRulesInjector {
//    @Mutable
//    @Final private static MaterialRules.MaterialRule MUD;
//    static {MUD = block(ModBlocks.DRAGONGRASS);}
//
//    private static MaterialRules.MaterialRule block(Block block) {
//        return MaterialRules.block(block.getDefaultState());
//    }
//
//    @ModifyVariable(method = "createDefaultRule", at = @At("STORE"), ordinal = 8)
//    private static MaterialRules.MaterialRule injected(MaterialRules.MaterialRule x) {
//        return MaterialRules.sequence(MaterialRules.condition(
//                        MaterialRules.STONE_DEPTH_FLOOR, MaterialRules.sequence(
//                                MaterialRules.condition(
//                                        MaterialRules.biome(
//                                                RegisterWorldgen.BREAKTHROUGH),
//                                        VanillaSurfaceRulesBlockInvoker.invokeBlock(
//                                                ModBlocks.DRAGONGRASS
//                                        )
//                                ),
//                                MaterialRules.condition(
//                                        MaterialRules.biome(
//                                                RegisterWorldgen.BREAKTHROUGH),
//                                        MaterialRules.condition(
//                                                MaterialRules.aboveY(YOffset.fixed(62), 0),
//                                                MaterialRules.condition(
//                                                        MaterialRules.not(
//                                                                MaterialRules.aboveY(YOffset.fixed(63), 0)),
//                                                        MaterialRules.condition(
//                                                                MaterialRules.noiseThreshold(
//                                                                        NoiseParametersKeys.SURFACE_SWAMP, 0.1D),
//                                                                VanillaSurfaceRulesBlockInvoker.invokeBlock(Blocks.WATER))))))),
//                x);
//    }
//}
