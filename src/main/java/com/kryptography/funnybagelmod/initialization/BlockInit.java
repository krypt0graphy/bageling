package com.kryptography.funnybagelmod.initialization;

import com.kryptography.funnybagelmod.FunnyBagelMod;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BlockInit {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(FunnyBagelMod.MODID);
    public static final DeferredBlock<Block> BAGEL_BLOCK = BLOCKS.registerSimpleBlock("bagel_block",
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN)
                    .strength(1.0f)
                    .sound(SoundType.WOOL)
                    .destroyTime(1F)
            );

}



