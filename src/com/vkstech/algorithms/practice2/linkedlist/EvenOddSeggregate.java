package com.vkstech.algorithms.practice2.linkedlist;

import com.vkstech.algorithms.practice2.linkedlist.LinkedList.Node;

public class EvenOddSeggregate {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(17);
        linkedList.insert(15);
        linkedList.insert(8);
        linkedList.insert(9);
        linkedList.insert(2);
        linkedList.insert(4);
        linkedList.insert(6);
        System.out.println(linkedList);

        evenOddSegregate(linkedList);
        System.out.println(linkedList);
    }

    private static void evenOddSegregate(LinkedList linkedList) {
        Node current = linkedList.head;
        Node odd = new Node(-1);
        Node even = new Node(-1);

        Node firstEven = even;
        Node firstOdd = odd;

        while (current != null) {
            if (current.data % 2 == 0) {
                even.next = current;
                even = even.next;
            } else {
                odd.next = current;
                odd = odd.next;
            }
            current = current.next;
        }

        even.next = firstOdd.next;
        odd.next = null;
        linkedList.head = firstEven.next;
    }
}
