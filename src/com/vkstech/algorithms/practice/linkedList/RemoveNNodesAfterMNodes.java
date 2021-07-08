package com.vkstech.algorithms.practice.linkedList;

import com.vkstech.algorithms.practice.linkedList.LinkedList.Node;

import static com.vkstech.algorithms.practice.linkedList.PrintLinkedList.printLinkedList;

/**
 * Delete N nodes after M nodes of a linked list
 * Given a linked list, delete N nodes after skipping M nodes of a linked list until the last of the linked list.
 * Eg: Input : 9 1 3 5 9 4 10 1, M = 2, N = 1
 * Output :  9 1 5 9 10 1
 * Explanation: Deleting one node after skipping the two nodes each time, we have list as 9-> 1-> 5-> 9-> 10-> 1.
 */
public class RemoveNNodesAfterMNodes {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(9);
        linkedList.insert(1);
        linkedList.insert(3);
        linkedList.insert(5);
        linkedList.insert(9);
        linkedList.insert(5);
        linkedList.insert(10);
        linkedList.insert(1);

        removeNodes(linkedList, 2, 1);
        printLinkedList(linkedList);

    }

    private static void removeNodes(LinkedList linkedList, int m, int n) {
        if (linkedList.head == null)
            return;

        Node previous = linkedList.head;
        Node current = linkedList.head;
        int i = 0;
        int j = 0;

        while (current != null) {
            if (i == m && j < n) {
                previous.next = current.next;
                current = previous.next;
                j++;
                continue;
            }

            if (j == n) {
                i = 0;
                j = 0;
            }

            previous = current;
            current = current.next;
            i++;
        }
    }

}
