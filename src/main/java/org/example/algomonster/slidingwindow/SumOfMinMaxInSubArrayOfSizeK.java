package org.example.algomonster.slidingwindow;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://www.geeksforgeeks.org/sum-minimum-maximum-elements-subarrays-size-k/
 */
public class SumOfMinMaxInSubArrayOfSizeK {

    public static void main(String[] args) {
        int[] arr = {2, 5, -1, 7, -3, -1, -2};
        int k = 4;
        System.out.println(sumOfMinMaxInSubArrayOfSizeK(arr, k));
    }

    private static int sumOfMinMaxInSubArrayOfSizeK(int[] arr, int k) {
        int res = 0;
        for (int right = k; right <= arr.length; right++) {
            int left = right - k;
            res = res + (getMaxFromArr(arr, left, right) + getMinFromArr(arr, left, right));
        }
        return res;
    }

    private static int getMinFromArr(int[] arr, int start, int end) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        return list.stream().filter(i -> list.indexOf(i) >= start && list.indexOf(i) < end).min((i1, i2) -> i1.compareTo(i2)).get();
    }

    private static int getMaxFromArr(int[] arr, int start, int end) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        return list.stream().filter(i -> list.indexOf(i) >= start && list.indexOf(i) < end).max((i1, i2) -> i1.compareTo(i2)).get();
    }
}
