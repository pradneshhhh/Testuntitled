package org.practice;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class GroupAnagrams {

    public static void main(String[] args) {
        List<String> input = List.of("eat", "tea", "tan", "ate", "nat", "bat");

        System.out.println(groupAnagrams(input));
    }

    private static List<CopyOnWriteArrayList<String>> groupAnagrams(List<String> input) {
        List<CopyOnWriteArrayList<String>> result = new ArrayList<>();
        Map<String, CopyOnWriteArrayList<String>> res = new HashMap<>();
        for(String str:input) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            if(!res.isEmpty() && res.containsKey(Arrays.toString(arr))) {
                res.get(Arrays.toString(arr)).add(str);
            } else {
                CopyOnWriteArrayList<String> l = new CopyOnWriteArrayList<>();
                l.add(str);
                res.put(Arrays.toString(arr), l);
            }
        }
        res.forEach((key, value) -> result.add(value));
        return result;
    }
}
