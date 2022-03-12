package com.dinocrew.dinocraft.registry.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;

public class ProffessorEntity extends HostileEntity {
    public ProffessorEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }
}
