package com.bhole.advanced_ds.rmq;

import com.bhole.advanced_ds.rmq.SparseTable;
import org.junit.Assert;
import org.junit.Test;

public class SparseTableTest {

    @Test
    public void testSparseTable() {
        SparseTable sparseTable = new SparseTable();
        int arr[] = {4,6,1,5,7,3};
        sparseTable.build(arr);
        Assert.assertEquals(sparseTable.getMinimum(1,5), 1);
        Assert.assertEquals(sparseTable.getMinimum(3,5), 3);
        Assert.assertEquals(sparseTable.getMinimum(2,4), 1);
    }
}
