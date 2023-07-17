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

    public static final RegistryObject<CreativeModeTab> ZEPS_EXTRA_CROPS = CREATIVE_MODE_TABS.register("zeps_extra_crops",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.PARSNIP.get()))
                    .title(Component.translatable("creativetab.zecrops_tab")).displayItems((displayParameters, output) -> {

                        output.accept(ModItems.PARSNIP.get());
                        output.accept(ModItems.PARSNIP_SEEDS.get());

                        output.accept(ModItems.WINTER_WHEAT.get());
                        output.accept(ModItems.WINTER_WHEAT_SEEDS.get());
                        output.accept(ModItems.WINTER_WHEAT_BREAD.get());

                        output.accept(ModItems.ONION.get());

                        output.accept(ModBlocks.ACACIA_MESQUITE_LEAVES.get());
                        output.accept(ModBlocks.ACACIA_MESQUITE_SAPLING.get());
                        output.accept(ModItems.MESQUITE.get());

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
