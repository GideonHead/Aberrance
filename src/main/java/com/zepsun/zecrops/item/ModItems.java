package com.zepsun.zecrops.item;

import com.zepsun.zecrops.ZECrops;
import com.zepsun.zecrops.block.ModBlocks;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ZECrops.MOD_ID);

    //Parsnip
    public static final RegistryObject<Item> PARSNIP = ITEMS.register("parsnip",
            () -> new Item(new Item.Properties().food(ModFoodProperties.PARSNIP)));
    public static final RegistryObject<Item> PARSNIP_SEEDS = ITEMS.register("parsnip_seeds",
            () -> new ItemNameBlockItem(ModBlocks.PARSNIP_CROP.get(), new Item.Properties()));

    //Winter Wheat
    public static final RegistryObject<Item> WINTER_WHEAT = ITEMS.register("winter_wheat",
            () -> new Item(new Item.Properties().food(ModFoodProperties.PARSNIP)));
    public static final RegistryObject<Item> WINTER_WHEAT_SEEDS = ITEMS.register("winter_wheat_seeds",
            () -> new ItemNameBlockItem(ModBlocks.WINTER_WHEAT_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> WINTER_WHEAT_BREAD = ITEMS.register("winter_wheat_bread",
            () -> new Item(new Item.Properties().food(Foods.BREAD)));

    //Mesquite


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
