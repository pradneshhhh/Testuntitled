package org.example.algomonster.twoptrs;

import java.util.List;

/**
 * Given a sorted list of numbers, remove duplicates and return the new length. You must do this in-place and without using extra memory.
 *
 * Input: [0, 0, 1, 1, 1, 2, 2].
 *
 * Output: 3.
 *
 * Your function should modify the list in place so that the first three elements become 0, 1, 2. Return 3 because the new length is 3.
 */
public class RemoveDuplicates {

    public static int removeDupes(List<Integer> list) {
        int[] arr = list.stream().mapToInt(i->i).toArray();
        int left = 0;
        for(int right=0; right<arr.length; ++right) {
            if(arr[left] != arr[right]) {
                left += 1;
                arr[left] = arr[right];
            }
        }
        return left+1;
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(0,0,1,1,1,2,2);
        System.out.println(removeDupes(list));
    }
}
