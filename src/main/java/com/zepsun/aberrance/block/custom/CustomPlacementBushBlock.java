package com.zepsun.aberrance.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class CustomPlacementBushBlock extends BushBlock {
    public static TagKey<Block> mayPlaceTag;

    public CustomPlacementBushBlock(TagKey<Block> pMayPlaceTag, Properties pProperties) {
        super(pProperties);
        mayPlaceTag = pMayPlaceTag;
    }

    @Override
    protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return pState.is(mayPlaceTag);
    }

    public static TagKey<Block> getPlacementTag() {
        return mayPlaceTag;
    }
}
