package com.kryptography.funnybagelmod.entity.projectile;

import com.kryptography.funnybagelmod.initialization.EntityInit;
import com.kryptography.funnybagelmod.initialization.ItemInit;
import com.kryptography.funnybagelmod.sound.FunnyBagelSound;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

public class ThrowableBagel extends ThrowableItemProjectile{



    public ThrowableBagel(Level levelIn, LivingEntity throwerIn) {
        super(EntityInit.THROWABLE_BAGEL.get(), throwerIn, levelIn);

    }

    public ThrowableBagel(Level levelIn, double x, double y ,double z) {
        super(EntityInit.THROWABLE_BAGEL.get(), x, y, z, levelIn);
    }

   // public ThrowableBagel(PlayMessages.SpawnEntity spawnEntity, Level level) {
    // this(EntityInit.THROWABLE_BAGEL.get(), level);
    //}

    public ThrowableBagel(EntityType<? extends ThrowableBagel> entity, Level level) {
        super(entity, level);
    }

    @SubscribeEvent
    public static void registerEntityRenders(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityInit.THROWABLE_BAGEL.get(), ThrownItemRenderer::new);
    }

    @Override
    protected Item getDefaultItem() {
        return ItemInit.THROWABLE_BAGEL.get();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void handleEntityEvent(byte id) {
        if (id == 3) {
            for (int n = 0; n < 8; ++n) {
                level().addParticle(new ItemParticleOption(ParticleTypes.ITEM, this.getItem()), this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
            }
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult hitResult) {
        super.onHitEntity(hitResult);
        Entity entity = hitResult.getEntity();
        Level level = hitResult.getEntity().level();
        entity.hurt(this.damageSources().thrown(this, this.getOwner()), (float) 0);
        if (entity instanceof Player) {
            ((Player) entity).getFoodData().eat(6, 0.3F);
            this.playSound(FunnyBagelSound.BONK.get(), 10F, 1F);

        }
    }


    @Override
    protected void onHit(HitResult p_37406_) {
        super.onHit(p_37406_);
        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte)3);
            this.discard();
        }

    }


    @Override
    public ItemStack getItem() {
        return new ItemStack(ItemInit.THROWABLE_BAGEL.get());
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket(ServerEntity p_352459_) {
        return super.getAddEntityPacket(p_352459_);
    }
}
