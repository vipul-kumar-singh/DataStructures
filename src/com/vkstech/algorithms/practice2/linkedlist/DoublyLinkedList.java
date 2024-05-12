package com.vkstech.algorithms.practice2.linkedlist;

import java.util.StringJoiner;

public class DoublyLinkedList {

    Node head;
    Node tail;

    public static class Node {
        int data;
        Node previous;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public DoublyLinkedList() {
    }

    public DoublyLinkedList(int... data) {
        for (int val : data)
            insertAtTail(val);
    }

    public void insertAtHead(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = tail = node;
        } else {
            this.head.previous = node;
            node.next = this.head;
            this.head = node;
        }
    }

    public void insertAtTail(int data) {
        Node node = new Node(data);
        if (tail == null) {
            head = tail = node;
        } else {
            this.tail.next = node;
            node.previous = this.tail;
            this.tail = node;
        }
    }

    public void print() {
        Node temp = this.head;
        StringJoiner stringJoiner = new StringJoiner("<->");
        while (temp != null) {
            stringJoiner.add(String.valueOf(temp.data));
            temp = temp.next;
        }
        System.out.println(stringJoiner);
    }

    public void printReverse() {
        Node temp = this.tail;
        StringJoiner stringJoiner = new StringJoiner("<->");
        while (temp != null) {
            stringJoiner.add(String.valueOf(temp.data));
            temp = temp.previous;
        }
        System.out.println(stringJoiner);
    }

    public boolean isEmpty() {
        return this.head == null && this.tail == null;
    }

}
