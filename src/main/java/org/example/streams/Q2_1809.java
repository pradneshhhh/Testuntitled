package org.example.streams;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Q2_1809 {

    public static void main(String[] args) {
        List<Book> books = List.of(new Book("Thinking in Java", 30.0),
                new Book("Java in 24 hrs", 20.0),
                new Book("Java Recipes", 10.0));
        double avgPrc1 = books.stream()
                .filter(book -> book.getPrice() > 10)
                .collect(Collectors.averagingDouble(Book::getPrice));
        double avgPrc2 = books.stream()
                .filter(book -> book.getPrice() > 90)
                .collect(Collectors.averagingDouble(Book::getPrice));

        System.out.println(avgPrc1);
        System.out.println(avgPrc2);
    }
}
