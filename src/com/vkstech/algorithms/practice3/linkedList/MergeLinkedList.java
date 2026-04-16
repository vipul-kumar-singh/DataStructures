package com.vkstech.algorithms.practice3.linkedList;

import static com.vkstech.algorithms.practice3.linkedList.MLinkedList.Node;

// https://www.geeksforgeeks.org/problems/merge-two-sorted-linked-lists/1
public class MergeLinkedList {

    public static void main(String[] args) {
        MLinkedList list1 = new MLinkedList();
        list1.insertMultiple(5, 10, 15, 40);

        MLinkedList list2 = new MLinkedList();
        list2.insertMultiple(2, 3, 20);

        MLinkedList mergedList1 = mergeList(list1, list2);
        mergedList1.print();


        MLinkedList list3 = new MLinkedList();
        list3.insertMultiple(1, 1);

        MLinkedList list4 = new MLinkedList();
        list4.insertMultiple(2, 4);

        MLinkedList mergedList2 = mergeList(list3, list4);
        mergedList2.print();

    }

    private static MLinkedList mergeList(MLinkedList list1, MLinkedList list2) {
        MLinkedList mergedList = new MLinkedList();
        Node temp = mergedList.head;

        Node temp1 = list1.head;
        Node temp2 = list2.head;

        while (temp1 != null && temp2 != null) {
            Node node;
            if (temp1.data < temp2.data) {
                node = new Node(temp1.data);
                temp1 = temp1.next;
            } else {
                node = new Node(temp2.data);
                temp2 = temp2.next;
            }

            if (temp == null) {
                mergedList.head = node;
                temp = mergedList.head;
            } else {
                temp.next = node;
                temp = temp.next;
            }
        }

        while (temp1 != null) {
            Node node = new Node(temp1.data);
            temp1 = temp1.next;

            temp.next = node;
            temp = temp.next;
        }

        while (temp2 != null) {
            Node node = new Node(temp2.data);
            temp2 = temp2.next;

            temp.next = node;
            temp = temp.next;
        }

        return mergedList;
    }
}
