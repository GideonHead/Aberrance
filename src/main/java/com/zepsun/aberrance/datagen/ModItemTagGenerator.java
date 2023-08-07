package com.zepsun.aberrance.datagen;

import com.zepsun.aberrance.Aberrance;
import com.zepsun.aberrance.block.ModBlocks;
import com.zepsun.aberrance.item.ModItems;
import com.zepsun.aberrance.tag.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> providerCompletableFuture, CompletableFuture<TagLookup<Block>> tagLookupCompletableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, providerCompletableFuture, tagLookupCompletableFuture, Aberrance.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Items.SEED_MAKER_CROPS)
                .add(ModItems.WINTER_WHEAT.get())
                .add(ModItems.PARSNIP.get())
                .add(Items.WHEAT)
                .add(Items.BEETROOT);

        this.tag(ModTags.Items.SEED_MAKER_SEEDS)
                .add(ModItems.WINTER_WHEAT_SEEDS.get())
                .add(ModItems.PARSNIP_SEEDS.get())
                .add(Items.WHEAT_SEEDS)
                .add(Items.BEETROOT_SEEDS);

        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.CREPE_MYRTLE_PLANKS.get().asItem())
                .add(ModBlocks.LIVE_OAK_PLANKS.get().asItem());

        this.tag(ItemTags.MUSIC_DISCS)
                .add(ModItems.MUSIC_DISC_ENRICHED.get());



    }

    @Override
    public String getName() {
        return "Item Tags";
    }
}
