package com.vkstech.algorithms.bookProblems.linkedlist;

public class VCircularLinkedList {

    private Node head;
    private Node tail;
    private int length;

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = this;
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
        tail.next = newNode;
        newNode.next = head;
        head = newNode;

        length++;
    }

    public void insertAtTail(int data) {
        if (length == 0) {
            head = new Node(data);
            tail = head;
            length++;
            return;
        }


        Node newNode = new Node(data);
        tail.next = newNode;
        newNode.next = head;
        tail = newNode;

        length++;
    }

    public Node deleteAtHead() {
        if (length == 0) {
            System.out.println("List is empty");
            return null;
        }

        Node temp = head;
        tail.next = head.next;
        head = head.next;
        temp.next = temp;
        length--;
        return temp;
    }

    public Node deleteAtTail() {
        if (length == 0) {
            System.out.println("List is empty");
            return null;
        }

        Node temp = head;

        while (temp.next != tail) {
            temp = temp.next;
        }

        Node deletedNode = tail;
        temp.next = head;
        tail = temp;
        deletedNode.next = deletedNode;
        length--;
        return deletedNode;
    }

    public static void main(String[] args) {
        VCircularLinkedList cll = new VCircularLinkedList();
        for (int i = 1; i <= 5; i++) {
            cll.insertAtTail(i);
        }

        System.out.println(cll.getLength());

        Node d1 = cll.deleteAtTail();

        System.out.println(cll.getLength());
    }
}
