package org.example.streams;

import java.util.Arrays;
import java.util.List;

public class Q2_1840 {

    public static void main(String[] args) {
        List<Integer> ls =
                Arrays.asList(11, 11, 22, 33, 33, 55, 66);
        System.out.println(ls.stream().distinct().anyMatch(num -> num==11));
        System.out.println(ls.stream().noneMatch(num -> num%11>0));
    }
}
