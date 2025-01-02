package com.kryptography.bageling.common.tags.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class CommonTags {

    public static final TagKey<Item> FOODS_MILK = commonItemTag("milk");
    public static final TagKey<Item> FOODS_DOUGH = commonItemTag("dough");
    public static final TagKey<Item> FOODS_TOMATO = commonItemTag("vegetables/tomato");
    public static final TagKey<Item> FOODS_RAW_SALMON = commonItemTag("raw_fishes/salmon");
    public static final TagKey<Item> FOODS_COOKED_BACON = commonItemTag("cooked_bacon");
    public static final TagKey<Item> FOODS_COOKED_EGG = commonItemTag("cooked_eggs");
    public static final TagKey<Item> FRUITS_STRAWBERRY = commonItemTag("fruits/strawberry");

    private static TagKey<Item> commonItemTag(String path) {
        return ItemTags.create(ResourceLocation.fromNamespaceAndPath("forge", path));
    }
}
