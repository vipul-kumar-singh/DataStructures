package com.vkstech.algorithms.practice3.linkedList;

import static com.vkstech.algorithms.practice3.linkedList.MLinkedList.Node;

// https://www.geeksforgeeks.org/problems/reverse-a-linked-list/1
public class ReverseLinkedList {

    public static void main(String[] args) {
        MLinkedList list1 = new MLinkedList();
        list1.insertMultiple(1, 2, 3, 4);
        list1.head = reverseList(list1);
        list1.print();

        MLinkedList list2 = new MLinkedList();
        list2.insertMultiple(2, 7, 10, 9, 8);
        list2.head = reverseList(list2);
        list2.print();

        MLinkedList list3 = new MLinkedList();
        list3.insertMultiple(8);
        list3.head = reverseList(list3);
        list3.print();
    }

    private static Node reverseList(MLinkedList list) {
        Node rev = null;
        Node temp = list.head;

        while (temp != null) {
            Node node = new Node(temp.data);

            if(rev == null) {
                rev = node;
                rev.next = null;
            } else {
                node.next = rev;
                rev = node;
            }

            temp = temp.next;
        }

        return rev;
    }
}
