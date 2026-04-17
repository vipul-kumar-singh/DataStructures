package com.vkstech.algorithms.practice3.linkedList.circular;

import java.util.StringJoiner;

public class MCircularLinkedList {

    Node head;

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public void insert(int data) {
        Node node = new Node(data);

        if (head == null) {
            head = node;
            head.next = head;
            return;
        }

        Node temp = head;

        while (temp.next != head) {
            temp = temp.next;
        }

        node.next = head;
        temp.next = node;
    }

    public Node delete() {
        if (head == null) {
            System.out.println("List is empty");
            return new Node(-1);
        }

        Node delNode = head;

        if (head.next == head) {
            head.next = null;
            head = null;
            return delNode;
        }

        Node temp = head.next;

        while (temp.next.next != head) {
            temp = temp.next;
        }

        delNode = temp.next;
        delNode.next = null;
        temp.next = head;

        return delNode;
    }

    public void print() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        StringJoiner sj = new StringJoiner(", ", "[", "]");
        sj.add(String.valueOf(head.data));

        Node temp = head.next;
        while (temp != head) {
            sj.add(String.valueOf(temp.data));
            temp = temp.next;
        }

        System.out.println(sj);
    }
}
