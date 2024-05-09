package com.vkstech.algorithms.practice2.linkedlist;

import java.util.Objects;

public class IntersectionPoint extends LinkedList {

    private static Node getCommonLinkedList(LinkedList linkedList1, LinkedList linkedList2) {
        if (linkedList1.head == null || linkedList2.head == null)
            return null;

        Node i = linkedList1.head;
        Node j = linkedList2.head;

        while (i != null && j != null) {
            if (i == j)
                return i;

            i = i.next;
            j = j.next;

            if (i == null && j != null)
                i = linkedList2.head;

            if (i != null && j == null)
                j = linkedList1.head;
        }

        return new Node(-1);

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

        Node temp1 = linkedList1.head;
        while (Objects.nonNull(temp1.next))
            temp1 = temp1.next;
        temp1.next = common.head;

        Node temp2 = linkedList2.head;
        while (Objects.nonNull(temp2.next))
            temp2 = temp2.next;
        temp2.next = common.head;

        System.out.println("LinkedList 1 :");
        System.out.println(linkedList1);
        System.out.println("LinkedList 2 :");
        System.out.println(linkedList2);

        LinkedList linkedList3 = new LinkedList();
        linkedList3.head = getCommonLinkedList(linkedList1, linkedList2);
        System.out.println("Common LinkedList :");
        System.out.println(linkedList3);
    }
}
