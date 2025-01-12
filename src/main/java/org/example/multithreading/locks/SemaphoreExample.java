package org.example.multithreading.locks;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    public static void main(String[] args) {
        Semaphore semaphoreLock = new Semaphore(2);
        SharedResourceSP sharedResourceSP = new SharedResourceSP();
        Thread t1 = new Thread(() -> sharedResourceSP.doSomething(semaphoreLock));
        Thread t2 = new Thread(() -> sharedResourceSP.doSomething(semaphoreLock));
        Thread t3 = new Thread(() -> sharedResourceSP.doSomething(semaphoreLock));
        Thread t4 = new Thread(() -> sharedResourceSP.doSomething(semaphoreLock));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class SharedResourceSP {

    void doSomething(Semaphore semaphore) {
        try {
            semaphore.acquire();
            System.out.println("Semaphore Lock acquired by "+ Thread.currentThread().getName());
            Thread.sleep(2000);
        } catch (Exception ex) {
            System.out.println("Exception occurred "+ ex.getMessage());
        } finally {
            semaphore.release();
            System.out.println("Semaphore Lock released by "+ Thread.currentThread().getName());
        }
    }
}
