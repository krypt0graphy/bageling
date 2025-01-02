package com.kryptography.bageling.common.dataproviders;

import com.kryptography.bageling.Bageling;
import com.kryptography.bageling.common.tags.item.CommonTags;
import com.kryptography.bageling.init.ModBlocks;
import com.kryptography.bageling.init.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.BAGEL.get(), 3)
                .pattern(" W ")
                .pattern("W W")
                .pattern(" W ")
                .define('W', Items.WHEAT)
                .unlockedBy("has_wheat", has(Items.WHEAT))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.SPIDERMANS_BAGEL.get(), 8)
                .pattern("BBB")
                .pattern("BSB")
                .pattern("BBB")
                .define('B', ModItems.BAGEL.get())
                .define('S', Items.STRING)
                .unlockedBy("has_spidermans_bagel", has(ModItems.SPIDERMANS_BAGEL.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModBlocks.BAGEL_STACK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.BAGEL.get())
                .unlockedBy("has_bagel", has(ModItems.BAGEL.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.BAGEL.get(), 9)
                .requires(ModBlocks.BAGEL_STACK.get())
                .unlockedBy("has_bagel", has(ModItems.BAGEL.get()))
                .save(consumer, Bageling.id("bagel").toString() + "_from_bagel_stack");

        ConditionalRecipe.builder().addCondition(or(new ModLoadedCondition("create"), new ModLoadedCondition("farmersdelight"))).addRecipe(c ->
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.BAGEL_DOUGH.get())
                .requires(CommonTags.FOODS_DOUGH)
                .unlockedBy("has_dough", has(CommonTags.FOODS_DOUGH))
                .save(c)).generateAdvancement().build(consumer, Bageling.id("bagel_dough"));


        //Sandwiches

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.CREAM_CHEESE_BAGEL.get(), 3)
                .requires(ModItems.BAGEL.get(), 3)
                .requires(CommonTags.FOODS_MILK)
                .unlockedBy("has_milk", has(CommonTags.FOODS_MILK))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.APPLE_JAM_BAGEL.get())
                .requires(ModItems.BAGEL.get())
                .requires(Items.APPLE)
                .unlockedBy("has_apple", has(Items.APPLE))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.SWEET_BERRY_JAM_BAGEL.get())
                .requires(ModItems.BAGEL.get())
                .requires(Items.SWEET_BERRIES)
                .unlockedBy("has_sweet_berries", has(Items.SWEET_BERRIES))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.GLOW_BERRY_JAM_BAGEL.get())
                .requires(ModItems.BAGEL.get())
                .requires(Items.GLOW_BERRIES)
                .unlockedBy("has_glow_berries", has(Items.GLOW_BERRIES))
                .save(consumer);


        ConditionalRecipe.builder().addCondition(new ModLoadedCondition("farmersdelight")).addRecipe(c -> ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.SALMON_BAGEL.get())
                .requires(CommonTags.FOODS_RAW_SALMON)
                .requires(CommonTags.FOODS_TOMATO)
                .requires(CommonTags.FOODS_MILK)
                .requires(ModItems.BAGEL.get())
                .unlockedBy("has_salmon", has(Items.SALMON))
                .save(c)
        ).generateAdvancement().build(consumer, Bageling.id("salmon_bagel"));
        ConditionalRecipe.builder().addCondition(new ModLoadedCondition("farmersdelight")).addRecipe(c -> ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.BACON_EGG_CHEESE_BAGEL.get())
                .requires(CommonTags.FOODS_COOKED_BACON)
                .requires(CommonTags.FOODS_COOKED_EGG)
                .requires(CommonTags.FOODS_MILK)
                .requires(ModItems.BAGEL.get())
                .unlockedBy("has_bacon", has(CommonTags.FOODS_COOKED_BACON))
                .save(c)
        ).generateAdvancement().build(consumer, Bageling.id("bacon_egg_cheese_bagel") );

        ConditionalRecipe.builder().addCondition(new ModLoadedCondition("neapolitan")).addRecipe(c ->
                ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.STRAWBERRY_JAM_BAGEL.get())
                        .requires(ModItems.BAGEL.get())
                        .requires(CommonTags.FRUITS_STRAWBERRY)
                        .unlockedBy("has_strawberry", has(CommonTags.FRUITS_STRAWBERRY))
                        .save(c)).generateAdvancement().build(consumer, Bageling.id("strawberry_bagel"));

        //Cooking recipes

        ConditionalRecipe.builder().addCondition(or(new ModLoadedCondition("create"), new ModLoadedCondition("farmersdelight"))).addRecipe(c ->
                SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.BAGEL_DOUGH.get()), RecipeCategory.FOOD,
                                ModItems.BAGEL.get(), 0.35F, 150)
                        .unlockedBy("has_bagel_dough", has(ModItems.BAGEL_DOUGH.get()))
                        .save(c, Bageling.id("bagel").toString() + "_from_smelting")
                ).generateAdvancement().build(consumer, Bageling.id("bagel_from_smelting"));

        ConditionalRecipe.builder().addCondition(or(new ModLoadedCondition("create"), new ModLoadedCondition("farmersdelight"))).addRecipe(c ->
                SimpleCookingRecipeBuilder.smoking(Ingredient.of(ModItems.BAGEL_DOUGH.get()), RecipeCategory.FOOD,
                                ModItems.BAGEL.get(), 0.35F, 75)
                        .unlockedBy("has_bagel_dough", has(ModItems.BAGEL_DOUGH.get()))
                        .save(c, Bageling.id("bagel").toString() + "_from_smoking")
        ).generateAdvancement().build(consumer, Bageling.id("bagel_from_smoking"));
    }
}
