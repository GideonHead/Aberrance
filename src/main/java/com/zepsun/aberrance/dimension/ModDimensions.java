package com.zepsun.aberrance.dimension;

import com.mojang.datafixers.util.Pair;
import com.zepsun.aberrance.Aberrance;
import com.zepsun.aberrance.worldgen.biome.ModBiomes;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.*;

import java.util.List;
import java.util.OptionalLong;

public class ModDimensions {
    public static NoiseRouter blankNoiseRouter = new NoiseRouter(ModDensityFunction.densityFunction, ModDensityFunction.densityFunction, ModDensityFunction.densityFunction, ModDensityFunction.densityFunction, ModDensityFunction.densityFunction, ModDensityFunction.densityFunction, ModDensityFunction.densityFunction, ModDensityFunction.densityFunction, ModDensityFunction.densityFunction, ModDensityFunction.densityFunction, ModDensityFunction.densityFunction, ModDensityFunction.densityFunction, ModDensityFunction.densityFunction, ModDensityFunction.densityFunction, ModDensityFunction.densityFunction);
    public static List<Climate.ParameterPoint> blankSpawnTarget = List.of(new Climate.ParameterPoint(new Climate.Parameter(0, 0), new Climate.Parameter(0, 0), new Climate.Parameter(0, 0), new Climate.Parameter(0, 0), new Climate.Parameter(0, 0), new Climate.Parameter(0, 0), 0));

    public static ResourceKey<LevelStem> ABYSS_KEY = ResourceKey.create(Registries.LEVEL_STEM,
            new ResourceLocation(Aberrance.MOD_ID, "abyss"));
    public static ResourceKey<Level> ABYSS_LEVEL_KEY = ResourceKey.create(Registries.DIMENSION,
            new ResourceLocation(Aberrance.MOD_ID, "abyss"));
    public static ResourceKey<DimensionType> ABYSS_DIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE,
            new ResourceLocation(Aberrance.MOD_ID, "abyss_type"));

    public static void bootstrapType(BootstapContext<DimensionType> context) {
        context.register(ABYSS_DIM_TYPE, new DimensionType(
                OptionalLong.of(8000), // fixedTime
                false, // hasSkylight
                false, // hasCeiling
                false, // ultraWarm
                false, // natural
                1.0, // coordinateScale
                true, // bedWorks
                false, // respawnAnchorWorks
                0, // minY
                256, // height
                256, // logicalHeight
                BlockTags.INFINIBURN_OVERWORLD, // infiniburn
                BuiltinDimensionTypes.NETHER_EFFECTS, // effectsLocation
                1.0f, // ambientLight
                new DimensionType.MonsterSettings(false, false, ConstantInt.of(0), 0)));
    }

    public static void bootstrapStem(BootstapContext<LevelStem> context) {
        HolderGetter<Biome> biomeRegistry = context.lookup(Registries.BIOME);
        HolderGetter<DimensionType> dimTypes = context.lookup(Registries.DIMENSION_TYPE);
        HolderGetter<NoiseGeneratorSettings> noiseGenSettings = context.lookup(Registries.NOISE_SETTINGS);

        NoiseBasedChunkGenerator noiseBasedChunkGenerator = new NoiseBasedChunkGenerator(
                MultiNoiseBiomeSource.createFromList(
                        new Climate.ParameterList<>(List.of(Pair.of(
                                        Climate.parameters(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.STARVED_SOUL_PLAINS)),
                                Pair.of(Climate.parameters(0.1F, 0.2F, 0.0F, 0.2F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.STARVED_SOUL_FOREST)),
                                Pair.of(Climate.parameters(0.2F, 0.2F, 0.0F, 0.2F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(ModBiomes.MURDEROUS_SOUL_PLAINS))
                        ))),
                //noiseGenSettings.getOrThrow(NoiseGeneratorSettings.NETHER));
                noiseGenSettings.getOrThrow(ModLevelGen.ABYSS));

        LevelStem stem = new LevelStem(dimTypes.getOrThrow(ModDimensions.ABYSS_DIM_TYPE), noiseBasedChunkGenerator);

        context.register(ABYSS_KEY, stem);
    }

}
