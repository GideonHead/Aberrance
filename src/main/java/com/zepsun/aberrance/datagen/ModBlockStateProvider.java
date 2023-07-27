package com.zepsun.aberrance.datagen;


import com.zepsun.aberrance.Aberrance;
import com.zepsun.aberrance.block.ModBlocks;
import com.zepsun.aberrance.block.custom.crop.ModCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.client.model.generators.ModelFile;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Aberrance.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        leavesBlock(ModBlocks.ACACIA_MESQUITE_LEAVES);
        saplingBlock(ModBlocks.ACACIA_MESQUITE_SAPLING);
        makeCrossCrop(((ModCropBlock) ModBlocks.PARSNIP_CROP.get()), "parsnip_stage", "parsnip_stage");
        makeCropCrop(((ModCropBlock) ModBlocks.WINTER_WHEAT_CROP.get()), "winter_wheat_stage", "winter_wheat_stage");
        makeCropCrop(((ModCropBlock) ModBlocks.ONION_CROP.get()), "onion_stage", "onion_stage");
        orientableBlockWithItem(ModBlocks.SEED_MAKER, "seed_maker_side", "seed_maker_side", "cobblestone_case");
        blockWithItem(ModBlocks.COBBLESTONE_CASE);
        blockWithItem(ModBlocks.KYANITE_ORE);
        blockWithItem(ModBlocks.KYANITE_ORE_DEEPSLATE);
        blockWithItem(ModBlocks.KYANITE_ORE_END);
        blockWithItem(ModBlocks.KYANITE_ORE_NETHER);
        blockWithItem(ModBlocks.KYANITE_BLOCK);
        blockWithItem(ModBlocks.RAW_KYANITE_BLOCK);
        blockWithItem(ModBlocks.WHITE_COBBLESTONE);
        blockWithItem(ModBlocks.WHITE_STONE_BRICKS);
        blockWithItem(ModBlocks.CREPE_MYRTLE_COMPOST);
        blockWithItem(ModBlocks.CREPE_MYRTLE_LEAVES);
        blockWithItem(ModBlocks.CREPE_MYRTLE_PLANKS);
        saplingBlock(ModBlocks.CREPE_MYRTLE_SAPLING);
        logBlock(((RotatedPillarBlock) ModBlocks.CREPE_MYRTLE_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.CREPE_MYRTLE_WOOD.get()), blockTexture(ModBlocks.CREPE_MYRTLE_LOG.get()), blockTexture(ModBlocks.CREPE_MYRTLE_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_CREPE_MYRTLE_LOG.get(), new ResourceLocation(Aberrance.MOD_ID, "block/stripped_crepe_myrtle_log"),
                new ResourceLocation(Aberrance.MOD_ID, "block/stripped_crepe_myrtle_log_top"));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_CREPE_MYRTLE_WOOD.get(), new ResourceLocation(Aberrance.MOD_ID, "block/stripped_crepe_myrtle_log"),
                new ResourceLocation(Aberrance.MOD_ID, "block/stripped_crepe_myrtle_log"));
        blockItem(ModBlocks.CREPE_MYRTLE_LOG);
        blockItem(ModBlocks.CREPE_MYRTLE_WOOD);
        blockItem(ModBlocks.STRIPPED_CREPE_MYRTLE_LOG);
        blockItem(ModBlocks.STRIPPED_CREPE_MYRTLE_WOOD);
        flowerBlock(ModBlocks.WILD_ONION_PLANT);
        blockWithItem(ModBlocks.RUDANIUM_ORE);
        blockWithItem(ModBlocks.RUDANIUM_ORE_DEEPSLATE);
        blockWithItem(ModBlocks.RUDANIUM_ORE_END);
        blockWithItem(ModBlocks.RUDANIUM_ORE_NETHER);
        blockWithItem(ModBlocks.RUDANIUM_BLOCK);
        blockWithItem(ModBlocks.RAW_RUDANIUM_BLOCK);


    }

    public void makeCrossCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> statesCross(state, block, modelName, textureName);
        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] statesCross(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().cross(modelName + state.getValue(((ModCropBlock) block).getAgeProperty()),
                new ResourceLocation(Aberrance.MOD_ID, "block/" + textureName + state.getValue(((ModCropBlock)block).getAgeProperty()))).renderType("cutout"));
        return models;
    }
    public void makeCropCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> statesCrop(state, block, modelName, textureName);
        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] statesCrop(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((ModCropBlock) block).getAgeProperty()),
                new ResourceLocation(Aberrance.MOD_ID, "block/" + textureName + state.getValue(((ModCropBlock)block).getAgeProperty()))).renderType("cutout"));
        return models;
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().cubeAll(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void flowerBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void orientableBlockWithItem(RegistryObject<Block> blockRegistryObject, String side, String front, String top) {
        simpleBlockWithItem(blockRegistryObject.get(), models().orientable(name(blockRegistryObject.get()),
                new ResourceLocation(Aberrance.MOD_ID, blockTexturePath(side)),
                new ResourceLocation(Aberrance.MOD_ID, blockTexturePath(front)),
                new ResourceLocation(Aberrance.MOD_ID, blockTexturePath(top))));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("aberrance:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private String name(Block block) {
        return key(block).getPath();
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }

    private String blockTexturePath(String name) {
        return "block/" + name;
    }

}