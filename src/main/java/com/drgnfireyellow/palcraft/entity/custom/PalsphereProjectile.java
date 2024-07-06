package com.drgnfireyellow.palcraft.entity.custom;

import com.drgnfireyellow.palcraft.Items;
import com.drgnfireyellow.palcraft.entity.Entities;
import com.drgnfireyellow.palcraft.entity.pals.custom.Pal;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

import java.util.Arrays;

public class PalsphereProjectile extends ThrownItemEntity {

    EntityType[] PALS = new EntityType[] {Entities.LAMBALL};

    public PalsphereProjectile(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public PalsphereProjectile(LivingEntity livingEntity, World world) {
        super(Entities.PALSPHERE_PROJECTILE, livingEntity, world);
    }

    @Override
    protected Item getDefaultItem() {
        return Items.PAL_SPHERE_ITEM;
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        this.discard();
        if (Arrays.asList(PALS).contains(entity.getType())) {
            LivingEntity lEntity = (LivingEntity) entity;
            double failureChance = lEntity.getHealth() / lEntity.getMaxHealth();
            if (Math.random() <= failureChance) {
                entity.playSound(SoundEvents.BLOCK_ANVIL_LAND, 2F, 1F);
            }
            else {
                entity.playSound(SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, 2F, 1F);
                entity.discard();
                Identifier entityTypeId = EntityType.getId(entity.getType());
                ItemStack usedStack = new ItemStack(Items.PAL_SPHERE_ITEM);
                NbtCompound usedNbt = new NbtCompound();
                usedNbt.putString("palType", entityTypeId.toString());
                usedStack.setNbt(usedNbt);
//                usedStack.setCustomName(Text.of("Pal Sphere [" + Text.translatable("entity." + entityTypeId.getNamespace() + "." + entityTypeId.getPath()) + "]"));
                dropStack(usedStack);
            }
        }
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
        if (this.getItem().getNbt() != null && this.getItem().getNbt().contains("palType")) {
            Pal summonedPal = (Pal) (EntityType.get(this.getItem().getNbt().getString("palType")).get()).create(this.getWorld());
            summonedPal.setPosition(blockHitResult.getPos());
            summonedPal.setCaptured(true);
            this.getWorld().spawnEntity(summonedPal);
        }
        this.discard();
    }
}
