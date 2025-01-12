package org.example.multithreading;

public class Counter {

    public static void main(String[] args) throws InterruptedException {
        final Object lock = new Object();
        Count c1 = new Count(lock);
        Runnable obj1 = () -> {
            for (int i=1; i <= 10000; i++) {
                c1.increment();
            }
        };
        Runnable obj2 = () -> {
            for (int i=1; i <= 10000; i++) {
                c1.increment();
            }
        };
        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(c1.c);
    }
}

class Count {
    int c;
    final Object lock;
    public Count(Object lock) {
        this.lock = lock;
    }
    public void increment() {
        synchronized (lock) {
            c += 1;
        }
    }
}


