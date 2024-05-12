package com.vkstech.algorithms.practice2.linkedlist;

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

        Node temp = dll.tail;
        while (r > 0) {
            temp = temp.next;
            r--;
        }

        dll.head = temp.next;
        dll.tail = temp;

        dll.head.previous = null;
        dll.tail.next = null;
    }
}
