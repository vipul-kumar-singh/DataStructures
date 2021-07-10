package com.vkstech.algorithms.practice.linkedList;

import com.vkstech.algorithms.practice.linkedList.LinkedList.Node;

import static com.vkstech.algorithms.practice.linkedList.PrintLinkedList.printLinkedListOneline;

/**
 * Reverse a Linked List in groups of given size.
 * Given a linked list of size N.
 * The task is to reverse every k nodes (where k is an input to the function) in the linked list.
 * Example 1: Input: LinkedList: 1->2->2->4->5->6->7->8, K = 4
 * Output: 4 2 2 1 8 7 6 5
 * Example 2: Input: LinkedList: 1->2->3->4->5, K = 3
 * Output: 3 2 1 5 4
 */
public class ReverseGroup {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        for (int i = 1; i <= 5; i++)
            linkedList.insert(i);

        linkedList.head = reverseGroup(linkedList.head, 3);
        printLinkedListOneline(linkedList);
    }

    private static Node reverseGroup(Node head, int k) {
        if (head == null)
            return null;

        Node current = head;
        Node next = null;
        Node prev = null;

        int count = 0;

        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        if (next != null)
            head.next = reverseGroup(next, k);

        return prev;
    }
}
