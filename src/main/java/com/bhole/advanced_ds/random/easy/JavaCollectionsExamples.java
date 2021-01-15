package com.bhole.advanced_ds.random.easy;

import java.util.*;

public class JavaCollectionsExamples {
    public void treeSet() {
        /*
        log n insertion, o(n logn) to sort
        Not a threadsafe.
        */
        Set<CustomNode> set = new TreeSet<CustomNode>(new Comparator<CustomNode>() {
            @Override
            public int compare(CustomNode customNode, CustomNode t1) {
                return customNode.val-t1.val;
            }
        });

        set.add(new CustomNode(10));
        set.add(new CustomNode(7));
        set.add(new CustomNode(20));

        set.stream().forEach(System.out::println);
    }

    public void treeMap() {
        // Log n operations like contains,add,remove, sorted map base on keys
        TreeMap<CustomNode, Integer> treeMap = new TreeMap<>(new Comparator<CustomNode>() {
            @Override
            public int compare(CustomNode customNode, CustomNode t1) {
                return customNode.val-t1.val;
            }
        });

        treeMap.put(new CustomNode(10), 10);
        treeMap.put(new CustomNode(7), 7);
        treeMap.put(new CustomNode(20), 20);
        java.util.Map.Entry<CustomNode, Integer> entry = treeMap.pollFirstEntry();
        System.out.println(entry);
    };

    public void linkedHashSet() {
        // maintains the order of inserted elements
        Set<CustomNode> set = new LinkedHashSet();
    }


    class CustomNode {
        int val;
        public CustomNode(int val) {
            this.val = val;
        }
        @Override
        public String toString() {
            return "("+val+")";
        }
    }

    public static void main(String args[]) {
        JavaCollectionsExamples examples = new JavaCollectionsExamples();
        //examples.treeSet();
        examples.treeMap();
    }
}
