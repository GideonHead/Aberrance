package com.zepsun.aberrance.worldgen;

import com.zepsun.aberrance.Aberrance;
import com.zepsun.aberrance.worldgen.placer.CrepeMyrtleTrunkPlacer;
import com.zepsun.aberrance.worldgen.placer.FancySoulTrunkPlacer;
import com.zepsun.aberrance.worldgen.placer.SoulTrunkPlacer;
import com.zepsun.aberrance.worldgen.placer.VeryFancySoulTrunkPlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModTrunkPlacerTypes {
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACERS =
            DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, Aberrance.MOD_ID);

    public static final RegistryObject<TrunkPlacerType<SoulTrunkPlacer>> SOUL_TRUNK_PLACER =
            TRUNK_PLACERS.register("soul_trunk_placer", () -> new TrunkPlacerType<>(SoulTrunkPlacer.CODEC));
    public static final RegistryObject<TrunkPlacerType<FancySoulTrunkPlacer>> FANCY_SOUL_TRUNK_PLACER =
            TRUNK_PLACERS.register("fancy_soul_trunk_placer", () -> new TrunkPlacerType<>(FancySoulTrunkPlacer.CODEC));
    public static final RegistryObject<TrunkPlacerType<VeryFancySoulTrunkPlacer>> VERY_FANCY_SOUL_TRUNK_PLACER =
            TRUNK_PLACERS.register("very_fancy_soul_trunk_placer", () -> new TrunkPlacerType<>(VeryFancySoulTrunkPlacer.CODEC));

    public static final RegistryObject<TrunkPlacerType<CrepeMyrtleTrunkPlacer>> CREPE_MYRTLE_TRUNK_PLACER =
            TRUNK_PLACERS.register("crepe_myrtle_trunk_placer", () -> new TrunkPlacerType<>(CrepeMyrtleTrunkPlacer.CODEC));

    public static final RegistryObject<TrunkPlacerType<CrepeMyrtleTrunkPlacer>> HUGE_TRUNK_PLACER =
            TRUNK_PLACERS.register("huge_trunk_placer", () -> new TrunkPlacerType<>(CrepeMyrtleTrunkPlacer.CODEC));

    public static void register(IEventBus eventBus) {
        TRUNK_PLACERS.register(eventBus);
    }
}
