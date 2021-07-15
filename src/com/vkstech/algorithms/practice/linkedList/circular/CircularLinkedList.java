package com.vkstech.algorithms.practice.linkedList.circular;


import java.util.StringJoiner;

public class CircularLinkedList {

    public Node head;

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public CircularLinkedList() {
    }

    public CircularLinkedList(int... data) {
        Node temp = null;
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
        if (temp != null)
            temp.next = this.head;
    }

    public void removeCircular() {
        if (head == null)
            return;

        Node temp = this.head;
        while (temp.next != this.head)
            temp = temp.next;
        temp.next = null;
    }

    public void print() {
        Node temp = this.head;
        StringJoiner sj = new StringJoiner("->");
        do {
            sj.add(String.valueOf(temp.data));
            temp = temp.next;
        } while (temp != null && temp != this.head);
        System.out.println(sj);
    }

}
