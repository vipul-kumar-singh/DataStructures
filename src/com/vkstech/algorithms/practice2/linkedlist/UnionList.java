package com.vkstech.algorithms.practice2.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class UnionList extends LinkedList {

    public static void main(String[] args) {
        LinkedList linkedList1 = new LinkedList();
        linkedList1.insertMultiple(9, 6, 4, 2, 3, 8);
        System.out.println(linkedList1);

        LinkedList linkedList2 = new LinkedList();
        linkedList2.insertMultiple(1, 2, 8, 6);
        System.out.println(linkedList2);

        LinkedList ll = getUnion(linkedList1, linkedList2);
        System.out.println(ll);
    }

    private static LinkedList getUnion(LinkedList linkedList1, LinkedList linkedList2) {
        if (linkedList1.head == null || linkedList2.head == null) {
            return null;
        }

        Set<Integer> set = new HashSet<>();

        LinkedList union = new LinkedList();
        Node curr = null;


        Node temp = linkedList2.head;
        while (temp != null) {
            set.add(temp.data);
            if (curr == null) {
                curr = new Node(temp.data);
                union.head = curr;
            } else {
                curr.next = new Node(temp.data);
                curr = curr.next;
            }
            temp = temp.next;
        }

        temp = linkedList1.head;
        while (temp != null) {
            if (!set.contains(temp.data)) {
                curr.next = new Node(temp.data);
                curr = curr.next;
            }
            temp = temp.next;
        }

        return union;
    }
}
