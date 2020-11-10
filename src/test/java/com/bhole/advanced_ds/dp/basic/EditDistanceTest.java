package com.bhole.advanced_ds.dp.basic;

import org.junit.Assert;
import org.junit.Test;

public class EditDistanceTest {
    @Test
    public void test() {
        EditDistance distance = new EditDistance();
        Assert.assertEquals(distance.getDist("sunday", "saturday"), 3);
    }
}
