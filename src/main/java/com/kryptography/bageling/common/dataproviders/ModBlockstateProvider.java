package com.kryptography.bageling.common.dataproviders;

import com.kryptography.bageling.Bageling;

import com.kryptography.bageling.init.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;


public class ModBlockstateProvider extends BlockStateProvider {
    public ModBlockstateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Bageling.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        this.simpleBlockWithItem(ModBlocks.BAGEL_STACK.get(), models().withExistingParent(ModBlocks.BAGEL_STACK.getRegisteredName(),"block/cube_bottom_top").texture("top", ModBlocks.BAGEL_STACK.getId().withSuffix("_top").withPrefix("block/")).texture("side", ModBlocks.BAGEL_STACK.getId().withSuffix("_side").withPrefix("block/")).texture("bottom", ModBlocks.BAGEL_STACK.getId().withSuffix("_bottom").withPrefix("block/")));
    }
}
