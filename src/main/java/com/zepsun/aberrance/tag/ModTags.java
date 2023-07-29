package com.zepsun.aberrance.tag;

import com.zepsun.aberrance.Aberrance;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
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

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(Aberrance.MOD_ID, name));
        }
        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }
}
