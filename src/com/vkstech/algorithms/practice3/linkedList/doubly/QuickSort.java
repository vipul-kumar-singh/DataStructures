package com.vkstech.algorithms.practice3.linkedList.doubly;

import static com.vkstech.algorithms.practice3.linkedList.doubly.MDoublyLinkedList.Node;

// https://www.geeksforgeeks.org/problems/quicksort-on-doubly-linked-list/1
public class QuickSort {

    public static void main(String[] args) {
        MDoublyLinkedList dll1 = new MDoublyLinkedList();
        dll1.insertMultiple(4, 2, 9);
        quickSort(dll1.head);
        dll1.print();

        MDoublyLinkedList dll2 = new MDoublyLinkedList();
        dll2.insertMultiple(1, 4, 9, 2);
        quickSort(dll2.head);
        dll2.print();
    }

    private static Node quickSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        quickSort(head, temp);
        return head;
    }

    private static void quickSort(Node left, Node right) {
        if (left != null && right != null && left != right.next) {
            Node p = partition(left, right);
            quickSort(left, p.prev);
            quickSort(p.next, right);
        }
    }

    private static Node partition(Node left, Node right) {
        Node p = left.prev;

        for (Node i = left; i != right; i = i.next) {
            if (i.data < right.data) {
                p = p == null ? left : p.next;
                swap(i, p);
            }
        }

        p = p == null ? left : p.next;
        swap(p, right);

        return p;
    }

    private static void swap(Node left, Node right) {
        int temp = left.data;
        left.data = right.data;
        right.data = temp;
    }
}
