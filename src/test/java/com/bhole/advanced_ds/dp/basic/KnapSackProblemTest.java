package com.bhole.advanced_ds.dp.basic;

import org.junit.Assert;
import org.junit.Test;

public class KnapSackProblemTest {
    @Test
    public void test() {
        KnapSackProblem knapSackProblem = new KnapSackProblem();
        Assert.assertEquals(knapSackProblem.solve(new int[]{1, 2, 3}, new int[]{10, 15, 40}, 6), 65);
    }
}
