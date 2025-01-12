package org.example.algomonster.slidingwindow;


public class LongestSubArrayHavingSumK {

    public static void main(String[] args) {
        int[] arr = { 10, 5, 2, 7, 1, 9 };
        int target = 15;

        findLongestSubArrayHavingSumK(arr, target);
    }

    private static void findLongestSubArrayHavingSumK(int[] arr, int target) {
        int left=0;
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int right=0; right<arr.length; right++) {
            sum += arr[right];
            while(sum>target) {
                sum -= arr[left];
                left++;
            }
            if(sum==target) {
                max= Math.max(max, right-left+1);
            }
        }
        System.out.println(max);
    }
}
