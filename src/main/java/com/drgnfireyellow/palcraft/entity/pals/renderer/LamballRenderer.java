package com.drgnfireyellow.palcraft.entity.pals.renderer;

import com.drgnfireyellow.palcraft.entity.pals.custom.Lamball;
import com.drgnfireyellow.palcraft.entity.pals.geo.LamballGeo;
import net.minecraft.client.render.entity.EntityRendererFactory;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class LamballRenderer extends GeoEntityRenderer<Lamball> {
    public LamballRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new LamballGeo());
    }
}
