package com.kryptography.bageling.init;

import com.kryptography.bageling.Bageling;
import com.kryptography.bageling.common.ModFoodProperties;
import com.kryptography.bageling.common.item.ThrowableBagelItem;
import com.kryptography.bageling.integration.Mods;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Bageling.MODID);

    public static final RegistryObject<Item> BAGEL = ITEMS.register("bagel", () -> new Item(new Item.Properties().food(ModFoodProperties.BAGEL)));

    public static final RegistryObject<Item> CREAM_CHEESE_BAGEL = ITEMS.register("cream_cheese_bagel", () -> new Item(new Item.Properties().food(ModFoodProperties.CREAM_CHEESE_BAGEL)));

    public static final RegistryObject<Item> SPIDERMANS_BAGEL = ITEMS.register("spidermans_bagel", () -> new ThrowableBagelItem(new Item.Properties().rarity(Rarity.RARE)));

    public static final RegistryObject<Item> APPLE_JAM_BAGEL = ITEMS.register("apple_jam_bagel", () -> new Item(new Item.Properties().food(Mods.FARMERSDELIGHT.isLoaded() ? ModFoodProperties.APPLE_JAM_BAGEL : ModFoodProperties.APPLE_JAM_BAGEL_NO_FD)));

    public static final RegistryObject<Item> SWEET_BERRY_JAM_BAGEL = ITEMS.register("sweet_berry_jam_bagel", () -> new Item(new Item.Properties().food(Mods.FARMERSDELIGHT.isLoaded() ? ModFoodProperties.SWEET_BERRY_JAM_BAGEL : ModFoodProperties.SWEET_BERRY_JAM_BAGEL_NO_FD)));;

    public static final RegistryObject<Item> GLOW_BERRY_JAM_BAGEL = ITEMS.register("glow_berry_jam_bagel", () -> new Item(new Item.Properties().food(Mods.FARMERSDELIGHT.isLoaded() ? ModFoodProperties.GLOW_BERRY_JAM_BAGEL : ModFoodProperties.GLOW_BERRY_JAM_BAGEL_NO_FD)));;

    //Other Mods
    public static final RegistryObject<Item> BAGEL_DOUGH = ITEMS.register("bagel_dough", () -> new Item(new Item.Properties().food(ModFoodProperties.BAGEL_DOUGH)));

    public static final RegistryObject<Item> BACON_EGG_CHEESE_BAGEL = ITEMS.register("bacon_egg_cheese_bagel", () -> new Item(new Item.Properties().food(ModFoodProperties.BACON_EGG_CHEESE_BAGEL)));

    public static final RegistryObject<Item> SALMON_BAGEL =  ITEMS.register("salmon_bagel", () -> new Item(new Item.Properties().food(ModFoodProperties.SALMON_BAGEL)));
}