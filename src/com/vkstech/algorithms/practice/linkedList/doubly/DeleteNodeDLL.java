package com.vkstech.algorithms.practice.linkedList.doubly;

/**
 * Delete node in Doubly Linked List
 * Given a doubly linked list and a position.
 * The task is to delete a node from given position in a doubly linked list.
 * Example : Input: 1 <-> 3 <-> 4, x = 3
 * Output: 1 <-> 3
 */
public class DeleteNodeDLL extends DoublyLinkedList {

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList(1, 3, 4);
        dll.print();
        deleteNodeAtPos(dll, 3);
        dll.print();

        deleteNodeAtPos(dll, 3);

        deleteNodeAtPos(dll, 2);
        dll.print();

        deleteNodeAtPos(dll, 1);
        dll.print();

        deleteNodeAtPos(dll, 1);
        deleteNodeAtPos(dll, -1);

    }

    public static void deleteAtHead(DoublyLinkedList dll) {
        if (dll.isEmpty()) {
            System.out.println("List is Empty");
            return;
        }

        if (dll.head.next == null) {
            dll.head = dll.tail = null;
        } else {
            dll.head = dll.head.next;
            dll.head.previous = null;
        }
    }

    public static void deleteAtTail(DoublyLinkedList dll) {
        if (dll.isEmpty()) {
            System.out.println("List is Empty");
            return;
        }

        if (dll.tail.previous == null) {
            dll.head = dll.tail = null;
        } else {
            dll.tail = dll.tail.previous;
            dll.tail.next = null;
        }
    }

    public static void deleteNodeAtPos(DoublyLinkedList dll, int pos) {
        if (pos < 1) {
            System.out.println("Invalid position");
            return;
        }

        Node temp = dll.head;
        while (pos > 1) {
            temp = temp.next;
            if (temp == null) {
                System.out.println("Invalid position");
                return;
            }
            pos--;
        }

        if (temp == dll.head) {
            deleteAtHead(dll);
            return;
        }

        if (temp == dll.tail) {
            deleteAtTail(dll);
            return;
        }

        temp.previous.next = temp.next;
        temp.next.previous = temp.previous;
        temp.next = null;
        temp.previous = null;
    }
}
