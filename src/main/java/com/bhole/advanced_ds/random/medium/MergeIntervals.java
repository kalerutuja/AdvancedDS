package com.bhole.advanced_ds.random.medium;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][];
        }
        int len = intervals.length;
        List<Pair> arr = Arrays.stream(intervals).map(Pair::new).collect(Collectors.toList());

        Map<Integer, Pair> map = Arrays.stream(intervals).map(Pair::new).collect(Collectors.toMap(Pair::hashCode, p-> p));

        arr.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair pair, Pair t1) {
                return pair.e - t1.e;
            }
        });
        Pair prev = arr.get(len-1);
        List<Pair> res = new ArrayList<>();
        for (int i=len-2; i>=0; i--) {
            Pair cur = arr.get(i);
            if (includes(cur, prev)) {
                prev = cur.merge(prev);
            }
            else {
                res.add(prev);
                prev = cur;
            }
        }
        res.add(prev);
        int arrRes[][] = res.stream().map(Pair::toArr).toArray(int[][]::new);
        return arrRes;
    }

    private boolean includes(Pair a, Pair b) {
        if (b.s <= a.e && a.s <= b.s) {
            return true;
        }
        if (a.equals(b)) {
            return true;
        }
        if(a.e == b.e) return true;
        if(a.e<= b.e && b.s<= a.s) return true;
        return false;
    }

    class Pair {
        int s;
        int e;
        public Pair () {

        }
        public Pair (int a[]) {
            this.s = a[0];
            this.e = a[1];
        }
        public int[] toArr() {
            int arr[] = new int[2];
            arr[0] = s;
            arr[1] = e;
            return arr;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return s == pair.s &&
                    e == pair.e;
        }

        @Override
        public int hashCode() {
            return Objects.hash(s, e);
        }
        public Pair merge(Pair b) {
            Pair res = new Pair();
            res.s = Math.min(this.s, b.s);
            res.e = Math.max(this.e, b.e);
            return res;
        }
    }

    public static void main(String args[]) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        int arr[][] = {{1,2}, {1,3}, {4,5}};
        Arrays.stream(mergeIntervals.merge(arr)).forEach(p-> {
            System.out.println(Arrays.toString(p));
        });

    }
}
