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
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    private static final List<ItemLike> RUDANIUM_SMELTABLES = List.of(ModItems.RAW_RUDANIUM.get(),
            ModBlocks.RUDANIUM_ORE.get(), ModBlocks.RUDANIUM_ORE_DEEPSLATE.get(), ModBlocks.RUDANIUM_ORE_NETHER.get(),
            ModBlocks.RUDANIUM_ORE_END.get());

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

        toolsRecipes(pWriter, "has_rudanium", ModItemGroups.RUDANIUM_ARMOR_TOOLS_GROUP);
        armorRecipes(pWriter, "has_rudanium", ModItemGroups.RUDANIUM_ARMOR_TOOLS_GROUP);

        oreSmelting(pWriter, RUDANIUM_SMELTABLES, RecipeCategory.MISC, ModItems.RUDANIUM_INGOT.get(), 0.25f, 200, "rudanium");
        oreBlasting(pWriter, RUDANIUM_SMELTABLES, RecipeCategory.MISC, ModItems.RUDANIUM_INGOT.get(), 0.25f, 100, "rudanium");

        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC, ModItems.RAW_RUDANIUM.get(), RecipeCategory.MISC, ModBlocks.RAW_RUDANIUM_BLOCK.get(),
                "aberrance:raw_rudanium", "rudanium","aberrance:raw_rudanium_block", "rudanium");
        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC, ModItems.RUDANIUM_INGOT.get(), RecipeCategory.MISC, ModBlocks.RUDANIUM_BLOCK.get(),
                "aberrance:rudanium_ingot_from_block", "rudanium","aberrance:rudanium_block", "rudanium");
        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC, ModItems.RUDANIUM_NUGGET.get(), RecipeCategory.MISC, ModItems.RUDANIUM_INGOT.get(),
                "aberrance:rudanium_nugget", "rudanium","aberrance:rudanium_ingot_from_nuggets", "rudanium");

    }

    protected static void toolsRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer, String requirementName, ArmorToolsGroup itemGroup) {

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, itemGroup.getSwordItem())
                .pattern("W")
                .pattern("W")
                .pattern("S")
                .define('W', itemGroup.getMaterialItem())
                .define('S', Items.STICK)
                .unlockedBy(requirementName, inventoryTrigger(ItemPredicate.Builder.item().
                        of(itemGroup.getMaterialItem()).build()))
                .save(finishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, itemGroup.getPickaxeItem())
                .pattern("WWW")
                .pattern(" S ")
                .pattern(" S ")
                .define('W', itemGroup.getMaterialItem())
                .define('S', Items.STICK)
                .unlockedBy(requirementName, inventoryTrigger(ItemPredicate.Builder.item().
                        of(itemGroup.getMaterialItem()).build()))
                .save(finishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, itemGroup.getAxeItem())
                .pattern("WW")
                .pattern("SW")
                .pattern("S ")
                .define('W', itemGroup.getMaterialItem())
                .define('S', Items.STICK)
                .unlockedBy(requirementName, inventoryTrigger(ItemPredicate.Builder.item().
                        of(itemGroup.getMaterialItem()).build()))
                .save(finishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, itemGroup.getHoeItem())
                .pattern("WW")
                .pattern("S ")
                .pattern("S ")
                .define('W', itemGroup.getMaterialItem())
                .define('S', Items.STICK)
                .unlockedBy(requirementName, inventoryTrigger(ItemPredicate.Builder.item().
                        of(itemGroup.getMaterialItem()).build()))
                .save(finishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, itemGroup.getShovelItem())
                .pattern("W")
                .pattern("S")
                .pattern("S")
                .define('W', itemGroup.getMaterialItem())
                .define('S', Items.STICK)
                .unlockedBy(requirementName, inventoryTrigger(ItemPredicate.Builder.item().
                        of(itemGroup.getMaterialItem()).build()))
                .save(finishedRecipeConsumer);


    }

    protected static void armorRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer, String requirementName, ArmorToolsGroup itemGroup) {

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, itemGroup.getHelmetItem())
                .pattern("WWW")
                .pattern("W W")
                .define('W', itemGroup.getMaterialItem())
                .unlockedBy(requirementName, inventoryTrigger(ItemPredicate.Builder.item().
                        of(itemGroup.getMaterialItem()).build()))
                .save(finishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, itemGroup.getChestplateItem())
                .pattern("W W")
                .pattern("WWW")
                .pattern("WWW")
                .define('W', itemGroup.getMaterialItem())
                .unlockedBy(requirementName, inventoryTrigger(ItemPredicate.Builder.item().
                        of(itemGroup.getMaterialItem()).build()))
                .save(finishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, itemGroup.getLeggingsItem())
                .pattern("WWW")
                .pattern("W W")
                .pattern("W W")
                .define('W', itemGroup.getMaterialItem())
                .unlockedBy(requirementName, inventoryTrigger(ItemPredicate.Builder.item().
                        of(itemGroup.getMaterialItem()).build()))
                .save(finishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, itemGroup.getBootsItem())
                .pattern("W W")
                .pattern("W W")
                .define('W', itemGroup.getMaterialItem())
                .unlockedBy(requirementName, inventoryTrigger(ItemPredicate.Builder.item().
                        of(itemGroup.getMaterialItem()).build()))
                .save(finishedRecipeConsumer);
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

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer,
                                     List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime,
                            pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, Aberrance.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }

    protected static void simpleSmithing(Consumer<FinishedRecipe> pFinishedRecipeConsumer, String requirementName, RecipeCategory pCategory, Item pMaterialItem, Item pSmithedItem, Item pResultItem) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(), Ingredient.of(pSmithedItem),
                Ingredient.of(pMaterialItem), pCategory, pResultItem).unlocks(requirementName, has(pMaterialItem))
                .save(pFinishedRecipeConsumer, getItemName(pResultItem) + "_smithing");
    }
}
