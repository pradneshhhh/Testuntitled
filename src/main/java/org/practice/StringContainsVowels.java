package org.practice;

import java.util.Arrays;

public class StringContainsVowels {

    public static void main(String[] args) {
        System.out.println(stringContainsVowels("Hello")); // true
        System.out.println(stringContainsVowels("TV")); // false
    }

    private static boolean stringContainsVowels(String str) {
        return Arrays.stream(str.split("")).anyMatch(s -> s.matches(".*[aeiou].*"));
    }
}
