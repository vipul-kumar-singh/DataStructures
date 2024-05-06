package com.vkstech.algorithms.practice2.linkedlist;

import static com.vkstech.algorithms.practice2.linkedlist.LinkedList.Node;

public class ReverseLinkedList {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        for (int i = 1; i <= 10; i++)
            linkedList.insert(i);

        System.out.println(linkedList);
        reverseLinkedList(linkedList);
        System.out.println(linkedList);
    }

    private static void reverseLinkedList(LinkedList linkedList) {
        Node prev = null;
        Node current = linkedList.head;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        linkedList.head = prev;
    }

}
