package com.drgnfireyellow.palcraft.client;

import com.drgnfireyellow.palcraft.entity.Entities;
import com.drgnfireyellow.palcraft.entity.pals.renderer.LamballRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class PalcraftClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(Entities.LAMBALL, LamballRenderer::new);
        EntityRendererRegistry.register(Entities.PALSPHERE_PROJECTILE, FlyingItemEntityRenderer::new);
    }
}
