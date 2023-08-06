package com.zepsun.aberrance.worldgen.biome.surface;

import com.zepsun.aberrance.block.ModBlocks;
import com.zepsun.aberrance.worldgen.biome.ModBiomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import org.stringtemplate.v4.ST;

import static net.minecraft.world.level.levelgen.SurfaceRules.abovePreliminarySurface;
import static net.minecraft.world.level.levelgen.SurfaceRules.stoneDepthCheck;

public class ModSurfaceRules {
    public static final SurfaceRules.ConditionSource NEW_DEFAULT_BLOCK = stoneDepthCheck(0, true, 1000, CaveSurface.FLOOR);

    public static final SurfaceRules.RuleSource STARVED_SOUL_SOIL = makeStateRule(ModBlocks.STARVED_SOUL_SOIL.get());
    public static final SurfaceRules.RuleSource MURDEROUS_SOUL_SOIL = makeStateRule(ModBlocks.MURDEROUS_SOUL_SOIL.get());
    private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);

    public static SurfaceRules.RuleSource makeRules() {
        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);

        SurfaceRules.RuleSource grassSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(abovePreliminarySurface(), GRASS_BLOCK), SurfaceRules.ifTrue(abovePreliminarySurface(), DIRT));

        SurfaceRules.RuleSource starvedSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(abovePreliminarySurface(), STARVED_SOUL_SOIL), SurfaceRules.ifTrue(abovePreliminarySurface(), STARVED_SOUL_SOIL));
        SurfaceRules.RuleSource murderousSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(abovePreliminarySurface(), MURDEROUS_SOUL_SOIL), SurfaceRules.ifTrue(abovePreliminarySurface(), MURDEROUS_SOUL_SOIL));


        return SurfaceRules.sequence(

                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.STARVED_SOUL_PLAINS), starvedSurface),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.MURDEROUS_SOUL_PLAINS), murderousSurface)
        );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }
}

