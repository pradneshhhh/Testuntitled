package org.example.algomonster.slidingwindow;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MaxOfSubArraysOfSizeK {

    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7,8}, k=3;

        System.out.println(findMaxOfSubArraysOfSizeK(arr, k));
    }

    private static List<Integer> findMaxOfSubArraysOfSizeK(int[] arr, int k) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<k;i++) {
            q.add(arr[i]);
        }
        for(int right=k; right<arr.length; right++) {
            int left=right-k;
            res.add(q.peek());
            q.remove(arr[left]);
            q.add(arr[right]);
        }
        return res;
    }
}
