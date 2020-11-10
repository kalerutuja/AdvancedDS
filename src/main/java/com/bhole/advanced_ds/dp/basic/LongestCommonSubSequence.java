package com.bhole.advanced_ds.dp.basic;

public class LongestCommonSubSequence {

    /*
    LCS recurrence is simple, for given i and j, if letter is equal then dp = 1+ diagonal dp value, else dp = max(top neighbour, left neighbour).
    Idea is fill first top row and first column with 0 so that we dont have to handle array bounds.
     */
    public int getLCS(String str1, String str2) {
        if (str1 == null || str2 == null) return 0;
        if (str1.length() ==0 || str2.length() == 0) return 0;
        str1 = str1.trim().toLowerCase();
        str2 = str2.trim().toLowerCase();

        int dpRows = str1.length()+1;
        int dpCols = str2.length()+1;
        int dp[][] = new int[dpRows][dpCols];

        for (int i=0; i < dpCols; i++) {
            dp[0][i] = 0;
        }
        for (int i=0; i < dpRows; i++) {
            dp[i][0] = 0;
        }
        for (int i=1; i < dpRows; i++) {
            for (int j=1; j < dpCols; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[dpRows-1][dpCols-1];
    }
}
