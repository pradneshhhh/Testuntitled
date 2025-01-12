package org.example.algomonster.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class FirstNegativeIntegerInWindowOfSizeK {

    public static void main(String[] args) {
        int arr[] = {-8, 2, 3, -6, 10}, k = 2;

        System.out.println(findFirstNegativeIntegerInWindowOfSizeK(arr, k));
    }

    private static List<Integer> findFirstNegativeIntegerInWindowOfSizeK(int[] arr, int k) {
        List<Integer> res = new ArrayList<>();
        for(int right=k; right<=arr.length; right++) {
            int left=right-k;
            int min = Math.min(arr[left], arr[right-1]);
            if(min<0) {
                res.add(min);
            } else {
                res.add(0);
            }
        }
        return res;
    }
}
