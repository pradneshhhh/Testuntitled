package org.practice;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class NonRepeatingChar {

    public static void main(String[] args) {
        String str = "leetcode";
        System.out.println(Arrays.stream(str.split("")).collect(Collectors.groupingBy(String::valueOf, LinkedHashMap::new, Collectors.counting())).entrySet().stream().sorted(Map.Entry.comparingByValue()).filter(entry -> entry.getValue()==1).map(Map.Entry::getKey).findFirst().get());
    }
}
