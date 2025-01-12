package org.practice;

import java.util.List;
import java.util.stream.Collectors;

public class T_Info_Vision {

    public static void main(String[] args) {
        List<String> list = List.of("hello","world","goodmorning");//"Hello","World","Goodmorning"

        list.stream().map(str ->
                str.substring(0, 1).toUpperCase()+str.substring(1, str.length())).collect(Collectors.toList()).forEach(System.out::println);
    }
}
