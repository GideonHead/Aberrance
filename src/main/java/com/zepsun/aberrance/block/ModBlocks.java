package com.zepsun.aberrance.block;

import com.zepsun.aberrance.Aberrance;
import com.zepsun.aberrance.block.custom.FlammableBlock;
import com.zepsun.aberrance.block.custom.FlammableWoodLog;
import com.zepsun.aberrance.block.custom.StrippableFlammableWoodLog;
import com.zepsun.aberrance.block.custom.crop.ModCropBlock;
import com.zepsun.aberrance.block.custom.station.SeedMakerBlock;
import com.zepsun.aberrance.item.ModItems;
import com.zepsun.aberrance.worldgen.tree.AcaciaMesquiteTreeGrower;
import com.zepsun.aberrance.worldgen.tree.CrepeMyrtleTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Aberrance.MOD_ID);


    //Parsnip
    public static final RegistryObject<Block> PARSNIP_CROP = BLOCKS.register("parsnip_crop",
            () -> new ModCropBlock(ModItems.PARSNIP_SEEDS::get, BlockBehaviour.Properties.copy(Blocks.WHEAT)));


    //Winter Wheat
    public static final RegistryObject<Block> WINTER_WHEAT_CROP = BLOCKS.register("winter_wheat_crop",
            () -> new ModCropBlock(ModItems.WINTER_WHEAT_SEEDS::get, BlockBehaviour.Properties.copy(Blocks.WHEAT)));


    //Onion
    public static final RegistryObject<Block> ONION_CROP = BLOCKS.register("onion_crop",
            () -> new ModCropBlock(ModItems.ONION::get, BlockBehaviour.Properties.copy(Blocks.WHEAT)));
    public static final RegistryObject<Block> WILD_ONION_PLANT = registerBlock("wild_onion_plant",
            () -> new FlowerBlock(() -> MobEffects.WITHER, 4, BlockBehaviour.Properties.copy(Blocks.ALLIUM)));


    //Mesquite
    public static final RegistryObject<Block> ACACIA_MESQUITE_LEAVES = registerBlock("acacia_mesquite_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).strength(0.2F)
                    .randomTicks().sound(SoundType.GRASS).noOcclusion().isSuffocating(ModBlocks::never).isViewBlocking(ModBlocks::never)
                    .ignitedByLava().pushReaction(PushReaction.DESTROY).isRedstoneConductor(ModBlocks::never)));
    public static final RegistryObject<Block> ACACIA_MESQUITE_SAPLING = registerBlock("acacia_mesquite_sapling",
            () -> new SaplingBlock(new AcaciaMesquiteTreeGrower(), BlockBehaviour.Properties.copy(Blocks.ACACIA_SAPLING).noLootTable()));


    //Crepe Myrtle
    public static final RegistryObject<Block> CREPE_MYRTLE_LEAVES = registerBlock("crepe_myrtle_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).strength(0.2F)
                    .randomTicks().sound(SoundType.GRASS).noOcclusion().isSuffocating(ModBlocks::never).isViewBlocking(ModBlocks::never)
                    .ignitedByLava().pushReaction(PushReaction.DESTROY).noLootTable().isRedstoneConductor(ModBlocks::never)));
    public static final RegistryObject<Block> CREPE_MYRTLE_SAPLING = registerBlock("crepe_myrtle_sapling",
            () -> new SaplingBlock(new CrepeMyrtleTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).noLootTable()));
    public static final RegistryObject<Block> STRIPPED_CREPE_MYRTLE_WOOD = registerBlock("stripped_crepe_myrtle_wood",
            () -> new FlammableWoodLog(BlockBehaviour.Properties.of().noLootTable().sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CREPE_MYRTLE_WOOD = registerBlock("crepe_myrtle_wood",
            () -> new StrippableFlammableWoodLog(STRIPPED_CREPE_MYRTLE_WOOD, BlockBehaviour.Properties.of().noLootTable().sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_CREPE_MYRTLE_LOG = registerBlock("stripped_crepe_myrtle_log",
            () -> new FlammableWoodLog(BlockBehaviour.Properties.of().noLootTable().sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CREPE_MYRTLE_LOG = registerBlock("crepe_myrtle_log",
            () -> new StrippableFlammableWoodLog(STRIPPED_CREPE_MYRTLE_LOG, BlockBehaviour.Properties.of().noLootTable().sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CREPE_MYRTLE_PLANKS = registerBlock("crepe_myrtle_planks",
            () -> new FlammableBlock(BlockBehaviour.Properties.of().noLootTable().sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CREPE_MYRTLE_COMPOST = registerBlock("crepe_myrtle_compost",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT).noLootTable().sound(SoundType.ROOTED_DIRT)));


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
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noLootTable()));
    public static final RegistryObject<Block> RAW_KYANITE_BLOCK = registerBlock("raw_kyanite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK).noLootTable()));


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
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noLootTable()));
    public static final RegistryObject<Block> RAW_RUDANIUM_BLOCK = registerBlock("raw_rudanium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK).noLootTable()));


    //Stations and Station parts
    public static final RegistryObject<Block> COBBLESTONE_CASE = registerBlock("cobblestone_case",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).noLootTable()));
    public static final RegistryObject<Block> SEED_MAKER = registerBlock("seed_maker",
            () -> new SeedMakerBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()));


    //White Stone
    public static final RegistryObject<Block> WHITE_COBBLESTONE = registerBlock("white_cobblestone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).noLootTable()));
    public static final RegistryObject<Block> WHITE_STONE_BRICKS = registerBlock("white_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS).noLootTable()));


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
