package org.example.multithreading;

public class CustomBlockingQueue {

    private QueueNode front;
    private QueueNode rear;
    private int length;
    private final int size;

    public CustomBlockingQueue(int size) {
        this.size=size;
    }

    public synchronized void offer(int data) throws InterruptedException {
        if(isFull()) {
            System.out.println("Maximum capacity reached. Hence waiting for take() operation");
            wait();
        }
        QueueNode newNode = new QueueNode(data);
        if(isEmpty()) {
            front=newNode;
        } else {
            rear.setNextNode(newNode);
        }
        rear=newNode;
        length++;
        System.out.println("Data added in the queue. Going to notify the observers.");
        notifyAll();
    }

    public synchronized int take() throws InterruptedException {
        if(isEmpty()) {
            System.out.println("No data found in the queue. take()() method execution paused.");
            wait();
        }
        int data = Integer.MIN_VALUE;
        data= front.getData();
        front=front.getNextNode();
        length--;
        notifyAll();
        return data;
    }

    public boolean isEmpty() {
        return length==0;
    }

    public boolean isFull() {
        return length>=size;
    }

    public static void main(String[] args) {
        CustomBlockingQueue bq = new CustomBlockingQueue(3);
        new Thread(()->{
            try {
                bq.offer(1);
                bq.offer(2);
                bq.offer(3);
                bq.offer(4);
                bq.offer(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(()->{
            try {
                System.out.println(bq.take());
                System.out.println(bq.take());
                System.out.println(bq.take());
                System.out.println(bq.take());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}

class QueueNode {
    private int data;
    private QueueNode nextNode;

    public QueueNode(int data) {
        this.data=data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public QueueNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(QueueNode nextNode) {
        this.nextNode = nextNode;
    }
}
