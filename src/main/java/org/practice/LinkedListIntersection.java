package org.practice;

public class LinkedListIntersection {

    public static void main(String[] args) {
        LinkedNode head1 = new LinkedNode(1);
        head1.next = new LinkedNode(2);
        head1.next.next = new LinkedNode(3);
        head1.next.next.next = new LinkedNode(4);

        LinkedNode head2 = new LinkedNode(10);
        head2.next = new LinkedNode(20);
        head2.next.next = new LinkedNode(30);
        head2.next.next.next = new LinkedNode(3);
        head2.next.next.next.next = new LinkedNode(40);

        LinkedNode ptrA = head1;
        LinkedNode ptrB = head2;

    }
}
