package com.kryptography.bageling.integration;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class FarmersDelightsTags {

    public static final TagKey<Block> MINEABLE_WITH_KNIFE = modBlockTag("mineable/knife");

    private static TagKey<Block> modBlockTag(String path) {
        return BlockTags.create(ResourceLocation.fromNamespaceAndPath(Mods.FARMERSDELIGHT.id(), path));
    }
}
