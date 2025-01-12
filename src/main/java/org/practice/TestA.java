package org.practice;

import java.util.Arrays;

public class TestA {

    public static void main(String[] args) {
        String str = "I am A Java Engineer";

        //result: "I ma A avaJ reenignE"

        Arrays.stream(str.split(" ")).forEach(s -> {
            System.out.print(reverseString(s) + " ");
        });
        System.out.println("\n--------------\n");
        Arrays.stream(str.split(" ")).map(s -> reverseString(s) + " ").forEach(System.out::print);

    }

    private static String reverseString(String s) {
        if (s.length() == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
