package com.zepsun.aberrance.worldgen.biome;

import com.zepsun.aberrance.Aberrance;
import com.zepsun.aberrance.worldgen.biome.custom.ModOverworldRegion;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.Regions;

public class ModTerraBlenderApi {
    public static void registerRegions() {
        Regions.register(new ModOverworldRegion(new ResourceLocation(Aberrance.MOD_ID, "overworld"), 5));
    }
}
