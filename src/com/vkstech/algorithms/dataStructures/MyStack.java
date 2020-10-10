package com.vkstech.algorithms.dataStructures;

import java.util.Objects;

public class MyStack {

    private Node head;
    private int size = 0;
    private final int MAX_SIZE;

    public MyStack(int max) {
        MAX_SIZE = max;
    }

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public void push(int data) {

        if (size == MAX_SIZE)
            throw new StackOverflowError();

        Node node = new Node(data);

        if (Objects.nonNull(head)) {
            node.next = head;
        }
        head = node;
        size++;
        System.out.println(data + " pushed into stack.");
    }

    public void pop() {
        if (Objects.isNull(head))
            throw new NullPointerException("Stack Underflow");

        Node node = head;
        head = head.next;
        node.next = null;
        size--;
        System.out.println(node.data + " popped fom stack.");
    }

    public void display() {

        if (Objects.isNull(head))
            System.out.println("Stack is Empty");

        Node start = head;
        while (Objects.nonNull(start)) {
            System.out.print(start.data + "\t");
            start = start.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack(5);

        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);

        myStack.display();

        myStack.pop();
        myStack.pop();
        myStack.pop();
        myStack.pop();
        myStack.pop();

        myStack.display();

    }
}
