package com.zepsun.aberrance.worldgen.placer;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.zepsun.aberrance.worldgen.ModTrunkPlacerTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.List;
import java.util.function.BiConsumer;

public class FancySoulTrunkPlacer extends TrunkPlacer {
    public static final Codec<FancySoulTrunkPlacer> CODEC = RecordCodecBuilder.create(fancySoulTrunkPlacerInstance ->
            trunkPlacerParts(fancySoulTrunkPlacerInstance).apply(fancySoulTrunkPlacerInstance, FancySoulTrunkPlacer::new));

    public FancySoulTrunkPlacer(int pBaseHeight, int pHeightRandA, int pHeightRandB) {
        super(pBaseHeight, pHeightRandA, pHeightRandB);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return ModTrunkPlacerTypes.FANCY_SOUL_TRUNK_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> pBlockSetter, RandomSource pRandom,
                                                            int pFreeTreeHeight, BlockPos pPos, TreeConfiguration pConfig) {

        setDirtAt(pLevel, pBlockSetter, pRandom, pPos.below(), pConfig);
        int height = pFreeTreeHeight + pRandom.nextInt(heightRandA, heightRandA + 3) + pRandom.nextInt(heightRandB - 1, heightRandB + 1);
        List<FoliagePlacer.FoliageAttachment> foliageAttachmentList = new java.util.ArrayList<>(List.of());

        placeLog(pLevel, pBlockSetter, pRandom, pPos, pConfig);

        for(int i = 0; i < height; i++) {
            placeLog(pLevel, pBlockSetter, pRandom, pPos.above(i), pConfig);

            if(i > 2) {

                if (i % 2 == 0 && pRandom.nextBoolean()) {
                    BlockPos currentPos = pPos.above(i).relative(Direction.NORTH);
                    if (pRandom.nextFloat() < 0.75f) {
                        placeLog(pLevel, pBlockSetter, pRandom, currentPos, pConfig, (BlockState) ->
                                BlockState.trySetValue(RotatedPillarBlock.AXIS, this.getLogAxis(pPos, currentPos)));
                    }
                }

                if (i % 2 == 0 && pRandom.nextBoolean()) {
                    BlockPos currentPos = pPos.above(i).relative(Direction.EAST);
                    if (pRandom.nextFloat() < 0.75f) {
                        placeLog(pLevel, pBlockSetter, pRandom, currentPos, pConfig, (BlockState) ->
                                BlockState.trySetValue(RotatedPillarBlock.AXIS, this.getLogAxis(pPos, currentPos)));
                    }
                }

                if (i % 2 == 0 && pRandom.nextBoolean()) {
                    BlockPos currentPos = pPos.above(i).relative(Direction.SOUTH);
                    if (pRandom.nextFloat() < 0.75f) {
                        placeLog(pLevel, pBlockSetter, pRandom, currentPos, pConfig, (BlockState) ->
                                BlockState.trySetValue(RotatedPillarBlock.AXIS, this.getLogAxis(pPos, currentPos)));
                    }
                }

                if (i % 2 == 0 && pRandom.nextBoolean()) {
                    BlockPos currentPos = pPos.above(i).relative(Direction.WEST);
                    if (pRandom.nextFloat() < 0.75f) {
                        placeLog(pLevel, pBlockSetter, pRandom, currentPos, pConfig, (BlockState) ->
                                BlockState.trySetValue(RotatedPillarBlock.AXIS, this.getLogAxis(pPos, currentPos)));
                    }
                }
            }

            if (i % 2 == 0 && pRandom.nextBoolean()) {
                if (pRandom.nextFloat() < 0.6f) {
                    foliageAttachmentList.add(placeBranch(pLevel, pBlockSetter, pRandom, pPos.above(i), pConfig, Direction.NORTH));
                }
            }

            if (i % 2 == 0 && pRandom.nextBoolean()) {
                if (pRandom.nextFloat() < 0.6f) {
                    foliageAttachmentList.add(placeBranch(pLevel, pBlockSetter, pRandom, pPos.above(i), pConfig, Direction.EAST));
                }
            }

            if (i % 2 == 0 && pRandom.nextBoolean()) {
                if (pRandom.nextFloat() < 0.6f) {
                    foliageAttachmentList.add(placeBranch(pLevel, pBlockSetter, pRandom, pPos.above(i), pConfig, Direction.SOUTH));
                }
            }

            if (i % 2 == 0 && pRandom.nextBoolean()) {
                if (pRandom.nextFloat() < 0.6f) {
                    foliageAttachmentList.add(placeBranch(pLevel, pBlockSetter, pRandom, pPos.above(i), pConfig, Direction.WEST));
                }
            }
        }

        foliageAttachmentList.add(new FoliagePlacer.FoliageAttachment(pPos.above(height).offset(0, -1, 0), 0, false));

        return foliageAttachmentList;
    }

    public FoliagePlacer.FoliageAttachment placeBranch(LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> pBlockSetter, RandomSource pRandom,
                                                            BlockPos pPos, TreeConfiguration pConfig, Direction pDirection) {

        BlockPos thisPos = pPos;
        int branchLength = pRandom.nextInt(2, 7);

        for(int i = 0; i < branchLength; i++) {
            float current = pRandom.nextFloat();
            if(current < 0.5f) {
                BlockPos currentPos = thisPos.relative(pDirection).relative(Direction.UP);
                placeLog(pLevel, pBlockSetter, pRandom, currentPos, pConfig, (BlockState) ->
                        BlockState.trySetValue(RotatedPillarBlock.AXIS, this.getLogAxis(pPos, currentPos)));
                thisPos = currentPos;
            } else if(current > 0.5f) {
                BlockPos currentPos = thisPos.relative(pDirection);
                placeLog(pLevel, pBlockSetter, pRandom, currentPos, pConfig, (BlockState) ->
                        BlockState.trySetValue(RotatedPillarBlock.AXIS, this.getLogAxis(pPos, currentPos)));
                thisPos = currentPos;
            }
        }

        return new FoliagePlacer.FoliageAttachment(thisPos, 0, false);
    }

    private Direction.Axis getLogAxis(BlockPos pPos, BlockPos pOtherPos) {
        Direction.Axis direction$axis = Direction.Axis.Y;
        int i = Math.abs(pOtherPos.getX() - pPos.getX());
        int j = Math.abs(pOtherPos.getZ() - pPos.getZ());
        int k = Math.max(i, j);
        if (k > 0) {
            if (i == k) {
                direction$axis = Direction.Axis.X;
            } else {
                direction$axis = Direction.Axis.Z;
            }
        }

        return direction$axis;
    }
}
