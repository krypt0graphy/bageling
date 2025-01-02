package com.kryptography.bageling.common.dataproviders.tags;

import com.kryptography.bageling.common.tags.item.CommonTags;
import com.kryptography.bageling.init.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;


import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags) {
        super(output, lookupProvider, blockTags);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(CommonTags.FOODS_DOUGH)
                .add(ModItems.BAGEL_DOUGH.get());
    }
}
