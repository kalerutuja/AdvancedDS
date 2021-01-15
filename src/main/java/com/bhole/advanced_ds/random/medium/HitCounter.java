package com.bhole.advanced_ds.random.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class HitCounter {

    Queue<Integer> queue;
    /** Initialize your data structure here. */
    public HitCounter() {
        queue= new LinkedList<>();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        queue.add(timestamp);
    }

    private void cleanup(int timestamp) {
        int keep = timestamp-300;
        while (!queue.isEmpty() && queue.peek()<=keep) {
            queue.remove();
        }
    }
    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        cleanup(timestamp);
        return queue.size();
    }

    public static void main(String args[]) {
        HitCounter obj = new HitCounter();
        obj.hit(1);
        obj.hit(2);
        obj.hit(3);
        System.out.println(obj.getHits(4));
        obj.hit(300);
        System.out.println(obj.getHits(300));
        System.out.println(obj.getHits(301));
    }
}
