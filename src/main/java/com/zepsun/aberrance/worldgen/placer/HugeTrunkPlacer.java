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

public class HugeTrunkPlacer extends TrunkPlacer {
    public static final Codec<HugeTrunkPlacer> CODEC = RecordCodecBuilder.create(hugeTrunkPlacerInstance ->
            trunkPlacerParts(hugeTrunkPlacerInstance).apply(hugeTrunkPlacerInstance, HugeTrunkPlacer::new));

    public HugeTrunkPlacer(int pBaseHeight, int pHeightRandA, int pHeightRandB) {
        super(pBaseHeight, pHeightRandA, pHeightRandB);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return ModTrunkPlacerTypes.HUGE_TRUNK_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> pBlockSetter, RandomSource pRandom,
                                                            int pFreeTreeHeight, BlockPos pPos, TreeConfiguration pConfig) {

        setDirtAt(pLevel, pBlockSetter, pRandom, pPos.below(), pConfig);
        int rawHeight = pRandom.nextInt(heightRandA - 10, heightRandA + 10);
        int height = 5 * (Math.round((float) rawHeight / 5));
        List<FoliagePlacer.FoliageAttachment> foliageAttachmentList = new java.util.ArrayList<>(List.of());

        foliageAttachmentList.add(generateTrunk(pLevel, pBlockSetter, pRandom, pPos, pConfig,height));

        return foliageAttachmentList;
    }

    public FoliagePlacer.FoliageAttachment generateTrunk(LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> pBlockSetter, RandomSource pRandom,
                                                       BlockPos pPos, TreeConfiguration pConfig, int height) {

        int layerHeight = height/5;
        BlockPos endPos = pPos;

        for(int i = 0; i < layerHeight; i++) {

            List<BlockPos> currentList = generateLayer1List(endPos);
            for (BlockPos blockPos : currentList) {
                placeLog(pLevel, pBlockSetter, pRandom, blockPos.above(i), pConfig);
            }
            endPos = pPos.above(i + 1);
        }
        for(int i = 0; i < layerHeight; i++) {

            List<BlockPos> currentList = generateLayer2List(endPos);
            for (BlockPos blockPos : currentList) {
                placeLog(pLevel, pBlockSetter, pRandom, blockPos.above(i), pConfig);
            }
            endPos = pPos.above(i + 1);
        }
        for(int i = 0; i < layerHeight; i++) {

            List<BlockPos> currentList = generateLayer3List(endPos);
            for (BlockPos blockPos : currentList) {
                placeLog(pLevel, pBlockSetter, pRandom, blockPos.above(i), pConfig);
            }
            endPos = pPos.above(i + 1);
        }
        for(int i = 0; i < layerHeight; i++) {

            List<BlockPos> currentList = generateLayer4List(endPos);
            for (BlockPos blockPos : currentList) {
                placeLog(pLevel, pBlockSetter, pRandom, blockPos.above(i), pConfig);
            }
            endPos = pPos.above(i + 1);
        }
        for(int i = 0; i < layerHeight; i++) {

            placeLog(pLevel, pBlockSetter, pRandom, endPos.above(i), pConfig);
            endPos = endPos.above(i);
            endPos = endPos.above();
        }

        return new FoliagePlacer.FoliageAttachment(endPos, 0, false);
    }

    private List<BlockPos> generateLayer1List(BlockPos pPos) {
        List<BlockPos> generatedList = new java.util.ArrayList<>(List.of(pPos));

        generatedList.add(pPos.relative(Direction.NORTH));
        generatedList.add(pPos.relative(Direction.EAST));
        generatedList.add(pPos.relative(Direction.SOUTH));
        generatedList.add(pPos.relative(Direction.WEST));

        generatedList.add(pPos.relative(Direction.NORTH).relative(Direction.EAST));
        generatedList.add(pPos.relative(Direction.SOUTH).relative(Direction.EAST));
        generatedList.add(pPos.relative(Direction.SOUTH).relative(Direction.WEST));
        generatedList.add(pPos.relative(Direction.NORTH).relative(Direction.WEST));

        generatedList.add(pPos.relative(Direction.NORTH, 2));
        generatedList.add(pPos.relative(Direction.NORTH, 2).relative(Direction.EAST));
        generatedList.add(pPos.relative(Direction.NORTH, 2).relative(Direction.WEST));

        generatedList.add(pPos.relative(Direction.EAST, 2));
        generatedList.add(pPos.relative(Direction.EAST, 2).relative(Direction.NORTH));
        generatedList.add(pPos.relative(Direction.EAST, 2).relative(Direction.SOUTH));

        generatedList.add(pPos.relative(Direction.SOUTH, 2));
        generatedList.add(pPos.relative(Direction.SOUTH, 2).relative(Direction.EAST));
        generatedList.add(pPos.relative(Direction.SOUTH, 2).relative(Direction.WEST));

        generatedList.add(pPos.relative(Direction.WEST, 2));
        generatedList.add(pPos.relative(Direction.WEST, 2).relative(Direction.NORTH));
        generatedList.add(pPos.relative(Direction.WEST, 2).relative(Direction.SOUTH));

        return generatedList;
    }

    private List<BlockPos> generateLayer2List(BlockPos pPos) {
        List<BlockPos> generatedList = new java.util.ArrayList<>(List.of(pPos));

        generatedList.add(pPos.relative(Direction.NORTH));
        generatedList.add(pPos.relative(Direction.EAST));
        generatedList.add(pPos.relative(Direction.SOUTH));
        generatedList.add(pPos.relative(Direction.WEST));

        generatedList.add(pPos.relative(Direction.NORTH).relative(Direction.EAST));
        generatedList.add(pPos.relative(Direction.SOUTH).relative(Direction.EAST));
        generatedList.add(pPos.relative(Direction.SOUTH).relative(Direction.WEST));
        generatedList.add(pPos.relative(Direction.NORTH).relative(Direction.WEST));

        generatedList.add(pPos.relative(Direction.NORTH, 2));

        generatedList.add(pPos.relative(Direction.EAST, 2));

        generatedList.add(pPos.relative(Direction.SOUTH, 2));

        generatedList.add(pPos.relative(Direction.WEST, 2));

        return generatedList;
    }

    private List<BlockPos> generateLayer3List(BlockPos pPos) {
        List<BlockPos> generatedList = new java.util.ArrayList<>(List.of(pPos));

        generatedList.add(pPos.relative(Direction.NORTH));
        generatedList.add(pPos.relative(Direction.EAST));
        generatedList.add(pPos.relative(Direction.SOUTH));
        generatedList.add(pPos.relative(Direction.WEST));

        generatedList.add(pPos.relative(Direction.NORTH).relative(Direction.EAST));
        generatedList.add(pPos.relative(Direction.SOUTH).relative(Direction.EAST));
        generatedList.add(pPos.relative(Direction.SOUTH).relative(Direction.WEST));
        generatedList.add(pPos.relative(Direction.NORTH).relative(Direction.WEST));

        return generatedList;
    }

    private List<BlockPos> generateLayer4List(BlockPos pPos) {
        List<BlockPos> generatedList = new java.util.ArrayList<>(List.of(pPos));

        generatedList.add(pPos.relative(Direction.NORTH));
        generatedList.add(pPos.relative(Direction.EAST));
        generatedList.add(pPos.relative(Direction.SOUTH));
        generatedList.add(pPos.relative(Direction.WEST));

        return generatedList;
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
