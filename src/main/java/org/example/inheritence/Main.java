package org.example.inheritence;

public class Main {

    public static void main(String[] args) {
        B b = new B();
        System.out.println(b.x);//30

        A a = new A();
        System.out.println(a.x);//20

        A a2 = new B();
        System.out.println(a2.x);//20

        C c = new C();
        System.out.println(c.x);//40

        B bc = new C();
        System.out.println(bc.x);//30

        A ac = new C();
        System.out.println(ac.x);//20


        b.m();
        a.m();
        a2.m();
        c.m();
        bc.m();
        ac.m();
    }
}
