package com.bhole.advanced_ds.dp.basic;

import org.junit.Assert;
import org.junit.Test;

public class SubSetSumTest {

    @Test
    public void test() {
        SubSetSum subSetSum = new SubSetSum();
        int set[] = {3, 34, 4, 12, 5, 2};
        Assert.assertEquals(subSetSum.isSubSetExist(9, set), true);
    }

    @Test
    public void testDivisibleByM() {
        SubSetSum subSetSum = new SubSetSum();
        int set[] = {3, 1, 7, 5};
        Assert.assertEquals(subSetSum.hasSubsetWithSumDivisibleByM(set, 6), true);
    }
}
