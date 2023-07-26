package com.zepsun.aberrance.worldgen;

import com.zepsun.aberrance.Aberrance;
import com.zepsun.aberrance.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> ACACIA_MESQUITE_PLACED_KEY = registerKey("acacia_mesquite_placed");
    public static final ResourceKey<PlacedFeature> CREPE_MYRTLE_PLACED_KEY = registerKey("crepe_myrtle_placed");

    public static final ResourceKey<PlacedFeature> KYANITE_ORE_PLACED_KEY = registerKey("kyanite_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_KYANITE_ORE_PLACED_KEY = registerKey("nether_kyanite_ore_placed");
    public static final ResourceKey<PlacedFeature> END_KYANITE_ORE_PLACED_KEY = registerKey("end_kyanite_ore_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, ACACIA_MESQUITE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ACACIA_MESQUITE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1/2, 0.1f, 2),
                        ModBlocks.ACACIA_MESQUITE_SAPLING.get()));

        register(context, CREPE_MYRTLE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CREPE_MYRTLE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1/2, 0.1f, 2),
                        ModBlocks.CREPE_MYRTLE_SAPLING.get()));

        register(context, KYANITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_KYANITE_ORE_KEY),
                WorldGenUtil.commonOrePlacement(1, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(0))));
        register(context, NETHER_KYANITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_KYANITE_ORE_KEY),
                WorldGenUtil.commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(64))));
        register(context, END_KYANITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_KYANITE_ORE_KEY),
                WorldGenUtil.commonOrePlacement(8, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(120))));
    }




    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Aberrance.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
