package com.zepsun.aberrance.datagen;


import com.zepsun.aberrance.Aberrance;
import com.zepsun.aberrance.block.ModBlocks;
import com.zepsun.aberrance.block.custom.crop.ModCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
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

        //Parsnip
        makeCropCrop(((ModCropBlock) ModBlocks.PARSNIP_CROP.get()), "parsnip_stage", "parsnip_stage");
        flowerBlock(ModBlocks.WILD_WINTER_WHEAT_PLANT);

        //Winter Wheat
        makeCropCrop(((ModCropBlock) ModBlocks.WINTER_WHEAT_CROP.get()), "winter_wheat_stage", "winter_wheat_stage");
        flowerBlock(ModBlocks.WILD_PARSNIP_PLANT);

        //Onion
        makeCropCrop(((ModCropBlock) ModBlocks.ONION_CROP.get()), "onion_stage", "onion_stage");
        flowerBlock(ModBlocks.WILD_ONION_PLANT);

        //Machines and Machine Parts
        orientableBlockWithItem(ModBlocks.SEED_MAKER, "seed_maker_side", "seed_maker_side", "cobblestone_case");
        blockWithItem(ModBlocks.COBBLESTONE_CASE);

        //Kyanite
        blockWithItem(ModBlocks.KYANITE_ORE);
        blockWithItem(ModBlocks.KYANITE_ORE_DEEPSLATE);
        blockWithItem(ModBlocks.KYANITE_ORE_END);
        blockWithItem(ModBlocks.KYANITE_ORE_NETHER);
        blockWithItem(ModBlocks.KYANITE_BLOCK);
        blockWithItem(ModBlocks.RAW_KYANITE_BLOCK);

        //Rudanium
        blockWithItem(ModBlocks.RUDANIUM_ORE);
        blockWithItem(ModBlocks.RUDANIUM_ORE_DEEPSLATE);
        blockWithItem(ModBlocks.RUDANIUM_ORE_END);
        blockWithItem(ModBlocks.RUDANIUM_ORE_NETHER);
        blockWithItem(ModBlocks.RUDANIUM_BLOCK);
        blockWithItem(ModBlocks.RAW_RUDANIUM_BLOCK);


        //Acacia Mesquite
        leavesBlock(ModBlocks.ACACIA_MESQUITE_LEAVES);
        saplingBlock(ModBlocks.ACACIA_MESQUITE_SAPLING);

        //Crepe Myrtle
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
        stairsBlock((StairBlock) ModBlocks.CREPE_MYRTLE_STAIRS.get(), blockTexture(ModBlocks.CREPE_MYRTLE_PLANKS.get()));
        slabBlock((SlabBlock) ModBlocks.CREPE_MYRTLE_SLAB.get(), blockTexture(ModBlocks.CREPE_MYRTLE_PLANKS.get()), blockTexture(ModBlocks.CREPE_MYRTLE_PLANKS.get()));
        blockItem(ModBlocks.CREPE_MYRTLE_STAIRS);
        blockItem(ModBlocks.CREPE_MYRTLE_SLAB);
        doorBlockWithRenderType((DoorBlock) ModBlocks.CREPE_MYRTLE_DOOR.get(), modLoc("block/crepe_myrtle_door_bottom"), modLoc("block/crepe_myrtle_door_top"), "cutout");
        trapdoorBlockWithRenderType((TrapDoorBlock) ModBlocks.CREPE_MYRTLE_TRAPDOOR.get(), modLoc("block/crepe_myrtle_trapdoor"), true, "cutout");
        trapdoorBlockItem(ModBlocks.CREPE_MYRTLE_TRAPDOOR);
        buttonBlock((ButtonBlock) ModBlocks.CREPE_MYRTLE_BUTTON.get(), blockTexture(ModBlocks.CREPE_MYRTLE_PLANKS.get()));
        pressurePlateBlock((PressurePlateBlock) ModBlocks.CREPE_MYRTLE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.CREPE_MYRTLE_PLANKS.get()));
        blockItem(ModBlocks.CREPE_MYRTLE_PRESSURE_PLATE);
        fenceBlock((FenceBlock) ModBlocks.CREPE_MYRTLE_FENCE.get(), blockTexture(ModBlocks.CREPE_MYRTLE_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) ModBlocks.CREPE_MYRTLE_FENCE_GATE.get(), blockTexture(ModBlocks.CREPE_MYRTLE_PLANKS.get()));
        blockItem(ModBlocks.CREPE_MYRTLE_FENCE_GATE);

        //Live Oak
        logBlock(((RotatedPillarBlock) ModBlocks.LIVE_OAK_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.LIVE_OAK_WOOD.get()), blockTexture(ModBlocks.LIVE_OAK_LOG.get()), blockTexture(ModBlocks.LIVE_OAK_LOG.get()));
        logBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_LIVE_OAK_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_LIVE_OAK_WOOD.get()), blockTexture(ModBlocks.STRIPPED_LIVE_OAK_LOG.get()),
                blockTexture(ModBlocks.STRIPPED_LIVE_OAK_LOG.get()));
        blockWithItem(ModBlocks.LIVE_OAK_LEAVES);
        blockWithItem(ModBlocks.LIVE_OAK_PLANKS);
        saplingBlock(ModBlocks.LIVE_OAK_SAPLING);
        blockItem(ModBlocks.LIVE_OAK_LOG);
        blockItem(ModBlocks.LIVE_OAK_WOOD);
        blockItem(ModBlocks.STRIPPED_LIVE_OAK_LOG);
        blockItem(ModBlocks.STRIPPED_LIVE_OAK_WOOD);
        stairsBlock((StairBlock) ModBlocks.LIVE_OAK_STAIRS.get(), blockTexture(ModBlocks.LIVE_OAK_PLANKS.get()));
        slabBlock((SlabBlock) ModBlocks.LIVE_OAK_SLAB.get(), blockTexture(ModBlocks.LIVE_OAK_PLANKS.get()), blockTexture(ModBlocks.LIVE_OAK_PLANKS.get()));
        blockItem(ModBlocks.LIVE_OAK_STAIRS);
        blockItem(ModBlocks.LIVE_OAK_SLAB);
        trapdoorBlockWithRenderType((TrapDoorBlock) ModBlocks.LIVE_OAK_TRAPDOOR.get(), modLoc("block/live_oak_trapdoor"), true, "cutout");
        doorBlockWithRenderType((DoorBlock) ModBlocks.LIVE_OAK_DOOR.get(), modLoc("block/live_oak_door_bottom"), modLoc("block/live_oak_door_top"),
                "cutout");
        trapdoorBlockItem(ModBlocks.LIVE_OAK_TRAPDOOR);
        buttonBlock((ButtonBlock) ModBlocks.LIVE_OAK_BUTTON.get(), blockTexture(ModBlocks.LIVE_OAK_PLANKS.get()));
        pressurePlateBlock((PressurePlateBlock) ModBlocks.LIVE_OAK_PRESSURE_PLATE.get(), blockTexture(ModBlocks.LIVE_OAK_PLANKS.get()));
        blockItem(ModBlocks.LIVE_OAK_PRESSURE_PLATE);
        fenceBlock((FenceBlock) ModBlocks.LIVE_OAK_FENCE.get(), blockTexture(ModBlocks.LIVE_OAK_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) ModBlocks.LIVE_OAK_FENCE_GATE.get(), blockTexture(ModBlocks.LIVE_OAK_PLANKS.get()));
        blockItem(ModBlocks.LIVE_OAK_FENCE_GATE);


        //Broadleaf
        logBlock(((RotatedPillarBlock) ModBlocks.BROADLEAF_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.BROADLEAF_WOOD.get()), blockTexture(ModBlocks.BROADLEAF_LOG.get()), blockTexture(ModBlocks.BROADLEAF_LOG.get()));
        logBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_BROADLEAF_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_BROADLEAF_WOOD.get()), blockTexture(ModBlocks.STRIPPED_BROADLEAF_LOG.get()),
                blockTexture(ModBlocks.STRIPPED_BROADLEAF_LOG.get()));
        blockWithItem(ModBlocks.BROADLEAF_LEAVES);
        blockWithItem(ModBlocks.BROADLEAF_PLANKS);
        saplingBlock(ModBlocks.BROADLEAF_SAPLING);
        blockItem(ModBlocks.BROADLEAF_LOG);
        blockItem(ModBlocks.BROADLEAF_WOOD);
        blockItem(ModBlocks.STRIPPED_BROADLEAF_LOG);
        blockItem(ModBlocks.STRIPPED_BROADLEAF_WOOD);
        stairsBlock((StairBlock) ModBlocks.BROADLEAF_STAIRS.get(), blockTexture(ModBlocks.BROADLEAF_PLANKS.get()));
        slabBlock((SlabBlock) ModBlocks.BROADLEAF_SLAB.get(), blockTexture(ModBlocks.BROADLEAF_PLANKS.get()), blockTexture(ModBlocks.BROADLEAF_PLANKS.get()));
        blockItem(ModBlocks.BROADLEAF_STAIRS);
        blockItem(ModBlocks.BROADLEAF_SLAB);
        trapdoorBlockWithRenderType((TrapDoorBlock) ModBlocks.BROADLEAF_TRAPDOOR.get(), modLoc("block/broadleaf_trapdoor"), true, "cutout");
        doorBlockWithRenderType((DoorBlock) ModBlocks.BROADLEAF_DOOR.get(), modLoc("block/broadleaf_door_bottom"), modLoc("block/broadleaf_door_top"),
                "cutout");
        trapdoorBlockItem(ModBlocks.BROADLEAF_TRAPDOOR);
        buttonBlock((ButtonBlock) ModBlocks.BROADLEAF_BUTTON.get(), blockTexture(ModBlocks.BROADLEAF_PLANKS.get()));
        pressurePlateBlock((PressurePlateBlock) ModBlocks.BROADLEAF_PRESSURE_PLATE.get(), blockTexture(ModBlocks.BROADLEAF_PLANKS.get()));
        blockItem(ModBlocks.BROADLEAF_PRESSURE_PLATE);
        fenceBlock((FenceBlock) ModBlocks.BROADLEAF_FENCE.get(), blockTexture(ModBlocks.BROADLEAF_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) ModBlocks.BROADLEAF_FENCE_GATE.get(), blockTexture(ModBlocks.BROADLEAF_PLANKS.get()));
        blockItem(ModBlocks.BROADLEAF_FENCE_GATE);


        //White Stone
        blockWithItem(ModBlocks.WHITE_COBBLESTONE);
        blockWithItem(ModBlocks.WHITE_STONE_BRICKS);
        wallBlock((WallBlock) ModBlocks.WHITE_STONE_BRICK_WALL.get(), blockTexture(ModBlocks.WHITE_STONE_BRICKS.get()));
        wallBlock((WallBlock) ModBlocks.WHITE_COBBLESTONE_WALL.get(), blockTexture(ModBlocks.WHITE_COBBLESTONE.get()));
        blockWithItem(ModBlocks.WHITE_STONE);
        wallBlock((WallBlock) ModBlocks.WHITE_STONE_WALL.get(), blockTexture(ModBlocks.WHITE_STONE.get()));
        stairsBlock((StairBlock) ModBlocks.WHITE_STONE_STAIRS.get(), blockTexture(ModBlocks.WHITE_STONE.get()));
        slabBlock((SlabBlock) ModBlocks.WHITE_STONE_SLAB.get(), blockTexture(ModBlocks.WHITE_STONE.get()), blockTexture(ModBlocks.WHITE_STONE.get()));
        stairsBlock((StairBlock) ModBlocks.WHITE_COBBLESTONE_STAIRS.get(), blockTexture(ModBlocks.WHITE_COBBLESTONE.get()));
        slabBlock((SlabBlock) ModBlocks.WHITE_COBBLESTONE_SLAB.get(), blockTexture(ModBlocks.WHITE_COBBLESTONE.get()), blockTexture(ModBlocks.WHITE_COBBLESTONE.get()));
        stairsBlock((StairBlock) ModBlocks.WHITE_STONE_BRICK_STAIRS.get(), blockTexture(ModBlocks.WHITE_STONE_BRICKS.get()));
        slabBlock((SlabBlock) ModBlocks.WHITE_STONE_BRICK_SLAB.get(), blockTexture(ModBlocks.WHITE_STONE_BRICKS.get()), blockTexture(ModBlocks.WHITE_STONE_BRICKS.get()));
        blockItem(ModBlocks.WHITE_STONE_STAIRS);
        blockItem(ModBlocks.WHITE_STONE_SLAB);
        blockItem(ModBlocks.WHITE_COBBLESTONE_STAIRS);
        blockItem(ModBlocks.WHITE_COBBLESTONE_SLAB);
        blockItem(ModBlocks.WHITE_STONE_BRICK_STAIRS);
        blockItem(ModBlocks.WHITE_STONE_BRICK_SLAB);


        //Misc Soul
        blockWithItem(ModBlocks.SOUL_SEDIMENT);


        //starved soul
        blockWithItem(ModBlocks.STARVED_SOUL_SOIL);
        flowerBlock(ModBlocks.STARVED_SOUL_GRASS);
        topSideBlockWithItem(ModBlocks.STARVED_SOUL_GRASS_BLOCK, "starved_soul_grass_block_side", "starved_soul_soil", "starved_soul_grass_block_top");
        blockWithItem(ModBlocks.STARVED_SPORE);
        saplingBlock(ModBlocks.STARVED_FUNGUS);
        logBlock((RotatedPillarBlock) ModBlocks.STARVED_STEM.get());
        axisBlock(((RotatedPillarBlock) ModBlocks.STARVED_HYPHAE.get()), blockTexture(ModBlocks.STARVED_STEM.get()), blockTexture(ModBlocks.STARVED_STEM.get()));
        blockItem(ModBlocks.STARVED_STEM);
        blockItem(ModBlocks.STARVED_HYPHAE);


        //Murderous Soul
        blockWithItem(ModBlocks.MURDEROUS_SOUL_SOIL);
        flowerBlock(ModBlocks.MURDEROUS_SOUL_GRASS);
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

    private void topSideBlockWithItem(RegistryObject<Block> blockRegistryObject, String side, String bottom, String top) {
        simpleBlockWithItem(blockRegistryObject.get(), models().orientableWithBottom(name(blockRegistryObject.get()),
                new ResourceLocation(Aberrance.MOD_ID, blockTexturePath(side)),
                new ResourceLocation(Aberrance.MOD_ID, blockTexturePath(side)),
                new ResourceLocation(Aberrance.MOD_ID, blockTexturePath(bottom)),
                new ResourceLocation(Aberrance.MOD_ID, blockTexturePath(top))));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("aberrance:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void trapdoorBlockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("aberrance:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + "_bottom"));
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