package com.vkstech.algorithms.practice3.linkedList;

import static com.vkstech.algorithms.practice3.linkedList.MLinkedList.Node;

// https://www.geeksforgeeks.org/problems/rearrange-a-linked-list/1
public class RearrangeLinkedList {

    public static void main(String[] args) {
        MLinkedList list1 = new MLinkedList();
        list1.insertMultiple(1, 2, 3, 4);
        rearrangeEvenOdd(list1);
        list1.print();

        MLinkedList list2 = new MLinkedList();
        list2.insertMultiple(1, 2, 3, 4, 5);
        rearrangeEvenOdd(list2);
        list2.print();

    }

    private static void rearrangeEvenOdd(MLinkedList list) {
        Node oddPointer = list.head;
        Node evenPointer = list.head.next;
        Node evenHead = list.head.next;

        while (evenPointer != null && evenPointer.next != null) {
            oddPointer.next = evenPointer.next;
            oddPointer = oddPointer.next;
            evenPointer.next = oddPointer.next;
            oddPointer.next = evenHead;
            evenPointer = evenPointer.next;
        }
    }
}
