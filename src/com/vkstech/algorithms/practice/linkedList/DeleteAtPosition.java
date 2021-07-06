package com.vkstech.algorithms.practice.linkedList;

import com.vkstech.algorithms.practice.linkedList.LinkedList.Node;

import static com.vkstech.algorithms.practice.linkedList.PrintLinkedList.printLinkedList;

/**
 * Delete a Node in Single Linked List
 * Delete xth node from a singly linked list.
 */
public class DeleteAtPosition {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        for (int i = 1; i <= 5; i++)
            linkedList.insert(i);

        printLinkedList(linkedList);
        deleteAtPos(linkedList, 1);
        printLinkedList(linkedList);

        deleteAtPos(linkedList, 4);
        printLinkedList(linkedList);

        deleteAtPos(linkedList, 2);
        printLinkedList(linkedList);

        deleteAtPos(linkedList, 3);
        printLinkedList(linkedList);

    }

    private static void deleteAtPos(LinkedList linkedList, int n) {
        if (n == 1) {
            Node temp = linkedList.head;
            linkedList.head = linkedList.head.next;
            temp.next = null;
            System.out.println("Removed " + temp.data);
            return;
        }

        Node previous = null;
        Node current = linkedList.head;

        while (n > 1) {
            previous = current;
            current = current.next;

            if (current == null)
                throw new IndexOutOfBoundsException();

            n--;
        }

        previous.next = current.next;
        current.next = null;
        System.out.println("Removed " + current.data);
    }
}
