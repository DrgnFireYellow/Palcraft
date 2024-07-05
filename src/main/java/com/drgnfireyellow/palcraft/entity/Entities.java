package com.drgnfireyellow.palcraft.entity;

import com.drgnfireyellow.palcraft.entity.custom.PalsphereProjectile;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import com.drgnfireyellow.palcraft.entity.pals.custom.Lamball;

public class Entities {
    public static final EntityType<PalsphereProjectile> PALSPHERE_PROJECTILE = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier("palcraft", "palsphere_projectile"),
            FabricEntityTypeBuilder.<PalsphereProjectile>create(SpawnGroup.MISC, PalsphereProjectile::new).dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build()
    );

    public static final EntityType<Lamball> LAMBALL = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier("palcraft", "lamball"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, Lamball::new).dimensions(EntityDimensions.fixed(0.75F, 0.75F)).build());
}
