package com.vkstech.algorithms.practice.linkedList;

import java.util.Objects;

/**
 * Given two singly linked lists of size N and M,
 * write a program to get the point where two linked lists intersect each other.
 */
public class IntersectionPoint extends LinkedList {

    private static Node getCommonLinkedList(LinkedList linkedList1, LinkedList linkedList2) {
        if (linkedList1.head == null || linkedList2.head == null)
            return null;

        Node i = linkedList1.head;
        Node j = linkedList2.head;
        while (i != null || j != null) {
            if (i == j)
                return i;

            i = i.next;
            j = j.next;

            if (i == null && j != null)
                i = linkedList2.head;

            if (j == null && i != null)
                j = linkedList1.head;


        }
        return null;

    }

    public static void main(String[] args) {
        LinkedList linkedList1 = new LinkedList();
        for (int i = 1; i < 4; i++)
            linkedList1.insert(i);

        LinkedList linkedList2 = new LinkedList();
        for (int i = 8; i > 4; i--)
            linkedList2.insert(i);

        LinkedList common = new LinkedList();
        for (int i = 9; i < 12; i++)
            common.insert(i);

        LinkedList.Node temp1 = linkedList1.head;
        while (Objects.nonNull(temp1.next))
            temp1 = temp1.next;
        temp1.next = common.head;

        LinkedList.Node temp2 = linkedList2.head;
        while (Objects.nonNull(temp2.next))
            temp2 = temp2.next;
        temp2.next = common.head;

        System.out.println("LinkedList 1 :");
        PrintLinkedList.printLinkedListOneline(linkedList1);
        System.out.println("LinkedList 2 :");
        PrintLinkedList.printLinkedListOneline(linkedList2);

        LinkedList linkedList3 = new LinkedList();
        linkedList3.head = getCommonLinkedList(linkedList1, linkedList2);
        System.out.println("Common LinkedList :");
        PrintLinkedList.printLinkedListOneline(linkedList3);
    }
}
