package com.zepsun.aberrance.block.entity;

import com.zepsun.aberrance.Aberrance;
import com.zepsun.aberrance.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Aberrance.MOD_ID);

    public static final RegistryObject<BlockEntityType<SeedMakerBlockEntity>> SEED_MAKER_BE =
            BLOCK_ENTITIES.register("seed_maker_block_entity", () ->
                    BlockEntityType.Builder.of(SeedMakerBlockEntity::new,
                            ModBlocks.SEED_MAKER.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
