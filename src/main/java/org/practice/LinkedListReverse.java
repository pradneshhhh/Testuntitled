package org.practice;

class LinkedNode {
    int val;
    LinkedNode next;
    public LinkedNode(int val) {
        this.val=val;
    }
}

public class LinkedListReverse {

    private static void printLinedList(LinkedNode head) {
        while(head!=null) {
            System.out.print(" "+head.val);
            head=head.next;
        }
    }

    private static LinkedNode reverseLinkedList(LinkedNode head) {
        LinkedNode prev = null;
        LinkedNode curr = head;
        while (curr!=null) {
            LinkedNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }

    public static void main(String[] args) {
        LinkedNode head = new LinkedNode(1);
        head.next = new LinkedNode(2);
        head.next.next = new LinkedNode(3);
        head.next.next.next = new LinkedNode(4);

        printLinedList(head);
        System.out.println("\n---------------");
        printLinedList(reverseLinkedList(head));
    }
}
