package org.example.algomonster.twoptrs;

/**
 * Shortest Sliding Window and Prefix Sum
 *
 * Given an array arr[] of integers and a number x, the task is to find the smallest subarray with a sum greater than the given value.
 *
 * arr[] = {1, 4, 45, 6, 0, 19}
 *    x  =  51
 * Output: 3
 * Minimum length subarray is {4, 45, 6}
 */
public class ShortestSubArrWithSumGreaterThanTarget {

    public static int shortestSubArrWithSumGreaterThanTarget(int[] arr, int target) {
        int shortest = Integer.MAX_VALUE;
        int left = 0;
        int[] prefixSum = generatePrefixSumArray(arr);
        for(int right=0; right<arr.length; right++) {
            while(getSumBetweenIndexes(prefixSum, left, right) > target) {
                shortest = Math.min(shortest, right - left + 1);
                left += 1;
            }
        }
        return shortest;
    }

    public static int[] generatePrefixSumArray(int[] arr) {
        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];
        // Adding present element with previous element
        for (int i = 1; i < arr.length; ++i)
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        return prefixSum;
    }

    public static int getSumBetweenIndexes(int[] prefixSum, int left, int right) {
        if(left==0 && right==0) {
            return prefixSum[0];
        } else if(left==0 && right>0) {
            return prefixSum[right];
        }
        return prefixSum[right] - prefixSum[left-1];
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 0, 19};
        System.out.println(shortestSubArrWithSumGreaterThanTarget(arr, 51));
    }
}
