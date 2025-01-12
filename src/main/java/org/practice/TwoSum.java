package org.practice;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoSum {

    private static List<Integer> twoSum(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length-1;i++) {
            if(!set.isEmpty() && set.contains(target-nums[i])) {
                return List.of(nums[i], target-nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(twoSum(nums, target));
    }
}
