package com.kryptography.bageling.common;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {

    public static final FoodProperties BAGEL = new FoodProperties.Builder().nutrition(5).saturationModifier(0.4f).fast().build();

    public static final FoodProperties BAGEL_DOUGH = new FoodProperties.Builder().nutrition(2).saturationModifier(0.4f).effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3f).fast().build();

    public static final FoodProperties CREAM_CHEESE_BAGEL = new FoodProperties.Builder().nutrition(8).saturationModifier(0.4f).fast().build();

    public static final FoodProperties BACON_EGG_CHEESE_BAGEL = new FoodProperties.Builder().nutrition(10).saturationModifier(0.8f).fast().build();

    public static final FoodProperties SALMON_BAGEL = new FoodProperties.Builder().nutrition(10).saturationModifier(0.8f).fast().build();

    public static final FoodProperties APPLE_JAM_BAGEL = new FoodProperties.Builder().nutrition(7).saturationModifier(0.4f).alwaysEdible().effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300, 0, false, false), 1F).fast().build();

    public static final FoodProperties SWEET_BERRY_JAM_BAGEL = new FoodProperties.Builder().nutrition(7).saturationModifier(0.4f).alwaysEdible().effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300, 0, false, false), 1F).fast().build();

    public static final FoodProperties GLOW_BERRY_JAM_BAGEL = new FoodProperties.Builder().nutrition(7).saturationModifier(0.4f).alwaysEdible().effect(() -> new MobEffectInstance(MobEffects.GLOWING, 100, 0), 1F).fast().build();

    public static final FoodProperties APPLE_JAM_BAGEL_NO_FD = new FoodProperties.Builder().nutrition(7).saturationModifier(0.4f).fast().build();

    public static final FoodProperties SWEET_BERRY_JAM_BAGEL_NO_FD = new FoodProperties.Builder().nutrition(7).saturationModifier(0.4f).fast().build();

    public static final FoodProperties GLOW_BERRY_JAM_BAGEL_NO_FD = new FoodProperties.Builder().nutrition(7).saturationModifier(0.4f).fast().build();
}
