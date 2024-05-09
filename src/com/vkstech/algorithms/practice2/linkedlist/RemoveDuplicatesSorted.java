package com.vkstech.algorithms.practice2.linkedlist;

public class RemoveDuplicatesSorted extends LinkedList {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertMultiple(2);
        System.out.println(linkedList);

        removeDuplicates(linkedList);
        System.out.println(linkedList);
    }

    private static void removeDuplicates(LinkedList linkedList) {
        if (linkedList == null || linkedList.head == null || linkedList.head.next == null)
            return;

        Node current = linkedList.head;
        Node next = linkedList.head.next;

        while (next != null) {
            if (current.data == next.data) {
                current.next = next.next;
            } else {
                current = current.next;
            }
            next = next.next;
        }
    }
}
