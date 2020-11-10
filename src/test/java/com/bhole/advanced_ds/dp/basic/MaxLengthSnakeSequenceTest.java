package com.bhole.advanced_ds.dp.basic;

import org.junit.Assert;
import org.junit.Test;

public class MaxLengthSnakeSequenceTest {
    @Test
    public void test() {
        MaxLengthSnakeSequence snakeSequence = new MaxLengthSnakeSequence();
        int grid [][]  = {
                {9, 6, 5, 2},
                {8, 7, 6, 5},
                {7, 3, 1, 6},
                {1, 1, 1, 7}
        };

        Assert.assertEquals(snakeSequence.getMaxLength(grid), 7);
    }
}
