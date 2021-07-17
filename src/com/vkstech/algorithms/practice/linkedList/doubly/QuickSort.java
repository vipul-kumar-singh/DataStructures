package com.vkstech.algorithms.practice.linkedList.doubly;

/**
 * QuickSort on Doubly Linked List
 */
public class QuickSort extends DoublyLinkedList {

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList(1, 4, 8, 5, 2);
        dll.print();

        quickSort(dll.head, dll.tail);
        dll.print();
    }

    private static void quickSort(Node left, Node right) {
        if (right != null && left != right && left != right.next) {
            Node p = partition(left, right);
            quickSort(left, p.previous);
            quickSort(p.next, right);
        }
    }

    private static Node partition(Node left, Node right) {
        Node i = left.previous;
        for (Node ptr = left; ptr != right; ptr = ptr.next) {
            if (ptr.data <= right.data) {
                i = i == null ? left : i.next;
                swap(i, ptr);
            }
        }
        i = i == null ? left : i.next;
        swap(i, right);
        return i;
    }

    private static void swap(Node i, Node j) {
        int temp = i.data;
        i.data = j.data;
        j.data = temp;
    }


}
