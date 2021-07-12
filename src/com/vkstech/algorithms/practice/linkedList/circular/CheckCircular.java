package com.vkstech.algorithms.practice.linkedList.circular;

/**
 * Check If Circular Linked List
 * Given a singly linked list, find if the linked list is circular or not.
 * A linked list is called circular if it not NULL terminated and all nodes are connected in the form of a cycle.
 * An empty linked list is considered as circular.
 */
public class CheckCircular extends CircularLinkedList {

    public static void main(String[] args) {
        CircularLinkedList circularLinkedList = new CircularLinkedList(1, 2, 3, 4, 5);
        circularLinkedList.print();
        System.out.println(checkCircular(circularLinkedList));

        circularLinkedList.removeCircular();
        System.out.println(checkCircular(circularLinkedList));
    }

    private static boolean checkCircular(CircularLinkedList linkedList) {
        if (linkedList == null)
            return true;

        Node temp = linkedList.head;
        while (temp != null) {
            if (temp.next == linkedList.head)
                return true;

            temp = temp.next;
        }
        return false;
    }
}
