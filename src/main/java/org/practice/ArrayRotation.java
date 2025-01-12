package org.practice;

import java.util.Arrays;

public class ArrayRotation {

    public static void rotate(int[] nums, int k) {
        // Solution to be implemented
        int[] res = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(i+k<nums.length) {
                res[i+k] = nums[i];
            } else if(i+k>=nums.length) {
                res[i+k-nums.length] = nums[i];
            }
        }
        nums = res;
        Arrays.stream(nums).forEach(System.out::println);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        rotate(array, 3);
        // Expected Output: [5, 6, 7, 1, 2, 3, 4]
    }
}
