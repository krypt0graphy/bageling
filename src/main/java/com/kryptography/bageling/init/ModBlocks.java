package com.kryptography.bageling.init;

import com.kryptography.bageling.Bageling;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Bageling.MODID);
    public static final DeferredBlock<Block> BAGEL_STACK = register("bagel_stack", () ->
            new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN)
                    .strength(0.5f)
                    .sound(SoundType.WOOL)
                    .destroyTime(0.5F))
            );


    public static <T extends Block> DeferredBlock<T> register(String name, Supplier<T> block) {
        DeferredBlock<T> ret = BLOCKS.register(name, block);
        ModItems.ITEMS.register(name, () -> new BlockItem(ret.get(), new Item.Properties()));
        return ret;
    }
}



