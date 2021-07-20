package com.vkstech.algorithms.practice.stack;

import java.util.StringJoiner;

public class StackWithLinkedlist {
    private Node head;

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public void push(int data) {
        Node node = new Node(data);

        node.next = this.head;
        this.head = node;
    }

    public int pop() {
        if (head == null)
            throw new IndexOutOfBoundsException("Stack Underflow");

        Node node = this.head;
        this.head = node.next;
        node.next = null;
        return node.data;
    }

    public int peek() {
        if (empty())
            throw new IndexOutOfBoundsException("Stack Underflow");

        return this.head.data;
    }

    public boolean empty() {
        return head == null;
    }

    public void print() {
        if (empty())
            return;

        StringJoiner stringJoiner = new StringJoiner("<-");
        Node temp = head;
        while (temp != null) {
            stringJoiner.add(String.valueOf(temp.data));
            temp = temp.next;
        }
        System.out.println(stringJoiner);
    }

    public static void main(String[] args) {
        StackWithLinkedlist stack = new StackWithLinkedlist();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.print();
        stack.pop();
        stack.pop();
        stack.print();
    }

}
