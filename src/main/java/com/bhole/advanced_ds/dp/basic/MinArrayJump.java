package com.bhole.advanced_ds.dp.basic;

public class MinArrayJump {

    /*
     DP works in way by traversing the subproblems from end to start.
     dp[i] = min jump required to reach end from i.
     Starts with base case dp[end] = 0;
     we iterate i from end-1 to start;
        on every i, if possible jump >0 then
             try all j jump and minimize dp[j]
          set dp[i] = dp[j]+1;
        if jump is not possible at i, set dp[i] = -1;
     */
    public int solve(int arr[]) {
        if (arr.length==0) return -1;
        int dp[] = new int[arr.length];
        int end= arr.length-1;
        dp[end] = 0;
        for (int i=end-1; i>=0; i--) {
            if (arr[i]>0) {
                int min = Integer.MAX_VALUE;
                for (int k=i+1; k<=(i+arr[i]) && k<=end; k++) {
                    if (dp[k]>=0) {
                        min=Math.min(dp[k], min);
                    }
                }
                dp[i] = 1+min;
            } else {
                dp[i] = -1;
            }
        }
        return dp[0];
    }
    {

    }
}