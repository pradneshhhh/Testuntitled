package org.example.stack;

public class Stack {

    private int bottom;
    private int top;
    private int idx;
    private int size;
    private int[] arr;

    public Stack(int size) {
        arr = new int[size];
        bottom = 0;
        idx = 0;
        top = size-1;
    }

    public void push(int item) {
        if(!isEmpty() || isFull()) {
            arr[idx] = item;
            idx += 1;
        }
    }

    public int pop() {
        int res = 0;
        if(!isEmpty() || isFull()) {
            res = arr[idx-1];
            arr[idx-1] = 0;
            idx -= 1;
        }
        return res;
    }

    public boolean isEmpty() {
        return idx<0;
    }

    public boolean isFull() {
        return arr.length < idx;
    }

    public static void main(String[] args) {
        Stack stack = new Stack(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop()+" "+stack.isEmpty());
    }
}
