package com.bhole.advanced_ds.dp.basic;

/*
Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.
 */
public class SubSetSum {
    public boolean isSubSetExist(int sum, int set[]) {
        if(set.length==0|| sum<=0) return false;
        boolean dp[][] = new boolean[sum+1][set.length];
        /*
          DP Array[i][j] stores: is subset sum exist for given i sum and up to subset of index j.
          for given i, j = (subset sum exist with considering current sum up to j) || ( copy output from j-1 index of subsets);
         */
        for (int j=0; j<set.length; j++) {
            dp[0][j] = true;
        }
        for(int i=1; i<=sum; i++) {
            for (int j=0; j<set.length; j++) {
                dp[i][j] = false;
                if (j==0) {
                    dp[i][0] = (i == set[0]);
                } else {
                    if ((i-set[j]) >= 0) {
                        dp[i][j] = dp[i-set[j]][j-1] || dp[i][j-1];
                    } else {
                        dp[i][j] = dp[i][j-1];
                    }
                }
            }
        }
        return dp[sum][set.length-1];
    }

    /*
       Check that given set has subset with sum divisible by m.

       set {3, 1, 7, 5}, m=6. Here set contains subset whose sum is divisible by 6.
       Generate the temp array with module of 6, and it will be subsetSum problem.
     */
    public boolean hasSubsetWithSumDivisibleByM(int set[], int m) {
        int temp[] = new int[set.length];
        for (int i=0; i<set.length; i++) {
            temp[i] = set[i]%6;
        }
        return isSubSetExist(m , temp);
    }
}

