package com.vkstech.algorithms.practice2.linkedlist;

public class CheckCircular extends LinkedList {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertMultiple(1, 2, 2, 1, 2, 0, 2, 2);

        Node temp = linkedList.head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = linkedList.head;

        boolean check = isCircualar(linkedList);
        System.out.println(check);
    }

    private static boolean isCircualar(LinkedList linkedList) {
        if (linkedList.head == null) {
            return false;
        }

        Node start = linkedList.head;
        Node end = linkedList.head.next;

        while (end != null) {
            if (start == end)
                return true;
            end = end.next;
        }
        return false;
    }
}