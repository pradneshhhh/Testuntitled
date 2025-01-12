package org.example.algomonster.binarysearch;

/**
 * Given a sorted array and a target value, find the first element that is strictly smaller than the given element.
 *
 * Examples:
 *
 * Input : arr[] = {1, 2, 3, 5, 8, 12}
 *         Target = 5
 * Output : 2 (Index of 3)
 */
public class FirstElementSmallerThanTarget {

    public static int firstElementSmallerThanTarget(int[] arr, int target) {
        if(arr==null || arr.length==0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        int result = -1;
        while(left <= right) {
            int mid = (left+right)/2;
            if(arr[mid] >= target) {
                right = mid - 1;
            } else {
                result = mid;
                left = left + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 8, 12};
        System.out.println(firstElementSmallerThanTarget(arr,5));
    }
}
