package org.example.multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {

    public static void main(String[] args) throws Exception {

        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(3);

        ProducerBQ producer = new ProducerBQ(queue);
        ConsumerBQ consumer = new ConsumerBQ(queue);

        new Thread(producer).start();
        Thread.sleep(2000);
        new Thread(consumer).start();

    }
}

    class ProducerBQ implements Runnable{

        protected BlockingQueue<String> queue;

        public ProducerBQ(BlockingQueue<String> queue) {
            this.queue = queue;
        }

        public void run() {
            try {
                queue.put("1");
                Thread.sleep(1000);
                queue.put("2");
                Thread.sleep(1000);
                queue.put("3");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class ConsumerBQ implements Runnable{

        protected BlockingQueue<String> queue = null;

        public ConsumerBQ(BlockingQueue<String> queue) {
            this.queue = queue;
        }

        public void run() {
            try {
                System.out.println(queue.take());
                System.out.println(queue.take());
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


