package com.vkstech.algorithms.practice.linkedList;

import com.vkstech.algorithms.practice.linkedList.LinkedList.Node;

import static com.vkstech.algorithms.practice.linkedList.PrintLinkedList.printLinkedList;

/**
 * Given a singly linked list, your task is to remove every kth node from the linked list.
 * Example:
 * Input: ll = {1 2 3 4 5 6 7 8}, k = 3
 * Output: 1 2 4 5 7 8
 */
public class RemoveEveryKthNode {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        for (int i = 1; i <= 8; i++)
            linkedList.insert(i);

        removeKthNode(linkedList, 3);
        printLinkedList(linkedList);
    }

    private static void removeKthNode(LinkedList linkedList, int k) {
        if (linkedList.head == null || k < 1) {
            return;
        }

        Node current = linkedList.head;
        Node previous = current;
        for (int i = 1; current != null; i++) {
            if (i % k == 0) {
                previous.next = current.next;
            } else {
                previous = current;
            }
            current = current.next;
        }
    }
}
