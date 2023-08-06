package com.zepsun.aberrance.datagen;

import com.zepsun.aberrance.Aberrance;
import com.zepsun.aberrance.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Aberrance.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.LOGS)
                .add(ModBlocks.CREPE_MYRTLE_LOG.get())
                .add(ModBlocks.CREPE_MYRTLE_WOOD.get())
                .add(ModBlocks.STRIPPED_CREPE_MYRTLE_LOG.get())
                .add(ModBlocks.STRIPPED_CREPE_MYRTLE_WOOD.get())
                .add(ModBlocks.LIVE_OAK_LOG.get())
                .add(ModBlocks.LIVE_OAK_WOOD.get())
                .add(ModBlocks.STRIPPED_LIVE_OAK_LOG.get())
                .add(ModBlocks.STRIPPED_LIVE_OAK_WOOD.get())
                .add(ModBlocks.BROADLEAF_LOG.get())
                .add(ModBlocks.BROADLEAF_WOOD.get())
                .add(ModBlocks.STRIPPED_BROADLEAF_LOG.get())
                .add(ModBlocks.STRIPPED_BROADLEAF_WOOD.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.WHITE_COBBLESTONE.get())
                .add(ModBlocks.WHITE_STONE_BRICKS.get())
                .add(ModBlocks.WHITE_STONE_BRICK_WALL.get())
                .add(ModBlocks.WHITE_COBBLESTONE_WALL.get())
                .add(ModBlocks.COBBLESTONE_CASE.get())
                .add(ModBlocks.SEED_MAKER.get())
                .add(ModBlocks.RUDANIUM_BLOCK.get())
                .add(ModBlocks.RAW_RUDANIUM_BLOCK.get())
                .add(ModBlocks.RUDANIUM_ORE.get())
                .add(ModBlocks.RUDANIUM_ORE_DEEPSLATE.get())
                .add(ModBlocks.RUDANIUM_ORE_END.get())
                .add(ModBlocks.RUDANIUM_ORE_NETHER.get())
                .add(ModBlocks.KYANITE_BLOCK.get())
                .add(ModBlocks.RAW_KYANITE_BLOCK.get())
                .add(ModBlocks.KYANITE_ORE_NETHER.get())
                .add(ModBlocks.KYANITE_ORE.get())
                .add(ModBlocks.KYANITE_ORE_END.get())
                .add(ModBlocks.KYANITE_ORE_DEEPSLATE.get());

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.LIVE_OAK_LOG.get())
                .add(ModBlocks.STRIPPED_LIVE_OAK_LOG.get())
                .add(ModBlocks.LIVE_OAK_WOOD.get())
                .add(ModBlocks.STRIPPED_LIVE_OAK_WOOD.get())
                .add(ModBlocks.LIVE_OAK_PLANKS.get())
                .add(ModBlocks.LIVE_OAK_BUTTON.get())
                .add(ModBlocks.LIVE_OAK_PRESSURE_PLATE.get())
                .add(ModBlocks.LIVE_OAK_FENCE.get())
                .add(ModBlocks.LIVE_OAK_FENCE_GATE.get())
                .add(ModBlocks.LIVE_OAK_DOOR.get())
                .add(ModBlocks.LIVE_OAK_TRAPDOOR.get())
                .add(ModBlocks.LIVE_OAK_STAIRS.get())
                .add(ModBlocks.LIVE_OAK_SLAB.get())

                .add(ModBlocks.BROADLEAF_LOG.get())
                .add(ModBlocks.STRIPPED_BROADLEAF_LOG.get())
                .add(ModBlocks.BROADLEAF_WOOD.get())
                .add(ModBlocks.STRIPPED_BROADLEAF_WOOD.get())
                .add(ModBlocks.BROADLEAF_PLANKS.get())
                .add(ModBlocks.BROADLEAF_BUTTON.get())
                .add(ModBlocks.BROADLEAF_PRESSURE_PLATE.get())
                .add(ModBlocks.BROADLEAF_FENCE.get())
                .add(ModBlocks.BROADLEAF_FENCE_GATE.get())
                .add(ModBlocks.BROADLEAF_DOOR.get())
                .add(ModBlocks.BROADLEAF_TRAPDOOR.get())
                .add(ModBlocks.BROADLEAF_STAIRS.get())
                .add(ModBlocks.BROADLEAF_SLAB.get())

                .add(ModBlocks.CREPE_MYRTLE_LOG.get())
                .add(ModBlocks.STRIPPED_CREPE_MYRTLE_LOG.get())
                .add(ModBlocks.CREPE_MYRTLE_WOOD.get())
                .add(ModBlocks.STRIPPED_CREPE_MYRTLE_WOOD.get())
                .add(ModBlocks.CREPE_MYRTLE_PLANKS.get())
                .add(ModBlocks.CREPE_MYRTLE_BUTTON.get())
                .add(ModBlocks.CREPE_MYRTLE_PRESSURE_PLATE.get())
                .add(ModBlocks.CREPE_MYRTLE_FENCE.get())
                .add(ModBlocks.CREPE_MYRTLE_FENCE_GATE.get())
                .add(ModBlocks.CREPE_MYRTLE_DOOR.get())
                .add(ModBlocks.CREPE_MYRTLE_TRAPDOOR.get())
                .add(ModBlocks.CREPE_MYRTLE_STAIRS.get())
                .add(ModBlocks.CREPE_MYRTLE_SLAB.get());

        this.tag(BlockTags.MINEABLE_WITH_HOE)
                .add(ModBlocks.LIVE_OAK_LEAVES.get())
                .add(ModBlocks.ACACIA_MESQUITE_LEAVES.get())
                .add(ModBlocks.CREPE_MYRTLE_LEAVES.get())
                .add(ModBlocks.BROADLEAF_LEAVES.get());


        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(ModBlocks.KYANITE_BLOCK.get())
                .add(ModBlocks.RAW_KYANITE_BLOCK.get())
                .add(ModBlocks.KYANITE_ORE_NETHER.get())
                .add(ModBlocks.KYANITE_ORE.get())
                .add(ModBlocks.KYANITE_ORE_END.get())
                .add(ModBlocks.KYANITE_ORE_DEEPSLATE.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.RUDANIUM_BLOCK.get())
                .add(ModBlocks.RAW_RUDANIUM_BLOCK.get())
                .add(ModBlocks.RUDANIUM_ORE.get())
                .add(ModBlocks.RUDANIUM_ORE_DEEPSLATE.get())
                .add(ModBlocks.RUDANIUM_ORE_END.get())
                .add(ModBlocks.RUDANIUM_ORE_NETHER.get());

        this.tag(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.CREPE_MYRTLE_FENCE.get())
                .add(ModBlocks.LIVE_OAK_FENCE.get());
        this.tag(BlockTags.WOODEN_BUTTONS)
                .add(ModBlocks.CREPE_MYRTLE_BUTTON.get())
                .add(ModBlocks.LIVE_OAK_BUTTON.get());
        this.tag(BlockTags.WOODEN_DOORS)
                .add(ModBlocks.CREPE_MYRTLE_DOOR.get())
                .add(ModBlocks.LIVE_OAK_DOOR.get());
        this.tag(BlockTags.WOODEN_SLABS)
                .add(ModBlocks.CREPE_MYRTLE_SLAB.get())
                .add(ModBlocks.LIVE_OAK_SLAB.get());
        this.tag(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks.CREPE_MYRTLE_STAIRS.get())
                .add(ModBlocks.LIVE_OAK_STAIRS.get());
        this.tag(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.CREPE_MYRTLE_PRESSURE_PLATE.get())
                .add(ModBlocks.LIVE_OAK_PRESSURE_PLATE.get());
        this.tag(BlockTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.CREPE_MYRTLE_TRAPDOOR.get())
                .add(ModBlocks.LIVE_OAK_TRAPDOOR.get());

        this.tag(BlockTags.FENCES)
                .add(ModBlocks.CREPE_MYRTLE_FENCE.get())
                .add(ModBlocks.LIVE_OAK_FENCE.get())
                .add(ModBlocks.BROADLEAF_FENCE.get());
        this.tag(BlockTags.WALLS)
                .add(ModBlocks.WHITE_COBBLESTONE_WALL.get())
                .add(ModBlocks.WHITE_STONE_WALL.get())
                .add(ModBlocks.WHITE_STONE_BRICK_WALL.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.CREPE_MYRTLE_FENCE_GATE.get())
                .add(ModBlocks.LIVE_OAK_FENCE_GATE.get())
                .add(ModBlocks.BROADLEAF_FENCE_GATE.get());

        this.tag(BlockTags.SOUL_SPEED_BLOCKS)
                .add(ModBlocks.STARVED_SOUL_SOIL.get())
                .add(ModBlocks.MURDEROUS_SOUL_SOIL.get())
                .add(ModBlocks.SOUL_SEDIMENT.get());

    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}
