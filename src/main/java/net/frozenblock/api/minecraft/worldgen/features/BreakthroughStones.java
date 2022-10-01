package net.frozenblock.api.minecraft.worldgen.features;

import com.dinocrew.dinocraft.registry.RegisterBlocks;
import com.mojang.serialization.Codec;
import net.frozenblock.lib.mathematics.AdvancedMath;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;
import net.frozenblock.api.math.Conics;
import net.frozenblock.api.math.Point3D;
import java.util.ArrayList;

public class BreakthroughStones extends Feature<ProbabilityFeatureConfiguration> {
    public BreakthroughStones(Codec<ProbabilityFeatureConfiguration> config) {
        super(config);
    }

    @Override
    public boolean place(FeaturePlaceContext<ProbabilityFeatureConfiguration> context) {
        WorldGenLevel world = context.level();
        BlockPos topPos = world.getHeightmapPos(Heightmap.Types.OCEAN_FLOOR_WG, context.origin());
        int xSize = (int) AdvancedMath.range(1, 3, (float) Math.random());
        int ySize = (int) AdvancedMath.range(1, 3, (float) Math.random());
        int zSize = (int) AdvancedMath.range(1, 3, (float) Math.random());

        ArrayList<Block> blocks = new ArrayList<>();
        blocks.add(RegisterBlocks.FOSSILIZED_STONE);
        blocks.add(Blocks.SMOOTH_BASALT);
        blocks.add(Blocks.MOSS_BLOCK);
        blocks.add(Blocks.MOSSY_COBBLESTONE);

        generateEllipsoid(xSize, ySize, zSize, 100, world, topPos, blocks);
        return true;
    }

    static void generateEllipsoid(int a, int b, int c, float percentage, WorldGenLevel world, BlockPos startPos, ArrayList<Block> blocks) {
        Point3D center = new Point3D.Float(startPos.getX(), startPos.getY(), startPos.getZ());


        // Build in an area between -a, -b, -c & a, b, c
        for (int i = -a; i <= a; i++) {
            for (int j = -b; j <= b; j++) {
                for (int k = -c; k <= c; k++) {
                    Point3D actual = new Point3D.Float(startPos.getX() + i, startPos.getY() + j, startPos.getZ() + k);
                    if (Conics.isInsideEllipsoid(center, a, b, c, actual)) {
                        if (Math.random() <= percentage / 100) {
                            BlockPos fpos = new BlockPos(startPos.getX() + i, startPos.getY() + j, startPos.getZ() + k);
                            int rndm = (int) (Math.random() * blocks.size());
                            world.setBlock(fpos, blocks.get(rndm).defaultBlockState(), 3);
                        }
                    }
                }
            }
        }
    }
}
