package com.zepsun.aberrance.worldgen.tree;

import com.zepsun.aberrance.worldgen.ModConfiguredFeatures;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class StarvedTreeGrower extends AbstractTreeGrower {
    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource pRandom, boolean pHasFlowers) {
        if (pRandom.nextInt(10) == 0) {
            return ModConfiguredFeatures.STARVED_FUNGUS_KEY;
        } else {
            return ModConfiguredFeatures.FANCY_STARVED_FUNGUS_KEY;
        }
    }
}
