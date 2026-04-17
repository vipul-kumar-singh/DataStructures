package com.vkstech.algorithms.practice3.linkedList.doubly;

import java.util.StringJoiner;

public class MDoublyLinkedList {

    Node head;
    Node tail;

    public static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
        }
    }

    // insertion at head
    public void insertAtHead(int data) {
        Node node = new Node(data);

        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    // insertion at tail
    public void insertAtTail(int data) {
        Node node = new Node(data);

        if (tail == null) {
            tail = node;
            head = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    // insert multiple
    public void insertMultiple(int... args) {
        for (int num : args) {
            insertAtTail(num);
        }
    }

    // deletion at head
    public Node deleteAtHead() {
        Node delNode = null;
        if (head == null) {
            System.out.println("List is empty");
        } else if (head == tail) {
            delNode = head;
            head = null;
            tail = null;
        } else {
            delNode = head;
            head = head.next;
            head.prev = null;
        }

        return delNode;
    }

    // deletion at tail
    public Node deleteAtTail() {
        Node delNode = null;
        if (tail == null) {
            System.out.println("List is empty");
        } else if (tail == head) {
            delNode = tail;
            tail = null;
            head = null;
        } else {
            delNode = tail;
            tail = tail.prev;
            tail.next = null;
        }

        return delNode;
    }

    // print
    public void print() {
        Node temp = head;
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        while (temp != null) {
            joiner.add(String.valueOf(temp.data));
            temp = temp.next;
        }

        System.out.println(joiner);
    }
}
