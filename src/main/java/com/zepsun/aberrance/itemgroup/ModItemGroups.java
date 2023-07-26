package com.zepsun.aberrance.itemgroup;

import com.zepsun.aberrance.item.ModItems;
import net.minecraft.world.item.Items;

public class ModItemGroups {

    public static final ArmorToolsGroup KYANITE_ARMOR_TOOLS_GROUP = new ArmorToolsGroup(
            ModItems.KYANITE_INGOT.get(),
            ModItems.KYANITE_SWORD.get(),
            ModItems.KYANITE_PICKAXE.get(),
            ModItems.KYANITE_SHOVEL.get(),
            ModItems.KYANITE_AXE.get(),
            ModItems.KYANITE_HOE.get(),
            ModItems.KYANITE_HELMET.get(),
            ModItems.KYANITE_CHESTPLATE.get(),
            ModItems.KYANITE_LEGGINGS.get(),
            ModItems.KYANITE_BOOTS.get()
    );

    public static final ArmorToolsGroup IRON_ARMOR_TOOLS_GROUP = new ArmorToolsGroup(
            Items.IRON_INGOT,
            Items.IRON_SWORD,
            Items.IRON_PICKAXE,
            Items.IRON_SHOVEL,
            Items.IRON_AXE,
            Items.IRON_HOE,
            Items.IRON_HELMET,
            Items.IRON_CHESTPLATE,
            Items.IRON_LEGGINGS,
            Items.IRON_BOOTS
    );

    public static final ArmorToolsGroup NETHERITE_ARMOR_TOOLS_GROUP = new ArmorToolsGroup(
            Items.NETHERITE_INGOT,
            Items.NETHERITE_SWORD,
            Items.NETHERITE_PICKAXE,
            Items.NETHERITE_SHOVEL,
            Items.NETHERITE_AXE,
            Items.NETHERITE_HOE,
            Items.NETHERITE_HELMET,
            Items.NETHERITE_CHESTPLATE,
            Items.NETHERITE_LEGGINGS,
            Items.NETHERITE_BOOTS
    );

}
