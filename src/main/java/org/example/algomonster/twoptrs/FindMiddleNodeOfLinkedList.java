package org.example.algomonster.twoptrs;

/**
 * Find the middle node of a linked list.
 *
 * Input: 0 1 2 3 4
 *
 * Output: 2
 *
 * If the number of nodes is even, then return the second middle node.
 *
 * Input: 0 1 2 3 4 5
 *
 * Output: 3
 */
public class FindMiddleNodeOfLinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public FindMiddleNodeOfLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public static int findMiddleNodeOfLinkedList(Node root) {
        Node slowPtr = root;
        Node fastPtr = root;
        while(fastPtr!=null && fastPtr.next!=null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }
        return slowPtr.value;
    }

    public static void main(String[] args) {
        FindMiddleNodeOfLinkedList linkedList = new FindMiddleNodeOfLinkedList(0);
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        System.out.println(findMiddleNodeOfLinkedList(linkedList.head));
    }
}
