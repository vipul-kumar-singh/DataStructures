package com.vkstech.algorithms.practice2.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class IntersectionList extends LinkedList {

    public static void main(String[] args) {
        LinkedList linkedList1 = new LinkedList();
        linkedList1.insertMultiple(9, 6, 4, 2, 3, 8);
        System.out.println(linkedList1);

        LinkedList linkedList2 = new LinkedList();
        linkedList2.insertMultiple(1, 2, 8, 6);
        System.out.println(linkedList2);

        LinkedList ll = getIntersection(linkedList1, linkedList2);
        System.out.println(ll);
    }

    private static LinkedList getIntersection(LinkedList linkedList1, LinkedList linkedList2) {
        if (linkedList1.head == null || linkedList2.head == null) {
            return null;
        }

        Set<Integer> set = new HashSet<>();

        Node temp = linkedList2.head;
        while (temp != null) {
            set.add(temp.data);
            temp = temp.next;
        }

        LinkedList intersect = new LinkedList();
        Node current = null;

        temp = linkedList1.head;
        while (temp != null) {
            if (set.contains(temp.data)) {
                if (current == null) {
                    intersect.head = new Node(temp.data);
                    current = intersect.head;
                } else {
                    current.next = new Node(temp.data);
                    current = current.next;
                }
            }
            temp = temp.next;
        }

        return intersect;
    }
}
