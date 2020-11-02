package com.bhole.advanced_ds.rmq;

/*
    Construct segment tree with TreeNode as storage and get the Range minimum query result in log(n).
    query Best Case : o(1)
    query Worst Case: log(n)

    query: log (n)
    preprocessing : o(n)
    space: 0(n)
 */
public class SegmentTree {

    TreeNode root = null;
    int input[];

    public TreeNode build(int input[])  {
        this.root = buildSegmentTree(input, 0, input.length-1);
        this.input = input;
        return this.root;
    }

    private int getValue(TreeNode node) {
       return (node == null? Integer.MAX_VALUE: node.value);
    }

    private TreeNode buildSegmentTree(int input[], int low, int high)  {
        if (low < 0 || high >= input.length) return null;
        TreeNode node = new TreeNode();
        if (low == high) {
           node.value = input[low];
           return node;
        }
        int mid = (low+high)/2;
        node.left = buildSegmentTree(input, low, mid);
        node.right = buildSegmentTree(input, mid+1, high);

        node.value  = Math.min(getValue(node.left), getValue(node.right));
        return node;
    }


    public int rangeMinimumQuery(int queryLow, int queryHigh) {
        return rmq(this.root, Range.of(0, this.input.length-1), Range.of(queryLow, queryHigh));
    }

    private Integer rmq(TreeNode root , Range bounds, Range query) {
        if (query == null || root == null) return Integer.MAX_VALUE;
        // q: 2,3
        // b: 3,3
        // b: 2,2
        if (bounds.low == query.low && bounds.high <=query.high) {
            return root.value;
        }
        if(query.high  == bounds.high && query.low<= bounds.low) return root.value;

        if (bounds.includes(query)) {
            int mid = bounds.getMid();
            Integer leftMin = rmq(root.left, Range.of(bounds.low, mid),  query);
            Integer rightMin = rmq(root.right, Range.of(mid+1,bounds.high), query);
            return Math.min(leftMin, rightMin);
        }
        return Integer.MAX_VALUE;
    }

}
