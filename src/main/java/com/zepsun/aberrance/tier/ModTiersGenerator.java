package com.zepsun.aberrance.tier;

import com.zepsun.aberrance.Aberrance;
import com.zepsun.aberrance.item.ModItems;
import com.zepsun.aberrance.tag.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModTiersGenerator {

    public static final Tier KYANITE = TierSortingRegistry.registerTier(
            new ForgeTier(5, 3031, 12.0f, 4.7f, 36,
                    ModTags.Blocks.NEEDS_KYANITE_TOOL, () -> Ingredient.of(ModItems.KYANITE_INGOT.get())),
            new ResourceLocation(Aberrance.MOD_ID, "kyanite"), List.of(Tiers.NETHERITE), List.of());

    public static final Tier RUDANIUM = TierSortingRegistry.registerTier(
            new ForgeTier(2, 375, 8.0f, 2.7f, 19,
                    ModTags.Blocks.NEEDS_KYANITE_TOOL, () -> Ingredient.of(ModItems.KYANITE_INGOT.get())),
            new ResourceLocation(Aberrance.MOD_ID, "rudanium"), List.of(Tiers.NETHERITE), List.of());

}
