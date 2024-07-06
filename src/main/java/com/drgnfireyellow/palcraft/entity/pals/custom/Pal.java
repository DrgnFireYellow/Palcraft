package com.drgnfireyellow.palcraft.entity.pals.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class Pal extends AnimalEntity {

    private boolean captured = false;
    private UUID ownerUuid = null;

    protected Pal(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    public void setCaptured(boolean value) {
        captured = false;
    }

    public boolean isCaptured() {
        return captured;
    }

    public void setOwner(UUID playerUuid) {
        ownerUuid = playerUuid;
    }

    public UUID getOwner() {
        return ownerUuid;
    }

}
