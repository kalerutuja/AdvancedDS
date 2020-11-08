package com.bhole.advanced_ds.dp.basic;

import org.junit.Assert;
import org.junit.Test;

public class PaintingFenceAlgorithmTest {

    @Test
    public void testAlgorithm() {
        PaintingFenceAlgorithm algorithm = new PaintingFenceAlgorithm();

        Assert.assertEquals(algorithm.numberOfWays(2, 2), 4);
        Assert.assertEquals(algorithm.numberOfWays(2, 3), 9);
        Assert.assertEquals(algorithm.numberOfWays(3, 2), 6);
        Assert.assertEquals(algorithm.numberOfWays(2, 10), 100);
    }
}
