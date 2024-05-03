package com.vkstech.algorithms.bookProblems.linkedlist;

public class VDoublyLinkedList {

    private Node head;
    private Node tail;
    private int length = 0;

    public static class Node {
        int data;
        Node next;
        Node previous;

        public Node(int data) {
            this.data = data;
        }
    }

    public int getLength() {
        return length;
    }

    public void insertAtHead(int data) {
        if (length == 0) {
            head = new Node(data);
            tail = head;
            length++;
            return;
        }

        Node newNode = new Node(data);
        newNode.next = head;
        head.previous = newNode;
        head = newNode;
        length++;
    }

    public void insertAtTail(int data) {
        if (length == 0) {
            tail = new Node(data);
            head = tail;
            length++;
            return;
        }

        Node newNode = new Node(data);
        tail.next = newNode;
        newNode.previous = tail;
        tail = newNode;
        length++;
    }

    public void insertAtPos(int data, int pos) {
        if (pos < 1 || pos > length) {
            System.out.println("Invalid position");
            return;
        }

        if (pos == 1) {
            insertAtHead(data);
            return;
        }

        if (pos == length) {
            insertAtTail(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;

        while (pos != 1) {
            temp = temp.next;
            pos--;
        }

        newNode.next = temp;
        newNode.previous = temp.previous;
        temp.previous.next = newNode;
        temp.previous = newNode;
        length++;
    }

    public Node deleteAtHead() {
        if (length == 0) {
            System.out.println("List is empty");
            return null;
        }

        Node temp = head;
        head = head.next;
        head.previous = null;
        temp.next = null;
        length--;
        return temp;
    }

    public Node deleteAtTail() {
        if (length == 0) {
            System.out.println("List is empty");
            return null;
        }

        Node temp = tail;
        tail = tail.previous;
        tail.next = null;
        temp.previous = null;
        length--;
        return temp;
    }

    public Node deleteAtPos(int pos) {
        if (length == 0) {
            System.out.println("List is empty");
            return null;
        }

        if (pos == 1)
            return deleteAtHead();

        if (pos == length)
            return deleteAtTail();

        Node temp = head;
        while (pos > 1) {
            temp = temp.next;
            pos--;
        }

        temp.previous.next = temp.next;
        temp.next.previous = temp.previous;

        temp.previous = null;
        temp.next = null;

        length--;
        return temp;
    }

    public static void main(String[] args) {
        VDoublyLinkedList dll = new VDoublyLinkedList();

        for (int i = 1; i <= 10; i++) {
            dll.insertAtTail(i);
        }

        dll.insertAtPos(15, 3);
        System.out.println(dll.length);

        dll.deleteAtPos(3);
        System.out.println(dll.length);
    }
}
