package com.zepsun.aberrance.worldgen;

import com.zepsun.aberrance.Aberrance;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_TREE_ACACIA_MESQUITE = registerKey("add_tree_acacia_mesquite");

    public static final ResourceKey<BiomeModifier> ADD_TREE_CREPE_MYRTLE_FOREST = registerKey("add_tree_crepe_myrtle_forest");
    public static final ResourceKey<BiomeModifier> ADD_TREE_CREPE_MYRTLE_PLAINS = registerKey("add_tree_crepe_myrtle_plains");

    public static final ResourceKey<BiomeModifier> ADD_KYANITE_ORE = registerKey("add_kyanite_ore");
    public static final ResourceKey<BiomeModifier> ADD_NETHER_KYANITE_ORE = registerKey("add_nether_kyanite_ore");
    public static final ResourceKey<BiomeModifier> ADD_END_KYANITE_ORE = registerKey("add_end_kyanite_ore");

    public static final ResourceKey<BiomeModifier> ADD_RUDANIUM_ORE = registerKey("add_rudanium_ore");
    public static final ResourceKey<BiomeModifier> ADD_NETHER_RUDANIUM_ORE = registerKey("add_nether_rudanium_ore");
    public static final ResourceKey<BiomeModifier> ADD_END_RUDANIUM_ORE = registerKey("add_end_rudanium_ore");

    public static final ResourceKey<BiomeModifier> ADD_WHITE_COBBLESTONE = registerKey("add_white_cobblestone");

    public static final ResourceKey<BiomeModifier> ADD_WILD_ONION_PLANT_FOREST = registerKey("add_wild_onion_plant_forest");
    public static final ResourceKey<BiomeModifier> ADD_WILD_ONION_PLANT_PLAINS = registerKey("add_wild_onion_plant_plains");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_TREE_ACACIA_MESQUITE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_SAVANNA),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.ACACIA_MESQUITE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_TREE_CREPE_MYRTLE_FOREST, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_FOREST),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.CREPE_MYRTLE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(ADD_TREE_CREPE_MYRTLE_PLAINS, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_PLAINS),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.CREPE_MYRTLE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_KYANITE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.KYANITE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_NETHER_KYANITE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.NETHER_KYANITE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_END_KYANITE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.END_KYANITE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_RUDANIUM_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.RUDANIUM_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_NETHER_RUDANIUM_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.NETHER_RUDANIUM_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_END_RUDANIUM_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.END_RUDANIUM_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_WHITE_COBBLESTONE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.WHITE_COBBLESTONE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_WILD_ONION_PLANT_FOREST, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_FOREST),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.WILD_ONION_PLANT_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(ADD_WILD_ONION_PLANT_PLAINS, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_PLAINS),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.WILD_ONION_PLANT_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

    }



    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(Aberrance.MOD_ID, name));
    }
}
