package com.zepsun.aberrance.worldgen;

import com.mojang.datafixers.kinds.Const;
import com.zepsun.aberrance.Aberrance;
import com.zepsun.aberrance.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.MegaJungleFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.BendingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;
import java.util.Random;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> ACACIA_MESQUITE_KEY = registerKey("acacia_mesquite");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CREPE_MYRTLE_KEY = registerKey("crepe_myrtle");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LIVE_OAK_KEY = registerKey("live_oak");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BROADLEAF_KEY = registerKey("broadleaf");

    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_KYANITE_ORE_KEY = registerKey("kyanite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_KYANITE_ORE_KEY = registerKey("nether_kyanite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_KYANITE_ORE_KEY = registerKey("end_kyanite_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_RUDANIUM_ORE_KEY = registerKey("rudanium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_RUDANIUM_ORE_KEY = registerKey("nether_rudanium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_RUDANIUM_ORE_KEY = registerKey("end_rudanium_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>>  WHITE_COBBLESTONE_KEY = registerKey("white_cobblestone");

    public static final ResourceKey<ConfiguredFeature<?, ?>>  WILD_ONION_PLANT_KEY = registerKey("wild_onion_plant");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {

        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endStoneReplaceables = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> overWorldKyaniteOres = List.of(OreConfiguration.target(stoneReplaceables,
                ModBlocks.KYANITE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.KYANITE_ORE_DEEPSLATE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overWorldRudaniumOres = List.of(OreConfiguration.target(stoneReplaceables,
                ModBlocks.RUDANIUM_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.RUDANIUM_ORE_DEEPSLATE.get().defaultBlockState()));

        register(context, ACACIA_MESQUITE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(Blocks.ACACIA_LOG),
                new FancyTrunkPlacer(3,11,0),
                BlockStateProvider.simple(ModBlocks.ACACIA_MESQUITE_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(2), 3),
                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, CREPE_MYRTLE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.CREPE_MYRTLE_LOG.get()),
                new StraightTrunkPlacer(2, 4, 1),
                BlockStateProvider.simple(ModBlocks.CREPE_MYRTLE_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 2),
                new TwoLayersFeatureSize(3, 0, 2)).build());

        register(context, LIVE_OAK_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.LIVE_OAK_LOG.get()),
                new FancyTrunkPlacer(3, 11, 0),
                BlockStateProvider.simple(ModBlocks.LIVE_OAK_LEAVES.get()),
                new FancyFoliagePlacer(ConstantInt.of(2),ConstantInt.of(4),4),
                new TwoLayersFeatureSize(3, 0, 2)).build());

        register(context, BROADLEAF_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.BROADLEAF_LOG.get()),
                new StraightTrunkPlacer(2, 4, 1),
                BlockStateProvider.simple(ModBlocks.BROADLEAF_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 2),
                new TwoLayersFeatureSize(3, 0, 2)).build());

        register(context, OVERWORLD_KYANITE_ORE_KEY, Feature.ORE, new OreConfiguration(overWorldKyaniteOres, 7));
        register(context, NETHER_KYANITE_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables,
                ModBlocks.KYANITE_ORE_NETHER.get().defaultBlockState(), 7));
        register(context, END_KYANITE_ORE_KEY, Feature.ORE, new OreConfiguration(endStoneReplaceables,
                ModBlocks.KYANITE_ORE_END.get().defaultBlockState(), 7));

        register(context, OVERWORLD_RUDANIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overWorldRudaniumOres, 9));
        register(context, NETHER_RUDANIUM_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables,
                ModBlocks.RUDANIUM_ORE_NETHER.get().defaultBlockState(), 9));
        register(context, END_RUDANIUM_ORE_KEY, Feature.ORE, new OreConfiguration(endStoneReplaceables,
                ModBlocks.RUDANIUM_ORE_END.get().defaultBlockState(), 9));

        register(context, WHITE_COBBLESTONE_KEY, Feature.ORE, new OreConfiguration(stoneReplaceables,
                ModBlocks.WHITE_COBBLESTONE.get().defaultBlockState(), 64));

        register(context, WILD_ONION_PLANT_KEY, Feature.FLOWER,
                new RandomPatchConfiguration(32, 6,2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.WILD_ONION_PLANT.get())))));
    }



    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Aberrance.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
