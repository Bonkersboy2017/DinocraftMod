package net.frozenblock.api.minecraft.worldgen.features;

import com.dinocrew.dinocraft.registry.ModBlocks;
import com.mojang.serialization.Codec;
import net.frozenblock.api.mathematics.AdvancedMath;
import net.frozenblock.api.mathematics.Conics;
import net.frozenblock.api.mathematics.Point3D;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.ArrayList;

public class BreakthroughStones extends Feature<ProbabilityConfig> {
    public BreakthroughStones(Codec<ProbabilityConfig> config) {
        super(config);
    }

    @Override
    public boolean generate(FeatureContext<ProbabilityConfig> context) {
        StructureWorldAccess world = context.getWorld();
        BlockPos topPos = world.getTopPosition(Heightmap.Type.OCEAN_FLOOR_WG, context.getOrigin());
        int xSize = (int) AdvancedMath.range(1, 3, (float) Math.random());
        int ySize = (int) AdvancedMath.range(1, 3, (float) Math.random());
        int zSize = (int) AdvancedMath.range(1, 3, (float) Math.random());

        ArrayList<Block> blocks = new ArrayList<>();
        blocks.add(ModBlocks.FOSSILIZED_STONE);
        blocks.add(Blocks.SMOOTH_BASALT);
        blocks.add(Blocks.MOSS_BLOCK);
        blocks.add(Blocks.MOSSY_COBBLESTONE);

        generateEllipsoid(xSize, ySize, zSize, 100, world, topPos, blocks);
        return true;
    }

    static void generateEllipsoid(int a, int b, int c, float percentage, StructureWorldAccess world, BlockPos startPos, ArrayList<Block> blocks) {
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
                            world.setBlockState(fpos, blocks.get(rndm).getDefaultState(), 3);
                        }
                    }
                }
            }
        }
    }
}
