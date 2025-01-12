package org.example.multithreading.lockfree;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {

    public static void main(String[] args) {
        ProblematicSolution problematicSolution = new ProblematicSolution();
        Thread t1 = new Thread(() -> {
            try {
                problematicSolution.incr();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                problematicSolution.incr();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();
        /*
        Problematic Answer:: 395
        Problematic Answer:: 394
         */
        
        LockFreeSolution lockFreeSolution = new LockFreeSolution();
        Thread t3 = new Thread(() -> {
            try {
                lockFreeSolution.incr();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t4 = new Thread(() -> {
            try {
                lockFreeSolution.incr();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t3.start();
        t4.start();
        /*
        LockFreeSolution Answer:: 398
        LockFreeSolution Answer:: 400
         */
    }
}

class ProblematicSolution {
    int res=0;

    void incr() throws InterruptedException {
        for(int i=0; i<200; i++) {
            Thread.sleep(5);
            res++;
        }
        System.out.println("Problematic Answer:: "+ res);
    }
}

class LockFreeSolution {
    AtomicInteger res = new AtomicInteger(0);
    
    void incr() throws InterruptedException {
        for(AtomicInteger i= new AtomicInteger(0); i.intValue()<200; i.incrementAndGet()) {
            Thread.sleep(5);
            res.incrementAndGet();
        }
        System.out.println("LockFreeSolution Answer:: "+ res);
    }
}
