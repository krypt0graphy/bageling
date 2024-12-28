package com.kryptography.bageling.common.item;


import com.kryptography.bageling.common.entity.projectile.ThrowableBagel;
import com.kryptography.bageling.init.ModItems;


import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ThrowableBagelItem extends Item {

    public ThrowableBagelItem(Item.Properties builder) {
        super(builder);
    }
    public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack itemstack = playerIn.getItemInHand(handIn);
        worldIn.playSound((Player)null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents.SNOWBALL_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (worldIn.getRandom().nextFloat() * 0.4F + 0.8F));
        if (!playerIn.getAbilities().instabuild) {
            itemstack.shrink(1);
        }

        if (!worldIn.isClientSide) {
            ThrowableBagel ThrowableBagel = new ThrowableBagel(worldIn, playerIn);
            ThrowableBagel.setItem(new ItemStack(ModItems.SPIDERMANS_BAGEL.get()));
            ThrowableBagel.shootFromRotation(playerIn, playerIn.getXRot(), playerIn.getYRot(), 0.0F, 0.6F, 1.0F);
            worldIn.addFreshEntity(ThrowableBagel);
        }

        playerIn.awardStat(Stats.ITEM_USED.get(this));
        return new InteractionResultHolder<>(InteractionResult.SUCCESS, itemstack);
    }

}