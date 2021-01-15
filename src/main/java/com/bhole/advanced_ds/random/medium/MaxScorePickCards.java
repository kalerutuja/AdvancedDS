package com.bhole.advanced_ds.random.medium;

import java.util.HashMap;

public class MaxScorePickCards {
    HashMap<Key, Integer> map = new HashMap<Key, Integer>();
    int[] cardPoints;
    public int maxScore(int[] cardPoints, int k) {
        this.cardPoints = cardPoints;
        //return recurse(k, 0, cardPoints.length-1);
        return findSwOpt(cardPoints, k);
    }

    private int recurse( int k, int start, int end) {
        if(k<=0 || start>end || start>=cardPoints.length || end<0) return 0;
        Key key = new Key(k, start, end);
        if (map.containsKey(key)) {
           return map.get(key);
        }
        System.out.println(String.format("(%d, %d, %d)", k, start, end));
        int case1 = cardPoints[start] + recurse( k-1, start+1, end);
        int case2 = cardPoints[end] + recurse(k-1, start, end-1);
        int max = Math.max(case1, case2);
        map.put(key, max);
        return max;
    }

    class Key {
        int k , start, end;
        public Key( int k, int start, int end) {
            this.k = k;
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String args[]) {
        MaxScorePickCards maxScorePickCards = new MaxScorePickCards();
        int res= maxScorePickCards.maxScore(new int[] {
                53,14,91,35,51,9,80,27,6,15,77,86,34,62,55,45,91,45,23,75,66,42,62,13,34,18,89,67,93,83,100,14,92,73,48,2,47,93,99,100,88,84,48
        }, 43);
        System.out.println(res);
        System.out.println(maxScorePickCards.maxScore(new int[]{9,7,7,9,7,7,9},7));

    }
    private int findSw(int arr[], int k) {
        int size = arr.length;
        int max = Integer.MIN_VALUE;
        for (int w=0; w<=k; w++) {
            int leftSum =0, rightSum=0;
            for (int l=0; l< k-w; l++) {
                leftSum+=arr[l];
            }
            for (int r=size-w; r<size; r++) {
                rightSum+=arr[r];
            }
            max = Math.max(max, leftSum+rightSum);
        }
        return max;
    }

    private int findSwOpt(int arr[], int k) {
        int size = arr.length;
        int max = Integer.MIN_VALUE;
        int leftSum =0, rightSum=0;
        for (int l=0; l< k; l++) {
            leftSum+=arr[l];
        }
        if (k>=arr.length) {
            return leftSum;
        }

        for (int w=0; w<=k; w++) {
            max = Math.max(max, leftSum+rightSum);
            if (k-1-w>=0) {
                leftSum = leftSum-arr[k-1-w];
            }
            rightSum +=arr[size-1-w];
        }
        return max;
    }

    /*
        Input: cardPoints = [9,7,7,9,7,7,9], k = 7
        Output: 55
     */
}
