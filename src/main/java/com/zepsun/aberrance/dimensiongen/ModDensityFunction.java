package com.zepsun.aberrance.dimensiongen;

import net.minecraft.util.KeyDispatchDataCodec;
import net.minecraft.world.level.levelgen.DensityFunction;

public class ModDensityFunction {

    public static DensityFunction densityFunction = new DensityFunction() {
        @Override
        public double compute(FunctionContext pContext) {
            return 0;
        }

        @Override
        public void fillArray(double[] pArray, ContextProvider pContextProvider) {

        }

        @Override
        public DensityFunction mapAll(Visitor pVisitor) {
            return null;
        }

        @Override
        public double minValue() {
            return 0;
        }

        @Override
        public double maxValue() {
            return 0;
        }

        @Override
        public KeyDispatchDataCodec<? extends DensityFunction> codec() {
            return null;
        }
    };
}
