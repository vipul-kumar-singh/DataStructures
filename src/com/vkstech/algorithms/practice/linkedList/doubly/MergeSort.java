package com.vkstech.algorithms.practice.linkedList.doubly;

public class MergeSort extends DoublyLinkedList {

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList(1, 4, 8, 5, 2);
        dll.print();

        dll.head = mergeSort(dll.head);
        dll.print();
    }

    private static Node mergeSort(Node head) {
        if (head == null || head.next == null)
            return head;

        Node previous = head;
        Node mid = head;
        Node last = head;

        while (last != null && last.next != null) {
            previous = mid;
            mid = mid.next;
            last = last.next.next;
        }
        previous.next = null;

        return merge(head, mid);
    }

    private static Node merge(Node head1, Node head2) {
        if (head1 == null)
            return head2;

        if (head2 == null)
            return head1;

        if (head1.next != null)
            head1 = mergeSort(head1);

        if (head2.next != null)
            head2 = mergeSort(head2);

        Node i = head1;
        Node j = head2;

        DoublyLinkedList mergedList = new DoublyLinkedList();
        Node temp = mergedList.head;
        while (i != null || j != null) {
            int data;
            if (i == null) {
                data = j.data;
                j = j.next;
            } else if (j == null) {
                data = i.data;
                i = i.next;
            } else {
                if (i.data < j.data) {
                    data = i.data;
                    i = i.next;
                } else if (i.data > j.data) {
                    data = j.data;
                    j = j.next;
                } else {
                    data = i.data;
                    i = i.next;
                    j = j.next;
                }
            }
            Node node = new Node(data);
            if (temp == null) {
                mergedList.head = node;
                temp = mergedList.head;
            } else {
                temp.next = node;
                temp = temp.next;
            }

        }
        return mergedList.head;
    }
}
