package org.practice;

import java.util.Arrays;

public class CheckAnagrams {

    public static boolean isAnagram(String str, String target) {
        char[] strArr = str.toCharArray();
        char[] targetArr = target.toCharArray();
        Arrays.sort(strArr);
        Arrays.sort(targetArr);
        return Arrays.equals(strArr, targetArr);
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("cat","tac"));
    }
}
