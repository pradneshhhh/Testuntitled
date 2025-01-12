package org.practice;

public class SwapNumbers {

    private static void swapWithExtraStorage(int a, int b) {
        System.out.println("Before swap, a::"+a+" b::"+b);
        int temp = a;
        a = b;
        b = temp;
        System.out.println("After swap, a::"+a+" b::"+b);
    }

    private static void swapWithoutExtraStorage(int a, int b) {
        System.out.println("Before swap, a::"+a+" b::"+b);
        b = a+b;
        a = b-a;
        b = b-a;
        System.out.println("After swap, a::"+a+" b::"+b);
    }

    public static void main(String[] args) {
        swapWithExtraStorage(10, 5);
        swapWithoutExtraStorage(10, 5);
    }
}
