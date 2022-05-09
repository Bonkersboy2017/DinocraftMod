package com.dinocrew.dinocraft.registry.blocks;

import com.dinocrew.dinocraft.Dinocraft;
import com.dinocrew.dinocraft.registry.ModBlocks;
import com.dinocrew.dinocraft.registry.entities.DinotanerBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.FurnaceBlockEntity;
import net.minecraft.util.registry.Registry;

public class modBlockEntityTypes {

        public static final BlockEntityType<DinotanerBlockEntity> DINOTANER_BLOCK_ENTITY = create("dinotaner_block_entity", FabricBlockEntityTypeBuilder.create(DinotanerBlockEntity::new, ModBlocks.DINOTANER).build(null));

        public static void initialize() {

        }

        private static <T extends BlockEntity> BlockEntityType<T> create(String id, BlockEntityType<T> blockEntityType) {
            return Registry.register(Registry.BLOCK_ENTITY_TYPE, Dinocraft.identify(id), blockEntityType);


        }}
