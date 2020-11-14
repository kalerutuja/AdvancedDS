package com.bhole.advanced_ds.dp.basic;

import org.junit.Assert;
import org.junit.Test;

public class EggDroppingPuzzleTest {
    @Test
    public void eggDropTest() {
        EggDroppingPuzzle puzzle = new EggDroppingPuzzle();
        Assert.assertEquals(puzzle.solve(6, 2), 3);
    }
}
