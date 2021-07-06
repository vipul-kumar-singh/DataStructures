package com.vkstech.algorithms.practice.linkedList;

import static com.vkstech.algorithms.practice.linkedList.LinkedList.Node;
import static com.vkstech.algorithms.practice.linkedList.PrintLinkedList.printLinkedList;

/**
 * Node at a given index in linked list
 */
public class InsertAtIndex {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        insertAt(linkedList, 0, 1);
        insertAt(linkedList, 0, 0);
        insertAt(linkedList, 2, 4);
        insertAt(linkedList, 2, 2);
        insertAt(linkedList, 3, 3);
        insertAt(linkedList, 5, 5);
        insertAt(linkedList, 0, -1);
        insertAt(linkedList, 7, 6);

        printLinkedList(linkedList);
    }

    private static void insertAt(LinkedList linkedList, int index, int data) {
        Node node = new Node(data);

        if (index == 0) {
            node.next = linkedList.head;
            linkedList.head = node;
            return;
        }

        Node temp = linkedList.head;
        while (index > 1 && temp != null) {
            temp = temp.next;
            index--;
        }

        if (temp == null)
            throw new IndexOutOfBoundsException("Invalid index");

        node.next = temp.next;
        temp.next = node;
    }
}
