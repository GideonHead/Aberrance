package com.zepsun.aberrance.dimension;

import com.zepsun.aberrance.Aberrance;
import com.zepsun.aberrance.block.ModBlocks;
import com.zepsun.aberrance.worldgen.biome.surface.ModSurfaceRules;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.SurfaceRuleData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.OverworldBiomeBuilder;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.*;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import terrablender.mixin.MixinNoiseGeneratorSettings;

import static com.sun.jna.Function.getFunction;

public class ModLevelGen extends NoiseRouterData {
    protected static final NoiseSettings ABYSS_NOISE_SETTINGS = NoiseSettings.create(0, 128, 1, 2);

    //protected static final NoiseSettings ABYSS_NOISE_SETTINGS = NoiseSettings.create(-64, 384, 1, 2);

    public static final ResourceKey<NoiseGeneratorSettings> ABYSS = ResourceKey.create(Registries.NOISE_SETTINGS, new ResourceLocation(Aberrance.MOD_ID, "abyss_noise"));

    public static NoiseGeneratorSettings abyss(BootstapContext<?> pContext, boolean pAmplified, boolean pLarge) {
        return new NoiseGeneratorSettings(ABYSS_NOISE_SETTINGS, ModBlocks.SOUL_SEDIMENT.get().defaultBlockState(),
                Blocks.WATER.defaultBlockState(), NoiseRouterData.overworld(pContext.lookup(Registries.DENSITY_FUNCTION),
                pContext.lookup(Registries.NOISE), false, false), ModSurfaceRules.makeRules(), (new OverworldBiomeBuilder()).spawnTarget(),
                63, false, true, false, false);
    }

    public static void bootstrapNoiseGen(BootstapContext<NoiseGeneratorSettings> pContext) {
        pContext.register(ABYSS, abyss(pContext, false, false));
    }
}
