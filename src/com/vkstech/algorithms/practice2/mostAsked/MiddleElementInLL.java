package com.vkstech.algorithms.practice2.mostAsked;

import com.vkstech.algorithms.practice2.linkedlist.LinkedList;
import com.vkstech.algorithms.practice2.linkedlist.LinkedList.Node;

public class MiddleElementInLL {

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        for (int i = 1; i <= 9; i++)
            ll.insert(i);

        int x = getMiddleElementInLL(ll);
        System.out.println(x);
    }

    private static int getMiddleElementInLL(LinkedList linkedList) {
        Node slow = linkedList.head;
        Node fast = linkedList.head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }
}
