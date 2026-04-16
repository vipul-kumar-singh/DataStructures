package com.vkstech.algorithms.practice3.linkedList;

import static com.vkstech.algorithms.practice3.linkedList.MLinkedList.Node;

// https://www.geeksforgeeks.org/problems/delete-without-head-pointer/1
public class DeleteNode {

    public static void main(String[] args) {
        MLinkedList list1 = new MLinkedList();
        list1.insertMultiple(1, 2);
        deleteNode(list1.head);
        list1.print();

        MLinkedList list2 = new MLinkedList();
        list2.insertMultiple(10, 20, 4, 30);
        deleteNode(list2.head.next);
        list2.print();
    }

    public static void deleteNode(Node del_node) {
        Node temp = del_node.next;
        del_node.data = temp.data;
        del_node.next = temp.next;
    }
}
