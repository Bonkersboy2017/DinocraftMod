package com.dinocrew.dinocraft.registry.worldgen;

import com.dinocrew.dinocraft.registry.ModBiomes;
import com.dinocrew.dinocraft.registry.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import org.quiltmc.qsl.worldgen.surface_rule.api.SurfaceRuleContext;
import org.quiltmc.qsl.worldgen.surface_rule.api.SurfaceRuleEvents;

public class ModSurfaceRules implements SurfaceRuleEvents.OverworldModifierCallback {

    @Override
    public void modifyOverworldRules(SurfaceRuleContext.Overworld context) {

        context.materialRules().add(0,
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
                                        ))
                        )
                )
        );
    }
}
