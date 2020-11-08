package com.bhole.advanced_ds.dp.basic;

/*
Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins,
 how many ways can we make the change? The order of coins doesn’t matter.
 */
public class CoinChange {
    public int getNumberOfWays(int num, int coins[]) {
        if (num <=0 || coins.length == 0) {
           return 0;
        }
        int dp[][] = new int[num+1][coins.length];
        for (int j=0; j<coins.length; j++) {
            dp[0][j] = 1;
        }
        for(int i=1; i<=num; i++) {
            for (int j=0; j<coins.length; j++) {
                int including  = 0;
                int excluding  = 0;
                if(i-coins[j] >=0) {
                    // include current coin in computation, and get count for remaining amount
                    including = dp[i-coins[j]][j];
                }
                if(j>0) {
                    // exclude current coin in computation, and get count for previous coins set
                    excluding = dp[i][j-1];
                }
                // take sum of both
                dp[i][j]= including + excluding;
            }
        }
        return dp[num][coins.length-1];
    }
}
