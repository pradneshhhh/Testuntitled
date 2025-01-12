package org.example.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class InterleavedOutput {

    public static void main(String[] args) {
        final Object lock = new Object();
        new Thread(new InterLeaved(lock), "A").start();
        new Thread(new InterLeaved(lock), "B").start();
    }
}

class InterLeaved implements Runnable {

    final Object lock;

    public InterLeaved(Object lock) {
        this.lock = lock;
    }
    AtomicInteger i;
    @Override
    public void run() {
        String tName = Thread.currentThread().getName();
        synchronized (lock) {
            for(i = new AtomicInteger(1); i.get()<=10; i.addAndGet(1)) {
                if(tName.equals("A") && i.get()%2==0) {
                    System.out.print(String.valueOf(i)+ (char) (i.get() + 'a' - 1) +" ");
                } else if(tName.equals("B") && i.get()%2!=0) {
                    System.out.print(String.valueOf(i)+ (char) (i.get() + 'a' - 1) +" ");
                }
            }
        }
    }
}
