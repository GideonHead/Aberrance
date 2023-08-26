package com.zepsun.aberrance.itemgroup;

import com.zepsun.aberrance.block.ModBlocks;
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

    public static final ArmorToolsGroup RUDANIUM_ARMOR_TOOLS_GROUP = new ArmorToolsGroup(
            ModItems.RUDANIUM_INGOT.get(),
            ModItems.RUDANIUM_SWORD.get(),
            ModItems.RUDANIUM_PICKAXE.get(),
            ModItems.RUDANIUM_SHOVEL.get(),
            ModItems.RUDANIUM_AXE.get(),
            ModItems.RUDANIUM_HOE.get(),
            ModItems.RUDANIUM_HELMET.get(),
            ModItems.RUDANIUM_CHESTPLATE.get(),
            ModItems.RUDANIUM_LEGGINGS.get(),
            ModItems.RUDANIUM_BOOTS.get()
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

    public static final TreeGroup CREPE_MYRTLE_TREE_GROUP = new TreeGroup(
            ModBlocks.CREPE_MYRTLE_LOG.get(),
            ModBlocks.CREPE_MYRTLE_WOOD.get(),
            ModBlocks.STRIPPED_CREPE_MYRTLE_LOG.get(),
            ModBlocks.STRIPPED_CREPE_MYRTLE_WOOD.get(),
            ModBlocks.CREPE_MYRTLE_PLANKS.get(),
            ModBlocks.CREPE_MYRTLE_LEAVES.get(),
            ModBlocks.CREPE_MYRTLE_SAPLING.get(),
            ModBlocks.CREPE_MYRTLE_DOOR.get(),
            ModBlocks.CREPE_MYRTLE_TRAPDOOR.get(),
            ModBlocks.CREPE_MYRTLE_BUTTON.get(),
            ModBlocks.CREPE_MYRTLE_PRESSURE_PLATE.get(),
            ModBlocks.CREPE_MYRTLE_FENCE.get(),
            ModBlocks.CREPE_MYRTLE_FENCE_GATE.get(),
            ModBlocks.CREPE_MYRTLE_SLAB.get(),
            ModBlocks.CREPE_MYRTLE_STAIRS.get()
    );

    public static final TreeGroup LIVE_OAK_TREE_GROUP = new TreeGroup(
            ModBlocks.LIVE_OAK_LOG.get(),
            ModBlocks.LIVE_OAK_WOOD.get(),
            ModBlocks.STRIPPED_LIVE_OAK_LOG.get(),
            ModBlocks.STRIPPED_LIVE_OAK_WOOD.get(),
            ModBlocks.LIVE_OAK_PLANKS.get(),
            ModBlocks.LIVE_OAK_LEAVES.get(),
            ModBlocks.LIVE_OAK_SAPLING.get(),
            ModBlocks.LIVE_OAK_DOOR.get(),
            ModBlocks.LIVE_OAK_TRAPDOOR.get(),
            ModBlocks.LIVE_OAK_BUTTON.get(),
            ModBlocks.LIVE_OAK_PRESSURE_PLATE.get(),
            ModBlocks.LIVE_OAK_FENCE.get(),
            ModBlocks.LIVE_OAK_FENCE_GATE.get(),
            ModBlocks.LIVE_OAK_SLAB.get(),
            ModBlocks.LIVE_OAK_STAIRS.get()
    );

    public static final TreeGroup BROADLEAF_TREE_GROUP = new TreeGroup(
            ModBlocks.BROADLEAF_LOG.get(),
            ModBlocks.BROADLEAF_WOOD.get(),
            ModBlocks.STRIPPED_BROADLEAF_LOG.get(),
            ModBlocks.STRIPPED_BROADLEAF_WOOD.get(),
            ModBlocks.BROADLEAF_PLANKS.get(),
            ModBlocks.BROADLEAF_LEAVES.get(),
            ModBlocks.BROADLEAF_SAPLING.get(),
            ModBlocks.BROADLEAF_DOOR.get(),
            ModBlocks.BROADLEAF_TRAPDOOR.get(),
            ModBlocks.BROADLEAF_BUTTON.get(),
            ModBlocks.BROADLEAF_PRESSURE_PLATE.get(),
            ModBlocks.BROADLEAF_FENCE.get(),
            ModBlocks.BROADLEAF_FENCE_GATE.get(),
            ModBlocks.BROADLEAF_SLAB.get(),
            ModBlocks.BROADLEAF_STAIRS.get()
    );

    public static final TreeGroup PALM_TREE_GROUP = new TreeGroup(
            ModBlocks.PALM_LOG.get(),
            ModBlocks.PALM_WOOD.get(),
            ModBlocks.STRIPPED_PALM_LOG.get(),
            ModBlocks.STRIPPED_PALM_WOOD.get(),
            ModBlocks.PALM_PLANKS.get(),
            ModBlocks.PALM_LEAVES.get(),
            ModBlocks.PALM_SAPLING.get(),
            ModBlocks.PALM_DOOR.get(),
            ModBlocks.PALM_TRAPDOOR.get(),
            ModBlocks.PALM_BUTTON.get(),
            ModBlocks.PALM_PRESSURE_PLATE.get(),
            ModBlocks.PALM_FENCE.get(),
            ModBlocks.PALM_FENCE_GATE.get(),
            ModBlocks.PALM_SLAB.get(),
            ModBlocks.PALM_STAIRS.get()
    );

    public static final TreeGroup STARVED_TREE_GROUP = new TreeGroup(
            ModBlocks.STARVED_STEM.get(),
            ModBlocks.STARVED_HYPHAE.get(),
            ModBlocks.STRIPPED_STARVED_STEM.get(),
            ModBlocks.STRIPPED_STARVED_HYPHAE.get(),
            ModBlocks.STARVED_PLANKS.get(),
            ModBlocks.STARVED_SPORE.get(),
            ModBlocks.STARVED_FUNGUS.get(),
            ModBlocks.STARVED_DOOR.get(),
            ModBlocks.STARVED_TRAPDOOR.get(),
            ModBlocks.STARVED_BUTTON.get(),
            ModBlocks.STARVED_PRESSURE_PLATE.get(),
            ModBlocks.STARVED_FENCE.get(),
            ModBlocks.STARVED_FENCE_GATE.get(),
            ModBlocks.STARVED_SLAB.get(),
            ModBlocks.STARVED_STAIRS.get()
    );

    public static final TreeGroup ACACIA_MESQUITE_TREE_GROUP = new TreeGroup(
            null,
            null,
            null,
            null,
            null,
            ModBlocks.ACACIA_MESQUITE_LEAVES.get(),
            ModBlocks.ACACIA_MESQUITE_SAPLING.get(),
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null
    );

}
