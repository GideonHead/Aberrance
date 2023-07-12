package com.zepsun.zecrops.datagen;


import com.zepsun.zecrops.ZECrops;
import com.zepsun.zecrops.block.ModBlocks;
import com.zepsun.zecrops.block.crop.ModCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ZECrops.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        leavesBlock(ModBlocks.ACACIA_MESQUITE_LEAVES);
        makeCrossCrop(((ModCropBlock) ModBlocks.PARSNIP_CROP.get()), "parsnip_stage", "parsnip_stage");
        makeCropCrop(((ModCropBlock) ModBlocks.WINTER_WHEAT_CROP.get()), "winter_wheat_stage", "winter_wheat_stage");

    }

    public void makeCrossCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> statesCross(state, block, modelName, textureName);
        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] statesCross(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().cross(modelName + state.getValue(((ModCropBlock) block).getAgeProperty()),
                new ResourceLocation(ZECrops.MOD_ID, "block/" + textureName + state.getValue(((ModCropBlock)block).getAgeProperty()))).renderType("cutout"));
        return models;
    }
    public void makeCropCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> statesCrop(state, block, modelName, textureName);
        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] statesCrop(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((ModCropBlock) block).getAgeProperty()),
                new ResourceLocation(ZECrops.MOD_ID, "block/" + textureName + state.getValue(((ModCropBlock)block).getAgeProperty()))).renderType("cutout"));
        return models;
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().cubeAll(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
}