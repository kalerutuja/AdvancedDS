package com.bhole.advanced_ds.dp.basic;

public class EggDroppingPuzzle {
    /*
    find out the minimum trials required to find out that egg will break from nth floorss,
        f= number of floors
        k = number of eggs
    Idea is to store sub problems in 2d array, rows(i) = eggs, columns(j) = floors.

    for i eggs, j floor,
     try dropping egg from each floor(k= 1 to j) and minimize number of attempt.
        1 + max ( eggs breaks at floors k sub problem, egg dont break at k sub problem)

    for example dp[2][4]
         minimize the attepts by dropping egg from floor 1 to floor 4.
              1+ max( if egg breaks at 1st floor then dp[1][0] to work with, if egg does not break then we have 3 floors and 2 eggs to work with)
              which is 1 + max(dp[1][0],dp[2][4-1])
     */

    int solve(int floors, int eggs) {
        if (floors <= 0 || eggs <=0) return 0;
        int dp[][] = new int[eggs][floors+1];
        for (int i=0; i<eggs; i++) {
            for (int j=0; j<=floors; j++) {
                if(j==0) {
                  dp[i][0] = 0;
                }
                else if(i==0) {
                    dp[i][j] = 1+ dp[i][j-1];
                } else {
                    int min = Integer.MAX_VALUE;
                    for(int k=1; k<=j; k++) {
                        min = Math.min(min, 1 + Math.max(dp[i-1][k-1], dp[i][j-k]));
                    }
                    dp[i][j] = min;
                }
            }
        }
        return dp[eggs-1][floors];
    }

}
