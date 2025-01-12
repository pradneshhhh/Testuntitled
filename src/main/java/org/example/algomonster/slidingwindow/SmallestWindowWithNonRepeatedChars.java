package org.example.algomonster.slidingwindow;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class SmallestWindowWithNonRepeatedChars {

    public static void main(String[] args) {
        String input = "aabcbcdbca";

        findSmallestWindowWithNonRepeatedChars(input);
    }

    private static void findSmallestWindowWithNonRepeatedChars(String input) {
        Set<String> set = Arrays.stream(input.split("")).collect(Collectors.toSet());
        Map<String, Integer> window = set.stream().collect(Collectors.toMap(k -> k, v -> 0, (v1, v2) -> v2));

        int left = 0;
        String[] arr = input.split("");
        for (int right = 0; right < arr.length; right++) {
            window.put(arr[right], window.get(arr[right]) + 1);
            while (window.get(arr[right]) > 1) {
                window.put(arr[left], window.get(arr[left]) - 1);
                left++;
            }
            if (windowContainsAllDistinctKeys(window, set)) {
                System.out.println("");
                printSubArray(arr, left, right);
            }
        }
    }

    private static void printSubArray(String[] arr, int left, int right) {
        for (int i = left; i <= right; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static boolean windowContainsAllDistinctKeys(Map<String, Integer> window, Set<String> set) {
        return window.entrySet().stream().allMatch(entry -> set.contains(entry.getKey()) && entry.getValue()==1);
    }


}
