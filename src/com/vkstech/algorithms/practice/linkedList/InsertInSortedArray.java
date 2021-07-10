package com.vkstech.algorithms.practice.linkedList;

import static com.vkstech.algorithms.practice.linkedList.LinkedList.Node;
import static com.vkstech.algorithms.practice.linkedList.PrintLinkedList.printLinkedListOneline;


/**
 * Insert in a Sorted List
 * Given a sorted singly linked list and a data,
 * your task is to insert the data in the linked list in a sorted way i.e. order of the list doesn't change.
 * Eg: Input: LinkedList: 50->100, data: 75
 * Output: 50 75 100
 */
public class InsertInSortedArray {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(50);
        linkedList.insert(100);
        printLinkedListOneline(linkedList);

        insertData(linkedList, 75);
        printLinkedListOneline(linkedList);

        insertData(linkedList, 25);
        printLinkedListOneline(linkedList);

        insertData(linkedList, 120);
        printLinkedListOneline(linkedList);

        insertData(linkedList, 80);
        printLinkedListOneline(linkedList);
    }

    private static void insertData(LinkedList linkedList, int data) {
        if (linkedList == null)
            linkedList = new LinkedList();

        Node node = new Node(data);
        System.out.println("Inserting " + data);

        if (linkedList.head == null) {
            linkedList.head = node;
            return;
        }

        if (linkedList.head.data > data) {
            node.next = linkedList.head;
            linkedList.head = node;
            return;
        }

        Node previous = linkedList.head;
        Node current = previous.next;

        while (current != null) {
            if (previous.data <= data && data <= current.data) {
                node.next = current;
                previous.next = node;
                return;
            }
            previous = current;
            current = current.next;
        }

        previous.next = node;
    }
}
