package org.example.algomonster.twoptrs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a string original and a string check, find the starting index of all substrings of original that is an anagram of check. The output must be sorted in ascending order.
 *
 * Parameters
 * original: A string
 * check: A string
 * Result
 * A list of integers representing the starting indices of all anagrams of check.
 * Examples
 * Example 1
 * Input: original = "cbaebabacd", check = "abc"
 *
 * Output: [0, 6]
 *
 * Explanation: The substring from 0 to 2, "cba", is an anagram of "abc", and so is the substring from 6 to 8, "bac".
 *
 * Example 2
 * Input: original = "abab", check = "ab"
 *
 * Output: [0, 1, 2]
 *
 * Explanation: All substrings with length 2 from "abab" are anagrams of "ab".
 *
 * Constraints
 * 1 <= len(original), len(check) <= 10^5
 * Each string consists of only lowercase characters in the standard English alphabet.
 */
public class FindAllAnagramsInAString {

    public static List<Integer> findAllAnagramsInAString(String str, String chk) {
        List<Integer> result = new ArrayList<>();
        char[] arr = str.strip().toLowerCase().toCharArray();
        char[] chkArr = chk.toCharArray();
        Arrays.sort(chkArr);
        for(int right=chk.length(); right<str.length(); right++) {
            int left = right - chk.length();
            StringBuilder buffer = new StringBuilder();
            for(int i=left; i<right; i++) {
                buffer.append(arr[i]);
            }
            char[] bufferArr = buffer.toString().toCharArray();
            Arrays.sort(bufferArr);
            if(Arrays.equals(bufferArr, chkArr)) {
                result.add(left);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findAllAnagramsInAString("cbaebabacd", "abc"));
        System.out.println(findAllAnagramsInAString("abab", "ab"));
    }
}
