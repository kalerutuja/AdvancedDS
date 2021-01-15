package com.bhole.advanced_ds.random.easy;

public class PrimePermutations {
    public int numPrimeArrangements(int n) {
        if (n<=0) return 0;
        if (n==1) return 1;
        int mod = (int)Math.pow(10,9) +7;
        System.out.println("num="+n);
        boolean primes[] = new boolean[n+1];
        int c=0;
        for (int i=2; i<=n; i++) {
            if (primes[i] == false) {
                c++;
                System.out.println(i+" is prime, count="+c);
                for (int k=2; (k*i)<=n; k++) {
                    primes[k*i] = true;
                }
            }
        }

        long pm = 1;
        int primeCount = c;
        int nonPrimeCount = (n-c);
        System.out.println(String.format("primeCount=%d, n=%d, nonPrimeCount=%d, c=%d",primeCount, n, nonPrimeCount, c));

        for (int i=1; i<=n; i++) {
            if (primes[i]==false) {
                if(primeCount>0) pm = pm*primeCount;
                primeCount--;
            } else {
                if (nonPrimeCount>0) pm=pm*nonPrimeCount;
                nonPrimeCount--;
            }
            System.out.println(pm);
            pm=pm%mod;
        }
        return (int)pm;
    }
    public static void main(String args[]) {
        PrimePermutations primePermutations = new PrimePermutations();
        System.out.println(primePermutations.numPrimeArrangements(100));
        double m = 10/0;
    }

}
