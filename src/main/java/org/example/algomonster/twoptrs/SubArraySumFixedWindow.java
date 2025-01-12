package org.example.algomonster.twoptrs;

/**
 * Given an array (list) nums consisted of only non-negative integers, find the largest sum among all subarrays of length k in nums.
 *
 * For example, if the input is nums = [1, 2, 3, 7, 4, 1], k = 3, then the output would be 14 as the largest length 3 subarray sum is given by [3, 7, 4] which sums to 14.
 */
public class SubArraySumFixedWindow {

    public static int subArraySumFixedWindow(int[] arr, int k) {
        int windowSum = 0;
        for(int i=0; i<k; i++) {
            windowSum += arr[i];
        }
        for(int right=k; right<arr.length; ++right) {
            int itrSum = windowSum;
            int left = right - k;
            itrSum -= arr[left];
            itrSum += arr[right];
            windowSum = Math.max(windowSum, itrSum);
        }
        return windowSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 7, 4, 1};
        System.out.println(subArraySumFixedWindow(arr, 3));
    }
}
