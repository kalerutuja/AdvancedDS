package com.bhole.advance_ds.rmq;

import com.bhole.advanced_ds.rmq.SegmentTree;
import com.bhole.advanced_ds.rmq.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class SegmentTreeTest {

    @Test
    public void testBuildSegmentTree() {
        SegmentTree segmentTree = new SegmentTree();
        int input[] = {8,7,3,20,2,17};
        TreeNode root = segmentTree.build(input);
        System.out.println(root);
        Assert.assertEquals(segmentTree.rangeMinimumQuery(2,3), 3);
        Assert.assertEquals(segmentTree.rangeMinimumQuery(1,4), 2);
        Assert.assertEquals(segmentTree.rangeMinimumQuery(0,5), 2);
        Assert.assertEquals(segmentTree.rangeMinimumQuery(3,5), 2);
    }
}
