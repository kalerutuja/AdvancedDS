package com.bhole.advanced_ds.dp.basic;

/*
 Ugly number: Whose only facts are prime numbers 2,3,5
 first is 1;
 */
public class UglyNumbers {
    public int getNthUglyNumber(int num) {
        int ugly[] = new int[num];
        ugly[0]=1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        int next2=2, next3=3, next5=5;

        for (int i=1; i<num; i++) {
            int nextUgly = Math.min(next2, Math.min(next3, next5));
            ugly[i] = nextUgly;
            if (nextUgly == next2) {
                index2+=1;
                next2 = ugly[index2] *2;
            }
            if (nextUgly == next3) {
                index3+=1;
                next3 = ugly[index3] *3;
            }
            if (nextUgly == next5) {
                index5+=1;
                next5 = ugly[index5] *5;
            }
        }
        return ugly[num-1];
    }
}