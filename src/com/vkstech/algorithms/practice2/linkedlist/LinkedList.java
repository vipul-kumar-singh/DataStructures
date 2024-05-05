package com.vkstech.algorithms.practice2.linkedlist;

import java.util.Objects;

public class LinkedList {

    public Node head;

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public void insert(int data) {
        Node node = new Node(data);

        if (Objects.isNull(head)) {
            head = node;
        } else {
            Node start = head;
            while (Objects.nonNull(start.next)) {
                start = start.next;
            }
            start.next = node;
        }
    }

    protected void insertMultiple(int... data) {
        Node temp = this.head;
        for(int val : data){
            Node node = new Node(val);
            if (temp == null){
                this.head = node;
                temp = this.head;
            } else {
                temp.next = node;
                temp = temp.next;
            }
        }
    }
}
