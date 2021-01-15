package com.bhole.advanced_ds.dp.medium;

import com.bhole.advanced_ds.random.medium.Tuple;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubArraySum {

    /*
    Return start and end index tuple of continuous sub array sum
     */
    public Tuple continuousSubArraySum(int[] nums, int sum) {
        if (nums.length == 0) return new Tuple(-1,-1);
        Map<Integer, Integer> map = new HashMap<>();
        int curSum = 0;
        int minLength = nums.length;
        int start = -1, end =-1;
        for (int i=0; i<nums.length; i++) {
            curSum+=nums[i];
            if (curSum-sum == 0) {
                if (i+1 < minLength) {
                    start = 0;
                    end = i;
                    minLength = end-start+1;
                }
            }
            if (map.containsKey(curSum-sum)) {
                int index = map.get(curSum-sum)+1;
                if (i-index+1 < minLength) {
                    start = index;
                    end = i;
                    minLength = end-start+1;
                }
            }
            map.put(curSum, i);
        }
        return new Tuple(start,end);
    }

    public static void main(String args[]) {
        ContinuousSubArraySum subArraySum  = new ContinuousSubArraySum();
        int arr[] = {3,1,4,2, 7};
        System.out.println(subArraySum.continuousSubArraySum(arr, 7));;
    }
}
