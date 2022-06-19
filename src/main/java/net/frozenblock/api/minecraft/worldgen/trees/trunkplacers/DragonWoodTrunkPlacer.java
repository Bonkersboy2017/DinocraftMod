package net.frozenblock.api.minecraft.worldgen.trees.trunkplacers;

import com.dinocrew.dinocraft.Dinocraft;
import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.frozenblock.api.mathematics.AdvancedMath;
import net.frozenblock.api.mathematics.Conics;
import net.frozenblock.api.mathematics.Point3D;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.List;
import net.minecraft.util.math.random.Random;
import java.util.function.BiConsumer;

// ALL CODE MADE BY LIUKRAST
// All rights Reserved

public class DragonWoodTrunkPlacer extends TrunkPlacer {
    public DragonWoodTrunkPlacer(int i, int j, int k) {
        super(i, j, k);
    }

    public static final Codec<DragonWoodTrunkPlacer> CODEC = RecordCodecBuilder.create(instance ->
            fillTrunkPlacerFields(instance).apply(instance, DragonWoodTrunkPlacer::new));

    protected TrunkPlacerType<?> getType() {
        return Dinocraft.DRAGONWOOD_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, net.minecraft.util.math.random.Random random, int height, BlockPos startPos, TreeFeatureConfig config) {
        BlockPos blockPos = startPos.down();

        // generate dirt below tree's base
        setToDirt(world, replacer, random, blockPos, config); // CENTER
        setToDirt(world, replacer, random, blockPos.east(), config); // EAST
        setToDirt(world, replacer, random, blockPos.west(), config); // WEST
        setToDirt(world, replacer, random, blockPos.north(), config); // NORTH
        setToDirt(world, replacer, random, blockPos.north().east(), config); // NORTH-EAST
        setToDirt(world, replacer, random, blockPos.north().west(), config); // NORTH-WEST
        setToDirt(world, replacer, random, blockPos.south(), config); // SOUTH
        setToDirt(world, replacer, random, blockPos.south().east(), config); // SOUTH-EAST
        setToDirt(world, replacer, random, blockPos.south().west(), config); // SOUTH-WEST
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        int min = 6;
        int max = 13;


        //Random Height between min & max
        int h = (int)AdvancedMath.range(min, max, (float)Math.random());
        int h_nw = (int)AdvancedMath.range((float)min/3, (float)max/3, (float)Math.random());
        int h_sw = (int)AdvancedMath.range((float)min/3, (float)max/3, (float)Math.random());
        int h_ne = (int)AdvancedMath.range((float)min/3, (float)max/3, (float)Math.random());
        int h_se = (int)AdvancedMath.range((float)min/3, (float)max/3, (float)Math.random());

        for(int i = 0; i < h; i++) {
            setLog(world, replacer, random, mutable, config, startPos, 0, i, 0, true); // CENTER

            setLog(world, replacer, random, mutable, config, startPos, 1, i, 0, true);
            setLog(world, replacer, random, mutable, config, startPos, -1, i, 0, true);
            setLog(world, replacer, random, mutable, config, startPos, 0, i, 1, true);
            setLog(world, replacer, random, mutable, config, startPos, 0, i, -1, true);

            setLogs(world, replacer,  random, mutable, config, startPos, 1, i, 1, true);
            setLogs(world, replacer,  random, mutable, config, startPos, -1, i, 1, true);
            setLogs(world, replacer,  random, mutable, config, startPos, 1, i, -1, true);
            setLogs(world, replacer,  random, mutable, config, startPos, -1, i, -1, true);
        }

        generateEllipsoid(8, 4, 8, 30, world, replacer,  random, new BlockPos(startPos.getX(), startPos.getY() + h, startPos.getZ()), config, mutable);
        generateHalfEllipsoid(9, 4, 9, 10, world, replacer,  random, new BlockPos(startPos.getX(), startPos.getY() + h, startPos.getZ()), config, mutable);


        return ImmutableList.of(new FoliagePlacer.TreeNode(startPos.up(h), 0, false));
    }



    private void setLogs(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, BlockPos.Mutable pos, TreeFeatureConfig config, BlockPos startPos, int x, int y, int z, boolean condition) {
        if(condition) {
            pos.set(startPos, x, y, z);
            trySetState(world, replacer, random, pos, config);
        }
    }

    private void setLog(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, BlockPos.Mutable pos, TreeFeatureConfig config, BlockPos startPos, int x, int y, int z, boolean condition) {
        setLogs(world, replacer, random, pos, config, startPos, x, y, z, condition);

    }

    private void generateEllipsoid(int a, int b, int c, float percentage, TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, BlockPos startPos, TreeFeatureConfig config, BlockPos.Mutable mutable) {
        Point3D center = new Point3D.Float(startPos.getX(), startPos.getY(), startPos.getZ());

        // Build in an area between -a, -b, -c & a, b, c
        for(int i = -a; i <= a; i++) {
            for(int j = -b; j <= b; j++) {
                for(int k = -c; k <= c; k++) {
                    Point3D actual = new Point3D.Float(startPos.getX() + i, startPos.getY() + j, startPos.getZ() + k);
                    if(Conics.isInsideEllipsoid(center, a, b, c, actual)) {
                        if(Math.random() < percentage/100) {
                            setLog(world, replacer, random, mutable, config, startPos, i, j, k, true);
                        }
                    }
                }
            }
        }
    }

    private void generateHalfEllipsoid(int a, int b, int c, float percentage, TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, BlockPos startPos, TreeFeatureConfig config, BlockPos.Mutable mutable) {
        Point3D center = new Point3D.Float(startPos.getX(), startPos.getY(), startPos.getZ());

        // Build in an area between -a, -b, -c & a, b, c
        for(int i = -a; i <= a; i++) {
            for(int j = -b; j <= 0; j++) {
                for(int k = -c; k <= c; k++) {
                    Point3D actual = new Point3D.Float(startPos.getX() + i, startPos.getY() + j, startPos.getZ() + k);
                    if(Conics.isInsideEllipsoid(center, a, b, c, actual)) {
                        if(Math.random() < percentage/100) {
                            setLog(world, replacer, random, mutable, config, startPos, i, j, k, true);
                        }
                    }
                }
            }
        }
    }
}