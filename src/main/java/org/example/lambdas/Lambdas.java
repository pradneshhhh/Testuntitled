package org.example.lambdas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

public class Lambdas {

    public static void main(String[] args) {

        consumer();

        supplier();

        predicate();

        function();

        List<Person> listPeople = getPeople();
        sortAge(listPeople);
        sortName(listPeople);
        sortHeight(listPeople);
    }

    public static void supplier() {
        Supplier<Integer> intSupplier = () -> 77;
        System.out.println(intSupplier.get());
    }

    public static void consumer() {
        Consumer<String> printConsumer1 = s -> System.out.println(s);
        Consumer<String> printConsumer2 = System.out::println;
        printConsumer1.accept("Printable lambda");
        printConsumer2.accept("Printable lambda");
    }

    public static void function() {
        Function<Integer, String> function = i -> "Number is: " + i;
        System.out.println(function.apply(25));
    }

    public static void predicate() {
        Predicate<Integer> predicate1 = i -> i < 0;
        System.out.println(predicate1.test(-1));
        System.out.println(predicate1.test(+1));
        Predicate<Integer> isEvenNum = i -> i%2==0;
        Predicate<String> startsWithMr = s -> s.startsWith("Mr");
        Predicate<Integer> isAdult = (age) -> age>18;
        System.out.println(check(4, isEvenNum));
        System.out.println(check(7, isEvenNum));
        System.out.println(check("Mr. Joe Bloggs", startsWithMr));
        System.out.println(check("Ms. Ann Bloggs", startsWithMr));
        System.out.println(check(33, isAdult));
        System.out.println(check(13, isAdult));
    }

    public static <T> boolean check(T t, Predicate<T> predicate) {
        return predicate.test(t);
    }

    private static List<Person> getPeople() {

        List<Person> result = new ArrayList<>();

        result.add(new Person("Mike", 33, 1.8));

        result.add(new Person("Mary", 25, 1.4));

        result.add(new Person("Alan", 34, 1.7));

        result.add(new Person("Zoe", 30, 1.5));

        return result;

    }

    public static void sortAge(List<Person> listOfPeople) {
        listOfPeople.sort(Comparator.comparing(Person::getAge));
        listOfPeople.forEach(System.out::println);
    }

    public static void sortName(List<Person> listOfPeople) {
        listOfPeople.sort(Comparator.comparing(Person::getName));
        listOfPeople.forEach(System.out::println);
    }

    public static void sortHeight(List<Person> listOfPeople) {
        listOfPeople.sort(Comparator.comparing(Person::getHeight));
        listOfPeople.forEach(System.out::println);
    }
}
