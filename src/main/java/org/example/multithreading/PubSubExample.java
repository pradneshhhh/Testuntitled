package org.example.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * https://java-jedi.medium.com/multithreading-wait-notify-3002ecd0b555
 *
 * wait () — owner thread releases the lock, the other thread waiting for the lock can acquire the lock and start execution. Owner thread will wait until it is notified or interrupted. If thread is interrupted while wait(), it throws InterruptedException
 *
 * notify() — as soon as the thread finishes execution, it calls notify() to return the lock to the owner
 */
public class PubSubExample {
    int val = 0;
    public void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("Initial produced value: "+val);
            val++;
            System.out.println("Second produced value: "+val);
            wait();
            System.out.println("Latest value in producer: "+val);
        }
    }

    public void consume() {
        synchronized (this) {
            System.out.println("Initial consumed value: "+val);
            notify();
            val++;
        }
    }

    public static void main(String[] args) {
        PubSubExample pubSubExample = new PubSubExample();
        new Thread(() -> {
            try {
                pubSubExample.produce();
            } catch (Exception ex) {
                System.out.println("Producer exception: "+ ex.getMessage());
            }
        }).start();
        new Thread(() -> {
            try {
                pubSubExample.consume();
            } catch (Exception ex) {
                System.out.println("Consumer exception: "+ ex.getMessage());
            }
        }).start();

        ////////////////////////////////////////////////////////

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() ->{
        try {
            pubSubExample.produce();
        } catch (Exception ex) {
            System.out.println("Producer exception: "+ ex.getMessage());
        }});

        executorService.submit(() ->{
            try {
                pubSubExample.consume();
            } catch (Exception ex) {
                System.out.println("Producer exception: "+ ex.getMessage());
            }});
        executorService.shutdown();
    }
}
