package org.practice;

import java.util.Arrays;
import java.util.stream.Collectors;

public class T_CG {

    public static void main(String[] args) {
        String str = "Pradnesh Mhatre";
        Arrays.stream(str.strip().split("")).collect(Collectors.groupingBy(String::valueOf, Collectors.counting())).entrySet().forEach(System.out::println);

        //SELECT NAME, MARKS FROM STUDENT ORDER BY MARKS DESC LIMIT 5;
    }
}
