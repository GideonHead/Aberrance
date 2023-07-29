package com.zepsun.aberrance.itemgroup;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nullable;

public class TreeGroup {

    @Nullable
    private Block logBlock;
    @Nullable
    private Block woodBlock;
    @Nullable
    private Block strippedLogBlock;
    @Nullable
    private Block strippedWoodBlock;

    @Nullable
    private Block planksBlock;
    @Nullable
    private Block leavesBlock;
    @Nullable
    private Block saplingBlock;
    @Nullable
    private Block doorBlock;
    @Nullable
    private Block trapdoorBlock;
    @Nullable
    private Block buttonBlock;
    @Nullable
    private Block pressurePlateBlock;
    @Nullable
    private Block fenceBlock;
    @Nullable
    private Block fenceGateBlock;
    @Nullable
    private Block slabBlock;
    @Nullable
    private Block stairsBlock;

    public TreeGroup(@Nullable Block inputLogBlock, @Nullable Block inputWoodBlock, @Nullable Block inputStrippedLogBlock, @Nullable Block inputStrippedWoodBlock,
                     @Nullable Block inputPlanksBlock, @Nullable Block inputLeavesBlock, @Nullable Block inputSaplingBlock, @Nullable Block inputDoorBlock,
                     @Nullable Block inputTrapdoorBlock, @Nullable Block inputButtonBlock, @Nullable Block inputPressurePlateBlock, @Nullable Block inputFenceBlock,
                     @Nullable Block inputFenceGateBlock, @Nullable Block inputSlabBlock, @Nullable Block inputStairsBlock) {
        logBlock = inputLogBlock;
        woodBlock = inputWoodBlock;
        strippedLogBlock = inputStrippedLogBlock;
        strippedWoodBlock = inputStrippedWoodBlock;

        planksBlock = inputPlanksBlock;
        leavesBlock = inputLeavesBlock;
        saplingBlock = inputSaplingBlock;
        doorBlock = inputDoorBlock;
        trapdoorBlock = inputTrapdoorBlock;
        buttonBlock = inputButtonBlock;
        pressurePlateBlock = inputPressurePlateBlock;
        fenceBlock = inputFenceBlock;
        fenceGateBlock = inputFenceGateBlock;
        slabBlock = inputSlabBlock;
        stairsBlock = inputStairsBlock;
    }

    @Nullable
    public Block getLogBlock() {
        return logBlock;
    }

    @Nullable
    public Block getWoodBlock() {
        return woodBlock;
    }

    @Nullable
    public Block getStrippedLogBlock() {
        return strippedLogBlock;
    }

    @Nullable
    public Block getStrippedWoodBlock() {
        return strippedWoodBlock;
    }

    @Nullable
    public Block getPlanksBlock() {
        return planksBlock;
    }

    @Nullable
    public Block getLeavesBlock() {
        return leavesBlock;
    }

    @Nullable
    public Block getSaplingBlock() {
        return saplingBlock;
    }

    @Nullable
    public Block getDoorBlock() {
        return doorBlock;
    }

    @Nullable
    public Block getTrapdoorBlock() {
        return trapdoorBlock;
    }

    @Nullable
    public Block getButtonBlock() {
        return buttonBlock;
    }

    @Nullable
    public Block getPressurePlateBlock() {
        return pressurePlateBlock;
    }

    @Nullable
    public Block getFenceBlock() {
        return fenceBlock;
    }

    @Nullable
    public Block getFenceGateBlock() {
        return fenceGateBlock;
    }

    @Nullable
    public Block getSlabBlock() {
        return slabBlock;
    }

    @Nullable
    public Block getStairsBlock() {
        return stairsBlock;
    }
}
