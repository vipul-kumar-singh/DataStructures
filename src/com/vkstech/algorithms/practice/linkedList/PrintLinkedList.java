package com.vkstech.algorithms.practice.linkedList;

import java.util.StringJoiner;

import static com.vkstech.algorithms.practice.linkedList.LinkedList.Node;

/**
 * Print Linked List elements
 */
public class PrintLinkedList {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        for (int i = 1; i <= 5; i++) {
            linkedList.insert(i);
        }

        printLinkedList(linkedList);
    }

    public static void printLinkedList(LinkedList linkedList) {
        Node temp = linkedList.head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void printLinkedListOneline(LinkedList linkedList) {
        Node temp = linkedList.head;
        StringJoiner sj = new StringJoiner(" -> ");
        while (temp != null) {
            sj.add(String.valueOf(temp.data));
            temp = temp.next;
        }
        System.out.println(sj);
    }
}
