package com.vkstech.algorithms.practice2.linkedlist;


import static com.vkstech.algorithms.practice2.linkedlist.LinkedList.Node;

public class DeleteWithoutHead {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(10);
        linkedList.insert(20);
        linkedList.insert(4);
        linkedList.insert(30);

        System.out.println(linkedList);

        Node node = linkedList.head.next.next.next;
        deleteNode(linkedList, node);

        System.out.println(linkedList);
    }

    private static void deleteNode(LinkedList linkedList, Node node) {
        if (linkedList.head == null) {
            System.out.println("List is Empty");
            return;
        }

        if (node.next == null) {
            System.out.println("Cannot remove last element");
            return;
        }

        node.data = node.next.data;
        node.next = node.next.next;
    }
}
