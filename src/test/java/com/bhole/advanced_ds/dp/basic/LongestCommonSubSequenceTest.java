package com.bhole.advanced_ds.dp.basic;

import org.junit.Assert;
import org.junit.Test;

public class LongestCommonSubSequenceTest {
    @Test
    public void test() {
     LongestCommonSubSequence commonSubSequence = new LongestCommonSubSequence();
     Assert.assertEquals(commonSubSequence.getLCS("AXYT", "AYZX"), 2);
     Assert.assertEquals(commonSubSequence.getLCS("AXYT", "AYZT"), 3);
     Assert.assertEquals(commonSubSequence.getLCS("ABCDGH", "AEDFHR"), 3);
    }
}
