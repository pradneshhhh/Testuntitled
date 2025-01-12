package org.example.multithreading.locks;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {

    public static void main(String[] args) {
        ReadWriteLock rwLock = new ReentrantReadWriteLock();
        SharedResourcesRW sharedResourcesRW1 = new SharedResourcesRW();
        Thread t1 = new Thread(() -> sharedResourcesRW1.producer(rwLock));
        Thread t2 = new Thread(() -> sharedResourcesRW1.producer(rwLock));
        SharedResourcesRW sharedResourcesRW2 = new SharedResourcesRW();
        Thread t3 = new Thread(() -> sharedResourcesRW2.consumer(rwLock));
        t1.start();
        t2.start();
        t3.start();
    }

static class SharedResourcesRW {
    private boolean isAvailable = false;

    private void producer(ReadWriteLock lock) {
        try {
            lock.readLock().lock();
            System.out.println("Read Lock acquired by "+ Thread.currentThread().getName());
        } catch (Exception ex) {
            System.out.println("Exception occurred "+ ex.getMessage());
        } finally {
            lock.readLock().unlock();
            System.out.println("Read Lock released by "+ Thread.currentThread().getName());
        }
    }

    private void consumer(ReadWriteLock lock) {
        try {
            lock.writeLock().lock();
            System.out.println("Write Lock acquired by "+ Thread.currentThread().getName());
            isAvailable = true;
        } catch (Exception ex) {
            System.out.println("Exception occurred "+ ex.getMessage());
        } finally {
            lock.writeLock().unlock();
            System.out.println("Write Lock released by "+ Thread.currentThread().getName());
        }
    }
}
}
