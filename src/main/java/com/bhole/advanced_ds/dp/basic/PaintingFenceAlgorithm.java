package com.bhole.advanced_ds.dp.basic;

/*
Given a fence with n posts and k colors,
find out the number of ways of painting the fence such that at most 2 adjacent posts have the same color.
Return the module of 10000 of ans as ans can be really big.
 */
public class PaintingFenceAlgorithm {
    private static final int MOD = 10000;

    int numberOfWays(int posts, int colors) {
        if(posts == 0) return 0;
        if(posts == 1) return colors;

        /*
        For posts = 2, we can in two ways, color all same and color different.
         */
        int same = colors;  // There are $colors ways to color 2 posts;
        int diff = colors * (colors -1); // If you color first post with one color you have colors-1  ways to color next post
        int total = same + diff;
        total = total % MOD;

        for (int i=3; i<=posts; i++) {
            same  = diff;   //  Previous diff is same because, to calculate same color possibilities,
             // only options what we have is previous color should be diff, else there will be 3 same colors consecutively.
            diff = total * (colors-1); // new diff, colors-1 possibilities for previous total, all we need to do is when we add new block, color is diff than last color in previous post.
            diff = diff % MOD;
            total = (same + diff) % MOD;
        }

        return total;
    }
}
