package com.vkstech.algorithms.practice.linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * Remove duplicates from an unsorted linked list
 * Given an unsorted linked list of N nodes. The task is to remove duplicate elements from this unsorted Linked List.
 * When a value appears in multiple nodes, the node which appeared first should be kept,
 * all others duplicates are to be removed.
 * Input: LinkedList: 2->4->5->2->3->4->3
 * Output: 2->4->5->3
 */
public class RemoveDuplicatesUnSorted extends LinkedList {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertMultiple(2, 4, 5, 2, 3, 4, 3);
        PrintLinkedList.printLinkedListOneline(linkedList);

        removeDuplicates(linkedList);
        PrintLinkedList.printLinkedListOneline(linkedList);
    }

    private static void removeDuplicates(LinkedList linkedList) {
        if (linkedList == null || linkedList.head == null || linkedList.head.next == null)
            return;

        Set<Integer> set = new HashSet<>();

        Node current = linkedList.head;
        Node next = current.next;

        while (next != null) {
            set.add(current.data);
            if (set.contains(next.data)) {
                current.next = next.next;
                next = current.next;
            } else {
                current = next;
                next = next.next;
            }
        }
    }
}
