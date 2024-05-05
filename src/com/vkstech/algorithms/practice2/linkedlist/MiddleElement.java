package com.vkstech.algorithms.practice2.linkedlist;

import com.vkstech.algorithms.practice2.linkedlist.LinkedList.Node;

public class MiddleElement {

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        for (int i = 1; i <= 10; i++)
            ll.insert(i);

        int x = getMiddleElement(ll);
        System.out.println(x);
    }

    private static int getMiddleElement(LinkedList ll) {
        Node slow = ll.head;
        Node fast = ll.head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }
}
