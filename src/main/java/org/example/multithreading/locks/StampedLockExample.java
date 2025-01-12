package org.example.multithreading.locks;

import java.util.concurrent.locks.StampedLock;

public class StampedLockExample {

    public static void main(String[] args) {
        StampedLock stampedLock = new StampedLock();
        SharedResourceSL sharedResourceSL1 = new SharedResourceSL();
        SharedResourceSL sharedResourceSL2 = new SharedResourceSL();
        Thread t1 = new Thread(() -> sharedResourceSL1.producer(stampedLock));
        Thread t2 = new Thread(() -> sharedResourceSL2.consumer(stampedLock));
        t1.start();
        t2.start();
    }

}

class SharedResourceSL {
    int a = 10;

    void producer(StampedLock lock) {
        try {
            long stamp = lock.tryOptimisticRead();
            System.out.println("Optimistic Read Lock acquired by "+ Thread.currentThread().getName());
            Thread.sleep(4000);
            if(lock.validate(stamp)) {
                System.out.println("Continue as Stamp value is intact with a = "+a);
            } else {
                a = 10;
                System.out.println("Rolling back as Stamp value is corrupted with a = "+a);
                producer(lock);
            }
        } catch (Exception ex) {
            System.out.println("Exception occurred "+ ex.getMessage());
        }
    }

    void consumer(StampedLock lock) {
        long stamp = lock.writeLock();
        try {
            System.out.println("Write Lock acquired by "+ Thread.currentThread().getName());
            a = 11;
            System.out.println("Changed a = "+a);
        } catch (Exception ex) {
            System.out.println("Exception occurred "+ ex.getMessage());
        } finally {
            lock.unlock(stamp);
            System.out.println("Write Lock released by "+ Thread.currentThread().getName());
        }
    }
}
