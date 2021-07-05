package com.vkstech.algorithms.practice.linkedList;

import static com.vkstech.algorithms.practice.linkedList.LinkedList.Node;

/**
 * Print Linked List elements
 */
public class CountNodes {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        for (int i = 1; i <= 4; i++) {
            linkedList.insert(i);
        }

        System.out.println(getCount(linkedList));
    }

    public static int getCount(LinkedList linkedList) {
        Node temp = linkedList.head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
