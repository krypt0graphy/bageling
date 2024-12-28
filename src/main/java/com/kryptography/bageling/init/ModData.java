package com.kryptography.bageling.init;

import com.kryptography.bageling.Bageling;
import com.kryptography.bageling.common.dataproviders.ModBlockstateProvider;
import com.kryptography.bageling.common.dataproviders.ModItemModelProvider;
import com.kryptography.bageling.common.dataproviders.loot.ModLootTableProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

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

        gen.addProvider(event.includeClient(), new ModItemModelProvider(packOutput, existingFileHelper));
        gen.addProvider(event.includeClient(), new ModBlockstateProvider(packOutput, existingFileHelper));
        gen.addProvider(event.includeServer(), new LootTableProvider(packOutput, Collections.emptySet(), List.of(new LootTableProvider.SubProviderEntry(ModLootTableProvider::new, LootContextParamSets.BLOCK)), lookup));
    }
}
