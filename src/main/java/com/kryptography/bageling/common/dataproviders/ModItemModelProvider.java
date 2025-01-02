package com.kryptography.bageling.common.dataproviders;

import com.kryptography.bageling.Bageling;
import com.kryptography.bageling.init.ModItems;
import com.kryptography.bageling.integration.Mods;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Bageling.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.BAGEL.get());
        basicItem(ModItems.CREAM_CHEESE_BAGEL.get());
        basicItem(ModItems.SPIDERMANS_BAGEL.get());

        if (Mods.FARMERSDELIGHT.isLoaded() || Mods.CREATE.isLoaded()) {
            basicItem(ModItems.BAGEL_DOUGH.get());
        }
    }
}
