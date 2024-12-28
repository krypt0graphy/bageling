package com.kryptography.funnybagelmod.tag;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;


public class ForgeTags {
    public static final TagKey<Item> MILK = forgeItemTag("milk");
    public static final TagKey<Item> DOUGH = forgeItemTag("dough");

    private static TagKey<Item> forgeItemTag(String path) {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("forge", path));
    }
}
