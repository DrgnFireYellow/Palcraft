package com.drgnfireyellow.palcraft;

import com.drgnfireyellow.palcraft.entity.Entities;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import com.drgnfireyellow.palcraft.entity.pals.custom.Lamball;

public class Palcraft implements ModInitializer {

    @Override
    public void onInitialize() {
        // Items
        Registry.register(Registries.ITEM, new Identifier("palcraft", "palsphere"), Items.PAL_SPHERE_ITEM);

        // ItemGroups
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content ->
                content.add(Items.PAL_SPHERE_ITEM)
        );

        // Entities
        FabricDefaultAttributeRegistry.register(Entities.LAMBALL, Lamball.createMobAttributes());
    }

}
