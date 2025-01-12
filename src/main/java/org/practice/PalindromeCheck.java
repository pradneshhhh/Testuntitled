package org.practice;

public class PalindromeCheck {

    private static boolean isPalindrome(String str) {
        String[] arr = str.split("");
        int left=0;
        int right=arr.length-1;
        while(left<=right) {
            if(!arr[left].equals(arr[right])) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "racecar";
        System.out.println(isPalindrome(str));
    }
}
