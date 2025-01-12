package org.practice;

import java.util.HashSet;
import java.util.Set;

public class DuplicateElements {

    public static void findDuplicates(int[] nums) {
        // Solution to be implemented
        Set<Integer> set = new HashSet<>();
        for(int i:nums) {
            if(!set.isEmpty() && set.contains(i)) {
                System.out.print(" "+i);
            } else {
                set.add(i);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 4, 5, 5, 6};
        findDuplicates(nums);
        // Expected Output: 2 5
    }
}
