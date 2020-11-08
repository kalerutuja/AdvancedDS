package com.bhole.advanced_ds.rmq;

import java.util.Arrays;

/*

 */
public class SquareRootDecomposition {
    int input[];
    int blockResult[];
    int blockSize;

    public void build(int input[]) {
        this.input = input;
        if (input!=null && input.length > 0) {
            this.blockSize =  (int) Math.floor(Math.sqrt(input.length));
            this.blockResult = new int[input.length/blockSize];

            int i =0;
            int blockIndex = 0;
            while (i+blockSize < input.length) {
                int min = Integer.MAX_VALUE;
                for (int index = i; index < (i+blockSize) ; index++) {
                    if(input[index] < min) {
                        min = input[index];
                    }
                }
                blockResult[blockIndex] = min;
                blockIndex++;
                i = i + blockSize;
            }
        }
        System.out.println(Arrays.toString(this.blockResult));
    }


    public int queryMinimum(int low, int high) {
        if (low<0 || high<0 || high>=input.length || low>=input.length || low>high ) {
            throw  new IllegalArgumentException(String.format("Invalid index low high index low=%s,high=%s", low, high));
        }
        int start = low;
        //1. cover partial block Overlapping
        //2. go through complete overlapping blocks
        //3. cover end partial overlapping
        int min = Integer.MAX_VALUE;
        while (start>0 && (start % this.blockSize) !=0 && start < high) {
            min = Math.min(input[start], min);
            start+=1;
        }
        while (start <= high) {
            int blockIndex = start / this.blockSize;
            min = Math.min(this.blockResult[blockIndex], min);
            start = start+this.blockSize;
        }
        while (start<=high) {
            min = Math.min(input[start], min);
            start+=1;
        }
        return min;
    }

}
