package com.vkstech.algorithms.practice2.linkedlist;

public class SplitHalfCLL extends CircularLinkedList {

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList(1, 5, 7, 8, 9);
        cll.print();

        splitInHalf(cll);
    }

    private static void splitInHalf(CircularLinkedList cll) {
        if (cll.head == null || cll.head == cll.head.next) {
            return;
        }

        Node slow = cll.head;
        Node fast = cll.head.next;

        while (fast != cll.head && fast.next != cll.head) {
            slow = slow.next;
            fast = fast.next.next;
        }

        CircularLinkedList firstHalf = getCircularLinkedList(cll.head, slow.next);
        CircularLinkedList secondHalf = getCircularLinkedList(slow.next, cll.head);

        firstHalf.print();
        secondHalf.print();
    }

    private static CircularLinkedList getCircularLinkedList(Node start, Node end) {
        CircularLinkedList circularLinkedList = new CircularLinkedList();

        circularLinkedList.head = new Node(start.data);
        Node temp = circularLinkedList.head;
        start = start.next;

        while (start != end) {
            temp.next = new Node(start.data);
            start = start.next;
            temp = temp.next;
        }
        temp.next = circularLinkedList.head;
        return circularLinkedList;
    }
}
