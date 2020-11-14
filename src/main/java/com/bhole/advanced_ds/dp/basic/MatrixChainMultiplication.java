package com.bhole.advanced_ds.dp.basic;

public class MatrixChainMultiplication {
    /*
    Find min cost of multiplication of matrix.
    DP solution is amazing,
    it starts with batch interval of length, runs from 2 to max;
    dp[i][i]  diagonal will always be zero as no cost for multiplication with itself.
    for length 0 to 4, it prepares the following batches of i, j, k where i< j < k
        0, 1, 2
        1, 2, 3
        2, 3, 4   // stores min result dp[2][4] matrix multiplication from 2 to 4 index.
        0, 1, 3
        0, 2, 3
        1, 2, 4
        1, 3, 4
        0, 1, 4
        0, 2, 4
        0, 3, 4

        we fill dp of only upper diagonal, and use previously computed results from batches.
        for example batch 0, 1, 4 uses dp[0][1] and dp[1][4] in min computation
     */
    public int solve(int arr[]) {
        int dp[][] = new int[arr.length][arr.length];
        for (int len=2; len < arr.length; len++) {
            for (int i=0; i<(arr.length-len); i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k=i+1; k<j; k++) {
                    System.out.println(String.format("%s, %s, %s", i, k, j));
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + (arr[i] * arr[k] * arr[j]));
                }
            }
        }

        return dp[0][arr.length-1];
    }
}
