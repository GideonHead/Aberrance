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
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> ACACIA_MESQUITE_PLACED_KEY = registerKey("acacia_mesquite_placed");
    public static final ResourceKey<PlacedFeature> CREPE_MYRTLE_PLACED_KEY = registerKey("crepe_myrtle_placed");
    public static final ResourceKey<PlacedFeature> CREPE_MYRTLE_EXTRA_PLACED_KEY = registerKey("crepe_myrtle_extra_placed");
    public static final ResourceKey<PlacedFeature> BROADLEAF_PLACED_KEY = registerKey("broadleaf_placed");
    public static final ResourceKey<PlacedFeature> BROADLEAF_EXTRA_PLACED_KEY = registerKey("broadleaf_extra_placed");
    public static final ResourceKey<PlacedFeature> PALM_PLACED_KEY = registerKey("palm_placed");
    public static final ResourceKey<PlacedFeature> PALM_EXTRA_PLACED_KEY = registerKey("palm_extra_placed");
    public static final ResourceKey<PlacedFeature> LIVE_OAK_PLACED_KEY = registerKey("live_oak_placed");
    public static final ResourceKey<PlacedFeature> LIVE_OAK_RARE_PLACED_KEY = registerKey("live_oak_rare_placed");
    public static final ResourceKey<PlacedFeature> FANCY_LIVE_OAK_PLACED_KEY = registerKey("fancy_live_oak_placed");

    public static final ResourceKey<PlacedFeature> KYANITE_ORE_PLACED_KEY = registerKey("kyanite_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_KYANITE_ORE_PLACED_KEY = registerKey("nether_kyanite_ore_placed");
    public static final ResourceKey<PlacedFeature> END_KYANITE_ORE_PLACED_KEY = registerKey("end_kyanite_ore_placed");

    public static final ResourceKey<PlacedFeature> RUDANIUM_ORE_PLACED_KEY = registerKey("rudanium_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_RUDANIUM_ORE_PLACED_KEY = registerKey("nether_rudanium_ore_placed");
    public static final ResourceKey<PlacedFeature> END_RUDANIUM_ORE_PLACED_KEY = registerKey("end_rudanium_ore_placed");

    public static final ResourceKey<PlacedFeature> WHITE_STONE_PLACED_KEY = registerKey("white_stone_placed");

    public static final ResourceKey<PlacedFeature> WILD_ONION_PLANT_PLACED_KEY = registerKey("wild_onion_plant_placed");
    public static final ResourceKey<PlacedFeature> WILD_PARSNIP_PLANT_PLACED_KEY = registerKey("wild_parsnip_plant_placed_key");
    public static final ResourceKey<PlacedFeature> WILD_WINTER_WHEAT_PLANT_PLACED_KEY = registerKey("wild_winter_wheat_placed_key");

    public static final ResourceKey<PlacedFeature> MURDEROUS_SOUL_GRASS_PLACED_KEY = registerKey("murderous_soul_grass_placed");

    public static final ResourceKey<PlacedFeature> STARVED_SOUL_GRASS_PLACED_KEY = registerKey("starved_soul_grass_placed");
    public static final ResourceKey<PlacedFeature> EXTRA_STARVED_SOUL_GRASS_PLACED_KEY = registerKey("extra_starved_soul_grass_placed");

    public static final ResourceKey<PlacedFeature> STARVED_FUNGUS_PLACED_KEY = registerKey("starved_stem_fungus");
    public static final ResourceKey<PlacedFeature> FANCY_STARVED_FUNGUS_PLACED_KEY = registerKey("fancy_starved_fungus_placed");
    public static final ResourceKey<PlacedFeature> VERY_FANCY_STARVED_FUNGUS_PLACED_KEY = registerKey("very_fancy_starved_fungus_placed");
    public static final ResourceKey<PlacedFeature> EXTRA_STARVED_FUNGUS_PLACED_KEY = registerKey("extra_starved_fungus_placed");
    public static final ResourceKey<PlacedFeature> EXTRA_FANCY_STARVED_FUNGUS_PLACED_KEY = registerKey("extra_fancy_starved_fungus_placed");
    public static final ResourceKey<PlacedFeature> EXTRA_VERY_FANCY_STARVED_FUNGUS_PLACED_KEY = registerKey("extra_very_fancy_starved_fungus_placed");

    public static final ResourceKey<PlacedFeature> STARVED_FUNGUS_PLANT_PLACED_KEY = registerKey("starved_fungus_plant_placed");
    public static final ResourceKey<PlacedFeature> EXTRA_STARVED_FUNGUS_PLANT_PLACED_KEY = registerKey("extra_starved_fungus_plant_placed");


    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, ACACIA_MESQUITE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ACACIA_MESQUITE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1/2, 0.1f, 2),
                        ModBlocks.ACACIA_MESQUITE_SAPLING.get()));

        register(context, CREPE_MYRTLE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CREPE_MYRTLE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1/2, 0.1f, 2),
                        ModBlocks.CREPE_MYRTLE_SAPLING.get()));

        register(context, CREPE_MYRTLE_EXTRA_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CREPE_MYRTLE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(12, 0.1f, 2),
                        ModBlocks.CREPE_MYRTLE_SAPLING.get()));

        register(context, PALM_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PALM_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1/2, 0.1f, 2),
                        ModBlocks.PALM_SAPLING.get()));
        register(context, PALM_EXTRA_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PALM_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(6, 0.1f, 2),
                        ModBlocks.PALM_SAPLING.get()));

        register(context, LIVE_OAK_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LIVE_OAK_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1f, 2),
                        ModBlocks.LIVE_OAK_SAPLING.get()));
        register(context, FANCY_LIVE_OAK_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.FANCY_LIVE_OAK_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1/3, 0.1f, 2),
                        ModBlocks.LIVE_OAK_SAPLING.get()));
        register(context, LIVE_OAK_RARE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LIVE_OAK_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1/2, 0.1f, 2),
                        ModBlocks.LIVE_OAK_SAPLING.get()));

        register(context, BROADLEAF_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BROADLEAF_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(2, 0.1f, 2),
                        ModBlocks.BROADLEAF_SAPLING.get()));

        register(context, BROADLEAF_EXTRA_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BROADLEAF_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(12, 0.1f, 2),
                        ModBlocks.BROADLEAF_SAPLING.get()));

        register(context, KYANITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_KYANITE_ORE_KEY),
                WorldGenUtil.commonOrePlacement(1, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(0))));
        register(context, NETHER_KYANITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_KYANITE_ORE_KEY),
                WorldGenUtil.commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(64))));
        register(context, END_KYANITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_KYANITE_ORE_KEY),
                WorldGenUtil.commonOrePlacement(8, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(120))));

        register(context, RUDANIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_RUDANIUM_ORE_KEY),
                WorldGenUtil.commonOrePlacement(9, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(120))));
        register(context, NETHER_RUDANIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_RUDANIUM_ORE_KEY),
                WorldGenUtil.commonOrePlacement(8, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(120))));
        register(context, END_RUDANIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_RUDANIUM_ORE_KEY),
                WorldGenUtil.commonOrePlacement(12, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(120))));

        register(context, WHITE_STONE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.WHITE_STONE_KEY),
                WorldGenUtil.commonOrePlacement(6, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(120))));

        register(context, WILD_ONION_PLANT_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.WILD_ONION_PLANT_KEY),
                List.of(RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
        register(context, WILD_PARSNIP_PLANT_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.WILD_PARSNIP_PLANT_KEY),
                List.of(RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
        register(context, WILD_WINTER_WHEAT_PLANT_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.WILD_WINTER_WHEAT_PLANT_KEY),
                List.of(RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

        register(context, MURDEROUS_SOUL_GRASS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MURDEROUS_SOUL_GRASS_KEY),
                List.of(RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
        register(context, STARVED_SOUL_GRASS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.STARVED_SOUL_GRASS_KEY),
                List.of(RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
        register(context, EXTRA_STARVED_SOUL_GRASS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.STARVED_SOUL_GRASS_KEY),
                List.of(RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

        register(context, STARVED_FUNGUS_PLANT_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.STARVED_FUNGUS_PLANT_KEY),
                List.of(RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
        register(context, EXTRA_STARVED_FUNGUS_PLANT_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.STARVED_FUNGUS_PLANT_KEY),
                List.of(RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

        register(context, STARVED_FUNGUS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.STARVED_FUNGUS_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1/2, 0.1f, 2),
                        ModBlocks.STARVED_FUNGUS.get()));
        register(context, EXTRA_STARVED_FUNGUS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.STARVED_FUNGUS_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(16, 0.1f, 2),
                        ModBlocks.STARVED_FUNGUS.get()));
        register(context, FANCY_STARVED_FUNGUS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.FANCY_STARVED_FUNGUS_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1/2, 0.1f, 2),
                        ModBlocks.STARVED_FUNGUS.get()));
        register(context, EXTRA_FANCY_STARVED_FUNGUS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.FANCY_STARVED_FUNGUS_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(8, 0.1f, 2),
                        ModBlocks.STARVED_FUNGUS.get()));
        register(context, VERY_FANCY_STARVED_FUNGUS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.VERY_FANCY_STARVED_FUNGUS_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1/2, 0.1f, 2),
                        ModBlocks.STARVED_FUNGUS.get()));
        register(context, EXTRA_VERY_FANCY_STARVED_FUNGUS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.VERY_FANCY_STARVED_FUNGUS_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(4, 0.1f, 2),
                        ModBlocks.STARVED_FUNGUS.get()));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Aberrance.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
