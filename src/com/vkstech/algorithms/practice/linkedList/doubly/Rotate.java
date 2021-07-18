package com.vkstech.algorithms.practice.linkedList.doubly;

/**
 * Rotate doubly Linked List
 * Given a doubly linked list, rotate the linked list counter-clockwise by P nodes.
 * Here P is a given positive integer and is smaller than the count of nodes(N) in a linked list.
 * Example: Input: 1<->2<->3<->4<->5<->6, r = 2
 * Output:  3<->4<->5<->6<->1<->2
 */
public class Rotate extends DoublyLinkedList {

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList(1, 2, 3, 4, 5, 6);
        dll.print();

        rotateDll(dll, 2);
        dll.print();

        rotateDll(dll, 4);
        dll.print();

        rotateDll(dll, 0);
        dll.print();

        rotateDll(dll, 6);
        dll.print();
    }

    private static void rotateDll(DoublyLinkedList dll, int r) {
        dll.tail.next = dll.head;
        dll.head.previous = dll.tail;

        Node temp = dll.head;
        while (r > 0) {
            temp = temp.next;
            r--;
        }

        dll.tail = temp.previous;
        dll.head = temp;

        dll.tail.next = null;
        dll.head.previous = null;
    }
}
