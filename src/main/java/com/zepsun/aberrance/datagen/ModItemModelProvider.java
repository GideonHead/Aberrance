package com.zepsun.aberrance.datagen;

import com.zepsun.aberrance.Aberrance;
import com.zepsun.aberrance.block.ModBlocks;
import com.zepsun.aberrance.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Aberrance.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.PARSNIP);
        simpleItem(ModItems.PARSNIP_SEEDS);
        simpleBlockItem(ModBlocks.WILD_WINTER_WHEAT_PLANT);

        simpleItem(ModItems.WINTER_WHEAT);
        simpleItem(ModItems.WINTER_WHEAT_SEEDS);
        simpleItem(ModItems.WINTER_WHEAT_BREAD);
        simpleBlockItem(ModBlocks.WILD_PARSNIP_PLANT);

        simpleItem(ModItems.ONION);
        simpleBlockItem(ModBlocks.WILD_ONION_PLANT);

        simpleItem(ModItems.MESQUITE);
        simpleBlockItem(ModBlocks.ACACIA_MESQUITE_SAPLING);

        simpleHandheldItem(ModItems.KYANITE_AXE);
        simpleHandheldItem(ModItems.KYANITE_SHOVEL);
        simpleHandheldItem(ModItems.KYANITE_PICKAXE);
        simpleHandheldItem(ModItems.KYANITE_HOE);
        simpleHandheldItem(ModItems.KYANITE_SWORD);
        simpleItem(ModItems.KYANITE_INGOT);
        simpleItem(ModItems.RAW_KYANITE);
        simpleItem(ModItems.KYANITE_NUGGET);
        simpleItem(ModItems.KYANITE_HELMET);
        simpleItem(ModItems.KYANITE_CHESTPLATE);
        simpleItem(ModItems.KYANITE_LEGGINGS);
        simpleItem(ModItems.KYANITE_BOOTS);

        simpleHandheldItem(ModItems.RUDANIUM_AXE);
        simpleHandheldItem(ModItems.RUDANIUM_SHOVEL);
        simpleHandheldItem(ModItems.RUDANIUM_PICKAXE);
        simpleHandheldItem(ModItems.RUDANIUM_HOE);
        simpleHandheldItem(ModItems.RUDANIUM_SWORD);
        simpleItem(ModItems.RUDANIUM_INGOT);
        simpleItem(ModItems.RAW_RUDANIUM);
        simpleItem(ModItems.RUDANIUM_NUGGET);
        simpleItem(ModItems.RUDANIUM_HELMET);
        simpleItem(ModItems.RUDANIUM_CHESTPLATE);
        simpleItem(ModItems.RUDANIUM_LEGGINGS);
        simpleItem(ModItems.RUDANIUM_BOOTS);

        simpleItem(ModItems.MUSIC_DISC_ENRICHED);

        simpleBlockItem(ModBlocks.CREPE_MYRTLE_SAPLING);

        simpleBlockItem(ModBlocks.LIVE_OAK_SAPLING);

        simpleBlockItem(ModBlocks.LIVE_OAK_DOOR);
        simpleBlockItem(ModBlocks.CREPE_MYRTLE_DOOR);

        buttonItem(ModBlocks.LIVE_OAK_BUTTON, ModBlocks.LIVE_OAK_PLANKS);
        buttonItem(ModBlocks.CREPE_MYRTLE_BUTTON, ModBlocks.CREPE_MYRTLE_PLANKS);
        fenceItem(ModBlocks.LIVE_OAK_FENCE, ModBlocks.LIVE_OAK_PLANKS);
        fenceItem(ModBlocks.CREPE_MYRTLE_FENCE, ModBlocks.CREPE_MYRTLE_PLANKS);
        wallItem(ModBlocks.WHITE_COBBLESTONE_WALL, ModBlocks.WHITE_COBBLESTONE);
        wallItem(ModBlocks.WHITE_STONE_BRICK_WALL, ModBlocks.WHITE_STONE_BRICKS);
        wallItem(ModBlocks.WHITE_STONE_WALL, ModBlocks.WHITE_STONE);

        fenceItem(ModBlocks.BROADLEAF_FENCE, ModBlocks.BROADLEAF_PLANKS);
        buttonItem(ModBlocks.BROADLEAF_BUTTON, ModBlocks.BROADLEAF_PLANKS);
        simpleBlockItem(ModBlocks.BROADLEAF_DOOR);
        simpleBlockItem(ModBlocks.BROADLEAF_SAPLING);

        fenceItem(ModBlocks.PALM_FENCE, ModBlocks.PALM_PLANKS);
        buttonItem(ModBlocks.PALM_BUTTON, ModBlocks.PALM_PLANKS);
        simpleBlockItem(ModBlocks.PALM_DOOR);
        simpleBlockItem(ModBlocks.PALM_SAPLING);

        simpleBlockItem(ModBlocks.MURDEROUS_SOUL_GRASS);
        simpleBlockItem(ModBlocks.STARVED_SOUL_GRASS);
        simpleBlockItem(ModBlocks.STARVED_FUNGUS);
        fenceItem(ModBlocks.STARVED_FENCE, ModBlocks.STARVED_PLANKS);
        buttonItem(ModBlocks.STARVED_BUTTON, ModBlocks.STARVED_PLANKS);
        simpleBlockItem(ModBlocks.STARVED_DOOR);
        simpleBlockItem(ModBlocks.STARVED_FUNGUS);

        simpleHandheldItem(ModItems.CUTLASS);
        simpleHandheldItem(ModItems.VIOLIN_BOW);



    }

    private <T> ItemModelBuilder simpleItem(RegistryObject<T> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Aberrance.MOD_ID, "item/" + item.getId().getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture", new ResourceLocation(Aberrance.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(Aberrance.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(Aberrance.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private <T> ItemModelBuilder simpleItemTextureName(RegistryObject<T> item, String name) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Aberrance.MOD_ID, "item/" + name));
    }

    private <T> ItemModelBuilder simpleHandheldItem(RegistryObject<T> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(Aberrance.MOD_ID, "item/" + item.getId().getPath()));
    }

    private <T> ItemModelBuilder simpleHandheldItemTextureName(RegistryObject<T> item, String name) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(Aberrance.MOD_ID, "item/" + name));
    }

    private <T> ItemModelBuilder simpleBlockItem(RegistryObject<T> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Aberrance.MOD_ID, "block/" + item.getId().getPath()));
    }

    private ItemModelBuilder blockItem(RegistryObject<Block> block) {
        return withExistingParent(block.getId().getPath(),
                new ResourceLocation("aberrance:block/" + block.getId().getPath()));
    }
}
