package com.zepsun.aberrance.datagen;

import com.zepsun.aberrance.Aberrance;
import com.zepsun.aberrance.tag.ModTags;
import com.zepsun.aberrance.worldgen.biome.ModBiomes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MultiNoiseBiomeSourceParameterList;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModBiomeTagGenerator extends BiomeTagsProvider {
    List<ResourceKey<Biome>> abyssBiomes = List.of(ModBiomes.MURDEROUS_SOUL_PLAINS, ModBiomes.STARVED_SOUL_PLAINS);
    List<ResourceKey<Biome>> modForestBiomes = List.of(ModBiomes.CREPE_MYRTLE_FOREST);
    List<ResourceKey<Biome>> modJungleBiomes = List.of(ModBiomes.BROADLEAF_HILLS);

    public ModBiomeTagGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pProvider, Aberrance.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        TagsProvider.TagAppender<Biome> tagappender = this.tag(ModTags.Biomes.IS_ABYSS);
        abyssBiomes.forEach(tagappender::add);

        TagsProvider.TagAppender<Biome> tagappender1 = this.tag(BiomeTags.IS_FOREST);
        modForestBiomes.forEach(tagappender1::add);
        TagsProvider.TagAppender<Biome> tagappender2 = this.tag(BiomeTags.IS_JUNGLE);
        modJungleBiomes.forEach(tagappender2::add);
    }

    @Override
    public String getName() {
        return "Biome Tags";
    }
}
