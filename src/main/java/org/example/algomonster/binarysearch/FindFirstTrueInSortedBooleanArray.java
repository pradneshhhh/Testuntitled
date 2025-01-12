package org.example.algomonster.binarysearch;

/**
 * An array of boolean values is divided into two sections: The left section consists of all false, and the right section consists of all true. Find the First True in a Sorted Boolean Array of the right section, i.e., the index of the first true element. If there is no true element, return -1.
 *
 * Input: arr = [false, false, true, true, true]
 *
 * Output: 2
 *
 * Explanation: The first true's index is 2.
 */
public class FindFirstTrueInSortedBooleanArray {

    public static int findFirstTrueInSortedBooleanArray(boolean[] arr) {
        if(arr==null || arr.length==0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        int result = -1;
        while(left <= right) {
            int mid = (left+right)/2;
            if(arr[mid]) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        boolean[] arr = {false, false, true, true, true};
        System.out.println(findFirstTrueInSortedBooleanArray(arr));
    }
}
