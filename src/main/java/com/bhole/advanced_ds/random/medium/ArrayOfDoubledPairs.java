package com.bhole.advanced_ds.random.medium;

import java.util.Arrays;

public class ArrayOfDoubledPairs {

    public boolean canReorderDoubled(int[] A) {
        Arrays.sort(A);
        System.out.println(Arrays.toString(A));
        boolean visited[] = new boolean[A.length];

        for (int i=0; i < A.length; i++) {
            if (visited[i] == false) {
                int small = A[i];
                visited[i] = true;
                int lookupValue = small*2;
                if (small < 0) {
                    if (small%2 !=0) {
                        return false;
                    }
                    lookupValue = small/2;
                }
                int index = Arrays.binarySearch(A,i+1, A.length, lookupValue);
                System.out.println("i="+i+", index="+index);
                if (index > 0) {
                    int nonVisitedIndex = linSearch(A, visited, lookupValue, index);
                    if(nonVisitedIndex> 0) {
                        visited[nonVisitedIndex] = true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }

        for(int i=0; i<visited.length; i++) {
            if(!visited[i]) {
                return false;
            }
        }
        return true;
    }

    int search(int arr[], boolean visited[], int ele, int start, int end)  {
        for(int i=start; i<=end; i++) {
            if (visited[i] == false && arr[i] == ele) {
                return i;
            }
        }
        return -1;
    }

    int linSearch(int arr[], boolean visited[], int ele, int mid) {
        for (int i=mid; i<arr.length && arr[i] == ele; i++) {
            if(!visited[i]) {
                return i;
            }
        }
        for (int i=mid; i>=0 && arr[i] == ele; i--) {
            if(!visited[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        int arr[] = {1,2,1,-8,8,-4,4,-4,2,-2};
        ArrayOfDoubledPairs pairs = new ArrayOfDoubledPairs();
        pairs.canReorderDoubled(arr);
    }
}
