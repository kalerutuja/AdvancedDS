package com.bhole.advanced_ds.dp.basic;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class WordBreakingProblemTest {
    @Test
    public void test() {
        WordBreakingProblem problem = new WordBreakingProblem();
        Assert.assertEquals(problem.solve("iamace", List.of("i", "am", "ace")), true);
    }
}
