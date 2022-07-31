package net.frozenblock.api.minecraft.worldgen.trees.foliageplacers;

import com.dinocrew.dinocraft.Dinocraft;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.frozenblock.api.mathematics.Conics;
import net.frozenblock.api.mathematics.Point3D;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

import java.util.function.BiConsumer;

public class DragonWoodFoliagePlacer extends FoliagePlacer {
    public static final Codec<DragonWoodFoliagePlacer> CODEC = RecordCodecBuilder.create((instance) -> {
        return fillFoliagePlacerFields(instance).apply(instance, DragonWoodFoliagePlacer::new);
    });

    public DragonWoodFoliagePlacer(IntProvider radius, IntProvider offset) {
        super(radius, offset);
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return Dinocraft.DRAGONWOOD_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, net.minecraft.util.math.random.Random random, TreeFeatureConfig config, int trunkHeight, TreeNode treeNode, int foliageHeight, int radius, int offset) {
        BlockPos.Mutable center = treeNode.getCenter().mutableCopy();
        generateEllipsoid(9, 4, 9, 100, world, replacer, random, config, center);
        generateEllipsoid(10, 5, 10, 50, world, replacer, random, config, center);
    }

    @Override
    public int getRandomHeight(net.minecraft.util.math.random.Random random, int trunkHeight, TreeFeatureConfig config) {
        return 0;
    }

    @Override
    protected boolean isInvalidForLeaves(net.minecraft.util.math.random.Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        return false;
    }


    private static void generateEllipsoid(int a, int b, int c, float percentage, TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, TreeFeatureConfig config, BlockPos startPos) {
        Point3D center = new Point3D.Float(startPos.getX(), startPos.getY(), startPos.getZ());

        // Build in an area between -a, -b, -c & a, b, c
        for (int i = -a; i <= a; i++) {
            for (int j = -b; j <= b; j++) {
                for (int k = -c; k <= c; k++) {
                    Point3D actual = new Point3D.Float(startPos.getX() + i, startPos.getY() + j, startPos.getZ() + k);
                    if (Conics.isInsideEllipsoid(center, a, b, c, actual)) {
                        if (Math.random() < percentage / 100) {
                            BlockPos fpos = new BlockPos(startPos.getX() + i, startPos.getY() + j, startPos.getZ() + k);
                            placeFoliageBlock(world, replacer, random, config, fpos);
                        }
                    }
                }
            }
        }
    }

}
