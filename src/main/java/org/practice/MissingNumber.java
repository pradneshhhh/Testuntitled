package org.practice;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MissingNumber {

    public static void main(String[] args) {
        int[] nums = {3, 0, 1, 5, 2, 6, 4}; // Example array
        int idealSum = nums.length * (nums.length + 1) / 2;
        int actualSum = Arrays.stream(nums).boxed().collect(Collectors.summingInt(Integer::valueOf));
        System.out.println("Missing number is:: " + (idealSum - actualSum));
    }
}
