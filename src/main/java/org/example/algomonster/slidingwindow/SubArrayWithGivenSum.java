package org.example.algomonster.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class SubArrayWithGivenSum {

    public static void main(String[] args) {
        int arr[] = { 15, 2, 4, 8, 9, 5, 10, 23}, sum = 23;

        System.out.println(findSubArrayWithGivenSum(arr, sum));
    }

    private static List<Integer> findSubArrayWithGivenSum(int[] arr, int sum) {
        List<Integer> res = new ArrayList<>();
        int left=0;
        int window=0;
        for(int right=0; right<arr.length; right++) {
            window += arr[right];
            while(window>sum) {
                window -= arr[left];
                left++;
            }
            if(window==sum) {
                res.add(left);
                res.add(right);
                return res;
            }
        }
        return res;
    }
}
