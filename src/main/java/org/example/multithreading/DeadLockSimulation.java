package org.example.multithreading;

public class DeadLockSimulation {

    static class SyncThread implements Runnable {

        private final Object obj1;
        private final Object obj2;

        public SyncThread(Object obj1, Object obj2) {
            this.obj1 = obj1;
            this.obj2 = obj2;
        }

        @Override
        public void run() {
            String tName = Thread.currentThread().getName();
            synchronized (obj1) {
                System.out.println(tName+" acquired lock on "+obj1);
                work();
                synchronized (obj2) {
                    System.out.println(tName+" acquired lock on "+obj2);
                    work();
                }
                System.out.println(tName+" released lock on "+obj2);
            }
            System.out.println(tName+" released lock on "+obj1);
            System.out.println(tName + " finished execution.");
        }

        private void work() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public static void main(String[] args) {
        final Object obj1 = new Object();
        final Object obj2 = new Object();
        final Object obj3 = new Object();

        new Thread(new SyncThread(obj1, obj2), "t1").start();
        new Thread(new SyncThread(obj2, obj3), "t2").start();
        new Thread(new SyncThread(obj3, obj1), "t3").start();
    }

}
