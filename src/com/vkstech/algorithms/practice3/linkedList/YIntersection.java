package com.vkstech.algorithms.practice3.linkedList;

import static com.vkstech.algorithms.practice3.linkedList.MLinkedList.Node;

public class YIntersection {

    public static void main(String[] args) {
        MLinkedList list1 = new MLinkedList();
        list1.insertMultiple(10, 15, 30);

        MLinkedList list2 = new MLinkedList();
        list2.insertMultiple(3, 6, 9);
        Node temp2 = list2.head;
        while (temp2.next != null) {
            temp2 = temp2.next;
        }
        temp2.next = list1.head.next;

        MLinkedList result1 = new MLinkedList();
        result1.head = intersectPoint(list1.head, list2.head);
        result1.print();


        MLinkedList list3 = new MLinkedList();
        list3.insertMultiple(4, 1, 8, 5);

        MLinkedList list4 = new MLinkedList();
        list4.insertMultiple(5, 6, 1);
        Node temp4 = list4.head;
        while (temp4.next != null) {
            temp4 = temp4.next;
        }
        temp4.next = list3.head.next;

        MLinkedList result2 = new MLinkedList();
        result2.head = intersectPoint(list3.head, list4.head);
        result2.print();
    }

    public static Node intersectPoint(Node head1, Node head2) {
        Node temp1 = head1;
        Node temp2 = head2;

        while (temp1 != temp2) {
            if (temp1 == null) {
                temp1 = head2;
            } else {
                temp1 = temp1.next;
            }

            if (temp2 == null) {
                temp2 = head1;
            } else {
                temp2 = temp2.next;
            }
        }

        return temp1;
    }
}
