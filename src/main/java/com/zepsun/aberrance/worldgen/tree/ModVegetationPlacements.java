package com.zepsun.aberrance.worldgen.tree;

import com.google.common.collect.ImmutableList;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModVegetationPlacements {

    private static final PlacementModifier TREE_THRESHOLD = SurfaceWaterDepthFilter.forMaxDepth(0);

    public static List<PlacementModifier> bushPlacement(PlacementModifier pPlacement) {
        return treePlacementBase(pPlacement).build();
    }

    private static ImmutableList.Builder<PlacementModifier> treePlacementBase(PlacementModifier pPlacement) {
        return ImmutableList.<PlacementModifier>builder().add(pPlacement).add(InSquarePlacement.spread()).add(TREE_THRESHOLD).add(PlacementUtils.HEIGHTMAP_OCEAN_FLOOR).add(BiomeFilter.biome());
    }

}
