package com.kryptography.bageling.common.tags.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class CommonTags {

    public static final TagKey<Item> FOODS_MILK = commonItemTag("foods/milk");
    public static final TagKey<Item> FOODS_DOUGH = commonItemTag("foods/dough");
    public static final TagKey<Item> FOODS_TOMATO = commonItemTag("foods/tomato");
    public static final TagKey<Item> FOODS_RAW_SALMON = commonItemTag("foods/raw_salmon");
    public static final TagKey<Item> FOODS_COOKED_BACON = commonItemTag("foods/cooked_bacon");
    public static final TagKey<Item> FOODS_COOKED_EGG = commonItemTag("foods/cooked_egg");

    private static TagKey<Item> commonItemTag(String path) {
        return ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", path));
    }
}
