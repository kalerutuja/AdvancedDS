package com.bhole.advanced_ds.dp.basic;

public class RodCutting {
    /*
    length   | 1   2   3   4   5   6   7   8
    --------------------------------------------
    price    | 1   5   8   9  10  17  17  20

    Recursive approach of rod cutting with memoized version has exponential complexity and can run out of stack.
    Better approach is store subproblems in 2d array.
    Row denotes piece lengths, Column has 0 to N available length.
    It works on traversing from top left to bottom right, and store the max of current+subproblems, subproblem of previous piece with same col length.
     */

    public int solve(int price[], int n) {
        if(price.length ==0) return 0;
        int dp[][] = new int[price.length][n+1];
        for (int i=1; i<price.length; i++) {
            for (int j=1; j<=n; j++) {
                if (i > j) {
                    dp[i][j] = dp[i-1][j];
                 } else {
                   dp[i][j]  = Math.max(dp[i][j-i] + price[i], dp[i-1][j]);
                }
            }
        }
        return dp[price.length-1][n];
    }

}
