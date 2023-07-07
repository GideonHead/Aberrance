package com.zepsun.zecrops.tab;

import com.zepsun.zecrops.ZECrops;
import com.zepsun.zecrops.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ZECrops.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ZEPS_EXTRA_CROPS = CREATIVE_MODE_TABS.register("zeps_extra_crops",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.PARSNIP.get()))
                    .title(Component.translatable("creativetab.zecrops_tab")).displayItems((displayParameters, output) -> {

                        output.accept(ModItems.PARSNIP.get());
                        output.accept(ModItems.PARSNIP_SEEDS.get());

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
