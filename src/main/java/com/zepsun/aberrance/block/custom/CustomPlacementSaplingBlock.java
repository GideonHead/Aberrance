package com.zepsun.aberrance.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;

public class CustomPlacementSaplingBlock extends SaplingBlock {
    public static TagKey<Block> mayPlaceTag;

    public CustomPlacementSaplingBlock(AbstractTreeGrower pTreeGrower, TagKey<Block> thisMayPlaceTag, Properties pProperties) {
        super(pTreeGrower, pProperties);
        mayPlaceTag = thisMayPlaceTag;
    }

    @Override
    protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return pState.is(mayPlaceTag);
    }

    public static TagKey<Block> getPlacementTag() {
        return mayPlaceTag;
    }
}
