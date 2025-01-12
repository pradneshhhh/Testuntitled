package org.practice;

import java.util.*;
import java.util.stream.Collectors;

public class MinBalanceExceededException extends RuntimeException {

    public MinBalanceExceededException(String message) {
        super(message);
    }

    /**
     * Map<String, String> innerMap1 = Map.of("1", "abc");
     * Map<String, String> innerMap2 = Map.of("2", "xyz");
     * Map<String, Map<String, String>> map1 = Map.of("3", innerMap1);
     * Map<String, Map<String, String>> map2 = Map.of("4", innerMap2);
     * List<Map<String, Map<String, String>>> list = List.of(map1, map2);
     *
     * Need to get list of key and value from inner map.
     *
     * output should be as follow:
     * List<String> keys = List.Of("1","2")
     * List<String> values = List.of("abc","xyz");
     *
     * has context menu
     *
     */
    public static void main(String[] args) {
        String str = "I love my India";
        String[] arr = str.split("");
        for(int i=arr.length-1; i>=0; i--) {
//            System.out.print(arr[i]);
        }


        Map<String, String> innerMap1 = Map.of("1", "abc");
        Map<String, String> innerMap2 = Map.of("2", "xyz");
        Map<String, Map<String, String>> map1 = Map.of("3", innerMap1);
        Map<String, Map<String, String>> map2 = Map.of("4", innerMap2);
        List<Map<String, Map<String, String>>> list = List.of(map1, map2);

//        Need to get list of key and value from inner map.
//
//                output should be as follow:
//        List<String> keys = List.Of("1","2")
//        List<String> values = List.of("abc","xyz");
        List<String> keys = new ArrayList<>();
        List<String> values = new ArrayList<>();
        list.stream().flatMap(map -> map.entrySet().stream()).forEach(entry -> {
            entry.getValue().keySet().stream().forEach(k -> keys.add(k));
            entry.getValue().values().stream().forEach(v -> values.add(v));
        });

        System.out.println(keys);
        System.out.println(values);

        //SELECT S.NAME, S.CLASS, M.MARKS FROM STUDENT S LEFT JOIN MARKS M ON S.ID=M.S_ID ORDER BY M.MARKS DESC LIMIT 5;
    }
}


