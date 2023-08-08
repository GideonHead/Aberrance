package com.zepsun.aberrance.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class CustomPlacementBushBlock extends BushBlock {
    public static List<Object> mayPlaceList;

    public CustomPlacementBushBlock(List<Object> pMayPlaceList, Properties pProperties) {
        super(pProperties);
        mayPlaceList = pMayPlaceList;
    }

    @Override
    protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        int i;
        for (i = 0; i < mayPlaceList.size(); i++)
        {
            if (mayPlaceList.get(i) instanceof Block) {
                if (pState.is((Block) mayPlaceList.get(i))) {
                    return true;
                }
            } else if (mayPlaceList.get(i) instanceof TagKey<?>) {
                if (pState.is((TagKey<Block>) mayPlaceList.get(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static List<Object> getMayPlaceList() {
        return mayPlaceList;
    }
}
