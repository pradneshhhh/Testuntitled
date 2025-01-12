package org.example.streams;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Book {
    private String title;
    private double price;
    Book(String title, double price){
        this.title = title;
        this.price = price;
    }
    public String getTitle() {   return title;}
    public double getPrice() {   return price;}
    public String toString() { return title+ " " + price;}

    public static void main(String[] args) {
        Book b1 = new Book("A", 100);
        Book b2 = new Book("A", 100);
        Book b3 = new Book("C", 200);
        Book b4 = new Book("A", 100);

        List<Book> list = List.of(b1, b2, b3, b4);
        list.stream().collect(Collectors.groupingBy(Book::getTitle, HashMap::new, Collectors.counting())).entrySet().stream().filter(entry -> entry.getValue()>2).forEach(System.out::println);
    }
}
