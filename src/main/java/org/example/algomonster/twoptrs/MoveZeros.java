package org.example.algomonster.twoptrs;

import java.util.Arrays;

/**
 * Given an array of integers, move all the 0s to the back of the array while maintaining the relative order of the non-zero elements. Do this in-place using constant auxiliary space.
 *
 * Input:
 *
 * [1, 0, 2, 0, 0, 7]
 * Output:
 *
 * [1, 2, 7, 0, 0, 0]
 */
public class MoveZeros {

    public static int[] moveZeros(int[] arr) {
        int left = 0;
        for(int right = 0; right<arr.length; ++right){
            if(arr[left]==0 && arr[right]>0) {
                arr[left] = arr[right];
                arr[right] = 0;
                left++;
            } else if(arr[left]==0 && arr[right]==0) {
                //HOLD LEFT PTR
            } else {
                left++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 0, 0, 7};
        System.out.println(Arrays.toString(moveZeros(arr)));
    }
}
