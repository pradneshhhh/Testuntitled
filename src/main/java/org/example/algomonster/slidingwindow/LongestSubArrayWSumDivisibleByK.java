package org.example.algomonster.slidingwindow;

public class LongestSubArrayWSumDivisibleByK {

    public static void main(String[] args) {
        int arr[] = {2, 7, 6, 1, 4, 5}, k = 3;

        int left=0;
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int right=0;right<arr.length;right++) {
            sum += arr[right];
            if(sum%k==0) {
                max = Math.max(max, right-left+1);
            }
        }

        System.out.println(max);
    }
}
