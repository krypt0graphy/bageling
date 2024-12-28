package com.kryptography.funnybagelmod.data;

import com.kryptography.funnybagelmod.FunnyBagelMod;
import com.kryptography.funnybagelmod.initialization.BlockInit;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Loot extends LootTableProvider {
    public Loot(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, Collections.emptySet(), List.of(
                new LootTableProvider.SubProviderEntry(Loot.BlockLoot::new, LootContextParamSets.BLOCK)
        ), lookupProvider);
    }

    private static class BlockLoot extends BlockLootSubProvider {

        protected BlockLoot(HolderLookup.Provider provider) {
            super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
        }

        @Override
        protected void generate() {
            dropSelf(BlockInit.BAGEL_BLOCK.get());
        }

        @Override
        protected Iterable<Block> getKnownBlocks()
        {
            return BuiltInRegistries.BLOCK.entrySet().stream()
                    .filter(e -> e.getKey().location().getNamespace().equals(FunnyBagelMod.MODID))
                    .map(Map.Entry::getValue)
                    .collect(Collectors.toList());
        }
    }
}
