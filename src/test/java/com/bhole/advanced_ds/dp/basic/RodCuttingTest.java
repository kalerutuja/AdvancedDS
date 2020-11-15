package com.bhole.advanced_ds.dp.basic;

import org.junit.Assert;
import org.junit.Test;

public class RodCuttingTest {
    @Test
    public void test() {
        RodCutting rodCutting = new RodCutting();
        Assert.assertEquals(rodCutting.solve(new int[]{0, 1, 5, 8, 9, 10, 17}, 8), 22);
    }
}
