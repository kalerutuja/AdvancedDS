package com.bhole.advanced_ds.dp.basic;

import org.junit.Assert;
import org.junit.Test;

public class CoinChangeTest {
    @Test
    public void test() {
        CoinChange coinChange = new CoinChange();
        int coins[] = {2,5,3,6};
        Assert.assertEquals(coinChange.getNumberOfWays(10, coins), 5);
    }
}
