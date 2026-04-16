package com.vkstech.algorithms.practice3.linkedList;

import java.util.Objects;

public class MLinkedList {

    Node head;

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    // Insertion at Head
    public void insertAtHead(int data) {
        Node node = new Node(data);

        if (Objects.nonNull(head)) {
            node.next = head;
        }
        head = node;
    }

    // Insertion at tail
    public void insertAtTail(int data) {
        Node node = new Node(data);

        if (Objects.isNull(head)) {
            head = node;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    // Insert Multiple
    protected void insertMultiple(int... data) {
        Node temp = this.head;
        for (int val : data) {
            Node node = new Node(val);
            if (temp == null) {
                this.head = node;
                temp = this.head;
            } else {
                temp.next = node;
                temp = temp.next;
            }
        }
    }

    // Print Linked List
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Deletion at head
    public Node deleteAtHead() {

        if (Objects.isNull(head)) {
            System.out.println("LL is empty");
            return null;
        }

        Node temp = head;
        head = head.next;
        temp.next = null;

        return temp;
    }

    // Deletion at tail
    public Node deleteAtTail() {
        if (Objects.isNull(head)) {
            System.out.println("LL is empty");
            return null;
        }

        if (Objects.isNull(head.next)) {
            head = null;
            return null;
        }

        Node temp = head;

        while (temp.next.next != null) {
            temp = temp.next;
        }

        Node node = temp.next;
        temp.next = null;

        return node;
    }

}
