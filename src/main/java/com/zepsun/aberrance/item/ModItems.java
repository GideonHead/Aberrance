package com.zepsun.aberrance.item;

import com.zepsun.aberrance.Aberrance;
import com.zepsun.aberrance.block.ModBlocks;
import com.zepsun.aberrance.tiers.ModTiers;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Aberrance.MOD_ID);


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


    //Onion
    public static final RegistryObject<Item> ONION = ITEMS.register("onion",
            () -> new ItemNameBlockItem(ModBlocks.ONION_CROP.get(), new Item.Properties().food(ModFoodProperties.PARSNIP)));


    //Mesquite
    public static final RegistryObject<Item> MESQUITE = ITEMS.register("mesquite",
            () -> new Item(new Item.Properties().food(Foods.SWEET_BERRIES)));


    //Kyanite
    public static final RegistryObject<Item> KYANITE_INGOT = ITEMS.register("kyanite_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> KYANITE_NUGGET = ITEMS.register("kyanite_nugget",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_KYANITE = ITEMS.register("raw_kyanite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> KYANITE_PICKAXE = ITEMS.register("kyanite_pickaxe",
            () -> new PickaxeItem(ModTiers.KYANITE, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> KYANITE_SHOVEL = ITEMS.register("kyanite_shovel",
            () -> new ShovelItem(ModTiers.KYANITE, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> KYANITE_AXE = ITEMS.register("kyanite_axe",
            () -> new AxeItem(ModTiers.KYANITE, 5, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> KYANITE_HOE = ITEMS.register("kyanite_hoe",
            () -> new HoeItem(ModTiers.KYANITE, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> KYANITE_SWORD = ITEMS.register("kyanite_sword",
            () -> new SwordItem(ModTiers.KYANITE, 4, -2.8F, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
