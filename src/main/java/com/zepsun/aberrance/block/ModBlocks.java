package com.zepsun.aberrance.block;

import com.zepsun.aberrance.Aberrance;
import com.zepsun.aberrance.block.custom.*;
import com.zepsun.aberrance.block.custom.crop.ModCropBlock;
import com.zepsun.aberrance.block.custom.station.SeedMakerBlock;
import com.zepsun.aberrance.item.ModItems;
import com.zepsun.aberrance.tag.ModTags;
import com.zepsun.aberrance.worldgen.tree.*;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Aberrance.MOD_ID);


    //Parsnip
    public static final RegistryObject<Block> PARSNIP_CROP = BLOCKS.register("parsnip_crop",
            () -> new ModCropBlock(ModItems.PARSNIP_SEEDS::get, BlockBehaviour.Properties.copy(Blocks.WHEAT)));
    public static final RegistryObject<Block> WILD_PARSNIP_PLANT = registerBlock("wild_parsnip_plant",
            () -> new CustomPlacementBushBlock(ModTags.Blocks.ABERRANCE_PLANT_PLACEABLES,
                    BlockBehaviour.Properties.copy(Blocks.ALLIUM)));


    //Winter Wheat
    public static final RegistryObject<Block> WINTER_WHEAT_CROP = BLOCKS.register("winter_wheat_crop",
            () -> new ModCropBlock(ModItems.WINTER_WHEAT_SEEDS::get, BlockBehaviour.Properties.copy(Blocks.WHEAT)));
    public static final RegistryObject<Block> WILD_WINTER_WHEAT_PLANT = registerBlock("wild_winter_wheat_plant",
            () -> new CustomPlacementBushBlock(ModTags.Blocks.ABERRANCE_PLANT_PLACEABLES,
                    BlockBehaviour.Properties.copy(Blocks.ALLIUM)));


    //Onion
    public static final RegistryObject<Block> ONION_CROP = BLOCKS.register("onion_crop",
            () -> new ModCropBlock(ModItems.ONION::get, BlockBehaviour.Properties.copy(Blocks.WHEAT)));
    public static final RegistryObject<Block> WILD_ONION_PLANT = registerBlock("wild_onion_plant",
            () -> new CustomPlacementBushBlock(ModTags.Blocks.ABERRANCE_PLANT_PLACEABLES,
                    BlockBehaviour.Properties.copy(Blocks.ALLIUM)));


    //Mesquite
    public static final RegistryObject<Block> ACACIA_MESQUITE_LEAVES = registerBlock("acacia_mesquite_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).strength(0.2F)
                    .randomTicks().sound(SoundType.GRASS).noOcclusion().isSuffocating(ModBlocks::never).isViewBlocking(ModBlocks::never)
                    .ignitedByLava().pushReaction(PushReaction.DESTROY).isRedstoneConductor(ModBlocks::never)));
    public static final RegistryObject<Block> ACACIA_MESQUITE_SAPLING = registerBlock("acacia_mesquite_sapling",
            () -> new SaplingBlock(new AcaciaMesquiteTreeGrower(), BlockBehaviour.Properties.copy(Blocks.ACACIA_SAPLING)));


    //Crepe Myrtle
    public static final RegistryObject<Block> CREPE_MYRTLE_LEAVES = registerBlock("crepe_myrtle_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).strength(0.2F)
                    .randomTicks().sound(SoundType.GRASS).noOcclusion().isSuffocating(ModBlocks::never).isViewBlocking(ModBlocks::never)
                    .ignitedByLava().pushReaction(PushReaction.DESTROY).isRedstoneConductor(ModBlocks::never)));
    public static final RegistryObject<Block> CREPE_MYRTLE_SAPLING = registerBlock("crepe_myrtle_sapling",
            () -> new SaplingBlock(new CrepeMyrtleTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> STRIPPED_CREPE_MYRTLE_WOOD = registerBlock("stripped_crepe_myrtle_wood",
            () -> new FlammableWoodLog(BlockBehaviour.Properties.of().copy(Blocks.OAK_LOG).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CREPE_MYRTLE_WOOD = registerBlock("crepe_myrtle_wood",
            () -> new StrippableFlammableWoodLog(STRIPPED_CREPE_MYRTLE_WOOD, BlockBehaviour.Properties.of().copy(Blocks.OAK_LOG).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_CREPE_MYRTLE_LOG = registerBlock("stripped_crepe_myrtle_log",
            () -> new FlammableWoodLog(BlockBehaviour.Properties.of().copy(Blocks.OAK_LOG).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CREPE_MYRTLE_LOG = registerBlock("crepe_myrtle_log",
            () -> new StrippableFlammableWoodLog(STRIPPED_CREPE_MYRTLE_LOG, BlockBehaviour.Properties.of().copy(Blocks.OAK_LOG).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CREPE_MYRTLE_PLANKS = registerBlock("crepe_myrtle_planks",
            () -> new FlammableBlock(BlockBehaviour.Properties.of().copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CREPE_MYRTLE_COMPOST = registerBlock("crepe_myrtle_compost",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT).copy(Blocks.DIRT).sound(SoundType.ROOTED_DIRT)));
    public static final RegistryObject<Block> CREPE_MYRTLE_STAIRS = registerBlock("crepe_myrtle_stairs",
            () -> new StairBlock(() -> ModBlocks.LIVE_OAK_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.of().copy(Blocks.OAK_STAIRS)));
    public static final RegistryObject<Block> CREPE_MYRTLE_SLAB = registerBlock("crepe_myrtle_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().copy(Blocks.OAK_SLAB)));
    public static final RegistryObject<Block> CREPE_MYRTLE_DOOR = registerBlock("crepe_myrtle_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of().copy(Blocks.OAK_DOOR).sound(SoundType.WOOD), BlockSetType.OAK));
    public static final RegistryObject<Block> CREPE_MYRTLE_TRAPDOOR = registerBlock("crepe_myrtle_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of().copy(Blocks.OAK_TRAPDOOR).sound(SoundType.WOOD), BlockSetType.OAK));
    public static final RegistryObject<Block> CREPE_MYRTLE_PRESSURE_PLATE = registerBlock("crepe_myrtle_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of().copy(Blocks.OAK_TRAPDOOR), BlockSetType.OAK));
    public static final RegistryObject<Block> CREPE_MYRTLE_BUTTON = registerBlock("crepe_myrtle_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.of().copy(Blocks.OAK_TRAPDOOR), BlockSetType.OAK, 20, true));
    public static final RegistryObject<Block> CREPE_MYRTLE_FENCE = registerBlock("crepe_myrtle_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().copy(Blocks.OAK_FENCE).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CREPE_MYRTLE_FENCE_GATE = registerBlock("crepe_myrtle_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of().copy(Blocks.OAK_FENCE_GATE).sound(SoundType.WOOD), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));


    //Live Oak
    public static final RegistryObject<Block> STRIPPED_LIVE_OAK_WOOD = registerBlock("stripped_live_oak_wood",
            () -> new FlammableWoodLog(BlockBehaviour.Properties.of().copy(Blocks.OAK_LOG).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> LIVE_OAK_WOOD = registerBlock("live_oak_wood",
            () -> new StrippableFlammableWoodLog(STRIPPED_LIVE_OAK_WOOD, BlockBehaviour.Properties.of().copy(Blocks.OAK_LOG).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_LIVE_OAK_LOG = registerBlock("stripped_live_oak_log",
            () -> new FlammableWoodLog(BlockBehaviour.Properties.of().copy(Blocks.OAK_LOG).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> LIVE_OAK_LOG = registerBlock("live_oak_log",
            () -> new StrippableFlammableWoodLog(STRIPPED_LIVE_OAK_LOG, BlockBehaviour.Properties.of().copy(Blocks.OAK_LOG).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> LIVE_OAK_PLANKS = registerBlock("live_oak_planks",
            () -> new FlammableBlock(BlockBehaviour.Properties.of().copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> LIVE_OAK_LEAVES = registerBlock("live_oak_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).strength(0.2F)
                    .randomTicks().sound(SoundType.GRASS).noOcclusion().isSuffocating(ModBlocks::never).isViewBlocking(ModBlocks::never)
                    .ignitedByLava().pushReaction(PushReaction.DESTROY).isRedstoneConductor(ModBlocks::never)));
    public static final RegistryObject<Block> LIVE_OAK_SAPLING = registerBlock("live_oak_sapling",
            () -> new SaplingBlock(new LiveOakTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> LIVE_OAK_STAIRS = registerBlock("live_oak_stairs",
            () -> new StairBlock(() -> ModBlocks.LIVE_OAK_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.of().copy(Blocks.OAK_STAIRS)));
    public static final RegistryObject<Block> LIVE_OAK_SLAB = registerBlock("live_oak_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().copy(Blocks.OAK_SLAB)));
    public static final RegistryObject<Block> LIVE_OAK_DOOR = registerBlock("live_oak_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of().copy(Blocks.OAK_DOOR).sound(SoundType.WOOD), BlockSetType.OAK));
    public static final RegistryObject<Block> LIVE_OAK_TRAPDOOR = registerBlock("live_oak_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of().copy(Blocks.OAK_TRAPDOOR).sound(SoundType.WOOD), BlockSetType.OAK));
    public static final RegistryObject<Block> LIVE_OAK_PRESSURE_PLATE = registerBlock("live_oak_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of().copy(Blocks.OAK_TRAPDOOR), BlockSetType.OAK));
    public static final RegistryObject<Block> LIVE_OAK_BUTTON = registerBlock("live_oak_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.of().copy(Blocks.OAK_TRAPDOOR), BlockSetType.OAK, 20, true));
    public static final RegistryObject<Block> LIVE_OAK_FENCE = registerBlock("live_oak_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().copy(Blocks.OAK_FENCE).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> LIVE_OAK_FENCE_GATE = registerBlock("live_oak_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of().copy(Blocks.OAK_FENCE_GATE).sound(SoundType.WOOD), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));


    //Broadleaf
    public static final RegistryObject<Block> STRIPPED_BROADLEAF_WOOD = registerBlock("stripped_broadleaf_wood",
            () -> new FlammableWoodLog(BlockBehaviour.Properties.of().copy(Blocks.OAK_LOG).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BROADLEAF_WOOD = registerBlock("broadleaf_wood",
            () -> new StrippableFlammableWoodLog(STRIPPED_BROADLEAF_WOOD, BlockBehaviour.Properties.of().copy(Blocks.OAK_LOG).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_BROADLEAF_LOG = registerBlock("stripped_broadleaf_log",
            () -> new FlammableWoodLog(BlockBehaviour.Properties.of().copy(Blocks.OAK_LOG).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BROADLEAF_LOG = registerBlock("broadleaf_log",
            () -> new StrippableFlammableWoodLog(STRIPPED_BROADLEAF_LOG, BlockBehaviour.Properties.of().copy(Blocks.OAK_LOG).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BROADLEAF_PLANKS = registerBlock("broadleaf_planks",
            () -> new FlammableBlock(BlockBehaviour.Properties.of().copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BROADLEAF_LEAVES = registerBlock("broadleaf_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).strength(0.2F)
                    .randomTicks().sound(SoundType.GRASS).noOcclusion().isSuffocating(ModBlocks::never).isViewBlocking(ModBlocks::never)
                    .ignitedByLava().pushReaction(PushReaction.DESTROY).isRedstoneConductor(ModBlocks::never)));
    public static final RegistryObject<Block> BROADLEAF_SAPLING = registerBlock("broadleaf_sapling",
            () -> new SaplingBlock(new BroadleafTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> BROADLEAF_STAIRS = registerBlock("broadleaf_stairs",
            () -> new StairBlock(() -> ModBlocks.BROADLEAF_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.of().copy(Blocks.OAK_STAIRS)));
    public static final RegistryObject<Block> BROADLEAF_SLAB = registerBlock("broadleaf_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().copy(Blocks.OAK_SLAB)));
    public static final RegistryObject<Block> BROADLEAF_DOOR = registerBlock("broadleaf_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of().copy(Blocks.OAK_DOOR).sound(SoundType.WOOD), BlockSetType.OAK));
    public static final RegistryObject<Block> BROADLEAF_TRAPDOOR = registerBlock("broadleaf_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of().copy(Blocks.OAK_TRAPDOOR).sound(SoundType.WOOD), BlockSetType.OAK));
    public static final RegistryObject<Block> BROADLEAF_PRESSURE_PLATE = registerBlock("broadleaf_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of().copy(Blocks.OAK_TRAPDOOR), BlockSetType.OAK));
    public static final RegistryObject<Block> BROADLEAF_BUTTON = registerBlock("broadleaf_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.of().copy(Blocks.OAK_TRAPDOOR), BlockSetType.OAK, 20, true));
    public static final RegistryObject<Block> BROADLEAF_FENCE = registerBlock("broadleaf_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().copy(Blocks.OAK_FENCE).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BROADLEAF_FENCE_GATE = registerBlock("broadleaf_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of().copy(Blocks.OAK_FENCE_GATE).sound(SoundType.WOOD), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));


    //Kyanite
    public static final RegistryObject<Block> KYANITE_ORE = registerBlock("kyanite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(2, 5)));
    public static final RegistryObject<Block> KYANITE_ORE_DEEPSLATE = registerBlock("kyanite_ore_deepslate",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> KYANITE_ORE_END = registerBlock("kyanite_ore_end",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(5, 8)));
    public static final RegistryObject<Block> KYANITE_ORE_NETHER = registerBlock("kyanite_ore_nether",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));
    public static final RegistryObject<Block> KYANITE_BLOCK = registerBlock("kyanite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RAW_KYANITE_BLOCK = registerBlock("raw_kyanite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK).requiresCorrectToolForDrops()));


    //Rudanium
    public static final RegistryObject<Block> RUDANIUM_ORE = registerBlock("rudanium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(3f, 3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RUDANIUM_ORE_DEEPSLATE = registerBlock("rudanium_ore_deepslate",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(3f, 3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RUDANIUM_ORE_END = registerBlock("rudanium_ore_end",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)
                    .strength(3f, 3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RUDANIUM_ORE_NETHER = registerBlock("rudanium_ore_nether",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK)
                    .strength(3f, 3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RUDANIUM_BLOCK = registerBlock("rudanium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RAW_RUDANIUM_BLOCK = registerBlock("raw_rudanium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK).requiresCorrectToolForDrops()));


    //Stations and Station parts
    public static final RegistryObject<Block> COBBLESTONE_CASE = registerBlock("cobblestone_case",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SEED_MAKER = registerBlock("seed_maker",
            () -> new SeedMakerBlock(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops()));


    //White Stone
    public static final RegistryObject<Block> WHITE_COBBLESTONE = registerBlock("white_cobblestone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> WHITE_STONE_BRICKS = registerBlock("white_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> WHITE_STONE = registerBlock("white_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> WHITE_COBBLESTONE_WALL = registerBlock("white_cobblestone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> WHITE_STONE_BRICK_WALL = registerBlock("white_stone_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> WHITE_STONE_WALL = registerBlock("white_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> WHITE_STONE_STAIRS = registerBlock("white_stone_stairs",
            () -> new StairBlock(() -> ModBlocks.WHITE_STONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.STONE_STAIRS)));
    public static final RegistryObject<Block> WHITE_STONE_SLAB = registerBlock("white_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_SLAB)));
    public static final RegistryObject<Block> WHITE_COBBLESTONE_STAIRS = registerBlock("white_cobblestone_stairs",
            () -> new StairBlock(() -> ModBlocks.WHITE_COBBLESTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.STONE_STAIRS)));
    public static final RegistryObject<Block> WHITE_COBBLESTONE_SLAB = registerBlock("white_cobblestone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_SLAB)));
    public static final RegistryObject<Block> WHITE_STONE_BRICK_STAIRS = registerBlock("white_stone_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.WHITE_STONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.STONE_STAIRS)));
    public static final RegistryObject<Block> WHITE_STONE_BRICK_SLAB = registerBlock("white_stone_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_SLAB)));
    //public static final RegistryObject<Block> WHITE_STONE_FURNACE = registerBlock("white_stone_furnace",
    //        () -> new WhiteStoneFurnaceBlock(BlockBehaviour.Properties.copy(Blocks.FURNACE).requiresCorrectToolForDrops()));


    //Starved Soul
    public static final RegistryObject<Block> SOUL_SEDIMENT = registerBlock("soul_sediment",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> STARVED_SOUL_SOIL = registerBlock("starved_soul_soil",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SOUL_SOIL)));
    public static final RegistryObject<Block> STARVED_SOUL_GRASS = registerBlock("starved_soul_grass",
            () -> new CustomPlacementBushBlock(ModTags.Blocks.SOUL_DIRT
                    , BlockBehaviour.Properties.copy(Blocks.GRASS).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> STARVED_SOUL_GRASS_BLOCK = registerBlock("starved_soul_grass_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SOUL_SOIL)));

    public static final RegistryObject<Block> STRIPPED_STARVED_STEM = registerBlock("stripped_starved_stem",
            () -> new FlammableWoodLog(BlockBehaviour.Properties.of().copy(Blocks.OAK_LOG).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_STARVED_HYPHAE = registerBlock("stripped_starved_hyphae",
            () -> new FlammableWoodLog(BlockBehaviour.Properties.of().copy(Blocks.OAK_LOG).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STARVED_STEM = registerBlock("starved_stem",
            () -> new StrippableFlammableWoodLog(STRIPPED_STARVED_STEM, BlockBehaviour.Properties.of().copy(Blocks.CRIMSON_STEM).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STARVED_HYPHAE = registerBlock("starved_hyphae",
            () -> new StrippableFlammableWoodLog(STRIPPED_STARVED_HYPHAE, BlockBehaviour.Properties.of().copy(Blocks.CRIMSON_HYPHAE).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STARVED_FUNGUS = registerBlock("starved_fungus",
            () -> new CustomPlacementNoGrowSaplingBlock(new StarvedTreeGrower(), ModTags.Blocks.SOUL_DIRT, BlockBehaviour.Properties.of().copy(Blocks.CRIMSON_FUNGUS)));
    public static final RegistryObject<Block> STARVED_SPORE = registerBlock("starved_spore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHER_WART_BLOCK)));
    public static final RegistryObject<Block> STARVED_PLANKS = registerBlock("starved_planks",
            () -> new FlammableBlock(BlockBehaviour.Properties.of().copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STARVED_STAIRS = registerBlock("starved_stairs",
            () -> new StairBlock(() -> ModBlocks.BROADLEAF_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.of().copy(Blocks.OAK_STAIRS)));
    public static final RegistryObject<Block> STARVED_SLAB = registerBlock("starved_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().copy(Blocks.OAK_SLAB)));
    public static final RegistryObject<Block> STARVED_DOOR = registerBlock("starved_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of().copy(Blocks.OAK_DOOR).sound(SoundType.WOOD), BlockSetType.OAK));
    public static final RegistryObject<Block> STARVED_TRAPDOOR = registerBlock("starved_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of().copy(Blocks.OAK_TRAPDOOR).sound(SoundType.WOOD), BlockSetType.OAK));
    public static final RegistryObject<Block> STARVED_PRESSURE_PLATE = registerBlock("starved_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of().copy(Blocks.OAK_TRAPDOOR), BlockSetType.OAK));
    public static final RegistryObject<Block> STARVED_BUTTON = registerBlock("starved_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.of().copy(Blocks.OAK_TRAPDOOR), BlockSetType.OAK, 20, true));
    public static final RegistryObject<Block> STARVED_FENCE = registerBlock("starved_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().copy(Blocks.OAK_FENCE).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STARVED_FENCE_GATE = registerBlock("starved_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of().copy(Blocks.OAK_FENCE_GATE).sound(SoundType.WOOD), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));


    //Murderous Soul
    public static final RegistryObject<Block> MURDEROUS_SOUL_SOIL = registerBlock("murderous_soul_soil",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SOUL_SOIL)));
    public static final RegistryObject<Block> MURDEROUS_SOUL_GRASS = registerBlock("murderous_soul_grass",
            () -> new CustomPlacementBushBlock(ModTags.Blocks.SOUL_DIRT
                    , BlockBehaviour.Properties.copy(Blocks.GRASS).requiresCorrectToolForDrops()));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    private static LeavesBlock leaves(SoundType pType) {
        return new LeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).strength(0.2F)
                .randomTicks().sound(pType).noOcclusion().isSuffocating(ModBlocks::never).isViewBlocking(ModBlocks::never)
                .ignitedByLava().pushReaction(PushReaction.DESTROY).isRedstoneConductor(ModBlocks::never));
    }

    private static boolean never(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return false;
    }
}
