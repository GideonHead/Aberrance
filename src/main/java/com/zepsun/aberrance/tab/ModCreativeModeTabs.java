package com.zepsun.aberrance.tab;

import com.zepsun.aberrance.Aberrance;
import com.zepsun.aberrance.block.ModBlocks;
import com.zepsun.aberrance.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Aberrance.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ABERRANCE = CREATIVE_MODE_TABS.register("aberrance_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.PARSNIP.get()))
                    .title(Component.translatable("creativetab.aberrance")).displayItems((displayParameters, output) -> {

                        output.accept(ModItems.PARSNIP.get());
                        output.accept(ModItems.PARSNIP_SEEDS.get());

                        output.accept(ModItems.WINTER_WHEAT.get());
                        output.accept(ModItems.WINTER_WHEAT_SEEDS.get());
                        output.accept(ModItems.WINTER_WHEAT_BREAD.get());

                        output.accept(ModItems.ONION.get());
                        output.accept(ModBlocks.WILD_ONION_PLANT.get());

                        output.accept(ModBlocks.SEED_MAKER.get());
                        output.accept(ModBlocks.COBBLESTONE_CASE.get());

                        output.accept(ModBlocks.ACACIA_MESQUITE_LEAVES.get());
                        output.accept(ModBlocks.ACACIA_MESQUITE_SAPLING.get());
                        output.accept(ModItems.MESQUITE.get());

                        output.accept(ModItems.KYANITE_INGOT.get());
                        output.accept(ModItems.KYANITE_NUGGET.get());
                        output.accept(ModItems.RAW_KYANITE.get());
                        output.accept(ModItems.KYANITE_AXE.get());
                        output.accept(ModItems.KYANITE_HOE.get());
                        output.accept(ModItems.KYANITE_SWORD.get());
                        output.accept(ModItems.KYANITE_PICKAXE.get());
                        output.accept(ModItems.KYANITE_SHOVEL.get());
                        output.accept(ModItems.KYANITE_HELMET.get());
                        output.accept(ModItems.KYANITE_CHESTPLATE.get());
                        output.accept(ModItems.KYANITE_LEGGINGS.get());
                        output.accept(ModItems.KYANITE_BOOTS.get());
                        output.accept(ModBlocks.KYANITE_ORE.get());
                        output.accept(ModBlocks.KYANITE_ORE_DEEPSLATE.get());
                        output.accept(ModBlocks.KYANITE_ORE_END.get());
                        output.accept(ModBlocks.KYANITE_ORE_NETHER.get());
                        output.accept(ModBlocks.KYANITE_BLOCK.get());
                        output.accept(ModBlocks.RAW_KYANITE_BLOCK.get());

                        output.accept(ModItems.RUDANIUM_INGOT.get());
                        output.accept(ModItems.RUDANIUM_NUGGET.get());
                        output.accept(ModItems.RAW_RUDANIUM.get());
                        output.accept(ModItems.RUDANIUM_AXE.get());
                        output.accept(ModItems.RUDANIUM_HOE.get());
                        output.accept(ModItems.RUDANIUM_SWORD.get());
                        output.accept(ModItems.RUDANIUM_PICKAXE.get());
                        output.accept(ModItems.RUDANIUM_SHOVEL.get());
                        output.accept(ModItems.RUDANIUM_HELMET.get());
                        output.accept(ModItems.RUDANIUM_CHESTPLATE.get());
                        output.accept(ModItems.RUDANIUM_LEGGINGS.get());
                        output.accept(ModItems.RUDANIUM_BOOTS.get());
                        output.accept(ModBlocks.RUDANIUM_ORE.get());
                        output.accept(ModBlocks.RUDANIUM_ORE_DEEPSLATE.get());
                        output.accept(ModBlocks.RUDANIUM_ORE_END.get());
                        output.accept(ModBlocks.RUDANIUM_ORE_NETHER.get());
                        output.accept(ModBlocks.RUDANIUM_BLOCK.get());
                        output.accept(ModBlocks.RAW_RUDANIUM_BLOCK.get());

                        output.accept(ModBlocks.CREPE_MYRTLE_LEAVES.get());
                        output.accept(ModBlocks.CREPE_MYRTLE_LOG.get());
                        output.accept(ModBlocks.CREPE_MYRTLE_PLANKS.get());
                        output.accept(ModBlocks.CREPE_MYRTLE_WOOD.get());
                        output.accept(ModBlocks.CREPE_MYRTLE_SAPLING.get());
                        output.accept(ModBlocks.STRIPPED_CREPE_MYRTLE_LOG.get());
                        output.accept(ModBlocks.STRIPPED_CREPE_MYRTLE_WOOD.get());
                        output.accept(ModBlocks.CREPE_MYRTLE_COMPOST.get());

                        output.accept(ModBlocks.WHITE_COBBLESTONE.get());
                        output.accept(ModBlocks.WHITE_STONE_BRICKS.get());

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
