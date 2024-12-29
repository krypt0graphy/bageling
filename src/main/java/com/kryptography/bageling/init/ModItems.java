package com.kryptography.bageling.init;

import com.kryptography.bageling.Bageling;
import com.kryptography.bageling.common.ModFoodProperties;
import com.kryptography.bageling.common.item.ThrowableBagelItem;
import com.kryptography.bageling.integration.Mods;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Optional;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Bageling.MODID);

    public static final DeferredItem<Item> BAGEL = ITEMS.register("bagel", () -> new Item(new Item.Properties().food(ModFoodProperties.BAGEL)));

    public static final DeferredItem<Item> CREAM_CHEESE_BAGEL = ITEMS.register("cream_cheese_bagel", () -> new Item(new Item.Properties().food(ModFoodProperties.CREAM_CHEESE_BAGEL)));

    public static final DeferredItem<Item> SPIDERMANS_BAGEL = ITEMS.register("spidermans_bagel", () -> new ThrowableBagelItem(new Item.Properties().rarity(Rarity.RARE)));

    public static final DeferredItem<Item> APPLE_JAM_BAGEL = ITEMS.register("apple_jam_bagel", () -> new Item(new Item.Properties().food(Mods.FARMERSDELIGHT.isLoaded() ? ModFoodProperties.APPLE_JAM_BAGEL : ModFoodProperties.APPLE_JAM_BAGEL_NO_FD)));

    public static final DeferredItem<Item> SWEET_BERRY_JAM_BAGEL = ITEMS.register("sweet_berry_jam_bagel", () -> new Item(new Item.Properties().food(Mods.FARMERSDELIGHT.isLoaded() ? ModFoodProperties.SWEET_BERRY_JAM_BAGEL : ModFoodProperties.SWEET_BERRY_JAM_BAGEL_NO_FD)));;

    public static final DeferredItem<Item> GLOW_BERRY_JAM_BAGEL = ITEMS.register("glow_berry_jam_bagel", () -> new Item(new Item.Properties().food(Mods.FARMERSDELIGHT.isLoaded() ? ModFoodProperties.GLOW_BERRY_JAM_BAGEL : ModFoodProperties.GLOW_BERRY_JAM_BAGEL_NO_FD)));;

    //Other Mods
    public static final Optional<DeferredItem<Item>> BAGEL_DOUGH = (Mods.FARMERSDELIGHT.isLoaded() || Mods.CREATE.isLoaded()) ? Optional.of(ITEMS.register("bagel_dough", () -> new Item(new Item.Properties().food(ModFoodProperties.BAGEL_DOUGH)))) : Optional.empty();

    public static final Optional<DeferredItem<Item>> BACON_EGG_CHEESE_BAGEL = Mods.FARMERSDELIGHT.runIfInstalled(() -> (DeferredItem<Item>) ITEMS.register("bacon_egg_cheese_bagel", () -> new Item(new Item.Properties().food(ModFoodProperties.BACON_EGG_CHEESE_BAGEL))));

    public static final Optional<DeferredItem<Item>> SALMON_BAGEL =  Mods.FARMERSDELIGHT.runIfInstalled(() -> (DeferredItem<Item>) ITEMS.register("salmon_bagel", () -> new Item(new Item.Properties().food(ModFoodProperties.SALMON_BAGEL))));
}