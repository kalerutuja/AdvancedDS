package com.bhole.advanced_ds.dp.basic;

public class EditDistance {
    public int getDist(String str1, String str2) {
        if (str1 == null || str2 == null) return 0;
        str1 = str1.trim().toLowerCase();
        str2 = str2.trim().toLowerCase();
        int dp[][] = new int[str1.length()+1][str2.length()+1];
        for (int i=0; i<=str1.length(); i++) {
            dp[i][0] = 0;
        }
        for (int i=0; i<=str2.length(); i++) {
            dp[0][i] = 0;
        }

        for (int i=1; i<=str1.length(); i++) {
            for (int j=1; j<=str2.length(); j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    if (i == 1) {
                        dp[i][j] = 1 + dp[i][j-1];
                    } else
                    if (j == 1) {
                        dp[i][j] = 1 + dp[i-1][j];
                    } else {
                        dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
                    }
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }
}
