package com.kryptography.bageling.init;

import com.kryptography.bageling.Bageling;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,Bageling.MODID);
    public static final RegistryObject<Block> BAGEL_STACK = register("bagel_stack", () ->
            new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN)
                    .strength(0.5f)
                    .sound(SoundType.WOOL)
                    .destroyTime(0.5F))
            );


    public static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> ret = BLOCKS.register(name, block);
        ModItems.ITEMS.register(name, () -> new BlockItem(ret.get(), new Item.Properties()));
        return ret;
    }
}



