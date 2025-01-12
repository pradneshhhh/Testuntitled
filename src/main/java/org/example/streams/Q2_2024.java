package org.example.streams;

import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Q2_2024 {

    public static void main(String[] args) {
        System.out.println(DoubleStream.of(0,2,4).filter(num -> num%2!=0).sum());
        Stream.of(1.0,3.0).mapToDouble(num -> num.doubleValue()).filter(num -> num%2==0)
                .average().ifPresent(System.out::println);
    }
}
