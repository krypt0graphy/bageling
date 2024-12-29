package com.kryptography.bageling.common.dataproviders;

import com.kryptography.bageling.Bageling;
import com.kryptography.bageling.common.tags.item.CommonTags;
import com.kryptography.bageling.init.ModBlocks;
import com.kryptography.bageling.init.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput, HolderLookup.Provider holderLookup) {
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.BAGEL)
                .pattern(" W ")
                .pattern("W W")
                .pattern(" W ")
                .define('W', Items.WHEAT)
                .unlockedBy("has_wheat", has(Items.WHEAT))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.SPIDERMANS_BAGEL, 8)
                .pattern("BBB")
                .pattern("BSB")
                .pattern("BBB")
                .define('B', ModItems.BAGEL)
                .define('S', Items.STRING)
                .unlockedBy("has_spidermans_bagel", has(ModItems.SPIDERMANS_BAGEL))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModBlocks.BAGEL_STACK)
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.BAGEL)
                .unlockedBy("has_bagel", has(ModItems.BAGEL))
                .save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.BAGEL, 9)
                .requires(ModBlocks.BAGEL_STACK)
                .unlockedBy("has_bagel", has(ModItems.BAGEL))
                .save(pRecipeOutput, Bageling.id("bagel").toString() + "_from_bagel_stack");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.BAGEL_DOUGH.get())
                .requires(CommonTags.FOODS_DOUGH)
                .unlockedBy("has_dough", has(CommonTags.FOODS_DOUGH))
                .save(pRecipeOutput);

        //Sandwiches

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.CREAM_CHEESE_BAGEL, 3)
                .requires(ModItems.BAGEL, 3)
                .requires(CommonTags.FOODS_MILK)
                .unlockedBy("has_milk", has(CommonTags.FOODS_MILK))
                .save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.APPLE_JAM_BAGEL)
                .requires(ModItems.BAGEL)
                .requires(Items.APPLE)
                .unlockedBy("has_apple", has(Items.APPLE))
                .save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.SWEET_BERRY_JAM_BAGEL)
                .requires(ModItems.BAGEL)
                .requires(Items.SWEET_BERRIES)
                .unlockedBy("has_sweet_berries", has(Items.SWEET_BERRIES))
                .save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.GLOW_BERRY_JAM_BAGEL)
                .requires(ModItems.BAGEL)
                .requires(Items.GLOW_BERRIES)
                .unlockedBy("has_glow_berries", has(Items.GLOW_BERRIES))
                .save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.BACON_EGG_CHEESE_BAGEL.get())
                .requires(CommonTags.FOODS_COOKED_BACON)
                .requires(CommonTags.FOODS_COOKED_EGG)
                .requires(CommonTags.FOODS_MILK)
                .requires(ModItems.BAGEL)
                .unlockedBy("has_porkchop", has(Items.PORKCHOP))
                .save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.SALMON_BAGEL.get())
                .requires(CommonTags.FOODS_RAW_SALMON)
                .requires(CommonTags.FOODS_TOMATO)
                .requires(CommonTags.FOODS_MILK)
                .requires(ModItems.BAGEL)
                .unlockedBy("has_salmon", has(Items.SALMON))
                .save(pRecipeOutput);

        //Cooking recipes
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.BAGEL_DOUGH.get()), RecipeCategory.FOOD,
                        ModItems.BAGEL, 0.35F, 150)
                .unlockedBy("has_bagel_dough", has(ModItems.BAGEL_DOUGH.get()))
                .save(pRecipeOutput, Bageling.id("bagel").toString() + "_from_smelting");

        SimpleCookingRecipeBuilder.smoking(Ingredient.of(ModItems.BAGEL_DOUGH.get()), RecipeCategory.FOOD,
                        ModItems.BAGEL, 0.35F, 75)
                .unlockedBy("has_bagel_dough", has(ModItems.BAGEL_DOUGH.get()))
                .save(pRecipeOutput, Bageling.id("bagel").toString() + "_from_smoking");

    }
}
