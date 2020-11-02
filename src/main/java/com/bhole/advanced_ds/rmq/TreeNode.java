package com.bhole.advanced_ds.rmq;

import java.util.Objects;

public class TreeNode {
    Integer value;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

}
class Range {
    int low;
    int high;
    public Range(int low, int high) {
        this.low = low;
        this.high = high;
    }

    public static Range of(int low, int high) {
        return new Range(low, high);
    }

    public Integer getMid() {
        return (this.low+this.high)/2;
    }

    /*
        this: 2, 5
         query: 4,8 (overlap from high end)
         query: 3,4 (locates in between)
         query: 1,0 (overlap from low)
     */
    public boolean includes(Range query) {
        if(query.low > query.high ) return false;
        if(this.low <= query.low && query.low <= this.high) {
            return true;
        }
        if(this.high >= query.high && query.low >= this.low) {
            return true;
        }
        if(this.low >= query.low && query.high>= this.low) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Range range = (Range) o;
        return low == range.low &&
                high == range.high;
    }

    @Override
    public int hashCode() {
        return Objects.hash(low, high);
    }

    @Override
    public String toString() {
        return "Range{" +
                "low=" + low +
                ", high=" + high +
                '}';
    }
}