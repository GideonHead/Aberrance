package com.zepsun.aberrance.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;

public class CustomPlacementNoGrowSaplingBlock extends SaplingBlock {
    public static TagKey<Block> mayPlaceTag;

    public CustomPlacementNoGrowSaplingBlock(AbstractTreeGrower pTreeGrower, TagKey<Block> thisMayPlaceTag, Properties pProperties) {
        super(pTreeGrower, pProperties);
        mayPlaceTag = thisMayPlaceTag;
    }

    @Override
    protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return pState.is(mayPlaceTag);
    }

    @Override
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {}

    public static TagKey<Block> getPlacementTag() {
        return mayPlaceTag;
    }
}
