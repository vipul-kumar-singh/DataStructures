package com.vkstech.algorithms.practice2.linkedlist;

import com.vkstech.algorithms.practice2.linkedlist.LinkedList.Node;

public class PairwiseSwap {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        for (int i = 1; i <= 10; i++)
            linkedList.insert(i);

        System.out.println(linkedList);
        pairWiseSwap(linkedList);
        System.out.println(linkedList);
    }

    private static void pairWiseSwap(LinkedList linkedList) {
        if (linkedList == null || linkedList.head == null || linkedList.head.next == null) {
            return;
        }

        //Swap first two elements
        Node prev = linkedList.head;
        linkedList.head = linkedList.head.next;
        prev.next = linkedList.head.next;
        linkedList.head.next = prev;

        //Swap remaining elements
        while (prev.next != null) {
            Node cur = prev.next;
            if (cur.next != null) {
                Node temp = cur.next;
                cur.next = temp.next;
                temp.next = cur;
                prev.next = temp;
            }
            prev = cur;
        }
    }
}
