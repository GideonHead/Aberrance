package com.zepsun.aberrance.datagen;

import com.zepsun.aberrance.block.ModBlocks;
import com.zepsun.aberrance.datagen.custom.SeedMakingRecipeBuilder;
import com.zepsun.aberrance.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.WINTER_WHEAT_BREAD.get(), 1)
                .requires(ModItems.WINTER_WHEAT.get())
                .requires(ModItems.WINTER_WHEAT.get())
                .requires(ModItems.WINTER_WHEAT.get())
                .unlockedBy("has_exampleitem", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.WINTER_WHEAT.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.COBBLESTONE_CASE.get())
                .pattern("OAO")
                .pattern("ACA")
                .pattern("OAO")
                .define('A', Items.RAW_IRON)
                .define('O', Items.AIR)
                .define('C', Items.COBBLESTONE)
                .unlockedBy("has_cobblestone", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.COBBLESTONE).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SEED_MAKER.get())
                .pattern("OAO")
                .pattern("ACA")
                .pattern("OAO")
                .define('A', ModBlocks.COBBLESTONE_CASE.get())
                .define('O', Items.QUARTZ)
                .define('C', Items.DIAMOND_HOE)
                .unlockedBy("has_cobblestone", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.COBBLESTONE).build()))
                .save(pWriter);

        new SeedMakingRecipeBuilder(Items.WHEAT, Items.WHEAT_SEEDS, 2)
                .unlockedBy("has_wheat", has(Items.WHEAT)).save(pWriter);

        new SeedMakingRecipeBuilder(Items.BEETROOT, Items.BEETROOT_SEEDS, 2)
                .unlockedBy("has_beetroot", has(Items.BEETROOT)).save(pWriter);

        new SeedMakingRecipeBuilder(ModItems.PARSNIP.get(), ModItems.PARSNIP_SEEDS.get(), 2)
                .unlockedBy("has_parsnip", has(ModItems.PARSNIP.get())).save(pWriter);

        new SeedMakingRecipeBuilder(ModItems.WINTER_WHEAT.get(), ModItems.WINTER_WHEAT_SEEDS.get(), 2)
                .unlockedBy("has_winter_wheat", has(ModItems.WINTER_WHEAT.get())).save(pWriter);
    }
}
