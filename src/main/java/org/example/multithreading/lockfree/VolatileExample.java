package org.example.multithreading.lockfree;

public class VolatileExample {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Thread t1 = new Thread(() -> {
            try {
                solution.incr();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                solution.incr();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();
        /*
        Doesn't guarantee the result as the data is fetched from RAM
        Solution :: 379
        Solution :: 381
         */
    }
}

class Solution {
    volatile int res=0;

    void incr() throws InterruptedException {
        for(int i=0; i<200; i++) {
            Thread.sleep(5);
            res++;
        }
        System.out.println("Solution :: "+ res);
    }
}
