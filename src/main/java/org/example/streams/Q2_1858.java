package org.example.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Q2_1858 {

    public static void main(String[] args) {
        List<AnotherBook> books = List.of(new AnotherBook("Gone with the wind", "Fiction"),
                new AnotherBook("Bourne Ultimatum", "Thriller"),
                new AnotherBook("The Client", "Thriller"));
        List<String> genreList = new ArrayList<>();
        genreList = books.stream().map(AnotherBook::getGenre).collect(Collectors.toList());
        genreList.forEach(System.out::println);
    }
}
