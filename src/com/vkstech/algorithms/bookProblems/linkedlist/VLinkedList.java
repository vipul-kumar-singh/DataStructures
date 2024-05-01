package com.vkstech.algorithms.bookProblems.linkedlist;

import java.util.StringJoiner;

public class VLinkedList {

    private Node head;

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public int getSize() {
        if (head == null) {
            return 0;
        }

        Node temp = head;
        int length = 0;

        while (temp != null) {
            length++;
            temp = temp.next;
        }

        return length;
    }

    public void insertAtHead(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }

        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtTail(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;

    }

    public void insertAtPos(int data, int pos) {
        if (pos > getSize()) {
            System.out.println("Unable to insert " + data + " at position " + pos);
            return;
        }

        if (pos == 0) {
            insertAtHead(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;
        Node prev = head;

        while (pos != 0) {
            prev = temp;
            temp = temp.next;
            pos--;
        }

        prev.next = newNode;
        newNode.next = temp;
    }

    private Node deleteAtHead() {
        if (head == null) {
            return null;
        }

        Node deleteNode = head;
        head = head.next;
        return deleteNode;
    }

    private Node deleteAtTail() {
        if (head == null) {
            return null;
        }

        Node deletedNode;

        if (head.next == null) {
            deletedNode = head;
            head = null;
            return deletedNode;
        }

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }

        deletedNode = temp.next;
        temp.next = null;
        return deletedNode;
    }

    private Node deleteAtPos(int pos) {
        if (pos > getSize()) {
            return null;
        }

        if (pos == 0) {
            return deleteAtHead();
        }

        if (pos == getSize() - 1) {
            return deleteAtTail();
        }

        Node temp = head;
        Node prev = head;

        while (pos != 0) {
            prev = temp;
            temp = temp.next;
            pos--;
        }

        prev.next = temp.next;
        temp.next = null;
        return temp;
    }

    public void clearAll() {
        head = null;
    }

    @Override
    public String toString() {
        if (head == null) {
            return null;
        }

        StringJoiner sj = new StringJoiner(",");
        Node temp = head;

        while (temp != null) {
            sj.add(String.valueOf(temp.data));
            temp = temp.next;
        }

        return sj.toString();
    }

    public static void main(String[] args) {
        VLinkedList linkedList = new VLinkedList();
        linkedList.insertAtPos(0, 0);
        linkedList.insertAtPos(1, 1);
        linkedList.insertAtPos(2, 1);
        linkedList.insertAtPos(3, 0);
        linkedList.insertAtPos(4, 1);
        linkedList.insertAtPos(5, 1);

        System.out.println(linkedList.getSize());

        linkedList.deleteAtPos(0);
        System.out.println(linkedList.getSize());

        linkedList.deleteAtPos(4);
        System.out.println(linkedList.getSize());

        linkedList.deleteAtPos(2);
        System.out.println(linkedList.getSize());

        System.out.println(linkedList);

        linkedList.deleteAtHead();
        linkedList.deleteAtHead();

        System.out.println(linkedList);

        linkedList.deleteAtHead();

        System.out.println(linkedList);
    }

}
