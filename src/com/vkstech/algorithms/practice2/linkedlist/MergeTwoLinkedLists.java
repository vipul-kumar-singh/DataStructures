package com.vkstech.algorithms.practice2.linkedlist;

public class MergeTwoLinkedLists extends LinkedList {

    public static void main(String[] args) {
        LinkedList linkedList1 = new LinkedList();
        linkedList1.insertMultiple(5, 10, 15, 40);
        System.out.println(linkedList1);

        LinkedList linkedList2 = new LinkedList();
        linkedList2.insertMultiple(2, 3, 20);
        System.out.println(linkedList2);

        LinkedList mergedLinkedList = merge(linkedList1, linkedList2);
        System.out.println(mergedLinkedList);
    }

    private static LinkedList merge(LinkedList linkedList1, LinkedList linkedList2) {
        if (linkedList1.head == null && linkedList2 == null)
            return linkedList1;

        if (linkedList1.head == null)
            return linkedList2;

        if (linkedList2.head == null)
            return linkedList1;

        LinkedList merged = new LinkedList();

        Node temp1 = linkedList1.head;
        Node temp2 = linkedList2.head;
        Node temp = null;


        while (temp1 != null && temp2 != null) {
            int data;
            if (temp1.data < temp2.data) {
                data = temp1.data;
                temp1 = temp1.next;
            } else {
                data = temp2.data;
                temp2 = temp2.next;
            }

            Node newNode = new Node(data);
            if (temp == null) {
                temp = newNode;
                merged.head = temp;
            } else {
                temp.next = newNode;
                temp = temp.next;
            }
        }

        while (temp1 != null) {
            temp.next = new Node(temp1.data);
            temp = temp.next;
            temp1 = temp1.next;
        }

        while (temp2 != null) {
            temp.next = new Node(temp2.data);
            temp = temp.next;
            temp2 = temp2.next;
        }

        return merged;
    }

}
