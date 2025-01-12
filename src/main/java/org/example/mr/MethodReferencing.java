package org.example.mr;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class MethodReferencing {

    public static void main(String[] args) {
        boundMR();

        unboundMR();

        constructorMR();
    }

    public static void boundMR() {
        String joe = "Mr. Joe Bloggs";
        Predicate<String> startsWith = prefix -> joe.startsWith(prefix);
        System.out.println(startsWith.test("Mr"));
        System.out.println(startsWith.test("Ms"));
        Predicate<String> startsWithMR = joe::startsWith;
        System.out.println(startsWithMR.test("Mr"));
        System.out.println(startsWithMR.test("Ms"));
    }

    public static void unboundMR() {
        Predicate<String> isEmpty = string -> string.isEmpty();
        System.out.println(isEmpty.test(""));
        System.out.println(isEmpty.test("xyz"));

        Predicate<String> isEmptyMR = String::isEmpty;
        System.out.println(isEmptyMR.test(""));
        System.out.println(isEmptyMR.test("xyz"));

        BiPredicate<String, String> startsWith = (s1, s2) -> s1.startsWith(s2);
        System.out.println(startsWith.test("Mr. Joe Bloggs", "Mr."));
        System.out.println(startsWith.test("Mr. Joe Bloggs", "Ms."));

        BiPredicate<String, String> startsWithMR = String::startsWith;
        System.out.println(startsWithMR.test("Mr. Joe Bloggs", "Mr."));
        System.out.println(startsWithMR.test("Mr. Joe Bloggs", "Ms."));
    }

    public static void constructorMR() {
        Supplier<List<String>> listSupplier = () -> new ArrayList<>();
        List<String> list = listSupplier.get();
        list.add("Lambda");
        list.forEach(System.out::println);

        Supplier<List<String>> listSupplierMR = ArrayList::new;
        List<String> listMR = listSupplier.get();
        listMR.add("Method Reference");
        listMR.forEach(System.out::println);

        Function<Integer, List<String>> listFunction = capacity -> new ArrayList<>(capacity);
        List<String> listFunc = listFunction.apply(10);
        listFunc.add("Lambda");
        listFunc.forEach(System.out::println);

        Function<Integer, List<String>> listFunctionMR = ArrayList::new;
        List<String> listFuncMR = listFunctionMR.apply(10);
        listFuncMR.add("Method Reference");
        listFuncMR.forEach(System.out::println);
    }
}
