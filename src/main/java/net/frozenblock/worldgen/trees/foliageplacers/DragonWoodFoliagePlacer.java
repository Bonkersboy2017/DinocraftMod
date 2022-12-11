package net.frozenblock.worldgen.trees.foliageplacers;

import com.dinocrew.dinocraft.Dinocraft;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.frozenblock.lib.math.api.Conics;
import net.frozenblock.lib.math.api.Point3D;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import java.util.function.BiConsumer;

public class DragonWoodFoliagePlacer extends FoliagePlacer {
    public static final Codec<DragonWoodFoliagePlacer> CODEC = RecordCodecBuilder.create((instance) -> {
        return foliagePlacerParts(instance).apply(instance, DragonWoodFoliagePlacer::new);
    });

    public DragonWoodFoliagePlacer(IntProvider radius, IntProvider offset) {
        super(radius, offset);
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return Dinocraft.DRAGONWOOD_FOLIAGE_PLACER;
    }

    @Override
    protected void createFoliage(LevelSimulatedReader world, BiConsumer<BlockPos, BlockState> replacer, RandomSource random, TreeConfiguration config, int trunkHeight, FoliageAttachment treeNode, int foliageHeight, int radius, int offset) {
        BlockPos.MutableBlockPos center = treeNode.pos().mutable();
        generateEllipsoid(9, 4, 9, 100, world, replacer, random, config, center);
        generateEllipsoid(10, 5, 10, 50, world, replacer, random, config, center);
    }

    @Override
    public int foliageHeight(RandomSource random, int trunkHeight, TreeConfiguration config) {
        return 0;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        return false;
    }


    private static void generateEllipsoid(int a, int b, int c, float percentage, LevelSimulatedReader world, BiConsumer<BlockPos, BlockState> replacer, RandomSource random, TreeConfiguration config, BlockPos startPos) {
        Point3D center = new Point3D.Float(startPos.getX(), startPos.getY(), startPos.getZ());

        // Build in an area between -a, -b, -c & a, b, c
        for (int i = -a; i <= a; i++) {
            for (int j = -b; j <= b; j++) {
                for (int k = -c; k <= c; k++) {
                    Point3D actual = new Point3D.Float(startPos.getX() + i, startPos.getY() + j, startPos.getZ() + k);
                    if (Conics.isInsideEllipsoid(center, a, b, c, actual)) {
                        if (Math.random() < percentage / 100) {
                            BlockPos fpos = new BlockPos(startPos.getX() + i, startPos.getY() + j, startPos.getZ() + k);
                            tryPlaceLeaf(world, replacer, random, config, fpos);
                        }
                    }
                }
            }
        }
    }

}
