package net.frozenblock.api.minecraft.worldgen.features;

import com.dinocrew.dinocraft.registry.ModBlocks;
import com.mojang.serialization.Codec;
import net.frozenblock.api.mathematics.AdvancedMath;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class BreakthoughRock extends BreakthroughStones {

    public BreakthoughRock(Codec<ProbabilityConfig> config) {
        super(config);
    }

    @Override
    public boolean generate(@NotNull FeatureContext<ProbabilityConfig> context) {
        StructureWorldAccess world = context.getWorld();
        BlockPos topPos = world.getTopPosition(Heightmap.Type.OCEAN_FLOOR_WG, context.getOrigin());
        int xSize = (int) AdvancedMath.range(2, 5, (float)Math.random());
        int ySize = (int)AdvancedMath.range(4, 10, (float)Math.random());
        int zSize = (int)AdvancedMath.range(2, 5, (float)Math.random());

        ArrayList<Block> blocks = new ArrayList<>();
        blocks.add(ModBlocks.FOSSILIZED_STONE);
        blocks.add(ModBlocks.FS_BRICKS);
        blocks.add(Blocks.SMOOTH_BASALT);

        if(world.getBlockState(topPos) == Blocks.WATER.getDefaultState()) {
            generateEllipsoid(xSize, ySize, zSize, 100, world, topPos, blocks);
        }
        return true;
    }
}
