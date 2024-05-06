package com.vkstech.algorithms.practice2.linkedlist;

import com.vkstech.algorithms.practice2.linkedlist.LinkedList.Node;

public class ReverseInGroups {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        for (int i = 1; i <= 9; i++)
            linkedList.insert(i);

        System.out.println(linkedList);
        linkedList.head = reverseGroup(linkedList.head, 3);
        System.out.println(linkedList);
    }

    private static Node reverseGroup(Node head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        Node prev = null;
        Node cur = head;
        Node next = null;

        int count = 0;

        while (cur != null && count < k) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            count++;
        }

        if (next != null) {
            head.next = reverseGroup(next, k);
        }

        return prev;
    }
}
