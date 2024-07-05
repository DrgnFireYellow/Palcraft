package com.drgnfireyellow.palcraft.entity.pals.geo;

import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import com.drgnfireyellow.palcraft.entity.pals.custom.Lamball;

public class LamballGeo extends GeoModel<Lamball> {
    private final Identifier model = new Identifier("palcraft", "geo/entity/lamball.geo.json");
    private final Identifier texture = new Identifier("palcraft", "textures/entity/lamball.png");
    private final Identifier animation = new Identifier("palcraft", "animations/entity/lamball.animation.json");

    @Override
    public Identifier getModelResource(Lamball object) {
        return this.model;
    }

    @Override
    public Identifier getTextureResource(Lamball object) {
        return this.texture;
    }

    @Override
    public Identifier getAnimationResource(Lamball object) {
        return this.animation;
    }
}
