package org.example.algomonster.twoptrs;

/**
 * Determine whether a string is a palindrome, ignoring non-alphanumeric characters and case. Examples:
 *
 * Input: Do geese see God? Output: True
 *
 * Input: Was it a car or a cat I saw? Output: True
 *
 * Input: A brown fox jumping over Output: False
 */
public class ValidPalindrome {

    public static boolean isValidPalindrome(String str) {
        char[] arr = str.strip().toLowerCase().toCharArray();
        int left = 0;
        int right = arr.length - 1;
        for(int i=0; i<=arr.length/2; i++) {
            if(arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValidPalindrome("M AMA M"));
        System.out.println(isValidPalindrome("A brown fox jumping over"));
        System.out.println(isValidPalindrome("Was it a car or a cat I saw"));
    }
}
