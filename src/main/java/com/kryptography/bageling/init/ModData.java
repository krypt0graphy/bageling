package com.kryptography.bageling.init;

import com.kryptography.bageling.Bageling;
import com.kryptography.bageling.common.dataproviders.ModBlockstateProvider;
import com.kryptography.bageling.common.dataproviders.ModItemModelProvider;
import com.kryptography.bageling.common.dataproviders.ModRecipeProvider;
import com.kryptography.bageling.common.dataproviders.loot.ModLootTableProvider;
import com.kryptography.bageling.common.dataproviders.tags.ModBlockTagProvider;
import com.kryptography.bageling.common.dataproviders.tags.ModItemTagProvider;
import com.kryptography.bageling.integration.Mods;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = Bageling.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ModData {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        PackOutput packOutput = gen.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookup = event.getLookupProvider();

        BlockTagsProvider blockTagsProvider = new ModBlockTagProvider(packOutput, lookup, existingFileHelper);
        gen.addProvider(event.includeServer(), blockTagsProvider);
        gen.addProvider(event.includeClient(), new ModItemTagProvider(packOutput, lookup, blockTagsProvider.contentsGetter()));
        gen.addProvider(event.includeClient(), new ModItemModelProvider(packOutput, existingFileHelper));
        gen.addProvider(event.includeClient(), new ModBlockstateProvider(packOutput, existingFileHelper));
        gen.addProvider(event.includeServer(), new LootTableProvider(packOutput, Collections.emptySet(), List.of(new LootTableProvider.SubProviderEntry(ModLootTableProvider::new, LootContextParamSets.BLOCK)), lookup));
        gen.addProvider(event.includeServer(), new ModRecipeProvider(packOutput, lookup));
    }

    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            addAfter(event, Items.BREAD, ModItems.BAGEL);
            addAfter(event, Items.CAKE, ModBlocks.BAGEL_STACK);
            addAfter(event, Items.HONEY_BOTTLE, ModItems.SPIDERMANS_BAGEL);
            if (Mods.FARMERSDELIGHT.isLoaded() || Mods.CREATE.isLoaded()) {
                addAfter(event, Items.HONEY_BOTTLE, ModItems.BAGEL_DOUGH.get());
            }
            if (Mods.FARMERSDELIGHT.isLoaded()) {
                addAfter(event, Items.HONEY_BOTTLE, ModItems.SALMON_BAGEL.get());
                addAfter(event, Items.HONEY_BOTTLE, ModItems.BACON_EGG_CHEESE_BAGEL.get());
            }
            addAfter(event, Items.HONEY_BOTTLE, ModItems.CREAM_CHEESE_BAGEL);
            addAfter(event, Items.HONEY_BOTTLE, ModItems.GLOW_BERRY_JAM_BAGEL);
            addAfter(event, Items.HONEY_BOTTLE, ModItems.SWEET_BERRY_JAM_BAGEL);
            addAfter(event, Items.HONEY_BOTTLE, ModItems.APPLE_JAM_BAGEL);
        }

    }

    public static void addAfter(BuildCreativeModeTabContentsEvent event, ItemLike first, ItemLike second) {
        event.insertAfter(new ItemStack(first), new ItemStack(second), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }
}
