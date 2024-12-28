package com.kryptography.funnybagelmod.initialization;

import com.kryptography.funnybagelmod.FunnyBagelMod;
import com.kryptography.funnybagelmod.items.ThrowableBagelItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;


@EventBusSubscriber(modid = FunnyBagelMod.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ItemInit {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(FunnyBagelMod.MODID);

    public static final DeferredItem<Item> BAGEL = ITEMS.register("bagel",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)
                    .food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.3F).build())));

    public static final DeferredItem<Item> CHEESE_BAGEL = ITEMS.register("cheese_bagel",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)
                    .food(new FoodProperties.Builder().nutrition(10).saturationModifier(0.4F).build())));

    public static final DeferredItem<Item> BAGEL_DOUGH = ITEMS.register("bagel_dough",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)
                    .food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.1F).build())));


    public static final DeferredItem<Item> THROWABLE_BAGEL = ITEMS.register("throwable_bagel",
            () -> new ThrowableBagelItem(new Item.Properties()
                    .stacksTo(64)
                    .rarity(Rarity.RARE)));



    public static final DeferredItem<BlockItem> BAGEL_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("bagel_block", BlockInit.BAGEL_BLOCK);


    @SubscribeEvent
    public static void buildContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.getEntries().putAfter(Items.BREAD.getDefaultInstance(), ItemInit.BAGEL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(ItemInit.BAGEL.get().getDefaultInstance(), ItemInit.BAGEL_DOUGH.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(ItemInit.BAGEL_DOUGH.get().getDefaultInstance(), ItemInit.CHEESE_BAGEL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(ItemInit.CHEESE_BAGEL.get().getDefaultInstance(), ItemInit.THROWABLE_BAGEL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(ItemInit.THROWABLE_BAGEL.get().getDefaultInstance(), ItemInit.BAGEL_BLOCK_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

        }
    }
}
