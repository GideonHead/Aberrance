package com.zepsun.zecrops.event;

import com.zepsun.zecrops.ZECrops;
import com.zepsun.zecrops.item.ModItems;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = ZECrops.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {
    @SubscribeEvent
    public static void AddCustomTrades(VillagerTradesEvent event) {
        if(event.getType() == VillagerProfession.FARMER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack parsnip_seeds_stack = new ItemStack(ModItems.PARSNIP_SEEDS.get(), 6);
            ItemStack winter_wheat_seeds_stack = new ItemStack(ModItems.PARSNIP_SEEDS.get(), 6);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.WHEAT_SEEDS, 6), parsnip_seeds_stack, 10, 2, 0.02f
            ));
            trades.get(villagerLevel).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.WHEAT_SEEDS, 6), winter_wheat_seeds_stack, 10, 2, 0.02f
            ));

        }
    }


    @SubscribeEvent
    public static void addCustomWanderingTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> trades = event.getGenericTrades();
        ItemStack parsnip_seeds_stack = new ItemStack(ModItems.PARSNIP_SEEDS.get(), 6);
        ItemStack winter_wheat_seeds_stack = new ItemStack(ModItems.PARSNIP_SEEDS.get(), 6);

        trades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.WHEAT_SEEDS, 6), parsnip_seeds_stack, 10, 2, 0.02f
        ));
        trades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.WHEAT_SEEDS, 6), winter_wheat_seeds_stack, 10, 2, 0.02f
        ));
    }
}