package org.example.multithreading.threadpool;

import java.util.concurrent.*;

public class ThreadPoolCreationExample {

    public static void main(String[] args) {

        /**
         * corePoolSize: 2
         * maximumPoolSize: 4
         * keepAliveTime: 10
         * TimeUnit: MINUTES
         * workQueue: ArrayBlockingQueue<>(2)
         * threadFactory: Executors.defaultThreadFactory()
         * RejectedExecutionHandler: CustomRejectedExecutionHandler
         */
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 10,
                TimeUnit.MINUTES, new ArrayBlockingQueue<>(2), Executors.defaultThreadFactory(), new CustomRejectedExecutionHandler());

        for(int task=1; task<=4; task++) {
            int taskWIP = task;
            threadPoolExecutor.submit(() -> {
                try {
                    Thread.sleep(2000);
                    System.out.println("Task number:: "+ taskWIP +" is completed by "+ Thread.currentThread().getName());
                } catch (InterruptedException ex) {
                    System.out.println("Exception occurred "+ ex.getMessage());
                }
            });
        }
        threadPoolExecutor.shutdown();
    }
}

class CustomRejectedExecutionHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Rejected task execution:: "+r.toString());
    }
}
