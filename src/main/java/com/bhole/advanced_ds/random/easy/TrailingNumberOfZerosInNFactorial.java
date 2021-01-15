package com.bhole.advanced_ds.random.easy;

public class TrailingNumberOfZerosInNFactorial {
    /*
      Given an integer n, return the number of trailing zeroes in n!.
      idea is count the number of 5 s any i from 0 to n.
      that count would be trailing zeros;
     */
    public int trailingZeroes(int n) {
        int count = 0;
        for (int i=1; i<=n; i++) {
            int num = i;
            while (num>0) {
                if (num>=5 && num%5==0) {
                    System.out.print(", "+i);
                    count+=1;
                    num = num/5;
                } else {
                    num = 0;
                }
            }

        }
        return count;
    }
    public static void main(String args[]) {
        TrailingNumberOfZerosInNFactorial zerosInNFactorial = new TrailingNumberOfZerosInNFactorial();
        System.out.println(zerosInNFactorial.trailingZeroes(30));
    }
}
