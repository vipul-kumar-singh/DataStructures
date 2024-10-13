package com.vkstech.algorithms.practice2.linkedlist;

import com.vkstech.algorithms.practice2.linkedlist.LinkedList.Node;

public class NthNodeFromEnd {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        for (int i = 1; i <= 9; i++)
            linkedList.insert(i);

        System.out.println(getNthNodeFromEnd(linkedList, 2));
        System.out.println(getNthNodeFromEnd(linkedList, 1));
        System.out.println(getNthNodeFromEnd(linkedList, 5));
        System.out.println(getNthNodeFromEnd(linkedList, 9));
        System.out.println(getNthNodeFromEnd(linkedList, 10));
    }

    private static int getNthNodeFromEnd(LinkedList ll, int n) {
        Node fast = ll.head;
        Node slow = ll.head;

        while (n > 1) {
            fast = fast.next;
            if (fast == null)
                throw new IndexOutOfBoundsException();
            n--;
        }

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow.data;
    }

}