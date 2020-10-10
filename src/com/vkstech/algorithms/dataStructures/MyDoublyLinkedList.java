package com.vkstech.algorithms.dataStructures;

import java.util.Objects;

public class MyDoublyLinkedList {

    private Node head;
    private Node tail;
    private int size;
    private final int MAX_SIZE;

    public MyDoublyLinkedList(int max) {
        this.MAX_SIZE = max;
        size = 0;
    }

    private static class Node {
        int data;
        Node next;
        Node previous;

        public Node(int data) {
            this.data = data;
        }
    }

    public void insertAtHead(int data) {
        if (isFull()) {
            System.out.println("List is full");
            return;
        }

        Node node = new Node(data);

        if (isEmpty()) {
            tail = node;
        } else {
            head.previous = node;
            node.next = head;
        }
        head = node;
        size++;
        System.out.println(data + " inserted at head.");
    }

    public void insertAtTail(int data) {
        if (isFull()) {
            System.out.println("List is full");
            return;
        }

        Node node = new Node(data);

        if (isEmpty()) {
            head = node;
        } else {
            node.previous = tail;
            tail.next = node;
        }
        tail = node;
        size++;
        System.out.println(data + " inserted at tail.");
    }

    public void insertAtPosition(int data, int position) {
        if (isFull()) {
            System.out.println("List is full");
            return;
        }

        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position");
            return;
        }

        if (position == 1) {
            insertAtHead(data);
        } else if (position == size + 1) {
            insertAtTail(data);
        } else {
            Node node = new Node(data);

            Node start = head;

            for (int i = 2; i < position; i++) {
                start = start.next;
            }

            node.previous = start;
            node.next = start.next;
            start.next.previous = node;
            start.next = node;
            size++;
            System.out.println(data + " inserted at position " + position);
        }
    }

    public void deleteAtHead() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node tmp = head;

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.previous = null;
            tmp.next = null;
        }
        size--;
        System.out.println(tmp.data + " removed from head");
    }

    public void deleteAtTail() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node tmp = tail;

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.previous;
            tail.next = null;
            tmp.previous = null;
        }
        size--;
        System.out.println(tmp.data + " removed from tail");
    }

    public void deleteAtPosition(int position) {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        if (position < 1 || position > size) {
            System.out.println("Invalid position");
            return;
        }

        if (position == 1) {
            deleteAtHead();
        } else if (position == size) {
            deleteAtTail();
        } else {

            Node start = head;

            for (int i = 2; i < position; i++) {
                start = start.next;
            }

            Node tmp = start.next;

            start.next = tmp.next;
            tmp.next.previous = start;

            tmp.next = null;
            tmp.previous = null;
            size--;

            System.out.println(tmp.data + " removed from position " + position);
        }
    }

    public void forwardDisplay() {
        if (isEmpty()) {
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

    public void backwardDisplay() {
        if (isEmpty()) {
            System.out.println("List is Empty");
            return;
        }

        Node start = tail;
        while (Objects.nonNull(start)) {
            System.out.print(start.data + "\t");
            start = start.previous;
        }
        System.out.println();
    }

    private boolean isFull() {
        return size == MAX_SIZE;
    }

    private boolean isEmpty() {
        return Objects.isNull(head) && Objects.isNull(tail);
    }

    public static void main(String[] args) {
        MyDoublyLinkedList myDoublyLinkedList = new MyDoublyLinkedList(5);

        myDoublyLinkedList.insertAtPosition(2, 0);
        myDoublyLinkedList.insertAtPosition(2, 2);
        myDoublyLinkedList.insertAtPosition(2, 1);
        myDoublyLinkedList.insertAtPosition(3, 2);
        myDoublyLinkedList.insertAtPosition(1, 1);
        myDoublyLinkedList.insertAtPosition(5, 4);
        myDoublyLinkedList.insertAtPosition(4, 4);
        myDoublyLinkedList.insertAtPosition(0, 1);

        myDoublyLinkedList.forwardDisplay();
        myDoublyLinkedList.backwardDisplay();

        myDoublyLinkedList.deleteAtPosition(0);
        myDoublyLinkedList.deleteAtPosition(6);
        myDoublyLinkedList.deleteAtPosition(1);
        myDoublyLinkedList.deleteAtPosition(4);
        myDoublyLinkedList.deleteAtPosition(2);
        myDoublyLinkedList.deleteAtPosition(1);
        myDoublyLinkedList.deleteAtPosition(1);
        myDoublyLinkedList.deleteAtPosition(1);

        myDoublyLinkedList.forwardDisplay();
        myDoublyLinkedList.backwardDisplay();
    }
}
