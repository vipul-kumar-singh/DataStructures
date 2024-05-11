package com.vkstech.algorithms.practice2.linkedlist;

import java.util.HashMap;

class Node {
    int data;
    Node next;
    Node arbit;

    Node(int x) {
        this.data = x;
        this.next = null;
        this.arbit = null;
    }
}

public class CloneRandom {

    private static Node cloneLinkedList(Node head) {
        Node temp = head;
        Node newHead = new Node(temp.data);

        HashMap<Node, Node> map = new HashMap<>();
        map.put(temp, newHead);

        while (temp.next != null) {
            temp = temp.next;
            newHead.next = new Node(temp.data);
            newHead = newHead.next;
            map.put(temp, newHead);
        }

        temp = head;
        while (temp != null) {
            map.get(temp).arbit = map.get(temp.arbit);
            temp = temp.next;
        }

        return map.get(head);
    }

    private static void printList(Node head) {
        System.out.print(head.data + "(" + head.arbit.data + ")");
        head = head.next;
        while (head != null) {
            System.out.print(" -> " + head.data + "(" + head.arbit.data + ")");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.arbit = head.next.next;
        head.next.arbit = head;
        head.next.next.arbit = head.next.next.next.next;
        head.next.next.next.arbit = head.next.next;
        head.next.next.next.next.arbit = head.next;

        System.out.println("The original linked list:");
        printList(head);

        Node sol = cloneLinkedList(head);

        System.out.println("The cloned linked list:");
        printList(sol);
    }
}
