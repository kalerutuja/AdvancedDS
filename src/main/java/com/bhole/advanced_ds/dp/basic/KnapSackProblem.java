package com.bhole.advanced_ds.dp.basic;

public class KnapSackProblem {
    public int solve(int weights[], int values[], int totalWeight) {
        if (totalWeight<=0 || weights.length==0||values.length ==0) return 0;
        int dp[][] = new int[weights.length][totalWeight+1];
        for (int i=0; i<weights.length; i++) {
            dp[i][0] = 0;
         }

        for (int i=0; i<weights.length; i++) {
            for (int j=1; j<=totalWeight; j++) {
                if (weights[i]<= j) {
                    int weightIncludingItem =  values[i];
                    if (i-1>=0 && (j-weights[i])>=0) {
                        weightIncludingItem = values[i] + dp[i-1][j - weights[i]];
                    }
                    dp[i][j] = Math.max(weightIncludingItem, dp[i][j-1]);
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[weights.length-1][totalWeight];
    }
}
