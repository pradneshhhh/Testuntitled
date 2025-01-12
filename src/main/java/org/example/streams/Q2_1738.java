package org.example.streams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Q2_1738 {

    public static void main(String[] args) {
        System.out.println(IntStream.rangeClosed(0,5).sum());
        System.out.println(IntStream.rangeClosed(0,5).max().orElse(0));

        List<Person> people = List.of(new Person("Alan","Burke",22),
                new Person("Zoe","Peters",20),
                new Person("Peter","Castle",29));
       people.stream().max(Comparator.comparing(Person::getAge))
               .ifPresent(person ->
                       System.out.print("Oldest person is "
                               + person.getFirstName() +
                                " " + person.getLastName() + "\n"));

       List<Integer> integerList = List.of(10,47,33,23);
       integerList.stream().reduce((n1,n2) -> {
           if(n1>n2) {
               return n1;
           }
           return n2;
       }).ifPresent(System.out::println);

        int maxNum = integerList.stream().reduce(0, (n1,n2) -> {
            if(n1>n2) {
                return n1;
            }
            return n2;
        });
        System.out.println(maxNum);
    }
}
