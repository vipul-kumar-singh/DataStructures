package com.vkstech.algorithms.practice2.linkedlist;

import com.vkstech.algorithms.practice2.linkedlist.LinkedList.Node;

public class RearrangeLinkedList {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        for (int i = 1; i <= 10; i++)
            linkedList.insert(i);
        System.out.println(linkedList);

        reArrange(linkedList);
        System.out.println(linkedList);
    }

    private static void reArrange(LinkedList linkedList) {
        if (linkedList.head == null || linkedList.head.next == null) {
            return;
        }

        Node odd = linkedList.head;
        Node even = odd.next;

        Node firstEven = odd.next;

        while (odd.next != null && even.next != null) {

            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        odd.next = firstEven;
    }
}
