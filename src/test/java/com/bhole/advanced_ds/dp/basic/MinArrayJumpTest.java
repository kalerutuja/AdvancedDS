package com.bhole.advanced_ds.dp.basic;

import org.junit.Assert;
import org.junit.Test;

public class MinArrayJumpTest {
    @Test
    public void test() {
        MinArrayJump jump = new MinArrayJump();
        Assert.assertEquals(jump.solve(new int[] {2,3,1,1,2,4,2,0,1,1}), 4);
    }
}
