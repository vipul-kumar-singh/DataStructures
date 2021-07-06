package com.vkstech.algorithms.practice.linkedList;

import com.vkstech.algorithms.practice.linkedList.LinkedList.Node;

/**
 * Nth node from end of linked list
 * Given a linked list consisting of L nodes and given a number N. The task is to find the Nth node from the end of the linked list.
 * Input: LinkedList: 1->2->3->4->5->6->7->8->9, N = 2
 * Output: 8
 */
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

    private static int getNthNodeFromEnd(LinkedList linkedList, int n) {
        Node slow = linkedList.head;
        Node fast = linkedList.head;

        while(n > 1){
            fast = fast.next;
            if (fast == null)
                throw new IndexOutOfBoundsException();
            n--;
        }

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        assert slow != null;
        return slow.data;
    }
}
