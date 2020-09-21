package com.vkstech.data.structures;

import java.util.Objects;

public class MyLinkedList {

    private Node head;
    private int size;
    private final int MAX_SIZE;

    public MyLinkedList(int max) {
        this.MAX_SIZE = max;
        size = 0;
    }

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public void insertAtHead(int data) {

        if (size == MAX_SIZE) {
            System.out.println("List is full");
            return;
        }

        Node node = new Node(data);

        if (Objects.nonNull(head)) {
            node.next = head;
        }
        head = node;
        size++;
        System.out.println(data + " inserted at the beginning of List.");
    }

    public void insertAtEnd(int data) {
        if (size == MAX_SIZE) {
            System.out.println("List is full");
            return;
        }

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
        size++;
        System.out.println(data + " inserted at the end of List.");
    }

    public void insertAtPosition(int data, int position) {
        if (size == MAX_SIZE) {
            System.out.println("List is full");
            return;
        }

        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position");
            return;
        } else if (position == 1) {
            insertAtHead(data);
            return;
        } else if (position == size + 1) {
            insertAtEnd(data);
            return;
        }

        Node node = new Node(data);
        Node start = head;

        for (int i = 2; i < position; i++) {
            start = start.next;
        }
        node.next = start.next;
        start.next = node;
        size++;
        System.out.println(data + " inserted at position " + position);
    }

    public void deleteAtPosition(int position) {
        if (Objects.isNull(head)) {
            System.out.println("List is Empty");
            return;
        }

        if (position < 1 || position > size) {
            System.out.println("Invalid position");
            return;
        }

        if (position == 1) {
            Node temp = head;
            head = head.next;
            temp.next = null;
        } else {

            Node start = head;
            Node previous = null;
            for (int i = 1; i < position; i++) {
                previous = start;
                start = start.next;
            }

            previous.next = start.next;
            start.next = null;
        }
        size--;
        System.out.println("Data deleted from position " + position);
    }

    public void display() {
        if (Objects.isNull(head)) {
            System.out.println("List is Empty");
            return;
        }

        Node start = head;
        while (Objects.nonNull(start)) {
            System.out.print(start.data + "\t");
            start = start.next;
        }
        System.out.println();
    }

    public int getSize() {
        return size;
    }
}

class LinkedListDemo {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList(6);

//        myLinkedList.insertAtHead(2);
//        myLinkedList.insertAtEnd(3);
//        myLinkedList.insertAtEnd(4);
//        myLinkedList.insertAtEnd(5);
//        myLinkedList.insertAtHead(1);
//        myLinkedList.insertAtHead(0);
//        myLinkedList.insertAtEnd(6);
//        myLinkedList.display();

        myLinkedList.insertAtPosition(1, 0);
        myLinkedList.insertAtPosition(1, 1);
        myLinkedList.insertAtPosition(4, 4);
        myLinkedList.insertAtPosition(4, 2);
        myLinkedList.insertAtPosition(2, 2);
        myLinkedList.insertAtPosition(3, 3);
        myLinkedList.insertAtPosition(5, 5);
        myLinkedList.insertAtPosition(0, 1);
        myLinkedList.insertAtPosition(6, 6);
        myLinkedList.display();

        myLinkedList.deleteAtPosition(0);
        myLinkedList.display();

        myLinkedList.deleteAtPosition(1);
        myLinkedList.display();

        myLinkedList.deleteAtPosition(2);
        myLinkedList.display();

        myLinkedList.deleteAtPosition(4);
        myLinkedList.display();

        myLinkedList.deleteAtPosition(4);
        myLinkedList.display();

        myLinkedList.deleteAtPosition(1);
        myLinkedList.display();

        myLinkedList.deleteAtPosition(1);
        myLinkedList.display();

        myLinkedList.deleteAtPosition(1);
        myLinkedList.display();

        myLinkedList.deleteAtPosition(1);
        myLinkedList.display();

    }
}
