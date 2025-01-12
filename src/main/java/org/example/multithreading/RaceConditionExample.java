package org.example.multithreading;

import java.time.Instant;
import java.util.Date;

/**
 * https://java-jedi.medium.com/multithreading-synchronization-class-level-and-method-level-synchronization-wait-and-notify-3488a8252b56
 */
public class RaceConditionExample {

    private final Object lockOnIncrement = new Object();
    private final Object lockOnDecrement = new Object();
    private int valueToBeIncreased = 0;
    private int valueToBeDecreased = 10000;

    public void increment() {
        for(int i=0;i<10000;i++) {
            synchronized (lockOnIncrement) {
                valueToBeIncreased++;
            }
        }
    }

    public void decrement() {
        for(int i=0;i<10000;i++) {
            synchronized (lockOnDecrement) {
                valueToBeDecreased--;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long startTime = new Date().toInstant().toEpochMilli();
        RaceConditionExample raceConditionExample = new RaceConditionExample();
        Thread incrThread = new Thread(raceConditionExample::increment);
        Thread decrThread = new Thread(raceConditionExample::decrement);
        incrThread.start();
        decrThread.start();
        incrThread.join();
        decrThread.join();
        System.out.println("Incremented Value : " + raceConditionExample.valueToBeIncreased);
        System.out.println("Decremented Value : " + raceConditionExample.valueToBeDecreased);
        System.out.println(new Date().toInstant().toEpochMilli() - startTime);
    }
}
