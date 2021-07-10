package com.vkstech.algorithms.practice.linkedList;

import com.vkstech.algorithms.practice.linkedList.LinkedList.Node;

import static com.vkstech.algorithms.practice.linkedList.PrintLinkedList.printLinkedListOneline;


/**
 * Pairwise swap elements of a linked list.
 * Given a singly linked list of size N. The task is to swap elements in the linked list pairwise.
 * For example, if the input list is 1 2 3 4, the resulting list after swaps will be 2 1 4 3.
 * Note: You need to swap the nodes, not only the data.
 */
public class PairSwap {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        for (int i = 1; i <= 4; i++)
            linkedList.insert(i);

        printLinkedListOneline(linkedList);
        pairWiseSwap(linkedList);
        printLinkedListOneline(linkedList);
    }

    private static void pairWiseSwap(LinkedList linkedList) {
        if (linkedList == null || linkedList.head == null || linkedList.head.next == null)
            return;

        // set first two elements
        Node i = linkedList.head;
        Node j = i.next;

        // swap first two elements
        Node temp = j.next;
        j.next = i;
        i.next = temp;
        linkedList.head = j;

        // Swap next pairs
        Node previous = i;
        i = i.next;

        while (i != null && i.next != null) {

            j = i.next;
            temp = j.next;
            j.next = i;
            i.next = temp;
            previous.next = j;

            previous = i;
            i = i.next;
        }
    }
}
