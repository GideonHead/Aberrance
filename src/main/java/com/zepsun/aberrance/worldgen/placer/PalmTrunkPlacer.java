package com.zepsun.aberrance.worldgen.placer;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.zepsun.aberrance.block.ModBlocks;
import com.zepsun.aberrance.worldgen.ModTrunkPlacerTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class PalmTrunkPlacer extends TrunkPlacer {
    public static final Codec<PalmTrunkPlacer> CODEC = RecordCodecBuilder.create(palmTrunkPlacerInstance ->
            trunkPlacerParts(palmTrunkPlacerInstance).apply(palmTrunkPlacerInstance, PalmTrunkPlacer::new));

    public PalmTrunkPlacer(int pBaseHeight, int pHeightRandA, int pHeightRandB) {
        super(pBaseHeight, pHeightRandA, pHeightRandB);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return ModTrunkPlacerTypes.PALM_TRUNK_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> pBlockSetter, RandomSource pRandom,
                                                            int pFreeTreeHeight, BlockPos pPos, TreeConfiguration pConfig) {


        int height = pFreeTreeHeight + pRandom.nextInt(heightRandA, heightRandA + 3) + pRandom.nextInt(heightRandB - 1, heightRandB + 1);
        List<FoliagePlacer.FoliageAttachment> foliageAttachmentList = new java.util.ArrayList<>(List.of());

        for(int i = 0; i < height; i++) {


            if(i == 0) {

                Boolean randBool = pRandom.nextBoolean();

                if (randBool) {
                    foliageAttachmentList.add(placeOffshoot(pLevel, pBlockSetter, pRandom, pPos.above(i), pConfig, Direction.NORTH));
                    foliageAttachmentList.add(placeOffshoot(pLevel, pBlockSetter, pRandom, pPos.above(i), pConfig, Direction.SOUTH));
                    if (pRandom.nextFloat() < 0.2f) {
                        foliageAttachmentList.add(placeOffshoot(pLevel, pBlockSetter, pRandom, pPos.above(i), pConfig, Direction.EAST));
                        foliageAttachmentList.add(placeOffshoot(pLevel, pBlockSetter, pRandom, pPos.above(i), pConfig, Direction.WEST));
                    }
                }

                if (!randBool) {
                    foliageAttachmentList.add(placeOffshoot(pLevel, pBlockSetter, pRandom, pPos.above(i), pConfig, Direction.EAST));
                    foliageAttachmentList.add(placeOffshoot(pLevel, pBlockSetter, pRandom, pPos.above(i), pConfig, Direction.WEST));
                    if (pRandom.nextFloat() < 0.2f) {
                        foliageAttachmentList.add(placeOffshoot(pLevel, pBlockSetter, pRandom, pPos.above(i), pConfig, Direction.NORTH));
                        foliageAttachmentList.add(placeOffshoot(pLevel, pBlockSetter, pRandom, pPos.above(i), pConfig, Direction.SOUTH));
                    }
                }
            }
        }
        return foliageAttachmentList;
    }

    public FoliagePlacer.FoliageAttachment placeOffshoot(LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> pBlockSetter, RandomSource pRandom,
                                                         BlockPos pPos, TreeConfiguration pConfig, Direction pDirection) {

        BlockPos thisPos = pPos.relative(pDirection);
        int branchLength = pRandom.nextInt(2, 5);
        BlockPos endPos = thisPos;

        placeLog(pLevel, pBlockSetter, pRandom, thisPos, pConfig);
        thisPos = thisPos.above().relative(pDirection);

        for(int i = 0; i < branchLength; i++) {

            int segmentLength = pRandom.nextInt(3, 6);

            for(int j = 0; j < segmentLength; j++) {

                if (i == branchLength - 1) {
                    if(j >= segmentLength/3) {
                        placeFibrousLog(pLevel, pBlockSetter, thisPos);
                        thisPos = thisPos.above();
                    } else {
                        placeLog(pLevel, pBlockSetter, pRandom, thisPos, pConfig);
                        thisPos = thisPos.above();
                    }
                } else {
                    placeLog(pLevel, pBlockSetter, pRandom, thisPos, pConfig);
                    thisPos = thisPos.above();
                }
            }
            endPos = thisPos;
            thisPos = thisPos.relative(pDirection);
        }

        return new FoliagePlacer.FoliageAttachment(endPos.offset(0, +1, 0), 0, false);
    }

    protected boolean placeFibrousLog(LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> pBlockSetter, BlockPos pPos) {
        if (this.validTreePos(pLevel, pPos)) {
            pBlockSetter.accept(pPos, ModBlocks.FIBROUS_PALM_LOG.get().defaultBlockState());
            return true;
        } else {
            return false;
        }
    }
}
