package com.bhole.advanced_ds.dp.basic;

/*
Find maximum length Snake sequence:
Given a grid of numbers, find maximum length Snake sequence and print it. If multiple snake sequences exists with the maximum length, print any one of them.

A snake sequence is made up of adjacent numbers in the grid such that for each number, the number on the right or the number below it is +1 or -1 its value. For example, if you are at location (x, y) in the grid, you can either move right i.e. (x, y+1) if that number is ± 1 or move down i.e. (x+1, y) if that number is ± 1.
For example,
9, 6, 5, 2
8, 7, 6, 5
7, 3, 1, 6
1, 1, 1, 7
In above grid, the longest snake sequence is: (9, 8, 7, 6, 5, 6, 7)
 */
public class MaxLengthSnakeSequence {
    public int getMaxLength(int grid[][]) {
        int rows = grid.length;
        if(rows==0) return 0;
        int cols = grid[0].length;
        if(cols==0) return 0;
        int dp[][] = new int[rows][cols];
        int maxSeq = Integer.MIN_VALUE;

        /*
         We need to follow right bottom up approach and start solving sub problems from dp[rows][cols];
         For given i and j, if right or bottom neighbor has abs diff of 1 then  add 1 to dp of corresponding neighbor and store it.
         Keep solving from last row last col to column wise, you will end at 0,0.
         Meanwhile solving, also store the maxSeq that you encountered in the process.
         */
        for (int j=cols-1; j>=0; j--) { // Column wise traversal, thus this out loop
            for (int i=rows-1; i>=0; i--) { // Bottom up
                dp[i][j] = 1; // Default Value as there will be always seq of 1.
                if (j==cols-1 && (i+1) < rows) {  // case for last col.
                    if (Math.abs(grid[i+1][j] - grid[i][j]) == 1) {
                        dp[i][j] = Math.max(1 + dp[i+1][j], dp[i][j]);
                    }
                }
                if ((j+1) < cols) { // case for rest matrix except last col
                    if (Math.abs(grid[i][j+1] - grid[i][j]) == 1) {
                        dp[i][j] = Math.max(1 + dp[i][j+1], dp[i][j]);
                    }
                }
                if ((i+1) < rows) { // case for rest matrix except last row
                    if (Math.abs(grid[i+1][j] - grid[i][j]) == 1) {
                        dp[i][j] = Math.max(1 + dp[i+1][j], dp[i][j]);
                    }
                }
                maxSeq = Math.max(dp[i][j], maxSeq);
            }
        }
        return maxSeq;
    }
}
