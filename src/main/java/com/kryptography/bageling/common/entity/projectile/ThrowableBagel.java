package com.kryptography.bageling.common.entity.projectile;

import com.kryptography.bageling.init.ModEntityTypes;
import com.kryptography.bageling.init.ModItems;
import com.kryptography.bageling.init.ModSounds;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ThrowableBagel extends ThrowableItemProjectile{



    public ThrowableBagel(Level levelIn, LivingEntity throwerIn) {
        super(ModEntityTypes.THROWABLE_BAGEL.get(), throwerIn, levelIn);

    }

    public ThrowableBagel(Level levelIn, double x, double y ,double z) {
        super(ModEntityTypes.THROWABLE_BAGEL.get(), x, y, z, levelIn);
    }

    public ThrowableBagel(EntityType<? extends ThrowableBagel> entity, Level level) {
        super(entity, level);
    }

    @SubscribeEvent
    public static void registerEntityRenders(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntityTypes.THROWABLE_BAGEL.get(), ThrownItemRenderer::new);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.SPIDERMANS_BAGEL.get();
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
            this.playSound(ModSounds.BONK.get(), 10F, 1F);

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
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        this.level().addFreshEntity(new ItemEntity(this.level(), this.getX(), this.getY(), this.getZ(), this.getItem()));
    }

    @Override
    public ItemStack getItem() {
        return new ItemStack(ModItems.SPIDERMANS_BAGEL.get());
    }

}
