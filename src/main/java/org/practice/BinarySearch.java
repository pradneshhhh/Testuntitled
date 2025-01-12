package org.practice;

public class BinarySearch {

    public static int binarySearch(int[] nums, int target) {
        // Solution to be implemented
        int left=0;
        int right=nums.length-1;
        while(left<=right) {
            int mid = (left+right)/2;
            if(nums[mid]==target) {
                return mid;
            } else if(nums[mid]<target) {
                left=mid+1;
            } else {
                right=mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 11, 13, 15};
        int target = 15;
        System.out.println(binarySearch(nums, target));  // Expected Output: 4 (index of 9)
    }
}
