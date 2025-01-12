package org.practice;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class T_Xoriant {

    public static void main(String[] args) {
        Integer n = 101;
        System.out.println(isPalindrome(n));
        List<Integer> collect = IntStream.of(n).boxed().collect(Collectors.toList());
        Collections.reverse(collect);
        System.out.println(Integer.valueOf(collect.stream().map(i-> String.valueOf(i)).collect(Collectors.joining())) == n);

    }

    public static boolean isPalindrome(Integer n) {
        String[] arr = n.toString().split("");//["1","0","1"]
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            if (!arr[left].equals(arr[right])) {
                return false;
            }
            left += 1;
            right -= 1;
        }
        return true;
    }
}
