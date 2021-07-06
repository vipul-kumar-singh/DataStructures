package com.vkstech.algorithms.practice.linkedList;

import com.vkstech.algorithms.practice.linkedList.LinkedList.Node;

/**
 * Finding middle element in a linked list
 * Given a singly linked list of N nodes. The task is to find the middle of the linked list.
 * For example, if given linked list is 1->2->3->4->5 then the output should be 3.
 * If there are even nodes, then there would be two middle nodes, we need to print the second middle element.
 * For example, if given linked list is 1->2->3->4->5->6 then the output should be 4.
 */
public class MiddleElement {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        for (int i = 1; i <= 5; i++)
            linkedList.insert(i);

        System.out.println(getMiddleElement(linkedList));

        linkedList.insert(6);
        System.out.println(getMiddleElement(linkedList));
    }

    private static int getMiddleElement(LinkedList linkedList) {
        Node slow = linkedList.head;
        Node fast = linkedList.head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }
}
