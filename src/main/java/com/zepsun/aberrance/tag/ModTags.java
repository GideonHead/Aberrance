package com.zepsun.aberrance.tag;

import com.zepsun.aberrance.Aberrance;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Items {

        public static final TagKey<Item> SEED_MAKER_CROPS = tag("seed_maker_crops");
        public static final TagKey<Item> SEED_MAKER_SEEDS = tag("seed_maker_seeds");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(Aberrance.MOD_ID, name));
        }
        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }
    public static class Blocks {

        public static final TagKey<Block> NEEDS_KYANITE_TOOL = tag("needs_kyanite_tool");
        public static final TagKey<Block> SOUL_DIRT = tag("soul_dirt");
        public static final TagKey<Block> ABERRANCE_PLANT_PLACEABLES = tag("aberrance_plant_placeables");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(Aberrance.MOD_ID, name));
        }
        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Biomes {

        public static final TagKey<Biome> IS_ABYSS = tag("is_abyss");
        public static final TagKey<Biome> IS_MURDEROUS = tag("is_murderous");
        public static final TagKey<Biome> IS_STARVED = tag("is_starved");

        private static TagKey<Biome> tag(String name) {
            return biomeTagCreate(new ResourceLocation(Aberrance.MOD_ID, name));
        }
        private static TagKey<Biome> forgeTag(String name) {
            return biomeTagCreate(new ResourceLocation("forge", name));
        }
    }

    private static TagKey<Biome> biomeTagCreate(ResourceLocation resourceLocation) {
        return TagKey.create(Registries.BIOME, resourceLocation);
    }
}
