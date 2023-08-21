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

public class CrepeMyrtleTrunkPlacer extends TrunkPlacer {
    public static final Codec<CrepeMyrtleTrunkPlacer> CODEC = RecordCodecBuilder.create(crepeMyrtleTrunkPlacerInstance ->
            trunkPlacerParts(crepeMyrtleTrunkPlacerInstance).apply(crepeMyrtleTrunkPlacerInstance, CrepeMyrtleTrunkPlacer::new));

    public CrepeMyrtleTrunkPlacer(int pBaseHeight, int pHeightRandA, int pHeightRandB) {
        super(pBaseHeight, pHeightRandA, pHeightRandB);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return ModTrunkPlacerTypes.CREPE_MYRTLE_TRUNK_PLACER.get();
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

            if(i == 0) {

                boolean offshootPlaced = false;

                if (i % 2 == 0 && pRandom.nextBoolean()) {
                    if (pRandom.nextFloat() < 0.6f) {
                        foliageAttachmentList.add(placeOffshoot(pLevel, pBlockSetter, pRandom, pPos.above(i), pConfig, Direction.NORTH));
                        offshootPlaced = true;
                    }
                }

                if (i % 2 == 0 && pRandom.nextBoolean()) {
                    if (pRandom.nextFloat() < 0.6f) {
                        foliageAttachmentList.add(placeOffshoot(pLevel, pBlockSetter, pRandom, pPos.above(i), pConfig, Direction.EAST));
                        offshootPlaced = true;
                    }
                }

                if (i % 2 == 0 && pRandom.nextBoolean()) {
                    if (pRandom.nextFloat() < 0.6f) {
                        foliageAttachmentList.add(placeOffshoot(pLevel, pBlockSetter, pRandom, pPos.above(i), pConfig, Direction.SOUTH));
                        offshootPlaced = true;
                    }
                }

                if (i % 2 == 0 && pRandom.nextBoolean()) {
                    if (pRandom.nextFloat() < 0.6f) {
                        foliageAttachmentList.add(placeOffshoot(pLevel, pBlockSetter, pRandom, pPos.above(i), pConfig, Direction.WEST));
                        offshootPlaced = true;
                    }
                }

                if (!offshootPlaced) {
                    float randF = pRandom.nextFloat();
                    if (randF < 0.5f) {
                        foliageAttachmentList.add(placeOffshoot(pLevel, pBlockSetter, pRandom, pPos.above(i), pConfig, Direction.WEST));
                    }
                    if (randF > 0.5f) {
                        foliageAttachmentList.add(placeOffshoot(pLevel, pBlockSetter, pRandom, pPos.above(i), pConfig, Direction.EAST));
                    }
                }
            }
        }

        foliageAttachmentList.add(new FoliagePlacer.FoliageAttachment(pPos.above(height).offset(0, +1, 0), 0, false));

        return foliageAttachmentList;
    }

    public FoliagePlacer.FoliageAttachment placeOffshoot(LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> pBlockSetter, RandomSource pRandom,
                                                         BlockPos pPos, TreeConfiguration pConfig, Direction pDirection) {

        BlockPos thisPos = pPos.relative(pDirection);
        int branchLength = pRandom.nextInt(1, 4);
        BlockPos endPos = thisPos;

        placeLog(pLevel, pBlockSetter, pRandom, thisPos, pConfig);
        thisPos = thisPos.above().relative(pDirection);

        for(int i = 0; i < branchLength; i++) {

            int segmentLength = pRandom.nextInt(1, 3);

            for(int j = 0; j< segmentLength; j++) {

                placeLog(pLevel, pBlockSetter, pRandom, thisPos, pConfig);
                thisPos = thisPos.above();
            }
            endPos = thisPos;
            thisPos = thisPos.relative(pDirection);
        }

        return new FoliagePlacer.FoliageAttachment(endPos.offset(0, +1, 0), 0, false);
    }
}
