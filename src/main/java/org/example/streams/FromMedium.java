package org.example.streams;

import java.util.*;
import java.util.stream.Collectors;

public class FromMedium {

    /**
     * Write a program to find first non repeat element from a given string by Java Streams.
     * input = "iloveprogrammsng"
     * result= "i"
     */
    public static String findFirstNonRepeatedElement(String str) {
       return Arrays.stream(str.split("")).collect(Collectors.groupingBy(s->s, LinkedHashMap::new , Collectors.counting())).entrySet().stream().filter(m -> m.getValue()==1).map(Map.Entry::getKey).findFirst().get();
    }

    /**
     *
     * Sort Map by values
     */
    public static void sortMapByValue(Map<String, Integer> map) {
        System.out.println(map.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)).toString());
    }

    /**
     *
     * Sort Map by keys
     */
    public static void sortMapByKey(String str) {
        Arrays.stream(str.split("")).collect(Collectors.groupingBy(s->s, LinkedHashMap::new, Collectors.counting())).entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
    }

    /**
     * Write a program to find second highest element from an array , Array can contain duplicate   elements .
     *
     * int array[] = {1,3,2,4,5,6,6,9,9,10,11};
     *
     * result = 10
     *
     */
    public static int findSecondHighestElementFromArray(int[] arr) {
        return Arrays.stream(arr).boxed().collect(Collectors.toSet()).stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
    }

    /**
     * Write a program to find first repeat element/character from a given string by Java Streams.
     *
     * input = "lovejava"
     *
     * result = "v"
     */
    public static String findFirstRepeatCharacterFromString(String str) {
        return Arrays.stream(str.split("")).collect(Collectors.groupingBy(s->s, LinkedHashMap::new, Collectors.counting())).entrySet().stream().filter(m -> m.getValue()>1).map(k -> k.getKey()).findFirst().get();
    }

    /**
     *
     * Write a program to find longest string in a given array
     */
    public static String findLongestStringInArray(String[] arr) {
        return Arrays.stream(arr).sorted(Comparator.comparingInt(String::length).reversed()).findFirst().get();
    }

    /**
     *
     * Write a Java program to find all elements from array which starts from 2 using stream API
     *
     */
    public static List<Integer> findAllElementsFromArrayWhichStartWith2(int[] arr) {
       return Arrays.stream(arr).boxed().filter(i -> i>=20 && i<=29).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(findFirstNonRepeatedElement("iloveprogrammsng"));

        int[] arr = {1,3,2,4,5,6,6,9,9,10,11};
        System.out.println(findSecondHighestElementFromArray(arr));

        System.out.println(findFirstRepeatCharacterFromString("lovejava"));

        String [] arrayInput = {"vivek"  , "kadiyan" , "ram" , "chaudhary vivek kadiyan"};
        System.out.println(findLongestStringInArray(arrayInput));

        int[] inputArray = {1,25,34,45,26,26,37};
        System.out.println(findAllElementsFromArrayWhichStartWith2(inputArray));

        sortMapByValue(Map.of("A", 10, "B", 5, "C", 7));

        sortMapByKey("fjoifdjaaidfoojpawed");
    }
}
