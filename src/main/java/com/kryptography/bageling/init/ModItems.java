package com.kryptography.bageling.init;

import com.kryptography.bageling.Bageling;
import com.kryptography.bageling.common.ModFoodProperties;
import com.kryptography.bageling.common.item.ThrowableBagelItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Bageling.MODID);

    public static final DeferredItem<Item> BAGEL = ITEMS.register("bagel", () -> new Item(new Item.Properties().food(ModFoodProperties.BAGEL)));

    public static final DeferredItem<Item> CREAM_CHEESE_BAGEL = ITEMS.register("cream_cheese_bagel", () -> new Item(new Item.Properties().food(ModFoodProperties.CREAM_CHEESE_BAGEL)));

    public static final DeferredItem<Item> SPIDERMANS_BAGEL = ITEMS.register("spidermans_bagel", () -> new ThrowableBagelItem(new Item.Properties().rarity(Rarity.RARE)));
}