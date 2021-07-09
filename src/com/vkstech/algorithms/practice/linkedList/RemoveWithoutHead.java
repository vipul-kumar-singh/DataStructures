package com.vkstech.algorithms.practice.linkedList;

import com.vkstech.algorithms.practice.linkedList.LinkedList.Node;

import static com.vkstech.algorithms.practice.linkedList.PrintLinkedList.printLinkedList;

/**
 * You are given a reference to the node which is to be deleted from the linked list of N nodes.
 * The task is to delete the node.
 * Note: No head reference is given to you.
 * It is guaranteed that the node to be deleted is not a tail node in the linked list.
 * Eg: Input: value[] = {10,20,4,30}, node = 20,
 * Output: {10, 4, 30}
 */
public class RemoveWithoutHead {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(10);
        linkedList.insert(20);
        linkedList.insert(4);
        linkedList.insert(30);

        Node node = linkedList.head.next.next.next;
        deleteNode(linkedList, node);

        printLinkedList(linkedList);
    }

    private static void deleteNode(LinkedList linkedList, Node node) {
        if (linkedList.head == null) {
            System.out.println("LinkedList is empty");
            return;
        }

        if (node.next == null) {
            System.out.println("Cannot remove tail node");
            return;
        }

        Node next = node.next;

        int temp = node.data;
        node.data = next.data;
        next.data = temp;

        node.next = next.next;
        next.next = null;
    }
}
