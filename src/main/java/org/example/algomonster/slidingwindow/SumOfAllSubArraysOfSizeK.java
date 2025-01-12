package org.example.algomonster.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class SumOfAllSubArraysOfSizeK {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6}, K = 3;
        System.out.println(findSumOfAllSubArraysOfSizeK(arr, K));
    }

    private static List<Integer> findSumOfAllSubArraysOfSizeK(int[] arr, int k) {
        List<Integer> res = new ArrayList<>();
        int initialSum = 0;
        for(int i=0; i<k; i++) {
            initialSum += arr[i];
        }
        res.add(initialSum);
        for(int right=k+1; right<=arr.length; right++) {
            int left = right-k;
            initialSum = initialSum - arr[left-1] + arr[right-1];
            res.add(initialSum);
        }
        return res;
    }
}
