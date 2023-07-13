package com.zepsun.zecrops.datagen;

import com.zepsun.zecrops.ZECrops;
import com.zepsun.zecrops.block.ModBlocks;
import com.zepsun.zecrops.item.ModItems;
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
        super(output, ZECrops.MOD_ID, existingFileHelper);
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

    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ZECrops.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ZECrops.MOD_ID,"block/" + item.getId().getPath()));
    }
}
