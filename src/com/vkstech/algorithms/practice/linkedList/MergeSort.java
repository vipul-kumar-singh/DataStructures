package com.vkstech.algorithms.practice.linkedList;

/**
 * Merge Sort for Linked List
 */
public class MergeSort extends LinkedList {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertMultiple(3, 5, 2, 4, 1);
        PrintLinkedList.printLinkedListOneline(linkedList);

        linkedList.head = mergeSort(linkedList.head);
        PrintLinkedList.printLinkedListOneline(linkedList);
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

        LinkedList mergedList = new LinkedList();
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
