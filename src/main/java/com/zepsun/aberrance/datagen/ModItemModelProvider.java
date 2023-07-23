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
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Aberrance.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.PARSNIP);
        simpleItem(ModItems.PARSNIP_SEEDS);
        simpleItem(ModItems.WINTER_WHEAT);
        simpleItem(ModItems.WINTER_WHEAT_SEEDS);
        simpleItem(ModItems.WINTER_WHEAT_BREAD);
        simpleItem(ModItems.ONION);
        simpleItem(ModItems.MESQUITE);
        saplingItem(ModBlocks.ACACIA_MESQUITE_SAPLING);
        simpleHandheldItem(ModItems.KYANITE_AXE);
        simpleHandheldItem(ModItems.KYANITE_SHOVEL);
        simpleHandheldItem(ModItems.KYANITE_PICKAXE);
        simpleHandheldItem(ModItems.KYANITE_HOE);
        simpleHandheldItem(ModItems.KYANITE_SWORD);
        simpleItem(ModItems.KYANITE_INGOT);
        simpleItem(ModItems.RAW_KYANITE);
        simpleItem(ModItems.KYANITE_NUGGET);
        saplingItem(ModBlocks.CREPE_MYRTLE_SAPLING);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Aberrance.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleHandheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(Aberrance.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Aberrance.MOD_ID,"block/" + item.getId().getPath()));
    }

    private ItemModelBuilder blockItem(RegistryObject<Block> block) {
        return withExistingParent(block.getId().getPath(),
                new ResourceLocation("aberrance:block/" + block.getId().getPath()));
    }
}
