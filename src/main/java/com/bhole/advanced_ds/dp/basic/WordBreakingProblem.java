package com.bhole.advanced_ds.dp.basic;

import java.util.List;

//WIP
public class WordBreakingProblem {
    /*
    given string and dictionary, find out if the string can be broken down into words in dictionary.
    For example: Iamace, dictionary: {I, am, ace}
    This problem can be solved using DP, rows: str len N, col: str len N;
    We only fill upper diagonal metrix, with length of words from 1 to Str Len N.
    for all diagonals  i,i, we check if the there is word string at i in dictionary,
    for each word length,
        we do partitioning and check if the subproblem from i to k-1, and k to j is exists,
            if exists then make current as true
            else move on to next partitioning.

     */

    public boolean solve(String str, List<String> dictionary) {
        if (str == null || dictionary.isEmpty()) return false;
        str = str.trim().toLowerCase();
        if (str.length() == 0) return false;
        boolean dp[][] = new boolean[str.length()][str.length()];
        for (int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            dp[i][i] = dictionary.stream().anyMatch(word-> word.startsWith(""+c)); //can be replaced with TRIE Log N lookup
        }
        for (int len=2; len<=str.length(); len++) {
            for (int i=0; i<str.length()-len; i++) {
                int j= i+len-1;
                String word = str.substring(i, j+1);
                System.out.println(String.format("Len: %d, word=%s, i=%d, j=%d", len, word, i, j));
                if (dictionary.contains(word)) {
                    dp[i][j] = true;
                    continue;
                }
                for (int k=i+1; k<=j; k++) {
                    System.out.println(String.format("Len: %d, i=%d, k=%d, j=%d", len,i,k,j));
                    if (dp[i][k-1] && dp[k][j]) {
                        dp[i][j] = true;
                        continue;
                    }
                }
            }
        }
        return dp[0][str.length()-1];
    }
}
