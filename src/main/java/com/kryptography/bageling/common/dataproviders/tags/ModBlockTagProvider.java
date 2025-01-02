package com.kryptography.bageling.common.dataproviders.tags;

import com.kryptography.bageling.Bageling;
import com.kryptography.bageling.init.ModBlocks;
import com.kryptography.bageling.integration.FarmersDelightsTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.BlockTagsProvider;

import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Bageling.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(FarmersDelightsTags.MINEABLE_WITH_KNIFE)
                .add(ModBlocks.BAGEL_STACK.get());
    }
}
