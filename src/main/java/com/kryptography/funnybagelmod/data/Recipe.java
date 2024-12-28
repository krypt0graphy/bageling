package com.kryptography.funnybagelmod.data;

import com.kryptography.funnybagelmod.FunnyBagelMod;
import com.kryptography.funnybagelmod.initialization.ItemInit;
import com.kryptography.funnybagelmod.tag.ForgeTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.internal.NeoForgeItemTagsProvider;
import net.neoforged.neoforge.event.entity.player.AdvancementEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.concurrent.CompletableFuture;

public class Recipe extends RecipeProvider {
    public Recipe(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {

        ShapedRecipeBuilder
                .shaped(RecipeCategory.FOOD, ItemInit.BAGEL.get())
                .pattern(" w ")
                .pattern("w w")
                .pattern(" w ")
                .define('w', Items.WHEAT)
                .unlockedBy("wheat", has(Items.WHEAT))
                .save(pRecipeOutput);
        ShapedRecipeBuilder
                .shaped(RecipeCategory.FOOD, ItemInit.BAGEL_BLOCK_ITEM.get())
                .pattern("bbb")
                .pattern("bbb")
                .pattern("bbb")
                .define('b', ItemInit.BAGEL)
                .unlockedBy("wheat", has(Items.WHEAT))
                .save(pRecipeOutput);
        ShapedRecipeBuilder
                .shaped(RecipeCategory.FOOD, ItemInit.THROWABLE_BAGEL, 8)
                .pattern("bbb")
                .pattern("bsb")
                .pattern("bbb")
                .define('b', ItemInit.BAGEL)
                .define('s', Items.STRING)
                .unlockedBy("wheat", has(Items.WHEAT))
                .save(pRecipeOutput);

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.FOOD, ItemInit.CHEESE_BAGEL.get(), 3)
                .requires(ItemInit.BAGEL, 3)
                .requires(ForgeTags.MILK)
                .unlockedBy("wheat", has(Items.WHEAT))
                .save(pRecipeOutput);
        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.FOOD, ItemInit.CHEESE_BAGEL.get(), 3)
                .requires(ItemInit.BAGEL, 3)
                .requires(Items.MILK_BUCKET)
                .unlockedBy("wheat", has(Items.WHEAT))
                .save(pRecipeOutput, ResourceLocation.fromNamespaceAndPath(FunnyBagelMod.MODID, "cheese_bagel_milkbucket"));
        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.FOOD, ItemInit.BAGEL_DOUGH.get())
                .requires(ForgeTags.DOUGH)
                .unlockedBy("wheat", has(Items.WHEAT))
                .save(pRecipeOutput);
        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.FOOD, ItemInit.BAGEL, 9)
                .requires(ItemInit.BAGEL_BLOCK_ITEM)
                .unlockedBy("wheat", has(Items.WHEAT))
                .save(pRecipeOutput, ResourceLocation.fromNamespaceAndPath(FunnyBagelMod.MODID, "bagel_block_to_bagel"));

        SimpleCookingRecipeBuilder.smoking(Ingredient.of(ItemInit.BAGEL_DOUGH), RecipeCategory.FOOD, ItemInit.BAGEL.get(), 0.35F, 100)
                .unlockedBy("wheat", has(Items.WHEAT))
                .save(pRecipeOutput, ResourceLocation.fromNamespaceAndPath(FunnyBagelMod.MODID, "bagel_smoker"));
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ItemInit.BAGEL_DOUGH), RecipeCategory.FOOD, ItemInit.BAGEL.get(), 0.35F, 200)
                .unlockedBy("wheat", has(Items.WHEAT))
                .save(pRecipeOutput, ResourceLocation.fromNamespaceAndPath(FunnyBagelMod.MODID, "bagel_campfire"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ItemInit.BAGEL_DOUGH), RecipeCategory.FOOD, ItemInit.BAGEL.get(), 0.35F, 200)
                .unlockedBy("wheat", has(Items.WHEAT))
                .save(pRecipeOutput, ResourceLocation.fromNamespaceAndPath(FunnyBagelMod.MODID, "bagel_furnace"));
    }
}
