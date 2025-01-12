package org.example.solid;

interface Bird {
   void fly();
   void walk();
}

class Eagle implements Bird {

    @Override
    public void fly() {
        System.out.println("Eagle flies");
    }

    @Override
    public void walk() {
        System.out.println("Eagle walks");
    }
}

class Ostrich implements Bird {

    @Override
    public void fly() {
        System.out.println("Ostrich flies");
    }

    @Override
    public void walk() {
        System.out.println("Ostrich walks");
    }
}

public class LSP {

    public static void main(String[] args) {
        Bird eagle = new Eagle();
        Bird ostrich = new Ostrich();
        eagle.fly();
        eagle.walk();
        ostrich.walk();
        ostrich.fly(); //LSP violation

        System.out.println("----------LSP RESOLVED----------------");
        EagleResolved eagleResolved = new EagleResolved();
        OstrichResolved ostrichResolved = new OstrichResolved();
        eagleResolved.fly();
        eagleResolved.walk();
        ostrichResolved.walk();
    }
}

interface FlyingBird {
        void fly();
}

interface WalkingBird {
    void walk();
}

class EagleResolved implements FlyingBird, WalkingBird {

    @Override
    public void fly() {
        System.out.println("Eagle flies");
    }

    @Override
    public void walk() {
        System.out.println("Eagle walks");
    }
}

class OstrichResolved implements WalkingBird {

    @Override
    public void walk() {
        System.out.println("Ostrich walks");
    }
}


