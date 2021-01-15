package com.bhole.advanced_ds.random.medium;

import java.util.HashSet;
import java.util.Set;

/*
Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.

Notice that you can not jump outside of the array at any time.

Input: arr = [4,2,3,0,3,1,2], start = 5

Simple DFS
 */
public class MinJumpToZerothIndexInArray {
    Set<Integer> visited = new HashSet<>();

    public boolean canReach(int[] arr, int start) {
        int size = arr.length;
        if (size==0) return false;
        if (start < 0 || start >= arr.length) return false;
        if(arr[start] == 0) return true;
        System.out.println("Start="+start);

        if (visited.contains(start)) {
           return false;
        }
        visited.add(start);
        int leftStart = start-arr[start];
        boolean moveLeft = false;
        if (leftStart >= 0) {
            moveLeft = canReach(arr, leftStart);
        }
        int rightStart = start+arr[start];
        boolean moveRight = false;
        if (rightStart >= 0) {
            moveRight = canReach(arr, rightStart);
        }

        return moveRight || moveLeft;
    }

    public static void main(String args[]) {
        MinJumpToZerothIndexInArray minJumpToZerothIndexInArray = new MinJumpToZerothIndexInArray();
        //int arr[] = {4,2,3,0,3,1,2};
        int arr[] = {3,0,2,1,2};
        System.out.println(minJumpToZerothIndexInArray.canReach(arr, 2));
    }
}
