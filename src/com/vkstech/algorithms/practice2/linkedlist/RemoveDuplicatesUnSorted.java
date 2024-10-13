package com.vkstech.algorithms.practice2.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesUnSorted extends LinkedList {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertMultiple(2, 4, 5, 2, 3, 4, 3);
        System.out.println(linkedList);

        removeDuplicates(linkedList);
        System.out.println(linkedList);
    }

    private static void removeDuplicates(LinkedList linkedList) {
        if (linkedList == null || linkedList.head == null || linkedList.head.next == null)
            return;


        Set<Integer> set = new HashSet<>();
        set.add(linkedList.head.data);

        Node prev = linkedList.head;
        Node current = linkedList.head.next;

        while (current != null) {
            if (set.contains(current.data)) {
                prev.next = current.next;
            } else {
                set.add(current.data);
                prev = prev.next;
            }
            current = current.next;
        }

    }
}
