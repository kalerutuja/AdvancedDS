package com.bhole.advanced_ds.dp.basic;

import org.junit.Assert;
import org.junit.Test;

public class MatrixChainMultiplicationTest {
    @Test
    public void test() {
        MatrixChainMultiplication matrixChain  = new MatrixChainMultiplication();
        Assert.assertEquals(matrixChain.solve(new int[]{40, 20, 30, 10, 30}), 26000);

    }
}

