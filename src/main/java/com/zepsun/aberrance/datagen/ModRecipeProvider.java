package com.zepsun.aberrance.datagen;

import com.zepsun.aberrance.Aberrance;
import com.zepsun.aberrance.block.ModBlocks;
import com.zepsun.aberrance.datagen.custom.SeedMakingRecipeBuilder;
import com.zepsun.aberrance.item.ModItems;
import com.zepsun.aberrance.itemgroup.ArmorToolsGroup;
import com.zepsun.aberrance.itemgroup.ModItemGroups;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
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
                .unlockedBy("has_winter_wheat", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.WINTER_WHEAT.get()).build()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.CREPE_MYRTLE_PLANKS.get(), 4)
                .requires(ModBlocks.CREPE_MYRTLE_LOG.get())
                .unlockedBy("has_crepe_myrtle", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.CREPE_MYRTLE_LOG.get()).build()))
                .save(pWriter, new ResourceLocation(Aberrance.MOD_ID, "crepe_myrtle_planks_from_log"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.CREPE_MYRTLE_PLANKS.get(), 4)
                .requires(ModBlocks.CREPE_MYRTLE_WOOD.get())
                .unlockedBy("has_crepe_myrtle", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.CREPE_MYRTLE_LOG.get()).build()))
                .save(pWriter, new ResourceLocation(Aberrance.MOD_ID, "crepe_myrtle_planks_from_wood"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.CREPE_MYRTLE_PLANKS.get(), 4)
                .requires(ModBlocks.STRIPPED_CREPE_MYRTLE_WOOD.get())
                .unlockedBy("has_crepe_myrtle", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.CREPE_MYRTLE_LOG.get()).build()))
                .save(pWriter, new ResourceLocation(Aberrance.MOD_ID, "crepe_myrtle_planks_from_stripped_wood"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.CREPE_MYRTLE_PLANKS.get(), 4)
                .requires(ModBlocks.STRIPPED_CREPE_MYRTLE_LOG.get())
                .unlockedBy("has_crepe_myrtle", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.CREPE_MYRTLE_LOG.get()).build()))
                .save(pWriter, new ResourceLocation(Aberrance.MOD_ID, "crepe_myrtle_planks_from_stripped_log"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.CREPE_MYRTLE_WOOD.get(), 3)
                .requires(ModBlocks.CREPE_MYRTLE_LOG.get())
                .unlockedBy("has_crepe_myrtle", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.CREPE_MYRTLE_LOG.get()).build()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.STRIPPED_CREPE_MYRTLE_WOOD.get(), 3)
                .requires(ModBlocks.STRIPPED_CREPE_MYRTLE_LOG.get())
                .unlockedBy("has_crepe_myrtle", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.CREPE_MYRTLE_LOG.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.COBBLESTONE_CASE.get())
                .pattern("OAO")
                .pattern("ACA")
                .pattern("OAO")
                .define('A', Blocks.RAW_IRON_BLOCK)
                .define('O', Items.RAW_IRON)
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




        armorToolsSmithingRecipes(pWriter, "has_kyanite_ingot", ModItemGroups.NETHERITE_ARMOR_TOOLS_GROUP, ModItemGroups.KYANITE_ARMOR_TOOLS_GROUP);
        simpleSmithing(pWriter, "has_kyanite_ingot", RecipeCategory.MISC, ModItems.RAW_KYANITE.get(), Items.NETHERITE_INGOT, ModItems.KYANITE_INGOT.get());


        new SeedMakingRecipeBuilder(Items.WHEAT, Items.WHEAT_SEEDS, 2)
                .unlockedBy("has_wheat", has(Items.WHEAT)).save(pWriter);

        new SeedMakingRecipeBuilder(Items.BEETROOT, Items.BEETROOT_SEEDS, 2)
                .unlockedBy("has_beetroot", has(Items.BEETROOT)).save(pWriter);

        new SeedMakingRecipeBuilder(ModItems.PARSNIP.get(), ModItems.PARSNIP_SEEDS.get(), 2)
                .unlockedBy("has_parsnip", has(ModItems.PARSNIP.get())).save(pWriter);

        new SeedMakingRecipeBuilder(ModItems.WINTER_WHEAT.get(), ModItems.WINTER_WHEAT_SEEDS.get(), 2)
                .unlockedBy("has_winter_wheat", has(ModItems.WINTER_WHEAT.get())).save(pWriter);


    }

    protected static void armorToolsSmithingRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer, String requirementName, ArmorToolsGroup inputItemGroup, ArmorToolsGroup outputItemGroup) {

        simpleSmithing(finishedRecipeConsumer, requirementName, RecipeCategory.COMBAT, outputItemGroup.getMaterialItem(), inputItemGroup.getSwordItem(), outputItemGroup.getSwordItem());
        simpleSmithing(finishedRecipeConsumer, requirementName, RecipeCategory.TOOLS, outputItemGroup.getMaterialItem(), inputItemGroup.getPickaxeItem(), outputItemGroup.getPickaxeItem());
        simpleSmithing(finishedRecipeConsumer, requirementName, RecipeCategory.TOOLS, outputItemGroup.getMaterialItem(), inputItemGroup.getShovelItem(), outputItemGroup.getShovelItem());
        simpleSmithing(finishedRecipeConsumer, requirementName, RecipeCategory.TOOLS, outputItemGroup.getMaterialItem(), inputItemGroup.getAxeItem(), outputItemGroup.getAxeItem());
        simpleSmithing(finishedRecipeConsumer, requirementName, RecipeCategory.TOOLS, outputItemGroup.getMaterialItem(), inputItemGroup.getHoeItem(), outputItemGroup.getHoeItem());

        simpleSmithing(finishedRecipeConsumer, requirementName, RecipeCategory.COMBAT,  outputItemGroup.getMaterialItem(), inputItemGroup.getHelmetItem(), outputItemGroup.getHelmetItem());
        simpleSmithing(finishedRecipeConsumer, requirementName, RecipeCategory.COMBAT,  outputItemGroup.getMaterialItem(), inputItemGroup.getChestplateItem(), outputItemGroup.getChestplateItem());
        simpleSmithing(finishedRecipeConsumer, requirementName, RecipeCategory.COMBAT,  outputItemGroup.getMaterialItem(), inputItemGroup.getLeggingsItem(), outputItemGroup.getLeggingsItem());
        simpleSmithing(finishedRecipeConsumer, requirementName, RecipeCategory.COMBAT,  outputItemGroup.getMaterialItem(), inputItemGroup.getBootsItem(), outputItemGroup.getBootsItem());

    }

    protected static void simpleSmithing(Consumer<FinishedRecipe> pFinishedRecipeConsumer, String requirementName, RecipeCategory pCategory, Item pMaterialItem, Item pSmithedItem, Item pResultItem) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(), Ingredient.of(pSmithedItem),
                Ingredient.of(pMaterialItem), pCategory, pResultItem).unlocks(requirementName, has(pMaterialItem))
                .save(pFinishedRecipeConsumer, getItemName(pResultItem) + "_smithing");
    }
}
