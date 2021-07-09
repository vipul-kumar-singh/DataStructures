package com.vkstech.algorithms.practice.linkedList;

import com.vkstech.algorithms.practice.linkedList.LinkedList.Node;

import static com.vkstech.algorithms.practice.linkedList.PrintLinkedList.printLinkedList;

/**
 * Rearrange a linked list
 * Given a singly linked list, the task is to rearrange it in a way that all odd position nodes are together
 * and all even positions node are together.
 * Assume the first element to be at position 1 followed by second element at position 2 and so on.
 * Eg: Input: LinkedList: 1->2->3->4->5, Output: 1 3 5 2 4
 */
public class OddEvenLinkedList {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        for (int i = 1; i <= 7; i++) {
            linkedList.insert(i);
        }

        rearrangeOddEven(linkedList);

        printLinkedList(linkedList);
    }

    private static void rearrangeOddEven(LinkedList linkedList) {
        if (linkedList.head == null || linkedList.head.next == null) {
            return;
        }

        Node odd = linkedList.head;
        Node even = odd.next;
        Node firstEven = odd.next;

        Node current = even.next;
        while (current != null) {

            odd.next = current;
            even.next = current.next;
            current.next = firstEven;

            odd = odd.next;
            even = even.next;

            if (even == null)
                break;

            current = even.next;
        }
    }
}
