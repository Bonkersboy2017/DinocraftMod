package net.frozenblock.api.minecraft.worldgen.features;

import com.dinocrew.dinocraft.registry.RegisterBlocks;
import com.mojang.serialization.Codec;
import net.frozenblock.lib.mathematics.AdvancedMath;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class BreakthoughRock extends BreakthroughStones {

    public BreakthoughRock(Codec<ProbabilityFeatureConfiguration> config) {
        super(config);
    }

    @Override
    public boolean place(@NotNull FeaturePlaceContext<ProbabilityFeatureConfiguration> context) {
        WorldGenLevel world = context.level();
        BlockPos topPos = world.getHeightmapPos(Heightmap.Types.OCEAN_FLOOR_WG, context.origin());
        int xSize = (int) AdvancedMath.range(2, 5, (float) Math.random());
        int ySize = (int) AdvancedMath.range(4, 10, (float) Math.random());
        int zSize = (int) AdvancedMath.range(2, 5, (float) Math.random());

        ArrayList<Block> blocks = new ArrayList<>();
        blocks.add(RegisterBlocks.FOSSILIZED_STONE);
        blocks.add(RegisterBlocks.FS_BRICKS);
        blocks.add(Blocks.SMOOTH_BASALT);

        if (world.getBlockState(topPos) == Blocks.WATER.defaultBlockState()) {
            generateEllipsoid(xSize, ySize, zSize, 100, world, topPos, blocks);
        }
        return true;
    }
}
