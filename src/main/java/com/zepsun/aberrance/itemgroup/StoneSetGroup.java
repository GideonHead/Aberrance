package com.zepsun.aberrance.itemgroup;

import net.minecraft.world.level.block.Block;

import javax.annotation.Nullable;

public class StoneSetGroup {
    @Nullable
    private Block cobblestoneBlock;
    @Nullable
    private Block stoneBricksBlock;
    @Nullable
    private Block cobblestoneWallBlock;
    @Nullable
    private Block stoneBrickWallBlock;

    public StoneSetGroup(@Nullable Block inputCobblestoneBlock, @Nullable Block inputStoneBricksBlock, @Nullable Block inputCobblestoneWallBlock,
                         @Nullable Block inputStoneBrickWallBlock) {
        cobblestoneBlock = inputCobblestoneBlock;
        stoneBricksBlock = inputStoneBricksBlock;
        cobblestoneWallBlock = inputCobblestoneWallBlock;
        stoneBrickWallBlock = inputStoneBrickWallBlock;
    }

    @Nullable
    public Block getCobblestoneBlock() {
        return cobblestoneBlock;
    }

    @Nullable
    public Block getCobblestoneWallBlock() {
        return cobblestoneWallBlock;
    }

    @Nullable
    public Block getStoneBricksBlock() {
        return stoneBricksBlock;
    }

    @Nullable
    public Block getStoneBrickWallBlock() {
        return stoneBrickWallBlock;
    }
}
