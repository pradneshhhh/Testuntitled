package org.example.algomonster.twoptrs;

import java.util.List;

/**
 * Given an array of integers sorted in ascending order, find two numbers that add up to a given target. Return the indices of the two numbers in ascending order. You can assume elements in the array are unique and there is only one solution. Do this in O(n) time and with constant auxiliary space.
 *
 * Input:
 *
 * arr: a sorted integer array
 * target: the target sum we want to reach
 * Sample Input: [2, 3, 4, 5, 8, 11, 18], 8
 *
 * Sample Output: 1 3
 */
public class TwoSumSorted {

    public static List<Integer> twoSumSorted(int[] arr, int target) {
        int left = 0;
        int right = arr.length-1;
        for(int i=arr.length-1; i>=0; i--){
            int sum = arr[left]+arr[right];
            if(sum == target) {
                return List.of(left, right);
            } else if(sum > target) {
                right -= 1;
            } else {
                left += 1;
            }
        }
        return List.of();
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 8, 11, 18};
        System.out.println(twoSumSorted(arr, 8));
    }
}
