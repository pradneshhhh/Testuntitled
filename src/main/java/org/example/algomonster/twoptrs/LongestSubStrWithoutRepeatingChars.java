package org.example.algomonster.twoptrs;

import java.util.HashMap;

public class LongestSubStrWithoutRepeatingChars {

    /**
     * Find the length of the longest substring of a given string without repeating characters.
     *
     * Input: abccabcabcc
     *
     * Output: 3
     *
     * Explanation: The longest substrings are abc and cab, both of length 3.
     */

    public static int longestSubstringWithoutRepeatingCharacters(String s) {
        int longest = 0;
        int left = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        for (int right = 0; right < s.length(); ++right) {
            window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0) + 1);
            while (window.get(s.charAt(right)) > 1) {
                window.put(s.charAt(left), window.get(s.charAt(left)) - 1);
                left++;
            }
            longest = Math.max(longest, right - left + 1);
        }
        return longest;
    }

    public static void main(String[] args) {
        System.out.println(longestSubstringWithoutRepeatingCharacters("abccabcabcc"));
    }
}
