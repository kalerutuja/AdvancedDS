package com.bhole.advanced_ds.random.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        Comparator<ListNode> cmp = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode a, ListNode b) {
                return a.val-b.val;
            }
        };
        PriorityQueue<ListNode> pq = new PriorityQueue(lists.length, cmp);
        for (ListNode n: lists) {
            if (n != null) {
                pq.add(n);
            }
        }
        ListNode head = null;
        ListNode cur = null;
        while (!pq.isEmpty()) {
            ListNode n = pq.poll();
            if (cur == null) {
                head = n;
                cur = n;
            } else {
                cur.next = n;
                cur = n;
            }

            if (n.next!=null) {
                pq.add(n.next);
            }
        }

        return head;
    }
}
