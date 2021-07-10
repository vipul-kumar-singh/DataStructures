package com.vkstech.algorithms.practice.linkedList;

import static com.vkstech.algorithms.practice.linkedList.LinkedList.Node;
import static com.vkstech.algorithms.practice.linkedList.PrintLinkedList.printLinkedListOneline;

/**
 * Reverse a linked list
 * Given a linked list of N nodes. The task is to reverse this list.
 */
public class Reverse {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        for (int i = 1; i <= 1; i++)
            linkedList.insert(i);

        printLinkedListOneline(linkedList);
        reverseLinkedList(linkedList);
        printLinkedListOneline(linkedList);
    }

    private static void reverseLinkedList(LinkedList linkedList) {
        Node prev = null;
        Node current = linkedList.head;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        linkedList.head = prev;
    }


}
