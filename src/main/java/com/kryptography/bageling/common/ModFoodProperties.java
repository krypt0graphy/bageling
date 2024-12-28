package com.kryptography.bageling.common;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {

    public static final FoodProperties BAGEL = new FoodProperties.Builder().nutrition(6).saturationModifier(0.3f).build();

    public static final FoodProperties BAGEL_DOUGH = new FoodProperties.Builder().nutrition(2).saturationModifier(0.3f).effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3f).build();

    public static final FoodProperties CREAM_CHEESE_BAGEL = new FoodProperties.Builder().nutrition(10).saturationModifier(0.4f).build();

}
