package com.vkstech.algorithms.practice2.mostAsked;

import com.vkstech.algorithms.practice2.linkedlist.LinkedList;
import com.vkstech.algorithms.practice2.linkedlist.LinkedList.Node;

public class MergeTwoSortedLL {

    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        for (int i = 1; i <= 9; i = i + 2)
            ll1.insert(i);
        System.out.println(ll1);

        LinkedList ll2 = new LinkedList();
        for (int i = 2; i <= 10; i = i + 2)
            ll2.insert(i);
        System.out.println(ll2);

        LinkedList ll3 = mergeLinkedList(ll1, ll2);
        System.out.println(ll3);
    }

    private static LinkedList mergeLinkedList(LinkedList ll1, LinkedList ll2) {
        if (ll1 == null)
            return ll2;

        if (ll2 == null)
            return ll1;

        Node temp1 = ll1.head;
        Node temp2 = ll2.head;
        Node temp3 = null;

        LinkedList ll3 = new LinkedList();

        while (temp1 != null && temp2 != null) {
            int data;
            if (temp1.data <= temp2.data) {
                data = temp1.data;
                temp1 = temp1.next;
            } else {
                data = temp2.data;
                temp2 = temp2.next;
            }

            Node newNode = new Node(data);
            if (temp3 == null) {
                temp3 = newNode;
                ll3.head = temp3;
            } else {
                temp3.next = newNode;
                temp3 = temp3.next;
            }
        }

        while (temp1 != null) {
            temp3.next = new Node(temp1.data);
            temp3 = temp3.next;
            temp1 = temp1.next;
        }

        while (temp2 != null) {
            temp3.next = new Node(temp2.data);
            temp3 = temp3.next;
            temp2 = temp2.next;
        }

        return ll3;
    }
}
