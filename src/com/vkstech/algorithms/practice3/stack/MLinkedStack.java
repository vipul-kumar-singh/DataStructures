package com.vkstech.algorithms.practice3.stack;

public class MLinkedStack {

    private Node top;

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(int data) {
        if (isEmpty()) {
            top = new Node(data);
            return;
        }

        Node node = new Node(data);
        node.next = top;
        top = node;
    }

    public Node pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }

        Node node = top;
        top = top.next;
        node.next = null;
        return node;
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }

        return top.data;
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        }

        Node temp = top;
        int count = 0;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }
}
