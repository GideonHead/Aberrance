package com.zepsun.zecrops.block;

import com.zepsun.zecrops.ZECrops;
import com.zepsun.zecrops.block.crop.ModCropBlock;
import com.zepsun.zecrops.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SoundType;
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
            DeferredRegister.create(ForgeRegistries.BLOCKS, ZECrops.MOD_ID);
    //Parsnip
    public static final RegistryObject<Block> PARSNIP_CROP = BLOCKS.register("parsnip_crop",
            () -> new ModCropBlock(ModItems.PARSNIP_SEEDS::get, BlockBehaviour.Properties.copy(Blocks.WHEAT)));

    //Winter Wheat
    public static final RegistryObject<Block> WINTER_WHEAT_CROP = BLOCKS.register("winter_wheat_crop",
            () -> new ModCropBlock(ModItems.WINTER_WHEAT_SEEDS::get, BlockBehaviour.Properties.copy(Blocks.WHEAT)));

    //Mesquite
    public static final RegistryObject<Block> ACACIA_MESQUITE_LEAVES = registerBlock("acacia_mesquite_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.of().noLootTable().mapColor(MapColor.PLANT).strength(0.2F)
                    .randomTicks().sound(SoundType.GRASS).noOcclusion().isSuffocating(ModBlocks::never).isViewBlocking(ModBlocks::never)
                    .ignitedByLava().pushReaction(PushReaction.DESTROY).isRedstoneConductor(ModBlocks::never)));

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