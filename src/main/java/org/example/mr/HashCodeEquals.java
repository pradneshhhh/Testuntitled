package org.example.mr;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class HashCodeEquals {

    public static void main(String[] args) {
        Set<Person> set = new HashSet<>();
        Person p1 = new Person();
        Person p2 = new Person();
        System.out.println(p1.hashCode() + " " + p2.hashCode());
        set.add(new Person(1, "A"));
        set.add(new Person(1, "A"));
        System.out.println(set.size());

        Set<String> strSet = new HashSet<>();
        String st1 = new String("hi");
        String st2 = new String("hi");
        strSet.add(st1);
        strSet.add(st2);
        System.out.println(st1.hashCode()+" "+st2.hashCode());
        System.out.println(strSet.size());
    }
}

class Person {
    private int id;
    private String name;

    public Person() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
