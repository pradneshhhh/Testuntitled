package org.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given an array and an integer K, find the maximum for each and every contiguous subarray of size K.
 * Examples :
 *
 *
 * Input: arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, K = 3
 * Output: 3 3 4 5 5 5 6
 * Explanation: Maximum of 1, 2, 3 is 3
 *                        Maximum of 2, 3, 1 is 3
 *                        Maximum of 3, 1, 4 is 4
 *                        Maximum of 1, 4, 5 is 5
 *                        Maximum of 4, 5, 2 is 5
 *                        Maximum of 5, 2, 3 is 5
 *                        Maximum of 2, 3, 6 is 6
 * has context menu
 * You can't send messages because you are not a member of the chat.
 * has context menu
 */
public class TechSME_T {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, K = 3;
        printMaxNumbersSubArrayOfK(arr, K).forEach(System.out::print);
    }

    public static List<Integer> printMaxNumbersSubArrayOfK(int[] arr, int K) {
        List<Integer> res = new ArrayList<>();
        if(arr!=null && arr.length>=K) {
            PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
            for (int i = 0; i < K; i++) {
                q.add(arr[i]);
            }
            res.add(q.peek());
            for (int right = K; right < arr.length; right++) {
                int left = right - K;
                q.remove(arr[left]);
                q.add(arr[right]);
                res.add(q.peek());
            }
        }
        return res;
    }

}
