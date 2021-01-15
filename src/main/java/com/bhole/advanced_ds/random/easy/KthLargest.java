package com.bhole.advanced_ds.random.easy;

import java.awt.event.KeyAdapter;
import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargest {

    PriorityQueue<Integer> priorityQueue = new PriorityQueue();
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        Arrays.stream(nums).forEach(n-> {
            System.out.println(add(n));
        });
    }

    public int add(int val) {
        priorityQueue.add(val);
        if (priorityQueue.size() > k) {
            priorityQueue.poll();
        }
        return priorityQueue.peek();
    }

    public static void main(String args[]) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4,5,8,2});
        Arrays.stream(new int[]{3,5,10,9,4}).forEach(n-> {
            System.out.println(" : "+kthLargest.add(n));
        });
    }

}
