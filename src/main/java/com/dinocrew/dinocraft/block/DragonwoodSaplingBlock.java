package com.dinocrew.dinocraft.block;

import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;

public class DragonwoodSaplingBlock extends SaplingBlock {
    public DragonwoodSaplingBlock(Properties settings) {
        super(new DragonwoodSaplingGenerator(), settings);
    }
}