package org.example.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Q2_1787 {

    public static void main(String[] args) {
        Stream<List<String>> stream = Stream.of(Arrays.asList("a","b"), Arrays.asList("a","c"));
        stream.flatMap(list -> list.stream()).filter(s->s.equals("c")).forEach(System.out::print);
    }
}
