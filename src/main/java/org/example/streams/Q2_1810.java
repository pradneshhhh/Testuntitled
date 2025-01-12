package org.example.streams;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Q2_1810 {

    public static void main(String[] args) {
        List<Person> people = List.of(new Person("Bob",null, 31),
                new Person("Paul",null, 32),
                new Person("John",null, 33));

        Double avg = people.stream().filter(person -> person.getAge()<30).collect(Collectors.averagingInt(Person::getAge));
        System.out.println(avg);
    }
}
