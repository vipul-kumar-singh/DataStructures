package com.vkstech.algorithms.practice3.linkedList.doubly;

import static com.vkstech.algorithms.practice3.linkedList.doubly.MDoublyLinkedList.Node;

// https://www.geeksforgeeks.org/problems/insert-in-sorted-way-in-a-sorted-dll/1
public class SortedInsertion {

    public static void main(String[] args) {
        MDoublyLinkedList dll = new MDoublyLinkedList();
        dll.insertMultiple(3, 5, 8, 10, 12);
        sortedInsert(dll.head, 9);
        sortedInsert(dll.head, 2);
        sortedInsert(dll.head, 13);
        sortedInsert(dll.head, 8);
        dll.print();
    }

    public static Node sortedInsert(Node head, int x) {
        Node node = new Node(x);

        if (head == null) {
            head = node;
            return head;
        }

        if (head.data > x) {
            node.next = head;
            head.prev = node;
            head = node;
            return head;
        }

        Node temp = head;

        while (temp.data <= x && temp.next != null) {
            temp = temp.next;
        }

        if (temp.data > x) {
            temp = temp.prev;
        }

        node.next = temp.next;
        node.prev = temp;
        temp.next = node;

        if (node.next != null)
            node.next.prev = node;

        return head;
    }
}