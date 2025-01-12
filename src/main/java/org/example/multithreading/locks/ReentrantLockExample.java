package org.example.multithreading.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    private int val;
    private final ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args) {

        ReentrantLockExample reentrantLockExample = new ReentrantLockExample();

        ExecutorService producerService = Executors.newFixedThreadPool(2);
        ExecutorService consumerService = Executors.newFixedThreadPool(3);

        producerService.execute(() -> {
            try{
                reentrantLockExample.lock.lock();
                for(int i=0;i<1000;i++) {
                    reentrantLockExample.val++;
                }
            } finally {
                reentrantLockExample.lock.unlock();
                System.out.println("Produced, latest val: "+reentrantLockExample.val);
            }
        });
        consumerService.submit(()->{
            try{
                reentrantLockExample.lock.lock();
                for(int i=0;i<1000;i++) {
                    reentrantLockExample.val--;
                }
            } finally {
                reentrantLockExample.lock.unlock();
                System.out.println("Consumed, latest val: "+reentrantLockExample.val);
            }
        });

        producerService.shutdown();
        consumerService.shutdown();
    }
}
