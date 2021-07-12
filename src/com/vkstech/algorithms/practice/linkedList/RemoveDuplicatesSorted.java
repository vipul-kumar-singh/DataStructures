package com.vkstech.algorithms.practice.linkedList;

/**
 * Remove duplicate element from sorted Linked List
 * Given a singly linked list consisting of N nodes.
 * The task is to remove duplicates (nodes with duplicate values) from the given list (if exists).
 * The nodes are arranged in a sorted way.
 * Input: LinkedList: 2->2->3->4->4->4->5
 * Output: 2->3->4->5
 */
public class RemoveDuplicatesSorted extends LinkedList {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertMultiple(2, 2, 3, 4, 4, 4, 5);
        PrintLinkedList.printLinkedListOneline(linkedList);

        removeDuplicates(linkedList);
        PrintLinkedList.printLinkedListOneline(linkedList);
    }

    private static void removeDuplicates(LinkedList linkedList) {
        if (linkedList == null || linkedList.head == null || linkedList.head.next == null)
            return;

        Node current = linkedList.head;
        Node next = current.next;

        while (next != null) {
            if (current.data == next.data) {
                current.next = next.next;
                next = current.next;
            } else {
                current = next;
                next = next.next;
            }
        }
    }
}
