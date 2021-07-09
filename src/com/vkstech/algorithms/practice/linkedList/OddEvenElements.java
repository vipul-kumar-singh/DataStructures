package com.vkstech.algorithms.practice.linkedList;

import com.vkstech.algorithms.practice.linkedList.LinkedList.Node;

import static com.vkstech.algorithms.practice.linkedList.PrintLinkedList.printLinkedList;

/**
 * Segregate even and odd nodes in a Linked List
 * Given a link list of size N, modify the list such that all the even numbers appear before all the odd numbers in the modified list.
 * The order of appearance of numbers within each segregation should be same as that in the original list.
 * Input: Link List = 17 -> 15 -> 8 -> 9 -> 2 -> 4 -> 6 -> NULL
 * Output: 8 2 4 6 17 15 9
 */
public class OddEvenElements {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(17);
        linkedList.insert(15);
        linkedList.insert(8);
        linkedList.insert(9);
        linkedList.insert(2);
        linkedList.insert(4);
        linkedList.insert(6);

        segregateOddEven(linkedList);
        printLinkedList(linkedList);
    }

    private static void segregateOddEven(LinkedList linkedList) {
        if (linkedList.head == null || linkedList.head.next == null)
            return;

        LinkedList oddLinkedList = new LinkedList();

        while (linkedList.head.data % 2 != 0) {
            oddLinkedList.insert(linkedList.head.data);
            linkedList.head = linkedList.head.next;
        }

        Node previous = linkedList.head;
        Node current = linkedList.head.next;
        while (current != null) {
            if (current.data % 2 != 0) {
                oddLinkedList.insert(current.data);
                current = current.next;
                previous.next = current;
            } else {
                previous = current;
                current = current.next;
            }
        }

        previous.next = oddLinkedList.head;
    }
}
