package org.example.multithreading.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionCommunication {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        SharedResourceCC sharedResourceCC = new SharedResourceCC();
        SharedResourceCC sharedResourceCC1 = new SharedResourceCC();
        Thread t1 = new Thread(() -> sharedResourceCC.produce(lock, condition));
        Thread t2 = new Thread(() -> sharedResourceCC.consume(lock, condition));
        Thread t3 = new Thread(() -> sharedResourceCC1.produce(lock, condition));
        Thread t4 = new Thread(() -> sharedResourceCC1.consume(lock, condition));

        t1.start();
        t2.start();
        t4.start();
        t3.start();
    }
}

class SharedResourceCC {

    boolean isAvailable = false;

    void produce(ReentrantLock lock, Condition condition) {
        try {
            lock.lock();
            System.out.println("Producer Lock acquired by "+ Thread.currentThread().getName());
            Thread.sleep(2000);
            if(isAvailable) {
                System.out.println("Producer is waiting "+ Thread.currentThread().getName());
                condition.await();
            }
            isAvailable = true;
            System.out.println("Produced isAvailable:: "+isAvailable+ " by thread:: "+Thread.currentThread().getName());
            condition.signalAll();
        } catch (Exception ex) {
            System.out.println("Exception occurred "+ ex.getMessage());
        } finally {
            lock.unlock();
            System.out.println("Producer Lock released by "+ Thread.currentThread().getName());
        }
    }

    void consume(ReentrantLock lock, Condition condition) {
        try {
            lock.lock();
            System.out.println("Consumer Lock acquired by "+ Thread.currentThread().getName());
            if(!isAvailable) {
                System.out.println("Consumer is waiting "+ Thread.currentThread().getName());
                condition.await();
            }
            isAvailable=false;
            System.out.println("Consumed isAvailable:: "+isAvailable+ " by thread:: "+Thread.currentThread().getName());
            condition.signalAll();
        } catch (Exception ex) {
            System.out.println("Exception occurred "+ ex.getMessage());
        } finally {
            lock.unlock();
            System.out.println("Consumer Lock released by "+ Thread.currentThread().getName());
        }
    }
}
