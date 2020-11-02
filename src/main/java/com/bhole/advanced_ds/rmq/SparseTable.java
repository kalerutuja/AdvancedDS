package com.bhole.advanced_ds.rmq;

import java.util.Arrays;

/*
 Preprocess given array to address get minimum from low to high queries in o(1).
 query time: o(1)
 preprocessing time : o(n logn)
 space: o(n logn)
 */
public class SparseTable {
    int input[];
    int sparseTable[][];
    int cols;

    public void build(int input[])  {
        this.input = input;
        int cols = (int) Math.floor(Math.log(input.length)/Math.log(2))+1;
        this.cols = cols;
        this.sparseTable = new int[input.length][cols];
        for (int i=0; i<input.length; i++) {
            this.sparseTable[i][0] = input[i];
        }
        for (int j=1; j<cols; j++) {
            for (int i=0; i<input.length; i++) {
                if (i + (1<<(j-1)) < input.length) {
                    int prevLess = this.sparseTable[i + (1<<(j-1))][j-1];
                    // prevLess is calculated by moving to i+ previous power of 2 of j that is (1 << (j-1)).
                    if (this.sparseTable[i][j-1] < prevLess) {
                        this.sparseTable[i][j] =  this.sparseTable[i][j-1];
                    } else {
                        this.sparseTable[i][j] =  prevLess;
                    }
                }
            }
        }

        System.out.println(Arrays.deepToString(this.sparseTable));;
    }

    public int getMinimum(int low, int high) {
        if (low<0 || high<0 || high>=input.length || low>=input.length || low>high ) {
            throw  new IllegalArgumentException(String.format("Invalid index low high index low=%s,high=%s", low, high));
        }
        int diff = high-low+1;
        int j = (int) Math.floor(Math.log(diff)/Math.log(2));
        if (this.sparseTable[low][j] <= this.sparseTable[low + diff - (1<<j)][j]) {
            return this.sparseTable[low][j];
        } else {
            return this.sparseTable[high-(1<<j)+1][j];
        }
    }
}
