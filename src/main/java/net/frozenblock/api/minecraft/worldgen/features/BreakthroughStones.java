package net.frozenblock.api.minecraft.worldgen.features;

import com.dinocrew.dinocraft.registry.ModBlocks;
import com.mojang.serialization.Codec;
import net.frozenblock.api.mathematics.AdvancedMath;
import net.frozenblock.api.mathematics.Conics;
import net.frozenblock.api.mathematics.Point3D;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.BiConsumer;

public class BreakthroughStones extends Feature<DefaultFeatureConfig> implements AdvancedMath {
    public BreakthroughStones(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        BlockPos topPos = context.getWorld().getTopPosition(Heightmap.Type.OCEAN_FLOOR_WG, context.getOrigin());
        int xSize = (int)range(3, 5, (float)Math.random());
        int ySize = (int)range(3, 5, (float)Math.random());
        int zSize = (int)range(3, 5, (float)Math.random());
        generateEllipsoid(xSize, ySize, zSize, 100, (World) context.getWorld(), topPos);
        return true;
    }

    private static void generateEllipsoid(int a, int b, int c, float percentage, World world, BlockPos startPos) {
        Point3D center = new Point3D.Float(startPos.getX(), startPos.getY(), startPos.getZ());

        ArrayList<Block> blocks = new ArrayList<>();
        blocks.add(ModBlocks.FOSSILIZED_STONE);
        blocks.add(Blocks.SMOOTH_BASALT);
        blocks.add(Blocks.MOSS_BLOCK);
        blocks.add(Blocks.MOSSY_COBBLESTONE);


        // Build in an area between -a, -b, -c & a, b, c
        for(int i = -a; i <= a; i++) {
            for(int j = -b; j <= b; j++) {
                for(int k = -c; k <= c; k++) {
                    Point3D actual = new Point3D.Float(startPos.getX() + i, startPos.getY() + j, startPos.getZ() + k);
                    if(Conics.isInsideEllipsoid(center, a, b, c, actual)) {
                        if(Math.random() < percentage/100) {
                            BlockPos fpos = new BlockPos(startPos.getX() + i, startPos.getY() + j, startPos.getZ() + k);
                            int rndm = (int)( Math.random() * blocks.size() );
                            world.setBlockState(fpos, blocks.get(rndm).getDefaultState());
                        }
                    }
                }
            }
        }
    }
}
