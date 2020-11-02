package com.bhole.advance_ds.rmq;

import com.bhole.advanced_ds.rmq.SquareRootDecomposition;
import org.junit.Assert;
import org.junit.Test;

public class SquareRootDecompositionTest {

    @Test
    public void sqrtTest() {
        SquareRootDecomposition squareRootDecomposition = new SquareRootDecomposition();
        int input[] = {4,6,1,5,7,3,2};
        squareRootDecomposition.build(input);
        Assert.assertEquals(squareRootDecomposition.queryMinimum(0,4), 1);
        Assert.assertEquals(squareRootDecomposition.queryMinimum(0,5), 1);
        Assert.assertEquals(squareRootDecomposition.queryMinimum(2,5), 1);
        Assert.assertEquals(squareRootDecomposition.queryMinimum(3,5), 3);
    }
}
