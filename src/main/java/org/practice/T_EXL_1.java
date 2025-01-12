package org.practice;

import java.util.Arrays;

/**
 * Given an integer n, return a string array answer (1-indexed) where:
 * <p>
 * answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
 * answer[i] == "Fizz" if i is divisible by 3.
 * answer[i] == "Buzz" if i is divisible by 5.
 * answer[i] == i (as a string) if none of the above conditions are true.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 3
 * Output: ["1","2","Fizz"]
 * Example 2:
 * <p>
 * Input: n = 5
 * Output: ["1","2","Fizz","4","Buzz"]
 * Example 3:
 * <p>
 * Input: n = 15
 * Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 104
 */
public class T_EXL_1 {

    public static void main(String[] args) {
        String[] res = buildFizzBuzzArray(3);
        System.out.println(Arrays.toString(res));
    }

    private static String[] buildFizzBuzzArray(int n) {
        if (n < 1 || n > Math.pow(10, 4)) {
            return new String[0];
        }
        String[] res = new String[n];
        for (int i = 1; i <= n; i++) {
            boolean isDivisibleBy3 = isDivisibleByN(i, 3);
            boolean isDivisibleBy5 = isDivisibleByN(i, 5);
            if (isDivisibleBy3 && isDivisibleBy5) {
                res[i - 1] = "FizzBuzz";
            } else if (isDivisibleBy3 && !isDivisibleBy5) {
                res[i - 1] = "Fizz";
            } else if (!isDivisibleBy3 && isDivisibleBy5) {
                res[i - 1] = "Buzz";
            } else {
                res[i - 1] = String.valueOf(i);
            }
        }
        return res;
    }

    private static boolean isDivisibleByN(int i, int n) {
        return i % n == 0;
    }

}
